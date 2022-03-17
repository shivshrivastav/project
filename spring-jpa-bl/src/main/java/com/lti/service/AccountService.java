package com.lti.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Activity;
import com.lti.exception.AccountException;

@Component(value = "accountService")
public class AccountService {

	@Autowired
	private GenericDao dao;

	@Transactional
	public void openAccount(Account account) {
		if (account.getBalance() < 1000) {
			throw new AccountException(
					"Sorry, cannot open account. More balance is needed. Minimum balance should be 1000");
		} else {
			dao.save(account);
		}
	}

	@Transactional
	public void withdraw(int acno, double amount) {
		Account acc = dao.fetchById(Account.class, acno);
		if (acc.getBalance() < amount)
			throw new AccountException("Insufficient Balance!!");
		else {
			acc.setBalance(acc.getBalance() - amount);
			dao.save(acc);

			Activity act = new Activity();
			act.setAmount(amount);
//			act.setDatenTime(LocalDateTime.now());
//			act.setType("Withdrawal");
			act.setAccount(acc);
			dao.save(act);
		}

	}

	public void deposit(int accno, double amount) {
		Account acc = dao.fetchById(Account.class, accno);
		acc.setBalance(acc.getBalance() + amount);
		dao.save(acc);

		Activity act = new Activity();
		act.setAmount(amount);
//		act.setDatenTime(LocalDateTime.now());
//		act.setType("Withdrawal");
		act.setAccount(acc);
		dao.save(act);
		

	}

	public void transfer(int fromAccno, int toAccno, double amount) {

	}

	public double balCheck() {

		return 0.0;

	}
}