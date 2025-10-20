package com.project.analysis.domain.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record AiAnalysisModelResponse(
        @JsonProperty("status")
        String status,
        
        @JsonProperty("user_no")
        Integer userNo,
        
        @JsonProperty("sleep_session_no")
        Integer sleepSessionNo,
        
        @JsonProperty("sleep_time_details_json")
        Object sleepTimeDetailsJson,
        
        @JsonProperty("daily_reports_json")
        Object dailyReportsJson,
        
        @JsonProperty("analysis_details_json")
        Object analysisDetailsJson,
        
        @JsonProperty("analysis_steps_array")
        List<Object> analysisStepsArray
) {}
