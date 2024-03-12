package com.bank.main.controller;

import com.bank.main.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


import com.bank.main.service.UserService;
import com.webapp.bankingportal.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService =  userService;

    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setName(registeredUser.getName());
        userResponse.setEmail(registeredUser.getEmail());
        userResponse.setAccountNumber(registeredUser.getAccount().getAccountNumber());
        userResponse.setIFSC_code(registeredUser.getAccount().getIFSC_code());
        userResponse.setBranch(registeredUser.getAccount().getBranch());
        userResponse.setAccount_type(registeredUser.getAccount().getAccount_type());


        return ResponseEntity.ok(userResponse);
    }



    @PostMapping("/update")
    public ResponseEntity<UserResponse> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setName(updateUser.getName());
        userResponse.setEmail(updateUser.getEmail());
        userResponse.setAccountNumber(updateUser.getAccount().getAccountNumber());
        userResponse.setIFSC_code(updateUser.getAccount().getIFSC_code());
        userResponse.setBranch(updateUser.getAccount().getBranch());
        userResponse.setAccount_type(updateUser.getAccount().getAccount_type());


        return ResponseEntity.ok(userResponse);
    }

}
