/**
*StudentUtils.java
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
package com.gmail.mwendapeter72.server.persistence.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;




/**
 * Utility that manages Student(s)
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class StudentUtils extends DBConnectDAO {
	
	  private static StudentUtils studentUtils;
	  private final Logger logger = Logger.getLogger(this.getClass());

	  /**
	 * @return {@link StudentUtils }
	 */
	public static StudentUtils getInstance() {
	        if (studentUtils == null) {
	        	studentUtils = new StudentUtils();
	        }

	        return studentUtils;
	    }
	   
	/**
	 * 
	 */
	public StudentUtils() {
		 super();
	}
	
	/**
	 * @param databaseName the  databaseName 
	 * @param Host the  Host
	 * @param databaseUsername the databaseUsername
	 * @param databasePassword the databasePassword
	 * @param databasePort the databasePort
	 */
	public StudentUtils(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
        super(databaseName, Host, databaseUsername, databasePassword, databasePort);
    }
	
	
	/**
	 * @param AdmNo the AdmNo
	 * @return count
	 */
	public int getStudents(String AdmNo) {
        int count = 0;
        
        try (
        		 Connection conn = dbutils.getConnection();
     	         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student ");    		   
 	    ) {
        	//pstmt.setString(1, AdmNo);           
 	       	ResultSet rset = pstmt.executeQuery();
 	       	
 	       	while(rset.next()){
 	       		count = count + 1;
 	       //	 System.out.println(count);
 	       	}

 	       
        } catch (SQLException e) {
            //logger.error("SQLException when getting count of student with AdmNo: " + AdmNo);
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        
        return count;
    }
    
	
	 /**
	 * @param AdmNo the AdmNo
	 * @return int count
	 */
	public int getIncomingCount(String AdmNo) {
	        int count=0;

	        try ( Connection conn = dbutils.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement("SELECT count(*) FROM Student ;");
	        		){           
	            
	            //pstmt.setString(1, AdmNo);
	                try(ResultSet rset = pstmt.executeQuery();){
	            
	            rset.next();
	            count = count + rset.getInt(1);
	            System.out.println(count);
	                }

	        } catch (SQLException e) {
	            logger.error("SQLException while getting all incoming count of Student with AdmNo '"
	                    + AdmNo + "'");
	            logger.error(ExceptionUtils.getStackTrace(e));

	        } 
	        return count;
	    }
	
	
	
	
	
	
	

}
