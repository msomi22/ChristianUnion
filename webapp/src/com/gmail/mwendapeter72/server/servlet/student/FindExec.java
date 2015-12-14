/**
 * 
 */
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
import com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.session.admin.SessionConstants;

/**
 * @author peter
 *
 */
public class FindExec extends HttpServlet{

	
	/**
	 * 
	 */
	
	private static StudentDAO studentDAO;
	LeadersRegister sp;
	Student s;
	String AdmNo;
	
	final String STUDENT_FIND_SUCCESS = " The Student Was Found in The System, See Whether You Can Assign Them some Responsibilities.";
	final String ERROR_ADMNO_NOT_FOUND = " The Admission Number You Provided Was Not Found in The System.";
    final String ERROR_NO_ADMNO = " Did You Provide The Student's Admission Number? ";
  
   
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
		   paramHash.put("nameExecutive", s.getFirstName()+" "+s.getLastName()+" "+s.getSurName());
		   paramHash.put("StudentUuid", s.getUuid()); 
		  
		   session.setAttribute(SessionConstants.STUDENT_REGISTER_DETAILS, paramHash);
		  
	   }
	    response.sendRedirect("admin/executive.jsp"); 		    
   }
   
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doPost(request, response);
   }
   /**
	 * 
	 */
	private static final long serialVersionUID = -8564205296767775912L;
   
}
