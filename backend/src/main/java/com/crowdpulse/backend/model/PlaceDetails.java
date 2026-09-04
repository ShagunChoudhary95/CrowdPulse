package com.crowdpulse.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonRawValue;

@Entity
@Table(name = "place_details")
@Data
public class PlaceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 RELATION
    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;

    private String description;

    private String significance;

    private String bestTime;

    @JsonRawValue
    @Column(columnDefinition = "json")
    private String peakMonths;

    @JsonRawValue
    @Column(columnDefinition = "json")
    private String offPeakMonths;

    @JsonRawValue
    @Column(columnDefinition = "json")
    private String dailyTimings;

    @JsonRawValue
    @Column(columnDefinition = "json")
    private String rituals;

    @JsonRawValue
    @Column(columnDefinition = "json")
    private String reachInfo;

    @JsonRawValue
    @Column(columnDefinition = "json")
    private String images;

    @JsonRawValue
    @Column(columnDefinition = "json")
    private String tags;

    private Integer avgDailyFootfall;

    private Double festivalRushMultiplier;

    @JsonRawValue
    @Column(columnDefinition = "json")
    private String queueConfig;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Place getPlace() { return place; }
    public void setPlace(Place place) { this.place = place; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSignificance() { return significance; }
    public void setSignificance(String significance) { this.significance = significance; }

    public String getBestTime() { return bestTime; }
    public void setBestTime(String bestTime) { this.bestTime = bestTime; }

    public String getPeakMonths() { return peakMonths; }
    public void setPeakMonths(String peakMonths) { this.peakMonths = peakMonths; }

    public String getOffPeakMonths() { return offPeakMonths; }
    public void setOffPeakMonths(String offPeakMonths) { this.offPeakMonths = offPeakMonths; }

    public String getDailyTimings() { return dailyTimings; }
    public void setDailyTimings(String dailyTimings) { this.dailyTimings = dailyTimings; }

    public String getRituals() { return rituals; }
    public void setRituals(String rituals) { this.rituals = rituals; }

    public String getReachInfo() { return reachInfo; }
    public void setReachInfo(String reachInfo) { this.reachInfo = reachInfo; }

    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }

    public Integer getAvgDailyFootfall() { return avgDailyFootfall; }
    public void setAvgDailyFootfall(Integer avgDailyFootfall) { this.avgDailyFootfall = avgDailyFootfall; }

    public Double getFestivalRushMultiplier() { return festivalRushMultiplier; }
    public void setFestivalRushMultiplier(Double festivalRushMultiplier) { this.festivalRushMultiplier = festivalRushMultiplier; }

    public String getQueueConfig() { return queueConfig; }
    public void setQueueConfig(String queueConfig) { this.queueConfig = queueConfig; }
}