package com.shop.service;

import java.util.List;

import com.shop.model.Forder;
import com.shop.model.Sorder;

public interface ForderService extends BaseService<Forder>{
	public double cluTotal(Forder forder);
	
	public void updateForderByStatus(int fid,int sid);
}
