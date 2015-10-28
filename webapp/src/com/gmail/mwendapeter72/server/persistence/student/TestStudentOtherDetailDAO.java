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

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;

/**
 * @author muriithi
 *
 */
public class TestStudentOtherDetailDAO {
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	private String UUID ="A95EA158-6D2E-4316-AC15-358E26C0CFA0",
			       UUID_NEW="DD08D8CE-59E6-41AF-824F-4C6538771094";
	
	private String STUDENT_UUID = "5C5724AF-B8C6-4322-ACE9-C340C6DB8D13",
			       STUDENT_UUID_NEW ="FC31CA05-DDAB-45BF-AC3C-4AE010A39102";
	
	private String  CHRISTIAN = "Yes",
			        CHRISTIAN_NEW = "NewYes",
			        CHRISTIAN_UPDATE = "UpdateYes";
	
	private String DURATION = "9 Years",
			       DURATION_NEW = "20 Years",
			       DURATION_UPDATE = "";
	
	private String MINISTRY = "Yes",
			       MINISTRY_NEW = "No",
			       MINISTRY_UPDATE = "";
	
	private String MINISTRY_NAME = "Evangelism",
			       MINISTRY_NAME_NEW = "Any Ministry",
			       MINISTRY_NAME_UPDATE = "";
	
	private String DESIRED_MINISTRY = "N/A",
			       DESIRED_MINISTRY_NEW = "New Ministry",
				   DESIRED_MINISTRY_UPDATE = "";
	
	private String MINISTRY_VISION = "Coming soon",
			       MINISTRY_VISION_NEW = "New Vision",
			       MINISTRY_VISION_UPDATE = "";
	
	
	private StudentOtherDetailDAO store;

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO#getDetail(java.lang.String)}.
	 */
	//@Ignore
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
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO#deleteDetail(com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail)}.
	 */
	@Ignore
	@Test
	public void testDeleteDetail() {
		store = new StudentOtherDetailDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO#getAllDetgail()}.
	 */
	@Ignore
	@Test
	public void testGetAllDetgail() {
		store = new StudentOtherDetailDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		 List<StudentOtherDetail> studentList = store.getAllDetailList(0,10);
		 //assertEquals(studentList.size() , 15);
		 for(StudentOtherDetail ss : studentList){
			System.out.println(ss);
		}
	}

}
