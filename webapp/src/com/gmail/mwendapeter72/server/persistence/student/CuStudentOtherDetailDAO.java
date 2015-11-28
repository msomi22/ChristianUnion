/**
* 
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.
*Contacts author the: +254718953974
*
**/
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
