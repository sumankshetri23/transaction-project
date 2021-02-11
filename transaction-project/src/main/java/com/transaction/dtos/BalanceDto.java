package com.transaction.dtos;

import java.sql.Timestamp;

public class BalanceDto {
	
	private int id;
	private String accountNumber;
	private Timestamp lastUpdateTimestamp;
	private double balance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Timestamp getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}
	public void setLastUpdateTimestamp(Timestamp lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}
