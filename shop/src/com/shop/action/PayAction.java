package com.shop.action;

import java.io.PrintWriter;
import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.BackData;
import com.shop.model.Forder;
import com.shop.model.SendData;
import com.shop.model.User;

@Controller("payAction")
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ParameterAware{

	private static final long serialVersionUID = -3898532322589046425L;
	
	private Map<String, String[]> parameters;
	
	
	@Override
	public Object getModel() {
		// TODO 自动生成的方法存根
		if(parameters.get("pd_FrpId")!=null){
			model=new SendData();
		}else{
			model=new BackData();
		}
		return model;
	}

	public String send() {
		// 把明文和密文都存储到request Map对象中
		SendData sendData=(SendData)model;
		Forder forder=(Forder) session.get("oldForder");
		User user=(User) session.get("user");
		//返回银行编号
		System.out.println(request.get("pd_FrpId").toString());
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt(forder.getTotal().toString());
		sendData.setPa_MP(user.getEmail()+","+user.getPhone());
		payService.saveDataToRequest(request, sendData);
		return "reqpay";
	}
	
	public String success() throws Exception {
		BackData backData=(BackData)model;
		boolean isOK=payService.checkBackData(backData);
		if (isOK) {
			if (parameters.get("r1_Code")[0].equals("1")) { 
				//把 支付成功的订单状态改成已支付,并个给用户显示支付成功信息
				//调用邮件服务接口
				forderService.updateForderByStatus(2013021829, 2);
				String adresss=backData.getR8_MP().split(",")[0];
				emailUtil.sendMessage("842198810@qq.com", "2013021829");
				//发送手机短信
				messageUtil.SendMessage("订单2013021829已经支付成功！！！", "13006152626");
				System.out.println(backData);
				System.out.println("----success !!!-----");
			}
		} else {
			System.out.println("----fail !!!-----");
		}
		return "index";
	}

	public void setParameters(Map<String, String[]> parameters) {
		this.parameters=parameters;
	}
}
