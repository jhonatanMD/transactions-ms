package com.transactions.ms.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


public class FixedTermEntity {

	@Id
	private String idFix;
	private String numAcc;
	private String dniCli;
	private Double cash;
	


	public String getIdFix() {
		return idFix;
	}
	public void setIdFix(String idFix) {
		this.idFix = idFix;
	}

	public String getNumAcc() {
		return numAcc;
	}
	public void setNumAcc(String numAcc) {
		this.numAcc = numAcc;
	}
	public String getDniCli() {
		return dniCli;
	}
	public void setDniCli(String dniCli) {
		this.dniCli = dniCli;
	}
	
	
	public Double getCash() {
		return cash;
	}
	public void setCash(Double cash) {
		this.cash = cash;
	}
	
}
