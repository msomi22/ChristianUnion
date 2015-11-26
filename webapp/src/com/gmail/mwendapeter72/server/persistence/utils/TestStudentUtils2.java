/**
 * 
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.
*Contacts author the: +254718953974
*
**/
package com.gmail.mwendapeter72.server.persistence.utils;

import org.junit.Ignore;
import org.junit.Test;

/**
 *@author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class TestStudentUtils2 {
	
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	final String ADMNO ="BS02/009/2013";
	
	private StudentUtils2 store;

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.utils.StudentUtils#getStudents(java.lang.String)}.
	 */
	//@Ignore
	@Test
	public void testGetStudents2() {
		store = new StudentUtils2(databaseName, Host, databaseUsername, databasePassword, databasePort);
		equals(store.getStudents(ADMNO));
		
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.utils.StudentUtils#getIncomingCount(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetIncomingCount2() {
		store = new StudentUtils2(databaseName, Host, databaseUsername, databasePassword, databasePort);
		equals(store.getIncomingCount(ADMNO));
	}

}
