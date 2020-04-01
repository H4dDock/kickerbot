package com.koval.KickerBot.api.dto;

import com.koval.KickerBot.model.Bet;
import com.koval.KickerBot.model.Player;

public class PlayerBetsDto {
    private Long id;
    private Player debtor;
    private Player borrower;
    private Bet bet;
    private Long count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getDebtor() {
        return debtor;
    }

    public void setDebtor(Player debtor) {
        this.debtor = debtor;
    }

    public Player getBorrower() {
        return borrower;
    }

    public void setBorrower(Player borrower) {
        this.borrower = borrower;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
