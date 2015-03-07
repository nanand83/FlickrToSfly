package com.anand.client;

import com.anand.models.*;
import com.anand.utils.*;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;

import java.util.*;

public class FlickrClient {
  	private static final String apiKey = "0fd992b0fff19e803daec389405acf52";
  	private static final String apiSecret = "dd718bff9c133771";
  
  	private static final String PROTECTED_RESOURCE_URL = "https://api.flickr.com/services/rest/";
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
  
  
  	public String getResponseFromApi(String method, Map<String, Object> paramMap) {
     	OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
      request.addQuerystringParameter("method", method);
     	if (paramMap!=null) {
        for (String key : paramMap.keySet()) {
           request.addQuerystringParameter(key, String.valueOf(paramMap.get(key)));
        }
      }
     	
      service.signRequest(getTokenValue("accessToken"), request);
      Response response = request.send();
      //System.out.println(response.getBody());
      return response.getBody();
   }
  
  	public List<Photoset> getPhotosets() {
     	String photosetsResponse = "";
     	List<Photoset> photosets = new ArrayList<Photoset>();
     	try {
			photosetsResponse = getResponseFromApi("flickr.photosets.getList", null);
        	photosets = XmlUtils.unmarshalPhotosets(photosetsResponse);
      } catch(Exception e) {
        	System.out.println("Exception while getting response from flickr api- getList");
        	e.printStackTrace();
      }
     	return photosets;
   }
                          
   public List<Photo> getPhotos(Photoset photoset) {
     	String photosResponse = "";
     	List<Photo> photos = new ArrayList<Photo>();
      try {
        	Map<String, Object> paramMap = new HashMap<String, Object>();
        	paramMap.put("photoset_id", photoset.getId());
        	paramMap.put("extras", "url_o");
         photosResponse = getResponseFromApi("flickr.photosets.getPhotos", paramMap);
        	//System.out.println(photosResponse);
         photos = XmlUtils.unmarshalPhotos(photosResponse);
       } catch(Exception e) {
         System.out.println("Exception while getting response from flickr api- getPhotos");
         e.printStackTrace();
      }
      return photos;
   }
  
  	public void printPhotoUrls(String albumName) {
     	System.out.println("Inspecting all albums for a match");
     	for (Photoset set : getPhotosets()) {
        	if (set.getTitle().equalsIgnoreCase(albumName)) {
           System.out.println("Match found!! Now getting photo URLs");
           for (Photo photo : getPhotos(set)) {
             System.out.println("Photo :"+photo.getId()+", URL: "+photo.getUrl());
           }
         }
      }
     
   }
  
  	public static void main(String args[]) {
     FlickrClient client = new FlickrClient();
     client.printPhotoUrls("Vidushi Namakaranam");
   }
  
}

