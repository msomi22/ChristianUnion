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
 * @author Muriithi<a href="mailto:mattjohnmurii@gmail.com">Muriithi John</a>
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class StudentOtherDetail extends AllBean {

	/**
	 * 
	 */
	private String StudentUuid;
	private String Christian;
    private String Duration;
    private String Ministry;
    private String MinistryName;
    private String DesiredMinistry;
    private String MinistryVision;
    
	public StudentOtherDetail() {
		super();
		StudentUuid = "";
		Christian = "";
		Duration = "";
		Ministry = "";
		MinistryName = "";
		DesiredMinistry = "";
		MinistryVision ="";
		
				
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

	public String getChristian() {
		return Christian;
	}

	public void setChristian(String christian) {
		Christian = christian;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public String getMinistry() {
		return Ministry;
	}

	public void setMinistry(String ministry) {
		Ministry = ministry;
	}

	public String getMinistryName() {
		return MinistryName;
	}

	public void setMinistryName(String ministryName) {
		MinistryName = ministryName;
	}

	public String getDesiredMinistry() {
		return DesiredMinistry;
	}

	public void setDesiredMinistry(String desiredMinistry) {
		DesiredMinistry = desiredMinistry;
	}


	/**
	 * @return the ministryVision
	 */
	public String getMinistryVision() {
		return MinistryVision;
	}

	/**
	 * @param ministryVision the ministryVision to set
	 */
	public void setMinistryVision(String ministryVision) {
		MinistryVision = ministryVision;
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Student Other Details [ getUuid() =");
		builder.append(getUuid());
		builder.append(", getStudentUuid() =");
		builder.append(getStudentUuid());
		builder.append(", Christian =");
		builder.append(Christian);
		builder.append(", Duration =");
		builder.append(Duration);
		builder.append(", Ministry =");
		builder.append(Ministry);
		builder.append(", MinistryName =");
		builder.append(MinistryName);
		builder.append(", DesiredMinistry =");
		builder.append(DesiredMinistry);
		builder.append(", MinistryVision =");
		builder.append(MinistryVision);
		builder.append("]");
		return builder.toString(); 
		}
	

}
