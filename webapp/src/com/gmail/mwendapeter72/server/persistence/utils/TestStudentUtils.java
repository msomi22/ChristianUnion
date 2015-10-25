/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.utils;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author peter
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
	 * Test method for {@link com.yahoo.petermwenda83.persistence.utils.StudentUtils#getStudents(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetStudents() {
		store = new StudentUtils(databaseName, Host, databaseUsername, databasePassword, databasePort);
		equals(store.getStudents(ADMNO));
		
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.utils.StudentUtils#getIncomingCount(java.lang.String)}.
	 */
	//@Ignore
	@Test
	public void testGetIncomingCount() {
		store = new StudentUtils(databaseName, Host, databaseUsername, databasePassword, databasePort);
		equals(store.getIncomingCount(ADMNO));
	}

}
