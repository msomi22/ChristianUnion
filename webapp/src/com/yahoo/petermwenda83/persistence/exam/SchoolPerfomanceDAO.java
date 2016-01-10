/**
 * 
 */
package com.yahoo.petermwenda83.persistence.exam;

import java.util.List;

import com.yahoo.petermwenda83.bean.exam.Perfomance;

/**
 * @author peter
 *
 */
public interface SchoolPerfomanceDAO {
	
	
	
	public Perfomance getPerformance(String schoolAccountUuid); 
	/**
	 * 
	 * @param perfomance
	 * @return
	 */
	public Perfomance getPerformance(Perfomance perfomance); 
	 /**
	  * 
	  * @param perfomance
	  * @return
	  */
	public boolean HasScore(Perfomance perfomance);
	  /**
	   * 
	   * @param perfomance
	   * @return
	   */
	public boolean putPerfomance(Perfomance perfomance);
	   /**
	    * 
	    * @param perfomance
	    * @return
	    */
	public boolean deletePerfomance(Perfomance perfomance);
	   /**
	    * 
	    * @param schoolAccountUuid
	    * @return
	    */
	public List<Perfomance> getPerfomanceList(String schoolAccountUuid);

}
