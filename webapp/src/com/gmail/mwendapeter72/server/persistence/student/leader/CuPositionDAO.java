/**
*CuRoleDAO.java
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
package com.gmail.mwendapeter72.server.persistence.student.leader;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.leader.Position;

/**
 * persistence description for {@link PositionDAO}.
 * 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 */
public interface CuPositionDAO {
	
	/**
	  * Retrieve the {@link Position} corresponding to the Uuid.
	  * @param Uuid {@link Uuid} the status Uuid 
	  * @return Position object
	  */
	public Position getPosition(String Uuid);
	
	/**
	 * 
	 * @param Position the Position
	 * @return whether Position was inserted successfully or not
	 */
	public boolean putPosition(Position position);
	/**
	 * 
	 * @param Position the Position
	 * @return whether Position was updated successfully or not
	 */
	public boolean updatePosition(Position position);
	 /**
	  * 
	  * @param Position the Position
	  * @return whether role was deleted successfully or not
	  */
	public boolean deletePosition(Position position);
	
	/**
	 * Retrieve all {@link Position}s
	 * @return list of all {@link Position}s available in MMUCU
	 */
	public List<Position> getPositionList();

}
