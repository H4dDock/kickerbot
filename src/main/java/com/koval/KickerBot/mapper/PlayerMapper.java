package com.koval.KickerBot.mapper;

import com.koval.KickerBot.api.dto.PlayerDto;
import com.koval.KickerBot.model.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends AbstractMapper<Player, PlayerDto> {}