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
 *
 */
public class StudentStatus  extends AllBean{
	
	private String StudentUuid;
	private String StudentStatusUuid;

	/**
	 * 
	 */
	public StudentStatus() {
		StudentUuid = "";
		StudentStatusUuid = "";
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
	 * @return the studentStatusUuid
	 */
	public String getStudentStatusUuid() {
		return StudentStatusUuid;
	}


	/**
	 * @param studentStatusUuid the studentStatusUuid to set
	 */
	public void setStudentStatusUuid(String studentStatusUuid) {
		StudentStatusUuid = studentStatusUuid;
	}


	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Student Status [ getUuid() =");
		builder.append(getUuid());
		builder.append(", StudentUuid =");
		builder.append(StudentUuid);
		builder.append(", StudentStatusUuid =");
		builder.append(StudentStatusUuid);
		builder.append("]");
		return builder.toString(); 
		}
}
