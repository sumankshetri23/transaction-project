package com.transaction.entities;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String accountNumber;
	private Timestamp transactionTs;
	private String type;
	private double amount;

	private LocalDate date;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Timestamp getTransactionTs() {
		return transactionTs;
	}

	public void setTransactionTs(Timestamp transactionTs) {
		this.transactionTs = transactionTs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	




}
