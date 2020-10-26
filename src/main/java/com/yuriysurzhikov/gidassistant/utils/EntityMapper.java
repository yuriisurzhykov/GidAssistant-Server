package com.yuriysurzhikov.gidassistant.utils;

public interface EntityMapper<Entity, DomainModel> {
    DomainModel mapFromEntity(Entity entity);
    Entity mapToEntity(DomainModel model);
}
