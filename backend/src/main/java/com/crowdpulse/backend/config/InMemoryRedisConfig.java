package com.crowdpulse.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Configuration
public class InMemoryRedisConfig {

    @Bean
    @Primary
    public StringRedisTemplate stringRedisTemplate() {
        final Map<String, String> valueStore = new ConcurrentHashMap<>();
        final Map<String, List<String>> listStore = new ConcurrentHashMap<>();
        final Map<String, Long> expiryStore = new ConcurrentHashMap<>();

        return new StringRedisTemplate() {
            @Override
            public void afterPropertiesSet() {
                // In-memory: bypass Redis connection initialization
            }

            @Override
            public Boolean hasKey(String key) {
                Long exp = expiryStore.get(key);
                if (exp != null && System.currentTimeMillis() > exp) {
                    delete(key);
                    return false;
                }
                return valueStore.containsKey(key) || listStore.containsKey(key);
            }

            @Override
            public Boolean delete(String key) {
                valueStore.remove(key);
                listStore.remove(key);
                expiryStore.remove(key);
                return true;
            }

            @Override
            public Long delete(Collection<String> keys) {
                long count = 0;
                for (String k : keys) {
                    if (Boolean.TRUE.equals(delete(k))) count++;
                }
                return count;
            }

            @Override
            public Set<String> keys(String pattern) {
                String regex = pattern.replace(".", "\\.").replace("*", ".*");
                Pattern p = Pattern.compile(regex);
                Set<String> allKeys = new HashSet<>();
                allKeys.addAll(valueStore.keySet());
                allKeys.addAll(listStore.keySet());

                long now = System.currentTimeMillis();
                Set<String> result = new HashSet<>();
                for (String k : allKeys) {
                    Long exp = expiryStore.get(k);
                    if (exp != null && now > exp) {
                        delete(k);
                        continue;
                    }
                    if (p.matcher(k).matches()) {
                        result.add(k);
                    }
                }
                return result;
            }

            @Override
            @SuppressWarnings("unchecked")
            public ValueOperations<String, String> opsForValue() {
                return (ValueOperations<String, String>) Proxy.newProxyInstance(
                    ValueOperations.class.getClassLoader(),
                    new Class<?>[]{ValueOperations.class},
                    (proxy, method, args) -> {
                        String name = method.getName();
                        if ("hashCode".equals(name)) return System.identityHashCode(proxy);
                        if ("equals".equals(name)) return proxy == args[0];
                        if ("toString".equals(name)) return "InMemoryValueOperations";

                        if ("set".equals(name) && args != null && args.length >= 2) {
                            String k = (String) args[0];
                            String v = (String) args[1];
                            valueStore.put(k, v);
                            if (args.length >= 4 && args[2] instanceof Number && args[3] instanceof TimeUnit) {
                                long timeout = ((Number) args[2]).longValue();
                                TimeUnit unit = (TimeUnit) args[3];
                                expiryStore.put(k, System.currentTimeMillis() + unit.toMillis(timeout));
                            } else if (args.length >= 3 && args[2] instanceof java.time.Duration) {
                                java.time.Duration duration = (java.time.Duration) args[2];
                                expiryStore.put(k, System.currentTimeMillis() + duration.toMillis());
                            }
                            return null;
                        } else if ("get".equals(name) && args != null && args.length >= 1) {
                            String k = (String) args[0];
                            Long exp = expiryStore.get(k);
                            if (exp != null && System.currentTimeMillis() > exp) {
                                delete(k);
                                return null;
                            }
                            return valueStore.get(k);
                        }
                        return null;
                    }
                );
            }

            @Override
            @SuppressWarnings("unchecked")
            public ListOperations<String, String> opsForList() {
                return (ListOperations<String, String>) Proxy.newProxyInstance(
                    ListOperations.class.getClassLoader(),
                    new Class<?>[]{ListOperations.class},
                    (proxy, method, args) -> {
                        String name = method.getName();
                        if ("hashCode".equals(name)) return System.identityHashCode(proxy);
                        if ("equals".equals(name)) return proxy == args[0];
                        if ("toString".equals(name)) return "InMemoryListOperations";

                        if (args == null || args.length == 0) return null;
                        String k = (String) args[0];
                        List<String> list = listStore.computeIfAbsent(k, key -> new CopyOnWriteArrayList<>());

                        if ("range".equals(name) && args.length >= 3) {
                            long start = ((Number) args[1]).longValue();
                            long end = ((Number) args[2]).longValue();
                            if (list.isEmpty()) return Collections.emptyList();
                            int s = (int) Math.max(0, start);
                            int e = (end < 0) ? (int) (list.size() + end) : (int) Math.min(list.size() - 1, end);
                            if (s > e || s >= list.size()) return Collections.emptyList();
                            return new ArrayList<>(list.subList(s, e + 1));
                        } else if ("rightPush".equals(name) && args.length >= 2) {
                            String val = (String) args[1];
                            list.add(val);
                            return (long) list.size();
                        } else if ("remove".equals(name) && args.length >= 3) {
                            long count = ((Number) args[1]).longValue();
                            Object val = args[2];
                            int removed = 0;
                            for (String item : new ArrayList<>(list)) {
                                if (Objects.equals(item, val)) {
                                    list.remove(item);
                                    removed++;
                                    if (count > 0 && removed >= count) break;
                                }
                            }
                            return (long) removed;
                        } else if ("size".equals(name)) {
                            return (long) list.size();
                        }
                        return null;
                    }
                );
            }
        };
    }
}

