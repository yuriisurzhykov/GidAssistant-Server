package com.yuriysurzhikov.gidassistant.controllers.interests;

import com.yuriysurzhikov.gidassistant.di.InjectionProvider;
import com.yuriysurzhikov.gidassistant.model.client.InterestFromClient;
import com.yuriysurzhikov.gidassistant.model.db.Interest;
import com.yuriysurzhikov.gidassistant.utils.tasks.Task;
import com.yuriysurzhikov.gidassistant.utils.tasks.TaskCallbacks;
import com.yuriysurzhikov.gidassistant.utils.tasks.TaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterestsService {

    private final InterestsRepository interestsRepository;
    private final InterestsEntityMapper interestsEntityMapper;

    public InterestsService(InterestsRepository interestsRepository, InterestsEntityMapper interestsEntityMapper) {
        this.interestsRepository = interestsRepository;
        this.interestsEntityMapper = interestsEntityMapper;
    }

    public void saveInterests(List<InterestFromClient> interests) {
        List<Interest> interestsForSave = interestsEntityMapper
                .mapListToEntity(interests)
                .parallelStream()
                .filter(interest -> interestsRepository.findByName(interest.name) != null)
                .collect(Collectors.toList());
        interestsRepository.saveAll(interestsForSave);
    }

    public Integer addAll(List<Interest> interests) {
        return interestsRepository.saveAll(interests).size() - interests.size();
    }
}
