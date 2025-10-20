package com.project.analysis.domain.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.analysis.domain.domain.entity.AnalyzedSleepLevel;
import com.project.analysis.domain.domain.entity.AnalyzedSoundEvent;
import lombok.Builder;

import java.util.List;

@Builder
public record SleepAnalysisRequest(
        List<AnalyzedSleepLevel> analyzedSleepLevels,
        List<AnalyzedSoundEvent> analyzedSoundEvents
) {}
