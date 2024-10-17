package com.Notes.Notes.restControllers;

import com.Notes.Notes.models.User;
import com.Notes.Notes.repository.UserRepository;
import com.Notes.Notes.requests.SignInRequest;
import com.Notes.Notes.responses.AuthenticationResponse;
import com.Notes.Notes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sign-up")
    public AuthenticationResponse signUp(@RequestBody User user) throws Exception{
        return userService.signUp(user);
    }

    @PostMapping("sign-in")
    public AuthenticationResponse signIn(@RequestBody SignInRequest signInRequest) throws Exception {
        return userService.signIn(signInRequest);
    }

}
