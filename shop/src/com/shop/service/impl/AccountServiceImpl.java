package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.AccountDAO;
import com.shop.model.Account;
import com.shop.service.AccountService;
@Transactional(propagation=Propagation.REQUIRED)
@Service("accountService")
@SuppressWarnings("unchecked")
public class AccountServiceImpl extends BaseServiceImpl implements AccountService{
	
	@Override
	public void save(Account t) {
		// TODO 自动生成的方法存根
		accountDAO.save(t);
	}

	@Override
	public void update(Account t) {
		// TODO 自动生成的方法存根
		accountDAO.getSession().update(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		accountDAO.delete(get(id));
	}

	@Override
	public Account get(int id) {
		// TODO 自动生成的方法存根
		return accountDAO.findById(id);
	}

	@Override
	public List<Account> queryALL() {
		// TODO 自动生成的方法存根
		return accountDAO.findAll();
	}

	@Override
	public void merge(Account t) {
		// TODO 自动生成的方法存根
		accountDAO.merge(t);
	}

}
