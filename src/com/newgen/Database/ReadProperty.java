/************************************************************************************
// NEWGEN SOFTWARE TECHNOLOGIES LIMITED
// Group	         :	CIG
// Product / Project     :	IMGC (OMNIDOCS).

/************************************************************************************
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 *
 * @author sapan.khandelwal
 */
public class ReadProperty {

    public static String getPropertyTagValue(String tag) {
        Properties propObject = read();
        if (propObject != null) {
            if (!(propObject.containsKey(tag))) {
                return "";
            } else {
                return propObject.getProperty(tag);
            }

        } else {
            return "";
        }
    }

    public static Properties read() {
       // String userDIR = System.getProperty("user.dir");
    	//String userDIR="C:\\newgen\\jboss-eap-7.0\\bin";
    	String userDIR="C:\\Users\\tprav\\Downloads\\Compressed\\REA Code\\Code";
        System.out.println("[USER DIRECTORY]::::::::::" + userDIR);
        Properties prop = new Properties();
        
        try {
          //  prop.load(new FileInputStream(userDIR + "//resource" + "//db.properties"));
            prop.load(new FileInputStream(userDIR + "\\resource" + "\\db.properties"));

        } catch (FileNotFoundException nfe) {
            //System.out.println(" \n\n### Properties file " + userDIR + "//resource//db.properties" + " NOT FOUND ");
            System.out.println(" \n\n### Properties file " + userDIR + "\\resource\\db.properties" + " NOT FOUND ");
            //WriteToLog.writeToLog("Properties file " + s + " not found\n" + "Exception in prperties file : " + nfe);
            return null;
        } catch (Exception e) {
            System.out.println(" \n\n###  **[Error]**  [Error in Properties file]::::"+e.getMessage());
          //Logger.writeToLog(3, " **[Error]**  [Error in Properties file]::::"+e.getMessage());

            return null;
        }
        return prop;
    }
}
