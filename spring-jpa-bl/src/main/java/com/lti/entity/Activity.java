package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_account_activities")
public class Activity {
	@Id
	@GeneratedValue
	private int Txno;
	private String DatenTime;
	private double Amount;
	
	@ManyToOne
	@JoinColumn(name="acno")
	private Account account;

	public int getTxno() {
		return Txno;
	}

	public void setTxno(int txno) {
		Txno = txno;
	}

	public String getDatenTime() {
		return DatenTime;
	}

	public void setDatenTime(String datenTime) {
		DatenTime = datenTime;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}