/**
 * 
 */
package com.ddlab.rnd.rest.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String url = "http://localhost:8080/cookiebasedspringrestauth2/j_spring_security_check?j_username=d&j_password=d";
		HttpPost post = new HttpPost(url);
		
//		HttpClient client = new DefaultHttpClient();
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(post);
		
		Header[] headers = response.getHeaders("Set-Cookie");
		for (Header h : headers) {
		    System.out.println(h.getValue().toString());  
		}
		
		System.out.println("-------------------");
		
//		Header[] headers1 = response.getAllHeaders();
//		for (Header h : headers1) {
//		    System.out.println(h.getValue().toString());  
//		}
		
		
		url = "http://localhost:8080/cookiebasedspringrestauth2/api/bankapi/withdraw/12345/500";
		
		HttpGet get = new HttpGet(url);
		
		HttpResponse response1 = client.execute(get);
		System.out.println("Response :::"+response1);
		
		HttpEntity entity = response1.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		System.out.println("===========>"+responseString);
		
		
	}

}
