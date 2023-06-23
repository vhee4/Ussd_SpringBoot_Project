package com.UssdProject.UssdProject.service.airtime;

import com.UssdProject.UssdProject.payload.airtimePayload.AirtimeRequest;
import com.UssdProject.UssdProject.payload.airtimePayload.AirtimeResponse;

public interface AirtimeService {
    AirtimeResponse purchaseAirtime(AirtimeRequest request);


}
