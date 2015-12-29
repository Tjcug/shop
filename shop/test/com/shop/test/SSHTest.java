package com.shop.test;

import javassist.expr.NewArray;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.CategoryDAO;
import com.shop.model.Category;
import com.shop.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback=false) 
@Transactional(propagation=Propagation.REQUIRED)
public class SSHTest {
	
	@Resource 
	private CategoryService categoryService;
	
	@Test
	public void Test(){
		categoryService.save(new Category("hello", true));
		System.out.println(1);
	}
}
