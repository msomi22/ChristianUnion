/**
*Ministry.java
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
package com.gmail.mwendapeter72.server.bean.student.leader.ministry;

import com.gmail.mwendapeter72.server.bean.StorableBean;
/**
 * <p>
 * A Ministry available in MMUCU, it has a leader
 * </p>
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class Ministry extends StorableBean{
	
	/**
	 * 
	 */
	
	private String MinistryName;

	/**
	 * 
	 */
	public Ministry() {
		super();
		MinistryName = "";
	}
    
	/**
	 * @return the ministryName
	 */
	public String getMinistryName() {
		return MinistryName;
	}

	/**
	 * @param ministryName the ministryName to set
	 */
	public void setMinistryName(String ministryName) {
		MinistryName = ministryName;
	}

	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Ministry [ getUuid() =");
		builder.append(getUuid());
		builder.append(", MinistryName =");
		builder.append(MinistryName);
		builder.append("]");
		return builder.toString(); 
		}
	private static final long serialVersionUID = 1026149847007084135L;
}
