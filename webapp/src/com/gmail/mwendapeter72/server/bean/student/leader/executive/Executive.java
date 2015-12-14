/**
*Executive.java
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
package com.gmail.mwendapeter72.server.bean.student.leader.executive;

import com.gmail.mwendapeter72.server.bean.StorableBean;

/**
 * <p>
 *  MMUCU  Executives,
 * </p>
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class Executive extends StorableBean{
	
	   private String Category;


	/**
	 * 
	 */
	public Executive() {
		Category = "";
	}
  
	

	/**
	 * @return the category
	 */
	public String getCategory() {
		return Category;
	}



	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		Category = category;
	}



	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Executive [ getUuid() =");
		builder.append(getUuid());
		builder.append(", Category =");
		builder.append(Category);
		builder.append("]");
		return builder.toString(); 
		}
	private static final long serialVersionUID = 1898601694974886318L;
}
