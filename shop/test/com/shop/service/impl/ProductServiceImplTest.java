package com.shop.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.Product;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback=false) 
@Transactional(propagation=Propagation.REQUIRED)
public class ProductServiceImplTest {

	@Resource
	private ProductService productService;
	
	@Test
	public void findALL() {
		for(Product product:productService.queryALL()){
			System.out.println(product);
		}
	}
	
	@Test
	public void queryJoinCategory(){
		for(Product product:productService.queryJoinCategory("", 1, 22)){
			System.out.println(product.getCategory().getType());
		}
	}
	
	@Test
	public void dletetProductPic(){
		productService.deletePdoductPic("1,2,3");
	}
	
	@Test
	public void queryByCid(){
		for(Product product:productService.queryByCid(1)){
			System.out.println(product.getCategory());
		}
	}
}
