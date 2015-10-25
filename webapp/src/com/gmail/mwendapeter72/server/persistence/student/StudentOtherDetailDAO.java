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
 *COPYRIGHT REMAINS TO SOFTECH SOLUTIONS, A FAST GROWING IT COMPANY
 *CONTSCTS: WWW.FASTECCHSOLUTIONS.CO.KE
 *          WWW.FACEBOOK.COM/FASTECH.CO.KE
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

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;

/**
 * @author Muriithi<a href="mailto:mattjohnmurii@gmail.com">Muriithi John</a>
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */

public class StudentOtherDetailDAO extends DBConnectDAO implements CuStudentOtherDetailDAO {

	private static StudentOtherDetailDAO studentOtherDetailDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();
	
	public static StudentOtherDetailDAO getInstance(){
		
		if(studentOtherDetailDAO == null){
			studentOtherDetailDAO = new StudentOtherDetailDAO();		
		}
		return studentOtherDetailDAO;
	}
	
	/**
	 * 
	 */
	public StudentOtherDetailDAO() {
		super();
	}
	
	/**
	 * 
	 */
	public StudentOtherDetailDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);
	
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentOtherDetailDAO#getDetail(java.lang.String)
	 */
	public StudentOtherDetail getDetail(String StudentUuid) {
		StudentOtherDetail studentDetail = null;
        ResultSet rset = null;
        try(
        		  Connection conn = dbutils.getConnection();
           	      PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM StudentOtherInfo"
           	      		+ " WHERE studentUuid = ?;");       
        		
        		){
        	
        	 pstmt.setString(1, StudentUuid); 
	         rset = pstmt.executeQuery();
	     while(rset.next()){
	
	    	 studentDetail  = beanProcessor.toBean(rset,StudentOtherDetail.class);
	   }
        	
        	
        	
        }catch(SQLException e){
        	 logger.error("SQL Exception when getting Student Other Details  with StudentUuid: " + studentDetail);
             logger.error(ExceptionUtils.getStackTrace(e));
             
        }
        
		return studentDetail; 
	}

	@Override
	public List<StudentOtherDetail> getStudentAdmNo(String schoolaccountUuid, String StudentUuid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentOtherDetailDAO#putDetail(com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail, java.lang.String)
	 */
	@Override
	public boolean putDetail(StudentOtherDetail studentDetail) {
		
		boolean success = true;
		
		  try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO StudentOtherInfo"
						+"(Uuid,StudentUuid,Christian,Duration,Ministry,"
						+ "MinistryName,DesiredMinistry,MinistryVision) VALUES (?,?,?,?,?,?,?,?);");
    		){
			   
			   
			    pstmt.setString(1, studentDetail.getUuid());		      
			    pstmt.setString(2, studentDetail.getStudentUuid());
			    pstmt.setString(3, studentDetail.getChristian());
			    pstmt.setString(4, studentDetail.getDuration());
			    pstmt.setString(5, studentDetail.getMinistry());
			    pstmt.setString(6, studentDetail.getMinistryName());
			    pstmt.setString(7, studentDetail.getDesiredMinistry());
			    pstmt.setString(8, studentDetail.getMinistryVision());		
	                       
	            pstmt.executeUpdate();

			 
		 }catch(SQLException e){
		   logger.error("SQL Exception trying to put StudentOtherDetail: "+studentDetail);
           logger.error(ExceptionUtils.getStackTrace(e)); 
           System.out.println(ExceptionUtils.getStackTrace(e));
           success = false;
		 }
		 
		
		
		return success;
		
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentOtherDetailDAO#updateDetail(com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail)
	 */
	@Override
	public boolean updateDetail(StudentOtherDetail studentDetail, String StudentUuid) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentOtherDetailDAO#deleteDetail(com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail)
	 */
	@Override
	public boolean deleteDetail(StudentOtherDetail studentDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentOtherDetailDAO#getAllDetgail()
	 */
	public List<StudentOtherDetail> getAllDetailList(int startIndex , int endIndex) {
		 List<StudentOtherDetail> studentdotherDetailsList = new ArrayList<>();
			
			try(
					Connection conn = dbutils.getConnection();
					PreparedStatement psmt= conn.prepareStatement("SELECT * FROM StudentOtherInfo ORDER BY StudentUuid ASC LIMIT ? OFFSET ? ;");
					) {
				
				psmt.setInt(1, endIndex - startIndex);
				psmt.setInt(2, startIndex);
				
				try(ResultSet rset = psmt.executeQuery();){
				
					studentdotherDetailsList = beanProcessor.toBeanList(rset, StudentOtherDetail.class);
				}
			} catch (SQLException e) {
				logger.error("SQLException when trying to get Student Other Detail List with an index and offset.");
	            logger.error(ExceptionUtils.getStackTrace(e));
	            System.out.println(ExceptionUtils.getStackTrace(e)); 
		    }
			
			return studentdotherDetailsList;		
	}

	
}
