package com.yuriysurzhikov.gidassistant.controllers.user;

import com.yuriysurzhikov.gidassistant.controllers.city.CityEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.interests.InterestsEntityMapper;
import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;
import com.yuriysurzhikov.gidassistant.model.db.User;
import com.yuriysurzhikov.gidassistant.utils.DateUtils;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserEntityMapper implements EntityMapper<User, UserFromClient> {
    @Autowired
    private CityEntityMapper cityEntityMapper;
    @Autowired
    private InterestsEntityMapper interestsEntityMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserFromClient mapFromEntity(User user) {
        return null;
    }

    @Override
    public User mapToEntity(UserFromClient userFromClient) {
        User user;
        if (userFromClient.getServerId() == null || (user = userRepository.findUserById(userFromClient.getServerId())) == null) {
            user = new User();
            user.id = UUID.randomUUID().toString();
            user.name = userFromClient.getName();
            user.login = userFromClient.getLogin() != null ? userFromClient.getLogin() : userFromClient.getEmail();
            user.email = userFromClient.getEmail();
            user.passwd = userFromClient.getPasswd();
            user.birthday = userFromClient.getBirthday();
            user.age = DateUtils.calculateAge(userFromClient.getBirthday());
            user.city = cityEntityMapper.mapToEntity(userFromClient.getCity());
            user.interests = interestsEntityMapper.mapListToEntity(userFromClient.getInterests());
        }
        return user;
    }

    @Override
    public List<User> mapListToEntity(List<UserFromClient> userFromClients) {
        return userFromClients.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<UserFromClient> mapListFromEntity(List<User> users) {
        return users.stream().map(this::mapFromEntity).collect(Collectors.toList());
    }
}
