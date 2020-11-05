package com.yuriysurzhikov.gidassistant.utils;

import kotlin.Pair;

import java.util.List;

public interface EntityMapper<Entity, DomainModel> {
    DomainModel mapFromEntity(Entity entity);
    Pair<Entity, Boolean> mapToEntity(DomainModel model);
    List<Pair<Entity, Boolean>> mapListToEntity(List<DomainModel> domainModels);
    List<DomainModel> mapListFromEntity(List<Entity> entities);
}
