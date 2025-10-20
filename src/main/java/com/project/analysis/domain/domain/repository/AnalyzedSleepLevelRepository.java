package com.project.analysis.domain.domain.repository;

import com.project.analysis.domain.domain.entity.AnalyzedSleepLevel;
import com.project.analysis.domain.domain.entity.SleepSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnalyzedSleepLevelRepository extends JpaRepository<AnalyzedSleepLevel, Long> {
    List<AnalyzedSleepLevel> findAllBySleepSession(SleepSession sleepSession);
}
