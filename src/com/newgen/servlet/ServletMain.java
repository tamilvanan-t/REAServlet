package com.newgen.servlet;

import com.newgen.Database.DBOperations;
import com.newgen.Database.ReadProperty;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMain extends HttpServlet {
	Logging logObj = new Logging();
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException
			  {
			    response.setContentType("application/xml");
			    PrintWriter out = response.getWriter();
			    String templateName = request.getParameter("templateName");
			    String empId = request.getParameter("Employee_ID");
			    String sQuery="",selectQuery="";
			    String columnName="",whereColName="";
			    
			    System.out.println("Variable: " + empId);
			    System.out.println("Template: " + templateName);
//			    try
//			    {
//			    if (templateName.contentEquals("Employee"))
//			    	{
//			    	this.logObj.servicelog("*****Inside Employee Template*****");
//			    	columnName=ReadProperty.getPropertyTagValue("Tablecol");
//			    	this.logObj.servicelog("*****Table Column Name="+columnName);
//			    	selectQuery= ReadProperty.getPropertyTagValue("selectQuery");
//			    	this.logObj.servicelog("*****Select Query="+selectQuery);
//			    	whereColName=ReadProperty.getPropertyTagValue("whereColName");
//			    	this.logObj.servicelog("*****Where Column Name="+whereColName);
//			    	sQuery = selectQuery + " where "+whereColName+"='" + empId + "'";
//			    	 this.logObj.servicelog("sQuery=" + sQuery);
//			    	}
//			      this.logObj.servicelog("***Establishing connection starts*****");
//			      DBOperations operations = new DBOperations();
//			      String responseXml = operations.getValues(sQuery,columnName);
//			      out.print(responseXml);
//			      this.logObj.servicelog("responseXml=" + responseXml);
//			    }
//			    catch (Exception e)
//			    {
//			    	 this.logObj.servicelog("Exception inside Servlet main="+e.getMessage());
//			    }
			  }
	/* protected void UpdateStatus(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException
			  {
			    response.setContentType("application/xml");
			    PrintWriter out = response.getWriter();

			    String templateName = request.getParameter("templateName");
			    String PO_Number = request.getParameter("PO_Number");
			    String SAP_Field_1 = request.getParameter("SAP_Field_1");
			    String SAP_Field_2 = request.getParameter("SAP_Field_2");
			    String Sales_Invoice_Number = request.getParameter("Sales_Invoice_Number");
			    String sQuery="";
			    try
			    {
			    	if (templateName.contentEquals("AP"))
			    	{
			    	 sQuery = "Update ST_AP set SAP_Field_1='"+SAP_Field_1+"',SAP_Field_2='"+SAP_Field_2+"', ExportedDate=getdate(), ExportStatus='Exported' where PO_Number='"+PO_Number+"'";
			    	}
			    	else if(templateName.contentEquals("AP_Payment"))
			    	{
			    		sQuery = "Update ST_AP_PAYMENT set ExportedDate=getdate(), ExportStatus='Exported' where PO_Number='"+PO_Number+"'";
			    		
			    	}
			    	else if(templateName.contentEquals("AR"))
			    	{
			    		sQuery = "Update ST_AR set ExportedDate=getdate(), ExportStatus='Exported' where Sales_Invoice_Number='"+Sales_Invoice_Number+"'";
			    		
			    	}
			    	else if(templateName.contentEquals("AR_Receipt"))
			    	{
			    		
			    		sQuery = "Update ST_AR_Receipt set ExportedDate=getdate(), ExportStatus='Exported' where Sales_Invoice_Number='"+Sales_Invoice_Number+"'";
			    	}
			    	
			    	DBOperations operations = new DBOperations();
				      String responseXml = operations.postValues(sQuery);
				       out.print(responseXml); 
			      
			    }
			    catch (Exception e)
			    {
			    }
			  }*/

			  protected void doGet(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException
			  {
			   processRequest(request, response);
			 }

			  protected void doPost(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException
			  {
				 // UpdateStatus(request, response);
			  }

			  public String getServletInfo()
			  {
			    return "Short description";
			  }
}
