package com.UssdProject.UssdProject.payload.transferPayload;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransferToUbaDto {
    private String SenderAccountNumber;
    private String RecipientAccountNumber;
    private double amount;
    private LocalDateTime localDateTime;
}
