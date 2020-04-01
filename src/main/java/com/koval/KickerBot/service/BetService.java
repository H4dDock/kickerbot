package com.koval.KickerBot.service;

import com.koval.KickerBot.api.dto.BetDto;
import com.koval.KickerBot.api.dto.RequestDto;
import com.koval.KickerBot.exception.BetWithGameException;
import com.koval.KickerBot.mapper.BetMapper;
import com.koval.KickerBot.model.Bet;
import com.koval.KickerBot.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService {
    private final BetRepository betRepository;
    private final BetMapper betMapper;
    private final GameService gameService;

    @Autowired
    public BetService(BetRepository betRepository, BetMapper betMapper, GameService gameService) {
        this.betRepository = betRepository;
        this.betMapper = betMapper;
        this.gameService = gameService;
    }

    public Bet createBet(RequestDto requestDto){
        String data = requestDto.getText();
        Bet bet = new Bet();
        bet.setBetName(data.substring(0, data.indexOf(" ")));
        bet.setBetDescription(data.substring(data.indexOf("\"") + 1, data.lastIndexOf("\"")));

        return betRepository.save(bet);
    }

    public List<BetDto> betList(){
        return betMapper.fromEntity(betRepository.findAll());
    }

    public void update(Long betId, BetDto dto){
        Bet bet = betMapper.fromDto(dto);
        bet.setId(betId);
        betRepository.save(bet);
    }

    public void delete(Long betId){
        if(!gameService.isThereIsPayerBet(betId)){
            betRepository.deleteById(betId);
        } else {
            throw new BetWithGameException();
        }
    }
}
