package com.project.analysis.domain.application.dto.request;

import com.project.analysis.domain.domain.entity.AnalyzedSleepLevel;
import com.project.analysis.domain.domain.entity.AnalyzedSoundEvent;
import com.project.analysis.domain.domain.entity.PeriodicReport;
import lombok.Builder;

import java.util.List;

@Builder
public record CreateWeeklyReportRequest (
        PeriodicReport periodicReport,
        List<AnalyzedSleepLevel> analyzedSleepLevels,
        List<AnalyzedSoundEvent> analyzedSoundEvents
) {}
