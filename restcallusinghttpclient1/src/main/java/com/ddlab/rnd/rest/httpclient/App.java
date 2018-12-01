package com.ddlab.rnd.rest.httpclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	String url = "http://localhost:8080/cookiebasedspringrestauth2/j_spring_security_check?j_username=d&j_password=d";
    	 
//    	HttpClient client = HttpClientBuilder.create().build();
//    	HttpPost post = new HttpPost(url);
//    	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//    	post.setEntity(new UrlEncodedFormEntity(urlParameters));
//    	HttpResponse response = client.execute(post);
//    	System.out.println("Response Code : " 
//                    + response.getStatusLine().getStatusCode());
//     
//    	BufferedReader rd = new BufferedReader(
//    	        new InputStreamReader(response.getEntity().getContent()));
//     
//    	StringBuffer result = new StringBuffer();
//    	String line = "";
//    	while ((line = rd.readLine()) != null) {
//    		result.append(line);
//    	}
//    	System.out.println(result);
    	
    	CloseableHttpClient httpclient = HttpClients.createDefault();
    	HttpPost httpPost = new HttpPost(url);
    	List <NameValuePair> nvps = new ArrayList <NameValuePair>();
//    	nvps.add(new BasicNameValuePair("username", "vip"));
//    	nvps.add(new BasicNameValuePair("password", "secret"));
//    	httpPost.setEntity(new UrlEncodedFormEntity(nvps));
    	CloseableHttpResponse response2 = httpclient.execute(httpPost);

    	try {
    	    System.out.println("--->"+response2.getStatusLine());
    	    HttpEntity entity2 = response2.getEntity();
    	    // do something useful with the response body
    	    // and ensure it is fully consumed
    	    EntityUtils.consume(entity2);
    	} finally {
    	    response2.close();
    	}
    	
    	
    	
    	
    	
    }
}
