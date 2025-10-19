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
@Table(name = "score_prediction_points",
       indexes = {
           @Index(name = "idx_score_prediction_points_periodic_report_no", columnList = "periodic_report_no")
       })
public class ScorePredictionPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_prediction_point_no")
    private Long scorePredictionPointNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodic_report_no", nullable = false)
    private PeriodicReport periodicReport;

    @Column(name = "date_index", nullable = false)
    private LocalDate dateIndex;

    @Column(name = "score", nullable = false)
    private Integer score;
}
