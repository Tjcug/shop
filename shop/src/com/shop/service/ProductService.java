package com.shop.service;

import java.util.List;

import com.shop.model.Category;
import com.shop.model.Product;

public interface ProductService extends BaseService<Product>{
	
	public List<Product> queryJoinCategory(String name,int page,int size);
	
	public long getCount(String name);
	
	public void deletebyIds(String ids);
	
	public void deletePdoductPic(String ids);
	
	public List<Product> queryByCid(int cid);
}
