package com.shop.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shop.model.Category;
import com.shop.model.Product;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;
import com.shop.util.ProductTimerTask;
import com.shop.util.UploadFieUtil;


public class IniitDataListener implements ServletContextListener{
	
	private ApplicationContext applicationContext=null;
	
	private ProductTimerTask productTimerTask=null;
	
	private UploadFieUtil uploadFieUtil=null;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO 自动生成的方32法存根
		applicationContext=WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		productTimerTask=(ProductTimerTask) applicationContext.getBean("productTimerTask");
		uploadFieUtil=(UploadFieUtil) applicationContext.getBean("uploadFieUtil");
		productTimerTask.setEvent(event);
		new Timer().schedule(productTimerTask,0, 1000*60*10);
		event.getServletContext().setAttribute("bankName", uploadFieUtil.getBankImage());
		
	}

}
