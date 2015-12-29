package com.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.model.FileImage;
import com.shop.service.AccountService;
import com.shop.service.CategoryService;
import com.shop.service.EmailUtil;
import com.shop.service.ForderService;
import com.shop.service.MessageUtil;
import com.shop.service.PayService;
import com.shop.service.ProductService;
import com.shop.service.SorderService;
import com.shop.service.UserService;
import com.shop.util.UploadFieUtil;

@Scope("prototype")
@Controller("baseAction")
public class BaseAction<T> extends ActionSupport implements RequestAware, SessionAware ,ApplicationAware,ModelDriven<T>{
	
	protected T model;
	
	protected Integer page;
	
	protected Integer rows;
	
	//获取被删除的ids
	protected String ids;
	
	protected FileImage fileImage;
	
	//获取返回的数据流
	protected InputStream inputStream;
	
	protected List<T> jsonList=null;
	
	protected Map<String,Object> pageMap=new HashMap<>();
	
	protected Map<String,Object> request;
	protected Map<String,Object> session;
	protected Map<String,Object> application;
	
	@Resource
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;
	@Resource
	protected ProductService productService;
	@Resource
	protected  SorderService sorderService;
	@Resource
	protected  ForderService forderService;
	@Resource
	protected  UserService userService;
	@Resource
	protected UploadFieUtil uploadFieUtil;
	@Resource
	protected PayService payService;
	@Resource
	protected EmailUtil emailUtil;
	@Resource
	protected MessageUtil messageUtil;
	@Override
	public void setApplication(Map<String, Object> application) {
		// TODO 自动生成的方法存根
		this.application=application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自动生成的方法存根
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO 自动生成的方法存根
		this.request=request;
	}

	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	@Override
	public T getModel() {
		// TODO 自动生成的方法存根
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz=(Class) type.getActualTypeArguments()[0];
		try {
			model=(T) clazz.newInstance();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return model;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public List<T> getJsonList() {
		return jsonList;
	}

	public void setJsonList(List<T> jsonList) {
		this.jsonList = jsonList;
	}

	public FileImage getFileImage() {
		return fileImage;
	}

	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}

	
}
