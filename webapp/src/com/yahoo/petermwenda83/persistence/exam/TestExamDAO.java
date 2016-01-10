/**
 * 
 */
package com.yahoo.petermwenda83.persistence.exam;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.yahoo.petermwenda83.bean.exam.Exam;

/**
 * @author peter
 *
 */
public class TestExamDAO {
	
	final String databaseName = "schooldb";
	final String Host = "localhost";
	final String databaseUsername = "school";
	final String databasePassword = "AllaManO1";
	final int databasePort = 5432;
	
	final String SCHOOL_UUID = "E3CDC578-37BA-4CDB-B150-DAB0409270CD";
	
	private ExamDAO store;

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.exam.ExamDAO#getExam(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetExam() {
		store = new ExamDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.exam.ExamDAO#putExam(com.yahoo.petermwenda83.bean.exam.Exam)}.
	 */
	@Ignore
	@Test
	public void testPutExam() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.exam.ExamDAO#updateExam(com.yahoo.petermwenda83.bean.exam.Exam)}.
	 */
	@Ignore
	@Test
	public void testUpdateExam() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.exam.ExamDAO#getExamList(java.lang.String)}.
	 */
	//@Ignore
	@Test
	public void testGetExamList() {
		store = new ExamDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		List<Exam> list = store.getExamList(SCHOOL_UUID);
		for (Exam perf : list) {
			System.out.println(perf); 
		}
	}
	
	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.exam.ExamDAO#getExamList(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetExamList2() {
		store = new ExamDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		List<Exam> list = store.getExamList();
		for (Exam e : list) {
			System.out.println(e); 
		}
	}

}
