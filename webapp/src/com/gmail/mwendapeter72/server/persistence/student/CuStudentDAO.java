/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student;


import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.Student;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author joram <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
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
	   * 
	   * @param student
	   * @param Uuid
	   * @return whether student was deleted successfully
	   */
	public boolean deleteStudent(Student student,String Uuid);
	
	
	   /**
	    * 
	    * @return List of all Students
	    */
	public List<Student> getAllStdeunt();

}
