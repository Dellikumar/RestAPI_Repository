package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.qa.base.TestBase;

public class RestClient extends TestBase{
	//without headers
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException
	{
		//to create client
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		//client hit the GET method
		CloseableHttpResponse closablehttpresponse = httpClient.execute(httpget);
		
		return closablehttpresponse;
    }
	
	//with headers
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
}
