package com.yuriysurzhikov.gidassistant.exceptions;

import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;

public class UserDoesNotExists extends Exception {
    public UserDoesNotExists(UserFromClient user) {
        super("User " + user.getLogin() + ", " + user.getEmail() + ", " + user.getPasswd() + " does not exists!");
    }
}
