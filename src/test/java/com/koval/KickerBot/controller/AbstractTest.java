package com.koval.KickerBot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.koval.KickerBot.repository.BetRepository;
import com.koval.KickerBot.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected PlayerRepository playerRepository;
    @Autowired
    protected BetRepository betRepository;
}
