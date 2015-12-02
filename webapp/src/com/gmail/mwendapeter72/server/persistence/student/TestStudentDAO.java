/**
*TestStudentDAO.java
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

import com.gmail.mwendapeter72.server.bean.student.Student;


/**
 * persistence test for {@link StudentDAO}
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author <a href="mailto:joramndungu10@gmail.com">Joram Muriithi</a>
 *
 */
public class TestStudentDAO {
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	private String UUID = "5C5724AF-B8C6-4322-ACE9-C340C6DB8D13";
	private String UUID_NEW ="2E3B7D20-42A5-47DE-A17C-8F685D91883F";
	
	private String STATUS_UUID_ACTIVE = "85C6F08E-902C-46C2-8746-8C50E7D11E2E",  
			       STATUS_UUID_INACTIVE = "6C03705B-E05E-420B-B5B8-C7EE36643E60";
	
	private String ADM_NO = "BS02/030/2012",
			       ADM_NO_NEW = "BS02/033/2012",
			       ADM_NO_UPDATE = "BHR/053/2013x";
	
	private String FIRST_NAME = "Joram",
			       FIRST_NAME_NEW = "Joyce",
			       FIRST_NAME_UPDATE = "updateJoyce";
	
	private String SURNAME = "Ndungu",
			       SURNAME_NEW = "Njoki",
			       SURNAME_UPDATE = "updateNjoki";
	
	private String LAST_NAME = "Muriithi",
			       LAST_NAME_NEW = "Njuguna",
			       LAST_NAME_UPDATE = "updateNjuguna";
	
	private String EMAIL = "joramndungu10@gmail.com",
			       EMAIL_NEW = "njokibryant@gmail.com",
			       EMAIL_UPDATE = "updatenjokibryant@gmaail.com";
	
	private String PHONE = "254716319456",
			       PHONE_NEW = "254721669959",
			       PHONE_UPDATE = "254721669959x";
	
	private String GURDIAN_CONTACT = "254716319456",
			       GURDIAN_CONTACT_NEW = "254721669959",
			       GURDIAN_CONTACT_UPDATE = "254721669959y";
	
	private String DOB = "1991",
			       DOB_NEW = "1994",
			       DOB_UPDATE = "1994";
	
	private String GENDER = "Male",
			       GENDER_NEW = "Female",
			       GENDER_UPDATE = "Female";
	
	private String PROGRAM = "Computer Science",
			       PROGRAM_NEW = "Human Resource Management",
			       PROGRAM_UPDATE = "HRM";
	
	private String ACADEMIC_YEAR = "2015/2016",
			       ACADEMIC_YEAR_NEW = "2015/2016",
			       ACADEMIC_YEAR_UPDATE = "2015/2016x";
	
	private String YEAR_STUDY = "4",
			       YEAR_STUDY_NEW = "3",
			       YEAR_STUDY_UPDATE = "3x";
	
	private String HOME_TOWN = "Nyeri",
			       HOME_TOWN_NEW = "Naivasha",
			       HOME_TOWN_UPDATE = "Naivashax";
	
	private String COUNTY = "Nyeri",
			       COUNTY_NEW = "Nakuru",
			       COUNTY_UPDATE = "Nakurux";

	 private Date DATE_ACTIVATE = new Date(new Long("141941056800") );
	 private Date DATE_ACTIVATE_NEW = new Date(new Long("141941055600") );
	 private Date DATE_ACTIVATE_UPDATE = new Date(new Long("141941056789") );
	
	 private StudentDAO store;


		/**
		 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#getStudent(java.lang.String)}.
		 */
	@Ignore
	@Test
	public void testGetStudent() {
		 store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 Student s = store.getStudent(ADM_NO);
		 assertEquals(s.getUuid(),UUID);
		 assertEquals(s.getAdmNo(),ADM_NO);
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#getStudentByUuid(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetStudentByUuid() {
		store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 Student s = store.getStudentByUuid(UUID);
		 assertEquals(s.getUuid(),UUID);
		// assertEquals(s.getAdmNo(),ADM_NO);
	}
	
	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#getStudentByEmail(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetStudentByEmail() {
		store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 Student s = store.getStudentByEmail(EMAIL);
		 assertEquals(s.getUuid(),UUID);
		 assertEquals(s.getAdmNo(),ADM_NO);
	}

	
	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#getStudentAdmNo(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetStudentAdmNo() {
	 store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	
			List<Student> list = store.getStudentAdmNo("BS02");
			System.out.println(list);
			//assertEquals(list.size(), 2);		
		}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#putStudent(com.gmail.mwendapeter72.server.bean.student.Student)}.
	 */
	@Ignore
	@Test
	public void testPutStudent() {
		 store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 Student s = new Student();
		 s.setUuid(UUID_NEW);
		 s.setStatusUuid(STATUS_UUID_ACTIVE);
		 s.setAdmNo(ADM_NO_NEW);
		 s.setFirstName(FIRST_NAME_NEW);
		 s.setSurName(SURNAME_NEW);
		 s.setLastName(LAST_NAME_NEW);
		 s.setEmail(EMAIL_NEW);
		 s.setMobile(PHONE_NEW);
		 s.setGuardianContact(GURDIAN_CONTACT_NEW); 
		 s.setDOB(DOB_NEW);
		 s.setGender(GENDER_NEW);
		 s.setProgram(PROGRAM_NEW);
		 s.setAcademicYear(ACADEMIC_YEAR_NEW);
		 s.setYearOfStudy(YEAR_STUDY_NEW);
		 s.setHomeTown(HOME_TOWN_NEW);
		 s.setCounty(COUNTY_NEW);
		 s.setDateOfRegistration(DATE_ACTIVATE_NEW); 
		 s.setActivationDate(DATE_ACTIVATE_NEW);
		 assertTrue(store.putStudent(s));  
	
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#updateStudent(com.gmail.mwendapeter72.server.bean.student.Student, java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testUpdateStudent() {
		 store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 Student s = new Student();
		 s.setUuid(UUID_NEW);
		 s.setAdmNo(ADM_NO_NEW);
		 s.setFirstName(FIRST_NAME_UPDATE);
		 s.setSurName(SURNAME_UPDATE);
		 s.setLastName(LAST_NAME_UPDATE);
		 s.setEmail(EMAIL_UPDATE);
		 s.setMobile(PHONE_UPDATE);
		 s.setGuardianContact(GURDIAN_CONTACT_UPDATE); 
		 s.setDOB(DOB_UPDATE);
		 s.setGender(GENDER_UPDATE);
		 s.setProgram(PROGRAM_UPDATE);
		 s.setAcademicYear(ACADEMIC_YEAR_UPDATE);
		 s.setYearOfStudy(YEAR_STUDY_UPDATE);
		 s.setHomeTown(HOME_TOWN_UPDATE);
		 s.setCounty(COUNTY_UPDATE);
		 assertTrue(store.updateStudent(s, UUID_NEW));  
	
	}

	
	

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#activateStudent(com.gmail.mwendapeter72.server.bean.student.Student)}.
	 */
	@Ignore
	@Test
	public void testActivateStudent() {
		 store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 Student s = new Student();
		 s.setUuid(UUID_NEW);
		 s.setStatusUuid(STATUS_UUID_ACTIVE);
		 s.setAcademicYear(ACADEMIC_YEAR_UPDATE);
		 s.setYearOfStudy(YEAR_STUDY_UPDATE);
		 s.setActivationDate(DATE_ACTIVATE_UPDATE); 
		 assertTrue(store.activateStudent(s));  
	
	}
	
	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#deActivateStudent(com.gmail.mwendapeter72.server.bean.student.Student)}.
	 */
	@Ignore
	@Test
	public void testDeActivateStudent() {
		 store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 Student s = new Student();
		 s.setUuid(UUID_NEW);
		 s.setStatusUuid(STATUS_UUID_INACTIVE); 
		 assertTrue(store.deActivateStudent(s));  
	
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#deleteStudent(com.gmail.mwendapeter72.server.bean.student.Student, java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testDeleteStudent() {
		 store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 Student s = new Student();
		 s.setUuid(UUID_NEW);
		 assertTrue(store.deleteStudent(s, UUID_NEW));  
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#getStudentList(int, int)}.
	 */
	@Ignore
	@Test
	public void testGetAllStdeunt() {
		 store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 List<Student> studentList = store.getStudentList(0,10);
		 //assertEquals(studentList.size() , 15);
		 for(Student ss : studentList){
			System.out.println(ss);
		}
	}
	
	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#getStudentList()}.
	 */
	@Ignore
	@Test
	public void testGetStudentList() {
		 store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 List<Student> studentList = store.getStudentList();
		 //assertEquals(studentList.size() , 15);
		 for(Student ss : studentList){
			System.out.println(ss);
			//System.out.println("StudentUuid=="+ss.getUuid()+"Reg Date=="+ss.getDateOfRegistration());
			//System.out.println("Reg Date"+ss.getDateOfRegistration());
			
		}
	}

}
