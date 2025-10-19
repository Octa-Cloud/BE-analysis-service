package com.project.analysis.domain.domain.service;

import com.project.analysis.domain.domain.entity.SleepSession;
import com.project.analysis.domain.domain.repository.SleepSessionRepository;
import com.project.analysis.global.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.project.analysis.global.exception.code.status.GlobalErrorStatus._NOT_FOUND;

@Service
@RequiredArgsConstructor
public class SleepSessionService {

    private final SleepSessionRepository sleepSessionRepository;

    public boolean isExists(Long userNo, LocalDate now) {
        return sleepSessionRepository.existsByUserNoAndSleepDate(userNo, now);
    }

    public void save(SleepSession sleepSession) {
        sleepSessionRepository.save(sleepSession);
    }

    public SleepSession findByUserNo(Long userNo, LocalDate now) {
        return sleepSessionRepository.findByUserNoAndSleepDate(userNo, now)
                .orElseThrow(() -> new RestApiException(_NOT_FOUND));
    }
}
