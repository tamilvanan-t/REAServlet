package com.newgen.Database;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.newgen.servlet.Logging;

public class ConnectDB {
	private static Connection dbConnection = null;
	 Logging logObj = new Logging();
	 
	  public static Connection getConnection() {
	    if (dbConnection != null)
	      return dbConnection;
	    try
	    {
	     //InputStream inputStream = ConnectDB.class.getClassLoader().getResourceAsStream("db.properties");
	    	
	     // Properties properties = new Properties();
	     // if (properties != null) {
	     //   properties.load(inputStream);

	        String dbDriver = ReadProperty.getPropertyTagValue("dbDriver");
	        String connectionUrl = ReadProperty.getPropertyTagValue("connectionUrl");

	        String userName = ReadProperty.getPropertyTagValue("userName");
	        String password = ReadProperty.getPropertyTagValue("password");
	        //String password = properties.getProperty("password");
	        Class.forName(dbDriver).newInstance();
	        dbConnection = DriverManager.getConnection(connectionUrl, userName, password);
	        
	     // }
	    }
	    catch (Exception e) {
	    	System.out.println(e);
	      e.printStackTrace();
	    }
	    return dbConnection;
	  }
}
