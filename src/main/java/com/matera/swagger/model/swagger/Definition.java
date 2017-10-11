package com.matera.swagger.model.swagger;

import java.util.Map;

public class Definition {

	private Map<String, Transaction> transactions;

	public Map<String, Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Map<String, Transaction> transactions) {
		this.transactions = transactions;
	}

}
