/**
 * 
 */
package com.gmail.mwendapeter72.server.bean.student;

import com.gmail.mwendapeter72.server.bean.AllBean;

/**
 * @author muriithi
 *
 */
public class StudentOtherDetails extends AllBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2335839952627713099L;
	/**
	 * 
	 */
	private String StudentUuid;
	private String Christian;
    private String Duration;
    private String Ministry;
    private String MinistryName;
    private String DesiredMinistry;
    
	public StudentOtherDetails() {
		super();
		StudentUuid = "";
		Christian = "";
		Duration = "";
		Ministry = "";
		MinistryName = "";
		DesiredMinistry = "";
		
				
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

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Student [ getUuid() =");
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
		builder.append("]");
		return builder.toString(); 
		}
	

}
