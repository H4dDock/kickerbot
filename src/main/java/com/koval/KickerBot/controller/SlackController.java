package com.koval.KickerBot.controller;

import com.koval.KickerBot.api.dto.ReceiveSlashDto;
import com.koval.KickerBot.api.dto.SlackResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlackController {
    @PostMapping(value = "/slack/slash",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public SlackResponse onReceiveSlashCommand(@ModelAttribute ReceiveSlashDto receiveSlashDto){
        return new SlackResponse("test text");
    }
}