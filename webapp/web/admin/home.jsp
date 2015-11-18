<!--
/******************************************************************************
 * ****************************************************************************
 ************* MAASAI MARA UNIVERITY CHRISTIAN UNION MANAGEMENT SYSTEM*********
 *************THIS SYSTEM IS BASED ON JAVAEE, USING MVC MODEL******************
 *************THE SYSTEM IS USED FOR STUDEN REGISTRATION TO THE UNION**********
 *************STUDENT REGISTRATION MODULE WILL BE ACCESSIBLE REMOTELY**********
 *************VIA USE OF PUBLIC IP ADDRESS OR A DOMAIN NAME********************
 *THE STUDENT WILL ALSO BE ABLE TO CHECK THEIR REGISTERD DETAILS FOR VERIFICATION
 *WHEREBY, THEY ARE ALLOWED TO MODIGY THEIR DETAILS WITHIN ONE WEEK AFTER REGISTRATION DATE
 *****************************************************************************************
 *****************************************************************************************
 *THE OTHER MODULES OR ONLY FOR ADMIN, THE ADMIN WILL APPROVE STUDEDNTS AFTER THEY REGISTER
 *THE REGISTRATION WILL REQURED RE-ACTIVATION AFTER A PERIOD OF ONE YEAR(12 MONTHS) THIS WILL
 *HAPPEN AUTOMATICALLY WITH THE HELP OF QUARTZ SCHEDULAR, FOR EFFICIENCY AND KEEPING THE SYSTEM
 *AT HIGH PERFORMANCE, SOME DATA ARE CACHED USING EHCHACE.
 **********************************************************************************************
 **********************************************************************************************
 *COPYRIGHT REMAINS TO SOFTECH SOLUTIONS, A FAST GROWING IT COMPANY
 *CONTSCTS: WWW.FASTECCHSOLUTIONS.CO.KE
 *          WWW.FACEBOOK.COM/FASTECH.CO.KE
 *
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 */
  
-->


<%@page import="com.gmail.mwendapeter72.server.pagination.student.StudentPaginator"%>
<%@page import="com.gmail.mwendapeter72.server.pagination.student.StudentPage"%>

<%@page import="com.gmail.mwendapeter72.server.pagination.student.detail.StudentPaginator2"%>
<%@page import="com.gmail.mwendapeter72.server.pagination.student.detail.StudentPage2"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Student"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentStatusDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.StudentStatus"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StatusDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Status"%>

<%@page import="com.gmail.mwendapeter72.server.session.SessionConstants"%>
<%@page import="com.gmail.mwendapeter72.server.session.admin.SessionConstants2"%>

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

    String username = (String) session.getAttribute(SessionConstants2.ADMIN_SESSION_KEY);
    if (StringUtils.isEmpty(username)) {
        response.sendRedirect("index.jsp");
    }

     session.setMaxInactiveInterval(SessionConstants2.SESSION_TIMEOUT);
     response.setHeader("Refresh", SessionConstants2.SESSION_TIMEOUT + "; url=/ChristianUnion/admin");

    HashMap<String, String> stustatusHash = new HashMap<String, String>();
    HashMap<String, String> statusHash = new HashMap<String, String>();

   Student student;
   StudentOtherDetail studentDetal;
   StudentStatus status;
   Status sstatus;

   StudentStatusDAO stustatusDAO = StudentStatusDAO.getInstance();
   List<StudentStatus> stustatustList = new ArrayList(); 
   stustatustList = stustatusDAO.getAllStudentStatus();

   StatusDAO statusDAO = StatusDAO.getInstance();
   List<Status> statustList = new ArrayList(); 
   statustList = statusDAO.getAllStatus();

      for(StudentStatus st : stustatustList){
           stustatusHash.put(st.getStudentUuid(), st.getStudentStatusUuid());
       }

       for(Status stat : statustList){
           statusHash.put(stat.getUuid(), stat.getStatus());
       }
    
    

  // out.println(stustatustList);

   StudentDAO studentDAO = StudentDAO.getInstance();
   List<Student> studentList1 = new ArrayList(); 
   studentList1 = studentDAO.getStudentList(0,15);


  
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
      // }






 
   //date format
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
    SimpleDateFormat timezoneFormatter = new SimpleDateFormat("z");

      %>
    



        <div id="tooplate_wrapper">

        <jsp:include page="header.jsp" />

                                   

         <div id="search_box">
            <form action="#" method="get">
                <input type="text" placeholder="Search By AdmNo" name="q" size="10" id="searchfield" title="searchfield" onkeyup="displaystudents(this.value)" />
                <!--<input type="submit" name="Search" value="" id="searchbutton" title="Search" />-->
            </form>
        </div>

                  

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
                                    out.println("error!!: " + editErr);
                                    out.println("</p>");                                 
                                    session.setAttribute(SessionConstants.STUDENT_UPDATE_ERROR, null);
                                  } 
                                   else if (StringUtils.isNotEmpty(editsuccess)) {
                                    out.println("<p style='color:green;'>");                                 
                                    out.println("success: " + editsuccess);
                                    out.println("</p>");                                   
                                    session.setAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS, null);
                                  } 

                            %>

        <div id="container" class="clear"> 

        <div id="tooplate_middle">     
         <div id="middle_left">
            <p>MMU CU Student Basic Details</p>
          </div>
                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                <thead>
                    <tr>
                        <th>*</th>
                        <th>Admission Number</th>
                        <th>Firstname</th>                
                       <!-- <th>Surname</th>  -->
                        <th>Lastname</th>
                       <!-- <th>Phone</th> -->
                       <!-- <th>Gurdian Contact</th>  -->
                        <th>Age</th>
                        <th>Gender</th>
                       <!--  <th>Program/Major</th>  -->
                       <!--   <th>Academic Year</th>  -->
                        <th>Year Of Study</th>   
                        <th>Home Town</th>
                        <th>County</th>
                         <th>Status</th>
                        <th>Activated On</th>
                       
                        <th>actions</th>
                    </tr>
                </thead>   
                <tbody class='tablebody'>
                       

                     <%   
                      SimpleDateFormat dateFormatter2 = new SimpleDateFormat("yyyy");
                      Calendar now = Calendar.getInstance();   
                      String nowdate = dateFormatter2.format(now.getTime());                                                    
                      int count = 1;
                       for (Student s : studentList1) {

                         String dob = s.getDOB();
        
                         int y = Integer.parseInt(dob);
                         int a = Integer.parseInt(nowdate);

                         int age = a-y;
                       

                       
    
                    %>
                      <tr class="tabledit">
                         
                         <td width="10%"><%=ussdCount%> </td>
                         <td class="center" ><a class="Zlink" href="#" data-toggle="modal" data-target="#groupcheck" value='<%=s.getAdmNo()%>' name='<%=s.getUuid()%>' onclick="TableGet(this)"><%=s.getAdmNo()%></a> </td>

                         <td class="center"><%=s.getFirstName()%></td>

                       <!--  <td class="center"><%//=s.getSurName()%></td> -->
                         <td class="center"><%=s.getLastName()%></td>  
                         <!-- <td class="center"><%//=s.getMobile()%></td>  -->
                       <!--  <td class="center"><%//=s.getGuardianContact()%></td> -->
                         <td class="center"><%=age%></td>
                         <td class="center"><%=s.getGender()%></td>
                        <!--   <td class="center"><%//=s.getProgram()%></td>   -->
                       <!--   <td class="center"><%//=s.getAcademicYear()%></td>     -->
                         <td class="center"><%=s.getYearOfStudy()%></td>
                         <td class="center"><%=s.getHomeTown()%></td>
                         <td class="center"><%=s.getCounty()%></td>  
                         <td class="center"><%=statusHash.get(stustatusHash.get(s.getUuid() ))%></td>  
                         <td class="center"><%=dateFormatter.format(s.getDateOfRegistration())%></td> 
                        
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
                       </tr>

                    <%
                           ussdCount++;
                           
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


              
                 <br> <br> <br> <br> <br> <br>
                 <br> <br> <br> <br> <br> <br>
                 <br> <br> <br> <br> <br> <br>
                 <br> <br> <br> <br> <br> <br>
                 <br> <br> <br> <br> <br> <br>
                 <br> <br> <br> <br> <br> <br>
                 <br> <br> <br> <br> <br> <br>
                


             

<div class="modal fade" id="groupcheck" tabindex="-1" role="dialog" arialabelled="exampleModalLabeled" aria-hidden="true">
<div id="scroll21" style="width:800px; ">
 </div>
</div>

    <div id="tooplate_main_top"></div>        
    <div id="tooplate_main">
        
    
    	
        <div class="cleaner"></div>
    </div> <!-- end of main -->

    
  <jsp:include page="footer.jsp" />

        
</div> <!-- end of wrapper -->
