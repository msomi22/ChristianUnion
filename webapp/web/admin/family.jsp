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
<%@page import="com.gmail.mwendapeter72.server.bean.student.Student"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.leader.family.Family"%>

<%@page import="com.gmail.mwendapeter72.server.session.admin.SessionConstants"%>



<%@page import="org.apache.commons.lang3.StringUtils"%>

<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.net.URLEncoder"%>


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
  
       Cache famCache = mgr.getCache(CacheVariables.CACHE_FAMILY_BY_UUID);
       HashMap<String, Family> famHash = new HashMap<String, Family>();
    
      //Variables
      Student student;
      LeadersRegister leaderReg;
      Family family;
  
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
      List<LeadersRegister> leadersRegisterList = new ArrayList<LeadersRegister>();
      keys = leadersRegisterCache.getKeys();
      for (Object key : keys) {
            element = leadersRegisterCache.get(key);
            leaderReg = (LeadersRegister) element.getObjectValue();
            leadersRegisterHash.put(leaderReg.getStudentUuid(),leaderReg);
            leadersRegisterList.add(leaderReg); 
        }
     
      

        List<Family> famList = new ArrayList<Family>();
        keys = famCache.getKeys();
        for (Object key : keys) {
            element = famCache.get(key);
            family = (Family) element.getObjectValue();
            famList.add(family);   
        }

      
   

         //out.println(leadersRegisterHash);
         //out.println(famHash);
         //out.println(gukaHash);
         SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
        // Basic Variables
         String gender;
         String familyCategory;
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

                          String name =""; 
                          if(StringUtils.isEmpty(paramHash.get("name"))){
                           name = " ";
                          }else{
                           name = paramHash.get("name"); 
                         
                         }



             %>
           
           <div class="content_title"> 
                <h3>MMUCU Family Leaders Registration </h3>
                
            </div>
        <!-- <div id="tooplate_middle"> -->  
            
              <form  class="form-horizontal"   action="../findFamilyHead" method="POST" >
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
                   <form  class="form-horizontal"   action="../assignFamily" method="POST" >
                    <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="name">Full Name:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="fullname" 
                            value="<%=name%>" readonly >
                        </div>
                    </div> 


                    <div class="control-group" id="dividm">
                        <label class="control-label" for="name">Category:</label>
                        <div class="controls" id="getCategory">
                             <select name="Category" id="Category" >
                             <option value="">select one</option>
                             <option value="Dad/Mum">Dad/Mum</option>
                             <option value="Overall Dad/Mum">Overall Dad/Mum</option>
                           
                            </select>                           
                          
                        </div>
                        </div> 
                      


                        <div class="control-group" id="dividm">
                        <label class="control-label" for="name">Family:</label>
                        <div class="controls" id="getFamName">
                             <select name="FamilyName" id="FamName" >
                             <option value="">select one</option>
                             <%      
                                    int count = 1;  
                                    if (famList != null) {
                                        for (Family f : famList) {
                                %>

                                <option value="<%=f.getFamilyName()%>"  ><%=f.getFamilyName()%></option>
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
             <input type="hidden" name="Gender" value="<%=StringUtils.trimToEmpty(paramHash.get("Gender"))%>">
                        <button type="submit" name="Find" value="Assign"   class="btn btn-primary">Assign</button> 
                    </div>

                    </fieldset>
                    </form> <!--end of form assign-->




         </div> 

        </div>
    </div><!--/span-->

  <jsp:include page="footer.jsp" />

        
        

