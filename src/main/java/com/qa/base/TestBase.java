package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class TestBase {
	
	public static Properties pro;
	
	public int STATUS_HTTP_200=200;
	public int STATUS_HTTP_201=201;
	public int STATUS_HTTP_400=400;
	public int STATUS_HTTP_404=404;
	
	
	
	
	public TestBase()
	{
		try {
			File f= new File("D:\\Eclipse\\RestAutomation\\src\\main\\java\\com\\qa\\config\\config.properties");
			FileInputStream fis = new FileInputStream(f);
			 pro=new Properties();
			pro.load(fis);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
