package com.transactions.ms.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.transactions.ms.model.CommissionEntity;
import com.transactions.ms.model.EntityDTO;
import com.transactions.ms.model.EntityTransaction;
import com.transactions.ms.repository.ITransactionRespository;
import com.transactions.ms.webclient.CallWebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	ITransactionRespository repository;
	
	@Autowired
	@Qualifier("webClient")
	CallWebClient callWeb;
	
	EntityTransaction transaction;
	CommissionEntity commission;
	List<CommissionEntity> commissions;
	EntityDTO dto;
	
	@Override
	public Flux<EntityTransaction> allTransactions() {
		// TODO Auto-generated method stub
		return repository.findAll();
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

	@Override
	public Mono<EntityDTO> allProductNumDoc(String numDoc) {
		// TODO Auto-generated method stub
		return callWeb.getProductosByNumDoc(numDoc);
	}



	@Override
	public Mono<EntityTransaction> payCardCredit(String numAcc, String numCard, String typeAcc, Double cash) {
		// TODO Auto-generated method stub
		if(typeAcc.equals("SA")) {
		return	callWeb.payCardOfSaving(numAcc, numCard, cash).flatMap(paySv->{
				return repository.save(paySv);
			});
		}
		else if(typeAcc.equals("CA")){
			return	callWeb.payCardOfCurrent(numAcc, numCard, cash).flatMap(payCur->{
				return repository.save(payCur);
			});
		}else {
			return null;
		}
	}

	@Override
	public Mono<EntityDTO> findByNumAccDate(String numAcc, String from, String until) throws Exception {
		// TODO Auto-generated method stub
		dto = new EntityDTO();
		commissions = new ArrayList<CommissionEntity>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
	 repository.findByNumAccAndDateTraBetween(numAcc,format.parse(from), format.parse(until)).flatMap(commi ->{	
			commission = new CommissionEntity();
			commission.setCommi(commi.getCommi());
			commission.setNumAcc(commi.getNumAcc());
			commission.setDateTra(commi.getDateTra());
			commissions.add(commission);
		return Flux.just(commi);		
		}).subscribe();
	dto.setCommissionEntities(commissions);
	return Mono.just(dto);
	
	}

	@Override
	public Mono<EntityTransaction> transacctions(EntityTransaction transaction ,String account) {
		if(account.equals("SA")) {
			return callWeb.getSaving(transaction.getNumAcc(),transaction.getType(),transaction.getCashO()).flatMap(p ->{
				transaction.setCashA(p.getCashA());
				transaction.setCashT(p.getCashT());
				transaction.setDateTra(p.getDateTra());
				repository.save(transaction).subscribe();
					 return Mono.just(p);
			});	
		}else if(account.equals("CA")) {
			return callWeb.getSaving(transaction.getNumAcc(),transaction.getType(),transaction.getCashO()).flatMap(p ->{
				transaction.setCashA(p.getCashA());
				transaction.setCashT(p.getCashT());
				transaction.setDateTra(p.getDateTra());
				repository.save(transaction).subscribe();
					 return Mono.just(p);
			});
		}else if(account.equals("CC")) {
			return callWeb.getCreditCard(transaction.getNumAcc(),transaction.getType(),transaction.getCashO()).flatMap(p ->{
				transaction.setCashA(p.getCashA());
				transaction.setCashT(p.getCashT());
				transaction.setDateTra(p.getDateTra());
				repository.save(transaction).subscribe();
					 return Mono.just(p);
			});
		}else if(account.equals("FA")) {
			return callWeb.getFixed(transaction.getNumAcc(),transaction.getType(),transaction.getCashO()).flatMap(p ->{
				transaction.setCashA(p.getCashA());
				transaction.setCashT(p.getCashT());
				transaction.setDateTra(p.getDateTra());
				repository.save(transaction).subscribe();
					 return Mono.just(p);
			});
		}else {
			 return Mono.just(transaction);
		}
		
	}
}
