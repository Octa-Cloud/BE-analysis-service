package com.project.analysis.domain.ui.spec;

import com.project.analysis.global.annotation.CurrentUser;
import com.project.analysis.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Tag(name = "Analysis")
public interface CreateMonthlyReportApiSpec {

    @Operation(
            summary = "월간 레포트 생성 API"
    )
    @PostMapping(value = "/api/analysis/reports/monthly")
    BaseResponse<Void> analyze(
            @CurrentUser Long userNo,
            @RequestParam LocalDate date
    );
}
