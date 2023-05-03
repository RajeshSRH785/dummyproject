package com.rajesh.accountmgmtservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Accounts {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int balance;
	private String acctStatus;

	public Accounts() {

	}

	// constructor using fields
	public Accounts(int id, int balance, String acctStatus) {
		super();
		this.id = id;
		this.balance = balance;
		this.acctStatus = acctStatus;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAcctStatus() {
		return acctStatus;
	}

	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}

}
