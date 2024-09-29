package com.Notes.Notes.controller;

import com.Notes.Notes.models.User;
import com.Notes.Notes.repository.UserRepository;
import com.Notes.Notes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public User findUserById(@PathVariable("userId") int id) throws Exception{
        return userService.findUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/create-user")
    public User createNewUser(@RequestBody User user) {
        User user1 = new User();

        user1.setId(user.getId());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());

        return userRepository.save(user1);
    }

    @GetMapping("/user/{username}")
    public User findUserByUsername(@PathVariable("username") String username) {
       return userService.findUserByUsername(username);
    }

}
