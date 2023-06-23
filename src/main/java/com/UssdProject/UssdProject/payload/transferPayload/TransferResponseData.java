package com.UssdProject.UssdProject.payload.transferPayload;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransferResponseData {
    private String accountNumber;
    private BigDecimal amount;
    private String transactionType;
    private BigDecimal accountBalance;

    private LocalDateTime localDateTime;
}
