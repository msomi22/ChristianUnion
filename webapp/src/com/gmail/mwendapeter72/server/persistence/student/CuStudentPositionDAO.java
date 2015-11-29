/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.StudentPosition;

/**
 * @author peter
 *
 */
public interface CuStudentPositionDAO {
	/**
	 * 
	 * @param StudentUuid
	 * @return
	 */
	public StudentPosition getPosition(String StudentUuid);
	/**
	 * 
	 * @param position
	 * @return
	 */
	public boolean putPosition(StudentPosition position);
	 /**
	  * 
	  * @param position
	  * @return
	  */
	public boolean updatePosition(StudentPosition position);
	 /**
	  * 
	  * @param position
	  * @return
	  */
	public boolean deletePosition(StudentPosition position);
	 /**
	  * 
	  * @return
	  */
	public List<StudentPosition> getAllPositions();

}
