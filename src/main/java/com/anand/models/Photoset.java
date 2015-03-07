package com.anand.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
 
import java.util.*;

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
 
   public int getPhotoCount() {
      return this.photoCount;
   }
 
  	@XmlAttribute(name="photos")
   public void setPhotoCount(int value) {
      this.photoCount = value;
   }
 
   public int getVideoCount() {
      return this.videoCount;
   }
 
  	@XmlAttribute(name="videos")
   public void setVideoCount(int value) {
      this.videoCount = value;
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
  
  	public List<Photo> getPhotos(){
     	return photos;
   }
  	
  	@XmlElement(name="photo")
  	public void setPhotos(List<Photo> photos) {
     	this.photos = photos;
   }
}