/**
 * 
 */
package com.gmail.mwendapeter72.server.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.gmail.mwendapeter72.server.bean.student.Status;
import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.bean.student.StudentStatus;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.persistence.student.StudentStatusDAO;
import com.gmail.mwendapeter72.server.session.SessionConstants;

/**
 * @author peter
 *
 */
public class CheckStudentStatus extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -838652220274285023L;
	private static StudentDAO studentDAO;
	private static StudentStatusDAO studentStatusDAO;
	//private static StatusDAO statusDAO;
	
	HashMap<String, String> studentStatusHash = new HashMap<String, String>();
	HashMap<String, String> statusHash = new HashMap<String, String>();
	List<StudentStatus> stustatustList = new ArrayList<StudentStatus>();  
	List<Status> statustList = new ArrayList<Status>();  
	
	final String ERROR_NO_ADMNO = "Please provide Your Admission Number.";
	final String ERROR_ADMNO_NOT_FOUND = "Your Admission Number Was Not Found in the system.";
	final String STUDENT_UPDATE_SUCCESS = "Student Information  Successfully Updated.";
	final String STUDENT_DETAILS_ACTIVE = "Your Information  Is Still Active. Good bye";
	final String STUDENT_DETAILS_INACTIVE = "Your Information  Is 'NOT' Active,Please acivate In the Form Below.";

	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       studentDAO = StudentDAO.getInstance();
       studentStatusDAO = StudentStatusDAO.getInstance();
      // statusDAO = StatusDAO.getInstance();
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
 	   
 	   String AdmNo = StringUtils.trimToEmpty(request.getParameter("AdmNo"));
 	   
 	  // String AcademicYear = StringUtils.trimToEmpty(request.getParameter("AcademicYear"));
 	  // String YearOfStudy = StringUtils.trimToEmpty(request.getParameter("YearOfStudy"));
 	  // System.out.println("Admission Number ="+AdmNo); 
 	   
 	   
 	    if(StringUtils.isBlank(AdmNo)){
 	    	 response.sendRedirect("studentupdate.jsp");  
		     session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_NO_ADMNO); 
	   }else if(studentDAO.getStudent(AdmNo) ==null){
		   response.sendRedirect("studentupdate.jsp");  
		   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_ADMNO_NOT_FOUND); 
	   }else{
		   
		   String Status_inactive = StringUtils.trim("6C03705B-E05E-420B-B5B8-C7EE36643E60"); 
		   
		   Student s = studentDAO.getStudent(AdmNo);
		   String studentUuid = s.getUuid();
		   stustatustList = studentStatusDAO.getAllStudentStatus();
		   //statustList = statusDAO.getAllStatus();
		   
		   for(StudentStatus status : stustatustList){
			   studentStatusHash.put(status.getStudentUuid(), status.getStudentStatusUuid());  
		   }

		   
		   //System.out.println("StatusUuid ="+studentStatusHash.get(studentUuid)+ "For Uuid="+s.getFirstName()+"("+s.getLastName()+")"); 
		   
		   if(StringUtils.equals(studentStatusHash.get(studentUuid), Status_inactive)){
			  // System.out.println("Student Inactive"); 
			   
			    Map<String, String> paramHash = new HashMap<>();    	
			   	paramHash.put("academic_year", s.getAcademicYear());
			   	paramHash.put("year_of_study",  s.getYearOfStudy());
				paramHash.put("student_uuid",  studentUuid); 
			   	
			  // request.getSession().setAttribute("academic_year", s.getAcademicYear()); 
	          // request.getSession().setAttribute("year_of_study", s.getYearOfStudy());  
	           
	           
	          // System.out.println(s.getAcademicYear()); 
	           //System.out.println(s.getYearOfStudy());  STUDENT_DETAILS_INACTIVE
	           
	           session.setAttribute(SessionConstants.STUDENT_REGISTER_DETAILS, paramHash);
	           session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, STUDENT_DETAILS_INACTIVE);  
	           response.sendRedirect("studentupdate.jsp");  
			   
		   }else{
			   
			  
			 //  System.out.println("Student Is Active"); 
			   session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, STUDENT_DETAILS_ACTIVE);  
			  
			   response.sendRedirect("studentupdate.jsp");  
		   }
		  
           //response.sendRedirect("studentupdate.jsp");  
           
		  // s.setAcademicYear(AcademicYear);
		  // s.setYearOfStudy(YearOfStudy); 
		   //studentDAO.updateStudent(s);
		   //session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, STUDENT_UPDATE_SUCCESS);
		   
		   
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
