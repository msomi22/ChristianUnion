/**
*LeadersReport.java
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
package com.gmail.mwendapeter72.server.servlet.reports;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister;
import com.gmail.mwendapeter72.server.cache.CacheVariables;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
/**
 * Generate Leaders report inform of PDF
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class LeadersReport extends HttpServlet{
	
	 public static final String RESOURCE = "/opt/Programs/img/tooplate_logo.png";
	 public static final String RESOURCE2 = "/opt/Programs/img/fastech.png";
	 final String PDF_TITLE = "Maasai Mara University Christian Union";
	 final String PDF_BOTTOM_TEXT = "Tel: +254 (0)721669959\n"
						            + "Web: http://www.njokitech.co.ke\n"
						            + "Email: njokibryant@gmail.com\n";
						          
	 
	 private final String STATUS_ACTIVE = "85C6F08E-902C-46C2-8746-8C50E7D11E2E";
	
	 private Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD);
	 private Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	// private Font normalText = new Font(Font.FontFamily.COURIER, 12);
	 
	 private Logger logger;
	 
	 private Cache studentsCache, leadersRegisterCache;
     HashMap<String, Student> studentHash = new HashMap<String, Student>();
     HashMap<String, LeadersRegister> leadersRegisterHash = new HashMap<String, LeadersRegister>();
   //Variables
     Student student;
    
	 
	  
	 private List<?> keys; 
	 private net.sf.ehcache.Element element;
	
	 String studentAdmno ="";
     String studentFullname ="";
     String studentYOS ="";
     String gender ="";
     String genderCategory ="";

    
	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       CacheManager mgr = CacheManager.getInstance();
       studentsCache = mgr.getCache(CacheVariables.CACHE_STUDENT_BY_UUID);
       leadersRegisterCache = mgr.getCache(CacheVariables.CACHE_LEADERS_REGISTER_BY_UUID);
       logger = Logger.getLogger(this.getClass());
      
   }
   
   
   
/**
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */
   
   
   
   
   
   
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	     
	       //HttpSession session = request.getSession(false);

	       response.setContentType("application/pdf");
	       response.setHeader("Content-Disposition", "inline; filename= \" mmuculeaders.pdf \" " );
	       
	     
	       
	        SimpleDateFormat formatter;
	        SimpleDateFormat formatter2;
	        String formattedDate;
	        String formattedYear;
	        Date date = new Date();
	        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
	       
	        
	      //get Student details from chase, put them in hashmap
	        keys = studentsCache.getKeys();
	        for (Object key : keys) {
	              element =  studentsCache.get(key);
	              student = (Student) ((net.sf.ehcache.Element) element).getObjectValue();
	              studentHash.put(student.getUuid(),student);
	        }
	        //Leaders Register Management
	        LeadersRegister leaderReg = new LeadersRegister();
	        List<LeadersRegister> leadersRegisterList = new ArrayList<LeadersRegister>();
	        keys = leadersRegisterCache.getKeys();
	        for (Object key : keys) {
	              element =  leadersRegisterCache.get(key);
	              leaderReg = (LeadersRegister) ((net.sf.ehcache.Element) element).getObjectValue();
	              leadersRegisterHash.put(leaderReg.getStudentUuid(),leaderReg);
	              leadersRegisterList.add(leaderReg); 
	          }
	       
	        
	         
	         OutputStream out=response.getOutputStream();
	         
	         try {
		           Document document = new Document(PageSize.A4, 36, 36, 54, 54); 
		           
		           FontSelector selector = new FontSelector();
		           Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
		           f1.setColor(BaseColor.BLUE);
		           Font f2 = FontFactory.getFont("MSung-Light","UniCNS-UCS2-H", BaseFont.NOT_EMBEDDED);
		           f2.setColor(BaseColor.RED);
		           selector.addFont(f1);
		           selector.addFont(f2);
		           
		           
		           /* Basic PDF Creation inside servlet */
		           PdfWriter.getInstance(document, out);
		           document.open();
		           document.setPageSize(PageSize.LETTER);
		           
		           Paragraph preface = new Paragraph();
		           // We add one empty line
		           addEmptyLine(preface, 1);
		           
		           // Lets write a big header
		           preface.add(new Paragraph(PDF_TITLE, bigFont));
		           addEmptyLine(preface, 1);
		           formatter = new SimpleDateFormat("dd, MMM yyyy HH:mm z");
		           formatter2 = new SimpleDateFormat("yyyy");
		           
		           formatter.setTimeZone(TimeZone.getTimeZone("GMT+3"));
		           formattedDate = formatter.format(date);
		           formattedYear = formatter2.format(date);
		           int formattedYearInt = Integer.parseInt(formattedYear); 
		           int nextYear = (int) Math.floor(formattedYearInt + 1);  
		           // Will create: Report generated by: _name, _date
		           preface.add(new Paragraph(formattedDate, smallBold));
		           
		           addEmptyLine(preface, 1);
		           preface.add(new Paragraph(PDF_BOTTOM_TEXT));
		           preface.setAlignment(Element.ALIGN_RIGHT);
		           
		           Image img = Image.getInstance(RESOURCE2);
		           document.add(img);
		           document.add(preface);
		           
		          
		          
		           Paragraph p2 = new Paragraph(selector.process("These are the Current Leaders for year "+formattedYear+"/"+nextYear+": \n"));
		           Paragraph p3 = new Paragraph(selector.process("Executive \n\n"));
		           Paragraph famHeader = new Paragraph(selector.process("Families \n"));
		           Paragraph famOverAll = new Paragraph(selector.process("Overall Dad/Mum \n"));
		           Paragraph famdadmum = new Paragraph(selector.process("Dad/Mum \n"));
		           Paragraph ministries = new Paragraph(selector.process("Ministries \n"));
		           Paragraph p4 = new Paragraph(selector.process("_________________________________________________________________________________________"));
		           document.add(p2);
		           document.add(p3);
		           BaseColor baseColor=new BaseColor(202,225,255);
		           Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		           
		          //table here
		            PdfPCell CountHeader = new PdfPCell(new Paragraph("*",boldFont));
		            CountHeader.setBackgroundColor(baseColor);
		            CountHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
		            //CountHeader.setColspan(2); 
		            
		            
		            PdfPCell fullnameHeader = new PdfPCell(new Paragraph("Full Name",boldFont));
		            fullnameHeader.setBackgroundColor(baseColor);
		           
		            PdfPCell RoleHeader = new PdfPCell(new Paragraph("Position",boldFont));
		            RoleHeader.setBackgroundColor(baseColor);
		            RoleHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
		            
		            PdfPCell YearStudayHeader = new PdfPCell(new Paragraph("Year",boldFont));
		            YearStudayHeader.setBackgroundColor(baseColor);
		            YearStudayHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
		            
		            PdfPCell DateInHeader = new PdfPCell(new Paragraph("Date In",boldFont));
		            DateInHeader.setBackgroundColor(baseColor);
		            DateInHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
		            
		            PdfPTable ExecTable = new PdfPTable(5); 
		            PdfPTable familyTable = new PdfPTable(5); 
		            PdfPTable famiyDMTable = new PdfPTable(5); 
		            PdfPTable ministryTable = new PdfPTable(5); 
		            //Rectangle rec = new Rectangle(523,770); 
		            ExecTable.setWidthPercentage(100); 
		            familyTable.setWidthPercentage(100); 
		            famiyDMTable.setWidthPercentage(100); 
		            ministryTable.setWidthPercentage(100); 
		            
		            ExecTable.setWidths(new int[]{10,80,70,15,35});   
		            familyTable.setWidths(new int[]{10,80,70,15,35});  
		            famiyDMTable.setWidths(new int[]{10,80,70,15,35});
		            ministryTable.setWidths(new int[]{10,80,70,15,35});
		          //  leadersTable.setLockedWidth(true); 
		            
		            ExecTable.setHorizontalAlignment(Element.ALIGN_LEFT);
		            familyTable.setHorizontalAlignment(Element.ALIGN_LEFT);
		            famiyDMTable.setHorizontalAlignment(Element.ALIGN_LEFT);
		            ministryTable.setHorizontalAlignment(Element.ALIGN_LEFT);
		            
		            ExecTable.addCell(CountHeader);
		            ExecTable.addCell(fullnameHeader);
		            ExecTable.addCell(RoleHeader);
		            ExecTable.addCell(YearStudayHeader);
		            ExecTable.addCell(DateInHeader);
		            
		            familyTable.addCell(CountHeader);
		            familyTable.addCell(fullnameHeader);
		            familyTable.addCell(RoleHeader);
		            familyTable.addCell(YearStudayHeader);
		            familyTable.addCell(DateInHeader);
		            
		            famiyDMTable.addCell(CountHeader);
		            famiyDMTable.addCell(fullnameHeader);
		            famiyDMTable.addCell(RoleHeader);
		            famiyDMTable.addCell(YearStudayHeader);
		            famiyDMTable.addCell(DateInHeader);
		            
		            ministryTable.addCell(CountHeader);
		            ministryTable.addCell(fullnameHeader);
		            ministryTable.addCell(RoleHeader);
		            ministryTable.addCell(YearStudayHeader);
		            ministryTable.addCell(DateInHeader);
		          
		            
		            //Executive
		            int execount = 1;
		            if(leadersRegisterList !=null){
                        for(LeadersRegister leader : leadersRegisterList){                          
                           student =  studentHash.get(leader.getStudentUuid());  
                           if(student !=null){
                              studentAdmno = student.getAdmNo();
                              studentFullname = student.getFirstName()+" "+student.getLastName()+" "+student.getSurName();
                              studentYOS = student.getYearOfStudy();
                             } 
                            
                            if(StringUtils.equals(leader.getStatusUuid(),STATUS_ACTIVE) &&
                            		StringUtils.equals(leader.getCategory(),"Executive")){                  
                        	ExecTable.addCell(" "+execount++); 
                        	ExecTable.addCell(studentFullname);
                        	ExecTable.addCell(leader.getPosition());  
                        	ExecTable.addCell(studentYOS);  
                        	ExecTable.addCell(dateFormatter.format(leader.getStartDate()));  
                        }
                      }
		            }      
		            
		            //Family overall Heads
                    int ofamcount = 1;  
                    
                    if(leadersRegisterList !=null){
                        for(LeadersRegister leader : leadersRegisterList){                          
                           student =  studentHash.get(leader.getStudentUuid());  
                           if(student !=null){
                              studentAdmno = student.getAdmNo();
                              studentFullname = student.getFirstName()+" "+student.getLastName()+" "+student.getSurName();
                              studentYOS = student.getYearOfStudy();
                              gender = student.getGender();
                             } 

                             if(StringUtils.equalsIgnoreCase(gender,"Male")){
                               genderCategory = "Dad";
                             }else{
                                genderCategory = "Mum";
                             }
                            
                            if(StringUtils.equals(leader.getStatusUuid(),STATUS_ACTIVE) && 
                               StringUtils.equalsIgnoreCase(leader.getCategory(),"Family") &&
                               StringUtils.equalsIgnoreCase(leader.getPosition(),"Overall")){
                            	familyTable.addCell(" "+ofamcount++); 
                            	familyTable.addCell(studentFullname);
                            	familyTable.addCell(leader.getPosition()+" "+genderCategory);  
                            	familyTable.addCell(studentYOS);  
                            	familyTable.addCell(dateFormatter.format(leader.getStartDate()));  
		                      }
                            }
                        }
                   
                    // Family Dad/Mum
                    
                    int famcount = 1;
                    if(leadersRegisterList !=null){
                        for(LeadersRegister leader : leadersRegisterList){                          
                           student =  studentHash.get(leader.getStudentUuid());  
                           if(student !=null){
                              studentAdmno = student.getAdmNo();
                              studentFullname = student.getFirstName()+" "+student.getLastName()+" "+student.getSurName();
                              studentYOS = student.getYearOfStudy();
                              gender = student.getGender();
                             } 

                              if(StringUtils.equalsIgnoreCase(gender,"Male")){
                               genderCategory = "Dad";
                             }else{
                                genderCategory = "Mum";
                             }
                            
                           if(StringUtils.equals(leader.getStatusUuid(),STATUS_ACTIVE) && 
                               StringUtils.equals(leader.getCategory(),"Family") &&
                               !StringUtils.equals(leader.getPosition(),"Overall")){
         
                    	  famiyDMTable.addCell(" "+famcount++); 
                    	  famiyDMTable.addCell(studentFullname);
                    	  famiyDMTable.addCell(leader.getPosition()+" "+genderCategory);  
                    	  famiyDMTable.addCell(studentYOS);  
                    	  famiyDMTable.addCell(dateFormatter.format(leader.getStartDate()));  
                        }
                     }
                    }    
                  
                    
                    //Ministries 
                    int mincount = 1;
                    if(leadersRegisterList !=null){
                        for(LeadersRegister leader : leadersRegisterList){                          
                           student =  studentHash.get(leader.getStudentUuid());  
                           if(student !=null){
                              studentAdmno = student.getAdmNo();
                              studentFullname = student.getFirstName()+" "+student.getLastName()+" "+student.getSurName();
                              studentYOS = student.getYearOfStudy();
                             } 
                            
                            if(StringUtils.equals(leader.getStatusUuid(),STATUS_ACTIVE) &&
                            		StringUtils.equals(leader.getCategory(),"Ministry")){                      
                        	ministryTable.addCell(" "+mincount++); 
                        	ministryTable.addCell(studentFullname);
                        	ministryTable.addCell(leader.getPosition()+" "+leader.getSubPosition());  
                        	ministryTable.addCell(studentYOS);  
                        	ministryTable.addCell(dateFormatter.format(leader.getStartDate()));  
                        }
                    }
                    
              } 
		            

		            document.add(ExecTable); 
		            document.add(famHeader);
		            document.add(famOverAll);
		            document.add(p4);
		            document.add(familyTable);
		            document.add(famdadmum);
		            document.add(p4);
		            document.add(famiyDMTable);
		            document.add(ministries);
		            document.add(p4);
		            document.add(ministryTable);
		         
			
					          
					           
					document.add(new Paragraph(selector.process("\n\n\nCollosians 3:4 \"When Christ, who is our life,"
					           		                     + " shall appear, then shall ye also appear with him in glory \" ")));
					         
					document.close();
		        
            
                    }
		            catch (DocumentException e){
		            	logger.error("DocumentException while writing into the document");
		                logger.error(ExceptionUtils.getStackTrace(e));
		           throw new IOException(e.getMessage());
		               }
		           finally {   
		    	   out.flush();
		           out.close();
		           }     
			
            } 


		private Paragraph addEmptyLine(Paragraph paragraph, int number) {
		    for (int i = 0; i < number; i++) {
		        paragraph.add(new Paragraph(" "));
		    }
		    return paragraph;
		    
		}
		/**
		 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
		 */
		@Override
		   protected void doGet(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
		      processRequest(request, response);
		   }
		/**
		 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
		 */
		@Override
		   protected void doPost(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
		       processRequest(request, response);
		   }
		
		/**
		 * @see javax.servlet.GenericServlet#getServletInfo()
		 */
		@Override
		   public String getServletInfo() {
		       return "This Servlet Generates PDF Using iText Library";
		   }
		
		private static final long serialVersionUID = -6189520081452984347L;
		  }
