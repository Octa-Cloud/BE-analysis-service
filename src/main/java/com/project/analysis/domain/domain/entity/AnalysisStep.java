package com.project.analysis.domain.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "analysis_steps",
       indexes = {
           @Index(name = "idx_analysis_steps_analysis_detail_no", columnList = "analysis_detail_no")
       })
public class AnalysisStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analysis_step_no")
    private Long analysisStepNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "analysis_detail_no", nullable = false)
    private AnalysisDetail analysisDetail;

    @Column(name = "step_index", nullable = false)
    private Integer stepIndex;

    @Column(name = "content", nullable = false, length = 255)
    private String content;

    public void updateAnalysisDetail(AnalysisDetail analysisDetail) {
        this.analysisDetail = analysisDetail;
    }
}
