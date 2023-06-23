package com.UssdProject.UssdProject.service.transfer;

import com.UssdProject.UssdProject.models.CustomUser;
import com.UssdProject.UssdProject.payload.transferPayload.TransferResponse;
import com.UssdProject.UssdProject.payload.transferPayload.TransferResponseData;
import com.UssdProject.UssdProject.payload.transferPayload.TransferToOtherBanksDto;
import com.UssdProject.UssdProject.payload.transferPayload.TransferToUbaDto;
import com.UssdProject.UssdProject.repository.UserRepository;
import com.UssdProject.UssdProject.utils.ResponseUtils;

import java.math.BigDecimal;

public class TransferToUbaServiceImpl implements TransferService{

    UserRepository userRepository;
    public TransferToUbaServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public TransferResponse transfer(TransferToOtherBanksDto transfer) {
        return null;
    }

    @Override
    public TransferResponse transfer(TransferToUbaDto transfer) {
        if(!userRepository.existsByAccountNumber(transfer.getSenderAccountNumber()) || userRepository.existsByAccountNumber(transfer.getRecipientAccountNumber())){
            return TransferResponse.builder()
                    .responseCode(ResponseUtils.USER_NOT_FOUND_CODE)
                    .responseMessage(ResponseUtils.USER_NOT_FOUND_MESSAGE)
                    .data(null)
                    .build();
        }
        CustomUser sender = userRepository.findByAccountNumber(transfer.getSenderAccountNumber());
        CustomUser recipient =  userRepository.findByAccountNumber(transfer.getRecipientAccountNumber());
        if(sender.getAccountBalance().compareTo(BigDecimal.valueOf(transfer.getAmount())) <0){
            return TransferResponse.builder()
                    .responseCode(ResponseUtils.INSUFFICIENT_FUNDS_CODE)
                    .responseMessage(ResponseUtils.INSUFFICIENT_FUNDS_MESSAGE)
                    .data(null)
                    .build();
        }
        sender.setAccountBalance(sender.getAccountBalance().subtract(BigDecimal.valueOf(transfer.getAmount())));
        CustomUser savedSender = userRepository.save(sender);
        recipient.setAccountBalance(recipient.getAccountBalance().add(BigDecimal.valueOf(transfer.getAmount())));
        CustomUser savedRecipient = userRepository.save(recipient);

        return TransferResponse.builder()
                .responseCode(ResponseUtils.TRANSFER_SUCCESS_CODE)
                .responseMessage(ResponseUtils.TRANSFER_SUCCESS_MESSAGE)
                .data(TransferResponseData.builder()
                        .accountBalance(savedSender.getAccountBalance())
                        .accountNumber(ResponseUtils.truncatedAccountNumber(savedSender.getAccountNumber()))
                        .amount(BigDecimal.valueOf(transfer.getAmount()))
                        .localDateTime(transfer.getLocalDateTime())
                        .transactionType("DEBIT")
                        .build())

                .build();
    }

}
