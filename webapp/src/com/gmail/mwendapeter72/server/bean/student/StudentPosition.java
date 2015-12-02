/**
*StudentPosition.java
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

import java.util.Date;

import com.gmail.mwendapeter72.server.bean.AllBean;

/**<p>
 * A Position/Role that a Student can assume within the System
 * </p>
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class StudentPosition extends AllBean{
	
	/**
	 * 
	 */
	
	private String StudentUuid;
	private String StatusUuid;
	private String Position;
	private Date StartDate;
	private Date EndDate;

	/**
	 * 
	 */
	public StudentPosition() {
		super();
		StudentUuid = "";
		StatusUuid = "";
		Position = "";
		StartDate = new Date();
		EndDate = new Date();
	}
   

	/**
	 * @return the studentUuid
	 */
	public String getStudentUuid() {
		return StudentUuid;
	}


	/**
	 * @param studentUuid the studentUuid to set
	 */
	public void setStudentUuid(String studentUuid) {
		StudentUuid = studentUuid;
	}


	/**
	 * @return the statusUuid
	 */
	public String getStatusUuid() {
		return StatusUuid;
	}


	/**
	 * @param statusUuid the statusUuid to set
	 */
	public void setStatusUuid(String statusUuid) {
		StatusUuid = statusUuid;
	}


	/**
	 * @return the position
	 */
	public String getPosition() {
		return Position;
	}


	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		Position = position;
	}


	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return StartDate;
	}


	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}


	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return EndDate;
	}


	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}




	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Student Position [ getUuid() =");
		builder.append(getUuid());
		builder.append(", StudentUuid =");
		builder.append(StudentUuid);
		builder.append(", StatusUuid =");
		builder.append(StatusUuid);
		builder.append(", Position =");
		builder.append(Position);
		builder.append(", StartDate =");
		builder.append(StartDate);
		builder.append(", EndDate =");
		builder.append(EndDate);
		builder.append("]");
		return builder.toString(); 
		}
	
	private static final long serialVersionUID = 7835521696219032205L;
}
