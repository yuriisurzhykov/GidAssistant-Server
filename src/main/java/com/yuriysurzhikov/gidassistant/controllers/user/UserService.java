package com.yuriysurzhikov.gidassistant.controllers.user;

import com.yuriysurzhikov.gidassistant.auth.LoginInitializer;
import com.yuriysurzhikov.gidassistant.auth.LoginSessionCreator;
import com.yuriysurzhikov.gidassistant.controllers.city.CityEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.interests.InterestsService;
import com.yuriysurzhikov.gidassistant.exceptions.IncorrectCredentialsException;
import com.yuriysurzhikov.gidassistant.exceptions.UserDoesNotExists;
import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;
import com.yuriysurzhikov.gidassistant.model.db.User;
import com.yuriysurzhikov.gidassistant.utils.Const;
import kotlin.Pair;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.yuriysurzhikov.gidassistant.utils.Const.User.error_message;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final LoginInitializer loginInitializer;

    public UserService(UserRepository userRepository,
                       UserEntityMapper userEntityMapper,
                       LoginInitializer loginInitializer) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.loginInitializer = loginInitializer;
    }

    public Pair<String, String> registerUser(UserFromClient user) {
        Pair<User, Boolean> userPair = userEntityMapper.mapToEntity(user);
        if(!userPair.component2()) {
            userRepository.save(userPair.component1());
        }
        return new Pair<>(Const.User.user_unique_id, userPair.component1().id);
    }

    public Map<String, String> loginUser(UserFromClient user) {
        try {
            return loginInitializer.loginUser(user);
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return new HashMap<>() {
                {
                    put(error_message, e.getMessage());
                }
            };
        } catch (UserDoesNotExists ex) {
            ex.printStackTrace();
            return new HashMap<>(1) {
                {
                    put(error_message, ex.getMessage());
                }
            };
        }
    }

    public void logoutUser(UserFromClient user) {

    }

    public User getUserById(String id) {
        return id == null ? null : userRepository.getOne(id);
    }

    public Boolean isUserCredentialsCorrect(UserFromClient user) {
        return userRepository.findUserByLoginAndPasswd(user.getLogin() == null ? user.getEmail() : user.getLogin(), user.getPasswd()) != null;
    }
}
