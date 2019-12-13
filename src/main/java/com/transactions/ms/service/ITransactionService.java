package com.transactions.ms.service;

import com.transactions.ms.model.EntityTransaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionService {
	
	Flux<EntityTransaction> allTransactions();
	Mono<EntityTransaction> saveTransaction(EntityTransaction transaction);
	Mono<EntityTransaction> updTransaction(EntityTransaction transaction);
	Mono<Void> dltTransaction(String id);
	Flux<EntityTransaction> transacctionNumC(String numC);
}
