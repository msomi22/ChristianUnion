/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student.leader.executive;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.gmail.mwendapeter72.server.bean.student.leader.executive.Executive;

/**
 * @author peter
 *
 */
public class TestExecutiveDAO {
	
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	private final String UUID = "EEB79F36-EE48-4DB3-9598-455A7087ED11",
			             UUID_NEW = "94ECC9A4-8423-478C-A4F8-CADB59C5B0CD";
	
	
	private final String CATEGORY = "Pastor(Chairperson)",
			             CATEGORY_NEW = "Pastor new",
			             CATEGORY_UPDATE = "Pastor update";
	
	ExecutiveDAO store;
	

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.executive.ExecutiveDAO#getExecutive(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetExecutive() {
		store = new ExecutiveDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Executive e = new Executive();
		e = store.getExecutive(UUID);
		assertEquals(e.getUuid(),UUID);
		assertEquals(e.getCategory(),CATEGORY);
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.executive.ExecutiveDAO#putExecutive(com.gmail.mwendapeter72.server.bean.student.leader.executive.Executive)}.
	 */
	@Ignore
	@Test
	public void testPutExecutive() {
		store = new ExecutiveDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Executive e = new Executive();
		e.setUuid(UUID_NEW);
		e.setCategory(CATEGORY_NEW);
		assertTrue(store.putExecutive(e));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.executive.ExecutiveDAO#updateExecutive(com.gmail.mwendapeter72.server.bean.student.leader.executive.Executive)}.
	 */
	@Ignore
	@Test
	public void testUpdateExecutive() {
		store = new ExecutiveDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Executive e = new Executive();
		e.setUuid(UUID_NEW);
		e.setCategory(CATEGORY_UPDATE);
		assertTrue(store.updateExecutive(e)); 
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.executive.ExecutiveDAO#deleteExecutive(com.gmail.mwendapeter72.server.bean.student.leader.executive.Executive)}.
	 */
	//@Ignore
	@Test
	public void testDeleteExecutive() {
		store = new ExecutiveDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Executive e = new Executive();
		e.setUuid(UUID_NEW);
		assertTrue(store.deleteExecutive(e));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.executive.ExecutiveDAO#getAllExecutives()}.
	 */
	@Ignore
	@Test
	public void testGetAllExecutives() {
		store = new ExecutiveDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		List<Executive> list = store.getExecutiveList();	
		for (Executive e : list) {
			System.out.println(e);
		}
	}

}
