package com.project.analysis.domain.infra.kafka.producer;

import com.project.analysis.domain.application.dto.request.AnalysisNoiseRequest;
import com.project.analysis.domain.domain.entity.AnalyzedSoundEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnalyzedSoundEventProducer {

    private final KafkaTemplate<String, Object> jsonKafkaTemplate;
    
    private static final String TOPIC_NAME = "analyzed-sound-event-topic";

    public void sendSoundEventAnalysisMessage(Long userNo, MultipartFile noise) {
        try {
            jsonKafkaTemplate.send(TOPIC_NAME, AnalysisNoiseRequest.builder()
                            .userNo(userNo)
                            .noise(noise)
                            .build()
                    )
                    .whenComplete((result, ex) -> {
                        if (ex == null) {
                            log.info("Successfully sent analyzed sound event message to Kafka. Offset: {}",
                                    result.getRecordMetadata().offset());
                        } else {
                            log.error("Failed to send analyzed sound event message to Kafka", ex);
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException("Failed to send analyzed sound event message", e);
        }
    }
}
