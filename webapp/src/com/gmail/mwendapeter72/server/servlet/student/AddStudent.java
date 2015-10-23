/**
 * 
 */
package com.gmail.mwendapeter72.server.servlet.student;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.gmail.mwendapeter72.server.session.SessionConstants;

/**
 * @author peter
 *
 */
public class AddStudent extends HttpServlet{
	
	final String ERROR_NO_STUDENT_FIRTSTNAME = "Please provide Student First Name.";
	final String STUDENT_ADD_SUCCESS = "Your Information Was Submited Successfully.";

	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
   }
   
   /**
   * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	
	  HttpSession session = request.getSession(true);
      
	   String AdmNo = StringUtils.trimToEmpty(request.getParameter("AdmNo"));
	   String FirstName = StringUtils.trimToEmpty(request.getParameter("FirstName"));
	   String SurName = StringUtils.trimToEmpty(request.getParameter("SurName"));
	   String LastName = StringUtils.trimToEmpty(request.getParameter("LastName"));
	   String Email = StringUtils.trimToEmpty(request.getParameter("Email"));
	   String Mobile = StringUtils.trimToEmpty(request.getParameter("Mobile"));
	   String GuardianContact = StringUtils.trimToEmpty(request.getParameter("GuardianContact"));
	   String DOB = StringUtils.trimToEmpty(request.getParameter("DOB"));
	   String Gender = StringUtils.trimToEmpty(request.getParameter("studentgender"));
	   String Program = StringUtils.trimToEmpty(request.getParameter("Program"));
	   String AcademicYear = StringUtils.trimToEmpty(request.getParameter("AcademicYear"));
	   String YearOfStudy = StringUtils.trimToEmpty(request.getParameter("YearOfStudy"));
	   String HomeTown = StringUtils.trimToEmpty(request.getParameter("HomeTown"));
	   String County = StringUtils.trimToEmpty(request.getParameter("County"));
	   String DateOfRegistration = StringUtils.trimToEmpty(request.getParameter("DateOfRegistration"));
	   
	   
	  
	   
	   
	
	   String StudentUuid = StringUtils.trimToEmpty(request.getParameter("StudentUuid"));
	   String Christian = StringUtils.trimToEmpty(request.getParameter("Christian"));
	   String Duration = StringUtils.trimToEmpty(request.getParameter("Duration"));
	   String Ministry = StringUtils.trimToEmpty(request.getParameter("Ministry"));
	   String MinistryName = StringUtils.trimToEmpty(request.getParameter("MinistryName"));
	   String DesiredMinistry = StringUtils.trimToEmpty(request.getParameter("DesiredMinistry"));
	   String Vision = StringUtils.trimToEmpty(request.getParameter("Vision"));
	   String Declaration = StringUtils.trimToEmpty(request.getParameter("Declaration"));
	   
	   System.out.println(AdmNo);
	   
	   
	   
	   
	   
	   session.setAttribute(SessionConstants.STUDENT_ADD_SUCCESS, STUDENT_ADD_SUCCESS); 
	   response.sendRedirect("index.jsp");  
	   
   }

   

/**
 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doPost(request, response);
   }
   
      
}
