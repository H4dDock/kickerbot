package com.koval.KickerBot.controller;

import com.koval.KickerBot.model.Bet;
import com.koval.KickerBot.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GameControllerTest extends AbstractTest {

    @Test
    @Transactional
    public void crud() throws Exception {
        String text = "@winner-@loser bet 10";

        Player player = new Player();
        player.setNickname("winner");
        playerRepository.save(player);

        player = new Player();
        player.setNickname("loser");
        playerRepository.save(player);

        Bet bet = new Bet();
        bet.setBetName("bet");
        betRepository.save(bet);

        this.mockMvc.perform(post("/games/game")
                .param("text", text)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
