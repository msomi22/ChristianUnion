/**
 * 
 */
package com.gmail.mwendapeter72.server.servlet.reports;

import java.io.*;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.itextpdf.text.BaseColor;
// Document Object
import com.itextpdf.text.Document;
//For adding content into PDF document
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
/**
 * @author peter
 *
 */
public class StudentReport extends HttpServlet{
	
	 /**
	 * 
	 */
	 private static final long serialVersionUID = -8894900425775729484L;
	 private static StudentDAO studentDAO;
	

	/**
    *
    * @param config
    * @throws ServletException
    */
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       studentDAO = StudentDAO.getInstance();
      
      
   }
   
   //invoked from doGet method to create PDF through servlet 
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	   HttpSession session = request.getSession(false);
	   if (session != null) {
	         session.invalidate();  
	     }
	     session = request.getSession(true);
	 	   
	 	   String AdmNo = StringUtils.trimToEmpty(request.getParameter("AdmNo").toUpperCase());
	 	   Student s = studentDAO.getStudent(AdmNo);
		  // String studentUuid = s.getUuid();
		  
	 	   
       //Set content type to application / pdf
       //browser will open the document only if this is set
       //response.setContentType("application/pdf");
       //Get the output stream for writing PDF object        
       OutputStream out=response.getOutputStream();
       try {
           Document document = new Document();
           //SimpleDateFormat dateFormatter = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
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
           
           File logo = new File("/opt/Programs/img/tooplate_logo.png");
           if(! logo.exists()){
        	  System.out.println("file"+logo.getName()+ " Not found"); 
           }else{
        	   System.out.println("file"+logo.getName()+ " found"); 
        	   
           }
            //Image img = Image.getInstance(ClassLoader.getSystemResource("/opt/Programs/img/tooplate_logo.png"));
           // img.setAbsolutePosition(450f, 10f); 
           
           
           
           document.add(new Paragraph(selector.process("Maasai Mara University Christain Union(MMUCU)  \n")));
           
           document.add(new Paragraph(selector.process("Student Personal Information:")));
           document.add(new Paragraph("Admission Number: \t " + s.getAdmNo()));
           document.add(new Paragraph("Name: \t " + s.getFirstName()   + " \t " + s.getLastName() +"  \t " +s.getSurName() ));
           document.add(new Paragraph("Gender:    \t " + s.getGender()));
           document.add(new Paragraph("Email Address:    \t " + s.getEmail()));
           document.add(new Paragraph("Mobile Number:    \t " + s.getMobile()));
           document.add(new Paragraph("Gurdian Contact:  \t " + s.getGuardianContact()));
           document.add(new Paragraph("County:  \t " + s.getCounty()));
           document.add(new Paragraph("Home Town:  \t " + s.getHomeTown()));
           
           document.add(new Paragraph(selector.process("Student Education Information:")));
           document.add(new Paragraph("Program/Major:    \t " + s.getProgram()));
           document.add(new Paragraph("Year Of Study:    \t " + s.getYearOfStudy()));
           document.add(new Paragraph("Academic Year:    \t " + s.getAcademicYear()));
           
           
           document.add(new Paragraph(selector.process("\n\n\nCollosians 3:4 \"When Christ, who is our life,"
           		                     + " shall appear, then shall ye also appear with him in glory \" ")));
         
           document.add(new Paragraph("Printed on:  \t\t\t\t\t\t\t\t\t\t"+new Date()));
           //.add(img); 
           response.setContentType("application/pdf");
           response.setHeader("Content-Disposition", "attachment; filename=\""+s.getAdmNo()+".pdf\"" );
          
           document.close();
       }
               catch (DocumentException exc){
               throw new IOException(exc.getMessage());
               }
       finally {            
           out.close();
       }
   }
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       processRequest(request, response);
   }
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       processRequest(request, response);
   }

   @Override
   public String getServletInfo() {
       return "This Servlet Generates PDF Using iText Library";
   }

}
