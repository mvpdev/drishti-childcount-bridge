package org.ei.drishti.utils;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class ChildcountBridge{
	
	private String url;
	private String message;
	private String chw;
	private String edate;
	private String identity;

	public ChildcountBridge( String identity, String message, String chw, String edate){
		
		this.message = message;
		this.edate = edate;
		this.chw = chw;
		this.identity = identity;
		
	}
	
	public void submitPost(){
			
        DefaultHttpClient httpClient = new DefaultHttpClient();
        
	    try {
			HttpPost postRequest = new HttpPost("http://localhost:80/dataentry/commcare/");
	 
	            List <NameValuePair> ccstring = new ArrayList <NameValuePair>();
	            ccstring.add(new BasicNameValuePair("identity", identity));
	            //ccstring.add(new BasicNameValuePair("chw", chw));
	            //ccstring.add(new BasicNameValuePair("edate", "2012-02-12"));
	            ccstring.add(new BasicNameValuePair("message", message));

	            postRequest.setEntity(new UrlEncodedFormEntity(ccstring, HTTP.UTF_8));
	            
			    HttpResponse response = httpClient.execute(postRequest);
	 
			if (response.getStatusLine().getStatusCode() != 200) {
			  new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
				//create logger
			}
	 
			BufferedReader br = new BufferedReader(
	                        new InputStreamReader((response.getEntity().getContent())));
	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 
			httpClient.getConnectionManager().shutdown();
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		  finally {
	        // When HttpClient instance is no longer needed,
	        // shut down the connection manager to ensure
	        // immediate deallocation of all system resources
			httpClient.getConnectionManager().shutdown();
	    }
		
	}
	
	
}



