package com.koval.KickerBot.mapper;

import java.util.List;

public interface AbstractMapper<Entity, Dto> {
    Entity fromDto(Dto dto);

    Dto fromEntity(Entity entity);

    List<Dto> fromEntity(List<Entity> listEntities);
}
