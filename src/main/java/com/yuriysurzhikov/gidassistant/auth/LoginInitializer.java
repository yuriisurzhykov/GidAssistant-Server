package com.yuriysurzhikov.gidassistant.auth;

import com.yuriysurzhikov.gidassistant.controllers.user.UserEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.user.UserService;
import com.yuriysurzhikov.gidassistant.exceptions.IncorrectCredentialsException;
import com.yuriysurzhikov.gidassistant.exceptions.UserDoesNotExists;
import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;
import com.yuriysurzhikov.gidassistant.model.db.LoginSession;
import com.yuriysurzhikov.gidassistant.model.db.User;
import com.yuriysurzhikov.gidassistant.model.login.SessionData;
import com.yuriysurzhikov.gidassistant.utils.Const;
import kotlin.Pair;
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

    public Map<String, String> loginUser(UserFromClient user) throws IncorrectCredentialsException, UserDoesNotExists {
        if(userService.isUserCredentialsCorrect(user)) {
            Map<String, String> map = new HashMap<>();
            SessionData session = new SessionData();
            session.setClientIP(user.getIp());
            session.setMacAddr(user.getMacAddr());
            LoginSession session1 = LoginSessionCreator.createSession(session);
            Pair<User, Boolean> pair = userEntityMapper.mapToEntity(user);
            if(pair.component2()){
                session1.user = pair.component1();
            } else {
                throw new UserDoesNotExists(user);
            }
            session1 = sessionRepository.save(session1);
            map.put(Const.User.session_id_key, session1.id);
            map.put(Const.User.user_unique_id, user.getServerId());
            return map;
        }
        throw new IncorrectCredentialsException(Const.Messages.login_error_message);
    }

    public Boolean logoutUser(UserFromClient user) throws IncorrectCredentialsException {
        if(userService.isUserCredentialsCorrect(user)) {
            if(user.getServerId() != null) {
                User user1 = userEntityMapper.mapToEntity(user).component1();
                for(LoginSession loginSession : sessionRepository.findSessionsByUser(user1))
                    sessionRepository.delete(loginSession);
            }
        }
        throw new IncorrectCredentialsException(Const.Messages.login_error_message);
    }
}
