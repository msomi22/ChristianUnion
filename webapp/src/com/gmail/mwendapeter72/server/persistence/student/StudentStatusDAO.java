/**
 * 
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.
*Contacts author the: +254718953974
*
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

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.bean.student.StudentStatus;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;

/**
 * @author peter
 *
 */
public class StudentStatusDAO extends DBConnectDAO implements CuStudentStatusDAO {
	
	private static StudentStatusDAO studentStatusDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();
	
	public static StudentStatusDAO getInstance(){
		
		if(studentStatusDAO == null){
			studentStatusDAO = new StudentStatusDAO();		
		}
		return studentStatusDAO;
	}
	
	/**
	 * 
	 */
	public StudentStatusDAO() { 
		super();
			
	}
	
	/**
	 * 
	 */
	public StudentStatusDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);
		
	}
	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentStatusDAO#get(java.lang.String)
	 */
	@Override
	public StudentStatus get(String StudentUuid) {
		StudentStatus studentstatus = null;
        ResultSet rset = null;
        try(
        		  Connection conn = dbutils.getConnection();
           	      PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM StudentStatus WHERE StudentUuid = ?;");       
        		
        		){
        	
        	 pstmt.setString(1, StudentUuid); 
	         rset = pstmt.executeQuery();
	          while(rset.next()){
	
	        	  studentstatus  = beanProcessor.toBean(rset,StudentStatus.class);
	          }
        	
        	
        	
        }catch(SQLException e){
        	 logger.error("SQL Exception when getting StudentStatus  with StudentUuid: " + StudentUuid);
             logger.error(ExceptionUtils.getStackTrace(e));
             System.out.println(ExceptionUtils.getStackTrace(e));
        }
        
		return studentstatus; 
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentStatusDAO#putStudentStatus(com.gmail.mwendapeter72.server.bean.student.StudentStatus)
	 */
	public boolean putStudentStatus(StudentStatus studentStatus) {
		boolean success = true; 
		
		 try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO StudentStatus" 
			        		+"(Uuid,StudentUuid,StudentStatusUuid) VALUES (?,?,?);");
    		){
			   
	            pstmt.setString(1, studentStatus.getUuid());
	            pstmt.setString(2, studentStatus.getStudentUuid());
	            pstmt.setString(3, studentStatus.getStudentStatusUuid());
	          
	            pstmt.executeUpdate();
	  
		 }catch(SQLException e){
			 logger.error("SQL Exception trying to put StudentStatus: "+studentStatus);
            logger.error(ExceptionUtils.getStackTrace(e)); 
            System.out.println(ExceptionUtils.getStackTrace(e));
            success = false;
		 }
		
		
		return success;
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentStatusDAO#updateStudentStatus(com.gmail.mwendapeter72.server.bean.student.StudentStatus)
	 */
	@Override
	public boolean updateStudentStatus(StudentStatus studentStatus) {
		boolean success = true; 
		
		 try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE StudentStatus SET StudentStatusUuid =? WHERE StudentUuid =?;");
   		){
			
	            pstmt.setString(1, studentStatus.getStudentStatusUuid());
	            pstmt.setString(2, studentStatus.getStudentUuid()); 
	          
	            pstmt.executeUpdate();
	  
		 }catch(SQLException e){
			 logger.error("SQL Exception trying to put StudentStatus: "+studentStatus);
             logger.error(ExceptionUtils.getStackTrace(e)); 
             System.out.println(ExceptionUtils.getStackTrace(e));
             success = false;
		 }
		
		
		return success;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentStatusDAO#deleteStudentStatus(com.gmail.mwendapeter72.server.bean.student.StudentStatus)
	 */
	@Override
	public boolean deleteStudentStatus(StudentStatus studentStatus) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentStatusDAO#getAllStudentStatus()
	 */
	public List<StudentStatus> getAllStudentStatus() {
		List<StudentStatus> list =new  ArrayList<>(); 
		  try(   
	      		Connection conn = dbutils.getConnection();
	      		PreparedStatement  pstmt = conn.prepareStatement("SELECT * FROM StudentStatus ;");   
	      		ResultSet rset = pstmt.executeQuery();
	  		) {
	      	
	          list = beanProcessor.toBeanList(rset, StudentStatus.class);

	      } catch(SQLException e){
	      	  logger.error("SQL Exception when getting all StudentStatus");
	          logger.error(ExceptionUtils.getStackTrace(e));
	          System.out.println(ExceptionUtils.getStackTrace(e));
	      }
	   
		return list;
	}

}
