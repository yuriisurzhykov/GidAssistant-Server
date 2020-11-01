package com.yuriysurzhikov.gidassistant.auth;

import com.yuriysurzhikov.gidassistant.controllers.user.UserEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.user.UserService;
import com.yuriysurzhikov.gidassistant.exceptions.IncorrectCredentialsException;
import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;
import com.yuriysurzhikov.gidassistant.model.db.LoginSession;
import com.yuriysurzhikov.gidassistant.model.db.User;
import com.yuriysurzhikov.gidassistant.model.login.SessionData;
import com.yuriysurzhikov.gidassistant.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginInitializer {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserEntityMapper userEntityMapper;

    public Map<String, String> loginUser(UserFromClient user) throws IncorrectCredentialsException {
        if(userService.isUserCredentialsCorrect(user)) {
            Map<String, String> map = new HashMap<>();
            SessionData session = new SessionData();
            session.setClientIP(user.getIp());
            LoginSession session1 = LoginSessionCreator.createSession(session);
            session1 = sessionRepository.save(session1);
            map.put(Const.User.SESSION_ID_KEY, session1.id);
            map.put(Const.User.UNIQUE_ID_KEY, session1.sessionIP);
            return map;
        }
        throw new IncorrectCredentialsException(Const.Messages.login_error_message);
    }

    public Boolean logoutUser(UserFromClient user) throws IncorrectCredentialsException {
        if(userService.isUserCredentialsCorrect(user)) {
            if(user.getServerId() != null) {
                User user1 = userEntityMapper.mapToEntity(user);
                for(LoginSession loginSession : sessionRepository.findSessionsByUser(user1))
                    sessionRepository.delete(loginSession);
            }
        }
        throw new IncorrectCredentialsException(Const.Messages.login_error_message);
    }
}
