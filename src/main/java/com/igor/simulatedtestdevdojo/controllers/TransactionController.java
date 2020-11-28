package com.igor.simulatedtestdevdojo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.igor.simulatedtestdevdojo.models.Client;
import com.igor.simulatedtestdevdojo.models.TransactionDto;
import com.igor.simulatedtestdevdojo.services.ClientDetailsService;
import com.igor.simulatedtestdevdojo.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping(path = "/{accountId}")
    @PreAuthorize("#accountId == #client.accountId")
    public ResponseEntity<List<TransactionDto>> getTransactionsByClientId(@PathVariable Long accountId,
                                                                          @AuthenticationPrincipal Client client) {
            return ResponseEntity.ok(transactionService.findTransactionsByClientId(accountId));
    }
}
