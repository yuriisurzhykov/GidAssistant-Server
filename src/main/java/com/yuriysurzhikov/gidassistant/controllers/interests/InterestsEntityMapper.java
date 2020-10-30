package com.yuriysurzhikov.gidassistant.controllers.interests;

import com.yuriysurzhikov.gidassistant.model.client.InterestFromClient;
import com.yuriysurzhikov.gidassistant.model.db.Interest;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class InterestsEntityMapper implements EntityMapper<Interest, InterestFromClient> {

    @Autowired
    private InterestsRepository interestsRepository;

    @Override
    public InterestFromClient mapFromEntity(Interest interest) {
        return null;
    }

    @Override
    public Interest mapToEntity(InterestFromClient interestFromClient) {
        Interest interest = new Interest();
        if(interestFromClient.getServerId() != null && !interestFromClient.getServerId().isEmpty()) {
            interest = interestsRepository.getOne(interestFromClient.getServerId());
        } else {
            interest.id = UUID.randomUUID().toString();
            interest.name = interestFromClient.getName();
        }
        return interest;
    }

    @Override
    public List<Interest> mapListToEntity(List<InterestFromClient> interestFromClients) {
        return interestFromClients.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<InterestFromClient> mapListFromEntity(List<Interest> interests) {
        return interests.stream().map(this::mapFromEntity).collect(Collectors.toList());
    }
}
