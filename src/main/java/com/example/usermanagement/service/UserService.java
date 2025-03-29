    package com.example.usermanagement.service;

    import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;

    @Service
    public class UserService {

        @Autowired
        private UserRepository userRepository;

        public List<User> getAllUsers() {
            return userRepository.getAllUsers();
        }

        // Add this method to save a user
        public void saveUser(User user) {
            if (user == null) {
                throw new IllegalArgumentException("User cannot be null");
            }
            userRepository.saveUser(user);
        }
    }
