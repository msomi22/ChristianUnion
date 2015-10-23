/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student;


import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.Student;

/**
 * @author joram
 *
 */
public interface CuStudentDAO {
	/**
	 * 
	 * @param AdmNo
	 * @return
	 */
	public Student getStudent(String AdmNo);
	/**
	 * 
	 * @param Uuid
	 * @return
	 */
	public Student getStudentByUuid(String Uuid);
	
        /**
         * 
         * @param student
         * @return
         */
	public boolean putStudent(Student student);
	
	 /**
	  * 
	  * @param student
	  * @param Uuid
	  * @return
	  */
	public boolean updateStudent(Student student,String Uuid);
	
	  /**
	   * 
	   * @param student
	   * @param Uuid
	   * @return
	   */
	public boolean deleteStudent(Student student,String Uuid);
	
	
	   /**
	    * 
	    * @return
	    */
	public List<Student> getAllStdeunt();

}
