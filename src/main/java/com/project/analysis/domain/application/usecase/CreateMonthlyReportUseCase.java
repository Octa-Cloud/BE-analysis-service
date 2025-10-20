package com.project.analysis.domain.application.usecase;

import com.project.analysis.domain.domain.entity.*;
import com.project.analysis.domain.domain.service.AnalyzedSleepLevelService;
import com.project.analysis.domain.domain.service.AnalyzedSoundEventService;
import com.project.analysis.domain.domain.service.PeriodicReportService;
import com.project.analysis.domain.domain.service.SleepSessionService;
import com.project.analysis.domain.infra.client.CreatePeriodicReportClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateMonthlyReportUseCase {

    private final PeriodicReportService periodicReportService;
    private final SleepSessionService sleepSessionService;
    private final AnalyzedSoundEventService analyzedSoundEventService;
    private final AnalyzedSleepLevelService analyzedSleepLevelService;
    private final CreatePeriodicReportClient createPeriodicReportClient;

    public void execute(Long userNo, LocalDate date) {
        PeriodicReport periodicReport = periodicReportService.findByUserNoAndStartedAt(userNo, date, DurationType.MONTHLY)
                .orElse(
                        PeriodicReport.builder()
                                .userNo(userNo)
                                .periodStartedAt(date.with(TemporalAdjusters.firstDayOfMonth()))
                                .durationType(DurationType.MONTHLY)
                                .build()
                );

        SleepSession sleepSession = sleepSessionService.findByUserNo(userNo, date);
        List<AnalyzedSleepLevel> analyzedSleepLevels = analyzedSleepLevelService.findAll(sleepSession);
        List<AnalyzedSoundEvent> analyzedSoundEvents = analyzedSoundEventService.findAll(sleepSession);

        PeriodicReport request = createPeriodicReportClient.request(periodicReport, analyzedSleepLevels, analyzedSoundEvents);

        periodicReportService.save(request);
    }
}
