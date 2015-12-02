/**
*TestStudentPositionDAO.java
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
package com.gmail.mwendapeter72.server.persistence.student;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.gmail.mwendapeter72.server.bean.student.StudentPosition;

/**
 * persistence test for {@link StudentPositionDAO}
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class TestStudentPositionDAO {
	
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	private String UUID = "B5ACDD4E-66FF-4664-A2DC-270537A3F354",
			       UUID_NEW = "";
	
	private String STUDENT_UUID ="ED12D9B0-1D74-4374-B435-A7C97B12F793",
			       STUDENT_UUID_NEW ="985F8800-CA73-4E91-95C3-1BE967A72F11";
	
	private String STATUS_UUID ="6C03705B-E05E-420B-B5B8-C7EE36643E60",
			       STATUS_UUID_NEW ="85C6F08E-902C-46C2-8746-8C50E7D11E2E";
	
	private String POSITION ="Bible Study Head",
			       POSITION_NEW ="Galilean Family dad",
			       POSITION_UPDATE ="dad";
	
	 private Date START_DATE = new Date(new Long("141941056800") );
	 private Date END_DATE = new Date(new Long("141941055600") );
	
	
	
	
	
	private StudentPositionDAO store;

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentPositionDAO#getPosition(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetPosition() {
		store = new StudentPositionDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		StudentPosition p = new StudentPosition();
		p = store.getPosition(STUDENT_UUID);
		assertEquals(p.getUuid(),UUID);
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentPositionDAO#putPosition(com.gmail.mwendapeter72.server.bean.student.StudentPosition)}.
	 */
	@Ignore
	@Test
	public void testPutPosition() {
		store = new StudentPositionDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		StudentPosition p = new StudentPosition();
		p.setUuid(UUID);
		p.setStudentUuid(STUDENT_UUID);
		p.setStatusUuid(STATUS_UUID);
		p.setPosition(POSITION);
		p.setStartDate(START_DATE);
		p.setEndDate(END_DATE);
		assertTrue(store.putPosition(p)); 
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentPositionDAO#updatePosition(com.gmail.mwendapeter72.server.bean.student.StudentPosition)}.
	 */
	@Ignore
	@Test
	public void testUpdatePosition() {
		store = new StudentPositionDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		StudentPosition p = new StudentPosition();
		p.setStudentUuid(STUDENT_UUID);
		p.setStatusUuid(STATUS_UUID_NEW);
		p.setPosition(POSITION_NEW);
		p.setStartDate(START_DATE);
		p.setEndDate(END_DATE);
		assertTrue(store.updatePosition(p));  
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentPositionDAO#deletePosition(com.gmail.mwendapeter72.server.bean.student.StudentPosition)}.
	 */
	@Ignore
	@Test
	public void testDeletePosition() {
		store = new StudentPositionDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		StudentPosition p = new StudentPosition();
		p.setStudentUuid(STUDENT_UUID);
		assertTrue(store.deletePosition(p));  
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentPositionDAO#getAllPositions(int, int)}.
	 */
	@Ignore
	@Test
	public void testGetAllPositions() {
		store = new StudentPositionDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		List<StudentPosition> studentPositionLIST = store.getAllPositions(0, 15);
		 //assertEquals(studentList.size() , 15); 
		 for(StudentPosition sp : studentPositionLIST){
			System.out.println(sp);
		}
	}

}
