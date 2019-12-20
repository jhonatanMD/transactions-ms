package com.transactions.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transactions.ms.model.EntityDTO;
import com.transactions.ms.model.EntityTransaction;
import com.transactions.ms.service.ITransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class RestControllerTransaction {

	@Autowired
	ITransactionService impl;
	EntityTransaction transaction;
	

	
	@GetMapping("/getProductosByNumDoc/{numDoc}")
	Mono<EntityDTO> getProductos(@PathVariable String numDoc){	
		return impl.allProductNumDoc(numDoc);
	}

	
	@GetMapping("/getTransactionNumc/{numC}")
	Flux<EntityTransaction> getTransactionNumC(@PathVariable String numC){
		return impl.transacctionNumC(numC);
	}
	
	@GetMapping("/getTransactionByDates/{numAcc}/{from}/{until}")
	 Mono<EntityDTO> getTransactionNumC(@PathVariable("numAcc") String numAcc,@PathVariable("from") String from,@PathVariable("until") String until) throws Exception{
		return impl.findByNumAccDate(numAcc, from, until);
	}
	
	@PostMapping("/transactions/{num}/{type}/{cash}/{account}")
	Mono<EntityTransaction> transactionSaving(@PathVariable("num") String num ,@PathVariable("type") String type,@PathVariable("cash") Double cash
			,@PathVariable("account") String account){

		transaction = new EntityTransaction();
		transaction.setNumAcc(num);
		transaction.setType(type);
		transaction.setCashO(cash);
		return  impl.transacctions(transaction, account);
			
	}
	/*
	@PostMapping("/transactionCurrent/{num}/{type}/{cash}")
	Mono<EntityTransaction> transactionCurrent(@PathVariable("num") String num ,@PathVariable("type") String type,@PathVariable("cash") Double cash){
		transaction = new EntityTransaction();
		transaction.setNumAcc(num);
		transaction.setType(type);
		transaction.setCashO(cash);
		return  impl.saveCurrent(transaction);
	}
	
	@PostMapping("/transactionCreditCard/{num}/{type}/{cash}")
	Mono<EntityTransaction> transactionCreditCard(@PathVariable("num") String num ,@PathVariable("type") String type,@PathVariable("cash") Double cash){
		transaction = new EntityTransaction();
		transaction.setNumAcc(num);
		transaction.setType(type);
		transaction.setCashO(cash);
		return impl.saveCardCredit(transaction);
				
		
	}
	
	@PostMapping("/transactionFixed/{num}/{type}/{cash}")
	Mono<EntityTransaction> transactionFixed(@PathVariable("num") String num ,@PathVariable("type") String type,@PathVariable("cash") Double cash){
		transaction = new EntityTransaction();
		transaction.setNumAcc(num);
		transaction.setType(type);
		transaction.setCashO(cash);
		return impl.saveCardFixed(transaction);
	}
	
	*/
	
	@PostMapping("/payCreditCard/{numAccount}/{numCard}/{typeAccount}/{cash}")
	Mono<EntityTransaction> payCreditCard(@PathVariable("numAccount") String numAccount,
			@PathVariable("numCard") String numCard,
			@PathVariable("typeAccount") String typeAccount,
			@PathVariable("cash") Double cash){
		return impl.payCardCredit(numAccount, numCard, typeAccount, cash);
	}
	
	
	
	
	/*
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
			//	 transaction.setDniC(p.getDniCli());
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
				// transaction.setDniC(p.getDniCli());
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
			//	 transaction.setDniC(p.getDocCli());
				 transaction.setNumAcc(p.getNumAcc());
				 transaction.setDateTra(dt);
				 impl.saveTransaction(transaction).subscribe();
				 return Mono.just(p);
		});
	}
	
*/
	
}
