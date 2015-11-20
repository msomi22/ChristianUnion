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

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.StudentStatus;

/**
 * @author peter
 *
 */
public interface CuStudentStatusDAO {
    
	/**
	 * 
	 * @param StudentUuid
	 * @return StudentStatus Object
	 */
	public StudentStatus get(String StudentUuid);
	  /**
	   * 
	   * @param studentStatus
	   * @return Whether Student was inserted successfully or not
	   */
	public boolean putStudentStatus(StudentStatus studentStatus);
	  /**
	   * 
	   * @param studentStatus
	   * @return Whether Student was updated successfully or not
	   */
	public boolean updateStudentStatus(StudentStatus studentStatus);
	  /**
	   * 
	   * @param studentStatus
	   * @return Whether Student was deleted successfully or not
	   */
	public boolean deleteStudentStatus(StudentStatus studentStatus);
	   /**
	    * 
	    * @return {@link List} List of all Student Status
	    */
	public List<StudentStatus> getAllStudentStatus();
}
