/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student.leader.executive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.student.leader.executive.Executive;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;

/**
 * @author peter
 *
 */
public class ExecutiveDAO extends DBConnectDAO implements CuExecutiveDAO {

	private static ExecutiveDAO executiveDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();

	/**
	 * @return {@link ExecutiveDAO}
	 */
	public static ExecutiveDAO getInstance(){
		if(executiveDAO == null){
			executiveDAO = new ExecutiveDAO();		
		}
		return executiveDAO;
	}

	/**
	 * 
	 */
	public ExecutiveDAO() { 
		super();

	}

	/**
	 * @param databaseName the  databaseName 
	 * @param Host the  Host
	 * @param databaseUsername the databaseUsername
	 * @param databasePassword the databasePassword
	 * @param databasePort the databasePort
	 */
	public ExecutiveDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);

	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.executive.CuExecutiveDAO#getExecutive(java.lang.String)
	 */
	public Executive getExecutive(String Uuid) {
		Executive executive = null;
		ResultSet rset = null;
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Executive"
						+ " WHERE Uuid = ?;");       

				){

			pstmt.setString(1, Uuid); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				executive  = beanProcessor.toBean(rset,Executive.class);
			}



		}catch(SQLException e){
			logger.error("SQL Exception when getting  Executive: " + Uuid);
			logger.error(ExceptionUtils.getStackTrace(e));

		}

		return executive; 
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.executive.CuExecutiveDAO#putExecutive(com.gmail.mwendapeter72.server.bean.student.leader.executive.Executive)
	 */
	public boolean putExecutive(Executive executive) {
		boolean success = true;
		  try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Executive" 
			        		+"(Uuid,Category) VALUES (?,?);");
		){
			   
	            pstmt.setString(1, executive.getUuid());
	            pstmt.setString(2, executive.getCategory());
	         
	            pstmt.executeUpdate();
			 
		 }catch(SQLException e){
			 logger.error("SQL Exception trying to Executive: " +executive);
             logger.error(ExceptionUtils.getStackTrace(e)); 
             System.out.println(ExceptionUtils.getStackTrace(e)); 
             success = false;
		 }
			
		return success;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuExecutiveDAO#updateExecutive(com.gmail.mwendapeter72.server.bean.student.Executive)
	 */
	@Override
	public boolean updateExecutive(Executive executive) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuExecutiveDAO#deleteExecutive(com.gmail.mwendapeter72.server.bean.student.Executive)
	 */
	@Override
	public boolean deleteExecutive(Executive executive) {
		boolean success = true; 
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Executive"
						+ " WHERE Uuid = ?;");       

				){

			pstmt.setString(1, executive.getUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception when deletting executive : " +executive);
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;

		}

		return success;
	}

	
	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.leader.executive.CuExecutiveDAO#getExecutiveList()
	 */
	public List<Executive> getExecutiveList() {
		List<Executive> list =new  ArrayList<>(); 
		try(   
				Connection conn = dbutils.getConnection();
				PreparedStatement  pstmt = conn.prepareStatement("SELECT * FROM Executive ;");   
				ResultSet rset = pstmt.executeQuery();
				) {

			list = beanProcessor.toBeanList(rset, Executive.class);

		} catch(SQLException e){
			logger.error("SQL Exception when getting Executive List");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
		}

		return list;
	}

}
