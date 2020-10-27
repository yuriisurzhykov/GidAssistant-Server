package com.yuriysurzhikov.gidassistant.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String getGreetings() {
        return "Hello, dear friend!";
    }
}
