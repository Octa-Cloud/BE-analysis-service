package com.project.analysis.domain.infra.kafka.producer;

import com.project.analysis.domain.application.dto.request.AnalysisBrainwaveRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnalysisBrainwaveProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    
    private static final String TOPIC_NAME = "analysis-brainwave-topic";

    public void sendBrainwaveAnalysisMessage(Long userNo, MultipartFile microwave) {
        try {
            kafkaTemplate.send(TOPIC_NAME,
                            AnalysisBrainwaveRequest.builder()
                                    .userNo(userNo)
                                    .microwave(microwave)
                                    .build()
                    )
                    .whenComplete((result, ex) -> {
                        if (ex == null) {
                            log.info("Successfully sent brainwave analysis message to Kafka. Offset: {}", 
                                    result.getRecordMetadata().offset());
                        } else {
                            log.error("Failed to send brainwave analysis message to Kafka", ex);
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException("Failed to send brainwave analysis message", e);
        }
    }
}
