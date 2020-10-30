package com.yuriysurzhikov.gidassistant.utils;

import java.util.List;

public interface EntityMapper<Entity, DomainModel> {
    DomainModel mapFromEntity(Entity entity);
    Entity mapToEntity(DomainModel model);
    List<Entity> mapListToEntity(List<DomainModel> domainModels);
    List<DomainModel> mapListFromEntity(List<Entity> entities);
}
