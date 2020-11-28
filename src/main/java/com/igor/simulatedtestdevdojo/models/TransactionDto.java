package com.igor.simulatedtestdevdojo.models;

import lombok.Data;

@Data
public class TransactionDto {
    private String id;
    private String arrangementId;
    private String bookingDate;
    private String type;
    private String valueDate;
    private double amount;
    private String currencyCode;
    private String currency;
    private String creditDebitIndicator;
    private double runningBalance;
    private String counterPartyAccountNumber;
    private String reference;
    private String typeGroup;
    private double instructedAmount;

}
