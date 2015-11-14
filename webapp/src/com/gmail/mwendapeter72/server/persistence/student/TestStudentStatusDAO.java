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
 *COPYRIGHT REMAINS TO FASTECH SOLUTIONS, A FAST GROWING IT COMPANY IN KENYA
 *CONTSCTS: WWW.FASTECCHSOLUTIONS.CO.KE
 *          WWW.FACEBOOK.COM/FASTECH.CO.KE
 *          PHONE:0718953974
 *          
 *          
 * 
 * 
 */
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
