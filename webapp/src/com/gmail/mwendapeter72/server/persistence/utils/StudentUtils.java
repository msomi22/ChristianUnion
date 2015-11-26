/**
 * 
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.
*Contacts author the: +254718953974
*
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
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class StudentUtils extends DBConnectDAO {
	
	  private static StudentUtils studentUtils;
	  private final Logger logger = Logger.getLogger(this.getClass());

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
	
	public StudentUtils(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
        super(databaseName, Host, databaseUsername, databasePassword, databasePort);
    }
	
	
	/**
	 * @param SchoolAccountUuid
	 * @return
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
	 * @param accountuuid
	 * @return
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
