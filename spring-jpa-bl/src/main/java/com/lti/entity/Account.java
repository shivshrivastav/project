package com.lti.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name="tbl_account")
public class Account {
	@Id
	@GeneratedValue
	private int acno;
	
	private String name;
	
	@Column(name="ac_type")
	private String ac_type;
	
	private double balance;
	
	@OneToMany(mappedBy="account")
	private List<Activity> activities;
	
	public int getAcno() {
		return acno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAc_type() {
		return ac_type;
	}

	public void setAc_type(String ac_type) {
		this.ac_type = ac_type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}
	
	

}