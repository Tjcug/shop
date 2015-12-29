package com.shop.service;

import java.util.Map;

import com.shop.model.BackData;
import com.shop.model.SendData;

public interface PayService {

	Map<String, Object> saveDataToRequest(Map<String, Object> request,
			SendData sendData);

	boolean checkBackData(BackData backData);

}
