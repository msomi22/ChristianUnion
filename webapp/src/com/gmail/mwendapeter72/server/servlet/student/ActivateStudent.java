/**
 * 
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.
*Contacts author the: +254718953974
*
**/
package com.gmail.mwendapeter72.server.servlet.student;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.session.SessionConstants;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class ActivateStudent extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6198995915322838427L;
	private static StudentDAO studentDAO;
	private EmailValidator emailValidator;
	
	final String ERROR_BLANK_ACADEMIC_YEAR = "Please provide Your Academic Year.";
	final String ERROR_UNCHANGED_ACADEMIC_YEAR = "Please Update your academic year.";
	final String ERROR_BLANK_EMAIL = "Please provide Your email address.";
	final String ERROR_EMAIN_NOT_FOUND = "Email Not found, You Must provide the email you provided during registration, If the problem persist visit MMUCU office.";
	final String ERROR_EMAIL_INVALID = "Your email address is not valid.";
	final String ERROR_BLANK_YEAR_STUDY = "Please provide Your Year of Study.";
	final String ERROR_YEAR_STUDY_INVALID = "Sorry! Year of Study is Invalid,It Must Be a Digit And can't Be Greater tahn 4 Not Unless Your Program takes Five years.";
	final String ERROR_BLANK_STUDENT_UUID = "Operation Not Allowed.";
	final String STUDENT_ACTIVATE_SUCCESS = "Student Information  Successfully Activated.";

	 String theEmail;
	 String AcademicYear;
	 Student s;
	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       studentDAO = StudentDAO.getInstance();
       emailValidator = EmailValidator.getInstance();
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
   String email = StringUtils.trimToEmpty(request.getParameter("email"));
  
   
   if(StringUtils.isBlank(academic_year)){
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_BLANK_ACADEMIC_YEAR); 
	   
   }else if(StringUtils.equals(academic_year, AcademicYear)){
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_UNCHANGED_ACADEMIC_YEAR); 
	   
   }else if(StringUtils.isBlank(email)){
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_BLANK_EMAIL); 
	   
   }else if(!emailValidator.isValid(email)){
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_EMAIL_INVALID); 
	   
   }else if(!emailFound(email) ){
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_EMAIN_NOT_FOUND); 
	   
   }else if(StringUtils.isBlank(year_of_study)){
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_BLANK_YEAR_STUDY); 
	   
    }else if(!ValidYear(year_of_study)){
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_YEAR_STUDY_INVALID); 
	   
    }else if(StringUtils.isBlank(student_uuid)){
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_BLANK_STUDENT_UUID); 
	   
    }else{
    	 
    	   s = studentDAO.getStudentByUuid(student_uuid);
    	   theEmail = s.getEmail();
    	   AcademicYear = s.getAcademicYear();
	    
	      String status_active = "85C6F08E-902C-46C2-8746-8C50E7D11E2E"; 
	     
	      Date now = new Date();
	      s.setAcademicYear(academic_year);
	      s.setYearOfStudy(year_of_study); 
	      s.setActivationDate(now); 
	      s.setStatusUuid(status_active); 
	      studentDAO.activateStudent(s); 
	     
	      session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, STUDENT_ACTIVATE_SUCCESS);
 
  
  }
   response.sendRedirect("studentupdate.jsp");  
     }
 
 
 /**
 * @param email
 * @return true or false
 */
private boolean emailFound(String email) {
	 boolean success = true;
	 if(StringUtils.equals(email, theEmail)){
		 success = true;
	 }else{
		 success = false;
	 }
	 return success;
}

/**
 * @param Year
 * @return
 */
private boolean ValidYear(String Year) {
		boolean success = true;
		String regex ="\\d+";////"[0-9]+"
		if(Year.matches(regex) && Double.parseDouble(Year)<=4){
			success = true;
		}else{
			success = false;
		}
		return success;
	}
 /**
  * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
  */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
 
 
 
}
