package com.shop.service;

import java.util.List;

import com.shop.model.Forder;
import com.shop.model.Product;
import com.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder>{
	
	//将商品转换为购物项
	public Sorder productToSorder(Product product);
	
	//添加一个商品项并返回一个新的购物车
	public Forder addSorder(Forder forder,Sorder sorder);
	
	//根据数量来更新购物车
	public Forder updateSorder(Forder forder,Sorder sorder);
	
	//根据number来查询商品的销售数量
	public List<Object> querySale(int number);
}
