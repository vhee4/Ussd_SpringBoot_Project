package com.UssdProject.UssdProject.utils;

import java.util.Random;

public class ResponseUtils {
    public static final String USER_REGISTERED_SUCCESS_CODE = "001";
    public static final String USER_REGISTERED_SUCCESS_MESSAGE = "User successfully registered";
    public static final String USER_EXISTS_CODE = "002";
    public static final String USER_EXISTS_MESSAGE = "User with provided phone number already exists";
    public static final String USER_NOT_FOUND_CODE = "003";
    public static final String USER_NOT_FOUND_MESSAGE = "User with provided account number not found";
    public static final String USER_INVALID_INPUT_CODE = "004";
    public static final String USER_INVALID_INPUT_MESSAGE = "Invalid input";


    public static final String AIRTIME_SUCCESS_CODE = "005";
    public static final String AIRTIME_SUCCESS_MESSAGE = "Airtime purchase successful";
    public static final String TRANSFER_SUCCESS_CODE = "006";
    public static final String TRANSFER_SUCCESS_MESSAGE = "Transfer successful";
    public static final String INSUFFICIENT_FUNDS_CODE = "007";
    public static final String INSUFFICIENT_FUNDS_MESSAGE = "Insufficient funds";




    public static final int LENGTH_OF_ACCOUNT_NUMBER = 10;

    public static String generateAccountNumber(int len){
        String accountNumber = "";
        int x;
        char[] stringChars = new char[len];
        for(int i =0; i < len; i++)
        {

            Random random = new Random();
            x = random.nextInt(9);

            stringChars[i] = Integer.toString(x).toCharArray()[0];

        }
        accountNumber = new String(stringChars);
        return accountNumber.trim();
    }

    public static String truncatedAccountNumber(String accountNumber){
        String firstThreeDigits = accountNumber.substring(0,3);
        String lastThreeDigits = accountNumber.substring(accountNumber.length()-3);
        StringBuilder truncatedAccountNumber = new StringBuilder(firstThreeDigits);

        for(int i = 3; i <accountNumber.length()-3; i++){
            truncatedAccountNumber.append('*');
        }

        truncatedAccountNumber.append(lastThreeDigits);
        return truncatedAccountNumber.toString();
    }
}
