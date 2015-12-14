/**
*FindFamilyHead.java
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
 * Servlet that Find Family heads  in the List of Student Leaders
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class FindFamilyHead  extends HttpServlet{

	/**
	 * 
	 */
	
	private static StudentDAO studentDAO;
	Student s;
	String AdmNo;
	
	final String STUDENT_FIND_SUCCESS = "  The Student Was Found in The System, See Whether You Can Assign Them some Responsibilities.";  
    final String ERROR_ADMNO_NOT_FOUND = " The Admission Number You Provided Was Not Found in The System.";
    final String ERROR_NO_ADMNO = " Did You Provide The Student's Admission Number?.";
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
		     session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_NO_ADMNO); 
		     
	   }else if(studentDAO.getStudent(AdmNo)==null){ 
		   session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_ADMNO_NOT_FOUND); 
		   
	   }else{
	   
		   s = studentDAO.getStudent(AdmNo);
		   session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS,STUDENT_FIND_SUCCESS);  
		   Map<String, String> paramHash = new HashMap<>();    	
		   paramHash.put("name", s.getFirstName()+" "+s.getLastName()+" "+s.getSurName());
		   paramHash.put("StudentUuid", s.getUuid()); 
		   paramHash.put("Gender", s.getGender()); 
		 
		   session.setAttribute(SessionConstants.STUDENT_REGISTER_DETAILS, paramHash);
		     
	   }
	    response.sendRedirect("admin/family.jsp"); 
   }
   
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doPost(request, response);
   }
   private static final long serialVersionUID = 8774678684594889037L;
}
