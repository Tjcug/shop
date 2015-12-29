package com.shop.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

import com.shop.service.MessageUtil;

@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil {
	
	/* （非 Javadoc）
	 * @see com.shop.util.MessageUtil#SendMessage(java.lang.String, java.lang.String)
	 */
	@Override
	public void SendMessage(String content, String number){
		HttpClient httpClient = new HttpClient();
		PostMethod postMethod=new PostMethod("http://utf8.sms.webchinese.cn");
		postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		postMethod.setParameter("Uid", "798750509@qq.com");
		postMethod.setParameter("Key", "72289a41b3d250d84d76");
		postMethod.setParameter("smsMob", number);
		postMethod.setParameter("smsText", content);
		int code = 0;
		try {
			code = httpClient.executeMethod(postMethod);
		} catch (HttpException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("HTTP请求返回的状态码:" + code);
		try {
			System.out.println(postMethod.getResponseBodyAsString());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
