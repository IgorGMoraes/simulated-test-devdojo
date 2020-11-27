package com.igor.simulatedtestdevdojo.mappers;

import com.igor.simulatedtestdevdojo.models.Transaction;
import com.igor.simulatedtestdevdojo.models.TransactionDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class TransactionMapper {

    public static final TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);


    @Mappings({
            @Mapping(source = "encodedKey", target = "id"),
            @Mapping(source = "parentAccountKey", target = "arrangementId"),
            @Mapping(source = "creationDate", target = "bookingDate"),
            @Mapping(source ="totalBalance", target = "runningBalance"),
            @Mapping(source = "id", target = "counterPartyAccountNumber"),
            @Mapping(source = "parentAccountKey", target = "reference")
    })
    public abstract TransactionDto transactionToTransactionDto(Transaction transaction);

    @AfterMapping
    protected void setRemainingAttributes(@MappingTarget TransactionDto transactionDto){
        transactionDto.setCreditDebitIndicator(transactionDto.getAmount() >= 0 ? "CREDIT" : "DEBIT" );
        transactionDto.setTypeGroup(transactionDto.getType());
        transactionDto.setInstructedAmount(transactionDto.getAmount());
    }

    //As all currencyCode are EUR I'll simplify this method to an simple if
    @AfterMapping
    protected void setCurrency(@MappingTarget TransactionDto transactionDto){
        if("EUR".equals(transactionDto.getCurrencyCode())){
            transactionDto.setCurrency("Euro");
        }
    }

}
