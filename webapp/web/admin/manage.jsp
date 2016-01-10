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
<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Student"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.leader.Position"%>

<%@page import="com.gmail.mwendapeter72.server.session.admin.SessionConstants"%>


<%@page import="org.apache.commons.lang3.StringUtils"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>


<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page import="net.sf.ehcache.Cache" %>
<%@ page import="net.sf.ehcache.CacheManager" %>
<%@ page import="net.sf.ehcache.Element" %>

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
     response.setHeader("Refresh", SessionConstants.SESSION_TIMEOUT + "; url=../logout");

    


      
      //Stusent Cache Management
       CacheManager mgr = CacheManager.getInstance();
       Cache studentsCache = mgr.getCache(CacheVariables.CACHE_STUDENT_BY_UUID);
       HashMap<String, Student> studentHash = new HashMap<String, Student>();
       //Leaders Register Cache Management
       Cache leadersRegisterCache = mgr.getCache(CacheVariables.CACHE_LEADERS_REGISTER_BY_UUID);
       HashMap<String, LeadersRegister> leadersRegisterHash = new HashMap<String, LeadersRegister>();
       Cache positionCache = mgr.getCache(CacheVariables.CACHE_POSITION_BY_UUID);
       HashMap<String, Position> positionHash = new HashMap<String, Position>();


       LeadersRegisterDAO leadersRegisterDAO = LeadersRegisterDAO.getInstance();
       StudentDAO studentDAO = StudentDAO.getInstance();

       List<Student> studentList = new ArrayList<Student>();
       studentList = studentDAO.getStudentList();

       List keys;
       Element element;



       //get Student details from chase, put them in hashmap
      Student student;
      keys = studentsCache.getKeys();
      for (Object key : keys) {
            element = studentsCache.get(key);
           // student = (Student) element.getObjectValue();
            //studentHash.put(student.getUuid(),student);
      }
          //Leaders Register Management
          LeadersRegister leaderReg = new LeadersRegister();
          List<LeadersRegister> leadersRegisterList = new ArrayList<LeadersRegister>();
          keys = leadersRegisterCache.getKeys();
          for (Object key : keys) {
            element = leadersRegisterCache.get(key);
            leaderReg = (LeadersRegister) element.getObjectValue();
            leadersRegisterHash.put(leaderReg.getStudentUuid(),leaderReg);
            //leadersRegisterList.add(leaderReg); 
        }
       
         leadersRegisterList = leadersRegisterDAO.getLeadersList();


         for(Student students : studentList){
            studentHash.put(students.getUuid(),students);
           }

         Position position;
         List<Position> positionList = new ArrayList<Position>();
         keys = positionCache.getKeys();
          for (Object key : keys) {
            element = positionCache.get(key);
            position = (Position) element.getObjectValue();
            positionHash.put(position.getUuid(),position);
            positionList.add(position);
        } 

         SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
         final String STATUS_ACTIVE = "85C6F08E-902C-46C2-8746-8C50E7D11E2E";
         String statusuuid; 
%>   


          <jsp:include page="header.jsp" />

                         
                <div class="row-fluid sortable">    
                <div class="box span12">

                <div class="box-content">

                <%

               
                         HashMap<String, String> paramHash = (HashMap<String, String>) session.getAttribute(
                         SessionConstants.STUDENT_REGISTER_DETAILS);

                        if (paramHash == null) {
                             paramHash = new HashMap<String, String>();
                            }

                                String findError = "";
                                String findsuccess = "";
                                session = request.getSession(false);
                              findError = (String) session.getAttribute(SessionConstants.STUDENT_FIND_ERROR);
                              findsuccess = (String) session.getAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS); 

                                                    

                                if (StringUtils.isNotEmpty(findError)) {
                                    out.println("<p style='color:red;'>");                 
                                    out.println("Oh my God!: " + findError);
                                    out.println("</p>");                                 
                                    session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, null);
                                  } 
                                   else if (StringUtils.isNotEmpty(findsuccess)) {
                                    out.println("<p style='color:green;'>");                                 
                                    out.println("Sharom!: " + findsuccess);
                                    out.println("</p>");                                   
                                    session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, null);
                                  } 

                          String fullname =""; 
                          if(StringUtils.isEmpty(paramHash.get("fullname"))){
                           fullname = " ";
                          }else{
                           fullname = paramHash.get("fullname"); 
                         
                         }



             %>


               <div class="content_title"> 
                <h3>MMUCU Leaders Registration  </h3>
                
             </div>
               
               <form  class="form-horizontal"   action="../findLeader" method="POST" >
                <fieldset>

                    <div class="control-group">
                        <label class="control-label" for="name">Admission Number:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="AdmNo" 
                            value=""  >
                        </div>
                    </div> <!--end of form find-->
                 
                    <!--submit form -->  
                    <div class="form-actions">
                        <button type="submit" name="Find" value="Find"   class="btn btn-primary">Find</button> 
                    </div>

                    </fieldset>
                    </form>

                   <!--Assign the role to the student --> 
                   <form  class="form-horizontal"   action="../registerLeader" method="POST" >
                    <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="name">Full Name:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="fullname" 
                            value="<%=fullname%>" readonly >
                        </div>
                    </div> 



                       <div class="control-group" id="dividm">
                        <label class="control-label" for="name">Category:</label>
                        <div class="controls">
                            <select name="Category" id="" >
                                <option value="">Select One</option>
                                <%  
                                    int count = 1;
                                    if (positionList != null) {
                                        for (Position pos : positionList) {
                                %>

                                <option value="<%=pos.getPositionName()%>"  ><%=pos.getPositionName()%></option>
                                <%
                                            count++;
                                        }
                                    }
                                %>
                            </select>                           
                          
                        </div>
                    </div> 
                      
            <div class="form-actions">
            <input type="hidden" name="StudentUuid" value="<%=StringUtils.trimToEmpty(paramHash.get("StudentUuid"))%>">
            
                        <button type="submit" name="Register" value="Register"   class="btn btn-primary">Register</button> 
                    </div>

                    </fieldset>
                    </form> <!--end of form assign-->


        








              



            <div class="content_title"> 
                <h3>Below are the Registered Leaders </h3>
                
             </div>
              <table class="table table-striped table-bordered bootstrap-datatable datatable">
              <thead>
                    <tr>
                        <th>*</th>
                        <th>Admission Number</th>
                        <th>Full Name</th>
                        <th>Year Of Study</th>
                        <th>Position</th>  
                        <th>In Date</th>   
                        <th>Action</th>                                  
                       
                    </tr>
               </thead>   
               <tbody class='tablebody'>                    
                         <tr class="tabledit">    
                          <% 
                          int leadercount = 1;
                          if(leadersRegisterList !=null){
                         for(LeadersRegister leader : leadersRegisterList){
                            student =  studentHash.get(leader.getStudentUuid());
                             if(StringUtils.equals(leader.getStatusUuid(),STATUS_ACTIVE)){
                            if(student !=null){
                           %>
                         <td width="3%"><%=leadercount%> </td>
                         <td class="center"><%=student.getAdmNo()%></td>  
                         <td class="center"><%=student.getFirstName()+" "+student.getLastName()+" "+student.getSurName()%></td>  
                         <td class="center"><%=student.getYearOfStudy()%></td>                    
                         <td class="center"><%=leader.getCategory()%></td>
                         <td class="center"><%=dateFormatter.format(leader.getStartDate())%></td>

                         <td class="center">
                              <form name="terminateRole" method="post" action="../terminateRole">
                              <input type="hidden" name="StudentUuid" value="<%=leader.getStudentUuid()%>">
                              <input type="hidden" name="StatusUuid" value="<%=leader.getStatusUuid()%>">
                              <input class="btn btn-success" type="submit" name="Remove" id="submit" value="Remove" />
                              </form> 
                        </td>   
                                           
                       </tr>
                         <%
                               leadercount++;
                                 }
                               }
                              }
                             }
                           %>

            </tbody>
            </table>  


 
       
        </div>
    </div><!--/span-->

</div><!--/row-->







  <jsp:include page="footer.jsp" />

      



