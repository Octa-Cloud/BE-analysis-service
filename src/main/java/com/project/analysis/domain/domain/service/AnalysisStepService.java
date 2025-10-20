package com.project.analysis.domain.domain.service;

import com.project.analysis.domain.domain.entity.AnalysisStep;
import com.project.analysis.domain.domain.repository.AnalysisStepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalysisStepService {

    private final AnalysisStepRepository analysisStepRepository;

    public void save(AnalysisStep analysisStep) {
        analysisStepRepository.save(analysisStep);
    }
}
