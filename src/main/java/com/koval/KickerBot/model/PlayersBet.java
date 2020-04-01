package com.koval.KickerBot.model;

import javax.persistence.*;

@Table(name = "players_bets")
@Entity
public class PlayersBet {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "debtor_id", referencedColumnName = "id", nullable = false)
    private Player debtor;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id", referencedColumnName = "id", nullable = false)
    private Player borrower;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duty_id", referencedColumnName = "id", nullable = false)
    private Bet bet;
    @Column(nullable = false)
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
