/******************************************************************************
 * ****************************************************************************
 ************* MAASAI MARA UNIVERITY CHRISTIAN UNION MANAGEMENT SYSTEM*********
 *************THIS SYSTEM IS BASED ON JAVAEE, USING MVC MODEL******************
 *************THE SYSTEM IS USED FOR STUDEN REGISTRATION TO THE UNION**********
 *************STUDENT REGISTRATION MODULE WILL BE ACCESSIBLE REMOTELY**********
 *************VIA USE OF PUBLIC IP ADDRESS OR A DOMAIN NAME********************
 *THE STUDENT WILL ALSO BE ABLE TO CHECK THEIR REGISTERD DETAILS FOR VERIFICATION
 *WHEREBY, THEY ARE ALLOWED TO MODIGY THEIR DETAILS WITHIN ONE WEEK AFTER REGISTRATION DATE
 *****************************************************************************************
 *****************************************************************************************
 *THE OTHER MODULES OR ONLY FOR ADMIN, THE ADMIN WILL APPROVE STUDEDNTS AFTER THEY REGISTER
 *THE REGISTRATION WILL REQURED RE-ACTIVATION AFTER A PERIOD OF ONE YEAR(12 MONTHS) THIS WILL
 *HAPPEN AUTOMATICALLY WITH THE HELP OF QUARTZ SCHEDULAR, FOR EFFICIENCY AND KEEPING THE SYSTEM
 *AT HIGH PERFORMANCE, SOME DATA ARE CACHED USING EHCHACE.
 **********************************************************************************************
 **********************************************************************************************
 *COPYRIGHT REMAINS TO SOFTECH SOLUTIONS, A FAST GROWING IT COMPANY
 *CONTSCTS: WWW.FASTECCHSOLUTIONS.CO.KE
 *          WWW.FACEBOOK.COM/FASTECH.CO.KE
 *
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.gmail.mwendapeter72.server.bean.student.Student;


/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author joram<a href="mailto:joramndungu10@gmail.com">Joram Muriithi</a>
 *
 */
public class TestStudentDAO {
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	private String UUID = "5C5724AF-B8C6-4322-ACE9-C340C6DB8D13";
	private String UUID_NEW ="760182D0-A534-4D85-86BC-6FEA9F44540D";
	
	private String ADM_NO = "BS02/030/2012",
			       ADM_NO_NEW = "BS02/033/2012",
			       ADM_NO_UPDATE = "";
	
	private String FIRST_NAME = "Joram",
			       FIRST_NAME_NEW = "Joyce",
			       FIRST_NAME_UPDATE = "";
	
	private String SURNAME = "Ndungu",
			       SURNAME_NEW = "Njoki",
			       SURNAME_UPDATE = "";
	
	private String LAST_NAME = "Muriithi",
			       LAST_NAME_NEW = "Njuguna",
			       LAST_NAME_UPDATE = "";
	
	private String EMAIL = "joramndungu10@gmail.com",
			       EMAIL_NEW = "njokibryant@gmaail.com",
			       EMAIL_UPDATE = "";
	
	private String PHONE = "254716319456",
			       PHONE_NEW = "254721669959",
			       PHONE_UPDATE = "";
	
	private String GURDIAN_CONTACT = "254716319456",
			       GURDIAN_CONTACT_NEW = "254721669959",
			       GURDIAN_CONTACT_UPDATE = "";
	
	private String DOB = "1991",
			       DOB_NEW = "1994",
			       DOB_UPDATE = "";
	
	private String GENDER = "Male",
			       GENDER_NEW = "Female",
			       GENDER_UPDATE = "";
	
	private String PROGRAM = "Computer Science",
			       PROGRAM_NEW = "Human Resource Management",
			       PROGRAM_UPDATE = "";
	
	private String ACADEMIC_YEAR = "2015/2016",
			       ACADEMIC_YEAR_NEW = "2015/2016",
			       ACADEMIC_YEAR_UPDATE = "";
	
	private String YEAR_STUDY = "4",
			       YEAR_STUDY_NEW = "3",
			       YEAR_STUDY_UPDATE = "";
	
	private String HOME_TOWN = "Nyeri",
			       HOME_TOWN_NEW = "Nakuru",
			       HOME_TOWN_UPDATE = "";
	
	private String COUNTY = "Nyeri",
			       COUNTY_NEW = "Nakuru",
			       COUNTY_UPDATE = "";

	 private Date DATE_REG = new Date(new Long("141941056800") );
	 private Date DATE_REG_NEW = new Date(new Long("141941055600") );
	 private Date DATE_REG_UPDATE = new Date(new Long("141941056789") );
	
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
	//@Ignore
	@Test
	public void testGetStudentByUuid() {
		store = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 Student s = store.getStudentByUuid(UUID);
		 assertEquals(s.getUuid(),UUID);
		// assertEquals(s.getAdmNo(),ADM_NO);
	}

	
	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.student.StudentDAO#putStudent(com.yahoo.petermwenda83.bean.student.StudentSubject)}.
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
		 s.setDateOfRegistration(DATE_REG_NEW);
		 assertTrue(store.putStudent(s));  
	
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#updateStudent(com.gmail.mwendapeter72.server.bean.student.Student, java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testUpdateStudent() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#deleteStudent(com.gmail.mwendapeter72.server.bean.student.Student, java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testDeleteStudent() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentDAO#getAllStdeunt()}.
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

}
