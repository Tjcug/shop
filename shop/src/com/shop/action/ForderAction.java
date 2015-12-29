package com.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.Forder;
import com.shop.model.Sorder;
import com.shop.model.Status;
import com.shop.model.User;

@Controller("forderAction")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED)
public class ForderAction extends BaseAction<Forder>{
	
	@Override
	public Forder getModel() {
		// TODO 自动生成的方法存根
		
		//这里很奇怪 反正就是要拿到session中的购物车，因为session 中的购物车才是 购物项中的设置的购物车属性
		model=(Forder) session.get("forder");
		return model;
	}
	
	public String save(){
		User user=(User) session.get("user");
		model.setUser(user);
		Status status=new Status();
		status.setId(1);
		model.setStatus(status);
		forderService.save(model);
		session.put("oldForder", session.remove("forder"));
		
		return "bank";
	}
	
}
