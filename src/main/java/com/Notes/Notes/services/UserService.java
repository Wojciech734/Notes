package com.Notes.Notes.services;

import com.Notes.Notes.models.User;
import com.Notes.Notes.requests.SignInRequest;
import com.Notes.Notes.responses.AuthenticationResponse;

public interface UserService {

    public AuthenticationResponse signUp(User user) throws Exception;
    public User findUserById(int id) throws Exception;
    public User findUserByUsername(String username);
    public AuthenticationResponse signIn(SignInRequest signInRequest) throws Exception;

}
