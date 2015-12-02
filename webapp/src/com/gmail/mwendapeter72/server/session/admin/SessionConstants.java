/**
*SessionConstants.java
*
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file CAN BE copied without the author's approval for learning purposes or for use in one's own project
*if need be, feel free to contact the author
*Contacts, Mobile: +254718953974
*         email: mwendapeter72@gmail.com
*         email: petermwenda83@yahoo.com 
**/
package com.gmail.mwendapeter72.server.session.admin;

/**
 * Constants which are used in session management of a admin.
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class SessionConstants {

	     final public static int SESSION_TIMEOUT = 100;  // Number of seconds for which a session is active.
	    final public static String ADMIN_SESSION_KEY = "Admin Session Key";
	    final public static String ADMIN_SIGN_IN_ERROR_KEY = "Admin Error Login";
	    final public static String ADMIN_SIGN_IN_ERROR_VALUE = "Sorry, the administrator username and/or "
	            + "password are incorrect. Please try again.";
	    final public static String ADMIN_LOGIN_TIME_KEY = "Admin login time key";
		
		//Student Management
		final public static String STUDENT_ADD_SUCCESS = "Student Addedd Successfully";
		final public static String STUDENT_ADD_ERROR = "Student Add Failed";
		
		final public static String STUDENT_UPDATE_SUCCESS = "Student Updated Successfully";
		final public static String STUDENT_UPDATE_ERROR = "Student Update Failed";
		
		final public static String STUDENT_REPORT_ERROR = "Report couldn't be generated";
		
		final public static String STUDENT_REGISTER_DETAILS = "Student Parameters";
	 
	 
}
