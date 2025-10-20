package com.project.analysis.domain.application.usecase;

import com.project.analysis.domain.domain.service.AnalyzedSleepLevelService;
import com.project.analysis.domain.infra.kafka.producer.AnalysisBrainwaveProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AnalyzeBrainwaveUseCase {

    private final AnalysisBrainwaveProducer analysisBrainwaveProducer;

    public void execute(Long userNo, MultipartFile microwave) {
        analysisBrainwaveProducer.sendBrainwaveAnalysisMessage(userNo, microwave);
    }
}
