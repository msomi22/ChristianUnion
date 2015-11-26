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
