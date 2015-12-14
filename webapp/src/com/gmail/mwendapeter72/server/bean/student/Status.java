/**
*Status.java
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
package com.gmail.mwendapeter72.server.bean.student;

import com.gmail.mwendapeter72.server.bean.StorableBean;

/**
 * <p>
 * A student status which is either Active or Inactive
 * </p>
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class Status extends StorableBean{
	
	
	private String Status;

	/**
	 * 
	 */
	public Status() {
		Status = "";
	}
	
	

	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Status [ getUuid() =");
		builder.append(getUuid());
		builder.append(", Status =");
		builder.append(Status);
		builder.append("]");
		return builder.toString(); 
		}
	
	private static final long serialVersionUID = 7802933881452572605L;
}
