/**
 *PositionDAO.java
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.student.leader.Position;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;
import com.gmail.mwendapeter72.server.persistence.student.StatusDAO;


/**
 * 
 * Persistence implementation for {@link PositionDAO}.
 * 
 * Copyright (c) FasTech Solutions Ltd., Dec 02, 2015
 * 
 * <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class PositionDAO extends DBConnectDAO implements CuPositionDAO {

	private static PositionDAO positionDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();

	/**
	 * @return {@link StatusDAO}
	 */
	public static PositionDAO getInstance(){

		if(positionDAO == null){
			positionDAO = new PositionDAO();		
		}
		return positionDAO;
	}

	/**
	 * 
	 */
	public PositionDAO() { 
		super();

	}

	/**
	 * @param databaseName the  databaseName 
	 * @param Host the  Host
	 * @param databaseUsername the databaseUsername
	 * @param databasePassword the databasePassword
	 * @param databasePort the databasePort
	 */
	public PositionDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);

	}
	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuPositionDAO#getPosition(java.lang.String)
	 */
	public Position getPosition(String Uuid) {
		Position position = null;
		ResultSet rset = null;
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Position"
						+ " WHERE Uuid = ?;");       

				){

			pstmt.setString(1, Uuid); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				position  = beanProcessor.toBean(rset,Position.class);
			}

		}catch(SQLException e){
			logger.error("SQL Exception when getting Position With Uuid: " + Uuid);
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));

		}

		return position; 
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuPositionDAO#putPosition(com.gmail.mwendapeter72.server.bean.student.leader.Position)
	 */
	public boolean putPosition(Position position) {
		boolean success = true;

		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Position"
						+"(Uuid,PositionName) VALUES (?,?);");
				){

			pstmt.setString(1, position.getUuid());		      
			pstmt.setString(2, position.getPositionName());
			pstmt.executeUpdate();


		}catch(SQLException e){
			logger.error("SQL Exception trying to put Position: "+position);
			logger.error(ExceptionUtils.getStackTrace(e)); 
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}
		
		return success;
	}

	@Override
	public boolean updatePosition(Position position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePosition(Position position) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuPositionDAO#getPositionList()
	 */
	public List<Position> getPositionList() {
		List<Position> list =new  ArrayList<>(); 
		try(   
				Connection conn = dbutils.getConnection();
				PreparedStatement  pstmt = conn.prepareStatement("SELECT * FROM Position ;");   
				ResultSet rset = pstmt.executeQuery();
				) {

			list = beanProcessor.toBeanList(rset, Position.class);

		} catch(SQLException e){
			logger.error("SQL Exception when getting Position List");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
		}

		return list;
	}

}
