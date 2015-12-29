package com.shop.service.impl;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.Account;
import com.shop.service.AccountService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback=false) 
@Transactional(propagation=Propagation.REQUIRED)
public class AccountServiceTest {
	
	@Resource
	private AccountService accountService;
	
	@Test
	public void testSave() {
		accountService.save(new Account("admin", "大强", "admin"));
	}
	
	@Test
	public void queryAll() {
		for(Account account:accountService.queryALL()){
			System.out.println(account);
		}
	}
}
