package com.anand.utils;

import java.sql.*;
import java.net.*;
import java.io.*;

public class DBUtils {
  private static final String DATABASE_URL = "postgres://obsyetawdctbrh:KG6i6SyYHjXaPHYWQfNqkm2imb@ec2-54-204-39-187.compute-1.amazonaws.com:5432/dbcokog704adr7";
  
  public DBUtils() {
    super();
  }
  
  private static Connection getConnection() throws URISyntaxException, SQLException {
    URI dbUri = new URI(DATABASE_URL);

    String username = dbUri.getUserInfo().split(":")[0];
    String password = dbUri.getUserInfo().split(":")[1];
    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

    return DriverManager.getConnection(dbUrl, username, password);
    
  }
  
  public boolean doesTokenExist(String tokenType)  {
    boolean doesTokenExist = false;
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;
    
    try {
    	conn = getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT COUNT(*) FROM Tokens where type='"+tokenType+"'");
      if (rs.next()) {
        doesTokenExist = rs.getInt(1) == 1 ? true : false;
      }
    } catch (Exception e) {
      System.out.println("Exception while checking if token exists in db or not");
      e.printStackTrace();
    } finally {
      try {
        if (rs != null) {
           rs.close();
        }
        if (stmt != null) {
           stmt.close();
        }
        if (conn != null) {
           conn.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    return doesTokenExist;
  }
  
  public byte[] getTokenValueBytes(String tokenType) {
    byte[] tokenValueBytes = null;
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;
    
    try {
    	conn = getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT Value FROM Tokens where type='"+tokenType+"'");
      if (rs.next()) {
        tokenValueBytes = rs.getBytes(1);
      }
    } catch (Exception e) {
      System.out.println("Exception while getting token value of type "+tokenType);
      e.printStackTrace();
    } finally {
      try {
        if (rs != null) {
           rs.close();
        }
        if (stmt != null) {
           stmt.close();
        }
        if (conn != null) {
           conn.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    return tokenValueBytes;
  }
  
  public Object getTokenValue(String tokenType) {
    Object token = null;
    
    byte[] tokenBytes = getTokenValueBytes(tokenType);
    if (tokenBytes!= null) {
      try {
      	token = deserialize(tokenBytes);
      } catch (Exception e) {
        	System.out.println("Exception while deserializing bytes");
        	e.printStackTrace();
      }
    }
    return token;
  }
  
  public Object deserialize(byte[] inputBytes) throws IOException, ClassNotFoundException {
    ByteArrayInputStream bais = new ByteArrayInputStream(inputBytes);
    ObjectInputStream ois = new ObjectInputStream(bais);
    return ois.readObject();
  }
}
