package com.project.analysis.domain.application.usecase;

import com.project.analysis.domain.application.dto.response.CreateDailyReportResponse;
import com.project.analysis.domain.domain.entity.*;
import com.project.analysis.domain.domain.service.*;
import com.project.analysis.domain.infra.client.CreateDailyReportClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateDailyReportUseCase {

    private final SleepSessionService sleepSessionService;
    private final AnalyzedSleepLevelService analyzedSleepLevelService;
    private final AnalyzedSoundEventService analyzedSoundEventService;
    private final CreateDailyReportClient createDailyReportClient;
    private final AnalysisDetailService analysisDetailService;
    private final DailyReportService dailyReportService;
    private final AnalysisStepService analysisStepService;

    public void execute(Long userNo, LocalDate date) {
        SleepSession sleepSession = sleepSessionService.findByUserNo(userNo, date);
        List<AnalyzedSleepLevel> analyzedSleepLevels = analyzedSleepLevelService.findAll(sleepSession);
        List<AnalyzedSoundEvent> analyzedSoundEvents = analyzedSoundEventService.findAll(sleepSession);
        DailyReport dailyReport = dailyReportService.findBySleepSession(sleepSession);

        CreateDailyReportResponse response = createDailyReportClient.request(analyzedSleepLevels, analyzedSoundEvents);

        AnalysisDetail analysisDetail = response.analysisDetail();
        analysisDetail.updateDailyReport(dailyReport);
        analysisDetailService.save(analysisDetail);

        for (AnalysisStep analysisStep : response.analysisStep()) {
            analysisStep.updateAnalysisDetail(analysisDetail);
            analysisStepService.save(analysisStep);
        }

        SleepTimeDetail sleepTimeDetail = response.sleepTimeDetail();
        sleepTimeDetail.updateDailyReport(dailyReport);
    }
}
