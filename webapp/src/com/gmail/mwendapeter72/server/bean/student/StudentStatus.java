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
 * @author peter
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
