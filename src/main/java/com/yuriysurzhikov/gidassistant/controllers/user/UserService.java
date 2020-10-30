package com.yuriysurzhikov.gidassistant.controllers.user;

import com.yuriysurzhikov.gidassistant.controllers.interests.InterestsService;
import com.yuriysurzhikov.gidassistant.di.InjectionProvider;
import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;
import com.yuriysurzhikov.gidassistant.model.db.User;
import com.yuriysurzhikov.gidassistant.utils.tasks.Task;
import com.yuriysurzhikov.gidassistant.utils.tasks.TaskCallbacks;
import com.yuriysurzhikov.gidassistant.utils.tasks.TaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final InterestsService interestsService;
    private final UserEntityMapper userEntityMapper;

    public UserService(UserRepository userRepository, InterestsService interestsService, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.interestsService = interestsService;
        this.userEntityMapper = userEntityMapper;
    }

    public void saveUser(UserFromClient user) {
        interestsService.saveInterests(user.getInterests());
        User dbUser = userEntityMapper.mapToEntity(user);
        userRepository.save(dbUser);
        interestsService.addAll(dbUser.interests);
    }
}
