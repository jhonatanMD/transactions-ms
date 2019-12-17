package com.transactions.ms.webclient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.transactions.ms.model.CurrentEntity;
import com.transactions.ms.model.EntityBusinessCredit;
import com.transactions.ms.model.EntityCreditCard;
import com.transactions.ms.model.EntityCreditPersonal;
import com.transactions.ms.model.EntityDTO;
import com.transactions.ms.model.FixedTermEntity;
import com.transactions.ms.model.SavingEntity;

import reactor.core.publisher.Mono;


public class CallWebClient {
	
	  WebClient client = WebClient.builder().baseUrl("http://localhost:8881")
			  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

	   public Mono<SavingEntity> getSaving(String dniC , String type,Double cash){
		  
		return  client.post().uri("/saving-account/api/updTransancionSaving/"+dniC+"/"+type+"/"+cash)
			.retrieve().bodyToMono(SavingEntity.class);	
	  }
	  
	  public Mono<CurrentEntity> getCurrent(String dniC , String type,Double cash){
		  
			return  client.post().uri("/current-account/api/updTransancionesCurrent/"+dniC+"/"+type+"/"+cash)
				.retrieve().bodyToMono(CurrentEntity.class);	
		  }
	  
	  public Mono<EntityBusinessCredit> getBusinessCredit(String dniC , String type,Double cash){
		  
			return  client.post().uri("/business-credit/api/updTransancionesBusinessCredit/"+dniC+"/"+type+"/"+cash)
				.retrieve().bodyToMono(EntityBusinessCredit.class);	
		  }
	  
	  public Mono<EntityCreditCard> getCreditCard(String dniC , String type,Double cash){
		  
			return  client.post().uri("/credit-card/api/updTransancionesCreditCard/"+dniC+"/"+type+"/"+cash)
				.retrieve().bodyToMono(EntityCreditCard.class);	
		  }
	  
	  public Mono<FixedTermEntity> getFixed(String dniC , String type,Double cash){
		  
			return  client.post().uri("/fixed-term/api/updTransancionesFixed/"+dniC+"/"+type+"/"+cash)
				.retrieve().bodyToMono(FixedTermEntity.class);	
		  }
	  
	  public Mono<EntityCreditPersonal> getCreditPersonal(String dniC , String type,Double cash){
		  
			return  client.post().uri("/personal-credit/api/updTransancionesCreditPersonal/"+dniC+"/"+type+"/"+cash)
				.retrieve().bodyToMono(EntityCreditPersonal.class);	
		  }
	  
	  
	  
	  EntityDTO dto;
	  public Mono<EntityDTO> getSavingByNumDoc(String numDoc){
		  
		  dto = new EntityDTO();
		  
			return  client.get().uri("/saving-account/api/getSavingDocu/"+numDoc)
				.retrieve().bodyToMono(SavingEntity.class).flatMap(p -> {
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
							.retrieve().bodyToMono(FixedTermEntity.class).flatMap(fixed -> {
							dto.setFixedTermEntity(fixed);
							return Mono.just(dto);
							});
					
						}).switchIfEmpty(Mono.just(dto));
					
					});
	  }

	  public Mono<EntityCreditPersonal> getCreditPersonalByNumDoc(String numDoc){
		  
			return  client.post().uri("/personal-credit/api/updTransancionesCreditPersonal/"+numDoc)
				.retrieve().bodyToMono(EntityCreditPersonal.class);	
		  }
	  
	  
	  
	  
	  
	  
}
