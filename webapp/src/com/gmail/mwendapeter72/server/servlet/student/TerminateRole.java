/**
*TerminateRole.java
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
 * This servlet is used to terminate a role that had been assigned to a student 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class TerminateRole extends HttpServlet  {
	
	/**
	 * 
	 */
	
	private static LeadersRegisterDAO leadersRegisterDAO;
    private final String STATUS_IN_ACTIVE = "6C03705B-E05E-420B-B5B8-C7EE36643E60";
    
    final String ROLE_TERNINATED_SUCCESS = " The Student has has been Removed from leadders Regester.";
    final String ERROR_STUDENT_INACTIVE = " This Student is Inactive.";
    final String ERROR_STH_WENT_WRONG = " Sorry but somethging went wrong.";
    
    private CacheManager cacheManager;
    LeadersRegister Leader;
   

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
	  
	   String StatusUuid = StringUtils.trimToEmpty(request.getParameter("StatusUuid"));
	   String StudentUuid = StringUtils.trimToEmpty(request.getParameter("StudentUuid"));
	  
	   //System.out.println(StatusUuid);
	  
	   if(StringUtils.isBlank(StudentUuid)){   
		   session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_STH_WENT_WRONG);
		   
	   }else if(StringUtils.equals(StatusUuid, STATUS_IN_ACTIVE)){  
		   session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_STUDENT_INACTIVE);
		   
	   }else{
	   Leader = leadersRegisterDAO.getLeader(StudentUuid);
	   Leader.setStudentUuid(StudentUuid);
	   Leader.setStatusUuid(STATUS_IN_ACTIVE);
	   leadersRegisterDAO.TerminateLeader(Leader);
	  
	   updateLeadersCache(Leader);
	   session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS,ROLE_TERNINATED_SUCCESS);  
	   
	   	   
	   }
	   response.sendRedirect("admin/manage.jsp");
   }
   
  

private void updateLeadersCache(LeadersRegister leadr) {
	   cacheManager.getCache(CacheVariables.CACHE_LEADERS_REGISTER_BY_UUID).put(new Element(leadr.getUuid(), leadr));
	  
}


protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doPost(request, response);
   }
   private static final long serialVersionUID = 8516330860219026602L;
}
