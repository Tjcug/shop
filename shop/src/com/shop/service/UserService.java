package com.shop.service;

import java.util.List;

import com.shop.model.Product;
import com.shop.model.User;

public interface UserService extends BaseService<User> {
	public User loginUser(User user);
}
