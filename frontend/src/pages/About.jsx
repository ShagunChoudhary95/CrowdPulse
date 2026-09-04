import Navbar from "../components/Navbar";
import { motion } from "framer-motion";
import { 
  Activity, 
  ShieldCheck, 
  Clock, 
  Users, 
  Zap, 
  MapPin, 
  Radio, 
  HeartHandshake, 
  Sparkles,
  ArrowRight
} from "lucide-react";
import { Link } from "react-router-dom";

export default function About() {
  const pillars = [
    {
      icon: Activity,
      title: "Universal Density Awareness",
      desc: "Calculates real-time crowd congestion and queue movement using non-linear physics modeling, group size distributions, and physical bottlenecks."
    },
    {
      icon: Clock,
      title: "AI Wait-Time Predictions",
      desc: "Dynamic 9-hour forecasting windows that anticipate morning aarti rushes, afternoon lulls, and seasonal festival spikes."
    },
    {
      icon: Users,
      title: "Fair Virtual Queueing",
      desc: "Token-based virtual queues with automatic background heartbeats that free devotees from standing in hours-long physically exhausting lines."
    },
    {
      icon: Radio,
      title: "Operator Ground Intelligence",
      desc: "Empowers local temple administrators and coastal police to report live flow rates, sanctum pauses, and weather advisories instantly."
    }
  ];

  return (
    <div className="min-h-screen bg-[#F8FAFC]">
      <Navbar />

      <main className="max-w-[1400px] mx-auto px-6 md:px-12 py-12 md:py-20">
        {/* Hero */}
        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          className="text-center max-w-3xl mx-auto mb-16 space-y-6"
        >
          <div className="inline-flex items-center gap-2 px-4 py-2 bg-white border border-slate-200 rounded-full shadow-sm text-xs font-semibold text-slate-600">
            <Sparkles className="w-4 h-4 text-[#FF9933]" />
            <span>Empowering Millions of Devotees & Travelers</span>
          </div>

          <h1 className="text-4xl md:text-6xl font-bold text-slate-900 tracking-tight leading-[1.15]">
            Reimagining Sacred Journeys with
            <span className="text-[#FF9933] block mt-1">Operational Intelligence</span>
          </h1>

          <p className="text-slate-500 text-base md:text-lg leading-relaxed">
            CrowdPulse is India's first unified density-awareness platform designed to alleviate stampede risks, minimize waiting misery, and optimize crowd throughput at high-footfall pilgrimage shrines and promenades.
          </p>
        </motion.div>

        {/* 4 Pillars Grid */}
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mb-20">
          {pillars.map(({ icon: Icon, title, desc }, idx) => (
            <motion.div
              key={title}
              initial={{ opacity: 0, y: 20 }}
              animate={{ opacity: 1, y: 0 }}
              transition={{ delay: idx * 0.1 }}
              className="bg-white border border-slate-200 rounded-2xl p-8 hover:border-[#FF9933]/40 hover:shadow-lg transition-all duration-300"
            >
              <div className="w-12 h-12 bg-[#FF9933]/10 border border-[#FF9933]/20 rounded-xl flex items-center justify-center mb-6 text-[#FF9933]">
                <Icon className="w-6 h-6" />
              </div>
              <h3 className="text-xl font-bold text-slate-900 mb-3">{title}</h3>
              <p className="text-slate-500 text-sm md:text-base leading-relaxed">{desc}</p>
            </motion.div>
          ))}
        </div>

        {/* Mission Banner */}
        <motion.div
          initial={{ opacity: 0, scale: 0.98 }}
          animate={{ opacity: 1, scale: 1 }}
          className="relative rounded-3xl overflow-hidden bg-gradient-to-br from-slate-900 via-slate-800 to-slate-950 p-10 md:p-16 text-white text-center shadow-xl mb-12"
        >
          <div className="max-w-2xl mx-auto space-y-6 relative z-10">
            <span className="text-xs font-bold text-[#FF9933] uppercase tracking-widest">Our Vision</span>
            <h2 className="text-3xl md:text-4xl font-bold tracking-tight">
              Dignified, safe, and stress-free access for every pilgrim across India.
            </h2>
            <p className="text-slate-300 text-sm md:text-base leading-relaxed">
              From the high altitudes of Kedarnath to the sacred ghats of Varanasi and the shores of Mumbai, we bridge the gap between ancient heritage and modern distributed cloud technology.
            </p>
            <div className="pt-4 flex justify-center">
              <Link
                to="/"
                className="inline-flex items-center gap-2 px-6 py-3.5 bg-[#FF9933] text-white font-bold rounded-xl text-sm shadow-md hover:bg-[#FF9933]/90 transition-all"
              >
                <span>Explore Live Intelligence</span>
                <ArrowRight className="w-4 h-4" />
              </Link>
            </div>
          </div>
        </motion.div>
      </main>
    </div>
  );
}
