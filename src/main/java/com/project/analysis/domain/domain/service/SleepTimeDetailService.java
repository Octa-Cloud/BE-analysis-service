package com.project.analysis.domain.domain.service;

import com.project.analysis.domain.domain.entity.SleepTimeDetail;
import com.project.analysis.domain.domain.repository.SleepTimeDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SleepTimeDetailService {

    private final SleepTimeDetailRepository sleepTimeDetailRepository;

    public void save(SleepTimeDetail sleepTimeDetail) {
        sleepTimeDetailRepository.save(sleepTimeDetail);
    }
}
