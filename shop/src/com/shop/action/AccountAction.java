package com.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.Account;

@Scope("prototype")
@Controller("accountAction")
@Transactional(propagation=Propagation.REQUIRED)
public class AccountAction extends BaseAction<Account>{
	
	public String query(){
		jsonList=accountService.queryALL();
		return "jsonList";
	}
	
	public String aindex(){
		return "aindex";
	}
}
