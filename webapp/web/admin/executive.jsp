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
<%@page import="com.gmail.mwendapeter72.server.bean.student.leader.executive.Executive"%>
<%@page import="com.gmail.mwendapeter72.server.session.admin.SessionConstants"%>

<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
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

      
    
    

    
      CacheManager mgr = CacheManager.getInstance();
       Cache execCache = mgr.getCache(CacheVariables.CACHE_EXECUTIVE_BY_UUID);

        Executive exec;
        List keys;
        Element element;
        
         keys = execCache.getKeys();
        List<Executive> execList = new ArrayList<Executive>();
        for (Object key : keys) {
            element = execCache.get(key);
            exec = (Executive) element.getObjectValue();
            execList.add(exec);
        }
    
   
        

%>






  <jsp:include page="header.jsp" />




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

                          String name =""; 
                          if(StringUtils.isEmpty(paramHash.get("nameExecutive"))){
                           name = " ";
                          }else{
                           name = paramHash.get("nameExecutive"); 
                         
                         }



             %>

        <!-- <div id="tooplate_middle"> -->  
             <P><b style=color:blue;> Executive </b></P>
              <form  class="form-horizontal"   action="../findExec" method="POST" >
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
                   <form  class="form-horizontal"   action="../assignExecutive" method="POST" >
                    <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="name">Full Name:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="fullname" 
                            value="<%=name%>" readonly >
                        </div>
                    </div> 


                        <div class="control-group" id="dividm">
                        <label class="control-label" for="name">Role:</label>
                        <div class="controls" id="getExecName">
                             <select name="CategoryUuid" id="Name" >
                             <option value="">Select One</option>
                                <%      
                                    int count = 1;
                                    if (execList != null) {
                                        for (Executive ex : execList) {
                                %>

                                <option value="<%=ex.getUuid()%>"  ><%=ex.getCategory()%></option>
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
                        <button type="submit" name="Find" value="Assign"   class="btn btn-primary">Assign</button> 
                    </div>

                    </fieldset>
                    </form> <!--end of form assign-->




         </div> 

  <jsp:include page="footer.jsp" />

        


