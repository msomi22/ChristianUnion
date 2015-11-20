/******************************************************************************
 * ****************************************************************************
 ************* MAASAI MARA UNIVERITY CHRISTIAN UNION MANAGEMENT SYSTEM*********
 *************THIS SYSTEM IS BASED ON JAVAEE, USING MVC MODEL******************
 *************THE SYSTEM IS USED FOR STUDEN REGISTRATION TO THE UNION**********
 *************STUDENT REGISTRATION MODULE WILL BE ACCESSIBLE REMOTELY**********
 *************VIA USE OF PUBLIC IP ADDRESS OR A DOMAIN NAME********************
 *THE STUDENT WILL ALSO BE ABLE TO CHECK THEIR REGISTERD DETAILS FOR VERIFICATION
 *WHEREBY, THEY ARE ALLOWED TO MODIGY THEIR DETAILS WITHIN ONE WEEK AFTER REGISTRATION DATE
 *****************************************************************************************
 *****************************************************************************************
 *THE OTHER MODULES OR ONLY FOR ADMIN, THE ADMIN WILL APPROVE STUDEDNTS AFTER THEY REGISTER
 *THE REGISTRATION WILL REQURED RE-ACTIVATION AFTER A PERIOD OF ONE YEAR(12 MONTHS) THIS WILL
 *HAPPEN AUTOMATICALLY WITH THE HELP OF QUARTZ SCHEDULAR, FOR EFFICIENCY AND KEEPING THE SYSTEM
 *AT HIGH PERFORMANCE, SOME DATA ARE CACHED USING EHCHACE.
 **********************************************************************************************
 **********************************************************************************************
 *COPYRIGHT REMAINS TO FASTECH SOLUTIONS, A FAST GROWING IT COMPANY IN KENYA
 *CONTSCTS: WWW.FASTECCHSOLUTIONS.CO.KE
 *          WWW.FACEBOOK.COM/FASTECH.CO.KE
 *          PHONE:0718953974
 *          
 *          
 * 
 * 
 */
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
