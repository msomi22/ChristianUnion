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
	 * @return student object of {@link Student} for the given admission number
	 */
	public Student getStudent(String AdmNo);
	
	/**
	 * 
	 * @param Email
	 * @return student object of {@link Student} for the given Email address
	 */
	public Student getStudentByEmail(String Email);
	/**
	 * 
	 * @param Uuid
	 * @return student object of {@link Student} for the given StudentUuid
	 */
	public Student getStudentByUuid(String Uuid);
	
	
	/**
	 * 
	 * @param admno
	 * @return	a {@link List} of {@link Student}s for the given admission number
	 */

	  public List<Student> getStudentAdmNo(String admno);
	
        /**
         * 
         * @param student
         * @return whether student {@link Student} was inserted successfully
         */
	public boolean putStudent(Student student);
	
	 /**
	  * 
	  * @param student
	  * @param Uuid
	  * @return whether student {@link Student} was updated successfully
	  */
	public boolean updateStudent(Student student,String Uuid);
	
	
	
	/**
	 * @param student
	 * @return whether student {@link Student} was updated successfully
	 */
	public boolean activateStudent(Student student);
	

	/**
	 * @param student
	 * @return whether student {@link Student} was deactivated successfully
	 */
	public boolean deActivateStudent(Student student);
	
	  /**
	   * 
	   * @param student
	   * @param Uuid
	   * @return whether student {@link Student} was deleted successfully
	   */
	public boolean deleteStudent(Student student,String Uuid);
	
	
	   /**
	    * 
	    * @param startIndex
	    * @param endIndex
	    * @return List a {@link List} of 15  {@link Student}s 
	    */
	   
	public List<Student> getStudentList(int startIndex , int endIndex);
	
	  /**
	    * 
	    * @return List a {@link List} of all  {@link Student}s 
	    */
	public List<Student> getStudentList();

}
