package com.UssdProject.UssdProject.service.airtime;

import com.UssdProject.UssdProject.models.CustomUser;
import com.UssdProject.UssdProject.payload.airtimePayload.AirtimeRequest;
import com.UssdProject.UssdProject.payload.airtimePayload.AirtimeResponse;
import com.UssdProject.UssdProject.payload.airtimePayload.AirtimeResponseData;
import com.UssdProject.UssdProject.payload.sms.SmsDetails;
import com.UssdProject.UssdProject.repository.UserRepository;
import com.UssdProject.UssdProject.service.sms.SmsServiceImpl;
import com.UssdProject.UssdProject.service.user.UserService;
import com.UssdProject.UssdProject.utils.ResponseUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AirtimeServiceImpl implements AirtimeService {

    UserService userService;
    UserRepository userRepository;
    SmsServiceImpl smsService;

    public AirtimeServiceImpl(UserService userService, UserRepository userRepository, SmsServiceImpl smsService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.smsService = smsService;
    }

    @Override
    public AirtimeResponse purchaseAirtime(AirtimeRequest request) {
        boolean isExistsByAccountNumber = userRepository.existsByAccountNumber(request.getAccountNumber());
        if(!isExistsByAccountNumber){
            return AirtimeResponse.builder()
                    .responseCode(ResponseUtils.USER_NOT_FOUND_CODE)
                    .responseMessage(ResponseUtils.USER_NOT_FOUND_MESSAGE)
                    .data(null)
                    .build();
        }else {
            CustomUser newCustomUser = userRepository.findByAccountNumber(request.getAccountNumber());
            if(!(request.getPin() == newCustomUser.getPin())){
                return AirtimeResponse.builder()
                        .responseCode(ResponseUtils.USER_INVALID_INPUT_CODE)
                        .responseMessage(ResponseUtils.USER_INVALID_INPUT_MESSAGE)
                        .data(null)
                        .build();
            }
            newCustomUser.setAccountBalance(newCustomUser.getAccountBalance().subtract(BigDecimal.valueOf(request.getAirtimeAmount())));
            CustomUser savedCustomUser = userRepository.save(newCustomUser);
            if(request.getPhoneNumber() == null){

                SmsDetails message = SmsDetails.builder()
                        .recipientPhoneNumber(savedCustomUser.getPhoneNumber())
                        .message("You have successfully recharged " + request.getAirtimeAmount() + "naira")
                        .build();
                smsService.sendSms(message);

        return AirtimeResponse.builder()
                .responseCode(ResponseUtils.AIRTIME_SUCCESS_CODE)
                .responseMessage(ResponseUtils.AIRTIME_SUCCESS_MESSAGE)
                .data(AirtimeResponseData.builder()
                        .accountNumber(ResponseUtils.truncatedAccountNumber(savedCustomUser.getAccountNumber()))
                        .phoneNumber(savedCustomUser.getPhoneNumber())
                        .airtimeAmount(request.getAirtimeAmount())
                        .accountBalance(savedCustomUser.getAccountBalance())
                        .dateCreated(request.getTransactionDate())
                        .build())
                .build();

            }else {
                SmsDetails message = SmsDetails.builder()
                        .recipientPhoneNumber(request.getPhoneNumber())
                        .message("You have successfully recharged " + request.getAirtimeAmount() + "naira")
                        .build();
                smsService.sendSms(message);

                return AirtimeResponse.builder()
                        .responseCode(ResponseUtils.AIRTIME_SUCCESS_CODE)
                        .responseMessage(ResponseUtils.AIRTIME_SUCCESS_MESSAGE)
                        .data(AirtimeResponseData.builder()
                                .accountNumber(ResponseUtils.truncatedAccountNumber(savedCustomUser.getAccountNumber()))
                                .phoneNumber(request.getPhoneNumber())
                                .airtimeAmount(request.getAirtimeAmount())
                                .accountBalance(savedCustomUser.getAccountBalance())
                                .dateCreated(request.getTransactionDate())
                                .build())
                        .build();
            }

            }

        }
    }



