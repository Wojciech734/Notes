package com.Notes.Notes.controller;

import com.Notes.Notes.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        User user1 = new User(1, "mocnyUser", "password");

        users.add(user1);

        return users;
    }

}
