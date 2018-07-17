package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.qa.base.TestBase;

public class RestClient extends TestBase{
	
	public void get(String url) throws ClientProtocolException, IOException
	{
		//to create client
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		CloseableHttpResponse closablehttpresponse = httpClient.execute(httpget);
		
		//to get response code
		int statuscode = closablehttpresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		
		//to get response string
		
		String stringResponse = EntityUtils.toString(closablehttpresponse.getEntity(), "UTF-8");
		System.out.println("Normal string response ---->" + stringResponse);
		
		//convert normal response to JSONObject
		
		JSONObject jsonresponse =new JSONObject(stringResponse);
		
		System.out.println("json response ---->" + jsonresponse);
		
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
