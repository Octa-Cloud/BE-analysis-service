package com.project.analysis.domain.domain.service;

import com.project.analysis.domain.domain.entity.AnalyzedSoundEvent;
import com.project.analysis.domain.domain.entity.SleepSession;
import com.project.analysis.domain.domain.repository.AnalyzedSoundEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyzedSoundEventService {

    private final AnalyzedSoundEventRepository analyzedSoundEventRepository;

    public List<AnalyzedSoundEvent> findAll(SleepSession sleepSession) {
        return analyzedSoundEventRepository.findAllBySleepSession(sleepSession);
    }

    public void save(AnalyzedSoundEvent analyzedSoundEvent) {
        analyzedSoundEventRepository.save(analyzedSoundEvent);
    }
}
