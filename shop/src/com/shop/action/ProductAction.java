package com.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

import net.sf.json.JSONSerializer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.Product;

@Scope("prototype")
@Controller("productAction")
@Transactional(propagation=Propagation.REQUIRED)
public class ProductAction extends BaseAction<Product>{
	
	public void update(){
		String pic=uploadFieUtil.UploadFile(fileImage);
		model.setPic(pic);
		productService.deletePdoductPic(String.valueOf(model.getId()));
		productService.merge(model);
	}
	
	public String queryJoinCategory(){
		pageMap=new HashMap<String, Object>();
		pageMap.put("total", productService.getCount(model.getName()));
		pageMap.put("rows", productService.queryJoinCategory(model.getName(), page, rows));
		return "jsonMap";
	}
	
	public String deletebyIds(){
		productService.deletePdoductPic(ids);
		productService.deletebyIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save(){
		String pic=uploadFieUtil.UploadFile(fileImage);
		model.setPic(pic);
		productService.save(model);
	}
	

	public String get(){
		request.put("product", productService.get(model.getId()));
		return "detail";
	}
}
