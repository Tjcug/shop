package com.shop.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.shop.model.FileImage;

@Component("uploadFieUtil")
public class UploadFieUtil {
	@Value("#{prop.ContentPath}")
	private String CotnetPath;
	
	@Value("#{prop.BankPath}")
	private String BankPath;
	//拿到文件名字
	private String getFielName(String fileName){
		return FilenameUtils.getExtension(fileName);
	}
	
	//生成新的文件名字 通过UUID
	private String getNewName(String fileName){
			String newName=UUID.randomUUID().toString()+"." +getFielName(fileName);
			System.out.println(newName);
			return newName;
	}
	
	//实现上传文件的方法
	public String UploadFile(FileImage fileImage){
		String newName=getNewName(fileImage.getUploadFileName());
		try {
			FileUtil.copyFile(fileImage.getUpload(), new File(CotnetPath,newName));
			return newName;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			fileImage.getUpload().delete();
		}
	}
	
	public boolean deleteFile(String fileName){
		return new File(CotnetPath,fileName).delete();
	}
	
	public String[] getBankImage(){
	return	new File(BankPath).list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO 自动生成的方法存根
				return name.endsWith(".gif");
			}
		});
	}
	
	public static void main(String[] args) {
//		for(String str:new UploadFieUtil().getBankImage()){
//			System.out.println(str);
//		}
//		
		String HelloWorld="HelloWord.gif";
		System.out.println(HelloWorld.substring(HelloWorld.lastIndexOf('.')+1));
	}
}
