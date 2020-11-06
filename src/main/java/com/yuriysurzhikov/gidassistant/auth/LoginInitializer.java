package com.yuriysurzhikov.gidassistant.auth;

import com.yuriysurzhikov.gidassistant.controllers.user.UserEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.user.UserRepository;
import com.yuriysurzhikov.gidassistant.controllers.user.UserService;
import com.yuriysurzhikov.gidassistant.exceptions.IncorrectCredentialsException;
import com.yuriysurzhikov.gidassistant.exceptions.UserDoesNotExists;
import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;
import com.yuriysurzhikov.gidassistant.model.db.LoginSession;
import com.yuriysurzhikov.gidassistant.model.db.User;
import com.yuriysurzhikov.gidassistant.model.login.LogoutSessionData;
import com.yuriysurzhikov.gidassistant.model.login.SessionData;
import com.yuriysurzhikov.gidassistant.utils.Const;
import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginInitializer {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEntityMapper userEntityMapper;

    public Map<String, String> loginUser(UserFromClient user) throws IncorrectCredentialsException, UserDoesNotExists {
        if(userRepository.findUserById(user.getServerId()) != null) {
            Map<String, String> map = new HashMap<>();
            SessionData session = new SessionData();
            session.clientIP = user.getIp();
            session.macAddr = user.getMacAddr();
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

    public Boolean logoutUser(LogoutSessionData user) throws IncorrectCredentialsException {
        try{
            if(user.userId != null && !user.userId.isEmpty()) {
                List<LoginSession> sessionDataList = sessionRepository.findAllByUserId(user.userId);
                sessionDataList
                        .parallelStream()
                        .peek(session -> {
                            sessionRepository.deleteById(session.id);
                        })
                        .close();
                return true;
            } else {
                sessionRepository.deleteById(user.sessionId);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IncorrectCredentialsException(Const.Messages.login_error_message);
        }
    }
}
