package com.project.analysis.domain.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sleep_time_details")
public class SleepTimeDetail {

    @Id
    @Column(name = "sleep_session_no")
    private Long sleepSessionNo;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sleep_session_no", referencedColumnName = "sleep_session_no")
    private DailyReport dailyReport;

    @Column(name = "deep_sleep_minutes", nullable = false)
    private Integer deepSleepMinutes;

    @Column(name = "light_sleep_minutes", nullable = false)
    private Integer lightSleepMinutes;

    @Column(name = "rem_sleep_minutes", nullable = false)
    private Integer remSleepMinutes;

    @Column(name = "deep_sleep_ratio", nullable = false, precision = 4, scale = 1)
    private BigDecimal deepSleepRatio;

    @Column(name = "light_sleep_ratio", nullable = false, precision = 4, scale = 1)
    private BigDecimal lightSleepRatio;

    @Column(name = "rem_sleep_ratio", nullable = false, precision = 4, scale = 1)
    private BigDecimal remSleepRatio;
}
