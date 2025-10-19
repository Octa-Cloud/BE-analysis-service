package com.project.analysis.domain.domain.repository;

import com.project.analysis.domain.domain.entity.SleepSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SleepSessionRepository extends JpaRepository<SleepSession, Long> {

    boolean existsByUserNoAndSleepDate(Long userNo, LocalDate sleepDate);
    Optional<SleepSession> findByUserNoAndSleepDate(Long userNo, LocalDate sleepDate);

}
