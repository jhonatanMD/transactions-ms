package com.transactions.ms.model;

import java.util.List;

public class EntityDTO {

	
	private List<SavingEntity> savingEntity;
	private List<CurrentEntity> currentEntity;
	private List<FixedTermEntity> fixedTermEntity;
	private List<EntityCreditCard> creditCardEntity;
	private List<EntityCreditPersonal> creditPersonalEntity;
	private List<EntityBusinessCredit> businessCreditEntity;
	
	
	
	
	
	
	public List<SavingEntity> getSavingEntity() {
		return savingEntity;
	}
	public void setSavingEntity(List<SavingEntity> savingEntity) {
		this.savingEntity = savingEntity;
	}
	public List<CurrentEntity> getCurrentEntity() {
		return currentEntity;
	}
	public void setCurrentEntity(List<CurrentEntity> currentEntity) {
		this.currentEntity = currentEntity;
	}
	public List<FixedTermEntity> getFixedTermEntity() {
		return fixedTermEntity;
	}
	public void setFixedTermEntity(List<FixedTermEntity> fixedTermEntity) {
		this.fixedTermEntity = fixedTermEntity;
	}
	public List<EntityCreditCard> getCreditCardEntity() {
		return creditCardEntity;
	}
	public void setCreditCardEntity(List<EntityCreditCard> creditCardEntity) {
		this.creditCardEntity = creditCardEntity;
	}
	public List<EntityCreditPersonal> getCreditPersonalEntity() {
		return creditPersonalEntity;
	}
	public void setCreditPersonalEntity(List<EntityCreditPersonal> creditPersonalEntity) {
		this.creditPersonalEntity = creditPersonalEntity;
	}
	public List<EntityBusinessCredit> getBusinessCreditEntity() {
		return businessCreditEntity;
	}
	public void setBusinessCreditEntity(List<EntityBusinessCredit> businessCreditEntity) {
		this.businessCreditEntity = businessCreditEntity;
	}

	
	
}
