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

import com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister;
import com.gmail.mwendapeter72.server.cache.CacheVariables;
import com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO;
import com.gmail.mwendapeter72.server.persistence.student.leader.executive.ExecutiveDAO;
import com.gmail.mwendapeter72.server.session.admin.SessionConstants;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author peter
 *
 */
public class AssignExecutive extends HttpServlet{
	
	/**
	 * 
	 */
	
	private static ExecutiveDAO executiveDAO;
	private static LeadersRegisterDAO leadersRegisterDAO;
	private CacheManager cacheManager;
	private String LeaderUuid;
	//final private String STATUS_ACTIVE_UUID = "85C6F08E-902C-46C2-8746-8C50E7D11E2E";
	//final private String EXECUTIVE_UUID = "4FB843A5-9919-4008-AF08-D7FFE83EF24D";
	
	
	final String ERROR_STUDENT_EXIST_IN_EXECUTIVE_REGISTER = " This Student Is Already registerd in the Executive Register.";
	final String ERROR_STUDENT_WITH_THE_GIVEN_ROLE_EXIST_REGISTER = " Another Leader Has Already Been Assigned This Position";
	final String ERROR_STUDENT_EXIST_REGISTER = " This Student is Already Registered in The executive Register.";
	final String ERROR_STUDENT_NOT_IN_LEADERS_REGISTER = " This Student is not in the Leaders Register.";
	final String ERROR_NOT_ALLOWED = " Did you Search For The Student Before Assigning Them a Role?";
	final String ERROR_ROLE_FOR_EXECUTIVE_ONLY = "  This Position Belong To Executive Only.";
    final String SUCESS_ROLE_ASSIGNED = "  Role has been Assigned To the Student Successfully.";
    final String ERROR_POSITION_EMPTY = " Did You select a Position/Role?";
    
    
    
   
	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       executiveDAO = ExecutiveDAO.getInstance();
       leadersRegisterDAO = LeadersRegisterDAO.getInstance();
       cacheManager = CacheManager.getInstance();
   }
   
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	
	   HttpSession session = request.getSession(true);
	  
	 
	   String CategoryUuid = StringUtils.trimToEmpty(request.getParameter("CategoryUuid"));
	   LeaderUuid = StringUtils.trimToEmpty(request.getParameter("LeaderUuid"));
	 
	    if(StringUtils.isBlank(LeaderUuid)){		      
		   session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_NOT_ALLOWED); 
		    
           } else if(StringUtils.isBlank(CategoryUuid)){ 
		    session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_POSITION_EMPTY); 
		   
	           } 
	           else if(leadersRegisterDAO.getLeader(LeaderUuid) ==null){
		       session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_STUDENT_NOT_IN_LEADERS_REGISTER); 
		      
		   
	           }/*else if(leadersRegisterDAO.getLeader(StudentUuid, STATUS_ACTIVE_UUID, EXECUTIVE_UUID) ==null){
				   session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_ROLE_FOR_EXECUTIVE_ONLY); 
				   
			   }*/
               else if(executiveDAO.getExecutive(LeaderUuid) !=null){
		       session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_STUDENT_EXIST_IN_EXECUTIVE_REGISTER); 
		   
	           }else{
	        	 
	        	
		  
	       
	       
		 session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS,SUCESS_ROLE_ASSIGNED);  
	 }
	     response.sendRedirect("admin/executive.jsp");  
   }
   
   


protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doPost(request, response);
   }
   private static final long serialVersionUID = 6620435445032352974L;
}
