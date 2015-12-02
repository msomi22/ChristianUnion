/**
*CuStudentPositionDAO.java
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

import com.gmail.mwendapeter72.server.bean.student.StudentPosition;

/**
 * Persistence description for{@link StudentPosition}
 * 
 * Copyright (c) FasTech Solutions Ltd., Dec 02, 2015
 * 
 *@author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public interface CuStudentPositionDAO {
	/**
	 * Retrieve the {@link StudentPosition} corresponding to the StudentUuid.
	 * 
	 * @param StudentUuid the StudentUuid
	 * @return whether the student's position was captured successfully or not
	 */
	public StudentPosition getPosition(String StudentUuid);
	
	
	/**
	 * 
	 * @param position the position
	 * @return whether the student's position was inserted successfully or not
	 */
	public boolean putPosition(StudentPosition position);
	 /**
	  * 
	  * @param position the position
	  * @return whether the student's position was updated successfully or not
	  */
	public boolean updatePosition(StudentPosition position);
	 /**
	  * 
	  * @param position the position
	  * @return whether the student's position was deleted successfully or not
	  */
	public boolean deletePosition(StudentPosition position);
	
	 /**
	  * Retrieve all {@link StudentPosition}
	  * @return List{@link List} of all Student Position
	  */
	public List<StudentPosition> getAllPositions(int startIndex , int endIndex);

}
