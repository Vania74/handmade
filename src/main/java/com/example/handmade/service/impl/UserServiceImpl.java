package com.example.handmade.service.impl;

import com.example.handmade.model.dtos.UserLoginDTO;
import com.example.handmade.model.dtos.UserRegistrationDTO;
import com.example.handmade.model.entity.UserEntity;
import com.example.handmade.repository.UserRepository;
import com.example.handmade.service.CurrentUser;
import com.example.handmade.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {

       UserEntity byEmail = userRepository.findByEmail(userLoginDTO.getEmail()).orElse(null);
        if (userLoginDTO.getPassword() == null || byEmail == null ||byEmail.getPassword() == null){
            return false;
        }
        boolean success = passwordEncoder.matches(userLoginDTO.getPassword(), byEmail.getPassword());
        if (success){
            currentUser.setFullName(byEmail.getFirstName() +" " + byEmail.getLastName());
            currentUser.setLoggedIn(true);
        }else {
            currentUser.clean();
        }
        return false;
    }

    @Override
    public void logout() {
        currentUser.clean();

    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO){
        UserEntity mapEntity = modelMapper.map(userRegistrationDTO, UserEntity.class);
        mapEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        return mapEntity;
    }
}
