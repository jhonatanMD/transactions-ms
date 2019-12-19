package com.transactions.ms.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Document(collection = "Transaction")
public class EntityTransaction {

	@Id
	private String idTra;
	
	@NotEmpty(message = "should not be empty")
	private String numAcc;

	
	@NotEmpty(message = "should not be empty")
	private Double cashO;
	
	@NotEmpty(message = "should not be empty")
	private Double cashA;
	
	@NotEmpty(message = "should not be empty")
	private Double cashT;
	
	@NotEmpty(message = "should not be empty")
	private String type;
	
	private Double commi;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@NotNull
	private Date dateTra;


	
	public String getIdTra() {
		return idTra;
	}

	public void setIdTra(String idTra) {
		this.idTra = idTra;
	}

	public String getNumAcc() {
		return numAcc;
	}

	public void setNumAcc(String numAcc) {
		this.numAcc = numAcc;
	}

	public Double getCashO() {
		return cashO;
	}

	public void setCashO(Double cashO) {
		this.cashO = cashO;
	}

	public Double getCashA() {
		return cashA;
	}

	public void setCashA(Double cashA) {
		this.cashA = cashA;
	}

	public Double getCashT() {
		return cashT;
	}

	public void setCashT(Double cashT) {
		this.cashT = cashT;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
