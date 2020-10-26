package com.yuriysurzhikov.gidassistant.controllers.user;

import com.gidassistant.server.exceptions.NotImplementedException;
import com.gidassistant.server.model.client.UserFromClient;
import com.gidassistant.server.model.server.User;
import com.gidassistant.server.utils.EntityMapper;

public class UserEntityMapper implements EntityMapper<User, UserFromClient> {
    @Override
    public UserFromClient mapFromEntity(User user) {
        return null;
    }

    @Override
    public User mapToEntity(UserFromClient userFromClient) {
        return null;
    }
}
