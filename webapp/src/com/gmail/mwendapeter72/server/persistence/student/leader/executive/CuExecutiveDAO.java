/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student.leader.executive;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.leader.executive.Executive;

/**
 * @author peter
 *
 */
public interface CuExecutiveDAO {
	 /**
	  * 
	  * @param ExecutiveUuid
	  * @return
	  */
	public Executive getExecutive(String Uuid);
	  /**
	   * 
	   * @param executive
	   * @return
	   */
	public boolean putExecutive(Executive executive);
	   /**
	    * 
	    * @param executive
	    * @return
	    */
	public boolean updateExecutive(Executive executive);
	   /**
	    * 
	    * @param executive
	    * @return
	    */
	public boolean deleteExecutive(Executive executive);
	   /**
	    * 
	    * @return
	    */
	public List<Executive> getExecutiveList();

}
