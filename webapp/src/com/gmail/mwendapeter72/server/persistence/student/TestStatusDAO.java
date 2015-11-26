/**
 * 
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.
*Contacts author the: +254718953974
*
**/
package com.gmail.mwendapeter72.server.persistence.student;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.gmail.mwendapeter72.server.bean.student.Status;


/**
 * @author peter
 *
 */
public class TestStatusDAO {
	
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	
	
	private StatusDAO  store;

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StatusDAO#getStatus(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetStatus() {
		store = new StatusDAO(databaseName, Host, databaseUsername, databasePassword, databasePort); 
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StatusDAO#putStatus(com.gmail.mwendapeter72.server.bean.student.Status)}.
	 */
	@Ignore
	@Test
	public void testPutStatus() {
		store = new StatusDAO(databaseName, Host, databaseUsername, databasePassword, databasePort); 
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StatusDAO#updateStatus(com.gmail.mwendapeter72.server.bean.student.Status)}.
	 */
	@Ignore
	@Test
	public void testUpdateStatus() {
		store = new StatusDAO(databaseName, Host, databaseUsername, databasePassword, databasePort); 
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StatusDAO#deleteStatus(com.gmail.mwendapeter72.server.bean.student.Status)}.
	 */
	@Ignore
	@Test
	public void testDeleteStatus() {
		store = new StatusDAO(databaseName, Host, databaseUsername, databasePassword, databasePort); 
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StatusDAO#getAllStatus()}.
	 */
	//@Ignore
	@Test
	public void testGetAllStatus() {
		store = new StatusDAO(databaseName, Host, databaseUsername, databasePassword, databasePort); 
		List<Status> list = store.getAllStatus();	
		for (Status ss : list) {
			System.out.println(ss);
		}
	}

}
