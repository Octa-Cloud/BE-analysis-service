package com.project.analysis.domain.domain.repository;

import com.project.analysis.domain.domain.entity.DailyReport;
import com.project.analysis.domain.domain.entity.SleepSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {
    Optional<DailyReport> findBySleepSession(SleepSession sleepSession);
}
