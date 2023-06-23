package com.UssdProject.UssdProject.controller;

import com.UssdProject.UssdProject.payload.userPayload.UserRequest;
import com.UssdProject.UssdProject.payload.userPayload.UserResponse;
import com.UssdProject.UssdProject.service.airtime.AirtimeService;
import com.UssdProject.UssdProject.service.user.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService,AirtimeService airtimeService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public UserResponse registerUser(@RequestBody UserRequest userRequest) {
        return userService.registerUser(userRequest);
    }





}
