package com.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.model.Category;
import com.shop.service.CategoryService;

/*
 * 
 */

@Scope("prototype")
@Controller("categoryAction")
@Transactional(propagation=Propagation.REQUIRED)
@SuppressWarnings("unchecked")
public class CategoryAction extends BaseAction<Category>{
	
	public String update(){
		categoryService.update(model);
		return "success";
	}
	
	public String queryJoinAccount(){
		pageMap=new HashMap<String, Object>();
		pageMap.put("total", categoryService.getCount(model.getType()));
		pageMap.put("rows", categoryService.queryJoinAccount(model.getType(), page, rows));
		return "jsonMap";
	}
	
	public String deletebyIds(){
		categoryService.deletebyIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save(){
		categoryService.save(model);
	}
	
	public String query(){
		jsonList=categoryService.queryALL();
		return "jsonList";
	}
}
