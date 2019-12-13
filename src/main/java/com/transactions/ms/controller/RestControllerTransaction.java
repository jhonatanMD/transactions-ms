package com.transactions.ms.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transactions.ms.model.CurrentEntity;
import com.transactions.ms.model.EntityBusinessCredit;
import com.transactions.ms.model.EntityCreditCard;
import com.transactions.ms.model.EntityCreditPersonal;
import com.transactions.ms.model.EntityTransaction;
import com.transactions.ms.model.FixedTermEntity;
import com.transactions.ms.model.SavingEntity;
import com.transactions.ms.service.TransactionServiceImpl;
import com.transactions.ms.webclient.CallWebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class RestControllerTransaction {

	@Autowired
	TransactionServiceImpl impl;
	
	 
	CallWebClient callWeb = new CallWebClient();
	
	
	@GetMapping("/getTransactions")
	Flux<EntityTransaction> getTransaction(){
				
		return impl.allTransactions();
	}
	
	
	
	@GetMapping("/getTransaction/{dni}")
	Flux<EntityTransaction> getTransactionAny(){
				
		return impl.allTransactions();
	}
	
	
	@GetMapping("/getTransactionNumc/{numC}")
	Flux<EntityTransaction> getTransactionNumC(@PathVariable String numC){
		return impl.transacctionNumC(numC);
	}
	
	@PostMapping("/transaction")
	Mono<EntityTransaction> transaction(@RequestBody EntityTransaction transaction){
				
		return impl.saveTransaction(transaction);
	}
	
	
	
	@PostMapping("/transactionSaving")
	Mono<SavingEntity> transactionSaving(@RequestBody EntityTransaction transaction){
		Date dt = new Date();
		return  callWeb.getSaving(transaction.getDniC(),transaction.getType(), transaction.getCashO()).flatMap(p ->{
				
			if(transaction.getType().equals("d")) {
				 transaction.setCashA(p.getCash() - transaction.getCashO());
			}else if(transaction.getType().equals("r")) {
				 transaction.setCashA(p.getCash() + transaction.getCashO());
			}
				 transaction.setCashT(p.getCash());
				 transaction.setDniC(p.getDniCli());
				 transaction.setNumAcc(p.getNumAcc());
				 transaction.setDateTra(dt);
				 impl.saveTransaction(transaction).subscribe();
				 return Mono.just(p);
		});
	}
	
	@PostMapping("/transactionCurrent")
	Mono<CurrentEntity> transactionCurrent(@RequestBody EntityTransaction transaction){
		Date dt = new Date();
		return  callWeb.getCurrent(transaction.getDniC(),transaction.getType(), transaction.getCashO()).flatMap(p ->{
				
			if(transaction.getType().equals("d")) {
				 transaction.setCashA(p.getCash() - transaction.getCashO());
			}else if(transaction.getType().equals("r")) {
				 transaction.setCashA(p.getCash() + transaction.getCashO());
			}
			
				 transaction.setCashT(p.getCash());
				 transaction.setDniC(p.getDniCli());
				 transaction.setNumAcc(p.getNumAcc());
				 transaction.setDateTra(dt);
				 impl.saveTransaction(transaction).subscribe();
				 return Mono.just(p);
		});
	}
	
	@PostMapping("/transactionCreditCard")
	Mono<EntityCreditCard> transactionCreditCard(@RequestBody EntityTransaction transaction){
		Date dt = new Date();
		return  callWeb.getCreditCard(transaction.getDniC(),transaction.getType(), transaction.getCashO()).flatMap(p ->{
				
			if(transaction.getType().equals("d")) {
				 transaction.setCashA(p.getCash() - transaction.getCashO());
			}else if(transaction.getType().equals("r")) {
				 transaction.setCashA(p.getCash() + transaction.getCashO());
			}
			
				 transaction.setCashT(p.getCash());
				 transaction.setDniC(p.getDniCli());
				 transaction.setNumAcc(p.getNumAcc());
				 transaction.setDateTra(dt);
				 impl.saveTransaction(transaction).subscribe();
				 return Mono.just(p);
		});
	}
	
	@PostMapping("/transactionCreditPersonal")
	Mono<EntityCreditPersonal> transactionCreditPersonal(@RequestBody EntityTransaction transaction){
		Date dt = new Date();
		return  callWeb.getCreditPersonal(transaction.getDniC(),transaction.getType(), transaction.getCashO()).flatMap(p ->{
				
			if(transaction.getType().equals("d")) {
				 transaction.setCashA(p.getCash() - transaction.getCashO());
			}else if(transaction.getType().equals("r")) {
				 transaction.setCashA(p.getCash() + transaction.getCashO());
			}
			
				 transaction.setCashT(p.getCash());
				 transaction.setDniC(p.getDniCli());
				 transaction.setNumAcc(p.getNumAcc());
				 transaction.setDateTra(dt);
				 impl.saveTransaction(transaction).subscribe();
				 return Mono.just(p);
		});
	}
	
	@PostMapping("/transactionFixed")
	Mono<FixedTermEntity> transactionFixed(@RequestBody EntityTransaction transaction){
		Date dt = new Date();
		return  callWeb.getFixed(transaction.getDniC(),transaction.getType(), transaction.getCashO()).flatMap(p ->{
				
			if(transaction.getType().equals("d")) {
				 transaction.setCashA(p.getCash() - transaction.getCashO());
			}else if(transaction.getType().equals("r")) {
				 transaction.setCashA(p.getCash() + transaction.getCashO());
			}
			
				 transaction.setCashT(p.getCash());
				 transaction.setDniC(p.getDniCli());
				 transaction.setNumAcc(p.getNumAcc());
				 transaction.setDateTra(dt);
				 impl.saveTransaction(transaction).subscribe();
				 return Mono.just(p);
		});
	}
	
	@PostMapping("/transactionBusinessCredit")
	Mono<EntityBusinessCredit> transactionBusinessCredit(@RequestBody EntityTransaction transaction){
		Date dt = new Date();
		return  callWeb.getBusinessCredit(transaction.getDniC(),transaction.getType(), transaction.getCashO()).flatMap(p ->{
				
			if(transaction.getType().equals("d")) {
				 transaction.setCashA(p.getCash() - transaction.getCashO());
			}else if(transaction.getType().equals("r")) {
				 transaction.setCashA(p.getCash() + transaction.getCashO());
			}
			
				 transaction.setCashT(p.getCash());
				 transaction.setDniC(p.getDocCli());
				 transaction.setNumAcc(p.getNumAcc());
				 transaction.setDateTra(dt);
				 impl.saveTransaction(transaction).subscribe();
				 return Mono.just(p);
		});
	}
	

	
}
