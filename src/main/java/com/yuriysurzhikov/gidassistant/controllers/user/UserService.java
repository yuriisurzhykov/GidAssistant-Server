package com.yuriysurzhikov.gidassistant.controllers.user;

import com.yuriysurzhikov.gidassistant.auth.LoginInitializer;
import com.yuriysurzhikov.gidassistant.auth.LoginSessionCreator;
import com.yuriysurzhikov.gidassistant.controllers.city.CityEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.interests.InterestsService;
import com.yuriysurzhikov.gidassistant.exceptions.IncorrectCredentialsException;
import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;
import com.yuriysurzhikov.gidassistant.model.db.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.yuriysurzhikov.gidassistant.utils.Const.User.ERROR_SESSION_MESSAGE;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final InterestsService interestsService;
    private final UserEntityMapper userEntityMapper;
    private final LoginInitializer loginInitializer;
    private final CityEntityMapper cityEntityMapper;

    public UserService(UserRepository userRepository,
                       InterestsService interestsService,
                       UserEntityMapper userEntityMapper,
                       LoginInitializer loginInitializer,
                       CityEntityMapper cityEntityMapper) {
        this.userRepository = userRepository;
        this.interestsService = interestsService;
        this.userEntityMapper = userEntityMapper;
        this.loginInitializer = loginInitializer;
        this.cityEntityMapper = cityEntityMapper;
    }

    public void registerUser(UserFromClient user) {
        User dbUser = userEntityMapper.mapToEntity(user);
        dbUser.interests.addAll(interestsService.saveInterests(user.getInterests()));
        dbUser.city = cityEntityMapper.mapToEntity(user.getCity());
        dbUser = userRepository.save(dbUser);
        user.setServerId(dbUser.id);
    }

    public Map<String, String> loginUser(UserFromClient user) {
        try {
            return loginInitializer.loginUser(user);
        } catch (IncorrectCredentialsException e) {
            return new HashMap<String, String>() {
                {
                    put(ERROR_SESSION_MESSAGE, e.getMessage());
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
