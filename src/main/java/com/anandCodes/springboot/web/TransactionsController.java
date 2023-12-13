package com.anandCodes.springboot.web;

import com.anandCodes.springboot.dto.TransactionDto;
import com.anandCodes.springboot.model.Transactions;
import com.anandCodes.springboot.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionsController {

    private TransactionService transactionService;

    public TransactionsController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transactions> getAllTransactions(){
        return transactionService.findAll();
    }

    @PostMapping("/transactions")
    public Transactions createTransactions(@RequestBody @Valid TransactionDto transactionDto){
        return transactionService.create(transactionDto.getAmount(), transactionDto.getUserId());
    }
}
