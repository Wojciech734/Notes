package com.Notes.Notes.services;

import com.Notes.Notes.models.User;
import com.Notes.Notes.repository.UserRepository;
import com.Notes.Notes.requests.SignInRequest;
import com.Notes.Notes.responses.AuthenticationResponse;
import com.Notes.Notes.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @Override
    public AuthenticationResponse signUp(User user) throws Exception {

        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new Exception("this username is already in use!");
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                savedUser.getUsername(), savedUser.getPassword());
        String token = JwtProvider.generateToken(authentication);

        return new AuthenticationResponse(
                token, "registered successfully");
    }

    public User getUserFromJwt() {
        return null;
    }

    @Override
    public User findUserById(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }

        throw new Exception("this user doesn't exist!");
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) throws Exception {

        Authentication authentication = authenticate(
                signInRequest.getUsername(), signInRequest.getPassword());

        String token = JwtProvider.generateToken(authentication);

        return new AuthenticationResponse(
                token, "logged in successfully");
    }


    private Authentication authenticate(String username, String password) {

        UserDetails userDetails = customerUserDetailsService.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("invalid username!");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("invalid password!");
        }

        return new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
    }

}
