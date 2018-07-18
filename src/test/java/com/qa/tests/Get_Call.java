package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

public class Get_Call extends TestBase {
	TestBase testbase;
	 RestClient restclient;
	 String url;
	 CloseableHttpResponse closablehttpresponse;
	@BeforeMethod
	public void setUp()
	{
		 testbase= new TestBase();
		
		 url=pro.getProperty("serviceURL")+pro.getProperty("apiURL");
		
	}
	@Test(priority=1)
	public void testWithOutHeaders() throws ClientProtocolException, IOException
	{
		 restclient=new RestClient();
		 closablehttpresponse=restclient.get(url);
		
		//to get response code
		int statuscode = closablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("The status code from json response is " +statuscode);
		
		Assert.assertEquals(statuscode, testbase.STATUS_HTTP_200);
		System.out.println("======Assertion for status cose passed=========");
		
		//to get response string
		
		String stringResponse = EntityUtils.toString(closablehttpresponse.getEntity(), "UTF-8");
		System.out.println("Normal string response ---->" + stringResponse);
		
		//convert normal response to JSONObject
		
		JSONObject jsonresponse =new JSONObject(stringResponse);
		
		System.out.println("json response ====>>" + jsonresponse);
		
		//parse json response object for getting simple JSON Object
		String per_Page=TestUtil.getValueByJPath(jsonresponse, "/per_page");
		System.out.println("The value of per page is =====>> " + per_Page);
		Assert.assertEquals(Integer.parseInt(per_Page), 3);
		
		String totalValue=TestUtil.getValueByJPath(jsonresponse, "/total");
		System.out.println("The total value is ======> " + totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		////parse json response object for getting data from JSON Array
		String lastname=TestUtil.getValueByJPath(jsonresponse, "/data[0]/last_name");
		System.out.println("The last name in JSON ARRAY of 0th index is====> " + lastname);
		//to get all headers
		Header[] allheaders = closablehttpresponse.getAllHeaders();
		
		HashMap<String, String> hashmap=new HashMap<String, String>();
		
		for(Header properheader:allheaders)
		{
              hashmap.put(properheader.getName(), properheader.getValue());
		}
		
		System.out.println("The header values are =====>" +hashmap);
		
 	}
	
	@Test(priority=2)
	public void testWithHeaders() throws ClientProtocolException, IOException
	{
		 restclient=new RestClient();
		 
		 HashMap<String, String> headermap =new HashMap<String, String>();
		 headermap.put("Content-Type", "application/json");
		 
		 /*headermap.put("username", "delli");
		 headermap.put("user_Auth", "test@12345");*/
		 
		 closablehttpresponse=restclient.get(url,headermap);
		
		//to get response code
		int statuscode = closablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("The status code from json response is " +statuscode);
		
		Assert.assertEquals(statuscode, testbase.STATUS_HTTP_200);
		System.out.println("======Assertion for status cose passed=========");
		
		//to get response string
		
		String stringResponse = EntityUtils.toString(closablehttpresponse.getEntity(), "UTF-8");
		System.out.println("Normal string response ---->" + stringResponse);
		
		//convert normal response to JSONObject
		
		JSONObject jsonresponse =new JSONObject(stringResponse);
		
		System.out.println("json response ====>>" + jsonresponse);
		
		//parse json response object for getting simple JSON Object
		String per_Page=TestUtil.getValueByJPath(jsonresponse, "/per_page");
		System.out.println("The value of per page is =====>> " + per_Page);
		Assert.assertEquals(Integer.parseInt(per_Page), 3);
		
		String totalValue=TestUtil.getValueByJPath(jsonresponse, "/total");
		System.out.println("The total value is ======> " + totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		////parse json response object for getting data from JSON Array
		String lastname=TestUtil.getValueByJPath(jsonresponse, "/data[0]/last_name");
		System.out.println("The last name in JSON ARRAY of 0th index is====> " + lastname);
		//to get all headers
		Header[] allheaders = closablehttpresponse.getAllHeaders();
		
		HashMap<String, String> hashmap=new HashMap<String, String>();
		
		for(Header properheader:allheaders)
		{
              hashmap.put(properheader.getName(), properheader.getValue());
		}
		
		System.out.println("The header values are =====>" +hashmap);
		
 	}
 
 
	}


