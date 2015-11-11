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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author joram<a href="mailto:joramndungu10@gmail.com">Joram Muriithi</a>
 *
 */
public class StudentDAO extends DBConnectDAO  implements CuStudentDAO {

	private static StudentDAO studentDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();
	
	public static StudentDAO getInstance(){
		
		if(studentDAO == null){
			studentDAO = new StudentDAO();		
		}
		return studentDAO;
	}
	
	/**
	 * 
	 */
	public StudentDAO() { 
		super();
			
	}
	
	/**
	 * 
	 */
	public StudentDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);
		
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudent(java.lang.String)
	 */
	public Student getStudent(String AdmNo) {
		Student student = null;
        ResultSet rset = null;
        try(
        		  Connection conn = dbutils.getConnection();
           	      PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student WHERE AdmNo = ?;");       
        		
        		){
        	
        	 pstmt.setString(1, AdmNo); 
	         rset = pstmt.executeQuery();
	          while(rset.next()){
	
	    	 student  = beanProcessor.toBean(rset,Student.class);
	          }
        	
        	
        	
        }catch(SQLException e){
        	 logger.error("SQL Exception when getting Student  with AdmNo: " + AdmNo);
             logger.error(ExceptionUtils.getStackTrace(e));
             System.out.println(ExceptionUtils.getStackTrace(e));
        }
        
		return student; 
	}
	
	
	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudentAdmNo(java.lang.String)
	 */
	
	public List<Student> getStudentAdmNo( String admno) {
		List<Student> list = new ArrayList<>();

        try (
        		 Connection conn = dbutils.getConnection();
     	       PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student WHERE admno ILIKE ? ORDER BY admno ASC LIMIT ? OFFSET ?;;");    		   
     	   ) {
            
         	   pstmt.setString(1, "%" + admno.toUpperCase() + "%");
         	   pstmt.setInt(2, 10);
         	   pstmt.setInt(3, 0);
         	   try( ResultSet rset = pstmt.executeQuery();){
     	       
     	       list = beanProcessor.toBeanList(rset, Student.class);
         	   }
        } catch (SQLException e) {
            logger.error("SQLException when getting Student of admno '" + admno +  "'");
             logger.error(ExceptionUtils.getStackTrace(e));
        }
                
        Collections.sort(list);
        return list;
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudentByUuid(java.lang.String)
	 */
	public Student getStudentByUuid(String Uuid) {
		Student student = null;
        ResultSet rset = null;
        try(
        		  Connection conn = dbutils.getConnection();
           	      PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student WHERE Uuid = ?;");       
        		
        		){
        	
        	 pstmt.setString(1, Uuid); 
	         rset = pstmt.executeQuery();
	          while(rset.next()){
	          
	    	 student  = beanProcessor.toBean(rset,Student.class);
	          }
        	
        	
        	
        }catch(SQLException e){
        	 logger.error("SQL Exception when getting Student  with Uuid: " + Uuid);
             logger.error(ExceptionUtils.getStackTrace(e));
             System.out.println(ExceptionUtils.getStackTrace(e));
            
        }
        //System.out.println(student);
		return student; 
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#putStudent(com.gmail.mwendapeter72.server.bean.student.Student)
	 */
	public boolean putStudent(Student student) {
		boolean success = true; 
		
		 try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Student" 
			        		+"(Uuid,AdmNo,FirstName,SurName,LastName,Email,Mobile,"
			        		+ "GuardianContact,DOB,Gender,Program,AcademicYear,"
			        		+ "YearOfStudy,HomeTown,County,DateOfRegistration) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
     		){
			   
	            pstmt.setString(1, student.getUuid());
	            pstmt.setString(2, student.getAdmNo());
	            pstmt.setString(3, student.getFirstName());
	            pstmt.setString(4, student.getSurName());
	            pstmt.setString(5, student.getLastName());
	            pstmt.setString(6, student.getEmail());
	            pstmt.setString(7, student.getMobile());
	            pstmt.setString(8, student.getGuardianContact());
	            pstmt.setString(9, student.getDOB());
	            pstmt.setString(10, student.getGender());
	            pstmt.setString(11, student.getProgram());
	            pstmt.setString(12, student.getAcademicYear());
	            pstmt.setString(13, student.getYearOfStudy());
	            pstmt.setString(14, student.getHomeTown());
	            pstmt.setString(15, student.getCounty());
	            pstmt.setTimestamp(16, new Timestamp(student.getDateOfRegistration().getTime()));
	            pstmt.executeUpdate();
	            
	          
	            
	            
			 
		 }catch(SQLException e){
			 logger.error("SQL Exception trying to put Student: "+student);
             logger.error(ExceptionUtils.getStackTrace(e)); 
             System.out.println(ExceptionUtils.getStackTrace(e));
             success = false;
		 }
		
		
		return success;
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#updateStudent(com.gmail.mwendapeter72.server.bean.student.Student, java.lang.String)
	 */
	public boolean updateStudent(Student student, String Uuid) {
		boolean success = true;
		
		  try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE Student SET AdmNo =?," 
			        +"FirstName =?,SurName =?,LastName =?,Email =?,Mobile =?,"
			        + "GuardianContact =?,DOB =?,Gender=?, Program =?,AcademicYear =?,YearOfStudy=?,"
			        + " HomeTown =?,County =? WHERE Uuid = ?;");
		){
			  
	            pstmt.setString(1, student.getAdmNo());
	            pstmt.setString(2, student.getFirstName());
	            pstmt.setString(3, student.getSurName());	           
	            pstmt.setString(4, student.getLastName());
	            pstmt.setString(5, student.getEmail());
	            pstmt.setString(6, student.getMobile());
	            pstmt.setString(7, student.getGuardianContact());
	            pstmt.setString(8, student.getDOB());
	            pstmt.setString(9, student.getGender());                       
	            pstmt.setString(10, student.getProgram());
	            pstmt.setString(11, student.getAcademicYear());
	            pstmt.setString(12, student.getYearOfStudy());
	            pstmt.setString(13, student.getHomeTown());
	            pstmt.setString(14, student.getCounty());
	            pstmt.setString(15, student.getUuid());
	            pstmt.executeUpdate();
			 
		 }catch(SQLException e){
			 logger.error("SQL Exception trying to update Student: "+student);
             logger.error(ExceptionUtils.getStackTrace(e));  
             System.out.println(ExceptionUtils.getStackTrace(e));
             success = false;
		 }
		return success;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#deleteStudent(com.gmail.mwendapeter72.server.bean.student.Student, java.lang.String)
	 */
	@Override
	public boolean deleteStudent(Student student, String Uuid) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getAllStdeunt()
	 */
	public List<Student> getStudentList(int startIndex , int endIndex) {
     List<Student> studentList = new ArrayList<>();
		
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement psmt= conn.prepareStatement("SELECT * FROM Student ORDER BY AdmNo ASC LIMIT ? OFFSET ? ;");
				) {
			
			psmt.setInt(1, endIndex - startIndex);
			psmt.setInt(2, startIndex);
			
			try(ResultSet rset = psmt.executeQuery();){
			
				studentList = beanProcessor.toBeanList(rset, Student.class);
			}
		} catch (SQLException e) {
			logger.error("SQLException when trying to get a Student List with an index and offset.");
            logger.error(ExceptionUtils.getStackTrace(e));
            System.out.println(ExceptionUtils.getStackTrace(e)); 
	    }
		
		return studentList;		
	}

	
}
