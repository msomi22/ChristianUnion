


<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Student"%>

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
  
 String admno = request.getParameter("admissNo");
  Student student;
 
  StudentDAO studentDAO = StudentDAO.getInstance();
  List<Student> studentList1 = new ArrayList(); 
  studentList1 = studentDAO.getStudentAdmNo(admno);


 
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
                    <tr class="tabledit">
                       <td width="10%"><%=count%></td>
                         <td class="center"><%=s.getAdmNo()%></td> 
                         <td class="center"><%=s.getFirstName()%></td>
                       <!--  <td class="center"><%//=s.getSurName()%></td> -->
                         <td class="center"><%=s.getLastName()%></td>  
                         <td class="center"><%=s.getMobile()%></td>  
                       <!--  <td class="center"><%//=s.getGuardianContact()%></td> -->
                         <td class="center"><%=age%></td>
                         <td class="center"><%=s.getGender()%></td>
                         <td class="center"><%=s.getProgram()%></td>  
                       <!--   <td class="center"><%//=s.getAcademicYear()%></td>     -->
                         <td class="center"><%=s.getYearOfStudy()%></td>
                         <td class="center"><%=s.getHomeTown()%></td>
                         <td class="center"><%=s.getCounty()%></td>  
                         <td class="center"><%=dateFormatter.format(s.getDateOfRegistration())%></td>  S
                                          
                    </tr>

                    <%       
                           count++;
                            } 
                    %>
               


       
          