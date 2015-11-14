/**
 * 
 */
package com.gmail.mwendapeter72.server.servlet.student;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.bean.student.StudentStatus;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.persistence.student.StudentStatusDAO;
import com.gmail.mwendapeter72.server.session.SessionConstants;

/**
 * @author peter
 *
 */
public class ActivateStudent extends HttpServlet{
	
	private static StudentDAO studentDAO;
	private static StudentStatusDAO studentStatusDAO;
	
	final String ERROR_BLANK_ACADEMIC_YEAR = "Please provide Your Academic Year.";
	final String ERROR_BLANK_YEAR_STUDY = "Please provide Your Year of Study.";
	final String ERROR_BLANK_STUDENT_UUID = "Operation Not Allowed.";
	final String STUDENT_ACTIVATE_SUCCESS = "Student Information  Successfully Activated.";

	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       studentDAO = StudentDAO.getInstance();
       studentStatusDAO = StudentStatusDAO.getInstance();
	}

   /**
    * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
    */
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   HttpSession session = request.getSession(true);
	  
   String year_of_study = StringUtils.trimToEmpty(request.getParameter("year_of_study"));
   String academic_year = StringUtils.trimToEmpty(request.getParameter("academic_year"));
   String student_uuid = StringUtils.trimToEmpty(request.getParameter("student_uuid"));
   
   
  /* System.out.println("year_of_study"+year_of_study); 
   System.out.println("academic_year"+academic_year); 
   System.out.println("student_uuid"+student_uuid); 
   */

   if(StringUtils.isBlank(academic_year)){
	  // response.sendRedirect("studentupdate.jsp");  
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_BLANK_ACADEMIC_YEAR); 

  }else if(StringUtils.isBlank(year_of_study)){
	    // response.sendRedirect("studentupdate.jsp");  
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_BLANK_YEAR_STUDY); 
	
  }else if(StringUtils.isBlank(student_uuid)){
	    // response.sendRedirect("studentupdate.jsp");  
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_BLANK_STUDENT_UUID); 
	
    }else{
	  
	      Student s = studentDAO.getStudentByUuid(student_uuid);
	      String status_active = "85C6F08E-902C-46C2-8746-8C50E7D11E2E"; 
	      //System.currentTimeMillis();
	      
	      Date now = new Date();
	      s.setAcademicYear(academic_year);
	      s.setYearOfStudy(year_of_study); 
	      s.setDateOfRegistration(now); 
	      studentDAO.updateStudent(s);
	       
	      StudentStatus st = studentStatusDAO.get(student_uuid);
	      st.setStudentStatusUuid(status_active);
	      st.setStudentUuid(student_uuid);
	      studentStatusDAO.updateStudentStatus(st);
	      
	      session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, STUDENT_ACTIVATE_SUCCESS);
 
  
  }
   response.sendRedirect("studentupdate.jsp");  
     }
 
 /**
  * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
  */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
 
 
 
}
