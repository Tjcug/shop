package com.shop.action;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.Forder;
import com.shop.model.Product;
import com.shop.model.Sorder;
import com.shop.service.SorderService;


@Scope("prototype")
@Controller("sorderAction")
public class SorderAction extends BaseAction<Sorder>{
	private List<Object> jsonObjectList;
	
	public List<Object> getJsonObjectList() {
		return jsonObjectList;
	}

	public void setJsonObjectList(List<Object> jsonObjectList) {
		this.jsonObjectList = jsonObjectList;
	}

	public String addSorder(){
		//1:根据product.id获取商品数据
		Product product=productService.get(model.getProduct().getId());
		//2:判断session中是否有购物车，没有的话就新创建一个购物车
		if(session.get("forder")==null){
			session.put("forder", new Forder());
		}
		//3:把商品数据添加到购物车中，并且判断是否有重复，有重复就数量加1
		
		Forder forder=(Forder) session.get("forder");
		Sorder solder=sorderService.productToSorder(product);
		forder=sorderService.addSorder(forder, solder);
		
		//4：计算商品的中价格
		double total=forderService.cluTotal(forder);
		forder.setTotal(total);
		session.put("forder", forder);
		return "showCar";
	}
	
	public String querySale(){
		jsonObjectList=sorderService.querySale(model.getNumber());
		return "jsonObjectList";
	}
	public String updateSorder(){
		Forder forder=(Forder) session.get("forder");
		forder=sorderService.updateSorder(forder, model);
		forder.setTotal(forderService.cluTotal(forder));
		session.put("forder", forder);
		inputStream=new ByteArrayInputStream(forder.getTotal().toString().getBytes());
		return "stream";
	}
}
