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


import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.Student;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author joram<a href="mailto:joramndungu10@gmail.com">Joram Muriithi</a>
 *
 */
public interface CuStudentDAO {
	/**
	 * 
	 * @param AdmNo
	 * @return student object
	 */
	public Student getStudent(String AdmNo);
	/**
	 * 
	 * @param Uuid
	 * @return student object
	 */
	public Student getStudentByUuid(String Uuid);
	
	
	/**
	    * 
	    * @param schoolaccount
	    * @param admno
	    * @return	a {@link List} of {@link Student}s whose admno partly or wholly
	    * matches the admno and belongs to a particular school account. Matching is case 
	    * insensitive. An empty list is returned if no Student matches the admno.
	    */
	  public List<Student> getStudentAdmNo(String admno);
	
        /**
         * 
         * @param student
         * @return whether student was inserted successfully
         */
	public boolean putStudent(Student student);
	
	 /**
	  * 
	  * @param student
	  * @param Uuid
	  * @return whether student was updated successfully
	  */
	public boolean updateStudent(Student student,String Uuid);
	
	
	
	/**
	 * @param student
	 * @return whether student was updated successfully
	 */
	public boolean updateStudent(Student student);
	
	  /**
	   * 
	   * @param student
	   * @param Uuid
	   * @return whether student was deleted successfully
	   */
	public boolean deleteStudent(Student student,String Uuid);
	
	
	   /**
	    * 
	    * @param startIndex
	    * @param endIndex
	    * @return List of all Students
	    */
	   
	public List<Student> getStudentList(int startIndex , int endIndex);
	
	  /**
	    * 
	    * @return List of all Students
	    */
	public List<Student> getStudentList();

}
