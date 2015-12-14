/**
*CuLeadersRegisterDAO.java
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

import com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister;

/**
 * Persistence description for{@link LeadersRegister}
 * 
 * Copyright (c) FasTech Solutions Ltd., Dec 02, 2015
 * 
 *@author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public interface CuLeadersRegisterDAO {
	/**
	 * Retrieve the {@link LeadersRegister} corresponding to the StudentUuid.
	 * 
	 * @param StudentUuid the StudentUuid
	 * @return whether LeadersRegister was captured successfully or not
	 */
	public LeadersRegister getLeader(String StudentUuid);
	
	
	/**
	 * Retrieve the {@link LeadersRegister} corresponding to the StudentUuid.
	 * 
	 * @param StudentUuid the StudentUuid
	 * @param StatusUuid the StatusUuid
	 * @return whether theLeadersRegister was captured successfully or not
	 */
	public LeadersRegister getLeader(String StudentUuid,String StatusUuid);
	

	/**
	 * Retrieve the {@link LeadersRegister} corresponding to the Leader.
	 * 
	 * @param Leader the Leader
	 * @return whether theLeadersRegister was captured successfully or not
	 */
	public LeadersRegister getLeader(LeadersRegister Leader);
	

	/**
	 * Retrieve the {@link LeadersRegister} corresponding to the StudentUuid.
	 * 
	 * @param StudentUuid the StudentUuid
	 * @return whether theLeadersRegister was captured successfully or not
	 */
	public boolean HasLeader(String StudentUuid,String StatusUuid);

	/**
	 * 
	 * @param LeadersRegister the Leader
	 * @return whether LeadersRegister was inserted successfully or not
	 */
	public boolean putLeader(LeadersRegister Leader);
	 /**
	  * 
	  * @param LeadersRegister the Leader
	  * @return whether the LeadersRegister was updated successfully or not
	  */
	public boolean updateLeader(LeadersRegister Leader);
	
	
	 /**
	  * 
	  * @param LeadersRegister the Leader
	  * @return whether the LeadersRegister was updated successfully or not
	  */
	 public boolean TerminateLeader(LeadersRegister Leader);
	 /**
	  * 
	  * @param LeadersRegister the Leader
	  * @return whether LeadersRegister was deleted successfully or not
	  */
	public boolean deleteLeader(LeadersRegister Leader);
	
	 /**
	  * Retrieve all {@link LeadersRegister}
	  * @return List{@link List} of all Leaders
	  */
	public List<LeadersRegister> getAllLeaders(int startIndex , int endIndex);
	
	
	/**
	  * Retrieve all {@link LeadersRegister}
	  * @return List{@link List} of all Leaders
	  */
	public List<LeadersRegister> getLeadersList();

}
