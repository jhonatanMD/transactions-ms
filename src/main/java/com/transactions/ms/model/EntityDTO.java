package com.transactions.ms.model;

import java.util.List;

public class EntityDTO {

	
	private SavingEntity savingEntity;
	private List<CurrentEntity> currentEntity;
	private FixedTermEntity fixedTermEntity;
	
	
	
	public SavingEntity getSavingEntity() {
		return savingEntity;
	}
	public void setSavingEntity(SavingEntity savingEntity) {
		this.savingEntity = savingEntity;
	}

	public List<CurrentEntity> getCurrentEntity() {
		return currentEntity;
	}
	public void setCurrentEntity(List<CurrentEntity> currentEntity) {
		this.currentEntity = currentEntity;
	}
	public FixedTermEntity getFixedTermEntity() {
		return fixedTermEntity;
	}
	public void setFixedTermEntity(FixedTermEntity fixedTermEntity) {
		this.fixedTermEntity = fixedTermEntity;
	}
	
	
}
