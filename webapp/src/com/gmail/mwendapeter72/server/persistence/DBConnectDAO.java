/**
*DBConnectDAO.java
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

import java.sql.SQLException;

import com.gmail.mwendapeter72.server.servlet.util.DbPoolUtil;




/**
 *  What is common to all data access objects (DAOs).
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
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
	 * @param databaseName the  databaseName
	 * @param Host the Host
	 * @param databaseUsername the databaseUsername
	 * @param databasePassword the databasePassword
	 * @param databasePort the databasePort
	 */
	public DBConnectDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		dbutils = new DButils(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}
	
	 
	public void closeConnections() {
		dbutils.closeConnections();
	} 
	

}
