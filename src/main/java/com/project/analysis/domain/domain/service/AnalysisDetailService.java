package com.project.analysis.domain.domain.service;

import com.project.analysis.domain.domain.entity.AnalysisDetail;
import com.project.analysis.domain.domain.repository.AnalysisDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalysisDetailService {

    private final AnalysisDetailRepository analysisDetailRepository;

    public void save(AnalysisDetail entity) {
        analysisDetailRepository.save(entity);
    }
}
