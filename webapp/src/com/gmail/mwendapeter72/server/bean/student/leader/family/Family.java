/**
*Family.java
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
package com.gmail.mwendapeter72.server.bean.student.leader.family;

import com.gmail.mwendapeter72.server.bean.StorableBean;

/**
 * <p>
 * A Family in MMUCU , group with a dad and mum that meets every week
 * </p>
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class Family extends StorableBean{
	
	/**
	 * 
	 */
	
	private String FamilyName;

	/**
	 * 
	 */
	public Family() {
		super();
		FamilyName = "";
	}
   
	
	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return FamilyName;
	}


	/**
	 * @param familyName the familyName to set
	 */
	public void setFamilyName(String familyName) {
		FamilyName = familyName;
	}

  

	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Family [ getUuid() =");
		builder.append(getUuid());
		builder.append(", FamilyName =");
		builder.append(FamilyName);
		builder.append("]");
		return builder.toString(); 
		}
	private static final long serialVersionUID = -3544699057076464587L;
}
