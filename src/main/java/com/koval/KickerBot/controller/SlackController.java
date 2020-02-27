package com.koval.KickerBot.controller;

import com.koval.KickerBot.api.dto.ReceiveSlashDto;
import com.koval.KickerBot.api.dto.SlackResponse;
import com.koval.KickerBot.model.Duty;
import com.koval.KickerBot.model.Player;
import com.koval.KickerBot.model.PlayersDuties;
import com.koval.KickerBot.repository.DutyRepository;
import com.koval.KickerBot.repository.PlayerRepository;
import com.koval.KickerBot.repository.PlayersDutiesRepository;
import com.koval.KickerBot.service.SlackService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlackController {
    private final SlackService slackService;
    private final PlayerRepository playerRepository;
    private final DutyRepository dutyRepository;
    private final PlayersDutiesRepository playersDutiesRepository;

    public SlackController(SlackService slackService, PlayerRepository playerRepository, DutyRepository dutyRepository, PlayersDutiesRepository playersDutiesRepository) {
        this.slackService = slackService;
        this.playerRepository = playerRepository;
        this.dutyRepository = dutyRepository;
        this.playersDutiesRepository = playersDutiesRepository;
    }

    @PostMapping(value = "/slack/slash",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public SlackResponse onReceiveSlashCommand(@ModelAttribute ReceiveSlashDto receiveSlashDto){
        return new SlackResponse("test text");
    }

    @PostMapping(value = "/slack/create-player")
    public SlackResponse createPlayer(@ModelAttribute ReceiveSlashDto receiveSlashDto){
        Player player = new Player();
        String nickname = receiveSlashDto.getText().replace("@", "");
        player.setNickname(nickname);
        playerRepository.save(player);

        return new SlackResponse("Player " + nickname + " created!");
    }

    @PostMapping(value = "/slack/create-duty")
    public SlackResponse createDuty(@ModelAttribute ReceiveSlashDto receiveSlashDto){
        String data = receiveSlashDto.getText();
        Duty duty = new Duty();
        duty.setDutyName(data.substring(0, data.indexOf(" ")));
        duty.setDutyDescription(data.substring(data.indexOf("\"") + 1, data.lastIndexOf("\"")));

        dutyRepository.save(duty);

        return new SlackResponse("Bet " + duty.getDutyName() + " created!");
    }

    @PostMapping(value = "/slack/game")
    public SlackResponse gameResult(@ModelAttribute ReceiveSlashDto receiveSlashDto){
        String[] data = receiveSlashDto.getText().replace("@", "").split(" ");

        PlayersDuties playersDuties = new PlayersDuties();
        playersDuties.setBorrower(playerRepository.findByNickname(data[0].split("-")[0]));
        playersDuties.setDebtor(playerRepository.findByNickname(data[0].split("-")[1]));
        playersDuties.setDuty(dutyRepository.findByDutyName(data[1]));
        playersDuties.setCount(Long.parseLong(data[2]));

        playersDutiesRepository.save(playersDuties);

        return new SlackResponse("Game result saved!");
    }
}