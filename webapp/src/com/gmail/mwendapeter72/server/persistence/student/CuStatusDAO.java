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

import com.gmail.mwendapeter72.server.bean.student.Status;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author betty
 *
 */
public interface CuStatusDAO {
	 /**
	  * 
	  * @param Uuid
	  * @return status object
	  */
	public Status getStatus(String Uuid);
	
	/**
	 * 
	 * @param status
	 * @return whether status was inserted successfully or not
	 */
	public boolean putStatus(Status status);
	/**
	 * 
	 * @param status
	 * @return whether status was updated successfully or not
	 */
	public boolean updateStatus(Status status);
	 /**
	  * 
	  * @param status
	  * @return whether status was deleted successfully or not
	  */
	public boolean deleteStatus(Status status);
	
	/**
	 * 
	 * @return {@link List} List of all status
	 */
	public List<Status> getAllStatus();
	

}
