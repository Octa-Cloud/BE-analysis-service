package com.project.analysis.domain.ui;

import com.project.analysis.domain.application.usecase.StartSleepSessionUseCase;
import com.project.analysis.domain.ui.spec.StartSleepSessionApiSpec;
import com.project.analysis.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StartSleepSessionController implements StartSleepSessionApiSpec {

    private final StartSleepSessionUseCase startSleepSessionUseCase;

    @Override
    public BaseResponse<Void> start(
            Long userNo
    ) {
        startSleepSessionUseCase.execute(userNo);
        return BaseResponse.onSuccess();
    }
}
