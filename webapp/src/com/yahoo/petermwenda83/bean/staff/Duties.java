
/*************************************************************
 * Online School Management System                           *
 * Forth Year Project                                        *
 * Maasai Mara University                                    *
 * Bachelor of Science(Computer Science)                     *
 * Year:2015-2016                                            *
 * Name: Njeru Mwenda Peter                                  *
 * ADM NO : BS02/009/2012                                    *
 *                                                           *
 *************************************************************/
package com.yahoo.petermwenda83.bean.staff;

import com.yahoo.petermwenda83.bean.StorableBean;

/**
 *  Teachers' Duties in a SchoolAccount
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class Duties extends StorableBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4930520236100114609L;
	private String cchoolAccountUuid;
	private String duty;

	/**
	 * 
	 */
	public Duties() {
		cchoolAccountUuid ="";
		duty ="";
	}

	/**
	 * @return the cchoolAccountUuid
	 */
	public String getCchoolAccountUuid() {
		return cchoolAccountUuid;
	}

	/**
	 * @param cchoolAccountUuid the cchoolAccountUuid to set
	 */
	public void setCchoolAccountUuid(String cchoolAccountUuid) {
		this.cchoolAccountUuid = cchoolAccountUuid;
	}

	/**
	 * @return the duty
	 */
	public String getDuty() {
		return duty;
	}

	/**
	 * @param duty the duty to set
	 */
	public void setDuty(String duty) {
		this.duty = duty;
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Duty");
		builder.append("[getUuid()=");
		builder.append(getUuid()); 
		builder.append(",cchoolAccountUuid=");
		builder.append(cchoolAccountUuid);
		builder.append(",teacherUuid=");
		builder.append(duty);
		builder.append("]");
		return builder.toString(); 
		}

}
