/**
 * 
 */
package com.gmail.mwendapeter72.server.bean.student;

import java.util.Date;

import com.gmail.mwendapeter72.server.bean.AllBean;

/**
 * @author peter
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
		builder.append("Student Status [ getUuid() =");
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
