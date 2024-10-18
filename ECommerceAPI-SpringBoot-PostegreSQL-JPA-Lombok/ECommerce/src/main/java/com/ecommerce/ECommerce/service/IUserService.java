package com.ecommerce.ECommerce.service;

import com.ecommerce.ECommerce.entity.User;

import java.util.List;

public interface IUserService {

    public List<User> getAllUser();
    public User isValidUser(String username,String password);
    public User register(User newUser);
}
