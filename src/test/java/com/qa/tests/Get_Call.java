package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class Get_Call extends TestBase {
	TestBase testbase;
	 RestClient restclient;
	 String url;
	@BeforeMethod
	public void setUp()
	{
		 testbase= new TestBase();
		
		 url=pro.getProperty("serviceURL")+pro.getProperty("apiURL");
		
	}
	@Test
	public void test() throws ClientProtocolException, IOException
	{
		 restclient=new RestClient();
		restclient.get(url);
	}

}
