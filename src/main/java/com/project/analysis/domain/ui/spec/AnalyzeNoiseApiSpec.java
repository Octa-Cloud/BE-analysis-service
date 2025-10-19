package com.project.analysis.domain.ui.spec;

import com.project.analysis.global.annotation.CurrentUser;
import com.project.analysis.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Tag(name = "Analysis")
public interface AnalyzeNoiseApiSpec {

    @Operation(
            summary = "소음 분석 API"
    )
    @PostMapping(value = "/api/analysis/noise", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    BaseResponse<Void> analyze(
            @CurrentUser Long userNo,
            @RequestParam("file") MultipartFile microwave
    );
}
