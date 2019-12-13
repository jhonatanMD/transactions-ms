package com.transactions.ms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.transactions.ms.model.EntityTransaction;

import reactor.core.publisher.Flux;
@Repository
public interface ITransactionRespository extends ReactiveMongoRepository<EntityTransaction, String> {

	Flux<EntityTransaction> findByDniC();
	Flux<EntityTransaction> findByNumAcc(String numAcc);
	
	
}
