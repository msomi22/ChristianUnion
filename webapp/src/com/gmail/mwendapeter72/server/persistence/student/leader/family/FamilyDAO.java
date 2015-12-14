/**
 *FamilyDAO.java
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
package com.gmail.mwendapeter72.server.persistence.student.leader.family;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.student.leader.family.Family;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;


/**
 * 
 * Persistence implementation for {@link FamilyDAO}
 * 
 * Copyright (c) FasTech Solutions Ltd., Dec 02, 2015
 * 
 * <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class FamilyDAO extends DBConnectDAO implements CuFamilyDAO {
	private static FamilyDAO familyDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();

	/**
	 * @return {@link FamilyDAO}
	 */
	public static FamilyDAO getInstance(){

		if(familyDAO == null){
			familyDAO = new FamilyDAO();		
		}
		return familyDAO;
	}

	/**
	 * 
	 */
	public FamilyDAO() { 
		super();

	}

	/**
	 * @param databaseName the  databaseName 
	 * @param Host the  Host
	 * @param databaseUsername the databaseUsername
	 * @param databasePassword the databasePassword
	 * @param databasePort the databasePort
	 */
	public FamilyDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);

	}
	
	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuFamilyDAO#getFamily(java.lang.String)
	 */
	public Family getFamily(String Uuid) {
		Family family = null;
		ResultSet rset = null;
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Family"
						+ " WHERE Uuid = ?;");       

				){

			pstmt.setString(1, Uuid); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				family  = beanProcessor.toBean(rset,Family.class);
			}



		}catch(SQLException e){
			logger.error("SQL Exception when getting Family with: " + Uuid);
			logger.error(ExceptionUtils.getStackTrace(e));

		}

		return family; 
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.family.CuFamilyDAO#putFamily(com.gmail.mwendapeter72.server.bean.student.leader.family.Family)
	 */
	public boolean putFamily(Family family) {		
		boolean success = true;
		  try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Family" 
			        		+"(Uuid,FamilyName) VALUES (?,?);");
  		){
			   
	            pstmt.setString(1, family.getUuid());
	            pstmt.setString(2, family.getFamilyName());
	           
	            pstmt.executeUpdate();
			 
		 }catch(SQLException e){
			 logger.error("SQL Exception trying to put Family: "+family);
             logger.error(ExceptionUtils.getStackTrace(e)); 
             System.out.println(ExceptionUtils.getStackTrace(e)); 
             success = false;
		 }
			
		return success;
		
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuFamilyDAO#updateFamily(com.gmail.mwendapeter72.server.bean.student.Family)
	 */
	@Override
	public boolean updateFamily(Family family) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuFamilyDAO#deleteFamily(com.gmail.mwendapeter72.server.bean.student.Family)
	 */
	@Override
	public boolean deleteFamily(Family family) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public List<Family> getFamilyList() {
		List<Family> list =new  ArrayList<>(); 
		try(   
				Connection conn = dbutils.getConnection();
				PreparedStatement  pstmt = conn.prepareStatement("SELECT * FROM Family;");   
				ResultSet rset = pstmt.executeQuery();
				) {

			list = beanProcessor.toBeanList(rset, Family.class);

		} catch(SQLException e){
			logger.error("SQL Exception when getting Family List");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
		}

		return list;
	}

}
