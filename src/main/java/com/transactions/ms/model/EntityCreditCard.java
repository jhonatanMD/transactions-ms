package com.transactions.ms.model;

public class EntityCreditCard {


	private String codCur;
	
	private String numCard;
	
	private Double cash;
	
	private Double cashLimit;
	
	private HeadLineEntity  customer;

	public String getCodCur() {
		return codCur;
	}

	public void setCodCur(String codCur) {
		this.codCur = codCur;
	}

	public String getNumCard() {
		return numCard;
	}

	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public Double getCashLimit() {
		return cashLimit;
	}

	public void setCashLimit(Double cashLimit) {
		this.cashLimit = cashLimit;
	}

	public HeadLineEntity getCustomer() {
		return customer;
	}

	public void setCustomer(HeadLineEntity customer) {
		this.customer = customer;
	}





}
