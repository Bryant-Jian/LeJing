package com.lejing.renshi.util;

import org.apache.http.entity.StringEntity;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class HttpUtil {
	
	private static AsyncHttpClient client = new AsyncHttpClient(); 
	
	static {
		client.setTimeout(51000); 
	}

	public static void get(String urlString, AsyncHttpResponseHandler res) 
	{
		client.get(urlString, res);
	}

	public static void get(String urlString, RequestParams params,
			AsyncHttpResponseHandler res)
	{
		client.get(urlString, params, res);
	}
	
	public static void post(String urlString, RequestParams params,
			AsyncHttpResponseHandler res) 
	{
		client.post(urlString, params, res);
	}
	
	public static void post(Context context, String url, StringEntity entity, AsyncHttpResponseHandler res){
		client.post(context, url, entity, "application/json", res);
	}

	public static void get(String urlString, JsonHttpResponseHandler res) 
	{
		client.get(urlString, res);
	}

	public static void get(String urlString, RequestParams params,
			JsonHttpResponseHandler res) 
	{
		client.get(urlString, params, res);
	}

	public static void get(String uString, BinaryHttpResponseHandler bHandler) 
	{
		client.get(uString, bHandler);
	}

	public static AsyncHttpClient getClient() {
		return client;
	}
}
