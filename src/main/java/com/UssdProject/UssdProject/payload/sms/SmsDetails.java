package com.UssdProject.UssdProject.payload.sms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @Builder
public class SmsDetails {
        private String recipientPhoneNumber;
        private String message;
}
