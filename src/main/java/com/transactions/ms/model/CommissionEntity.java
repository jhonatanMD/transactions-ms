package com.transactions.ms.model;

import java.util.List;

public class CommissionEntity {
	
	List<EntityTransaction> commissions;

	public List<EntityTransaction> getCommissions() {
		return commissions;
	}

	public void setCommissions(List<EntityTransaction> commissions) {
		this.commissions = commissions;
	}

}

