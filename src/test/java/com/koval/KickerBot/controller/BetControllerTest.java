package com.koval.KickerBot.controller;

import com.koval.KickerBot.api.dto.BetDto;
import com.koval.KickerBot.model.Bet;
import com.koval.KickerBot.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BetControllerTest extends AbstractTest {

    @Test
    @Transactional
    public void crud() throws Exception{
        /* create */
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

        /* list */
        this.mockMvc
                .perform(get("/bets")
                        .contentType(MediaType.APPLICATION_JSON))
                //.andDo(print())
                .andExpect(status().isOk());

        /* update */
        BetDto dto = new BetDto();
        dto.setBetName("betUpdate");
        dto.setBetDescription("betUpdateDescription");

        this.mockMvc
                .perform(put("/bets/{betId}", betId)
                        .content(objectMapper.writeValueAsString(dto))
                        .contentType(MediaType.APPLICATION_JSON))
                //.andDo(print())
                .andExpect(status().isOk());

        /* delete */
        this.mockMvc.perform(delete("/bets/{betId}", betId))
                //.andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void deleteBetInGame() throws Exception{
        /* create */
        String text = "@winner-@loser bet 10";

        Player player = new Player();
        player.setNickname("winner");
        playerRepository.save(player);

        player = new Player();
        player.setNickname("loser");
        playerRepository.save(player);

        Bet bet = new Bet();
        bet.setBetName("bet");
        Long betId = betRepository.save(bet).getId();

        this.mockMvc.perform(post("/games/game")
                .param("text", text)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        /* delete */
        this.mockMvc.perform(delete("/bets/{betId}", betId))
                .andDo(print())
                .andExpect(status().isConflict());

    }
}
