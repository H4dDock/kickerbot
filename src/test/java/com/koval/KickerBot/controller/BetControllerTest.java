package com.koval.KickerBot.controller;

import com.koval.KickerBot.model.Bet;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BetControllerTest extends AbstractTest {

    @Test
    @Transactional
    public void createBetTest() throws Exception{
        String betDescription = "BetDescription";
        String betTestName = "betTest";
        String betTest = betTestName + " \"" + betDescription + "\"";

        String location = this.mockMvc
                .perform(post("/bets/create-bet")
                        .param("text", betTest)
                        .contentType(MediaType.APPLICATION_JSON))
                //.andDo(print())
                .andExpect(status().isCreated())
                .andReturn().getResponse().getHeader(HttpHeaders.LOCATION);

        long betId = Long.parseLong(location.replace("/bets/", ""));

        Bet bet = betRepository.findById(betId).orElseThrow();

        assertEquals(bet.getBetName(), betTestName);
        assertEquals(bet.getBetDescription(), betDescription);
    }
}
