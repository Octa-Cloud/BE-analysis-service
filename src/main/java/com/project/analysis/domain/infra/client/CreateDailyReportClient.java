package com.project.analysis.domain.infra.client;

import com.project.analysis.domain.application.dto.request.SleepAnalysisRequest;
import com.project.analysis.domain.application.dto.response.AiAnalysisModelResponse;
import com.project.analysis.domain.application.dto.response.CreateDailyReportResponse;
import com.project.analysis.domain.domain.entity.AnalyzedSleepLevel;
import com.project.analysis.domain.domain.entity.AnalyzedSoundEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateDailyReportClient {

    private final RestClient aiAnalysisModelRestClient;

    public CreateDailyReportResponse request(List<AnalyzedSleepLevel> analyzedSleepLevels, List<AnalyzedSoundEvent> analyzedSoundEvents) {
        return aiAnalysisModelRestClient
                    .post()
                    .uri("/analyze/daily_report/json")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(SleepAnalysisRequest.builder()
                            .analyzedSleepLevels(analyzedSleepLevels)
                            .analyzedSoundEvents(analyzedSoundEvents)
                            .build()
                    )
                    .retrieve()
                    .onStatus(HttpStatusCode::isError, (req, res) -> {
                        log.error("AI analysis model returned error: {}", res.getStatusCode());
                        throw new RestClientException("AI analysis model error: " + res.getStatusCode());
                    })
                    .body(CreateDailyReportResponse.class);
    }
}
