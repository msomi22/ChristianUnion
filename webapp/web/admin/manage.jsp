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
         @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 */
%>

<%@page import="com.gmail.mwendapeter72.server.cache.CacheVariables"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.StudentPosition"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentPositionDAO"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StatusDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Status"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Student"%>

<%@page import="com.gmail.mwendapeter72.server.session.admin.SessionConstants"%>
<%@page import="com.gmail.mwendapeter72.server.session.SessionStatistics"%>

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
if (session == null) {
        response.sendRedirect("index.jsp");
    }

    String username = (String) session.getAttribute(SessionConstants.ADMIN_SESSION_KEY);
    if (StringUtils.isEmpty(username)) {
        response.sendRedirect("index.jsp");
    }

     session.setMaxInactiveInterval(SessionConstants.SESSION_TIMEOUT);
     response.setHeader("Refresh", SessionConstants.SESSION_TIMEOUT + "; url=/ChristianUnion/admin");
     StudentPositionDAO studentPositionDAO = StudentPositionDAO.getInstance();
     List <StudentPosition> studentPositionList = new ArrayList<StudentPosition>();
     studentPositionList = studentPositionDAO.getAllPositions(0,15);
     HashMap<String, String> statusHash = new HashMap<String, String>();
     HashMap<String, String> studentHash = new HashMap<String, String>();
     
      StatusDAO statusDAO = StatusDAO.getInstance();
      List<Status> statustList = new ArrayList(); 
      statustList = statusDAO.getAllStatus();

       for(Status stat : statustList){
           statusHash.put(stat.getUuid(), stat.getStatus());
       }
      
      StudentDAO studentDAO = StudentDAO.getInstance();
      List<Student> studentList = new ArrayList(); 
      studentList = studentDAO.getStudentList();
     
      for(Student s : studentList){
           studentHash.put(s.getUuid(), s.getAdmNo());
       }


       int ussdCount = 1;
    

        //date format
      SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
      SimpleDateFormat timezoneFormatter = new SimpleDateFormat("z");

%>





<style type="text/css">
   input{
    height: 26px !important;
   }
   
 </style>

<div id="tooplate_wrapper">

  <jsp:include page="header.jsp" />
    
  <div id="container" class="clear"> 
   <div id="tooplate_main_top"></div>        
            <div id="tooplate_main" >
                 

 <div class="box-content">


            <div id="tooplate_middle">     
         <div id="middle_left">
            <p>MMU CU Student Basic Details</p>
          </div>
                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                <thead>
                    <tr>
                        <th>*</th>
                        <th>Admission Number</th>
                        <th>Position</th>                
                        <th>Status</th>
                        <th>StartDate</th>
                        <th>EndDate</th>
                        <th>Terminate</th>
                    </tr>
                </thead>   
                <tbody class='tablebody'>                    
                      <tr class="tabledit"> 
                      <%
                       for(StudentPosition sp : studentPositionList){
                      %>
                         <td width="3%"><%=ussdCount%> </td>
                         <td class="center"><%=studentHash.get(sp.getStudentUuid())%></td>                    
                         <td class="center"><%=sp.getPosition()%></td>
                         <td class="center"><%=statusHash.get(sp.getStatusUuid())%></td>
                         <td class="center"><%=sp.getStartDate()%></td>  
                         <td class="center"><%=sp.getEndDate()%></td>  
                        
                        <td class="center">
                                <form name="terminateRole" method="post" action="../terminateRole">
                                <input type="hidden" name="AdmNo" value="">
                                <input class="btn btn-success" type="submit" name="TerminateRole" id="submit" value="Terminate" />
                                </form> 
                       </td>   

                       </tr>
                    <%
                           ussdCount++;
                           
                        }
                    %>

                </tbody>
                </table>  
              
                </div> 


 </div>




          </div>


                 <br> <br> <br> <br> <br> <br>
                 
                 
   <div id="tooplate_main_top"></div>        
    <div id="tooplate_main">
        </div>

    
        
        <div class="cleaner"></div>
    </div> 
  <jsp:include page="footer.jsp" />

        
</div> <!-- end of wrapper -->



