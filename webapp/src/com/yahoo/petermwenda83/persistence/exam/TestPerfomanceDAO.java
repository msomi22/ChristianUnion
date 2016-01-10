/**
 * 
 */
package com.yahoo.petermwenda83.persistence.exam;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.yahoo.petermwenda83.bean.exam.Perfomance;

/**
 * @author peter
 *
 */
public class TestPerfomanceDAO {
	
	final String databaseName = "schooldb";
	final String Host = "localhost";
	final String databaseUsername = "school";
	final String databasePassword = "AllaManO1";
	final int databasePort = 5432;
	
	final String SCHOOL_UUID = "E3CDC578-37BA-4CDB-B150-DAB0409270CD";
	
	private PerfomanceDAO store;

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.exam.PerfomanceDAO#getPerformance(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetPerformanceString() {
		store = new PerfomanceDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.exam.PerfomanceDAO#getPerformance(com.yahoo.petermwenda83.bean.exam.Perfomance)}.
	 */
	@Ignore
	@Test
	public void testGetPerformancePerfomance() {
		store = new PerfomanceDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.exam.PerfomanceDAO#HasScore(com.yahoo.petermwenda83.bean.exam.Perfomance)}.
	 */
	@Ignore
	@Test
	public void testHasScore() {
		store = new PerfomanceDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.exam.PerfomanceDAO#putPerfomance(com.yahoo.petermwenda83.bean.exam.Perfomance)}.
	 */
	@Ignore
	@Test
	public void testPutPerfomance() {
		store = new PerfomanceDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.exam.PerfomanceDAO#deletePerfomance(com.yahoo.petermwenda83.bean.exam.Perfomance)}.
	 */
	@Ignore
	@Test
	public void testDeletePerfomance() {
		store = new PerfomanceDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.exam.PerfomanceDAO#getPerfomanceList(java.lang.String)}.
	 */
	//@Ignore
	@Test
	public void testGetPerfomanceList() {
		store = new PerfomanceDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		List<Perfomance> list = store.getPerfomanceList(SCHOOL_UUID);
		for (Perfomance perf : list) {
			System.out.println(perf); 
		}
	}

}
