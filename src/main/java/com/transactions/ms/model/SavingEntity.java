package com.transactions.ms.model;

public class SavingEntity {
	

	private String codSav;
	
	private String numAcc;
	
	private Double cash;
	
	private String dniCli;
	
	
	public String getCodSav() {
		return codSav;
	}

	public void setCodSav(String codSav) {
		this.codSav = codSav;
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


	public String getDniCli() {
		return dniCli;
	}

	public void setDniCli(String dniCli) {
		this.dniCli = dniCli;
	}






	
	//private Flux<String> firm;



/*	public Flux<String> getFirm() {
		return firm;
	}

	public void setFirm(Flux<String> firm) {
		this.firm = firm;
	}
	*/
}
