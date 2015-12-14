/**
*AllBean.java
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
package com.gmail.mwendapeter72.server.bean;

import java.io.Serializable;
import java.util.UUID;

/**<p>
 * Represents an object in the MMUCU architecture that can be stored in the
 * RDBMS as well as cached.</p>
 * </
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class StorableBean implements Serializable {
	
	private int id;
	private String uuid;
	/**
	 * 
	 */
	public StorableBean() {
		id = 0;
		uuid = UUID.randomUUID().toString().toUpperCase(); 
	} 
	/**
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id the id
	 */
	public void setId(int id) {
		this.id = id;
	}
	 /**
	  * 
	  * @return the uuid
	  */
	public String getUuid() {
		return uuid;
	}
	/**
	 * 
	 * @param uuid the uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	private static final long serialVersionUID = 2022260668987558097L;

}
