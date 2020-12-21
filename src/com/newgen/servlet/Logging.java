package com.newgen.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Logging implements Serializable
{
  public void servicelog(String strLog)
  {
    try
    {
      File objDirs = null;
      String user_dir = System.getProperty("user.dir");
      String sLogFilePath = user_dir + System.getProperty("file.separator") + "DBLogs";

      objDirs = new File(sLogFilePath);
      objDirs.mkdirs();
      GregorianCalendar cal = new GregorianCalendar();
      int logcount = 0;
      sLogFilePath = sLogFilePath + System.getProperty("file.separator") + "CustomPurgeUtil_" + cal.get(5) + "-" + (cal.get(2) + 1) + "-" + cal.get(1) + "_" + logcount + ".log";

      File logfile = new File(sLogFilePath);
      if (logfile.length() > 5242880L) {
        logcount++;
      }

      FileOutputStream fos = new FileOutputStream(sLogFilePath, true);
      PrintWriter pw = new PrintWriter(fos);
      pw.println("................................................................");
      pw.print(new Date() + "  ");
      pw.println(strLog);

      pw.close();
    } catch (Exception ex) {
      System.out.println("Error in creating log " + ex.getMessage());
    }
  }

  public void CBCServicelog(String strLog)
  {
    try
    {
      File objDirs = null;
      String user_dir = System.getProperty("user.dir");
      String sLogFilePath = user_dir + System.getProperty("file.separator") + "LOS_Custom_Logs" +System.getProperty("file.separator")+"CBC";

      objDirs = new File(sLogFilePath);
      objDirs.mkdirs();
      GregorianCalendar cal = new GregorianCalendar();
      int logcount = 0;
      sLogFilePath = sLogFilePath + System.getProperty("file.separator") + "CBCUtil_" + cal.get(5) + "-" + (cal.get(2) + 1) + "-" + cal.get(1) + "_" + logcount + ".log";

      File logfile = new File(sLogFilePath);
      if (logfile.length() > 5242880L) {
        logcount++;
      }

      FileOutputStream fos = new FileOutputStream(sLogFilePath, true);
      PrintWriter pw = new PrintWriter(fos);
      pw.println("................................................................");
      pw.print(new Date() + "  ");
      pw.println(strLog);

      pw.close();
    } catch (Exception ex) {
      System.out.println("Error in creating log " + ex.getMessage());
    }
  }

}