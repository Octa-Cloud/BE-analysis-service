package com.project.analysis.domain.infra.kafka.consumer;

import com.project.analysis.domain.domain.entity.AnalyzedSoundEvent;
import com.project.analysis.domain.domain.service.AnalyzedSoundEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnalyzedSoundEventConsumer {

    private final AnalyzedSoundEventService analyzedSoundEventService;

    @KafkaListener(
            topics = "analyzed-sound-event-topic",
            groupId = "analysis-service-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeAnalyzedSoundEvent(
            @Payload AnalyzedSoundEvent analyzedSoundEvent
    ) {
        try {
            analyzedSoundEventService.save(analyzedSoundEvent);
        } catch (Exception e) {
            throw new RuntimeException("Failed to process AnalyzedSoundEvent", e);
        }
    }
}
