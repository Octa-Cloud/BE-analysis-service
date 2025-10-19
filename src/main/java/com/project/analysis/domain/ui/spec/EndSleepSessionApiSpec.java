package com.project.analysis.domain.ui.spec;

import com.project.analysis.global.annotation.CurrentUser;
import com.project.analysis.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PatchMapping;

@Tag(name = "Analysis")
public interface EndSleepSessionApiSpec {

    @Operation(
            summary = "수면 종료 API"
    )
    @PatchMapping("/api/analysis/session")
    BaseResponse<Void> end(
            @CurrentUser Long userNo
    );
}
