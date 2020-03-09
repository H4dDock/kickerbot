package com.koval.KickerBot.service;

import com.koval.KickerBot.api.dto.RequestDto;
import com.koval.KickerBot.api.dto.SlackResponseDto;
import com.koval.KickerBot.model.PlayersBets;
import com.koval.KickerBot.repository.BetRepository;
import com.koval.KickerBot.repository.PlayerRepository;
import com.koval.KickerBot.repository.PlayersDutiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final PlayerRepository playerRepository;
    private final BetRepository betRepository;
    private final PlayersDutiesRepository playersDutiesRepository;

    @Autowired
    public GameService(PlayerRepository playerRepository, BetRepository betRepository, PlayersDutiesRepository playersDutiesRepository) {
        this.playerRepository = playerRepository;
        this.betRepository = betRepository;
        this.playersDutiesRepository = playersDutiesRepository;
    }

    public SlackResponseDto gameResult(RequestDto requestDto){
        String[] data = requestDto.getText().replace("@", "").split(" ");

        PlayersBets playersBets = new PlayersBets();
        playersBets.setBorrower(playerRepository.findByNickname(data[0].split("-")[0]));
        playersBets.setDebtor(playerRepository.findByNickname(data[0].split("-")[1]));
        playersBets.setBet(betRepository.findByBetName(data[1]));
        playersBets.setCount(Long.parseLong(data[2]));

        playersDutiesRepository.save(playersBets);

        return new SlackResponseDto("Game result saved!");
    }
}
