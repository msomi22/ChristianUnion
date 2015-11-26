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

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.gmail.mwendapeter72.server.bean.student.StudentStatus;

/**
 * @author peter
 *
 */
public class TestStudentStatusDAO {
	
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	private String UUID = "A5ACDD4E-66FF-4664-A2DC-270537A3F354",
			       UUID_NEW ="8CC662C5-18D5-45F8-BB46-D382118D4A42";
	
	private String STUDENT_UUID = "5C5724AF-B8C6-4322-ACE9-C340C6DB8D13";
	private String STUDENT_STATUS_UUID = "85C6F08E-902C-46C2-8746-8C50E7D11E2E";
	
	private String STATUS_INACTIVE = "6C03705B-E05E-420B-B5B8-C7EE36643E60";
	
	
	private StudentStatusDAO store;
	

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentStatusDAO#get(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGet() {
		store = new StudentStatusDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentStatusDAO#putStudentStatus(com.gmail.mwendapeter72.server.bean.student.StudentStatus)}.
	 */
	@Ignore
	@Test
	public void testPutStudentStatus() {
		store = new StudentStatusDAO(databaseName, Host, databaseUsername, databasePassword, databasePort); 
		StudentStatus s = new StudentStatus();
		s.setUuid(UUID_NEW);
		s.setStudentUuid(STUDENT_UUID);
		s.setStudentStatusUuid(STUDENT_STATUS_UUID);
		assertTrue(store.putStudentStatus(s));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentStatusDAO#updateStudentStatus(com.gmail.mwendapeter72.server.bean.student.StudentStatus)}.
	 */
	@Ignore
	@Test
	public void testUpdateStudentStatus() {
		store = new StudentStatusDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		StudentStatus s = new StudentStatus();
		s.setStudentUuid(STUDENT_UUID);
		s.setStudentStatusUuid(STATUS_INACTIVE);
		assertTrue(store.updateStudentStatus(s));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentStatusDAO#deleteStudentStatus(com.gmail.mwendapeter72.server.bean.student.StudentStatus)}.
	 */
	@Ignore
	@Test
	public void testDeleteStudentStatus() {
		store = new StudentStatusDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentStatusDAO#getAllStudentStatus()}.
	 */
	//@Ignore
	@Test
	public void testGetAllStudentStatus() {
		store = new StudentStatusDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		List<StudentStatus> list = store.getAllStudentStatus();	
		for (StudentStatus ss : list) {
			System.out.println(ss);
		}
	}

}
