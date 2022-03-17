package com.lti.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.entity.Account;
import com.lti.service.AccountService;

public class AccountTest {

	@Test
	public void checkingopeningAnAccount() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		AccountService accServ= (AccountService) ctx.getBean("accountService");
		
		Account acc = new Account();
		acc.setName("shiv");
        acc.setBalance(90000);
		accServ.openAccount(acc);
				
				
	}
	@Test
	public void checkWithdraw() {
		 ApplicationContext ctx =new ClassPathXmlApplicationContext("spring-config.xml");
		 AccountService acsrvc= (AccountService) ctx.getBean("accountService");
		 acsrvc.withdraw(81, 1000);
	}
	@Test
	public void checkDeposit() {
		 ApplicationContext ctx =new ClassPathXmlApplicationContext("spring-config.xml");
		 AccountService acsrvc= (AccountService) ctx.getBean("accountService");
		 acsrvc.withdraw(81, 17000);

	}
}