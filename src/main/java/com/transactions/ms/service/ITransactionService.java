package com.transactions.ms.service;

import com.transactions.ms.model.EntityDTO;
import com.transactions.ms.model.EntityTransaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionService {
	
	Flux<EntityTransaction> allTransactions();

	Mono<EntityTransaction> opeMovementSaving(String numAcc,String numDest,Double cash,String type);
	Mono<EntityTransaction> opeMovementCurrent(String numAcc,String numDest,Double cash,String type);
	Mono<EntityTransaction> updTransaction(EntityTransaction transaction);
	Mono<Void> dltTransaction(String id);
	Flux<EntityTransaction> transacctionNumC(String numC);
	Mono<EntityDTO> allProductNumDoc(String numDoc);
	Mono<EntityDTO> findByNumAccDate(String numAcc,String from , String until) throws Exception;
	
	Mono<EntityTransaction> transacctions(EntityTransaction transaction,String account);
}
