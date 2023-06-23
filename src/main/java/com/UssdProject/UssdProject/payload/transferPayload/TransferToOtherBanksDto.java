package com.UssdProject.UssdProject.payload.transferPayload;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransferToOtherBanksDto {
    private String SenderAccountNumber;
    private String RecipientAccountNumber;
    private double amount;
    private String bankName;
    private LocalDateTime localDateTime;

}
