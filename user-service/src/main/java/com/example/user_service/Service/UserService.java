package com.example.user_service.Service;

import com.example.user_service.Model.User;
import com.example.user_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String name, String email, String password) {
        User user = new User(name, email, password);
        userRepository.save(user);
    }

    public List<User>getalluser()
    {
       return userRepository.findAll();
    }
}