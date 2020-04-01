package com.koval.KickerBot.mapper;

import com.koval.KickerBot.api.dto.BetDto;
import com.koval.KickerBot.model.Bet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BetMapper extends AbstractMapper<Bet, BetDto>{}