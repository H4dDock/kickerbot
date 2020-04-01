package com.koval.KickerBot.controller;

import com.koval.KickerBot.api.dto.RequestDto;
import com.koval.KickerBot.api.dto.SlackResponseDto;
import com.koval.KickerBot.model.Player;
import com.koval.KickerBot.repository.PlayersBetRepository;
import com.koval.KickerBot.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.koval.KickerBot.util.BaseControllerUtils.uri;

@RestController
public class PlayersController {
    private final PlayerService playerService;


    private final PlayersBetRepository playersBetRepository;

    public PlayersController(PlayerService playerService, PlayersBetRepository playersBetRepository) {
        this.playerService = playerService;
        this.playersBetRepository = playersBetRepository;
    }

    @PostMapping(value = "/players/create-player")
    public ResponseEntity<SlackResponseDto> createPlayer(@ModelAttribute RequestDto requestDto){
        Player player = playerService.createUser(requestDto);
        return ResponseEntity
                .created(uri("/players/{id}", Map.of("id", player.getId())))
                .body(new SlackResponseDto("Player " + player.getNickname() + " created!"));
    }
}