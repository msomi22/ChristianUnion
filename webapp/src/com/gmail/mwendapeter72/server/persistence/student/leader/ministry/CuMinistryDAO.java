/**
*CuMinistryDAO.java
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
package com.gmail.mwendapeter72.server.persistence.student.leader.ministry;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.leader.ministry.Ministry;

/**
 * persistence description for {@link Ministry}ies.
 * 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 */
public interface CuMinistryDAO {
	
	/**
	  * Retrieve the {@link Ministry} corresponding to the Uuid.
	  * @param Uuid {@link Uuid} the Ministry Uuid 
	  * @return Ministry object
	  */
	public Ministry getMinistry(String Uuid);
	
	/**
	 * 
	 * @param ministry the ministry
	 * @return whether ministry was inserted successfully or not
	 */
	public boolean putMinistry(Ministry ministry);
	/**
	 * 
	 * @param ministry the ministry
	 * @return whether ministry was updated successfully or not
	 */
	public boolean updateMinistry(Ministry ministry);
	 /**
	  * 
	  * @param ministry the ministry
	  * @return whether ministry was deleted successfully or not
	  */
	public boolean deleteMinistry(Ministry ministry);
	
	/**
	 * Retrieve all {@link Ministry}ies
	 * @return list of all {@link Ministry}ies available in MMUCU
	 */
	public List<Ministry> getAllMinistres();

}
