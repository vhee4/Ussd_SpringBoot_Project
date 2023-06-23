package com.UssdProject.UssdProject.controller;

import com.UssdProject.UssdProject.payload.airtimePayload.AirtimeRequest;
import com.UssdProject.UssdProject.payload.airtimePayload.AirtimeResponse;
import com.UssdProject.UssdProject.service.airtime.AirtimeService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airtime")
public class AirtimeController {
    AirtimeService airtimeService;
    public AirtimeController(AirtimeService airtimeService) {
        this.airtimeService = airtimeService;
    }

    @PutMapping
    public AirtimeResponse purchaseAirtimeForSelf(@RequestBody AirtimeRequest request) {
        return airtimeService.purchaseAirtime(request);
    }



}
