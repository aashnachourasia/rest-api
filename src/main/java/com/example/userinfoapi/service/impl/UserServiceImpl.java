package com.example.userinfoapi.service.impl;

import com.example.userinfoapi.exception.UserNotFoundException;
import com.example.userinfoapi.model.User;
import com.example.userinfoapi.repository.UserRepository;
import com.example.userinfoapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public String createUser(User user) {
        //data saved via repo layer into db
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String updateUser(User user) {
        //more Business logic
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String deleteUser(String userId) {
        //more Business logic
        userRepository.deleteById(userId);
        return "Success";
    }

    @Override
    public User getUser(String userId) {
        if(userRepository.findById(userId).isEmpty())
            throw new UserNotFoundException("Requested user does not exist");
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
