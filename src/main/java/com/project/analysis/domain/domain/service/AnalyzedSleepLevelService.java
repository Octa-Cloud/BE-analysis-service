package com.project.analysis.domain.domain.service;

import com.project.analysis.domain.domain.entity.AnalyzedSleepLevel;
import com.project.analysis.domain.domain.entity.SleepSession;
import com.project.analysis.domain.domain.repository.AnalyzedSleepLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyzedSleepLevelService {

    private final AnalyzedSleepLevelRepository analyzedSleepLevelRepository;

    public List<AnalyzedSleepLevel> findAll(SleepSession sleepSession) {
        return analyzedSleepLevelRepository.findAllBySleepSession(sleepSession);
    }

    public void save(AnalyzedSleepLevel analyzedSleepLevel) {
        analyzedSleepLevelRepository.save(analyzedSleepLevel);
    }
}
