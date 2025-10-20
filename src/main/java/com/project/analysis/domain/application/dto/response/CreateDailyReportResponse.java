package com.project.analysis.domain.application.dto.response;

import com.project.analysis.domain.domain.entity.AnalysisDetail;
import com.project.analysis.domain.domain.entity.AnalysisStep;
import com.project.analysis.domain.domain.entity.SleepTimeDetail;

import java.util.List;

public record CreateDailyReportResponse(
        AnalysisDetail analysisDetail,
        List<AnalysisStep> analysisStep,
        SleepTimeDetail sleepTimeDetail
) {}
