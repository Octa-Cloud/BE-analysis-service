package com.project.analysis.domain.domain.service;

import com.project.analysis.domain.domain.entity.DailyReport;
import com.project.analysis.domain.domain.entity.SleepSession;
import com.project.analysis.domain.domain.repository.DailyReportRepository;
import com.project.analysis.global.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.project.analysis.global.exception.code.status.GlobalErrorStatus._NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DailyReportService {

    private final DailyReportRepository dailyReportRepository;

    public DailyReport findBySleepSession(SleepSession sleepSession) {
        return dailyReportRepository.findBySleepSession(sleepSession)
                .orElseThrow(() -> new RestApiException(_NOT_FOUND));
    }
}
