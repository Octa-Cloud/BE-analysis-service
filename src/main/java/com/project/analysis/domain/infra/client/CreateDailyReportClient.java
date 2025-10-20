package com.project.analysis.domain.infra.client;

import com.project.analysis.domain.application.dto.response.CreateDailyReportResponse;
import com.project.analysis.domain.domain.entity.AnalyzedSleepLevel;
import com.project.analysis.domain.domain.entity.AnalyzedSoundEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateDailyReportClient {

    public CreateDailyReportResponse request(List<AnalyzedSleepLevel> analyzedSleepLevels, List<AnalyzedSoundEvent> analyzedSoundEvents) {

    }
}
