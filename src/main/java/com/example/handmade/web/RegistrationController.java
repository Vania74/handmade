package com.example.handmade.web;

import com.example.handmade.model.dtos.UserRegistrationDTO;
import com.example.handmade.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @ModelAttribute("registerDTO")
    public UserRegistrationDTO registerDTO() {
        return new UserRegistrationDTO();
    }

    @GetMapping("/users/register")
    public String register(){
        return "auth-register";
    }


    @PostMapping("/users/register")
    public String register(UserRegistrationDTO userRegistrationDTO){
        userService.registerUser(userRegistrationDTO);
        return "index";
    }
}
