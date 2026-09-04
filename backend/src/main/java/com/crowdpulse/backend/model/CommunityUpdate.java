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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPlaceId() { return placeId; }
    public void setPlaceId(Long placeId) { this.placeId = placeId; }

    public Integer getReportedQueueLength() { return reportedQueueLength; }
    public void setReportedQueueLength(Integer reportedQueueLength) { this.reportedQueueLength = reportedQueueLength; }

    public Integer getThroughputPerMin() { return throughputPerMin; }
    public void setThroughputPerMin(Integer throughputPerMin) { this.throughputPerMin = throughputPerMin; }

    public String getQueueStatus() { return queueStatus; }
    public void setQueueStatus(String queueStatus) { this.queueStatus = queueStatus; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    private LocalDateTime createdAt;
}