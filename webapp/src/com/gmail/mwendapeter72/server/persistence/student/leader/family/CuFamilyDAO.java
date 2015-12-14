/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student.leader.family;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.leader.family.Family;

/**
 * @author peter
 *
 */
public interface CuFamilyDAO {
	
	/**
	 * 
	 * @param Uuid
	 * @return
	 */
	public Family getFamily(String Uuid);
	 /**
	  * 
	  * @param family
	  * @return
	  */
	public boolean putFamily(Family family);
	  /**
	   * 
	   * @param family
	   * @return
	   */
	public boolean updateFamily(Family family);
	   /**
	    * 
	    * @param family
	    * @return
	    */
	public boolean deleteFamily(Family family);
	   /**
	    * 
	    * @return
	    */
	public List<Family> getFamilyList();
	
    }
