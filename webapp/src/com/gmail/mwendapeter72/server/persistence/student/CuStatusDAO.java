/**
*CuStatusDAO.java
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

import com.gmail.mwendapeter72.server.bean.student.Status;

/**
 * persistence description for {@link Status}s.
 * 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 */
public interface CuStatusDAO {
	 /**
	  * Retrieve the {@link Status} corresponding to the Uuid.
	  * @param Uuid {@link Uuid} the status Uuid 
	  * @return status object
	  */
	public Status getStatus(String Uuid);
	
	/**
	 * 
	 * @param status the status
	 * @return whether status was inserted successfully or not
	 */
	public boolean putStatus(Status status);
	/**
	 * 
	 * @param status the status
	 * @return whether status was updated successfully or not
	 */
	public boolean updateStatus(Status status);
	 /**
	  * 
	  * @param status the status
	  * @return whether status was deleted successfully or not
	  */
	public boolean deleteStatus(Status status);
	
	/**
	 * Retrieve all {@link Status} 
	 * @return {@link List} List of all status
	 */
	public List<Status> getAllStatus();
	

}
