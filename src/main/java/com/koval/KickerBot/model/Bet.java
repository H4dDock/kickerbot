package com.koval.KickerBot.model;

import javax.persistence.*;

@Table(name = "bets")
@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String betName;
    @Column
    private String betDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBetName() {
        return betName;
    }

    public void setBetName(String dutyName) {
        this.betName = dutyName;
    }

    public String getBetDescription() {
        return betDescription;
    }

    public void setBetDescription(String dutyDescription) {
        this.betDescription = dutyDescription;
    }
}
