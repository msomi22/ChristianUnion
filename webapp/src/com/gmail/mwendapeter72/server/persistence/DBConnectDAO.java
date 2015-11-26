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

import java.sql.SQLException;

import com.gmail.mwendapeter72.server.servlet.util.DbPoolUtil;




/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class DBConnectDAO {

	
	 protected DButils dbutils;
	/**
	 * @throws SQLException 
	 * 
	 */
	public DBConnectDAO()  { 
	dbutils =  DbPoolUtil.getDBCredentials();
	}
	/**
	 * 
	 * @param databaseName
	 * @param Host
	 * @param databaseUsername
	 * @param databasePassword
	 * @param databasePort
	 */
	public DBConnectDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		dbutils = new DButils(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}
	
	 
	public void closeConnections() {
		dbutils.closeConnections();
	} 
	

}
