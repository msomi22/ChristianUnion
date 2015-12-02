/**
*TestStudentUtils.java
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
package com.gmail.mwendapeter72.server.persistence.utils;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Test  Student(s) Utility
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class TestStudentUtils {
	
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	final String ADMNO ="BS02/009/2013";
	
	private StudentUtils store;

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.utils.StudentUtils#getStudents(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetStudents() {
		store = new StudentUtils(databaseName, Host, databaseUsername, databasePassword, databasePort);
		equals(store.getStudents(ADMNO));
		
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.utils.StudentUtils#getIncomingCount(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetIncomingCount() {
		store = new StudentUtils(databaseName, Host, databaseUsername, databasePassword, databasePort);
		equals(store.getIncomingCount(ADMNO));
	}

}
