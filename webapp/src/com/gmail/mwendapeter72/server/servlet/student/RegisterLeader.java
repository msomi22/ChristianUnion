/**
*RegisterLeader.java
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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister;
import com.gmail.mwendapeter72.server.cache.CacheVariables;
import com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO;
import com.gmail.mwendapeter72.server.session.admin.SessionConstants;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Servlet to Assign a Role to students 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class RegisterLeader extends HttpServlet {
	
	 private static LeadersRegisterDAO leadersRegisterDAO;
	 private CacheManager cacheManager;
	 String StudentUuid;
	
	
    private final String STATUS_ACTIVE = "85C6F08E-902C-46C2-8746-8C50E7D11E2E";
    
    final String ERROR_IS_ALREADY_IN_LEADERS_REGISTER = "  This Student is Already in the Leaders Register.";
    final String ERROR_NOT_ALLOWED = "  Did you Search For The Student Before Assigning Them a Role?";
	final String SUCESS_STUDENT_REGISTERED = "  Student has been registered Successfully.";
    final String ERROR_POSITION_EMPTY = "  Did You select a Position? you didn't";
    final String SUCESS_STUDENT_NOT_REGISTERED = " Student was not registered!";
    
   

	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       leadersRegisterDAO = LeadersRegisterDAO.getInstance();
       cacheManager = CacheManager.getInstance();
     
   }
   
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	
	   HttpSession session = request.getSession(true);
	  
	   StudentUuid = StringUtils.trimToEmpty(request.getParameter("StudentUuid"));
	   String Category = StringUtils.trimToEmpty(request.getParameter("Category"));
	 
	   
	       if(StringUtils.isBlank(StudentUuid) || StudentUuid == null){   
		    session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_NOT_ALLOWED); 
		   
	         }else if(StringUtils.isBlank(Category)){   
		      session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_POSITION_EMPTY); 
		   
	         } else if(leadersRegisterDAO.getLeader(StudentUuid,STATUS_ACTIVE) !=null){
			       session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_IS_ALREADY_IN_LEADERS_REGISTER); 
				      				   
	           }  else {
	  
				       LeadersRegister Leader = new LeadersRegister();
				       Leader.setStudentUuid(StudentUuid);
				       Leader.setStatusUuid(STATUS_ACTIVE); 
				       Leader.setCategory(Category); 
				       updateLeadersCache(Leader); 
				       leadersRegisterDAO.putLeader(Leader);  
					   session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS,SUCESS_STUDENT_REGISTERED);  
	        
	     }
	   response.sendRedirect("admin/manage.jsp");  
   }
   
   
   private void updateLeadersCache(LeadersRegister l) {
	   cacheManager.getCache(CacheVariables.CACHE_LEADERS_REGISTER_BY_UUID).put(new Element(l.getUuid(), l));
	
}


protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doPost(request, response);
   }
   
   private static final long serialVersionUID = -6861375736729795975L;

}
