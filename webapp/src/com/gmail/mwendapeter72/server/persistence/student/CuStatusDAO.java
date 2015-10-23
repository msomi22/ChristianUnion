/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student;

import com.gmail.mwendapeter72.server.bean.student.ApprovalStatus;

/**
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
	
	
	
	
	
	
	
	

}
