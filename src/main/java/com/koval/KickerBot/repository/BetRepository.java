package com.koval.KickerBot.repository;

import com.koval.KickerBot.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
    Bet findByBetName(String betName);
}
