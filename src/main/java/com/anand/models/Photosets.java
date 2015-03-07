package com.anand.models;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlRootElement(name="photosets")
public class Photosets {
  private List<Photoset> photosets;
  
  @XmlElement(name="photoset")
  public void setPhotosets(List<Photoset> photosets) {
    this.photosets = photosets;
  }
  
  public List<Photoset> getPhotosets() {
    return photosets;
  }
  
  public Photosets() {
    super();
  }
}
