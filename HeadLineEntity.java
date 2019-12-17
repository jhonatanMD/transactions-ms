package com.headlines.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HeadLines")
public class HeadLineEntity {

	@Id
	private String idH;
	
	private String idCli;
	
	private String namH;
	private String lastNamH;
	private String dniH;
	
	private String profile;
	
	public String getIdH() {
		return idH;
	}
	public void setIdH(String idH) {
		this.idH = idH;
	}
	public String getIdCli() {
		return idCli;
	}
	public void setIdCli(String idCli) {
		this.idCli = idCli;
	}
	public String getNamH() {
		return namH;
	}
	public void setNamH(String namH) {
		this.namH = namH;
	}
	public String getLastNamH() {
		return lastNamH;
	}
	public void setLastNamH(String lastNamH) {
		this.lastNamH = lastNamH;
	}
	public String getDniH() {
		return dniH;
	}
	public void setDniH(String dniH) {
		this.dniH = dniH;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
}
