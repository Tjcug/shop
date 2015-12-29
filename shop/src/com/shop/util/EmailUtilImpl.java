package com.shop.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.shop.service.EmailUtil;

@Component("emailUtil")
public class EmailUtilImpl implements EmailUtil {
	private Properties prop;
	private Session session;
	private Message message;
	private Transport transport;
	
	/* （非 Javadoc）
	 * @see com.shop.service.impl.MessageUtil#sendMessage(java.lang.String, java.lang.String)
	 */
	@Override
	public void sendMessage(String email,String id){
		//登录邮箱客户端（创建回话Session）
		prop=new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.host", "localhost");
		prop.put("mail.smtp.auth","true");
		//创建了Session回话
		session=Session.getDefaultInstance(prop);
		//设置debug模式调试发送信息
		session.setDebug(true);
		//创建一封邮箱对象
		message=new MimeMessage(session);
		//写信
		try {
			//正文内容
			message.setContent("订单"+id+"已经支付成功！！！", "text/html;charset=utf-8");
			message.setSubject("订单支付成功邮件！");
			//发件人地址
			message.setFrom(new InternetAddress("798750509@qq.com"));
			transport=session.getTransport();
			//和链接服务器的认证信息
			transport.connect("smtp.qq.com", "798750509@qq.com", "otnauzrdovsqbfec");
			//设置收件人地址，并且发送邮件
			transport.sendMessage(message, new Address[]{new InternetAddress(email) });
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}finally{
			try {
				transport.close();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				throw new RuntimeException(e);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new EmailUtilImpl().sendMessage("842198810@qq.com", "123887996");
	}
}
