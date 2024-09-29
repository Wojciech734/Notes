package com.Notes.Notes.services;

import com.Notes.Notes.models.User;
import com.Notes.Notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User signUp(User user) {
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
    public User findUserByUsername(String username){
       return userRepository.findByUsername(username);
    }

}
