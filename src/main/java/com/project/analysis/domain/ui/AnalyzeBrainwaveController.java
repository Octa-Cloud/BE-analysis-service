package com.project.analysis.domain.ui;

import com.project.analysis.domain.application.usecase.AnalyzeBrainwaveUseCase;
import com.project.analysis.domain.ui.spec.AnalyzeBrainwaveApiSpec;
import com.project.analysis.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class AnalyzeBrainwaveController implements AnalyzeBrainwaveApiSpec {

    private final AnalyzeBrainwaveUseCase analyzeBrainwaveUseCase;

    @Override
    public BaseResponse<Void> analyze(Long userNo, MultipartFile microwave) {
        analyzeBrainwaveUseCase.execute(userNo, microwave);
        return BaseResponse.onSuccess();
    }
}
