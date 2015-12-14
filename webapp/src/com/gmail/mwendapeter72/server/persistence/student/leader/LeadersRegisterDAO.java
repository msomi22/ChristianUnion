/**
 *LeadersRegisterDAO.java
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;

/**
 * Persistence implementation for {@link LeadersRegister}s
 * 
 * Copyright (c) FasTech Solutions Ltd., Dec 02, 2015
 * 
 *  <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class LeadersRegisterDAO extends DBConnectDAO  implements CuLeadersRegisterDAO {

	private static LeadersRegisterDAO LeadersRegisterDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();

	/**
	 * @return {@link LeadersRegisterDAO}
	 */
	public static LeadersRegisterDAO getInstance(){

		if(LeadersRegisterDAO == null){
			LeadersRegisterDAO = new LeadersRegisterDAO();		
		}
		return LeadersRegisterDAO;
	}

	/**
	 * 
	 */
	public LeadersRegisterDAO() { 
		super();

	}


	/**
	 * @param databaseName the  databaseName 
	 * @param Host the  Host
	 * @param databaseUsername the databaseUsername
	 * @param databasePassword the databasePassword
	 * @param databasePort the databasePort
	 */
	public LeadersRegisterDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);

	}



	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuLeadersRegisterDAO#getLeader(java.lang.String)
	 */
	public LeadersRegister getLeader(String StudentUuid) {
		LeadersRegister LeadersRegister = null;
		ResultSet rset = null;
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM LeadersRegister"
						+ " WHERE studentUuid = ?;");       

				){

			pstmt.setString(1, StudentUuid); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				LeadersRegister  = beanProcessor.toBean(rset,LeadersRegister.class);
			}



		}catch(SQLException e){
			logger.error("SQL Exception when getting LeadersRegister: " + LeadersRegister);
			logger.error(ExceptionUtils.getStackTrace(e));

		}

		return LeadersRegister; 
	}

	

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuLeadersRegisterDAO#getLeader(java.lang.String, java.lang.String)
	 */
	@Override
	public LeadersRegister getLeader(String StudentUuid, String StatusUuid) {
		LeadersRegister LeadersRegister = null;
		ResultSet rset = null;
		
		
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM LeadersRegister"
						+ " WHERE studentUuid = ? AND StatusUuid = ? ;");       

				){

			pstmt.setString(1, StudentUuid); 
			pstmt.setString(2, StatusUuid); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				LeadersRegister  = beanProcessor.toBean(rset,LeadersRegister.class);
			}



		}catch(SQLException e){
			logger.error("SQL Exception when getting LeadersRegister: " + LeadersRegister);
			logger.error(ExceptionUtils.getStackTrace(e));

		}

		return LeadersRegister; 
	}
	
	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuLeadersRegisterDAO#getLeader(com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister)
	 */
	@Override
	public LeadersRegister getLeader(LeadersRegister Leader) {
		LeadersRegister LeadersRegister = null;
		ResultSet rset = null;
		
		
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM LeadersRegister"
						+ " WHERE StudentUuid = ? AND StatusUuid = ? AND Category = ? AND Position = ? AND SubPosition = ? ;");       

				){

			pstmt.setString(1, Leader.getStudentUuid()); 
			pstmt.setString(2, Leader.getStatusUuid()); 
			pstmt.setString(3, Leader.getCategory()); 
			pstmt.setString(4, Leader.getPosition()); 
			pstmt.setString(5, Leader.getSubPosition()); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				LeadersRegister  = beanProcessor.toBean(rset,LeadersRegister.class);
			}



		}catch(SQLException e){
			logger.error("SQL Exception when getting LeadersRegister: " + LeadersRegister);
			logger.error(ExceptionUtils.getStackTrace(e));

		}

		return LeadersRegister; 
	}


	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuLeadersRegisterDAO#HasLeader(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean HasLeader(String StudentUuid, String StatusUuid) {
		boolean UuidExist = false;
		
		String StudeUuid = "";
		String SttusUuid = ""; 
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM LeadersRegister"
						+ " WHERE studentUuid = ? AND StatusUuid = ? ;");       
				){

			pstmt.setString(1, StudentUuid);
			pstmt.setString(2, StatusUuid);
			try(
					ResultSet rset = pstmt.executeQuery();
					) {
				
				if(rset.next()) {
					StudeUuid = rset.getString("StudentUuid");
					SttusUuid = rset.getString("StatusUuid");
					UuidExist = (StudeUuid  != StudentUuid && SttusUuid != StatusUuid) ? true : false;
					
					// System.out.println("StudentUuid from db"+StudeUuid)	;
					// System.out.println("StatusUuid from db"+SttusUuid)	;
					// System.out.println("This Student exist in the db")	;
				} 
			}
		

		}catch(SQLException e){
			logger.error("SQL Exception when getting ExecutiveHead with: ");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e)); 
		}
		//System.out.println(UuidExist);
		return UuidExist;
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuLeadersRegisterDAO#putLeader(com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister)
	 */
	public boolean putLeader(LeadersRegister Leader) {
		boolean success = true;
		if(!HasLeader(Leader.getStudentUuid(),Leader.getStatusUuid())){
		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO LeadersRegister"
						+"(Uuid,StudentUuid,StatusUuid,Category,Position,SubPosition,StartDate) VALUES (?,?,?,?,?,?,?);");
				){

			pstmt.setString(1, Leader.getUuid());		      
			pstmt.setString(2, Leader.getStudentUuid());
			pstmt.setString(3, Leader.getStatusUuid());
			pstmt.setString(4, Leader.getCategory());
			pstmt.setString(5, Leader.getPosition());
			pstmt.setString(6, Leader.getSubPosition());
			pstmt.setTimestamp(7, new Timestamp(Leader.getStartDate().getTime()));
			
			pstmt.executeUpdate();


		}catch(SQLException e){
			logger.error("SQL Exception trying to put LeadersRegister: "+Leader);
			logger.error(ExceptionUtils.getStackTrace(e)); 
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}
		
		}else{
			
			try(   Connection conn = dbutils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement("UPDATE LeadersRegister SET StatusUuid =?," 
							+"Category =?,Position =?,SubPosition =?,StartDate =? WHERE StudentUuid = ?;");
					){
				
				pstmt.setString(1, Leader.getStatusUuid());
				pstmt.setString(2, Leader.getCategory());
				pstmt.setString(3, Leader.getPosition());
				pstmt.setString(4, Leader.getSubPosition());
				pstmt.setTimestamp(5, new Timestamp(Leader.getStartDate().getTime()));
				pstmt.setString(6, Leader.getStudentUuid());
				pstmt.executeUpdate();


			}catch(SQLException e){
				logger.error("SQL Exception trying to put LeadersRegister: "+Leader);
				logger.error(ExceptionUtils.getStackTrace(e)); 
				System.out.println(ExceptionUtils.getStackTrace(e));
				success = false;
			}
			
			
		}
		
		return success;
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuLeadersRegisterDAO#updateLeader(com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister)
	 */
	public boolean updateLeader(LeadersRegister Leader) {
		boolean success = true;

		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE LeadersRegister SET StatusUuid =?," 
						+"Category =?,Position =?,SubPosition =?,StartDate =?,EndDate =? WHERE StudentUuid = ?;");
				){


			pstmt.setString(1, Leader.getStatusUuid());
			pstmt.setString(2, Leader.getCategory());
			pstmt.setString(3, Leader.getPosition());
			pstmt.setString(4, Leader.getSubPosition());
			pstmt.setTimestamp(5, new Timestamp(Leader.getStartDate().getTime()));
			pstmt.setTimestamp(6, new Timestamp(Leader.getEndDate().getTime()));
			pstmt.setString(7, Leader.getStudentUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception trying to update LeadersRegister: "+Leader);
			logger.error(ExceptionUtils.getStackTrace(e));  
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}
		return success;
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuLeadersRegisterDAO#TerminateLeader(com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister)
	 */
	public boolean TerminateLeader(LeadersRegister Leader) {
		boolean success = true;

		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE LeadersRegister SET StatusUuid =?," 
						+"EndDate =? WHERE StudentUuid = ?;");
				){


			pstmt.setString(1, Leader.getStatusUuid());
			pstmt.setTimestamp(2, new Timestamp(Leader.getEndDate().getTime()));
			pstmt.setString(3, Leader.getStudentUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception trying to update LeadersRegister: "+Leader);
			logger.error(ExceptionUtils.getStackTrace(e));  
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}
		return success;
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuLeadersRegisterDAO#deleteLeader(com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister)
	 */
	public boolean deleteLeader(LeadersRegister Leader) {
		boolean success = true; 
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM LeadersRegister"
						+ " WHERE StudentUuid = ?;");       

				){

			pstmt.setString(1, Leader.getStudentUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception when deletting LeadersRegister : " +Leader);
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;

		}

		return success;
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuLeadersRegisterDAO#getAllLeaders(int, int)
	 */
	public List<LeadersRegister> getAllLeaders(int startIndex, int endIndex) {
		List<LeadersRegister> leadersList = new ArrayList<>();

		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement psmt= conn.prepareStatement("SELECT * FROM LeadersRegister ORDER BY StudentUuid ASC LIMIT ? OFFSET ? ;");
				) {

			psmt.setInt(1, endIndex - startIndex);
			psmt.setInt(2, startIndex);

			try(ResultSet rset = psmt.executeQuery();){

				leadersList = beanProcessor.toBeanList(rset, LeadersRegister.class);
			}
		} catch (SQLException e) {
			logger.error("SQLException when trying to get List of LeadersRegister  with an index and offset.");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e)); 
		}

		return leadersList;	
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.CuLeadersRegisterDAO#getLeadersList()
	 */
	public List<LeadersRegister> getLeadersList() {
		List<LeadersRegister> leadersList = new ArrayList<>();

		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement psmt= conn.prepareStatement("SELECT * FROM LeadersRegister ORDER BY StudentUuid ;");
				) {


			try(ResultSet rset = psmt.executeQuery();){

				leadersList = beanProcessor.toBeanList(rset, LeadersRegister.class);
			}
		} catch (SQLException e) {
			logger.error("SQLException when trying to get List of  LeadersRegister.");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e)); 
		}

		return leadersList;	
	}

	
	

	

}
