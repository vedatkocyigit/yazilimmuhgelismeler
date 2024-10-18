package com.ecommerce.ECommerce.service;

import com.ecommerce.ECommerce.entity.User;
import com.ecommerce.ECommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@AllArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User isValidUser(String username, String password) {

        User user = userRepository.findByUsername(username);


        if (user != null && user.getPassword().equals(password)){return user;}


        return null;
    }

    @Override
    public User register(User newUser) {


        User user = userRepository.save(newUser);


        if (user != null) {return user;}else{return null;}
    }
}
