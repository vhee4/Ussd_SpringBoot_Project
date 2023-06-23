package com.UssdProject.UssdProject.payload.airtimePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirtimeResponseData {
    private String accountNumber;//truncated accountNumber
    public String phoneNumber;
    private double airtimeAmount;
    private BigDecimal accountBalance;
    private Date dateCreated;
}
