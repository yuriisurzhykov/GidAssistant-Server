package com.yuriysurzhikov.gidassistant.controllers.user;

import com.yuriysurzhikov.gidassistant.controllers.city.CityEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.city.CityRepository;
import com.yuriysurzhikov.gidassistant.controllers.interests.InterestsEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.interests.InterestsRepository;
import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;
import com.yuriysurzhikov.gidassistant.model.db.City;
import com.yuriysurzhikov.gidassistant.model.db.User;
import com.yuriysurzhikov.gidassistant.utils.DateUtils;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;
import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserEntityMapper implements EntityMapper<User, UserFromClient> {
    @Autowired
    private CityEntityMapper cityEntityMapper;
    @Autowired
    private InterestsEntityMapper interestsEntityMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private InterestsRepository interestsRepository;

    @Override
    public UserFromClient mapFromEntity(User user) {
        return null;
    }

    @Override
    public Pair<User, Boolean> mapToEntity(UserFromClient userFromClient) {
        User user = null;
        if (userFromClient.getServerId() != null) {
            user = userRepository.findUserById(userFromClient.getServerId());
        }
        if (user == null) {
            user = new User();
            user.id = UUID.randomUUID().toString();
            user.name = userFromClient.getName();
            user.login = userFromClient.getLogin() != null ? userFromClient.getLogin() : userFromClient.getEmail();
            user.email = userFromClient.getEmail();
            user.passwd = userFromClient.getPasswd();
            user.birthday = userFromClient.getBirthday();
            Pair<City, Boolean> pair = cityEntityMapper.mapToEntity(userFromClient.getCity());
            if(!pair.component2()) {
                cityRepository.save(pair.component1());
            }
            user.city = pair.component1();
            user.age = DateUtils.calculateAge(userFromClient.getBirthday());
            user.interests = interestsEntityMapper
                    .mapListToEntity(userFromClient.getInterests())
                    .parallelStream()
                    .peek(interestBooleanPair -> {
                        if(!interestBooleanPair.component2()) {
                            interestsRepository.save(interestBooleanPair.component1());
                        }
                    })
                    .map(Pair::component1)
                    .collect(Collectors.toList());
            return new Pair<>(user, false);
        } else {
            return new Pair<>(user, true);
        }
    }

    @Override
    public List<Pair<User, Boolean>> mapListToEntity(List<UserFromClient> userFromClients) {
        return userFromClients.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<UserFromClient> mapListFromEntity(List<User> users) {
        return users.stream().map(this::mapFromEntity).collect(Collectors.toList());
    }
}
