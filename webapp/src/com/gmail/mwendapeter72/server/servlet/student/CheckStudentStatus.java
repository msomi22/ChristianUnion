/******************************************************************************
 * ****************************************************************************
 ************* MAASAI MARA UNIVERITY CHRISTIAN UNION MANAGEMENT SYSTEM*********
 *************THIS SYSTEM IS BASED ON JAVAEE, USING MVC MODEL******************
 *************THE SYSTEM IS USED FOR STUDEN REGISTRATION TO THE UNION**********
 *************STUDENT REGISTRATION MODULE WILL BE ACCESSIBLE REMOTELY**********
 *************VIA USE OF PUBLIC IP ADDRESS OR A DOMAIN NAME********************
 *THE STUDENT WILL ALSO BE ABLE TO CHECK THEIR REGISTERD DETAILS FOR VERIFICATION
 *WHEREBY, THEY ARE ALLOWED TO MODIGY THEIR DETAILS WITHIN ONE WEEK AFTER REGISTRATION DATE
 *****************************************************************************************
 *****************************************************************************************
 *THE OTHER MODULES OR ONLY FOR ADMIN, THE ADMIN WILL APPROVE STUDEDNTS AFTER THEY REGISTER
 *THE REGISTRATION WILL REQURED RE-ACTIVATION AFTER A PERIOD OF ONE YEAR(12 MONTHS) THIS WILL
 *HAPPEN AUTOMATICALLY WITH THE HELP OF QUARTZ SCHEDULAR, FOR EFFICIENCY AND KEEPING THE SYSTEM
 *AT HIGH PERFORMANCE, SOME DATA ARE CACHED USING EHCHACE.
 **********************************************************************************************
 **********************************************************************************************
 *COPYRIGHT REMAINS TO SOFTECH SOLUTIONS, A FAST GROWING IT COMPANY
 *CONTSCTS: WWW.FASTECCHSOLUTIONS.CO.KE
 *          WWW.FACEBOOK.COM/FASTECH.CO.KE
 *
 * 
 */
package com.gmail.mwendapeter72.server.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
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
	final String STUDENT_DETAILS_ACTIVE = "Your Information  Is Still Active.";
	final String STUDENT_DETAILS_INACTIVE = "Your Information  Is 'NOT' Active,Please acivate In the Form Below.";
    
	
	 Long diffhours;
	 Long diffmin;
	 Long diffsec;
	 Long diff;
	 Long remaininghrs;
	 Long deactivationdateHOURS;
	 int days_after_deactivation;
	 int daysb4_deactivation;
	 
	 final int HOURS_IN_A__YEAR = 24*365; 
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
 	   
 	   String AdmNo = StringUtils.trimToEmpty(request.getParameter("AdmNo").toUpperCase());
 	   
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
		   Date nows = new Date();
		   Date regDate =	s.getDateOfRegistration();
		  // System.out.println("now="+nows);
		  // System.out.println("regDate="+regDate);

			 
				 diff =  nows.getTime() - regDate.getTime();
				 diffsec =  Math.abs(diff / 1000 % 60);
				 diffmin =  Math.abs(diff / (60*1000) % 60);
				 diffhours = diff / (60*60*1000);
				 
				 deactivationdateHOURS = diffhours-HOURS_IN_A__YEAR;
				 
				 //System.out.println("diff in hours btwn now and regDate = "+diffhours);
				 //System.out.println("deactivation= " + Math.floor(deactivationdateHOURS/24) +" days ago");
				 
				 //meaning the student should be deactivated
				 if(diffhours>HOURS_IN_A__YEAR){
					   days_after_deactivation = (int)Math.floor(((diffhours/24)-(HOURS_IN_A__YEAR/24))); 					  
					  // System.out.println("days elapsed after deactivation = "+days_after_deactivation);
					   
					   //student still active
				   }else{
					   daysb4_deactivation = (int)Math.floor((HOURS_IN_A__YEAR/24)-(diffhours/24)); 					 
					  // System.out.println("days remaining b4_deactivation   = "+daysb4_deactivation);
				   }
				 
				
		   //System.out.println(days);
		   
		   
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
				paramHash.put("AdmNumber",  s.getAdmNo());  
			   	
			  // request.getSession().setAttribute("academic_year", s.getAcademicYear()); 
	          // request.getSession().setAttribute("year_of_study", s.getYearOfStudy());  
	           
	           
	          // System.out.println(s.getAcademicYear()); 
	           //System.out.println(s.getYearOfStudy());  STUDENT_DETAILS_INACTIVE
	           
	           session.setAttribute(SessionConstants.STUDENT_REGISTER_DETAILS, paramHash);
	           session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, "Hi " + s.getFirstName() + ", \t " +STUDENT_DETAILS_INACTIVE+" \n " + days_after_deactivation + " Days has elapsed since we deactivated the Information.");  
	           response.sendRedirect("studentupdate.jsp");  
			    
		   }else{
			   
			  
			 //  System.out.println("Student Is Active"); 
			   session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, "Hi " + s.getFirstName() + ", \t " + STUDENT_DETAILS_ACTIVE +" \n " + daysb4_deactivation + " Days Remaining after which we will Deactivated the Information .");  
			  
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
