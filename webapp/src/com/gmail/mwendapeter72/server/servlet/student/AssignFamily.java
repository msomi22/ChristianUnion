/**
*AssignFamily.java
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

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.cache.CacheVariables;
import com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO;
import com.gmail.mwendapeter72.server.session.admin.SessionConstants;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
/**
 * Servlet to Assign Families to Family heads 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class AssignFamily extends HttpServlet{
	/**
	 * 
	 */
	
	
	private static LeadersRegisterDAO leadersRegisterDAO;
	
	Student student;
	
	private String familyUuid;
	private String LeadersUuid;
	private String Category;
	
	//final private String STATUS_ACTIVE_UUID = "85C6F08E-902C-46C2-8746-8C50E7D11E2E";
	//final private String FAMILY_UUID ="33025CDD-F27F-473B-B23D-9A68DB7335B4";
	
	
	final String ERROR_STUDENT_NOT_IN_LEADERS_REGISTER = " This Student is not in the Leaders Register or They are Not Active.";
	final String ERROR_STUDENT_WITH_THE_GIVEN_ROLE_EXIST_REGISTER = " Another Leader Has Already Been Assigned This Position";
	final String ERROR_STUDENT_EXIST_IN_FAMILY_REGISTER = "  This Student Is Already registerd in the Family Register.";
	final String SUCESS_ROLE_ASSIGNED = "  Role has been Assigned To the Student Successfully.";
	final String ERROR_ROLE_FOR_FAMILY_ONLY = " This Position Belong To Familiy Heads Only.";
    final String ERROR_NOT_ALLOWED = "  Did you Search For The Student";
    final String ERROR_CATEGORY_EMPTY = " Did You select a Category";
    final String ERROR_FAMILY_EMPTY = " Did You select a Family";
    
    
    private CacheManager cacheManager;
  

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
	  
	 
	          familyUuid = StringUtils.trimToEmpty(request.getParameter("familyUuid"));
	          LeadersUuid = StringUtils.trimToEmpty(request.getParameter("LeadersUuid"));
	          Category = StringUtils.trimToEmpty(request.getParameter("Category"));
	          
	      
	        if(StringUtils.isBlank(LeadersUuid)){		      
		       session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_NOT_ALLOWED); 
		      
               }else if(StringUtils.isBlank(familyUuid)){ 
      		     session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_FAMILY_EMPTY); 
      		   
  	            }else if(StringUtils.isBlank(Category)){ 
      		     session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_CATEGORY_EMPTY); 
      		   
  	            } else if(leadersRegisterDAO.getLeader(LeadersUuid) ==null){
  			       session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_STUDENT_NOT_IN_LEADERS_REGISTER); 
  			      
  				   
	           }else {
  	  	        	 
  	  	        	   }
		               				       
			           session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS,SUCESS_ROLE_ASSIGNED);  
			
						
	    response.sendRedirect("admin/family.jsp");  
   }
   
   
   


protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doPost(request, response);
   }
   private static final long serialVersionUID = -8693860165868902896L;
}
