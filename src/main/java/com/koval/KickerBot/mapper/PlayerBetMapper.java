package com.koval.KickerBot.mapper;

import com.koval.KickerBot.api.dto.PlayerBetsDto;
import com.koval.KickerBot.model.PlayersBet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerBetMapper extends AbstractMapper<PlayersBet, PlayerBetsDto> {
}
