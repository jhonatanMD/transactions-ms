package com.transactions.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class EntityBusinessCredit {
	@Id
	private String codCur;
	
	private String numAcc;
	
	private Double cash;
	
	private String docCli;
	

	


	public String getCodCur() {
		return codCur;
	}

	public void setCodCur(String codCur) {
		this.codCur = codCur;
	}

	public String getNumAcc() {
		return numAcc;
	}

	public void setNumAcc(String numAcc) {
		this.numAcc = numAcc;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}



	public String getDocCli() {
		return docCli;
	}

	public void setDocCli(String docCli) {
		this.docCli = docCli;
	}



}
