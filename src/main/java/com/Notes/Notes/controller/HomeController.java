package com.Notes.Notes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/homeController")
    public String home() {
        return "home controller 1";
    }

    @GetMapping("/home")
    public String home2() {
        return "home controller 2";
    }

}
