package com.koval.KickerBot.exception;

import org.springframework.http.HttpStatus;

public class BetWithGameException extends MessageErrorException{
    public BetWithGameException() {
        super(HttpStatus.CONFLICT, "bet", "game-with-bet-exist");
    }
}
