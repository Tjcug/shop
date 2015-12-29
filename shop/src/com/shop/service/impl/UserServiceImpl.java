package com.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.model.User;
import com.shop.service.UserService;
@Service("userService")
@SuppressWarnings("unchecked")
public class UserServiceImpl extends BaseServiceImpl implements UserService{

	@Override
	public void save(User t) {
		// TODO 自动生成的方法存根
		userDao.save(t);
	}

	@Override
	public void update(User t) {
		// TODO 自动生成的方法存根
		userDao.getSession().update(t);
	}

	@Override
	public void merge(User t) {
		// TODO 自动生成的方法存根
		userDao.getSession().merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		userDao.delete(get(id));
	}

	@Override
	public User get(int id) {
		// TODO 自动生成的方法存根
		return userDao.findById(id);
	}

	@Override
	public List<User> queryALL() {
		// TODO 自动生成的方法存根
		return userDao.findAll();
	}

	@Override
	public User loginUser(User user) {
		// TODO 自动生成的方法存根
		String hql="FROM User u WHERE u.login=:login AND u.pass=:pass";
		return (User) userDao.getSession().createQuery(hql)
				.setString("login",user.getLogin())
				.setString("pass", user.getPass())
				.uniqueResult();
	}

}
