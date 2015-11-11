/******************************************************************************
 * ****************************************************************************
 ************* MAASAI MARA UNIVERITY CHRISTIAN UNION MANAGEMENT SYSTEM*********
 *************THIS SYSTEM IS BASED ON JAVAEE, USING MVC MODEL******************
 *************THE SYSTEM IS USED FOR STUDEN REGISTRATION TO THE UNION**********
 *************STUDENT REGISTRATION MODULE WILL BE ACCESSIBLE REMOTELY**********
 *************VIA USE OF PUBLIC IP ADDRESS OR A DOMAIN NAME********************
 *THE STUDENT WILL ALSO BE ABLE TO CHECK THEIR REGISTERD DETAILS FOR VERIFICATION
 *WHEREBY, THEY ARE ALLOWED TO MODIGY THEIR DETAILS WITHIN ONE WEEK AFTER REGISTRATION DATE
 *****************************************************************************************
 *****************************************************************************************
 *THE OTHER MODULES OR ONLY FOR ADMIN, THE ADMIN WILL APPROVE STUDEDNTS AFTER THEY REGISTER
 *THE REGISTRATION WILL REQURED RE-ACTIVATION AFTER A PERIOD OF ONE YEAR(12 MONTHS) THIS WILL
 *HAPPEN AUTOMATICALLY WITH THE HELP OF QUARTZ SCHEDULAR, FOR EFFICIENCY AND KEEPING THE SYSTEM
 *AT HIGH PERFORMANCE, SOME DATA ARE CACHED USING EHCHACE.
 **********************************************************************************************
 **********************************************************************************************
 *COPYRIGHT REMAINS TO FASTECH SOLUTIONS, A FAST GROWING IT COMPANY IN KENYA
 *CONTSCTS: WWW.FASTECCHSOLUTIONS.CO.KE
 *          WWW.FACEBOOK.COM/FASTECH.CO.KE
 *          PHONE:0718953974
 *          
 *          
 * 
 * 
 */
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
	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentStatusDAO#get(java.lang.String)
	 */
	@Override
	public StudentStatus get(String StudentUuid) {
		// TODO Auto-generated method stub
		return null;
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

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentStatusDAO#updateStudentStatus(com.gmail.mwendapeter72.server.bean.student.StudentStatus)
	 */
	@Override
	public boolean updateStudentStatus(StudentStatus studentStatus) {
		// TODO Auto-generated method stub
		return false;
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
