/**
*SessionStatistics.java
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
package com.gmail.mwendapeter72.server.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * Holds data that is displayed on the portal once the admin has logged in.
 * <p>
 * The data is meant to be cached while a session is still active to avoid
 * expensive computations with the RDBMS.
 * <p>
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
 
public class SessionStatistics implements Serializable {
	
	private int allIncomingCount;
	
	//They are used to keep count against Month
    private final Map<String, Integer> studentCount;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6516924608718437954L;
   
	 public SessionStatistics() {
		 allIncomingCount =0;
		 studentCount = new HashMap<>();
	 }

	/**
	 * @return the allIncomingCount
	 */
	public int getAllIncomingCount() {
		return allIncomingCount;
	}

	/**
	 * @param allIncomingCount the allIncomingCount to set
	 */
	public void setAllIncomingCount(int allIncomingCount) {
		this.allIncomingCount = allIncomingCount;
	}

	/**
	 * @return the accountCount
	 */
	public Map<String, Integer> getStudentCount() {
		return studentCount;
	}
   
    

}

 