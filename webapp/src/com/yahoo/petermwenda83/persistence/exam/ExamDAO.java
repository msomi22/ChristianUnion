/**
 * 
 */
package com.yahoo.petermwenda83.persistence.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.yahoo.petermwenda83.bean.exam.Exam;
import com.yahoo.petermwenda83.persistence.GenericDAO;

/**
 * @author peter
 *
 */
public class ExamDAO extends GenericDAO  implements ScoolExamDAO {
	
	private static ExamDAO examDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();
	
	public static ExamDAO getInstance(){
		
		if(examDAO == null){
			examDAO = new ExamDAO();		
		}
		return examDAO;
	}
	
	/**
	 * 
	 */
	public ExamDAO() {
		super();
	}
	
	/**
	 * 
	 */
	public ExamDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}
	/* (non-Javadoc)
	 * @see com.yahoo.petermwenda83.persistence.exam.ScoolExamDAO#getExam(java.lang.String)
	 */
	@Override
	public Exam getExam(String schoolAccountUuid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.yahoo.petermwenda83.persistence.exam.ScoolExamDAO#putExam(com.yahoo.petermwenda83.bean.exam.Exam)
	 */
	@Override
	public boolean putExam(Exam exam) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.yahoo.petermwenda83.persistence.exam.ScoolExamDAO#updateExam(com.yahoo.petermwenda83.bean.exam.Exam)
	 */
	@Override
	public boolean updateExam(Exam exam) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.yahoo.petermwenda83.persistence.exam.ScoolExamDAO#getExamList(java.lang.String)
	 */
	@Override
	public List<Exam> getExamList(String schoolAccountUuid) {
		List<Exam> list = new ArrayList<>();

        try (
        		 Connection conn = dbutils.getConnection();
     	         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Exam WHERE SchoolAccountUuid = ?;");    		   
     	   ) {
         	   pstmt.setString(1, schoolAccountUuid);           
         	   try( ResultSet rset = pstmt.executeQuery();){
     	       
     	       list = beanProcessor.toBeanList(rset, Exam.class);
         	   }
        } catch (SQLException e) {
            logger.error("SQLException when getting Exam List of a school with schoolAccountUuid " + schoolAccountUuid ); 
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return list;
	}

	/* (non-Javadoc)
	 * @see com.yahoo.petermwenda83.persistence.exam.ScoolExamDAO#getExamList()
	 */
	@Override
	public List<Exam> getExamList() {
		// TODO Auto-generated method stub
		return null;
	}

}
