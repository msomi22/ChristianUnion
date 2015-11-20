/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;




/**
 * @author peter
 *
 */
public class StudentUtils2 extends DBConnectDAO {
	
	  private static StudentUtils2 studentUtils2;
	  private final Logger logger = Logger.getLogger(this.getClass());

	  public static StudentUtils2 getInstance() {
	        if (studentUtils2 == null) {
	        	studentUtils2 = new StudentUtils2();
	        }

	        return studentUtils2;
	    }
	   
	/**
	 * 
	 */
	public StudentUtils2() {
		 super();
	}
	
	public StudentUtils2(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
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
     	         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM StudentOtherInfo ");    		   
 	    ) {
        	//pstmt.setString(1, AdmNo);           
 	       	ResultSet rset = pstmt.executeQuery();
 	       	
 	       	while(rset.next()){
 	       		count = count + 1;
 	        //System.out.println(count);
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
	             PreparedStatement pstmt = conn.prepareStatement("SELECT count(*) FROM StudentOtherInfo ;");
	        		){           
	            
	            //pstmt.setString(1, AdmNo);
	                try(ResultSet rset = pstmt.executeQuery();){
	            
	            rset.next();
	            count = count + rset.getInt(1);
	           // System.out.println(count);
	                }

	        } catch (SQLException e) {
	            logger.error("SQLException while getting all incoming count of Student with AdmNo '"
	                    + AdmNo + "'");
	            logger.error(ExceptionUtils.getStackTrace(e));

	        } 
	        return count;
	    }
	
	
	
	
	
	
	

}
