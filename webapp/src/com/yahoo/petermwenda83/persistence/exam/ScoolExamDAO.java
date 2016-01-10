/**
 * 
 */
package com.yahoo.petermwenda83.persistence.exam;

import java.util.List;

import com.yahoo.petermwenda83.bean.exam.Exam;

/**
 * @author peter
 *
 */
public interface ScoolExamDAO {
	/**
	 * 
	 * @param schoolAccountUuid
	 * @return
	 */
	public Exam getExam(String schoolAccountUuid);
	/**
	 * 
	 * @param exam
	 * @return
	 */
	public boolean putExam(Exam exam); 
	 /**
	  * 
	  * @param exam
	  * @return
	  */
	public boolean updateExam(Exam exam); 
	 /**
	  * 
	  * @param schoolAccountUuid
	  * @return
	  */
	public List<Exam> getExamList(String schoolAccountUuid); 
	 /**
	  * 
	  * @return
	  */
	public List<Exam> getExamList(); 

}
