package com.transactions.ms.model;

import java.util.Date;

public class CommissionEntity {
	
	private String numAcc;
	private Double commi;
	private Date   dateTra;
	
	public String getNumAcc() {
		return numAcc;
	}
	public void setNumAcc(String numAcc) {
		this.numAcc = numAcc;
	}
	public Double getCommi() {
		return commi;
	}
	public void setCommi(Double commi) {
		this.commi = commi;
	}
	public Date getDateTra() {
		return dateTra;
	}
	public void setDateTra(Date dateTra) {
		this.dateTra = dateTra;
	}
	
	
}

