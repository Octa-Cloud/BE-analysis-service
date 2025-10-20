package com.project.analysis.domain.application.usecase;

import com.project.analysis.domain.infra.kafka.producer.AnalyzedSoundEventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AnalyzeNoiseUseCase {

    private final AnalyzedSoundEventProducer analyzedSoundEventProducer;

    public void execute(Long userNo, MultipartFile noise) {
        analyzedSoundEventProducer.sendSoundEventAnalysisMessage(userNo, noise);
    }
}
