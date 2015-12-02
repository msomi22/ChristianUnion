/**
 *StudentPositionDAO.java
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.student.StudentPosition;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;

/**
 * Persistence implementation for {@link StudentPosition}s
 * 
 * Copyright (c) FasTech Solutions Ltd., Dec 02, 2015
 * 
 *  <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class StudentPositionDAO extends DBConnectDAO  implements CuStudentPositionDAO {

	private static StudentPositionDAO StudentPositionDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();

	/**
	 * @return {@link StudentPositionDAO}
	 */
	public static StudentPositionDAO getInstance(){

		if(StudentPositionDAO == null){
			StudentPositionDAO = new StudentPositionDAO();		
		}
		return StudentPositionDAO;
	}

	/**
	 * 
	 */
	public StudentPositionDAO() { 
		super();

	}


	/**
	 * @param databaseName the  databaseName 
	 * @param Host the  Host
	 * @param databaseUsername the databaseUsername
	 * @param databasePassword the databasePassword
	 * @param databasePort the databasePort
	 */
	public StudentPositionDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);

	}



	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentPositionDAO#getPosition(java.lang.String)
	 */
	public StudentPosition getPosition(String StudentUuid) {
		StudentPosition StudentPosition = null;
		ResultSet rset = null;
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM StudentPosition"
						+ " WHERE studentUuid = ?;");       

				){

			pstmt.setString(1, StudentUuid); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				StudentPosition  = beanProcessor.toBean(rset,StudentPosition.class);
			}



		}catch(SQLException e){
			logger.error("SQL Exception when getting Student Position: " + StudentPosition);
			logger.error(ExceptionUtils.getStackTrace(e));

		}

		return StudentPosition; 
	}



	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentPositionDAO#putPosition(com.gmail.mwendapeter72.server.bean.student.StudentPosition)
	 */
	public boolean putPosition(StudentPosition position) {

		boolean success = true;

		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO StudentPosition"
						+"(Uuid,StudentUuid,StatusUuid,Position,StartDate,"
						+ "EndDate) VALUES (?,?,?,?,?,?);");
				){


			pstmt.setString(1, position.getUuid());		      
			pstmt.setString(2, position.getStudentUuid());
			pstmt.setString(3, position.getStatusUuid());
			pstmt.setString(4, position.getPosition());
			pstmt.setTimestamp(5, new Timestamp(position.getStartDate().getTime()));
			pstmt.setTimestamp(6, new Timestamp(position.getEndDate().getTime()));

			pstmt.executeUpdate();


		}catch(SQLException e){
			logger.error("SQL Exception trying to put StudentPosition: "+position);
			logger.error(ExceptionUtils.getStackTrace(e)); 
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}



		return success;
	}



	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentPositionDAO#updatePosition(com.gmail.mwendapeter72.server.bean.student.StudentPosition)
	 */
	public boolean updatePosition(StudentPosition position) {
		boolean success = true;

		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE StudentPosition SET StatusUuid =?," 
						+"Position =?,StartDate =?,EndDate =? WHERE StudentUuid = ?;");
				){


			pstmt.setString(1, position.getStatusUuid());
			pstmt.setString(2, position.getPosition());
			pstmt.setTimestamp(3, new Timestamp(position.getStartDate().getTime()));
			pstmt.setTimestamp(4, new Timestamp(position.getEndDate().getTime()));
			pstmt.setString(5, position.getStudentUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception trying to update StudentPosition: "+position);
			logger.error(ExceptionUtils.getStackTrace(e));  
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}
		return success;
	}



	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentPositionDAO#deletePosition(com.gmail.mwendapeter72.server.bean.student.StudentPosition)
	 */
	public boolean deletePosition(StudentPosition position) {
		boolean success = true; 
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM StudentPosition"
						+ " WHERE StudentUuid = ?;");       

				){

			pstmt.setString(1, position.getStudentUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception when deletting StudentPosition : " +position);
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;

		}

		return success;
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentPositionDAO#getAllPositions(int, int)
	 */
	public List<StudentPosition> getAllPositions(int startIndex , int endIndex) {
		List<StudentPosition> studentPositionList = new ArrayList<>();

		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement psmt= conn.prepareStatement("SELECT * FROM StudentPosition ORDER BY StudentUuid ASC LIMIT ? OFFSET ? ;");
				) {

			psmt.setInt(1, endIndex - startIndex);
			psmt.setInt(2, startIndex);

			try(ResultSet rset = psmt.executeQuery();){

				studentPositionList = beanProcessor.toBeanList(rset, StudentPosition.class);
			}
		} catch (SQLException e) {
			logger.error("SQLException when trying to get StudentPosition List with an index and offset.");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e)); 
		}

		return studentPositionList;	
	}

}
