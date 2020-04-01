package com.koval.KickerBot.service;

import com.koval.KickerBot.api.dto.RequestDto;
import com.koval.KickerBot.api.dto.SlackResponseDto;
import com.koval.KickerBot.model.PlayersBet;
import com.koval.KickerBot.repository.BetRepository;
import com.koval.KickerBot.repository.PlayerRepository;
import com.koval.KickerBot.repository.PlayersBetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final PlayerRepository playerRepository;
    private final BetRepository betRepository;
    private final PlayersBetRepository playersBetRepository;

    @Autowired
    public GameService(PlayerRepository playerRepository, BetRepository betRepository, PlayersBetRepository playersBetRepository) {
        this.playerRepository = playerRepository;
        this.betRepository = betRepository;
        this.playersBetRepository = playersBetRepository;
    }

    //ToDo заменить массив дата на мапу вынести в метод перенос
    public SlackResponseDto gameResult(RequestDto requestDto){
        String[] data = requestDto.getText()
                .replaceAll("@", "")
                .replaceAll("-", " ")
                .split(" ");

        PlayersBet playersBet = playersBetRepository.findGameByPlayersAndBet(data[1], data[0], data[2]);
        if(playersBet != null){
            playersBet.setCount(playersBet.getCount() + Long.parseLong(data[3]));
        } else{
            playersBet = new PlayersBet();
            playersBet.setBorrower(playerRepository.findByNickname(data[0]));
            playersBet.setDebtor(playerRepository.findByNickname(data[1]));
            playersBet.setBet(betRepository.findByBetName(data[2]));
            playersBet.setCount(Long.parseLong(data[3]));
        }

        playersBetRepository.save(playersBet);

        return new SlackResponseDto("Game result saved!");
    }

    public SlackResponseDto betPayed(RequestDto requestDto){
        String[] data = requestDto.getText()
                .replaceAll("@", "")
                .replaceAll("->"," ")
                .split(" ");

        playersBetRepository.findGameByPlayersAndBet(data[0], data[1], data[2]);
        return new SlackResponseDto("Debt set off");
    }

    public boolean isThereIsPayerBet(Long betId){
        return playersBetRepository.findByBetId(betId).size() > 0;
    }
}
