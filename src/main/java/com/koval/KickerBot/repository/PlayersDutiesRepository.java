package com.koval.KickerBot.repository;

import com.koval.KickerBot.model.PlayersBets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersDutiesRepository extends JpaRepository<PlayersBets, Long> {
}
