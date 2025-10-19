package com.project.analysis.domain.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "daily_reports",
       indexes = {
           @Index(name = "idx_daily_reports_user_no", columnList = "user_no")
       })
public class DailyReport {

    @Id
    @Column(name = "sleep_session_no")
    private Long sleepSessionNo;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sleep_session_no", referencedColumnName = "sleep_session_no")
    private SleepSession sleepSession;

    @Column(name = "memo", length = 255)
    private String memo;

    @Column(name = "user_no", nullable = false)
    private Long userNo;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
