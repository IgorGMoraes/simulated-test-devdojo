package com.igor.simulatedtestdevdojo.services;

import com.google.gson.Gson;
import com.igor.simulatedtestdevdojo.mappers.TransactionMapper;
import com.igor.simulatedtestdevdojo.models.Transaction;
import com.igor.simulatedtestdevdojo.models.TransactionDto;
import com.igor.simulatedtestdevdojo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.util.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class TransactionService {

    private final ClientRepository clientRepository;

    public List<TransactionDto> findTransactionsByClientId(Long clientId) {
        String jsonTransactions = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"))
                .getTransactions();
        List<Transaction> transactions = Lists.newArrayList(
                new Gson().fromJson(jsonTransactions, Transaction[].class));
        return transactions.stream()
                .map(TransactionMapper.INSTANCE::transactionToTransactionDto)
                .collect(Collectors.toList());
    }

}
