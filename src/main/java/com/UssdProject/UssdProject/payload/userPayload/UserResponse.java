package com.UssdProject.UssdProject.payload.userPayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class UserResponse {
    private String responseCode;
    private String responseMessage;
    private UserResponseData data;
}
