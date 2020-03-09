package com.koval.KickerBot.service;

import com.koval.KickerBot.api.dto.RequestDto;
import com.koval.KickerBot.api.dto.SlackResponseDto;
import com.koval.KickerBot.model.Player;
import com.koval.KickerBot.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.koval.KickerBot.util.BaseControllerUtils.uri;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createUser(RequestDto requestDto){
        Player player = new Player();
        String nickname = requestDto.getText().replace("@", "");
        player.setNickname(nickname);
        return playerRepository.save(player);
    }
}
