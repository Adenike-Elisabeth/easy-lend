package com.example.transactionservice.service;

import com.example.transactionservice.dto.requests.LoanTransactionRequest;
import com.example.transactionservice.dto.response.LoanTransactionResponse;

public interface TransactionService {
    LoanTransactionResponse initializePay(LoanTransactionRequest request);
}
