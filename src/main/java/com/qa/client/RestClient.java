package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.qa.base.TestBase;

public class RestClient extends TestBase{
	//without headers GET call
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException
	{
		//to create client
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		//client hit the GET method
		CloseableHttpResponse closablehttpresponse = httpClient.execute(httpget);
		
		return closablehttpresponse;
    }
	
	//with headers GET Call
	public CloseableHttpResponse get(String url ,HashMap<String, String> headermap) throws ClientProtocolException, IOException
	{
		//to create client
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		
		for(Entry<String, String> entry:headermap.entrySet())
		{
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		//client hit the GET method
		CloseableHttpResponse closablehttpresponse = httpClient.execute(httpget);
		
		return closablehttpresponse;
    }
	
	//with headers POST call
	
	public CloseableHttpResponse post(String url ,String entityString ,HashMap<String, String> headermap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost= new HttpPost(url);
		
		//To create payload
		
		httppost.setEntity( new StringEntity(entityString));
		
		for( Entry<String, String> entry:headermap.entrySet())
		{
			httppost.addHeader(entry.getKey(), entry.getValue());
		}
		
		
		CloseableHttpResponse closablehttpresponse = httpclient.execute(httppost);
	    
		return closablehttpresponse;
	
	}
	
	
	
	
	
	
	
	
}
