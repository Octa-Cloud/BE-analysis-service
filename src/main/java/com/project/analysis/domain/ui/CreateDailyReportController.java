package com.project.analysis.domain.ui;

import com.project.analysis.domain.application.usecase.CreateDailyReportUseCase;
import com.project.analysis.domain.ui.spec.CreateDailyReportApiSpec;
import com.project.analysis.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class CreateDailyReportController implements CreateDailyReportApiSpec {

    private final CreateDailyReportUseCase createDailyReportUseCase;

    @Override
    public BaseResponse<Void> analyze(Long userNo, LocalDate date) {
        createDailyReportUseCase.execute(userNo, date);
        return BaseResponse.onSuccess();
    }
}
