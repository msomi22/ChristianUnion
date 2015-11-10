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
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import com.gmail.mwendapeter72.server.bean.AllBean;
import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO;
import com.gmail.mwendapeter72.server.session.SessionConstants;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class AddStudent extends HttpServlet{
	private static StudentDAO studentDAO;
	private static StudentOtherDetailDAO studentOtherDetailDAO;
	private EmailValidator emailValidator;
	
	
	final String ERROR_NO_ADMNO = "Please provide Your Admission Number.";
	final String ERROR_ADMNO_EXIST = "Admission Number Alraedy exist.";
	
	final String ERROR_NO_STUDENT_FIRTSTNAME = "Please provide Your First Name.";
	final String ERROR_NO_STUDENT_SURNAME = "Please provide Your SurName.";
	final String ERROR_NO_STUDENT_LASTNAME = "Please provide Your Last Name.";
	final String ERROR_NO_STUDENT_EMAIL = "Please provide Your email address.";
	final String ERROR_INVALID_EMAIL = "Email address Invalid.";
	final String ERROR_NO_PHONE = "Please provide Your Phone Number.";
	final String ERROR_NO_GURDIAN_CONTACT = "Please provide Guardian Phone Number.";
	final String ERROR_NO_DOB = "Please provide Your Year of Birth.";
	final String ERROR_INVALID_DOB = "Please provide A Valid Year of Birth.";
	final String ERROR_NO_GENDER_SELECTED = "Please Select Your Gender.";
	final String ERROR_NO_STUDENT_PROGRAM = "Please Provide Your Program/Major.";
	
	final String ERROR_NO_STUDENT_ACADEMIC_YEAR = "Please Provide Your Academic Year.";
	final String ERROR_NO_STUDENT_YEAR_OF_STUDY = "Please Provide Your Year of Study.";
	final String ERROR_NO_STUDENT_HOME_TOWN = "Please Provide Your Home Town.";
	final String ERROR_NO_STUDENT_COUNTY = "Please Provide Your County.";
	
	
	
	final String ERROR_DECLARATION_NOTCHECKED = "Please Accept the Declaration.";
	
	final String STUDENT_ADD_SUCCESS = "Your Information Was Submited Successfully.";
	

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
      
	   String AdmNo = StringUtils.trimToEmpty(request.getParameter("AdmNo"));
	   String FirstName = StringUtils.trimToEmpty(request.getParameter("FirstName"));
	   String SurName = StringUtils.trimToEmpty(request.getParameter("SurName"));
	   String LastName = StringUtils.trimToEmpty(request.getParameter("LastName"));
	   String Email = StringUtils.trimToEmpty(request.getParameter("Email"));
	   String Phone = StringUtils.trimToEmpty(request.getParameter("Phone"));
	   String GuardianContact = StringUtils.trimToEmpty(request.getParameter("GuardianContact"));
	   String DOB = StringUtils.trimToEmpty(request.getParameter("DOB"));
	   String Gender = StringUtils.trimToEmpty(request.getParameter("studentgender"));
	   String Program = StringUtils.trimToEmpty(request.getParameter("Program"));
	   String AcademicYear = StringUtils.trimToEmpty(request.getParameter("AcademicYear"));
	   String YearOfStudy = StringUtils.trimToEmpty(request.getParameter("YearOfStudy"));
	   String HomeTown = StringUtils.trimToEmpty(request.getParameter("HomeTown"));
	   String County = StringUtils.trimToEmpty(request.getParameter("County"));
	   
	   
	  
	   String Christian = StringUtils.trimToEmpty(request.getParameter("Christian"));
	   String Duration = StringUtils.trimToEmpty(request.getParameter("Duration"));
	   String Ministry = StringUtils.trimToEmpty(request.getParameter("Ministry"));
	   String MinistryName = StringUtils.trimToEmpty(request.getParameter("MinistryName"));
	   String DesiredMinistry = StringUtils.trimToEmpty(request.getParameter("DesiredMinistry"));
	   String Vision = StringUtils.trimToEmpty(request.getParameter("Vision"));
	   String Declaration = StringUtils.trimToEmpty(request.getParameter("Declaration"));
	   
	  // System.out.println(Gender);
	  /* System.out.println(YearOfStudy);
	   System.out.println(Duration);
	   System.out.println(MinistryName);*/
	   
		// This is used to store parameter names and values from the form.
	   	Map<String, String> paramHash = new HashMap<>();    	
	   	paramHash.put("AdmNo", AdmNo);
	   	paramHash.put("FirstName", FirstName);
	   	paramHash.put("SurName", SurName);
	   	paramHash.put("LastName", LastName);
		paramHash.put("Email", Email);
	   	paramHash.put("Phone", Phone);
	   	paramHash.put("GuardianContact", GuardianContact);
	   	paramHash.put("DOB", DOB);
	    paramHash.put("Gender", Gender);
	   	paramHash.put("Program", Program);
	   	paramHash.put("AcademicYear", AcademicYear);
	   	paramHash.put("YearOfStudy", YearOfStudy);
		paramHash.put("HomeTown", HomeTown);
	   	paramHash.put("County", County);
	   	
	   //	paramHash.put("Christian", Christian);
	   	paramHash.put("Duration", Duration);
	   //	paramHash.put("Ministry", Ministry);
	   	paramHash.put("MinistryName", MinistryName);
	   	paramHash.put("DesiredMinistry", DesiredMinistry);
		paramHash.put("Vision", Vision);
	  
	    if(StringUtils.isBlank(AdmNo)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_ADMNO); 
 
	   }else if(studentDAO.getStudent(AdmNo) !=null){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_ADMNO_EXIST); 
    	
	   }else if(StringUtils.isBlank(FirstName)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_STUDENT_FIRTSTNAME); 
    	 
	   }else if(StringUtils.isBlank(SurName)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_STUDENT_SURNAME); 
    	  
	   }else if(StringUtils.isBlank(LastName)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_STUDENT_LASTNAME); 
    	  
	   }else if(StringUtils.isBlank(Email)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_STUDENT_EMAIL); 
    	 
	   }else if(!emailValidator.isValid(Email)){		     
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_INVALID_EMAIL);  
		  	   
	   }else if(StringUtils.isBlank(Phone)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_PHONE); 
    	 
	   }else if(StringUtils.isBlank(GuardianContact)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_GURDIAN_CONTACT); 
    	  
	   }else if(StringUtils.isBlank(DOB)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_DOB); 
    	   
	   }else if(!ValidDob(DOB)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_INVALID_DOB); 
    	   
	   }else if(StringUtils.isBlank(Gender)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_GENDER_SELECTED); 
    	 
	   }else if(StringUtils.isBlank(Program)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_STUDENT_PROGRAM); 
    	 
	   }
	    
	   else if(StringUtils.isBlank(AcademicYear)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_STUDENT_ACADEMIC_YEAR); 
    	 
	   }else if(StringUtils.isBlank(YearOfStudy)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_STUDENT_YEAR_OF_STUDY); 
    	   
	   }else if(StringUtils.isBlank(HomeTown)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_STUDENT_HOME_TOWN); 
    	 
	   }else if(StringUtils.isBlank(County)){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_NO_STUDENT_COUNTY); 
    	  
	   }
	   else if(!StringUtils.equals(Declaration, StringUtils.trimToEmpty("on"))){
		   session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, ERROR_DECLARATION_NOTCHECKED); 
    	 
	   }else{
		   
		  session.setAttribute(SessionConstants.STUDENT_REGISTER_DETAILS, null);
		  Student s = new Student();
		  String  StudeUuid = s.getUuid();
		 
		  s.setUuid(StudeUuid);
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
		  studentDAO.putStudent(s);
		   
		  
		StudentOtherDetail d = new StudentOtherDetail();
		  String Uuid = d.getUuid();
		  d.setUuid(Uuid);
		  d.setStudentUuid(StudeUuid);
		  d.setChristian(Christian.toUpperCase());
		  d.setDuration(Duration.toUpperCase());
		  d.setMinistry(Ministry.toUpperCase());
		  d.setMinistryName(MinistryName.toUpperCase());
		  d.setDesiredMinistry(DesiredMinistry.toUpperCase());
		  d.setMinistryVision(Vision);
		  studentOtherDetailDAO.putDetail(d);
		  session.setAttribute(SessionConstants.STUDENT_ADD_SUCCESS, STUDENT_ADD_SUCCESS); 
		 
		   
		   
	   }
	   
	  
	   session.setAttribute(SessionConstants.STUDENT_REGISTER_DETAILS, paramHash);
	   response.sendRedirect("index.jsp");  
	  
	   
   }

   

private boolean ValidDob(String dOB) {
	boolean success = true;
	String regex ="\\d+";//     /^\d{4}$/
	//String regex ="/^\\d{4}$/"; //     /^\d{4}$/
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
