package com.UssdProject.UssdProject.service.transfer;

import com.UssdProject.UssdProject.payload.transferPayload.TransferResponse;
import com.UssdProject.UssdProject.payload.transferPayload.TransferToOtherBanksDto;
import com.UssdProject.UssdProject.payload.transferPayload.TransferToUbaDto;

public interface TransferService {
    TransferResponse transfer(TransferToOtherBanksDto transfer);

    TransferResponse transfer(TransferToUbaDto transfer);

//    TransferResponse transfer();
//
//    TransferResponse transfer(TransferToOtherBanksDto transfer);
//    TransferResponse transferToOtherBanks(TransferToOtherBanksDto transfer);

}
