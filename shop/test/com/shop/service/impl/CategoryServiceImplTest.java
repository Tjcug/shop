package com.shop.service.impl;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.Category;
import com.shop.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback=false) 
@Transactional(propagation=Propagation.REQUIRED)
public class CategoryServiceImplTest {

	@Resource
	private CategoryService CategoryService;
	
	@Test
	public void testSave() {
		CategoryService.save(new Category("test",true));
	}

	@Test
	public void testUpdate() {
		CategoryService.update(new Category(5,"test",true));
	}

	@Test
	public void testDelete() {
		CategoryService.delete(6);
	}

	@Test
	public void testGet() {
		System.out.println(CategoryService.get(3));
	}

	@Test
	public void testQueryALL() {
		for(Category cate:CategoryService.queryALL())
		System.out.println(cate);
	}
	
	@Test
	public void queryJoinAccount() {
		for(Category cate:CategoryService.queryJoinAccount("",2,3))
		System.out.println(cate);
	}
	
	@Test
	public void queryCount() {
		System.out.println(CategoryService.getCount(""));
	}
	
	@Test
	public void deletebyIds() {
		CategoryService.deletebyIds("5");
	}
	
	@Test
	public void queryByHot() {
		for(Category cate:CategoryService.queryByHot(true))
			System.out.println(cate);
	}
}
