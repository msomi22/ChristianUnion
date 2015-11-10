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
import org.apache.commons.validator.routines.EmailValidator;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO;
import com.gmail.mwendapeter72.server.session.SessionConstants;

/**
 * @author peter
 *
 */
public class EditStudent extends HttpServlet{
	private static StudentDAO studentDAO;
	private static StudentOtherDetailDAO studentOtherDetailDAO;
	private EmailValidator emailValidator;
	
	
	final String ERROR_ADMNO_EXIST = "Admission Number Alraedy exist.";
	final String ERROR_INVALID_EMAIL = "Email address Invalid.";
	final String ERROR_INVALID_DOB = "Please provide A Valid Year of Birth.";
	
	final String ERROR_STUDENT_UPDATE = "Error! Student Details Not Updated.";
	final String STUDENT_UPDATE_SUCCESS = "Student Information  Successfully Updated.";

	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       studentDAO = StudentDAO.getInstance();
       studentOtherDetailDAO = StudentOtherDetailDAO.getInstance();
    
 
       emailValidator = EmailValidator.getInstance();
   }
   
   
   
   /**
   * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	
	   HttpSession session = request.getSession(true);
	   
	   String Uuid = StringUtils.trimToEmpty(request.getParameter("uuid"));
	   
	   String AdmNo = StringUtils.trimToEmpty(request.getParameter("admno"));
	   String FirstName = StringUtils.trimToEmpty(request.getParameter("firstname"));
	   String SurName = StringUtils.trimToEmpty(request.getParameter("surname"));
	   String LastName = StringUtils.trimToEmpty(request.getParameter("lastname"));
	   String Email = StringUtils.trimToEmpty(request.getParameter("email"));
	   String Phone = StringUtils.trimToEmpty(request.getParameter("mobile"));
	   String GuardianContact = StringUtils.trimToEmpty(request.getParameter("guardiancontact"));
	   String DOB = StringUtils.trimToEmpty(request.getParameter("dob"));
	   String Gender = StringUtils.trimToEmpty(request.getParameter("gender"));
	   String Program = StringUtils.trimToEmpty(request.getParameter("program"));
	   String AcademicYear = StringUtils.trimToEmpty(request.getParameter("academicyear"));
	   String YearOfStudy = StringUtils.trimToEmpty(request.getParameter("yearofstudy"));
	   String HomeTown = StringUtils.trimToEmpty(request.getParameter("hometown"));
	   String County = StringUtils.trimToEmpty(request.getParameter("county"));
	   
	   
	  
	   String Christian = StringUtils.trimToEmpty(request.getParameter("ischristian"));
	   String Duration = StringUtils.trimToEmpty(request.getParameter("duration"));
	   String Ministry = StringUtils.trimToEmpty(request.getParameter("hasministry"));
	   String MinistryName = StringUtils.trimToEmpty(request.getParameter("ministryname"));
	   String DesiredMinistry = StringUtils.trimToEmpty(request.getParameter("desiredministry"));
	   String Vision = StringUtils.trimToEmpty(request.getParameter("vision"));
	  
	   
	  /* System.out.println(Gender);
	   System.out.println(YearOfStudy);
	   System.out.println(Vision);*/
	   
	   /*if(studentDAO.getStudent(AdmNo) !=null){
		   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_ADMNO_EXIST); 
    	
	   } 
	   else*/ if(!emailValidator.isValid(Email)){		     
		   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_INVALID_EMAIL);  
		  	   
	   }else if(!ValidDob(DOB)){
		   session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, ERROR_INVALID_DOB); 
    	   
	   }else{
		   
		   session.setAttribute(SessionConstants.STUDENT_REGISTER_DETAILS, null);
		   
		   
			  Student s = new Student();
			  s.setUuid(Uuid);
			  s.setAdmNo(AdmNo.toUpperCase());
			  s.setFirstName(FirstName.toUpperCase());
			  s.setSurName(SurName.toUpperCase());
			  s.setLastName(LastName.toUpperCase());
			  s.setEmail(Email);
			  s.setMobile(Phone);
			  s.setGuardianContact(GuardianContact);
			  s.setDOB(DOB);
			  s.setGender(Gender.toUpperCase());
			  s.setProgram(Program.toUpperCase());
			  s.setAcademicYear(AcademicYear.toUpperCase());
			  s.setYearOfStudy(YearOfStudy);
			  s.setHomeTown(HomeTown.toUpperCase());
			  s.setCounty(County.toUpperCase());
			  studentDAO.updateStudent(s, Uuid);
			   
			  
			  StudentOtherDetail d = new StudentOtherDetail();
			  d.setStudentUuid(Uuid);
			  d.setChristian(Christian.toUpperCase());
			  d.setDuration(Duration.toUpperCase());
			  d.setMinistry(Ministry.toUpperCase());
			  d.setMinistryName(MinistryName.toUpperCase());
			  d.setDesiredMinistry(DesiredMinistry.toUpperCase());
			  d.setMinistryVision(Vision);
			  studentOtherDetailDAO.updateDetail(d, Uuid); 
			  session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, STUDENT_UPDATE_SUCCESS);
		   
	   } 
	  
	   response.sendRedirect("admin/home.jsp"); 
   }
   


private boolean ValidDob(String dOB) {
	boolean success = true;
	String regex ="\\d+";////"[0-9]+"
	if(dOB.matches(regex) && dOB.length()==4){
		success = true;
	}else{
		success = false;
	}
	return success;
}
   
   /**
   * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doPost(request, response);
   }
   
   
   
}
