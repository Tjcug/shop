package com.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("sendAction")
@Transactional(propagation=Propagation.REQUIRED)
public class SendAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		return "success";
	}
	
}
