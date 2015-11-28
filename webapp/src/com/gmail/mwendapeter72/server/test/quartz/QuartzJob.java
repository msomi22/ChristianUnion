/**
 * 
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.
*Contacts author the: +254718953974
*
**/
package com.gmail.mwendapeter72.server.test.quartz;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;


/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class QuartzJob implements Job {
	
	private static  StudentDAO studentDAO;
	
	 List<Student> studentList = new ArrayList<>();
	
	 HashMap<String,String> statusHash = new HashMap<String,String>(); 
	
	 Long diffhours;
	 Long diffmin;
	 Long diffsec;
	 final int HOURS_IN_A__YEAR = 24*365; 

	/**
	 * 
	 */
	public QuartzJob() {
		studentDAO = StudentDAO.getInstance();
	   
	}

	
	/**
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		 ChangeStatus();
    }

	private  void ChangeStatus() {
		 studentList = studentDAO.getStudentList(); 		
		if(studentList !=null){	
		for(Student st : studentList){
		     Date regDate =	st.getActivationDate();
			 Date nows = new Date();		 
			
				 Long diff =  nows.getTime() - regDate.getTime();
				 diffsec =  Math.abs(diff / 1000 % 60);
				 diffmin =  Math.abs(diff / (60*1000) % 60);
				 diffhours = diff / (60*60*1000);
				
					 if(diffhours/24 > HOURS_IN_A__YEAR/24){
						 final String STATUS_INACTIVE_UUID = "6C03705B-E05E-420B-B5B8-C7EE36643E60";
						 Student s = new Student();
						 s.setUuid(st.getUuid()); 
						 s.setStatusUuid(STATUS_INACTIVE_UUID);
						 studentDAO.deActivateStudent(s); 
				           }
				 
			
			
		}
			
		} 
	
	}
	
}
