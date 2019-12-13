package com.transactions.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transactions.ms.model.EntityTransaction;
import com.transactions.ms.repository.ITransactionRespository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements ITransactionService {

	
	@Autowired
	ITransactionRespository repository;
	
	@Override
	public Flux<EntityTransaction> allTransactions() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<EntityTransaction> saveTransaction(EntityTransaction transaction) {
		// TODO Auto-generated method stub
		return repository.save(transaction);
	}

	@Override
	public Mono<EntityTransaction> updTransaction(EntityTransaction transaction) {
		// TODO Auto-generated method stub
		return repository.save(transaction);
	}

	@Override
	public Mono<Void> dltTransaction(String id) {
		// TODO Auto-generated method stub
		return repository.deleteById(id);
	}

	@Override
	public Flux<EntityTransaction> transacctionNumC(String numC) {
		// TODO Auto-generated method stub
		return repository.findByNumAcc(numC);
	}

}
