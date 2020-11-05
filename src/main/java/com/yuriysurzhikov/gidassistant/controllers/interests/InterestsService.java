package com.yuriysurzhikov.gidassistant.controllers.interests;

import com.yuriysurzhikov.gidassistant.model.client.InterestFromClient;
import com.yuriysurzhikov.gidassistant.model.db.Interest;
import com.yuriysurzhikov.gidassistant.utils.Const;
import kotlin.Pair;
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

    public Integer saveInterests(List<InterestFromClient> interests) {
        List<Pair<Interest, Boolean>> pairs = interestsEntityMapper.mapListToEntity(interests);
        long count = pairs.parallelStream()
                .peek(interestBooleanPair -> {
                    if (!interestBooleanPair.component2()) {
                        interestsRepository.save(interestBooleanPair.component1());
                    }
                })
                .filter(interestBooleanPair -> !interestBooleanPair.component2())
                .count();
        return count == interests.size() ? Const.Repository.SAVE_SUCCESSFUL : Const.Repository.SAVE_FOUND_COINCIDENCE;
    }
}
