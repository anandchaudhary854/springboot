package com.anandCodes.springboot.repository;

import com.anandCodes.springboot.model.Transactions;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transactions, String> {
}
