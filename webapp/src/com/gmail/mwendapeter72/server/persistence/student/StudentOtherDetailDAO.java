/**
 *StudentOtherDetailDAO.java
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

import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;

/**
 * Persistence implementation for {@link StudentOtherDetail}s
 * 
 * Copyright (c) FasTech Solutions Ltd., Dec 02, 2015
 * 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author <a href="mailto:mattjohnmurii@gmail.com">Muriithi John</a>
 *
 */

public class StudentOtherDetailDAO extends DBConnectDAO implements CuStudentOtherDetailDAO {

	private static StudentOtherDetailDAO studentOtherDetailDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();

	/**
	 * @return {@link StudentOtherDetailDAO}
	 */
	public static StudentOtherDetailDAO getInstance(){

		if(studentOtherDetailDAO == null){
			studentOtherDetailDAO = new StudentOtherDetailDAO();		
		}
		return studentOtherDetailDAO;
	}

	/**
	 * 
	 */
	public StudentOtherDetailDAO() {
		super();
	}


	/**
	 * @param databaseName the  databaseName 
	 * @param Host the  Host
	 * @param databaseUsername the databaseUsername
	 * @param databasePassword the databasePassword
	 * @param databasePort the databasePort
	 */
	public StudentOtherDetailDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);

	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentOtherDetailDAO#getDetail(java.lang.String)
	 */
	public StudentOtherDetail getDetail(String StudentUuid) {
		StudentOtherDetail studentDetail = null;
		ResultSet rset = null;
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM StudentOtherInfo"
						+ " WHERE studentUuid = ?;");       

				){

			pstmt.setString(1, StudentUuid); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				studentDetail  = beanProcessor.toBean(rset,StudentOtherDetail.class);
			}



		}catch(SQLException e){
			logger.error("SQL Exception when getting Student Other Details  with StudentUuid: " + studentDetail);
			logger.error(ExceptionUtils.getStackTrace(e));

		}
		//System.out.println(studentDetail);
		return studentDetail; 
	}




	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentOtherDetailDAO#putDetail(com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail)
	 */
	public boolean putDetail(StudentOtherDetail studentDetail) {

		boolean success = true;

		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO StudentOtherInfo"
						+"(Uuid,StudentUuid,Christian,Duration,Ministry,"
						+ "MinistryName,DesiredMinistry,MinistryVision) VALUES (?,?,?,?,?,?,?,?);");
				){


			pstmt.setString(1, studentDetail.getUuid());		      
			pstmt.setString(2, studentDetail.getStudentUuid());
			pstmt.setString(3, studentDetail.getChristian());
			pstmt.setString(4, studentDetail.getDuration());
			pstmt.setString(5, studentDetail.getMinistry());
			pstmt.setString(6, studentDetail.getMinistryName());
			pstmt.setString(7, studentDetail.getDesiredMinistry());
			pstmt.setString(8, studentDetail.getMinistryVision());		

			pstmt.executeUpdate();


		}catch(SQLException e){
			logger.error("SQL Exception trying to put StudentOtherDetail: "+studentDetail);
			logger.error(ExceptionUtils.getStackTrace(e)); 
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}



		return success;

	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentOtherDetailDAO#updateDetail(com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail, java.lang.String)
	 */
	public boolean updateDetail(StudentOtherDetail studentDetail, String StudentUuid) {
		boolean success = true;

		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE StudentOtherInfo SET Christian =?," 
						+"Duration =?,Ministry =?,MinistryName =?,DesiredMinistry =?,MinistryVision =? WHERE StudentUuid = ?;");
				){

			pstmt.setString(1, studentDetail.getChristian());
			pstmt.setString(2, studentDetail.getDuration());
			pstmt.setString(3, studentDetail.getMinistry());	           
			pstmt.setString(4, studentDetail.getMinistryName());
			pstmt.setString(5, studentDetail.getDesiredMinistry());
			pstmt.setString(6, studentDetail.getMinistryVision());
			pstmt.setString(7, studentDetail.getStudentUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception trying to update Student Other Detail: "+studentDetail);
			logger.error(ExceptionUtils.getStackTrace(e));  
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}
		return success;
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentOtherDetailDAO#deleteDetail(com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail)
	 */
	public boolean deleteDetail(StudentOtherDetail studentDetail) {
		boolean success = true; 
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM StudentOtherInfo"
						+ " WHERE StudentUuid = ?;");       

				){

			pstmt.setString(1, studentDetail.getStudentUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception when deletting studentDetail : " +studentDetail);
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;

		}

		return success;
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentOtherDetailDAO#getAllDetailList(int, int)
	 */
	public List<StudentOtherDetail> getAllDetailList(int startIndex , int endIndex) {
		List<StudentOtherDetail> studentdotherDetailsList = new ArrayList<>();

		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement psmt= conn.prepareStatement("SELECT * FROM StudentOtherInfo ORDER BY StudentUuid ASC LIMIT ? OFFSET ? ;");
				) {

			psmt.setInt(1, endIndex - startIndex);
			psmt.setInt(2, startIndex);

			try(ResultSet rset = psmt.executeQuery();){

				studentdotherDetailsList = beanProcessor.toBeanList(rset, StudentOtherDetail.class);
			}
		} catch (SQLException e) {
			logger.error("SQLException when trying to get Student Other Detail List with an index and offset.");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e)); 
		}

		return studentdotherDetailsList;		
	}


}
