package com.project.analysis.domain.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AnalyzeNoiseUseCase {

    public void execute(Long userNo, MultipartFile noise) {

    }
}
