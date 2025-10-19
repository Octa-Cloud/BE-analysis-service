package com.project.analysis.domain.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "analysis_details",
       indexes = {
           @Index(name = "idx_analysis_details_sleep_session_no", columnList = "sleep_session_no")
       })
public class AnalysisDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analysis_detail_no")
    private Long analysisDetailNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sleep_session_no", referencedColumnName = "sleep_session_no", nullable = false)
    private DailyReport dailyReport;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty", nullable = false, length = 10)
    private Difficulty difficulty;

    @Enumerated(EnumType.STRING)
    @Column(name = "effect", nullable = false, length = 10)
    private Effect effect;
}
