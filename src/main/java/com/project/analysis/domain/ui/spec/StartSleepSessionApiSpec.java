package com.project.analysis.domain.ui.spec;

import com.project.analysis.global.annotation.CurrentUser;
import com.project.analysis.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Analysis")
public interface StartSleepSessionApiSpec {

    @Operation(
            summary = "수면 시작 API"
    )
    @PostMapping("/api/analysis/session")
    BaseResponse<Void> start(
            @CurrentUser Long userNo
    );
}
