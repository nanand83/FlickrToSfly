package com.anand.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
 

@XmlRootElement(name="photo")
public class Photo {
 
   private long id;
 
   private String secret;
 
   private int server;
 
   private String title;
 
   private int isPrimary;
 
   private String url;
 
   public Photo() {
   }
 
   public long getId() {
      return this.id;
   }
 
  	@XmlAttribute(name="id")
   public void setId(long value) {
      this.id = value;
   }
 
   public String getSecret() {
      return this.secret;
   }
 
  	@XmlAttribute(name="secret")
   public void setSecret(String value) {
      this.secret = value;
   }
 
   public int getServer() {
      return this.server;
   }
 
  	@XmlAttribute(name="server")
   public void setServer(int value) {
      this.server = value;
   }
 
   public String getTitle() {
      return this.title;
   }
 
  	@XmlAttribute(name="title")
   public void setTitle(String value) {
      this.title = value;
   }
 
   public int getIsPrimary() {
      return this.isPrimary;
   }
 
  	@XmlAttribute(name="isPrimary")
   public void setIsPrimary(int value) {
      this.isPrimary = value;
   }
 
   public String getUrl() {
      return this.url;
   }
 
  	@XmlAttribute(name="url_o")
   public void setUrl(String value) {
      this.url = value;
   }
}