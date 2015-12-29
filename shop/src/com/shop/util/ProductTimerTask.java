package com.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.shop.model.Category;
import com.shop.model.Product;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;

@Component("productTimerTask")
public class ProductTimerTask  extends TimerTask{
	@Resource
	private ProductService productService;
	@Resource
	private CategoryService categoryService;
	//application内置对象
	private ServletContextEvent event;
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		System.out.println("--------守护线程加载-------");
		List<List<Product>> bigList=new ArrayList<>();
		for(Category category: categoryService.queryByHot(true)){
			bigList.add(productService.queryByCid(category.getId()));
		}
		event.getServletContext().setAttribute("bigList", bigList);
	}

	public ServletContextEvent getEvent() {
		return event;
	}

	public void setEvent(ServletContextEvent event) {
		this.event = event;
	}
	
	

}
