/**
 * 
 */
package com.gmail.mwendapeter72.server.servlet.reports;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO;
import com.gmail.mwendapeter72.server.session.SessionConstants;
import com.itextpdf.text.BaseColor;
// Document Object
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
//For adding content into PDF document
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * @author peter
 *
 */
public class StudentReport extends HttpServlet{
	
	
	final String ERROR_NO_ADMNO = "Please provide Your Admission Number.";
	final String ERROR_ADMNO_NOT_EXIST = "Admission Number doesn't exist.";
	
	 /**
	 * 
	 */
	 private static final long serialVersionUID = -8894900425775729484L;
	 
	 private static StudentDAO studentDAO;
	 private static StudentOtherDetailDAO studentOtherDetailDAO;
	 StudentOtherDetail std;
	 String AdmNo;
	 
	 public static final String RESOURCE = "/opt/Programs/img/tooplate_logo.png";
	 final String PDF_TITLE = "Maasai Mara University Christian Union";
	 final String PDF_BOTTOM_TEXT = "Tel: +254 (0)xxxxxxxxxx\n"
						            + "Web: http://www.mmucu.com\n"
						            + "Email: mmucu@gmail.com\n"
						            + "CONFIDENTIAL, (c) Copyright M.M.U.C.U";
	 
	 private Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD);
	 private Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	 private Font normalText = new Font(Font.FontFamily.COURIER, 12);
	 
	 private Logger logger;
	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       studentDAO = StudentDAO.getInstance();
       studentOtherDetailDAO = StudentOtherDetailDAO.getInstance();
       logger = Logger.getLogger(this.getClass());
      
   }
   
   //invoked from doGet method to create PDF through servlet 
   
/**
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	     
	       HttpSession session = request.getSession(false);
	       response.setContentType("application/pdf");
	       
	       if(request.getParameter("AdmNo") !=null){
	 	   AdmNo = StringUtils.trimToEmpty(request.getParameter("AdmNo").toUpperCase());
	       }
	 	  response.setHeader("Content-Disposition", "inline; filename= \" "+AdmNo+".pdf \" " );
	 	 
	 	  
	 	  if(StringUtils.isBlank(AdmNo)){
	 		   response.sendRedirect("admin/home.jsp"); 
			   session.setAttribute(SessionConstants.STUDENT_REPORT_ERROR, ERROR_NO_ADMNO); 
	 
		   }else if(studentDAO.getStudent(AdmNo) ==null){
			   response.sendRedirect("admin/home.jsp"); 
			   session.setAttribute(SessionConstants.STUDENT_REPORT_ERROR, ERROR_ADMNO_NOT_EXIST); 
	    	
		   }else {
			   
			   
			    Student s = studentDAO.getStudent(AdmNo);
			    std = studentOtherDetailDAO.getDetail(s.getUuid());
		 	    SimpleDateFormat formatter;
		        String formattedDate;
		        Date date = new Date();
		 	  
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
	           formatter.setTimeZone(TimeZone.getTimeZone("GMT+3"));
	           formattedDate = formatter.format(date);
	           // Will create: Report generated by: _name, _date
	           preface.add(new Paragraph(formattedDate, smallBold));
	           
	           addEmptyLine(preface, 1);
	           preface.add(new Paragraph(PDF_BOTTOM_TEXT));
	           preface.setAlignment(Element.ALIGN_RIGHT);
	           
	           Image img = Image.getInstance(RESOURCE);
	           document.add(img);
	           document.add(preface);
	           
	          
	          
	           Paragraph p2 = new Paragraph(selector.process("\n\n Student Personal Information:"));
	           if(s !=null && std !=null){
	           Paragraph p3 = new Paragraph("Admission Number:	\t " + s.getAdmNo());
	           Paragraph p4 = new Paragraph("Name:	\t " + s.getFirstName()   + "	\t " + s.getLastName() +"	\t " +s.getSurName() );
	           Paragraph p5 = new Paragraph("Gender:	\t " + s.getGender());
	           Paragraph p6 = new Paragraph("Email Address:	\t " + s.getEmail());
	           Paragraph p7 = new Paragraph("Mobile Number:	\t " + s.getMobile());
	           Paragraph p8 = new Paragraph("Guardian Contact:	\t " + s.getGuardianContact());
	           Paragraph p9 = new Paragraph("County:	\t " + s.getCounty());
	           Paragraph p10 = new Paragraph("Home Town:	\t " + s.getHomeTown());
	           
	           Paragraph p11 = new Paragraph(selector.process("\n\n Student Education Information:"));
	           
	           Paragraph p12 = new Paragraph("Program/Major:	\t " + s.getProgram());
	           Paragraph p13 = new Paragraph("Year Of Study:	\t " + s.getYearOfStudy());
	           Paragraph p14  = new Paragraph("Academic Year:	\t " + s.getAcademicYear());
	           
	           Paragraph p15 = new Paragraph(selector.process("\n\n Student Other Information:"));
	         
	           Paragraph p16 = new Paragraph("Ministry(ies) :	\t "+std.getMinistryName());
	           
	           p2.setAlignment(Element.ALIGN_CENTER);
	           p3.setAlignment(Element.ALIGN_CENTER);
	           p4.setAlignment(Element.ALIGN_CENTER);
	           p5.setAlignment(Element.ALIGN_CENTER);
	           p6.setAlignment(Element.ALIGN_CENTER);
	           p7.setAlignment(Element.ALIGN_CENTER);
	           p8.setAlignment(Element.ALIGN_CENTER);
	           p9.setAlignment(Element.ALIGN_CENTER);
	           p10.setAlignment(Element.ALIGN_CENTER);
	           p11.setAlignment(Element.ALIGN_CENTER);
	           p12.setAlignment(Element.ALIGN_CENTER);
	           p13.setAlignment(Element.ALIGN_CENTER);
	           p14.setAlignment(Element.ALIGN_CENTER);
	           p15.setAlignment(Element.ALIGN_CENTER);
	           p16.setAlignment(Element.ALIGN_CENTER);
	           
	          
	           document.add(p2);
	           document.add(p3);
	           document.add(p4);
	           document.add(p5);
	           document.add(p6);
	           document.add(p7);
	           document.add(p8);
	           document.add(p9);
	           document.add(p10);
	           
	           document.add(p11);
	           document.add(p12);
	           document.add(p13);
	           document.add(p14);
	           document.add(p15);
	           document.add(p16);
	           

	         // document.add(addEmptyLine(new Paragraph("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj."), 1));
	           
	           document.add(new Paragraph(selector.process("\n\n\nCollosians 3:4 \"When Christ, who is our life,"
	           		                     + " shall appear, then shall ye also appear with him in glory \" ")));
	         
	           document.close();
	          
	            }
	       
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

}
