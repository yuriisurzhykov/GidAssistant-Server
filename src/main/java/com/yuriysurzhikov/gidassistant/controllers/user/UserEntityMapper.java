package com.yuriysurzhikov.gidassistant.controllers.user;

import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;
import com.yuriysurzhikov.gidassistant.model.db.User;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;

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
