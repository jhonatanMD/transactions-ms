package com.transactions.ms.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.transactions.ms.model.EntityTransaction;

import reactor.core.publisher.Flux;
@Repository
public interface ITransactionRespository extends ReactiveMongoRepository<EntityTransaction, String> {

	
	Flux<EntityTransaction> findByNumAcc(String numAcc);
	
	//Flux<EntityTransaction> findByNumAccAndDateTraBetween(String numAcc,String from , String until);
	
	/*@Query("{'numAcc':?0,'dateTra': {$gte:ISODate( '?1' ),$lt:ISODate('?2')}}")
	Flux<EntityTransaction> findByDateParm(String numAcc,String from , String until);*/
	
	//Flux<EntityTransaction> findByDateTraBetween(String from , String until);
	Flux<EntityTransaction> findByNumAccAndDateTraBetween(String numAcc,Date from , Date until);
	
	

	
}
