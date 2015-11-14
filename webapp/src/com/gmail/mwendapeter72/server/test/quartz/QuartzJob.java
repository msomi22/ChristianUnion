/**
 * 
 */
package com.gmail.mwendapeter72.server.test.quartz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.bean.student.StudentStatus;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.persistence.student.StudentStatusDAO;

/**
 * @author peter
 *
 */
public class QuartzJob implements Job {
	
	private static  StudentDAO studentDAO;
	private static  StudentStatusDAO studentStatusDAO; 
	
	 List<Student> studentList = new ArrayList<>();
	 List<StudentStatus> studenstatustList = new ArrayList<>();
	
	HashMap<String,String> statusHash = new HashMap<String,String>(); 

	/**
	 * 
	 */
	public QuartzJob() {
		studentDAO = StudentDAO.getInstance();
		studentStatusDAO = StudentStatusDAO.getInstance();
	   
	}

	
	/**
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("*### MMUCU Quartz Running @TestBy-PeterMwenda###");
		 ChangeStatus();
    }

	private  void ChangeStatus() {
		 //System.out.println("Helloooooo!!!! MMUCU Quartz Running :::TestByPeterMwenda###");
		 //StudentStatus s = new StudentStatus();
		 StudentStatus sts = new StudentStatus();
		
		
		 studentList = studentDAO.getStudentList(); 		
		 studenstatustList = studentStatusDAO.getAllStudentStatus();
		
		if(studentList !=null && studenstatustList !=null){	
			//System.out.println("Lists Not Null");
		for(Student st : studentList){
		     Date regDate =	st.getDateOfRegistration();
		     String studentUuid = st.getUuid();
		     
			 SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy");
             Calendar now = Calendar.getInstance();   
             
             String current_year = dateFormatter.format(now.getTime());   
		     String regYear = dateFormatter.format(regDate.getTime()); 
		     
			 //System.out.println("Current Year ="+current_year);
			// System.out.println("Reg year ="+regYear);
			 
			 int crrnt_year = Integer.parseInt(current_year);
			 int reg_year = Integer.parseInt(regYear);
			 
			 int duration = crrnt_year - reg_year;
			// System.out.println("Duration ="+duration); 
			  
				 for(StudentStatus status : studenstatustList){
					 if(duration>=1 && StringUtils.equals(status.getStudentUuid(), studentUuid)){
						 String StatusUuid = "6C03705B-E05E-420B-B5B8-C7EE36643E60";
						 sts.setStudentStatusUuid(StatusUuid);
						 sts.setStudentUuid(studentUuid); 
						 studentStatusDAO.updateStudentStatus(sts);
				           }
				 }
			
			
			
		}
			
		} //end of if(studentList !=null){		
	
	}//end private void ChangeStatus() {
	
}
