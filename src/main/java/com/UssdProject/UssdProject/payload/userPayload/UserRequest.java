package com.UssdProject.UssdProject.payload.userPayload;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Data
public class UserRequest {

    private int pin;
    private String PhoneNumber;
    private LocalDateTime dateCreated;

}
