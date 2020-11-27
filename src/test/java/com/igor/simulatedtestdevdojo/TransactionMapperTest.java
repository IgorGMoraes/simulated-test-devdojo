package com.igor.simulatedtestdevdojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igor.simulatedtestdevdojo.mappers.TransactionMapper;
import com.igor.simulatedtestdevdojo.models.Transaction;
import com.igor.simulatedtestdevdojo.models.TransactionDto;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

@Log4j2
public class TransactionMapperTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldMapTransactionToDto() throws IOException {
        Transaction transaction = objectMapper.readValue(new File("src/test/resources/transaction.json"), Transaction.class);
        TransactionDto transactionDto = TransactionMapper.INSTANCE.transactionToTransactionDto(transaction);
        assertEquals("8a8586c5718588a20171881b4bc86de3", transactionDto.getId());
        assertEquals("Euro", transactionDto.getCurrency());
        assertEquals(1679.89, transactionDto.getRunningBalance(), 1e-15);
    }

}
