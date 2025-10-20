package com.project.analysis.domain.domain.service;

import com.project.analysis.domain.domain.entity.DurationType;
import com.project.analysis.domain.domain.entity.PeriodicReport;
import com.project.analysis.domain.domain.repository.PeriodicReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeriodicReportService {

    private final PeriodicReportRepository periodicReportRepository;

    public Optional<PeriodicReport> findByUserNoAndStartedAt(Long userNo, LocalDate startedAt, DurationType type) {
        return periodicReportRepository.findByUserNoAndPeriodStartedAtAndDurationType((userNo, startedAt, type);
    }

    public void save(PeriodicReport periodicReport) {
        periodicReportRepository.save(periodicReport);
    }
}
