package com.transactions.ms.model;

import java.util.List;

public class CurrentEntity {
	
	private String codCur;
	
	private String numAcc;
	
	private Double cash;

	private String typeCli;
	
	private String profile;
	
	private List<HeadLineEntity> heads;
	
	private List<SignatoriesEntity> sigs;

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

	public String getTypeCli() {
		return typeCli;
	}

	public void setTypeCli(String typeCli) {
		this.typeCli = typeCli;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public List<HeadLineEntity> getHeads() {
		return heads;
	}

	public void setHeads(List<HeadLineEntity> heads) {
		this.heads = heads;
	}

	public List<SignatoriesEntity> getSigs() {
		return sigs;
	}

	public void setSigs(List<SignatoriesEntity> sigs) {
		this.sigs = sigs;
	}



	
	

}
