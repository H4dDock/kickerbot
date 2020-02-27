package com.koval.KickerBot.repository;

import com.koval.KickerBot.model.Duty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DutyRepository extends JpaRepository<Duty, Long> {
    Duty findByDutyName(String dutyName);
}
