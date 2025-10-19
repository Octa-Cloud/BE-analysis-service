package com.project.analysis.domain.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "periodic_reports",
       indexes = {
           @Index(name = "idx_periodic_reports_user_no", columnList = "user_no"),
           @Index(name = "idx_periodic_reports_period_started_at", columnList = "period_started_at")
       })
public class PeriodicReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "periodic_report_no")
    private Long periodicReportNo;

    @Column(name = "user_no", nullable = false)
    private Long userNo;

    @Column(name = "sleep_session_count", nullable = false)
    private Integer sleepSessionCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "duration_type", nullable = false, length = 10)
    private DurationType durationType;

    @Column(name = "period_started_at", nullable = false)
    private LocalDate periodStartedAt;

    @Column(name = "total_score", nullable = false)
    private Integer totalScore;

    @Column(name = "total_sleep_time", nullable = false)
    private Integer totalSleepTime;

    @Column(name = "total_bed_time_minutes", nullable = false)
    private Integer totalBedTimeMinutes;

    @Column(name = "total_deep_sleep_time_minutes", nullable = false)
    private Integer totalDeepSleepTimeMinutes;

    @Column(name = "total_light_sleep_time_minutes", nullable = false)
    private Integer totalLightSleepTimeMinutes;

    @Column(name = "total_rem_sleep_time_minutes", nullable = false)
    private Integer totalRemSleepTimeMinutes;

    @Column(name = "improvement", length = 500)
    private String improvement;

    @Column(name = "weakness", length = 500)
    private String weakness;

    @Column(name = "recommendation", length = 500)
    private String recommendation;

    @Column(name = "score_prediction_description", length = 500)
    private String scorePredictionDescription;
}
