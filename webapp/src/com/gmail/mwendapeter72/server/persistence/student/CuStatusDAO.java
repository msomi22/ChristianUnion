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
 *COPYRIGHT REMAINS TO SOFTECH SOLUTIONS, A FAST GROWING IT COMPANY
 *CONTSCTS: WWW.FASTECCHSOLUTIONS.CO.KE
 *          WWW.FACEBOOK.COM/FASTECH.CO.KE
 *          
 *          
 * 
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.ApprovalStatus;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author betty
 *
 */
public interface CuStatusDAO {
	 /**
	  * 
	  * @param Uuid
	  * @return
	  */
	public ApprovalStatus getStatus(String Uuid);
	
	/**
	 * 
	 * @param status
	 * @return whether status was inserted successfully or not
	 */
	public boolean putStatus(ApprovalStatus status);
	/**
	 * 
	 * @param status
	 * @return whether status was updated successfully or not
	 */
	public boolean updateStatus(ApprovalStatus status);
	 /**
	  * 
	  * @param status
	  * @return whether status was deleted successfully or not
	  */
	public boolean deleteStatus(ApprovalStatus status);
	
	/**
	 * 
	 * @return {@link List} List of all status
	 */
	public List<ApprovalStatus> getAllStatus();
	

}
