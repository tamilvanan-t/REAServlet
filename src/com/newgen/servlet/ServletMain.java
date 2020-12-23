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
			throws ServletException, IOException {
		response.setContentType("application/xml");
		PrintWriter out = response.getWriter();
		String process = request.getParameter("process");
		String lineNo = request.getParameter("lineNo");
		String machineName = request.getParameter("machineName");
		String machineDrwaing = request.getParameter("machineDrwaing");

		System.out.println("process: " + process);
		System.out.println("lineNo: " + lineNo);
		System.out.println("machineName: " + machineName);
		System.out.println("machineDrwaing: " + machineDrwaing);

		String sQuery = "", selectQuery = "";
		String columnName = "", whereColName = "";

		String responseXml = ProcessRequest.processRequest(process, lineNo, machineName, machineDrwaing);
		
		out.print(responseXml);
		this.logObj.servicelog("responseXml=" + responseXml);
		try {
			this.logObj.servicelog("*****Inside Employee Template*****");
			columnName = ReadProperty.getPropertyTagValue("Tablecol");
			this.logObj.servicelog("*****Table Column Name=" + columnName);
			selectQuery = ReadProperty.getPropertyTagValue("selectQuery");
			this.logObj.servicelog("*****Select Query=" + selectQuery);
			whereColName = ReadProperty.getPropertyTagValue("whereColName");
			this.logObj.servicelog("*****Where Column Name=" + whereColName);
			sQuery = selectQuery + " where " + whereColName + "='" + empId + "'";
			this.logObj.servicelog("sQuery=" + sQuery);
			this.logObj.servicelog("***Establishing connection starts*****");
			
		} catch (Exception e) {
			this.logObj.servicelog("Exception inside Servlet main=" + e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UpdateStatus(request, response);
	}

	public String getServletInfo() {
		return "Short description";
	}
}
