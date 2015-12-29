package com.shop.service;

import java.util.List;

import com.shop.model.Category;

public interface CategoryService extends BaseService<Category>{
	
	public List<Category> queryJoinAccount(String type,int page,int size);
	
	public long getCount(String type);
	
	public void deletebyIds(String ids);
	
	public List<Category> queryByHot(boolean hot);
}
