package com.project.analysis.domain.ui;

import com.project.analysis.domain.application.usecase.CreateWeeklyReportUseCase;
import com.project.analysis.domain.ui.spec.CreateWeeklyReportApiSpec;
import com.project.analysis.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class CreateWeeklyReportController implements CreateWeeklyReportApiSpec {

    private final CreateWeeklyReportUseCase createWeeklyReportUseCase;

    @Override
    public BaseResponse<Void> analyze(Long userNo, LocalDate date) {
        createWeeklyReportUseCase.execute(userNo, date);
        return BaseResponse.onSuccess();
    }
}
