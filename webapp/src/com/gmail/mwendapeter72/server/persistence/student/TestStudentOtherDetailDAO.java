/**
*TestStudentOtherDetailDAO.java
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

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;

/**
 * persistence test for {@link StudentOtherDetailDAO}
 *  @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class TestStudentOtherDetailDAO {
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	private String UUID ="A95EA158-6D2E-4316-AC15-358E26C0CFA0",
			       UUID_NEW="3E3B7D20-42A5-47DE-A17C-8F685D91883F";
	
	private String STUDENT_UUID = "5C5724AF-B8C6-4322-ACE9-C340C6DB8D13",
			       STUDENT_UUID_NEW ="2E3B7D20-42A5-47DE-A17C-8F685D91883F";
	
	private String  CHRISTIAN = "Yes",
			        CHRISTIAN_NEW = "NewYes",
			        CHRISTIAN_UPDATE = "UpdateYes";
	
	private String DURATION = "9 Years",
			       DURATION_NEW = "20 Years",
			       DURATION_UPDATE = "update above 4 years";
	
	private String MINISTRY = "Yes",
			       MINISTRY_NEW = "No",
			       MINISTRY_UPDATE = "update Yea";
	
	private String MINISTRY_NAME = "Evangelism",
			       MINISTRY_NAME_NEW = "Any Ministry",
			       MINISTRY_NAME_UPDATE = "update Praise&W";
	
	private String DESIRED_MINISTRY = "N/A",
			       DESIRED_MINISTRY_NEW = "New Ministry",
				   DESIRED_MINISTRY_UPDATE = "update Praise & Worship";
	
	private String MINISTRY_VISION = "Coming soon",
			       MINISTRY_VISION_NEW = "New Vision",
			       MINISTRY_VISION_UPDATE = "update Oh! u cant imagine";
	
	
	private StudentOtherDetailDAO store;

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO#getDetail(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetDetail() {
		store = new StudentOtherDetailDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		StudentOtherDetail d = new StudentOtherDetail();
		d = store.getDetail(STUDENT_UUID);
		//System.out.println(store.getDetail(STUDENT_UUID));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO#putDetail(com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail)}.
	 */
	@Ignore
	@Test
	public void testPutDetail() {
		store = new StudentOtherDetailDAO(databaseName, Host, databaseUsername, databasePassword, databasePort); 
		StudentOtherDetail s = new StudentOtherDetail();
		s.setUuid(UUID_NEW);
		s.setStudentUuid(STUDENT_UUID_NEW);
		s.setChristian(CHRISTIAN_NEW);
		s.setDuration(DURATION_NEW);
		s.setMinistry(MINISTRY_NEW);
		s.setMinistryName(MINISTRY_NAME_NEW);
		s.setDesiredMinistry(DESIRED_MINISTRY_NEW);
		s.setMinistryVision(MINISTRY_VISION_NEW); 
		 assertTrue(store.putDetail(s));
	}


	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO#updateDetail(com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail, java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testUpdateDetail() {
		store = new StudentOtherDetailDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		StudentOtherDetail s = new StudentOtherDetail();
		s.setStudentUuid(STUDENT_UUID_NEW);
		s.setChristian(CHRISTIAN_UPDATE);
		s.setDuration(DURATION_UPDATE);
		s.setMinistry(MINISTRY_UPDATE);
		s.setMinistryName(MINISTRY_NAME_UPDATE);
		s.setDesiredMinistry(DESIRED_MINISTRY_UPDATE);
		s.setMinistryVision(MINISTRY_VISION_UPDATE); 
		assertTrue(store.updateDetail(s,STUDENT_UUID_NEW));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO#deleteDetail(com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail)}.
	 */
	@Ignore
	@Test
	public void testDeleteDetail() {
		store = new StudentOtherDetailDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		StudentOtherDetail s = new StudentOtherDetail();
		s.setStudentUuid(STUDENT_UUID_NEW);
		assertTrue(store.deleteDetail(s));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO#getAllDetailList(int, int)}.
	 */
	@Ignore
	@Test
	public void testGetAllDetailList() {
		store = new StudentOtherDetailDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 List<StudentOtherDetail> studentList = store.getAllDetailList(0,10);
		 //assertEquals(studentList.size() , 15);
		 for(StudentOtherDetail ss : studentList){
			System.out.println(ss);
		}
	}

}
