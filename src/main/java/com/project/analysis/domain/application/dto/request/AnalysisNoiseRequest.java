package com.project.analysis.domain.application.dto.request;

import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record AnalysisNoiseRequest(
        Long userNo,
        MultipartFile noise
) {}
