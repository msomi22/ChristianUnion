/**
*QuartzJob.java
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
package com.gmail.mwendapeter72.server.test.quartz;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.cache.CacheVariables;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


/**
 * quartz that auto deactivate a student after a year
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class QuartzJob implements Job {
	
	private static  StudentDAO studentDAO;
	private CacheManager cacheManager;
	private Cache studentsCache;
    private List keys;
	private net.sf.ehcache.Element element;
	Student student;
	 List<Student> studentList = new ArrayList<>();
	
	 HashMap<String,String> statusHash = new HashMap<String,String>(); 
	
	 Long hoursDifference;
	 Long minutesDifference;
	 Long secondsDifference;
	 Long timeDifference;
	 final int HOURS_IN_A__YEAR = 24*365; 

	/**
	 * 
	 */
	public QuartzJob() {
		super();
		 studentDAO = StudentDAO.getInstance();
		 cacheManager = CacheManager.getInstance();
	     studentsCache = cacheManager.getCache(CacheVariables.CACHE_STUDENT_BY_UUID);
	   
	}

	
	/**
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		 ChangeStatus();
		
    }

	private  void ChangeStatus() {
		
		        keys = studentsCache.getKeys();
		        for (Object key : keys) {
		              element =  studentsCache.get(key);
		              student = (Student) ((net.sf.ehcache.Element) element).getObjectValue();
		              studentList.add(student);
		        }
		 
		       	
		if(studentList !=null){	
		for(Student student : studentList){
		     Date activationDate =	student.getActivationDate();
			 Date currentDate = new Date();		 
			
				 timeDifference =  currentDate.getTime() - activationDate.getTime();
				 secondsDifference =  Math.abs(timeDifference / 1000 % 60);
				 minutesDifference =  Math.abs(timeDifference / (60*1000) % 60);
				 hoursDifference = timeDifference / (60*60*1000);
				
					 if(hoursDifference/24 > HOURS_IN_A__YEAR/24){
						 final String STATUS_INACTIVE_UUID = "6C03705B-E05E-420B-B5B8-C7EE36643E60";
						 Student student2 = new Student();
						 student2.setUuid(student.getUuid()); 
						 student2.setStatusUuid(STATUS_INACTIVE_UUID);
						 studentDAO.deActivateStudent(student2); 
						 updateAccountCache(student2);
				           }
				 		
		            }
			
		    } 
	    }


	private void updateAccountCache(Student student2) {
		 cacheManager.getCache(CacheVariables.CACHE_EXECUTIVE_HEAD_BY_UUID).put(new Element(student2.getUuid(), student2));
		
	} 
	
}
