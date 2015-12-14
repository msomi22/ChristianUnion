/**
 *MinistryDAO.java
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.student.leader.ministry.Ministry;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;
import com.gmail.mwendapeter72.server.persistence.student.StatusDAO;


/**
 * 
 * Persistence implementation for {@link MinistryDAO}.
 * 
 * Copyright (c) FasTech Solutions Ltd., Dec 02, 2015
 * 
 * <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class MinistryDAO extends DBConnectDAO implements CuMinistryDAO {

	private static MinistryDAO ministryDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();

	/**
	 * @return {@link StatusDAO}
	 */
	public static MinistryDAO getInstance(){

		if(ministryDAO == null){
			ministryDAO = new MinistryDAO();		
		}
		return ministryDAO;
	}

	/**
	 * 
	 */
	public MinistryDAO() { 
		super();

	}

	/**
	 * @param databaseName the  databaseName 
	 * @param Host the  Host
	 * @param databaseUsername the databaseUsername
	 * @param databasePassword the databasePassword
	 * @param databasePort the databasePort
	 */
	public MinistryDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);

	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuMinistryDAO#getMinistry(java.lang.String)
	 */
	@Override
	public Ministry getMinistry(String Uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuMinistryDAO#putMinistry(com.gmail.mwendapeter72.server.bean.student.Ministry)
	 */
	@Override
	public boolean putMinistry(Ministry ministry) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuMinistryDAO#updateMinistry(com.gmail.mwendapeter72.server.bean.student.Ministry)
	 */
	@Override
	public boolean updateMinistry(Ministry ministry) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuMinistryDAO#deleteMinistry(com.gmail.mwendapeter72.server.bean.student.Ministry)
	 */
	@Override
	public boolean deleteMinistry(Ministry ministry) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.ministry.CuMinistryDAO#getAllMinistres()
	 */
	public List<Ministry> getAllMinistres() {
		List<Ministry> list =new  ArrayList<>(); 
		try(   
				Connection conn = dbutils.getConnection();
				PreparedStatement  pstmt = conn.prepareStatement("SELECT * FROM Ministry ;");   
				ResultSet rset = pstmt.executeQuery();
				) {

			list = beanProcessor.toBeanList(rset, Ministry.class);

		} catch(SQLException e){
			logger.error("SQL Exception when getting all Ministry");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
		}

		return list;
	}

}
