package com.Notes.Notes.restControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {


    @GetMapping("/example-home-1")
    public String homeExample() {
        return "home controller 1";
    }

    @GetMapping("/example-home-2")
    public String homeExample2() {
        return "home controller 2";
    }

}
