package com.yuriysurzhikov.gidassistant.auth;

import com.yuriysurzhikov.gidassistant.model.db.LoginSession;
import com.yuriysurzhikov.gidassistant.model.login.SessionData;

import java.util.Calendar;
import java.util.UUID;

public class LoginSessionCreator {

    public static LoginSession createSession(SessionData user) {
        LoginSession session = new LoginSession();
        session.id = UUID.randomUUID().toString();
        session.macAddr = user.macAddr;
        session.sessionIP = user.clientIP;
        session.sessionTime = Calendar.getInstance().getTime().getTime();
        return session;
    }
}
