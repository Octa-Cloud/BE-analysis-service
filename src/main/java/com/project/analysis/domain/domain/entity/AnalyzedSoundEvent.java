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
@Table(name = "analyzed_sound_events",
       indexes = {
           @Index(name = "idx_analyzed_sound_events_sleep_session_no", columnList = "sleep_session_no"),
           @Index(name = "idx_analyzed_sound_events_recorded_at", columnList = "recorded_at")
       })
public class AnalyzedSoundEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analyzed_sound_event_no")
    private Long analyzedSoundEventNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sleep_session_no")
    private SleepSession sleepSession;

    @Enumerated(EnumType.STRING)
    @Column(name = "event", length = 20)
    private SoundEvent event;

    @Column(name = "recorded_at", nullable = false)
    private LocalDateTime recordedAt;
}
