package com.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.AccountDAO;
import com.shop.dao.CategoryDAO;
import com.shop.dao.ForderDAO;
import com.shop.dao.ProductDAO;
import com.shop.dao.SorderDAO;
import com.shop.dao.UserDAO;
import com.shop.util.UploadFieUtil;

@Service("baseService")
public class BaseServiceImpl {
	@Resource
	protected UploadFieUtil uploadFieUtil;
	@Resource
	protected AccountDAO accountDAO;
	@Resource
	protected ProductDAO productDAO;
	@Resource
	protected CategoryDAO categoryDAO;
	@Resource
	protected SorderDAO sorderDAO;
	@Resource
	protected ForderDAO forderDAO;
	@Resource
	protected UserDAO userDao;
}
