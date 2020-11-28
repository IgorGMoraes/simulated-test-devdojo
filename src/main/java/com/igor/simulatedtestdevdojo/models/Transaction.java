package com.igor.simulatedtestdevdojo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private String encodedKey;
    private String parentAccountKey;
    private String creationDate;
    private String type;
    private String valueDate;
    private double amount;
    private String currencyCode;
    private double totalBalance;
    private Long id;

    @JsonProperty("accountBalances")
    private void setTotalBalance(Map<String, String> accountBalances) {
        this.totalBalance = Double.parseDouble(accountBalances.get("totalBalance"));
    }

}
