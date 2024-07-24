package com.example.handmade.web;

import com.example.handmade.model.dtos.UserLoginDTO;
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


    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginDTO userLoginDTO){
        userService.login(userLoginDTO);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }
}
