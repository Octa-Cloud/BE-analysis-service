package com.project.analysis.domain.domain.repository;

import com.project.analysis.domain.domain.entity.DurationType;
import com.project.analysis.domain.domain.entity.PeriodicReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PeriodicReportRepository extends JpaRepository<PeriodicReport, Long> {
    Optional<PeriodicReport> findByUserNoAndPeriodStartedAtAndDurationType(Long userNo, LocalDate periodStartedAt, DurationType durationType);
}
