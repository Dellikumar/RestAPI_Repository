package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class TestBase {
	
	public static Properties pro;
	
	
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
