/**
*Role.java
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
package com.gmail.mwendapeter72.server.bean.student.leader;

import com.gmail.mwendapeter72.server.bean.StorableBean;

/**
 * <p>
 * A Role/Position in MMUCU that students are assigned to
 * </p>
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class Position extends StorableBean{
	
	/**
	 * 
	 */
	
	private String PositionName;

	/**
	 * 
	 */
	public Position() {
		PositionName = "";
	}
   

	/**
	 * @return the positionName
	 */
	public String getPositionName() {
		return PositionName;
	}


	/**
	 * @param positionName the positionName to set
	 */
	public void setPositionName(String positionName) {
		PositionName = positionName;
	}


	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Position [ getUuid() =");
		builder.append(getUuid());
		builder.append(", PositionName =");
		builder.append(PositionName);
		builder.append("]");
		return builder.toString(); 
		}
	private static final long serialVersionUID = -9019509704333657384L;
}
