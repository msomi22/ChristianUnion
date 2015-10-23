/**
 * 
 */
package com.gmail.mwendapeter72.server.bean.student;

/**
 * @author muriithi
 *
 */
public class StudentOtherDetails extends Student{

	/**
	 * 
	 */
	private String Christian;
    private String Duration;
    private String Ministry;
    private String MinistryName;
    private String DesiredMinistry;
    
	public StudentOtherDetails() {
		super();
		Christian = "";
		Duration = "";
		Ministry = "";
		MinistryName = "";
		DesiredMinistry = "";
		
				
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
