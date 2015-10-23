/**
 * 
 */
package com.gmail.mwendapeter72.server.bean.student;

import com.gmail.mwendapeter72.server.bean.AllBean;

/**
 * @author betty
 *
 */
public class ApprovalStatus extends AllBean{
	
	//Status
	private String Status;

	/**
	 * 
	 */
	public ApprovalStatus() {
		Status = "";
	}
	
	

	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Status [ getUuid() =");
		builder.append(getUuid());
		builder.append(", Status =");
		builder.append(Status);
		builder.append("]");
		return builder.toString(); 
		}
	

}
