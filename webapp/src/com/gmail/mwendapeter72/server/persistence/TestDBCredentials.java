/**
*TestDButils.java
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
package com.gmail.mwendapeter72.server.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

/**
 * Tests our class with database credentials.
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */

public class TestDBCredentials {
	private DBCredentials dBCredentials;
	@Test
	public void getConnection() throws SQLException {
		System.out.println("connection test"); 
		
	dBCredentials = new DBCredentials("cudb", "localhost", "cu", "Cu12c", 5432);
		
		Connection con; 
		con = dBCredentials.getConnection();
		System.out.println("Connection is: " + con);
	}

}

