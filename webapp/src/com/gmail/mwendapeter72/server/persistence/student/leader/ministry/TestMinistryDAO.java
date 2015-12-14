/**
 *TestMinistryDAO.java
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
package com.gmail.mwendapeter72.server.persistence.student.leader.ministry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.gmail.mwendapeter72.server.bean.student.leader.ministry.Ministry;


/**
 * persistence test for {@link MinistryDAO}
 * 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class TestMinistryDAO {
	
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;


	private String UUID ="6F8E71E1-1BD1-49A8-B4A2-8E27641D7CF9",
			       UUID_NEW ="5BB51ECA-B554-4C73-ACCB-F09149C81D5E";
	
	private String MIMISTRY_NAME ="Ushering",
			       MIMISTRY_NAME_NEW ="new",
			       MIMISTRY_NAME_UPDATE ="update";

	private MinistryDAO  store;


	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.ministry.MinistryDAO#getMinistry(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetMinistry() {
		store = new MinistryDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Ministry m = new Ministry();
		m = store.getMinistry(UUID);
		assertEquals(m.getUuid(),UUID);
		assertEquals(m.getMinistryName(),MIMISTRY_NAME);
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.ministry.MinistryDAO#putMinistry(com.gmail.mwendapeter72.server.bean.student.leader.ministry.Ministry)}.
	 */
	@Ignore
	@Test
	public void testPutMinistry() {
		store = new MinistryDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Ministry m = new Ministry();
		m.setUuid(UUID_NEW);
		m.setMinistryName(MIMISTRY_NAME_NEW);
		assertTrue(store.putMinistry(m));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.ministry.MinistryDAO#updateMinistry(com.gmail.mwendapeter72.server.bean.student.leader.ministry.Ministry)}.
	 */
	@Ignore
	@Test
	public void testUpdateMinistry() {
		store = new MinistryDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Ministry m = new Ministry();
		m.setUuid(UUID_NEW);
		m.setMinistryName(MIMISTRY_NAME_UPDATE);
		assertTrue(store.updateMinistry(m));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.ministry.MinistryDAO#deleteMinistry(com.gmail.mwendapeter72.server.bean.student.leader.ministry.Ministry)}.
	 */
	@Ignore
	@Test
	public void testDeleteMinistry() {
		store = new MinistryDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Ministry m = new Ministry();
		m.setUuid(UUID_NEW);
		assertTrue(store.deleteMinistry(m));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.ministry.MinistryDAO#getAllMinistres()}.
	 */
	@Ignore
	@Test
	public void testGetAllMinistres() {
		store = new MinistryDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		List<Ministry> list = store.getAllMinistres();	
		for (Ministry ss : list) {
			System.out.println(ss);
		}
	}

}
