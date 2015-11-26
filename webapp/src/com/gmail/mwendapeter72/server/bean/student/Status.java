/**
 * 
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.
*Contacts author the: +254718953974
*
**/
package com.gmail.mwendapeter72.server.bean.student;

import com.gmail.mwendapeter72.server.bean.AllBean;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author betty
 *
 */
public class Status extends AllBean{
	
	//Status
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



	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Status [ getUuid() =");
		builder.append(getUuid());
		builder.append(", Status =");
		builder.append(Status);
		builder.append("]");
		return builder.toString(); 
		}
	

}
