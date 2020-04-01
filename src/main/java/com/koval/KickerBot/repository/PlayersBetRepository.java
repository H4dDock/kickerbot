package com.koval.KickerBot.repository;

import com.koval.KickerBot.model.PlayersBet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayersBetRepository extends JpaRepository<PlayersBet, Long> {
    List<PlayersBet> findByBetId(Long betId);

    @Query(value = "SELECT * FROM players_bets " +
            "INNER JOIN players as deptor on players_bets.debtor_id = deptor.id" +
            "INNER JOIN players as borrower on players_bets.borrower_id = borrower.id" +
            "INNER JOIN bets as bet on duty_id = bet.id" +
            "WHERE " +
            "deptor.nickname = :deptorNickName AND" +
            "borrower.nickname = :borrowerNickName AND" +
            "bet.bet_name = :betName",nativeQuery = true)
    PlayersBet findGameByPlayersAndBet(String deptorNickName, String borrowerNickName, String betName);

}
