package com.yuriysurzhikov.gidassistant.controllers.interests;

import com.yuriysurzhikov.gidassistant.model.client.InterestFromClient;
import com.yuriysurzhikov.gidassistant.model.db.Interest;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;
import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterestsEntityMapper implements EntityMapper<Interest, InterestFromClient> {

    @Autowired
    private InterestsRepository interestsRepository;

    @Override
    public InterestFromClient mapFromEntity(Interest interest) {
        return null;
    }

    @Override
    public Pair<Interest, Boolean> mapToEntity(InterestFromClient interestFromClient) {
        Interest interest;
        interest = interestsRepository.findInterestByName(interestFromClient.getName());
        if (interest != null) {
            return new Pair<>(interest, true);
        } else {
            interest = new Interest();
            interest.name = interestFromClient.getName();
            return new Pair<>(interest, false);
        }
    }

    @Override
    public List<Pair<Interest, Boolean>> mapListToEntity(List<InterestFromClient> interestFromClients) {
        return interestFromClients.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<InterestFromClient> mapListFromEntity(List<Interest> interests) {
        return interests.stream().map(this::mapFromEntity).collect(Collectors.toList());
    }
}
