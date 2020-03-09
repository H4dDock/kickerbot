package com.koval.KickerBot.controller;

import com.koval.KickerBot.api.dto.RequestDto;
import com.koval.KickerBot.api.dto.SlackResponseDto;
import com.koval.KickerBot.model.Bet;
import com.koval.KickerBot.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.koval.KickerBot.util.BaseControllerUtils.uri;

@RestController
public class BetController {
    private final BetService betService;

    @Autowired
    public BetController(BetService betService) {
        this.betService = betService;
    }

    @PostMapping(value = "/bets/create-bet")
    public ResponseEntity<SlackResponseDto> createBet(@ModelAttribute RequestDto requestDto){
        Bet bet = betService.createBet(requestDto);

        return ResponseEntity
                .created(uri("/bets/{id}", Map.of("id", bet.getId())))
                .body(new SlackResponseDto("Bet " + bet.getBetName() + " created!"));
    }
}
