/**
*CuStudentDAO.java
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


import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.Student;

/**
 * persistence description for {@link StudentDAO}.
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author <a href="mailto:joramndungu10@gmail.com">Joram Muriithi</a>
 *
 */
public interface CuStudentDAO {
	/**
	 * Retrieve the {@link Student} corresponding to the AdmNo.
	 * @param AdmNo the student's admno
	 * @return student object of {@link Student} for the given admission number
	 */
	public Student getStudent(String AdmNo);
	
	/**
	 * Retrieve the {@link Student} corresponding to the AdmNo.
	 * @param AdmNo the student's admno
	 * @return student object of {@link Student} for the given admission number
	 */
	public Student getStudent(String Uuid, String Gender);
	
	/**
	 * Retrieve the {@link Student} corresponding to the Email.
	 * @param Email the student's Email
	 * @return student object of {@link Student} for the given Email address
	 */
	public Student getStudentByEmail(String Email);
	/**
	 * Retrieve the {@link Student} corresponding to the Uuid.
	 * @param Uuid the student's Uuid
	 * @return student object of {@link Student} for the given StudentUuid
	 */
	public Student getStudentByUuid(String Uuid);
	
	
	/**
	 *  Retrieve all {@link Student} corresponding to the admno.
	 * @param admno the student's admno
	 * @return	a {@link List} of {@link Student}s for the given admission number
	 */

	  public List<Student> getStudentAdmNo(String admno);
	
        /**
         * 
         * @param student the student
         * @return whether student {@link Student} was inserted successfully
         */
	public boolean putStudent(Student student);
	
	 /**
	  * 
	  * @param student the student
	  * @param Uuid the student's Uuid
	  * @return whether student {@link Student} was updated successfully
	  */
	public boolean updateStudent(Student student,String Uuid);
	
	
	
	/**
	 * @param student the student
	 * @return whether student {@link Student} was updated successfully
	 */
	public boolean activateStudent(Student student);
	

	/**
	 * @param student the student
	 * @return whether student {@link Student} was deactivated successfully
	 */
	public boolean deActivateStudent(Student student);
	
	  /**
	   * 
	   * @param student the student
	   * @param Uuid the student's Uuid
	   * @return whether student {@link Student} was deleted successfully
	   */
	public boolean deleteStudent(Student student,String Uuid);
	
	
	   /**
	    * Retrieve all {@link Student}  within a given range
	    * @param startIndex the startIndex
	    * @param endIndex the  endIndex
	    * @return List a {@link List} of 15  {@link Student}s 
	    */
	   
	public List<Student> getStudentList(int startIndex , int endIndex);
	
	  /**
	    * Retrieve all {@link Student} 
	    * @return List a {@link List} of all  {@link Student}s 
	    */
	public List<Student> getStudentList();

}
