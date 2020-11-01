package com.yuriysurzhikov.gidassistant.controllers.interests;

import com.yuriysurzhikov.gidassistant.model.client.InterestFromClient;
import com.yuriysurzhikov.gidassistant.model.db.Interest;
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

    public List<Interest> saveInterests(List<InterestFromClient> interests) {
        List<Interest> interestsForSave = interestsEntityMapper
                .mapListToEntity(interests)
                .parallelStream()
                .filter(interest -> interestsRepository.findInterestByName(interest.name) == null)
                .collect(Collectors.toList());
        interestsRepository.saveAll(interestsForSave);
        return interestsEntityMapper.mapListToEntity(interests);
    }
}
