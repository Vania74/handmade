package com.example.handmade.web;

import com.example.handmade.model.dtos.UserRegistrationDTO;
import com.example.handmade.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/register")
    public String register(){
        return "auth-register";
    }

    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/users/register")
    public String register(UserRegistrationDTO userRegistrationDTO){
        userService.registerUser(userRegistrationDTO);
        return "index";
    }
}
