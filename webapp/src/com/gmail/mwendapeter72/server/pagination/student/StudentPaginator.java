/**
*StudentPaginator.java
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
package com.gmail.mwendapeter72.server.pagination.student;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.persistence.utils.StudentUtils;



/**
 * <p>
 * This Paginator is used to manage pagination so that we can control the number of students displayed per page
 * </p>
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class StudentPaginator {
	
	public final int PAGESIZE = 15;
	private static StudentUtils studentUtils;
	private static StudentDAO studentDAO;
	private String AdmNo;
   
	public StudentPaginator() {
	    studentUtils = StudentUtils.getInstance();
		studentDAO = StudentDAO.getInstance();
		
	}
	
	 /**
     * @param databaseName the  databaseName
     * @param Host the Host
     * @param databaseUsername the databaseUsername
     * @param databasePassword the databasePassword 
     * @param databasePort the database Port
     */
	    public StudentPaginator(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {

	        //initialize the DAOs
	    	studentUtils = new StudentUtils(databaseName, Host, databaseUsername, databasePassword, databasePort);
	    	studentDAO = new StudentDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	    }
	
	 /**
    *
    * @return the first page
    */
   public StudentPage getFirstPage() {
	   StudentPage page = new StudentPage();
       List<Student> stuList = studentDAO.getStudentList(0, PAGESIZE);
       page = new StudentPage(1, getTotalPage(), PAGESIZE, stuList);	    
       return page;
   }

   
   /**
    * Provides the last page of the Incoming USSD session report
    *
    * @return	a Incoming USSD page
    */
   public StudentPage getLastPage() {
	   
	   StudentPage page = new StudentPage();

       List<Student> stuList = null;
       int  startIndex,sessionCount;
       int totalPage = getTotalPage();
       startIndex = (totalPage - 1) * PAGESIZE;
       sessionCount = studentUtils.getIncomingCount(AdmNo);
       stuList = studentDAO.getStudentList(startIndex, sessionCount); 
       page = new StudentPage(totalPage, totalPage, PAGESIZE, stuList);
       return page;
   }
   

   /**
    * Moves you forward to the page of the Incoming USSD session that comes
    * after the current page
    *
    * @param currentPage the currentPage
    * @return an Incoming USSD page
    */
   public StudentPage getNextPage(final StudentPage currentPage) {
       int totalPage = getTotalPage();
       StudentPage page = new StudentPage();
       List<Student> smsList = studentDAO.getStudentList(currentPage.getPageNum() * PAGESIZE, 
       		((currentPage.getPageNum() * PAGESIZE) + PAGESIZE));

       page = new StudentPage(currentPage.getPageNum() + 1, totalPage, PAGESIZE, smsList);

       return page;
   }

   
   /**
    * Moves you backward to the page of the Incoming USSD session that comes
    * before the current page
    *
    * @param currentPage the currentPage
    * @return	an Incoming USSD page
    */
   public StudentPage getPrevPage(final StudentPage currentPage) {
       int totalPage = getTotalPage();

       StudentPage page = new StudentPage();
       
       List<Student> smsList = studentDAO.getStudentList( (currentPage.getPageNum() - 2) * PAGESIZE, 
       		((currentPage.getPageNum() - 1) * PAGESIZE));

       page = new StudentPage(currentPage.getPageNum() - 1, totalPage, PAGESIZE, smsList);

       return page;
   }
   

   /**
    * Calculates the total number of pages that would be printed for the SMS
    * that belong to the logged-in account
    *
    * @return	an integer
    */
  
		public int getTotalPage() {
	        int totalSize = 0;

	        totalSize = studentUtils.getStudents(AdmNo);
	        return ((totalSize - 1) / PAGESIZE) + 1;
	    }
	    
		
}
