package com.project.analysis.domain.ui;

import com.project.analysis.domain.application.usecase.CreateMonthlyReportUseCase;
import com.project.analysis.domain.ui.spec.CreateMonthlyReportApiSpec;
import com.project.analysis.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class CreateMonthlyReportController implements CreateMonthlyReportApiSpec {

    private final CreateMonthlyReportUseCase createMonthlyReportUseCase;

    @Override
    public BaseResponse<Void> analyze(Long userNo, LocalDate date) {
        createMonthlyReportUseCase.execute(userNo, date);
        return BaseResponse.onSuccess();
    }
}
