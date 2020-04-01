package com.koval.KickerBot.api.dto;

public class BetDto {
    private Long id;
    private String betName;
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

    public void setBetName(String betName) {
        this.betName = betName;
    }

    public String getBetDescription() {
        return betDescription;
    }

    public void setBetDescription(String betDescription) {
        this.betDescription = betDescription;
    }
}
