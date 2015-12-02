/**
*CheckStudentStatus.java
*
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file CAN BE copied without the author's approval for learning purposes or for use in one's own project
*if need be, feel free to contact the author
*Contacts, Mobile: +254718953974
*         email: mwendapeter72@gmail.com
*         email: petermwenda83@yahoo.com 
**/
package com.gmail.mwendapeter72.server.servlet.student;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.session.SessionConstants;


/**
 * used to check whther student is active or inactive 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class CheckStudentStatus extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -838652220274285023L;
	private static StudentDAO studentDAO;
	
	final String STATUS_INACTIVE_UUID = StringUtils.trim("6C03705B-E05E-420B-B5B8-C7EE36643E60"); 
	
	final String ERROR_NO_ADMNO = "Please provide Your Admission Number.";
	final String ERROR_ADMNO_NOT_FOUND = "Your Admission Number Was Not Found in the system.";
	final String STUDENT_UPDATE_SUCCESS = "Student Information  Successfully Updated.";
	final String STUDENT_DETAILS_ACTIVE = "Your Information  Is Still Active.";
	final String STUDENT_DETAILS_INACTIVE = "Your Information  Is 'NOT' Active,Please activate In the Form Below.";
    
	
	 Long diffhours;
	 Long diffmin;
	 Long diffsec;
	 Long diff;
	 Long remaininghrs;
	 Long deactivationdateHOURS;
	 int days_after_deactivation;
	 int daysb4_deactivation;
	 
	 final int HOURS_IN_A__YEAR = 24*365; 
	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       studentDAO = StudentDAO.getInstance();
	}
   
   /**
    * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
    */
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 	
	 HttpSession session = request.getSession(false);

     if (session != null) {
         session.invalidate();  
     }
     session = request.getSession(true);
 	   
 	   String AdmNo = StringUtils.trimToEmpty(request.getParameter("AdmNo").toUpperCase());
 	  
 	    if(StringUtils.isBlank(AdmNo)){
 	    	 response.sendRedirect("studentupdate.jsp");  
		     session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_NO_ADMNO); 
	   }else if(studentDAO.getStudent(AdmNo) ==null){
		   response.sendRedirect("studentupdate.jsp");  
		   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_ADMNO_NOT_FOUND); 
	   }else{
		   
		  
		   
		   Student s = studentDAO.getStudent(AdmNo);
		   Date nows = new Date();
		   Date regDate =	s.getActivationDate();
		  
				 diff =  nows.getTime() - regDate.getTime();
				 diffsec =  Math.abs(diff / 1000 % 60);
				 diffmin =  Math.abs(diff / (60*1000) % 60);
				 diffhours = diff / (60*60*1000);
				 
				 deactivationdateHOURS = diffhours-HOURS_IN_A__YEAR;
				 
				 //meaning the student should be deactivated
				 if(diffhours>HOURS_IN_A__YEAR){
					   days_after_deactivation = (int)Math.floor(((diffhours/24)-(HOURS_IN_A__YEAR/24))); 					  
					 
					   //student still active
				   }else{
					   daysb4_deactivation = (int)Math.floor((HOURS_IN_A__YEAR/24)-(diffhours/24)); 					 
				   }
				 
				
		   //System.out.println(days);
		  
		   if(StringUtils.equals(s.getStatusUuid(), STATUS_INACTIVE_UUID)){
			    Map<String, String> paramHash = new HashMap<>();    	
			   	paramHash.put("academic_year", s.getAcademicYear());
			   	paramHash.put("year_of_study",  s.getYearOfStudy());
				paramHash.put("student_uuid",  s.getUuid()); 
				paramHash.put("AdmNumber",  s.getAdmNo());  
			   	
			 
	           session.setAttribute(SessionConstants.STUDENT_REGISTER_DETAILS, paramHash);
	           session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, "Hi " + s.getFirstName() + ", \t " +STUDENT_DETAILS_INACTIVE+" \n " + days_after_deactivation + " Days has elapsed since we deactivated the Information.");  
	           response.sendRedirect("studentupdate.jsp");  
			    
		   }else{
			 
			   session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, "Hi " + s.getFirstName() + ", \t " + STUDENT_DETAILS_ACTIVE +" \n " + daysb4_deactivation + " Days Remaining after which we will Deactivated the Information .");  
			  
			   response.sendRedirect("studentupdate.jsp");  
		   }
		 
		   
	   }
 	   
       }
 
 
 /**
  * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
  */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
