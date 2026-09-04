package com.crowdpulse.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "community_updates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long placeId;

    private Integer reportedQueueLength;

    private Integer throughputPerMin;

    private String queueStatus;

    @Column(columnDefinition = "TEXT")
    private String note;

    public Long getPlaceId() {
        return placeId;
    }

    public Integer getReportedQueueLength() {
        return reportedQueueLength;
    }

    public Integer getThroughputPerMin() {
        return throughputPerMin;
    }

    public String getQueueStatus() {
        return queueStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    private LocalDateTime createdAt;
}