package com.koval.KickerBot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class PlayerControllerTest extends AbstractTest{

	@Test
	@Transactional
	void createPlayerTest() throws Exception {
		String playerName = "@testUserMock";

		String location = this.mockMvc
				.perform(post("/players/create-player")
				.param("text", playerName)
				.contentType(MediaType.APPLICATION_JSON))
				//.andDo(print())
				.andExpect(status().isCreated())
				.andReturn().getResponse().getHeader(HttpHeaders.LOCATION);

		Long playerId = Long.parseLong(location.replace("/players/", ""));

		String nickname = playerRepository.findById(playerId).orElseThrow().getNickname();
		assert nickname.equals(playerName.replace("@",""));
	}

}
