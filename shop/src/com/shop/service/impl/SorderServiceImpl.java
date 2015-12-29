package com.shop.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONSerializer;
import net.sf.json.JSONString;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.CategoryDAO;
import com.shop.model.Category;
import com.shop.model.Forder;
import com.shop.model.Product;
import com.shop.model.Sorder;
import com.shop.service.CategoryService;
import com.shop.service.SorderService;
@Transactional(propagation=Propagation.REQUIRED)
@Service("sorderService")
@SuppressWarnings("unchecked")
public class SorderServiceImpl extends BaseServiceImpl implements SorderService {

	@Override
	public void save(Sorder t) {
		// TODO 自动生成的方法存根
		sorderDAO.save(t);
	}

	@Override
	public void update(Sorder t) {
		// TODO 自动生成的方法存根
		sorderDAO.getSession().update(t);
	}

	@Override
	public void merge(Sorder t) {
		// TODO 自动生成的方法存根
		sorderDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		sorderDAO.delete(get(id));
	}

	@Override
	public Sorder get(int id) {
		// TODO 自动生成的方法存根
		return sorderDAO.findById(id);
	}

	@Override
	public List<Sorder> queryALL() {
		// TODO 自动生成的方法存根
		return sorderDAO.findAll();
	}

	@Override
	public Sorder productToSorder(Product product) {
		// TODO 自动生成的方法存根
		Sorder model=new Sorder();
		model.setName(product.getName());
		model.setPrice(product.getPrice());
		model.setNumber(1);
		model.setProduct(product);
		return model;
	}

	@Override
	public Forder addSorder(Forder forder, Sorder sorder) {
		// TODO 自动生成的方法存根
		boolean isHave=false;
		for(Sorder old :(Set<Sorder>)forder.getSorders()){
			if(old.getProduct().getId().equals(sorder.getProduct().getId())){
				isHave=true;
				old.setNumber(sorder.getNumber()+old.getNumber());
				break;
			}
		}
		
		if(!isHave){
			sorder.setForder(forder);
			forder.getSorders().add(sorder);
		}
		
		return forder;
	}

	@Override
	public Forder updateSorder(Forder forder, Sorder sorder) {
		// TODO 自动生成的方法存根
		for(Sorder temp: (Set<Sorder>)forder.getSorders()){
			if(temp.getProduct().getId()==sorder.getProduct().getId()){
				temp.setNumber(sorder.getNumber());
			}
		}
		return forder;
	}

	@Override
	public List<Object> querySale(int number) {
		// TODO 自动生成的方法存根
		String hql="SELECT s.name, sum(s.number) FROM Sorder s JOIN s.product Group by s.product.id";
		return	sorderDAO.getSession()
				.createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(number)
				.list();
	}

}
