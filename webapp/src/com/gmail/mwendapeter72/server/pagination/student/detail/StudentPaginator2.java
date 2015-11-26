/**
 * 
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.
*Contacts author the: +254718953974
*
**/
package com.gmail.mwendapeter72.server.pagination.student.detail;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;
import com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO;
import com.gmail.mwendapeter72.server.persistence.utils.StudentUtils2;





/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class StudentPaginator2 {
	
	public final int PAGESIZE = 15;
	private static StudentUtils2 studentUtils2;
	private static StudentOtherDetailDAO studentOtherDAO;
	private String AdmNo;
    
	/**
	 * @param SchoolAccountUuid 
	 * 
	 */
	public StudentPaginator2() {
		//account = new SchoolAccount();
		//account.setUuid(SchoolAccountUuid); 
		
	    studentUtils2 = StudentUtils2.getInstance();
	    studentOtherDAO = StudentOtherDetailDAO.getInstance();
		//this.SchoolAccountUuid = SchoolAccountUuid;
	}
	
	    /**
	     * @param databaseName
	     * @param Host
	     * @param databaseUsername
	     * @param databasePassword
	     * @param databasePort
	     */
	    public StudentPaginator2(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {

	        //initialize the DAOs
	    	studentUtils2 = new StudentUtils2(databaseName, Host, databaseUsername, databasePassword, databasePort);
	    	studentOtherDAO = new StudentOtherDetailDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	    }
	
	 /**
    *
    * @return the first page
    */
   public StudentPage2 getFirstPage() {
	   StudentPage2 page2 = new StudentPage2();
       List<StudentOtherDetail> stuList = studentOtherDAO.getAllDetailList(0, PAGESIZE);
       page2 = new StudentPage2(1, getTotalPage(), PAGESIZE, stuList);	    
       return page2;
   }

   
   /**
    * Provides the last page of the Incoming USSD session report
    *
    * @return	a Incoming USSD page
    */
   public StudentPage2 getLastPage() {
	   
	   StudentPage2 page2 = new StudentPage2();

       List<StudentOtherDetail> stuList = null;
       int  startIndex,sessionCount;
       int totalPage = getTotalPage();
       startIndex = (totalPage - 1) * PAGESIZE;
       sessionCount = studentUtils2.getIncomingCount(AdmNo);
       stuList = studentOtherDAO.getAllDetailList(startIndex, sessionCount); 
       page2 = new StudentPage2(totalPage, totalPage, PAGESIZE, stuList);
       return page2;
   }
   

   /**
    * Moves you forward to the page of the Incoming USSD session that comes
    * after the current page
    *
    * @param currentPage
    * @return	an Incoming USSD page
    */
   public StudentPage2 getNextPage(final StudentPage2 currentPage2) {
       int totalPage = getTotalPage();

       StudentPage2 page2 = new StudentPage2();
       List<StudentOtherDetail> smsList = studentOtherDAO.getAllDetailList(currentPage2.getPageNum() * PAGESIZE, 
       		((currentPage2.getPageNum() * PAGESIZE) + PAGESIZE));

       page2 = new StudentPage2(currentPage2.getPageNum() + 1, totalPage, PAGESIZE, smsList);

       return page2;
   }

   
   /**
    * Moves you backward to the page of the Incoming USSD session that comes
    * before the current page
    *
    * @param currentPage
    * @return	an Incoming USSD page
    */
   public StudentPage2 getPrevPage(final StudentPage2 currentPage2) {
       int totalPage = getTotalPage();

       StudentPage2 page2 = new StudentPage2();
       
       List<StudentOtherDetail> smsList = studentOtherDAO.getAllDetailList( (currentPage2.getPageNum() - 2) * PAGESIZE, 
       		((currentPage2.getPageNum() - 1) * PAGESIZE));

       page2 = new StudentPage2(currentPage2.getPageNum() - 1, totalPage, PAGESIZE, smsList);

       return page2;
   }
   

   /**
    * Calculates the total number of pages that would be printed for the SMS
    * that belong to the logged-in account
    *
    * @return	an integer
    */
  
		public int getTotalPage() {
	        int totalSize = 0;

	        //get the number of all sessions belonging to this email
	        totalSize = studentUtils2.getStudents(AdmNo);

	//TODO: divide by the page size and add one to take care of remainders and what else?
	        return ((totalSize - 1) / PAGESIZE) + 1;
	    }
	    
		
}
