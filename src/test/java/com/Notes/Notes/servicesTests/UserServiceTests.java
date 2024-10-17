package com.Notes.Notes.servicesTests;

import com.Notes.Notes.models.User;
import com.Notes.Notes.repository.UserRepository;
import com.Notes.Notes.services.UserServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImplementation userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindUserById_UserExists() throws Exception {

        User user = new User(1, "username", "password123");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        User foundUser = userService.findUserById(1);

        assertNotNull(foundUser);
        assertEquals("username", foundUser.getUsername());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    void testFindUserById_UserDoesNotExist() {
        when(userRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> {
            userService.findUserById(1);
        });

        assertEquals("this user doesn't exist!", exception.getMessage());
    }

}
