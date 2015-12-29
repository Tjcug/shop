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
import com.shop.model.Sorder;
import com.shop.service.CategoryService;
import com.shop.service.ForderService;
import com.shop.service.SorderService;
@Transactional(propagation=Propagation.REQUIRED)
@Service("forderService")
@SuppressWarnings("unchecked")
public class ForderServiceImpl extends BaseServiceImpl implements ForderService {

	@Override
	public void save(Forder t) {
		// TODO 自动生成的方法存根
		forderDAO.save(t);
	}

	@Override
	public void update(Forder t) {
		// TODO 自动生成的方法存根
		forderDAO.getSession().update(t);
	}

	@Override
	public void merge(Forder t) {
		// TODO 自动生成的方法存根
		forderDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		forderDAO.delete(get(id));
	}

	@Override
	public Forder get(int id) {
		// TODO 自动生成的方法存根
		return forderDAO.findById(id);
	}

	@Override
	public List<Forder> queryALL() {
		// TODO 自动生成的方法存根
		return forderDAO.findAll();
	}

	@Override
	public double cluTotal(Forder forder) {
		// TODO 自动生成的方法存根
		double total=0.0;
		for(Sorder temp: (Set<Sorder>)forder.getSorders()){
			total+=temp.getNumber()*temp.getPrice();
		}
		return total;
	}

	@Override
	public void updateForderByStatus(int fid, int sid) {
		// TODO 自动生成的方法存根
		String hql="UPDATE Forder f SET f.status.id=:sid where f.id=:fid";
		forderDAO.getSession().createQuery(hql)
		.setInteger("sid", sid)
		.setInteger("fid", fid)
		.executeUpdate();
	}

}
