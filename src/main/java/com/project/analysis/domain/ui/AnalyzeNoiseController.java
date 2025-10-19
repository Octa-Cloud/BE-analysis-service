package com.project.analysis.domain.ui;

import com.project.analysis.domain.application.usecase.AnalyzeNoiseUseCase;
import com.project.analysis.domain.ui.spec.AnalyzeNoiseApiSpec;
import com.project.analysis.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class AnalyzeNoiseController implements AnalyzeNoiseApiSpec {

    private final AnalyzeNoiseUseCase analyzeNoiseUseCase;

    @Override
    public BaseResponse<Void> analyze(Long userNo, MultipartFile noise) {
        analyzeNoiseUseCase.execute(userNo, noise);
        return BaseResponse.onSuccess();
    }
}
