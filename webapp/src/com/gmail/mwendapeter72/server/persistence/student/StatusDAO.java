/**
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

import com.gmail.mwendapeter72.server.bean.student.ApprovalStatus;
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
	public ApprovalStatus getStatus(String Uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#putStatus(com.gmail.mwendapeter72.server.bean.student.ApprovalStatus)
	 */
	@Override
	public boolean putStatus(ApprovalStatus status) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#updateStatus(com.gmail.mwendapeter72.server.bean.student.ApprovalStatus)
	 */
	@Override
	public boolean updateStatus(ApprovalStatus status) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#deleteStatus(com.gmail.mwendapeter72.server.bean.student.ApprovalStatus)
	 */
	@Override
	public boolean deleteStatus(ApprovalStatus status) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStatusDAO#getAllStatus()
	 */
	@Override
	public List<ApprovalStatus> getAllStatus() {
		List<ApprovalStatus> list =new  ArrayList<>(); 
		  try(   
	      		Connection conn = dbutils.getConnection();
	      		PreparedStatement  pstmt = conn.prepareStatement("SELECT * FROM ApprovalStatus ;");   
	      		ResultSet rset = pstmt.executeQuery();
	  		) {
	      	
	          list = beanProcessor.toBeanList(rset, ApprovalStatus.class);

	      } catch(SQLException e){
	      	  logger.error("SQL Exception when getting all Status");
	          logger.error(ExceptionUtils.getStackTrace(e));
	          System.out.println(ExceptionUtils.getStackTrace(e));
	      }
	   
		return list;
	}

}
