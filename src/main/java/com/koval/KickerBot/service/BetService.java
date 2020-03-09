package com.koval.KickerBot.service;

import com.koval.KickerBot.api.dto.RequestDto;
import com.koval.KickerBot.model.Bet;
import com.koval.KickerBot.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetService {
    private final BetRepository betRepository;

    @Autowired
    public BetService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public Bet createBet(RequestDto requestDto){
        String data = requestDto.getText();
        Bet bet = new Bet();
        bet.setBetName(data.substring(0, data.indexOf(" ")));
        bet.setBetDescription(data.substring(data.indexOf("\"") + 1, data.lastIndexOf("\"")));

        return betRepository.save(bet);
    }
}
