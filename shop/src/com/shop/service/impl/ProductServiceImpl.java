package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.ProductDAO;
import com.shop.model.Product;
import com.shop.service.ProductService;
@Transactional(propagation=Propagation.REQUIRED)
@SuppressWarnings("unchecked")
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl implements ProductService{

	@Override
	public void save(Product t) {
		// TODO 自动生成的方法存根
		productDAO.save(t);
	}

	@Override
	public void merge(Product t) {
		// TODO 自动生成的方法存根
		productDAO.getSession().merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		productDAO.delete(productDAO.findById(id));
	}

	@Override
	public Product get(int id) {
		// TODO 自动生成的方法存根
		return productDAO.findById(id);
	}

	@Override
	public List<Product> queryALL() {
		// TODO 自动生成的方法存根
		return productDAO.findAll();
	}

	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		// TODO 自动生成的方法存根
		 return productDAO.getSession().createQuery("FROM Product p LEFT JOIN FETCH p.category WHERE p.name LIKE :name ORDER BY p.id")
				.setString("name","%"+name +"%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public long getCount(String name) {
		// TODO 自动生成的方法存根
		return (long) productDAO.getSession().createQuery("SELECT count(c) FROM Product c WHERE c.name LIKE :name")
				.setString("name","%"+name +"%")
				.uniqueResult();
	}

	@Override
	public void deletebyIds(String ids) {
		// TODO 自动生成的方法存根
		String Hql="DELETE FROM Product WHERE id in("+ids+")";
		productDAO.getSession().createQuery(Hql).executeUpdate();
	}

	@Override
	public void deletePdoductPic(String ids) {
		// TODO 自动生成的方法存根
		String Hql="FROM Product WHERE id in("+ids+")";
		List<Product> proList=productDAO.getSession().createQuery(Hql).list();
		for(Product m_product:proList){
			uploadFieUtil.deleteFile(m_product.getPic());
		}
	}

	@Override
	public void update(Product t) {
		// TODO 自动生成的方法存根
		productDAO.getSession().update(t);
	}

	@Override
	public List<Product> queryByCid(int cid) {
		// TODO 自动生成的方法存根
		 return productDAO.getSession().createQuery("FROM Product p JOIN FETCH p.category WHERE p.open=true AND p.category.id=:cid ORDER BY p.date DESC")
				.setInteger("cid", cid)
				.setFirstResult(0)
				.setMaxResults(4)
				.list();
	}

}
