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
 */
package com.gmail.mwendapeter72.server.persistence.student;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;


/**
 * @author Muriithi<a href="mailto:mattjohnmurii@gmail.com">Muriithi John</a>
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public interface CuStudentOtherDetailDAO {
	
	/**
	 * @param StudentUuid
	 * @return student detail object
	 */
	public StudentOtherDetail getDetail(String StudentUuid);
	
	
	/**
	    * 
	    * @param schoolaccount
	    * @param admno
	    * @return	a {@link List} of {@link Student}s whose admno partly or wholly
	    * matches the admno and belongs to a particular school account. Matching is case 
	    * insensitive. An empty list is returned if no Student matches the admno.
	    */
	  public List<StudentOtherDetail> getStudentAdmNo(String schoolaccountUuid, String StudentUuid);
	
	/**
	 * 
	 * @param studentDetail
	 * @param StudentUuid
	 * @return whether the students details was inserted successfully or not
	 */
	public boolean putDetail(StudentOtherDetail studentDetail);
	
	/**
	 * 
	 * @param studentDetail
	 * @return whether the students details was updated successfully or not
	 */
	
	public boolean updateDetail(StudentOtherDetail studentDetail,String StudentUuid) ;
	
	/**
	 * 
	 * @param studentDetail 
	 * @return whether the students details was deleted successfully or not
	 */
	
    public boolean deleteDetail(StudentOtherDetail studentDetail);
    
	/**
	 * 
	 * @return the list of all students other details
	 */
    
	public List<StudentOtherDetail> getAllDetailList(int startIndex , int endIndex);

}
