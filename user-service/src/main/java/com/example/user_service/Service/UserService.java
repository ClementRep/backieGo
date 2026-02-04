package com.example.user_service.Service;

import com.example.user_service.Model.User;
import com.example.user_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create user with location
    public User createUser(String name, String email, String password, Double latitude, Double longitude) {
        User user = new User(name, email, password, latitude, longitude);
        userRepository.save(user);
        return user;
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
