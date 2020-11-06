package com.yuriysurzhikov.gidassistant.controllers.interests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interest")
public class InterestsController {

    @Autowired
    private InterestsService interestsService;

}
