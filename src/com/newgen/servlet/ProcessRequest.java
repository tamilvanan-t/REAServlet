package com.newgen.servlet;

import com.newgen.Database.DBOperations;
import com.newgen.Database.ReadProperty;

public class ProcessRequest {
	private static String processG;
	private static String lineNoG;
	private static String machineNameG;
	private static String machineDrwaingG;
	
	private static final String LINE_NO 		= "LineNo";
	private static final String MACHINE_NAME 	= "MachineName";
	private static final String MACHINE_DRWAING = "MachineDrwaing";
	private static final String SUB_FOLDER 		= "SubFolder";

	private static String identifyField(String process, String  lineNo, String  machineName, String  machineDrwaing) {
		String field = null;
		
		if(!processG.equalsIgnoreCase(process)) {
			field = LINE_NO;
		} else if(processG.equalsIgnoreCase(process)
				&& !lineNoG.equalsIgnoreCase(lineNo)) {
			field = MACHINE_NAME;
		} else if(processG.equalsIgnoreCase(process)
				&& lineNoG.equalsIgnoreCase(lineNo)
				&& !machineNameG.equalsIgnoreCase(machineName)) {
			field = MACHINE_DRWAING;
		} else if(processG.equalsIgnoreCase(process)
				&& lineNoG.equalsIgnoreCase(lineNo)
				&& machineNameG.equalsIgnoreCase(machineName)
				&& !machineDrwaingG.equalsIgnoreCase(machineDrwaing)) {
			field = SUB_FOLDER;
		}
		
		processG = process;
		lineNoG = lineNo;
		machineNameG = machineName;
		machineDrwaingG = machineDrwaing;
		
		return field;
	}
	
	public static String processRequest(String process, String  lineNo, String  machineName, String  machineDrwaing) {
		String field = identifyField(process, lineNo, machineName, machineDrwaing);
		String query = ReadProperty.getPropertyTagValue(field);
		
		if(field.equalsIgnoreCase(LINE_NO)) {
			
		} else if(field.equalsIgnoreCase(MACHINE_NAME)) {
			
		} else if(field.equalsIgnoreCase(MACHINE_DRWAING)) {
			
		} else if(field.equalsIgnoreCase(SUB_FOLDER)) {
			
		}
		
		DBOperations operations = new DBOperations();
		String responseXml = operations.getValues(sQuery, columnName);
		
		return null;
	}
	
	private static boolean isNotNullOrEmpty(String s) {
		boolean isNotNullOrEmpty = false;
		if(s == null
				|| s.isEmpty()) {
			isNotNullOrEmpty = true;
		}
		return isNotNullOrEmpty;
	}
}
