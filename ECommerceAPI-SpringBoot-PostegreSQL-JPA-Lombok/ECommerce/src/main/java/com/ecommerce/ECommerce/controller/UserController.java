package com.ecommerce.ECommerce.controller;


import com.ecommerce.ECommerce.entity.User;
import com.ecommerce.ECommerce.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class UserController {

    private final UserService userService;



    @GetMapping("/users")
    public List<User> getAllUser(){

        return userService.getAllUser();
    }
    @PostMapping("/login")

    public void login(@RequestBody User loginUser){


        String username = loginUser.getUsername();
        String password = loginUser.getPassword();

        User user =userService.isValidUser(username,password);


        if (user != null) {

            System.out.println(user.getName() + user.getSurname());
        }else{

            System.out.println("Error");
        }
    }
    @PostMapping("/register")

    public void register(@RequestBody User newUser){


        User user = userService.register(newUser);


        if (user != null) {

            System.out.println(user.getName() + user.getSurname());
        }else{

            System.out.println("Error");
        }

    }
}
