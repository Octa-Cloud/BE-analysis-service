package com.project.analysis.domain.domain.repository;

import com.project.analysis.domain.domain.entity.AnalyzedSoundEvent;
import com.project.analysis.domain.domain.entity.SleepSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnalyzedSoundEventRepository extends JpaRepository<AnalyzedSoundEvent, Long> {
    List<AnalyzedSoundEvent> findAllBySleepSession(SleepSession sleepSession);
}
