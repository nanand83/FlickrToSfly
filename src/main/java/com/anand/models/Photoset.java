package com.anand.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
 

@XmlRootElement(name="photoset")
public class Photoset {
 
   private long id;
 
   private long primary;
 
   private String secret;
 
   private long server;
 
   private int farm;
 
   private int photoCount;
 
   private int videoCount;
  
  	private String title;
  
  	private String description;
 
  	private List<Photo> photos;
  
   public Photoset() {
   }
 
   public long getId() {
      return this.id;
   }
 
  	@XmlAttribute(name="id")
   public void setId(long value) {
      this.id = value;
   }
 
   public long getPrimary() {
      return this.primary;
   }
 
  	@XmlAttribute(name="primary")
   public void setPrimary(long value) {
      this.primary = value;
   }
 
   public String getSecret() {
      return this.secret;
   }
 
  	@XmlAttribute(name="secret")
   public void setSecret(String value) {
      this.secret = value;
   }
 
   public long getServer() {
      return this.server;
   }
 
  	@XmlAttribute(name="server")
   public void setServer(long value) {
      this.server = value;
   }
 
   public int getFarm() {
      return this.farm;
   }
 	
  	@XmlAttribute(name="farm")
   public void setFarm(int value) {
      this.farm = value;
   }
 
   public int getPhotos() {
      return this.photos;
   }
 
  	@XmlAttribute(name="photos")
   public void setPhotos(int value) {
      this.photos = value;
   }
 
   public int getVideos() {
      return this.videos;
   }
 
  	@XmlAttribute(name="videos")
   public void setVideos(int value) {
      this.videos = value;
   }
     public String getTitle() {
      return this.title;
   }
 
  	@XmlElement(name="title")
   public void setTitle(String value) {
      this.title = value;
   }
 
   public String getDescription() {
      return this.description;
   }
 
  	@XmlElement(name="description")
   public void setDescription(String value) {
      this.description = value;
   }
}