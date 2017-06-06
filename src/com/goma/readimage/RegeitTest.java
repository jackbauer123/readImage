package com.goma.readimage;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
public class RegeitTest {
	public static void main(String[] args) {
		DefaultHttpClient  httpclient = new DefaultHttpClient();
		HttpGet getMethod = new HttpGet("http://www.gxwzgjj.com/GetCode1.asp");
		//HttpPost httpost=new HttpPost("http://www.myrainbow.cn/Member/Register.do");
		String sessionId="";
		    try {
			    String yzm = ""; 
		        HttpResponse response = httpclient.execute(getMethod);
		       /* Header headers[] = response.getAllHeaders();
		        int ii = 0;
		        while (ii < headers.length) {
		            if(headers[ii].getName().equals("Set-Cookie"))
		            	sessionId=headers[ii].getValue().substring(headers[ii].getValue().indexOf("=")+1,headers[ii].getValue().indexOf(";"));
		            ++ii;
		        } 
		        List<Cookie> cookies = httpclient.getCookieStore().getCookies();
		        if (cookies.isEmpty()) {
		            System.out.println("None");
		        } else {
		            for (int i = 0; i < cookies.size(); i++) {
		                System.out.println("- " + cookies.get(i).toString());
		            }
		        }*/
		        HttpEntity entity = response.getEntity();
		   
			    if (entity != null) {   
			        InputStream instream = entity.getContent();
				    BufferedImage bi = ImageIO.read(instream);
				   
				    yzm = ImageRead.read(bi,1);
				    System.out.println(yzm+"-----------------------------");
				   /* List <NameValuePair> nvps = new ArrayList <NameValuePair>();
			        nvps.add(new BasicNameValuePair("parentId", null));
			        nvps.add(new BasicNameValuePair("userMID", "0"));
			        nvps.add(new BasicNameValuePair("returnUrl", null));
				    nvps.add(new BasicNameValuePair("Email", "robert0001@163.com"));
			        nvps.add(new BasicNameValuePair("loginId", "robert0001"));
			        nvps.add(new BasicNameValuePair("password", "robert0001"));
			        nvps.add(new BasicNameValuePair("validateCode", yzm));
			        httpost.setEntity(new UrlEncodedFormEntity(nvps));
			        response = httpclient.execute(httpost);
			        HttpEntity entity1 = response.getEntity();
			       if (entity1 != null) {
			        System.out.println("Response content: "  
			                    + inputStream2String(entity1.getContent()));*/   
				    instream.close();
			       }
			      
			      
			   // }
			   
		    } catch (Exception e) {
			    e.printStackTrace();
		    }
		 finally {  
		// httpost.abort();  
		 getMethod.abort();
     }  
	    
	}
	
	 public static String inputStream2String(InputStream is) throws IOException {   
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();   
	        int i = -1;   
	        while ((i = is.read()) != -1) {   
	            baos.write(i);   
	        }   
	        return baos.toString();   
	    }   

	
}
