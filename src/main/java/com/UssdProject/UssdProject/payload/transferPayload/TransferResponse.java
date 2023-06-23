package com.UssdProject.UssdProject.payload.transferPayload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferResponse {
    private String responseCode;
    private String responseMessage;
    private TransferResponseData data;
}
