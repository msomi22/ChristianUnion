/**
*FindLeader.java
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
import com.gmail.mwendapeter72.server.session.admin.SessionConstants;

/**
 * This servlet finds a student to assign a role to
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class FindLeader extends HttpServlet {
	/**
	 * 
	 */
	
	private static StudentDAO studentDAO;
	Student s;
	String AdmNo;
	private final String STATUS_IN_ACTIVE = "6C03705B-E05E-420B-B5B8-C7EE36643E60";
	
	final String ERROR_EMPTY_ADMNO = " You didn't  provide the student's admission number, can i give you a chance to try again?.";
	final String SUCCESS_STUDENT_FIND = " You can add this student in the leaders register.";
    final String ERROR_ADMNO_NOT_FOUND = " The admission number was not found in the system.";
    final String ERROR_STUDENT_INACTIVE = " This student is not active.";
	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       studentDAO = StudentDAO.getInstance();
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	
	   HttpSession session = request.getSession(true);

	    AdmNo = StringUtils.trimToEmpty(request.getParameter("AdmNo"));
	        
	    if(StringUtils.isBlank(AdmNo)){
		     session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_EMPTY_ADMNO); 
		     
	   }else if(studentDAO.getStudent(AdmNo)==null){ 
		   session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_ADMNO_NOT_FOUND); 
		   
	   }else{
	   
		   s = studentDAO.getStudent(AdmNo);
		   if(StringUtils.equals(s.getStatusUuid(), STATUS_IN_ACTIVE)){
			   session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_STUDENT_INACTIVE); 
		   }else{
			   
		  
		   session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS,SUCCESS_STUDENT_FIND);  
		   Map<String, String> paramHash = new HashMap<>();    	
		   paramHash.put("fullname", s.getFirstName()+" "+s.getLastName()+" "+s.getSurName());
		   paramHash.put("StudentUuid", s.getUuid()); 
		   
		 
		   session.setAttribute(SessionConstants.STUDENT_REGISTER_DETAILS, paramHash);
		 
		   }
	   }
	    response.sendRedirect("admin/manage.jsp");  
   }
   
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doPost(request, response);
   }
   private static final long serialVersionUID = -4594768594799486053L;
}
