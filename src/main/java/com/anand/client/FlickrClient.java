package com.anand.client;

import com.anand.models.*;
import com.anand.utils.*;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;

public class FlickrClient {
  	private String apiKey = "0fd992b0fff19e803daec389405acf52";
  	private String apiSecret = "dd718bff9c133771";
  
  	private OAuthService service = null;
  	private DBUtils dbUtils = null;
  
	public FlickrClient() {
		service = new ServiceBuilder()
                                .provider(FlickrApi.class)
                                .apiKey(apiKey)
                                .apiSecret(apiSecret)
                                .build();
		dbUtils = new DBUtils();     
   }
  
  	public Token getTokenValue(String tokenType) {
     	boolean doesTokenExist = dbUtils.doesTokenExist(tokenType);
     	Token token = null;
     	try {
        if (doesTokenExist) {
				token = (Token)dbUtils.getTokenValue(tokenType);
        }  else {
				System.out.println("Token of type "+tokenType+" does not exist in Db");
          	System.exit(0);
        }
      } catch (Exception e) {
        	System.out.println("Exception while retrieving token value from Db");
        	e.printStackTrace();
      }
     
     return token;
   } 
  
  
  	public String getResponseFromApi(String method) {
     return "";
   }
  
  	public Photosets getPhotosetsFromResponse(String response) {
     return null;
   }
  
  	public void printPhotoUrls(String albumName) {
     
     
   }
  
  	public static void main(String args[]) {
     FlickrClient client = new FlickrClient();
     client.printPhotoUrls("Vidushi Namakaranam");
   }
  
}

