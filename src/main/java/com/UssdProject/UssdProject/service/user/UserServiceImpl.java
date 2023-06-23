package com.UssdProject.UssdProject.service.user;

import com.UssdProject.UssdProject.models.CustomUser;
import com.UssdProject.UssdProject.payload.userPayload.UserRequest;
import com.UssdProject.UssdProject.payload.userPayload.UserResponse;
import com.UssdProject.UssdProject.payload.userPayload.UserResponseData;
import com.UssdProject.UssdProject.repository.UserRepository;
import com.UssdProject.UssdProject.utils.ResponseUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //register a user
    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        Boolean isExistsByPhoneNumber = userRepository.existsByPhoneNumber(userRequest.getPhoneNumber());
        if(isExistsByPhoneNumber) {
            return UserResponse.builder()
                    .responseCode(ResponseUtils.USER_EXISTS_CODE)
                    .responseMessage(ResponseUtils.USER_EXISTS_MESSAGE)
                    .data(null)
                    .build();

        } else if (String.valueOf(userRequest.getPin()).length() != 4 || userRequest.getPhoneNumber().length() != 11) {
            return UserResponse.builder()
                    .responseCode(ResponseUtils.USER_INVALID_INPUT_CODE)
                    .responseMessage(ResponseUtils.USER_INVALID_INPUT_MESSAGE)
                    .data(null)
                    .build();

        }else {
            CustomUser newCustomUser = CustomUser.builder()
                    .accountNumber(ResponseUtils.generateAccountNumber(10))
                    .accountBalance(BigDecimal.valueOf(200000.00))
                    .pin(userRequest.getPin())
                    .phoneNumber(userRequest.getPhoneNumber())
                    .dateCreated(userRequest.getDateCreated())
                    .build();
             CustomUser savedCustomUser = userRepository.save(newCustomUser);

            return UserResponse.builder()
                    .responseCode(ResponseUtils.USER_REGISTERED_SUCCESS_CODE)
                    .responseMessage(ResponseUtils.USER_REGISTERED_SUCCESS_MESSAGE)
                    .data(UserResponseData.builder()
                            .accountNumber(ResponseUtils.generateAccountNumber(10))
                            .accountBalance(savedCustomUser.getAccountBalance())
                            .dateCreated(savedCustomUser.getDateCreated())
                            .build())
                    .build();
        }
    }

}
