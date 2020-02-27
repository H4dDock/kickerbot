package com.koval.KickerBot.repository;

import com.koval.KickerBot.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByNickname(String nickname);
}
