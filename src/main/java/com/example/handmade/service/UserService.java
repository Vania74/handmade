package com.example.handmade.service;

import com.example.handmade.model.dtos.UserLoginDTO;
import com.example.handmade.model.dtos.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);
    boolean login(UserLoginDTO userLoginDTO);


}
