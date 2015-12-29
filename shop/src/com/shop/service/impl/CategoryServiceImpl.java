package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONSerializer;
import net.sf.json.JSONString;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.CategoryDAO;
import com.shop.model.Category;
import com.shop.service.CategoryService;
@Transactional(propagation=Propagation.REQUIRED)
@Service("categoryService")
@SuppressWarnings("unchecked")
public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {
	
	public CategoryServiceImpl(){
		System.out.println("----------------CategoryServiceImpl----------");
	}
	
	@Override
	public void save(Category category) {
		// TODO 自动生成的方法存根
		categoryDAO.save(category);
	}

	@Override
	public void update(Category category) {
		// TODO 自动生成的方法存根
		categoryDAO.getSession().update(category);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		categoryDAO.delete(categoryDAO.findById(id));
	}

	@Override
	public Category get(int id) {
		// TODO 自动生成的方法存根
		return categoryDAO.findById(id);
	}

	@Override
	public List<Category> queryALL() {
		// TODO 自动生成的方法存根
		return categoryDAO.findAll();
	}

	@Override
	public List<Category> queryJoinAccount(String type,int page, int size) {
		// TODO 自动生成的方法存根
		return categoryDAO.getSession().createQuery("FROM Category c LEFT JOIN FETCH c.account WHERE c.type LIKE :type ORDER BY c.id")
				.setString("type","%"+type +"%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public long getCount(String type) {
		// TODO 自动生成的方法存根
		return (long) categoryDAO.getSession().createQuery("SELECT count(c) FROM Category c WHERE c.type LIKE :type")
				.setString("type","%"+type +"%")
				.uniqueResult();
	}

	@Override
	public void deletebyIds(String ids) {
		// TODO 自动生成的方法存根
		String Hql="DELETE FROM Category WHERE id in("+ids+")";
		categoryDAO.getSession().createQuery(Hql).executeUpdate();
	}

	@Override
	public void merge(Category t) {
		// TODO 自动生成的方法存根
		categoryDAO.getSession().merge(t);
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		// TODO 自动生成的方法存根
		String Hql="FROM Category c WHERE c.hot=:hot";
		return categoryDAO.getSession().createQuery(Hql)
				.setBoolean("hot", hot)
				.list();
	}

}
