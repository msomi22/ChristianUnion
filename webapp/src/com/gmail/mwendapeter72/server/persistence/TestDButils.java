/**
 * 
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.
*Contacts author the: +254718953974
*
**/
package com.gmail.mwendapeter72.server.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */

public class TestDButils {
	private DButils dButils;
	@Test
	public void getConnection() throws SQLException {
		System.out.println("connection test"); 
		
	dButils = new DButils("cudb", "localhost", "cu", "Cu12c", 5432);
		
		Connection con; 
		con = dButils.getConnection();
		System.out.println("Connection is: " + con);
	}

}

