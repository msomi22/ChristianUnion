/**
 *TestFamilyDAO.java
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
package com.gmail.mwendapeter72.server.persistence.student.leader.family;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.gmail.mwendapeter72.server.bean.student.leader.family.Family;

/**
 * persistence test for {@link FamilyDAO}
 * 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class TestFamilyDAO {
	
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	private final String UUID = "C8F4A212-4F15-4614-ADBC-FDF58E57EA7B",
			             UUID_NEW = "94ECC9A4-8423-478C-A4F8-CADB59C5B0CD";
	
	private final String FAMILY_NAME = "Belean",
			             FAMILY_NAME_NEW = "new",
	                     FAMILY_NAME_UPDATE = "update";
	



	private FamilyDAO  store;

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.family.FamilyDAO#getFamily(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetFamily() {
		store = new FamilyDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Family f = new Family();
		f = store.getFamily(UUID);
		assertEquals(f.getUuid(),UUID);
		assertEquals(f.getFamilyName(),FAMILY_NAME);
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.family.FamilyDAO#putFamily(com.gmail.mwendapeter72.server.bean.student.leader.family.Family)}.
	 */
	@Ignore
	@Test
	public void testPutFamily() {
		store = new FamilyDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Family f = new Family();
		f.setUuid(UUID_NEW); 
		f.setFamilyName(FAMILY_NAME_NEW); 
		assertTrue(store.putFamily(f));
		
		
		
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.family.FamilyDAO#updateFamily(com.gmail.mwendapeter72.server.bean.student.leader.family.Family)}.
	 */
	@Ignore
	@Test
	public void testUpdateFamily() {
		store = new FamilyDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Family f = new Family();
		f.setUuid(UUID_NEW); 
		f.setFamilyName(FAMILY_NAME_UPDATE); 
		assertTrue(store.updateFamily(f));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.family.FamilyDAO#deleteFamily(com.gmail.mwendapeter72.server.bean.student.leader.family.Family)}.
	 */
	@Ignore
	@Test
	public void testDeleteFamily() {
		store = new FamilyDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Family f = new Family();
		f.setUuid(UUID_NEW); 
		assertTrue(store.deleteFamily(f));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.family.FamilyDAO#getAllFamilies()}.
	 */
	//@Ignore
	@Test
	public void testGetAllFamilies() {
		store = new FamilyDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		List<Family> list = store.getFamilyList();
		for (Family ss : list) {
			System.out.println(ss);
		}
	}

}
