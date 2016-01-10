/**
 * 
 */
package com.yahoo.petermwenda83.persistence.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.yahoo.petermwenda83.bean.exam.Perfomance;
import com.yahoo.petermwenda83.bean.student.Student;
import com.yahoo.petermwenda83.persistence.GenericDAO;

/**
 * @author peter
 *
 */
public class PerfomanceDAO extends GenericDAO  implements SchoolPerfomanceDAO {
	
	private static PerfomanceDAO perfomanceDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();
	
	public static PerfomanceDAO getInstance(){
		
		if(perfomanceDAO == null){
			perfomanceDAO = new PerfomanceDAO();		
		}
		return perfomanceDAO;
	}
	
	/**
	 * 
	 */
	public PerfomanceDAO() {
		super();
	}
	
	/**
	 * 
	 */
	public PerfomanceDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	/* (non-Javadoc)
	 * @see com.yahoo.petermwenda83.persistence.exam.SchoolPerfomanceDAO#getPerformance(java.lang.String)
	 */
	@Override
	public Perfomance getPerformance(String schoolAccountUuid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.yahoo.petermwenda83.persistence.exam.SchoolPerfomanceDAO#getPerformance(com.yahoo.petermwenda83.bean.exam.Perfomance)
	 */
	@Override
	public Perfomance getPerformance(Perfomance perfomance) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.yahoo.petermwenda83.persistence.exam.SchoolPerfomanceDAO#HasScore(com.yahoo.petermwenda83.bean.exam.Perfomance)
	 */
	@Override
	public boolean HasScore(Perfomance perfomance) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.yahoo.petermwenda83.persistence.exam.SchoolPerfomanceDAO#putPerfomance(com.yahoo.petermwenda83.bean.exam.Perfomance)
	 */
	@Override
	public boolean putPerfomance(Perfomance perfomance) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.yahoo.petermwenda83.persistence.exam.SchoolPerfomanceDAO#deletePerfomance(com.yahoo.petermwenda83.bean.exam.Perfomance)
	 */
	@Override
	public boolean deletePerfomance(Perfomance perfomance) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.yahoo.petermwenda83.persistence.exam.SchoolPerfomanceDAO#getPerfomanceList(java.lang.String)
	 */
	@Override
	public List<Perfomance> getPerfomanceList(String schoolAccountUuid) {
		List<Perfomance> list = new ArrayList<>();

        try (
        		 Connection conn = dbutils.getConnection();
     	         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Perfomance WHERE SchoolAccountUuid = ?;");    		   
     	   ) {
         	   pstmt.setString(1, schoolAccountUuid);           
         	   try( ResultSet rset = pstmt.executeQuery();){
     	       
     	       list = beanProcessor.toBeanList(rset, Perfomance.class);
         	   }
        } catch (SQLException e) {
            logger.error("SQLException when getting Students List of a school with schoolAccountUuid " + schoolAccountUuid ); 
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return list;
	}

}
