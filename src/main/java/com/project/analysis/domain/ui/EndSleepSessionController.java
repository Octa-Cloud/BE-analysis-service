package com.project.analysis.domain.ui;

import com.project.analysis.domain.application.usecase.EndSleepSessionUseCase;
import com.project.analysis.domain.ui.spec.EndSleepSessionApiSpec;
import com.project.analysis.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EndSleepSessionController implements EndSleepSessionApiSpec {

    private final EndSleepSessionUseCase endSleepSessionUseCase;

    @Override
    public BaseResponse<Void> end(Long userNo) {
        endSleepSessionUseCase.execute(userNo);
        return BaseResponse.onSuccess();
    }
}
