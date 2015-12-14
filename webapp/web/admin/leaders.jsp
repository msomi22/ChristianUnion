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


<%@page import="com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Student"%>

<%@page import="com.gmail.mwendapeter72.server.session.admin.SessionConstants"%>
<%@page import="com.gmail.mwendapeter72.server.cache.CacheVariables"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page import="net.sf.ehcache.Cache" %>
<%@ page import="net.sf.ehcache.CacheManager" %>
<%@ page import="net.sf.ehcache.Element" %>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@page import="java.text.SimpleDateFormat"%>

<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
  // for session management.    
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
       
      //Variables
      Student student;
      List keys;
      Element element;

      
       //get Student details from chase, put them in hashmap
        keys = studentsCache.getKeys();
        for (Object key : keys) {
              element = studentsCache.get(key);
              student = (Student) element.getObjectValue();
              studentHash.put(student.getUuid(),student);
        }

      //Leaders Register Management
         LeadersRegister leaderReg = new LeadersRegister(); 
      List<LeadersRegister> leadersRegisterList = new ArrayList<LeadersRegister>();
      keys = leadersRegisterCache.getKeys();
      for (Object key : keys) {
            element = leadersRegisterCache.get(key);
            leaderReg = (LeadersRegister) element.getObjectValue();
            leadersRegisterHash.put(leaderReg.getStudentUuid(),leaderReg);
            leadersRegisterList.add(leaderReg); 
        }

       
         SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
        // Basic Variables
        
         final String STATUS_ACTIVE = "85C6F08E-902C-46C2-8746-8C50E7D11E2E";
         String studentAdmno ="";
         String studentFullname ="";
         String studentYOS ="";
         String gender ="";
         String genderCategory ="";

       
%>



           <jsp:include page="header.jsp" />
  
                    
           
       <div class="row-fluid sortable">    
       <div class="box span12">
        <div class="box-content">

                                       <%

               
                                String findError = "";
                                String findsuccess = "";
                                session = request.getSession(false);
                                     findError = (String) session.getAttribute(SessionConstants.STUDENT_FIND_ERROR);
                                     findsuccess = (String) session.getAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS); 

                                                    

                                if (StringUtils.isNotEmpty(findError)) {
                                    out.println("<p style='color:red;'>");                 
                                    out.println("error: " + findError);
                                    out.println("</p>");                                 
                                    session.setAttribute(SessionConstants.STUDENT_FIND_ERROR, null);
                                  } 
                                   else if (StringUtils.isNotEmpty(findsuccess)) {
                                    out.println("<p style='color:green;'>");                                 
                                    out.println("success: " + findsuccess);
                                    out.println("</p>");                                   
                                    session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, null);
                                  } 



             %>



         <div class="content_title"> 
        <p> <h3>Download leaders List </h3>
          
           <form  class="form-horizontal"   action="../leadersReport" method="POST" target="_blank">
                    <fieldset>
                    <div class="form-actions">        
                    <button type="submit" name="Report" value="Report"   class="btn btn-primary">Download</button> 
                    </div>
                    </fieldset>
                 </form>
        </p></div>
                      <p>&nbsp;&nbsp;&nbsp;</p>
                       <div class="content_title"> 
                       <h3>MMUCU LEADERS</h3>
                       <p> Executives:</p>
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
                        
                    </tr>
               </thead>   
               <tbody class='tablebody'>                    
                         <tr class="tabledit"> 
                          <% 
                          int execount = 1;
                          if(leadersRegisterList !=null){
                         for(LeadersRegister leader : leadersRegisterList){                          
                            student =  studentHash.get(leader.getStudentUuid());  
                            if(student !=null){
                               studentAdmno = student.getAdmNo();
                               studentFullname = student.getFirstName()+" "+student.getLastName()+" "+student.getSurName();
                               studentYOS = student.getYearOfStudy();
                              } 
                             
                             if(StringUtils.equals(leader.getStatusUuid(),STATUS_ACTIVE) && StringUtils.equals(leader.getCategory(),"Executive")){
                           
                           %>
                         <td width="3%"><%=execount%> </td>
                         <td class="center"><%=studentAdmno%></td>  
                         <td class="center"><%=studentFullname%></td>  
                         <td class="center"><%=studentYOS%></td>                    
                         <td class="center"><%=leader.getPosition()%></td>
                         <td class="center"><%=dateFormatter.format(leader.getStartDate())%></td>
                                           
                         
                       </tr>
                         <%
                               execount++;
                             
                              }
                             }
                           }
                           %>

            </tbody>
            </table>  



             <p>&nbsp;&nbsp;&nbsp;</p>
            <div class="content_title"> 
                <h3>MMUCU FAMIRIES</h3>
                <p> Overall Dad/Mum:</p>
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
                        
                    </tr>
               </thead>   
               <tbody class='tablebody'>                    
                         <tr class="tabledit"> 
                          <% 
                          int ofamcount = 1;  //
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
                           
                           %>
                         <td width="3%"><%=ofamcount%> </td>
                         <td class="center"><%=studentAdmno%></td>  
                         <td class="center"><%=studentFullname%></td>  
                         <td class="center"><%=studentYOS%></td>                    
                         <td class="center"><%=leader.getPosition()+" "+genderCategory%></td>
                         <td class="center"><%=dateFormatter.format(leader.getStartDate())%></td>
                         

                       </tr>
                    <%
                           ofamcount++;
                           }
                           }
                       }
                    %>

            </tbody>
            </table> 

              <p>&nbsp;&nbsp;&nbsp;</p>
              <div class="content_title"> 
                <p> Famiry Dad/Mum:</p>
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
                       
                    </tr>
               </thead>   
               <tbody class='tablebody'>                    
                         <tr class="tabledit"> 
                          <%
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
                           
                           %>
                         <td width="3%"><%=execount%> </td>
                         <td class="center"><%=studentAdmno%></td>  
                         <td class="center"><%=studentFullname%></td>  
                         <td class="center"><%=studentYOS%></td>                    
                         <td class="center"><%=leader.getPosition()+" "+genderCategory%></td>
                         <td class="center"><%=dateFormatter.format(leader.getStartDate())%></td>
                         

                       </tr>
                    <%
                           famcount++;
                           }
                           }
                       }
                    %>

            </tbody>
            </table>  
          


                      <p>&nbsp;&nbsp;&nbsp;</p>
                       <div class="content_title"> 
                       <h3>MMUCU MINISTRIES</h3>
                       <p> Ministries Leaders:</p>
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
                       
                    </tr>
               </thead>   
               <tbody class='tablebody'>                    
                         <tr class="tabledit"> 
                          <%  
                        
                         int mincount = 1;
                          if(leadersRegisterList !=null){
                         for(LeadersRegister leader : leadersRegisterList){   
                            String position = leader.getPosition();
                            String subposition = leader.getSubPosition();
                            if(StringUtils.equals(position,null) || StringUtils.equals(subposition,null)){
                              position = "";
                              subposition = "";
                            }



                            student =  studentHash.get(leader.getStudentUuid());  
                            if(student !=null){
                               studentAdmno = student.getAdmNo();
                               studentFullname = student.getFirstName()+" "+student.getLastName()+" "+student.getSurName();
                               studentYOS = student.getYearOfStudy();
                              } 
                             
                             if(StringUtils.equals(leader.getStatusUuid(),STATUS_ACTIVE) && StringUtils.equals(leader.getCategory(),"Ministry")){
                           
                           %>
                         <td width="3%"><%=mincount%> </td>
                         <td class="center"><%=studentAdmno%></td>  
                         <td class="center"><%=studentFullname%></td>  
                         <td class="center"><%=studentYOS%></td>                    
                         <td class="center"><%=position+" "+subposition%></td>
                         <td class="center"><%=dateFormatter.format(leader.getStartDate())%></td>           
                         

                       </tr>
                    <%
                          mincount++;
                              
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

    


         