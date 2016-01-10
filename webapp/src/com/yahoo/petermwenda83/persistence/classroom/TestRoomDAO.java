/**
 * 
 */
package com.yahoo.petermwenda83.persistence.classroom;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author peter
 *
 */
public class TestRoomDAO {
	
	final String databaseName = "schooldb";
	final String Host = "localhost";
	final String databaseUsername = "school";
	final String databasePassword = "AllaManO1";
	final int databasePort = 5432;
	
	
	private RoomDAO store;

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.classroom.RoomDAO#getroom(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetroom() {
		store = new RoomDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.classroom.RoomDAO#putroom(com.yahoo.petermwenda83.bean.classroom.ClassRoom)}.
	 */
	@Test
	public void testPutroom() {
		store = new RoomDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.classroom.RoomDAO#updateroom(com.yahoo.petermwenda83.bean.classroom.ClassRoom)}.
	 */
	@Test
	public void testUpdateroom() {
		store = new RoomDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.classroom.RoomDAO#deleteroom(com.yahoo.petermwenda83.bean.classroom.ClassRoom)}.
	 */
	@Test
	public void testDeleteroom() {
		store = new RoomDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/**
	 * Test method for {@link com.yahoo.petermwenda83.persistence.classroom.RoomDAO#getAllRooms(java.lang.String)}.
	 */
	@Test
	public void testGetAllRooms() {
		store = new RoomDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

}
