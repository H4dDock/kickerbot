package com.koval.KickerBot.controller;

import com.koval.KickerBot.api.dto.SlackResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlackController {
    @PostMapping(value = "/slack/slash")
    public SlackResponse onReceiveSlashCommand(){
        return new SlackResponse("test text");
    }
}