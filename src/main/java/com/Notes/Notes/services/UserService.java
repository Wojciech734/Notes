package com.Notes.Notes.services;

import com.Notes.Notes.models.User;

public interface UserService {

    public User signUp(User user);
    public User findUserById(int id) throws Exception;
    public User findUserByUsername(String username);

}
