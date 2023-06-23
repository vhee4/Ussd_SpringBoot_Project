package com.UssdProject.UssdProject.payload.airtimePayload;

import com.UssdProject.UssdProject.payload.userPayload.UserResponseData;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirtimeResponse {
    private String responseCode;
    private String responseMessage;
    private AirtimeResponseData data;
}
