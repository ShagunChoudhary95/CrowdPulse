package com.crowdpulse.backend.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "places")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private PlaceType type;

    private String city;
    private String state;
    private String country;

    private double latitude;
    private double longitude;

    private int radius;
    private int capacity;
    private String queueStatus = "ACTIVE";

    @Column(name = "scaling_factor")
    private double scalingFactor=1.0;

    @Column(name = "admin_offset")
    private Integer adminOffset=0;

    private Integer baseThroughput;

private String peakStart;
private String peakEnd;

private Double peakMultiplier = 1.5;

private Double seasonMultiplier = 1.0;

private Integer maxDailyCapacity;

private Integer concurrentCapacity;

    // Getters and Setters

    public String getQueueStatus() {
    return queueStatus;
}

public void setQueueStatus(String queueStatus) {
    this.queueStatus = queueStatus;
}
    public Integer getBaseThroughput() {
    return baseThroughput;
    }
    public void setBaseThroughput(Integer baseThroughput) {
    this.baseThroughput = baseThroughput;
    }   

    public String getPeakStart() {
    return peakStart;
    }   
    public void setPeakStart(String peakStart) {
    this.peakStart = peakStart;
    }

    public String getPeakEnd() {
    return peakEnd; 
    }
    public void setPeakEnd(String peakEnd) {        
    this.peakEnd = peakEnd;
    }

    public Double getPeakMultiplier() {
    return peakMultiplier;
    }
    public void setPeakMultiplier(Double peakMultiplier) {
    this.peakMultiplier = peakMultiplier;   
    }
    
    public Double getSeasonMultiplier() {
    return seasonMultiplier;
    }
    public void setSeasonMultiplier(Double seasonMultiplier) {
    this.seasonMultiplier = seasonMultiplier;
    }

    public Integer getMaxDailyCapacity() {
    return maxDailyCapacity;    
    }
    public void setMaxDailyCapacity(Integer maxDailyCapacity) { 
    this.maxDailyCapacity = maxDailyCapacity;
    }  

    public Integer getConcurrentCapacity() {
    return concurrentCapacity;
    }
    public void setConcurrentCapacity(Integer concurrentCapacity) {
    this.concurrentCapacity = concurrentCapacity;   
    }


    public int getCapacity() {
    return capacity;
    }
    public void setCapacity(int capacity) {
    this.capacity = capacity;
    }

    public PlaceType getType() {
    return type;
}
public void setType(PlaceType type) {
    this.type = type;
}
        public Double getScalingFactor() {
            return scalingFactor;
        }
        public void setScalingFactor(Double scalingFactor) {
    this.scalingFactor = scalingFactor;
}

public Integer getAdminOffset() {
    return adminOffset;
}
public void setAdminOffset(Integer adminOffset) {
    this.adminOffset = adminOffset;
}



    
    @Column(name = "is_active")
    private boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean isActive) { this.isActive = isActive; }

    @OneToOne(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private PlaceDetails placeDetails;
}