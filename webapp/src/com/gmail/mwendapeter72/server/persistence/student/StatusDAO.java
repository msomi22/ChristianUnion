/**
 *StatusDAO.java
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
package com.gmail.mwendapeter72.server.persistence.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.student.Status;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;





/**
 * 
 * Persistence implementation for {@link Status}s.
 * 
 * Copyright (c) FasTech Solutions Ltd., Dec 02, 2015
 * 
 * <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class StatusDAO extends DBConnectDAO implements CuStatusDAO {

	private static StatusDAO statusDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();

	/**
	 * @return {@link StatusDAO}
	 */
	public static StatusDAO getInstance(){

		if(statusDAO == null){
			statusDAO = new StatusDAO();		
		}
		return statusDAO;
	}

	/**
	 * 
	 */
	public StatusDAO() { 
		super();

	}

	/**
	 * @param databaseName the  databaseName 
	 * @param Host the  Host
	 * @param databaseUsername the databaseUsername
	 * @param databasePassword the databasePassword
	 * @param databasePort the databasePort
	 */
	public StatusDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);

	}


	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#getStatus(java.lang.String)
	 */
	@Override
	public Status getStatus(String Uuid) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#putStatus(com.gmail.mwendapeter72.server.bean.student.Status)
	 */
	@Override
	public boolean putStatus(Status status) {
		// TODO Auto-generated method stub
		return false;
	}


	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#updateStatus(com.gmail.mwendapeter72.server.bean.student.Status)
	 */
	@Override
	public boolean updateStatus(Status status) {
		// TODO Auto-generated method stub
		return false;
	}


	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#deleteStatus(com.gmail.mwendapeter72.server.bean.student.Status)
	 */
	@Override
	public boolean deleteStatus(Status status) {
		// TODO Auto-generated method stub
		return false;
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#getAllStatus()
	 */
	@Override
	public List<Status> getAllStatus() {
		List<Status> list =new  ArrayList<>(); 
		try(   
				Connection conn = dbutils.getConnection();
				PreparedStatement  pstmt = conn.prepareStatement("SELECT * FROM Status ;");   
				ResultSet rset = pstmt.executeQuery();
				) {

			list = beanProcessor.toBeanList(rset, Status.class);

		} catch(SQLException e){
			logger.error("SQL Exception when getting all Status");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
		}

		return list;
	}

}
