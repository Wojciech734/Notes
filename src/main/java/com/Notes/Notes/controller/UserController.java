package com.Notes.Notes.controller;

import com.Notes.Notes.models.User;
import com.Notes.Notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{userId}")
    public User findUserById(@PathVariable("userId") Integer id) {

        User user1 = new User();
        user1.setUsername("username");
        user1.setPassword("password");

        user1.setId(id);

        return user1;
    }

}
