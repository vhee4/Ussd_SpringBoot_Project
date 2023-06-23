package com.UssdProject.UssdProject.payload.airtimePayload;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class AirtimeRequest {
    private String accountNumber;
    private int pin;
    private double airtimeAmount;
    private String phoneNumber;
    private Date transactionDate;
}
