package com.project.analysis.domain.application.usecase;

import com.project.analysis.domain.domain.entity.SleepSession;
import com.project.analysis.domain.domain.service.SleepSessionService;
import com.project.analysis.global.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static com.project.analysis.global.exception.code.status.GlobalErrorStatus.ALREADY_SLEPT;

@Service
@Transactional
@RequiredArgsConstructor
public class EndSleepSessionUseCase {

    private final SleepSessionService sleepSessionService;

    public void execute(Long userNo) {
        SleepSession sleepSession = sleepSessionService.findByUserNo(userNo, LocalDate.now());
        sleepSession.end();
    }
}
