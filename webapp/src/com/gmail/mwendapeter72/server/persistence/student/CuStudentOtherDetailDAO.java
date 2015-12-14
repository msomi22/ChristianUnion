/**
*CuStudentOtherDetailDAO.java
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
package com.gmail.mwendapeter72.server.persistence.student;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;


/**
 * persistence description for {@link StudentOtherDetail}s.
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author <a href="mailto:mattjohnmurii@gmail.com">Muriithi John</a>
 *
 */
public interface CuStudentOtherDetailDAO {
	
	/**
	 * Retrieve the {@link StudentOtherDetail} corresponding to the StudentUuid.
	 * @param StudentUuid the StudentUuid
	 * @return student detail object
	 */
	public StudentOtherDetail getDetail(String StudentUuid);
	
	
	/**
	 * 
	 * @param studentDetail the studentDetail
	 * @param StudentUuid the StudentUuid 
	 * @return whether the students details was inserted successfully or not
	 */
	public boolean putDetail(StudentOtherDetail studentDetail);
	
	/**
	 * 
	 * @param studentDetail the studentDetail
	 * @return whether the students details was updated successfully or not
	 */
	
	public boolean updateDetail(StudentOtherDetail studentDetail,String StudentUuid) ;
	
	/**
	 * 
	 * @param studentDetail the studentDetail
	 * @return whether the students details was deleted successfully or not
	 */
	
    public boolean deleteDetail(StudentOtherDetail studentDetail);
    
	/**
	 * Retrieve all {@link StudentOtherDetail}
	 * @return the list of all students other details
	 */
    
	public List<StudentOtherDetail> getAllDetailList(int startIndex , int endIndex);
	
	 
		/**
		 * Retrieve all {@link StudentOtherDetail}
		 * @return the list of all students other details
		 */
	    
		public List<StudentOtherDetail> getDetailList();

}
