/**
 *TestPositionDAO.java
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
package com.gmail.mwendapeter72.server.persistence.student.leader;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.gmail.mwendapeter72.server.bean.student.leader.Position;


/**
 * persistence test for {@link PositionDAO}
 * 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class TestPositionDAO {
	
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;

	
	private String UUID = "4FB843A5-9919-4008-AF08-D7FFE83EF24D",
			       UUID_NEW = "7083D314-B693-4D25-9152-BAF9B8D4C6EF";
	
	private String POSITION_NAME = "Executive",
			       POSITION_NAME_NEW = "Executive new",
			       POSITION_NAME_UPDATE = "Executive update";


	private PositionDAO  store;


	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.PositionDAO#getRole(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetPosition() {
		store = new PositionDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Position p = new Position();
		p = store.getPosition(UUID);
		assertEquals(p.getUuid(),UUID);
		assertEquals(p.getPositionName(),POSITION_NAME);
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.PositionDAO#putRole(com.gmail.mwendapeter72.server.bean.student.leader.Position)}.
	 */
	@Ignore
	@Test
	public void testPutPosition() {
		store = new PositionDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Position p = new Position();
		p.setUuid(UUID_NEW);
		p.setPositionName(POSITION_NAME_NEW);
		assertTrue(store.putPosition(p));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.PositionDAO#updateRole(com.gmail.mwendapeter72.server.bean.student.leader.Position)}.
	 */
	@Ignore
	@Test
	public void testUpdatePosition() {
		store = new PositionDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Position p = new Position();
		p.setUuid(UUID_NEW);
		p.setPositionName(POSITION_NAME_UPDATE);
		assertTrue(store.updatePosition(p)); 
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.PositionDAO#deleteRole(com.gmail.mwendapeter72.server.bean.student.leader.Position)}.
	 */
	@Ignore
	@Test
	public void testDeletePosition() {
		store = new PositionDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		Position p = new Position();
		p.setUuid(UUID_NEW);
		assertTrue(store.deletePosition(p));  
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.PositionDAO#getAllRoles()}.
	 */
	@Ignore
	@Test
	public void testGetPositionList() {
		store = new PositionDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		List<Position> list = store.getPositionList();	
		for (Position ss : list) {
			System.out.println(ss);
		}
	}

}
