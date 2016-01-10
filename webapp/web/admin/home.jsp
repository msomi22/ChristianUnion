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

<%@page import="com.gmail.mwendapeter72.server.pagination.student.StudentPaginator"%>
<%@page import="com.gmail.mwendapeter72.server.pagination.student.StudentPage"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Student"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail"%>


<%@page import="com.gmail.mwendapeter72.server.persistence.student.StatusDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Status"%>

<%@page import="com.gmail.mwendapeter72.server.session.admin.SessionConstants"%>

<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="org.apache.commons.lang3.math.NumberUtils"%>


<%@page import="java.util.ArrayList"%>
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
  
      StudentDAO studentDAO = StudentDAO.getInstance();
     //Stusent Cache Management
       CacheManager mgr = CacheManager.getInstance();
       Cache studentsCache = mgr.getCache(CacheVariables.CACHE_STUDENT_BY_UUID);

       Student student = new Student();
     

       List keys;
       Element element;

     //get Student details from chase, put them in hashmap
      List<Student> studentList = new ArrayList(); 
      keys = studentsCache.getKeys();
      for (Object key : keys) {
            element = studentsCache.get(key);
            //student = (Student) element.getObjectValue();
           // studentList.add(student);
      }
      studentList = studentDAO.getStudentList();

      List<Student> studentList1 = new ArrayList(); 
      studentList1 = studentDAO.getStudentList(0,15);

      HashMap<String, String> statusHash = new HashMap<String, String>();

     

        StatusDAO statusDAO = StatusDAO.getInstance();
        List<Status> statustList = new ArrayList(); 
        statustList = statusDAO.getAllStatus();
     
       for(Status stat : statustList){
           statusHash.put(stat.getUuid(), stat.getStatus());
       }
     

   //date format
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
    SimpleDateFormat timezoneFormatter = new SimpleDateFormat("z");


    /*if(out.getBufferSize() !=0){
          out.clearBuffer();
          out.println("error");
          return;
      } */

     int ussdCount = 0;
     StudentPaginator paginator = new StudentPaginator();
     StudentPage studentpage;

     
     studentpage = (StudentPage) session.getAttribute("currentPage");
        String referrer = request.getHeader("referer");
        String pageParam = (String) request.getParameter("page");

        // We are to give the first page
        if (studentpage == null
                || !StringUtils.endsWith(referrer, "home.jsp")
                || StringUtils.equalsIgnoreCase(pageParam, "first")) {
              studentpage = paginator.getFirstPage();

            //We are to give the last page
        } else if (StringUtils.equalsIgnoreCase(pageParam, "last")) {
             studentpage = paginator.getLastPage();

            // We are to give the previous page
        } else if (StringUtils.equalsIgnoreCase(pageParam, "previous")) {
            studentpage = paginator.getPrevPage(studentpage);

            // We are to give the next page 
        } else if (StringUtils.equalsIgnoreCase(pageParam, "next"))  {
           studentpage = paginator.getNextPage(studentpage);
        }

        session.setAttribute("currentPage", studentpage);
        studentList1 = studentpage.getContents();
        ussdCount = (studentpage.getPageNum() - 1) * studentpage.getPagesize() + 1;
    

%> 
<jsp:include page="header.jsp" />

  


<div class="row-fluid sortable">		
    <div class="box span12">
       
        <div class="box-content">
            
                    <%

                        

                                String editErr = "";
                                String editsuccess = "";
                                session = request.getSession(false);
                                     editErr = (String) session.getAttribute(SessionConstants.STUDENT_UPDATE_ERROR);                                
                                     editsuccess = (String) session.getAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS); 

                                if(session != null) {
                                    editErr = (String) session.getAttribute(SessionConstants.STUDENT_UPDATE_ERROR);
                                    editsuccess = (String) session.getAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS);
                                }                        

                                if (StringUtils.isNotEmpty(editErr)) {
                                    out.println("<p style='color:red;'>");                 
                                    out.println("Oh my God!: " + editErr);
                                    out.println("</p>");                                 
                                    session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, null);
                                  } 
                                   else if (StringUtils.isNotEmpty(editsuccess)) {
                                    out.println("<p style='color:green;'>");                                 
                                    out.println("Sharom!: " + editsuccess);
                                    out.println("</p>");                                   
                                    session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, null);
                                  } 

                                 

                            %>


            <div>
                            <div id="search_box">
                     <form action="#" method="get">
                <input type="text" placeholder="Search By AdmNo" name="q" size="10" id="searchfield" title="searchfield" onkeyup="displaystudents(this.value)" />
                    </form>
                      </div>




            <table class="table table-striped table-bordered bootstrap-datatable ">
                <thead>
                    <tr>
                        <th>*</th>
                        <th>Admission Number</th>
                        <th>Firstname</th>                
                        <th>Lastname</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Year Of Study</th>   
                        <th>County</th>
                        <th>Status</th>
                        <th>Activated On</th>
                        <th>Action</th>
                        <th>Download</th>
                    </tr>
               </thead>   
               <tbody class='tablebody'>
                       

                     <%   
                      SimpleDateFormat dateFormatter2 = new SimpleDateFormat("yyyy");
                      Calendar now = Calendar.getInstance();   
                      String nowdate =(String) dateFormatter2.format(now.getTime());  

                      int count = 1;
                      if(studentList1 !=null){
                       for (Student s : studentList1) {

                         String dob = s.getDOB();
                        
                         int birthYear =  NumberUtils.toInt(dob);
                         int currentYear = NumberUtils.toInt(nowdate);

                         int age = currentYear - birthYear;
                     
                       

                       
    
                    %>
                      <tr class="tabledit">
                         
                         <td width="3%"><%=ussdCount%> </td>
                         <td class="center" ><a class="Zlink" href="#" data-toggle="modal" data-target="#groupcheck" value='<%=s.getAdmNo()%>' name='<%=s.getUuid()%>' onclick="TableGet(this)"><%=s.getAdmNo()%></a> </td>

                         <td class="center"><%=s.getFirstName()%></td>
                         <td class="center"><%=s.getLastName()%></td>  
                         <td class="center"><%=age%></td>
                         <td class="center"><%=s.getGender()%></td>
                         <td class="center" width="5%"><%=s.getYearOfStudy()%></td>
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
                     if(ss !=null) {
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
                                <form name="print" method="post" action="../studentReport" target="_blank">
                                <input type="hidden" name="AdmNo" value="<%=s.getAdmNo()%>">
                                <input class="btn btn-success" type="submit" name="printstudent" id="submit" value="PDF" />
                                </form> 
                                </td>
                       </tr>

                    <%
                           ussdCount++;
                             }
                            }
                        }
                    %>

                </tbody>
            </table>  


            <div id="pagination">
                <form name="pageForm" method="post" action="home.jsp">                                
                    <%                                            
                        if (!studentpage.isFirstPage()) {
                    %>
                        <input class="toolbarBtn" type="submit" name="page" value="First" />
                        <input class="toolbarBtn" type="submit" name="page" value="Previous" />
                    <%
                        }
                    %>
                    <span class="pageInfo">Page 
                        <span class="pagePosition currentPage"><%= studentpage.getPageNum()%></span> of 
                        <span class="pagePosition"><%= studentpage.getTotalPage()%></span>
                    </span>   
                    <%
                        if (!studentpage.isLastPage()) {                        
                    %>
                        <input class="toolbarBtn" type="submit" name="page" value="Next">  
                        <input class="toolbarBtn" type="submit" name="page" value="Last">
                    <%
                       }
                    %>                                
                </form>
            </div>


            </div>

       <br>   <br>   <br>


                  
<div class="modal fade" id="groupcheck" tabindex="-1" role="dialog" arialabelled="exampleModalLabeled" aria-hidden="true">
<div id="scroll21" style="width:800px; ">
 </div>
</div>

        </div>
    </div><!--/span-->

</div><!--/row-->


<jsp:include page="footer.jsp" />
