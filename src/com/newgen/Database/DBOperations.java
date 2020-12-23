package com.newgen.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.newgen.servlet.Logging;

public class DBOperations {
	public String Processname;
	public String State;
	public String UserRole;
	public String UserName;
	public String ProductName;
	public String Productcode;
	public String Productversion;
	public boolean status;
	Logging logObj = new Logging();

	public DBOperations() {
		this.status = false;
	}

	public String getValues(String sQuery) {
		String result = "";

		try {
			String helpStr = "";
			Connection conn = ConnectDB.getConnection();
			if (conn != null) {
				this.logObj.servicelog("-----Connection Establish successfully-----");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sQuery);
				this.logObj.servicelog("sQuery:" + sQuery);

				int rowIndex = 0;
				while (rs.next()) {
					helpStr = "";
					String rsData = rs.getString(rowIndex);
					
					if(rowIndex > 0) {
						helpStr += ",";
					}
					helpStr += rsData;
					rowIndex++;
				}

				if (helpStr != "") {
					result = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>\n" + "<Omniscan>\n"
							+ "<output>";

					result += helpStr + "</output>\n" + "<status>1</status>\n" + "<desc></desc>\n" + "</Omniscan>";
				} else {
					result = result + "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>\n" + "<Omniscan>\n"
							+ "<output></output>\n" + "<status>0</status>\n"
							+ "<desc>Record not found in database</desc>\n" + "</Omniscan>";
				}

			} else {
				result = result + "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>\n" + "<Omniscan>\n"
						+ "<output></output>\n" + "<status>0</status>\n" + "<desc>Unable to create connection</desc>\n" + "</Omniscan>";
			}

		} catch (Exception ex) {
			this.logObj.servicelog("Exception Inside getvalues=" + ex);
			ex.printStackTrace();
		}

		return result;
	}

	public String getDateFormat(String inputString, String currFormat, String formatToConvert) {
		String strDate = "";
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat(currFormat);
			SimpleDateFormat sdf2 = new SimpleDateFormat(formatToConvert);
			strDate = sdf2.format(sdf1.parse(inputString));
			this.logObj.servicelog("Converted Date format=" + strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			this.logObj.servicelog("Date format Exception=" + e.getMessage());
			e.printStackTrace();

		}

		return strDate;

	}

	public String postValues(String sQuery) {
		String result = "";

		try {
			Integer noOfrow = 0;
			Connection conn = ConnectDB.getConnection();
			if (conn != null) {
				Statement stmt = conn.createStatement();

				System.out.println("sQuery:" + sQuery);
				noOfrow = stmt.executeUpdate(sQuery);

				if (noOfrow > 0) {
					result = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>\n" + "<Omniscan>\n"
							+ "<output>";

					result += "</output>\n" + "<status>1</status>\n" + "<desc></desc>\n" + "</Omniscan>";
				} else {
					result = result + "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>\n" + "<Omniscan>\n"
							+ "<output></output>\n" + "<status>0</status>\n" + "<desc>Record Not Found.</desc>\n"
							+ "</Omniscan>";
				}

			} else {
				result = result + "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>\n" + "<Omniscan>\n"
						+ "<output></output>\n" + "<status>0</status>\n" + "<desc></desc>\n" + "</Omniscan>";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

}
