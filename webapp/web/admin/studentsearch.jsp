<%
/**
Maasai Mara University Christian Union Online Management System.
Copyright 2015 Fastech Solutions Ltd
Licensed under the Open Software License, Version 3.0 
The codes herein AND/OR this file CAN BE copied without the author's approval for learning purposes or for use in one's own project
if need be, feel free to contact the author
Contacts, Mobile: +254718953974
         email: mwendapeter72@gmail.com
         email: petermwenda83@yahoo.com 
         @author <a href="mailto:migwindungu@gmail.com">Migwi Ndung'u</a>
 */
%>


<%@page import="com.gmail.mwendapeter72.server.persistence.student.StatusDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Status"%>
<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Student"%>
<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail"%>
<%@page import="com.gmail.mwendapeter72.server.session.SessionConstants"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.net.URLEncoder"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


 <%
    
    HashMap<String, String> statusHash = new HashMap<String, String>();


   String admno = request.getParameter("admissNo");
   Student student;
   Status sstatus;
 //out.println(admno);
  StudentDAO studentDAO = StudentDAO.getInstance();
  List<Student> studentList1 = new ArrayList(); 
  studentList1 = studentDAO.getStudentAdmNo(admno);


   StatusDAO statusDAO = StatusDAO.getInstance();
   List<Status> statustList = new ArrayList(); 
   statustList = statusDAO.getAllStatus();

       for(Status stat : statustList){
           statusHash.put(stat.getUuid(), stat.getStatus());
       }
 
   //date format
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
    SimpleDateFormat timezoneFormatter = new SimpleDateFormat("z");




       
%>       
                    <%  
                    int count =1;                                                        
                      SimpleDateFormat dateFormatter2 = new SimpleDateFormat("yyyy");
                      Calendar now = Calendar.getInstance();   
                      String nowdate = dateFormatter2.format(now.getTime());                                                    
                   
                       for (Student s : studentList1) {

                         String dob = s.getDOB();
        
                         int y = Integer.parseInt(dob);
                         int a = Integer.parseInt(nowdate);

                         int age = a-y;
                      
                    %>

                    <tr class="tabledit" >
                        <td width="3%"><%=count%></td>
                         <td class="center" ><a class="Zlink" href="#" data-toggle="modal" data-target="#groupcheck" value='<%=s.getAdmNo()%>' name='<%=s.getUuid()%>' onclick="TableGet(this)"><%=s.getAdmNo()%></a> </td>
                         <td class="center"><%=s.getFirstName()%></td>
                         <td class="center"><%=s.getLastName()%></td>  
                         <td class="center"><%=age%></td>
                         <td class="center"><%=s.getGender()%></td>
                         <td class="center" width="5%"><%=s.getYearOfStudy()%></td>
                        <!-- <td class="center"><%=s.getHomeTown()%></td> -->
                         <td class="center"><%=s.getCounty()%></td>  
                         <td class="center"><%=statusHash.get(s.getStatusUuid())%></td>  
                         <td class="center"><%=dateFormatter.format(s.getActivationDate())%></td>  

                         <td class="center">
                            <form name="edit" method="post" action="editstudent.jsp"> 
                                <input type="hidden" name="admno" value="<%=s.getAdmNo()%>">
                                 <input type="hidden" name="firstname" value="<%=s.getFirstName()%>">
                                <input type="hidden" name="surname" value="<%=s.getSurName()%>">
                                <input type="hidden" name="lastname" value="<%=s.getLastName()%>">
                                <input type="hidden" name="email" value="<%=s.getEmail()%>">
                                <input type="hidden" name="mobile" value="<%=s.getMobile()%>">
                                <input type="hidden" name="guardiancontact" value="<%=s.getGuardianContact()%>">
                                <input type="hidden" name="dob" value="<%=s.getDOB()%>">
                                <input type="hidden" name="gender" value="<%=s.getGender()%>">
                                <input type="hidden" name="program" value="<%=s.getProgram()%>">
                                <input type="hidden" name="academicyear" value="<%=s.getAcademicYear()%>">
                                <input type="hidden" name="yearofstudy" value="<%=s.getYearOfStudy()%>">
                                <input type="hidden" name="hometown" value="<%=s.getHomeTown()%>">
                                <input type="hidden" name="county" value="<%=s.getCounty()%>">
                                <input type="hidden" name="uuid" value="<%=s.getUuid()%>">

                                <%
                                  
                     StudentOtherDetailDAO studentDetailsDAO = StudentOtherDetailDAO.getInstance();
                     StudentOtherDetail ss;
                     ss = studentDetailsDAO.getDetail(s.getUuid());   
                                %>

                                <input type="hidden" name="ischristian" value="<%=ss.getChristian()%>">
                                <input type="hidden" name="duration" value="<%=ss.getDuration()%>">
                                <input type="hidden" name="hasministry" value="<%=ss.getMinistry()%>">
                                <input type="hidden" name="ministryname" value="<%=ss.getMinistryName()%>">
                                <input type="hidden" name="desiredministry" value="<%=ss.getDesiredMinistry()%>">
                                <input type="hidden" name="vision" value="<%=ss.getMinistryVision()%>">
                                <input class="btn btn-success" type="submit" name="edit" id="submit" value="Edit" /> 
                                </form> 
                                </td> 

                                <td class="center">
                                <form name="print" method="post" action="../studentReport">
                                <input type="hidden" name="AdmNo" value="<%=s.getAdmNo()%>">
                                <input class="btn btn-success" type="submit" name="printstudent" id="submit" value="PDF" />
                                </form>                       
                                </td>  



                    </tr>

                    <%       
                           count++;
                            } 
                    %>
               


       
          