package com.transactions.ms.webclient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.transactions.ms.model.CommissionEntity;
import com.transactions.ms.model.CurrentEntity;
import com.transactions.ms.model.EntityBusinessCredit;
import com.transactions.ms.model.EntityCreditCard;
import com.transactions.ms.model.EntityCreditPersonal;
import com.transactions.ms.model.EntityDTO;
import com.transactions.ms.model.EntityTransaction;
import com.transactions.ms.model.FixedTermEntity;
import com.transactions.ms.model.SavingEntity;

import reactor.core.publisher.Mono;

@Component
@Qualifier("webClient")
public class CallWebClient {
	
	
	  WebClient client = WebClient.builder().baseUrl("http://localhost:8881")
			  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	  
	  EntityDTO dto;
	  CommissionEntity commission;

	   public Mono<EntityTransaction> getSaving(String numAcc , String type,Double cash){
		  
		return  client.post().uri("/saving-account/api/updTransancionSaving/"+numAcc+"/"+type+"/"+cash)
			.retrieve().bodyToMono(EntityTransaction.class);	
	  }
	  
	  public Mono<EntityTransaction> getCurrent(String numAcc , String type,Double cash){
		  
			return  client.post().uri("/current-account/api/updTransancionesCurrent/"+numAcc+"/"+type+"/"+cash)
				.retrieve().bodyToMono(EntityTransaction.class);	
		  }
	  
	  public Mono<EntityBusinessCredit> getBusinessCredit(String numAcc , String type,Double cash){
		  
			return  client.post().uri("/business-credit/api/updTransancionesBusinessCredit/"+numAcc+"/"+type+"/"+cash)
				.retrieve().bodyToMono(EntityBusinessCredit.class);	
		  }
	  
	  public Mono<EntityTransaction> getCreditCard(String numAcc , String type,Double cash){
		  
			return  client.post().uri("/credit-card/api/updTransancionesCreditCard/"+numAcc+"/"+type+"/"+cash)
				.retrieve().bodyToMono(EntityTransaction.class);	
		  }
	  
	  public Mono<EntityTransaction> getFixed(String numAcc , String type,Double cash){
		  
			return  client.post().uri("/fixed-term/api/updTransancionesFixed/"+numAcc+"/"+type+"/"+cash)
				.retrieve().bodyToMono(EntityTransaction.class);	
		  }
	  
	  public Mono<EntityCreditPersonal> getCreditPersonal(String numAcc , String type,Double cash){
		  
			return  client.post().uri("/personal-credit/api/updTransancionesCreditPersonal/"+numAcc+"/"+type+"/"+cash)
				.retrieve().bodyToMono(EntityCreditPersonal.class);	
		  }
	  
	  
	  
	
	  
	  public Mono<EntityTransaction> payCardOfSaving(String numAcc , String numCard,Double cash){
		  
			return  client.post().uri("/saving-account/api/payCreditCard/"+numAcc+"/"+numCard+"/"+cash)
				.retrieve().bodyToMono(EntityTransaction.class);	
		  }
	  
	  public Mono<EntityTransaction> payCardOfCurrent(String numAcc , String numCard,Double cash){
		  
			return  client.post().uri("/credit-cardt/api/payCreditCard/"+numAcc+"/"+numCard+"/"+cash)
				.retrieve().bodyToMono(EntityTransaction.class);	
		  }
	  
	  

	  
	  public Mono<EntityDTO> getProductosByNumDoc(String numDoc){
		  
		  dto = new EntityDTO();
		  
			return  client.get().uri("/saving-account/api/getSavingDocu/"+numDoc)
				.retrieve().bodyToFlux(SavingEntity.class).collectList().flatMap(p -> {
				dto.setSavingEntity(p);
				return Mono.just(dto);
				}).switchIfEmpty(Mono.just(dto)).flatMap(p->{
					
					return  client.get().uri("/current-account/api/getCurrentNumDoc/"+numDoc)
							.retrieve().bodyToFlux(CurrentEntity.class).collectList()
							.flatMap(current -> {
							dto.setCurrentEntity(current);
							
							return Mono.just(dto);
							
				}).switchIfEmpty(Mono.just(dto)).flatMap(p2->{
					
					return  client.get().uri("/fixed-term/api/getFixedNumDoc/"+numDoc)
							.retrieve().bodyToFlux(FixedTermEntity.class).collectList().flatMap(fixed -> {
							dto.setFixedTermEntity(fixed);
							return Mono.just(dto);
							});
					
						}).switchIfEmpty(Mono.just(dto)).flatMap(p3->{
							
							return  client.get().uri("/credit-card/api/getCreditCardNumDoc/"+numDoc)
									.retrieve().bodyToFlux(EntityCreditCard.class).collectList().flatMap(card -> {
									dto.setCreditCardEntity(card);
									return Mono.just(dto);
									});
							
								}).switchIfEmpty(Mono.just(dto)).flatMap(p4->{
									
									return  client.get().uri("/personal-credit/api/getCreditPersonalNumDoc/"+numDoc)
											.retrieve().bodyToFlux(EntityCreditPersonal.class).collectList().flatMap(creditPer -> {
											dto.setCreditPersonalEntity(creditPer);
											return Mono.just(dto);
											});
									
										}).switchIfEmpty(Mono.just(dto)).flatMap(p5->{
											
											return  client.get().uri("/business-credit/api/getBusinessCrediDoc/"+numDoc)
													.retrieve().bodyToFlux(EntityBusinessCredit.class).collectList().flatMap(creditBusi -> {
													dto.setBusinessCreditEntity(creditBusi);
													return Mono.just(dto);
													});
											
												}).switchIfEmpty(Mono.just(dto));
					
					});		
	  }

	  public Mono<EntityCreditPersonal> getCreditPersonalByNumDoc(String numDoc){
		  
			return  client.post().uri("/personal-credit/api/updTransancionesCreditPersonal/"+numDoc)
				.retrieve().bodyToMono(EntityCreditPersonal.class);	
		  }
	  
	  
	
	  /*
	  public Mono<CommissionEntity> getCommissions(String from , String until ){
		  
		  commission = new CommissionEntity();
		  return client.get().uri("/credit-card/api/getSavingDate/"+from)
					.retrieve().bodyToFlux(EntityTransaction.class).collectList().flatMap(card -> {
					commission.setCommissions(card);
					return Mono.just(commission);
					});
	  }*/
	  
}
