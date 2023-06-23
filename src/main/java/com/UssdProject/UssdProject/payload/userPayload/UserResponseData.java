package com.UssdProject.UssdProject.payload.userPayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseData {
    private String accountNumber;//truncated accountNumber
    private BigDecimal accountBalance;
    private LocalDateTime dateCreated;
}
