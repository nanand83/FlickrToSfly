package com.anand.utils;

import com.anand.models.*;
import java.util.*;
import javax.xml.stream.*;
import javax.xml.bind.*;
import java.io.*;

public class XmlUtils {
  public static List<Photoset> unmarshalPhotosets(String photosetsResponse) {
    XMLInputFactory xif = XMLInputFactory.newInstance();
    List<Photoset> photosetList = new ArrayList<Photoset>();
    try {
      XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(photosetsResponse));
      xsr.nextTag();
      xsr.nextTag();
      JAXBContext jaxbContext = JAXBContext.newInstance(Photosets.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Photosets photosets = (Photosets) jaxbUnmarshaller.unmarshal(xsr);
      photosetList = photosets.getPhotosets();
    } catch (Exception e) {
      System.out.println("Exception while unmarshalling photosets response");
      e.printStackTrace();
    }
    return photosetList;

  }
  
  
  public static List<Photo> unmarshalPhotos(String photoResponse) {
    XMLInputFactory xif = XMLInputFactory.newInstance();
    List<Photo> photos = new ArrayList<Photo>();
    try {
      XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(photoResponse));
      xsr.nextTag();
      xsr.nextTag();
      JAXBContext jaxbContext = JAXBContext.newInstance(Photoset.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Photoset photoset = (Photoset) jaxbUnmarshaller.unmarshal(xsr);
      photos = photoset.getPhotos();
    } catch (Exception e) {
      System.out.println("Exception while unmarshalling photo response");
      e.printStackTrace();
    }
    return photos;
  }
  
}
