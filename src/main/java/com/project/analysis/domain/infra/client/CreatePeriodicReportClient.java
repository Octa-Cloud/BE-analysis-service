package com.project.analysis.domain.infra.client;

import com.project.analysis.domain.application.dto.request.CreateWeeklyReportRequest;
import com.project.analysis.domain.application.dto.request.SleepAnalysisRequest;
import com.project.analysis.domain.application.dto.response.CreateDailyReportResponse;
import com.project.analysis.domain.domain.entity.AnalyzedSleepLevel;
import com.project.analysis.domain.domain.entity.AnalyzedSoundEvent;
import com.project.analysis.domain.domain.entity.PeriodicReport;
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
public class CreatePeriodicReportClient {

    private final RestClient aiAnalysisModelRestClient;

    public PeriodicReport request(PeriodicReport periodicReport, List<AnalyzedSleepLevel> analyzedSleepLevels, List<AnalyzedSoundEvent> analyzedSoundEvents) {
        return aiAnalysisModelRestClient
                    .post()
                    .uri("/analyze/periodic_report/json")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                            CreateWeeklyReportRequest.builder()
                                    .periodicReport(periodicReport)
                                    .analyzedSleepLevels(analyzedSleepLevels)
                                    .analyzedSoundEvents(analyzedSoundEvents)
                            .build()
                    )
                    .retrieve()
                    .onStatus(HttpStatusCode::isError, (req, res) -> {
                        log.error("AI analysis model returned error: {}", res.getStatusCode());
                        throw new RestClientException("AI analysis model error: " + res.getStatusCode());
                    })
                    .body(PeriodicReport.class);
    }
}
