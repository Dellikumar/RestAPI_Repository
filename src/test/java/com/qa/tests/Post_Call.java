package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

import junit.framework.Assert;

public class Post_Call extends TestBase {
	
	
	
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
	@Test
	public void postCall() throws JsonGenerationException, JsonMappingException, IOException
	{
		restclient =new RestClient();
		HashMap<String, String> headermap=new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		
		//To create json payload by using jackson API
		ObjectMapper mapper = new ObjectMapper();
		Users users= new Users("morpheus","leader");
		
		//create json file
		mapper.writeValue(new File("D:\\Eclipse\\RestAutomation\\src\\main\\java\\com\\qa\\data\\users.json"), users);
		
		//object to json string
		String jsonstring = mapper.writeValueAsString(users);
		System.out.println(jsonstring);
		
		//call post method
		
		closablehttpresponse=restclient.post(url, jsonstring, headermap);
		
		//verifivcation odf status
		
		
		int statuscode = closablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("status code of POST call is ====> " + statuscode);
		
		Assert.assertEquals(statuscode, testbase.STATUS_HTTP_201);
		
		//to get response
		String StringResponse = EntityUtils.toString(closablehttpresponse.getEntity(), "UTF-8");
		//to convert json response
		
		JSONObject jsonresponse =new JSONObject(StringResponse);
		System.out.println("The JSON response from the server is " + jsonresponse);
		
		//convert json respons to object
		
		Users userResponseObj = mapper.readValue(StringResponse, Users.class);
		
		System.out.println(" response from server name is----> " + userResponseObj.getName());
		System.out.println(" response from server  job is---->" + userResponseObj.getJob());
		System.out.println("users class object name is =====> " +users.getName());
		System.out.println("user class object job is ===========> " +users.getJob());
		
		//Assertions
		
		Assert.assertEquals(userResponseObj.getName(), users.getName());
		System.out.println("=========>Assertion is perfectly executed==========>");
		
		
		
		
		
		
		
		
		
		
		
	}

}
