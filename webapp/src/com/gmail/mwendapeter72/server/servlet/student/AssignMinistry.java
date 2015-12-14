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

import com.gmail.mwendapeter72.server.cache.CacheVariables;
import com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO;
import com.gmail.mwendapeter72.server.session.admin.SessionConstants;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author peter
 *
 */
public class AssignMinistry extends HttpServlet{
	/**
	 * 
	 */
	
	private static LeadersRegisterDAO leadersRegisterDAO;
	
	
	private String Position;
	private String LeadersUuid;
	private String MinistryUuid;
	final private String STATUS_ACTIVE_UUID = "85C6F08E-902C-46C2-8746-8C50E7D11E2E";
	final private String MINISTRY_UUID = "4CA4CC22-0953-4C65-B722-EAA2DD335C58";
  
    
    final String ERROR_STUDENT_MINISTRY_MISMATCH = "  This Student is not in the Leaders Register or They are Not Active.";
    final String ERROR_STUDENT_EXIST_IN_MINISTRY_REGISTER = "  This Student Is Already registerd in the Ministry Register.";
    final String ERROR_STUDENT_NOT_IN_LEADERS_REGISTER = " This Student is not in the Leaders Register.";
    final String ERROR_NOT_ALLOWED = "  Did you Search For The Student Before Assigning Them a Ministry?";
    final String SUCESS_ROLE_ASSIGNED = "  Role has been Assigned To the Student Successfully.";
    final String ERROR_ROLE_FOR_MINISTRY_HEAD_ONLY = " This Position Belong To Ministry Heads Only";
    final String ERROR_STUDENT_NO_MINISTRY = " The Student Doesn't Lead any Ministry.";
    final String ERROR_CHECK_GENDER = "  Please Check The Student Gender.";
    
    final String ERROR_MINISTRY_NAME_EMPTY = " Did You Select a Ministry?";
    final String ERROR_POSITION_EMPTY = " Did You select a Position?";
    
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
	 
	          Position = StringUtils.trimToEmpty(request.getParameter("Position"));
	          LeadersUuid = StringUtils.trimToEmpty(request.getParameter("LeadersUuid"));
	          MinistryUuid = StringUtils.trimToEmpty(request.getParameter("MinistryUuid"));
	  
	           if(StringUtils.isBlank(LeadersUuid)){ 
				     session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_NOT_ALLOWED); 
				   
			     }else if(StringUtils.isBlank(Position)){ 
		          session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_POSITION_EMPTY); 
		   
	              }
		          else if(StringUtils.isBlank(MinistryUuid)){		      
			     session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_MINISTRY_NAME_EMPTY); 
			      
	            }else if(leadersRegisterDAO.getLeader(LeadersUuid)==null){
		         session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, ERROR_STUDENT_NOT_IN_LEADERS_REGISTER);   
		       
		       }
		       else{
		 
	       	       
	       session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS,SUCESS_ROLE_ASSIGNED);  
	      
		   
	      }
	     response.sendRedirect("admin/ministry.jsp"); 
        }
   
   


protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doPost(request, response);
   }
   
   private static final long serialVersionUID = 8125378592792581155L;
}


