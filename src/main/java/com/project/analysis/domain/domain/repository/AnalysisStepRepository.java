package com.project.analysis.domain.domain.repository;

import com.project.analysis.domain.domain.entity.AnalysisStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisStepRepository extends JpaRepository<AnalysisStep, Long> {
}
