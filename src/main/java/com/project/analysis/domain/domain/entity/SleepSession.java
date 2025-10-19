package com.project.analysis.domain.domain.entity;

import com.project.analysis.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sleep_sessions",
       indexes = {
           @Index(name = "idx_sleep_sessions_user_no", columnList = "user_no"),
           @Index(name = "idx_sleep_sessions_created_at", columnList = "created_at")
       })
public class SleepSession extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sleep_session_no")
    private Long sleepSessionNo;

    @Column(name = "user_no", nullable = false)
    private Long userNo;

    @Column(name = "finished_at")
    private LocalDateTime finishedAt;

    @Column(name = "sleep_date")
    private LocalDate sleepDate;

    public void end() {
        this.finishedAt = LocalDateTime.now();
    }
}
