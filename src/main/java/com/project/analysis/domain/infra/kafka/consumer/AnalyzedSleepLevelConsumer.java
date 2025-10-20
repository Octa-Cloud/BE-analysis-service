package com.project.analysis.domain.infra.kafka.consumer;

import com.project.analysis.domain.domain.entity.AnalyzedSleepLevel;
import com.project.analysis.domain.domain.service.AnalyzedSleepLevelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnalyzedSleepLevelConsumer {

    private final AnalyzedSleepLevelService analyzedSleepLevelService;

    @KafkaListener(
            topics = "analyzed-sleep-level-topic",
            groupId = "analysis-service-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeAnalyzedSleepLevel(
            @Payload AnalyzedSleepLevel analyzedSleepLevel
    ) {
        try {
             analyzedSleepLevelService.save(analyzedSleepLevel);
        } catch (Exception e) {
            throw new RuntimeException("Failed to process AnalyzedSleepLevel", e);
        }
    }
}
