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

import com.gmail.mwendapeter72.server.bean.student.Status;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;


/**
 * @author peter
 *
 */
public class StatusDAO extends DBConnectDAO implements CuStatusDAO {

	private static StatusDAO statusDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();
	
	public static StatusDAO getInstance(){
		
		if(statusDAO == null){
			statusDAO = new StatusDAO();		
		}
		return statusDAO;
	}
	
	/**
	 * 
	 */
	public StatusDAO() { 
		super();
			
	}
	
	/**
	 * 
	 */
	public StatusDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);
		
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#getStatus(java.lang.String)
	 */
	@Override
	public Status getStatus(String Uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#putStatus(com.gmail.mwendapeter72.server.bean.student.ApprovalStatus)
	 */
	@Override
	public boolean putStatus(Status status) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#updateStatus(com.gmail.mwendapeter72.server.bean.student.ApprovalStatus)
	 */
	@Override
	public boolean updateStatus(Status status) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#deleteStatus(com.gmail.mwendapeter72.server.bean.student.ApprovalStatus)
	 */
	@Override
	public boolean deleteStatus(Status status) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#getAllStatus()
	 */
	@Override
	public List<Status> getAllStatus() {
		List<Status> list =new  ArrayList<>(); 
		  try(   
	      		Connection conn = dbutils.getConnection();
	      		PreparedStatement  pstmt = conn.prepareStatement("SELECT * FROM Status ;");   
	      		ResultSet rset = pstmt.executeQuery();
	  		) {
	      	
	          list = beanProcessor.toBeanList(rset, Status.class);

	      } catch(SQLException e){
	      	  logger.error("SQL Exception when getting all Status");
	          logger.error(ExceptionUtils.getStackTrace(e));
	          System.out.println(ExceptionUtils.getStackTrace(e));
	      }
	   
		return list;
	}

}
