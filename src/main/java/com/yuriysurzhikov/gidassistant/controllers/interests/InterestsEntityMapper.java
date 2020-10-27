package com.yuriysurzhikov.gidassistant.controllers.interests;

import com.yuriysurzhikov.gidassistant.model.client.InterestFromClient;
import com.yuriysurzhikov.gidassistant.model.db.Interest;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;

public class InterestsEntityMapper implements EntityMapper<Interest, InterestFromClient> {
    @Override
    public InterestFromClient mapFromEntity(Interest interest) {
        return null;
    }

    @Override
    public Interest mapToEntity(InterestFromClient interestFromClient) {
        return null;
    }
}
