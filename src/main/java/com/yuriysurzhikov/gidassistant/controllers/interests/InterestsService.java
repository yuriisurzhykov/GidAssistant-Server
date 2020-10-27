package com.yuriysurzhikov.gidassistant.controllers.interests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestsService {

    @Autowired
    private InterestsRepository interestsRepository;
}
