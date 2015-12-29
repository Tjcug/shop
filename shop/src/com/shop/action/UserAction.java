package com.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.User;

@Controller("userAction")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED)
public class UserAction extends BaseAction<User>{
	
	public String login(){
		model=userService.loginUser(model);
		if(model==null){
			session.put("error", "用户名密码错误");
			return "ulogin";
		}else{
			//登录成功并返回相应的页面
			session.put("user", model);
			if(session.get("goURL")==null){
				return "index";
			}
			else{
				return "goURL";
			}
		}
	}
}
