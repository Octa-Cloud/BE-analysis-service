package com.project.analysis.domain.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "analyzed_sleep_levels",
       uniqueConstraints = {
           @UniqueConstraint(name = "uq_analyzed_sleep_levels_session_time", columnNames = {"sleep_session_no", "recorded_at"})
       },
       indexes = {
           @Index(name = "idx_analyzed_sleep_levels_sleep_session_no", columnList = "sleep_session_no"),
           @Index(name = "idx_analyzed_sleep_levels_recorded_at", columnList = "recorded_at")
       })
public class AnalyzedSleepLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analyzed_sleep_level_no")
    private Long analyzedSleepLevelNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sleep_session_no")
    private SleepSession sleepSession;

    @Min(0)
    @Max(6)
    @Column(name = "level")
    private Integer level;

    @Column(name = "recorded_at", nullable = false)
    private LocalDateTime recordedAt;
}
