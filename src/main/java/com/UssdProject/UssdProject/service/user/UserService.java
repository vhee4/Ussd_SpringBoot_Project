package com.UssdProject.UssdProject.service.user;

import com.UssdProject.UssdProject.payload.userPayload.UserRequest;
import com.UssdProject.UssdProject.payload.userPayload.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);

}
