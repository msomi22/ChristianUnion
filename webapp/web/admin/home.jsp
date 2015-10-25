


<%@page import="com.gmail.mwendapeter72.server.pagination.student.StudentPaginator"%>
<%@page import="com.gmail.mwendapeter72.server.pagination.student.StudentPage"%>

<%@page import="com.gmail.mwendapeter72.server.pagination.student.detail.StudentPaginator2"%>
<%@page import="com.gmail.mwendapeter72.server.pagination.student.detail.StudentPage2"%>

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
  if (session == null) {
        response.sendRedirect("../index.jsp");
    }

     session.setMaxInactiveInterval(SessionConstants.SESSION_TIMEOUT);
    response.setHeader("Refresh", SessionConstants.SESSION_TIMEOUT + "; url=../logout");

  Student student;
  StudentOtherDetail studentDetal;

  StudentDAO studentDAO = StudentDAO.getInstance();
  List<Student> studentList1 = new ArrayList(); 
  studentList1 = studentDAO.getStudentList(0,10);


  StudentOtherDetailDAO studentDetailsDAO = StudentOtherDetailDAO.getInstance();
  List<StudentOtherDetail> studentDetailsList = new ArrayList(); 
  studentDetailsList = studentDetailsDAO.getAllDetailList(0,10);

    HashMap<String, String> admnoHash = new HashMap<String, String>();
    HashMap<String, String> firstnameHash = new HashMap<String, String>();
    HashMap<String, String> lastnameHash = new HashMap<String, String>();


   
          for(Student ss : studentList1){
             admnoHash.put(ss.getUuid(), ss.getAdmNo() );
             firstnameHash.put(ss.getUuid(), ss.getFirstName() );
             lastnameHash.put(ss.getUuid(), ss.getLastName() );
        
          }
         




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





     
     int ussdCount2 = 0;
     StudentPaginator2 paginator2 = new StudentPaginator2();
       StudentPage2 studentpage2;    
       studentpage2 = (StudentPage2) session.getAttribute("currentPage2");
        String referrer2 = request.getHeader("referer");
        String pageParam2 = (String) request.getParameter("page2");

        // We are to give the first page
        if (studentpage2 == null
                || !StringUtils.endsWith(referrer2, "home.jsp")
                || StringUtils.equalsIgnoreCase(pageParam2, "first")) {
              studentpage2 = paginator2.getFirstPage();

            //We are to give the last page
        } else if (StringUtils.equalsIgnoreCase(pageParam2, "last")) {
             studentpage2 = paginator2.getLastPage();

            // We are to give the previous page
        } else if (StringUtils.equalsIgnoreCase(pageParam2, "previous")) {
            studentpage2 = paginator2.getPrevPage(studentpage2);

            // We are to give the next page 
        } else if (StringUtils.equalsIgnoreCase(pageParam2, "next"))  {
           studentpage2 = paginator2.getNextPage(studentpage2);
        }

        session.setAttribute("currentPage2", studentpage2);
        studentDetailsList = studentpage2.getContents();
        ussdCount2 = (studentpage2.getPageNum() - 1) * studentpage2.getPagesize() + 1;


 
   //date format
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
    SimpleDateFormat timezoneFormatter = new SimpleDateFormat("z");

      %>
    



        <div id="tooplate_wrapper">

        <jsp:include page="header.jsp" />



         <div id="search_box">
            <form action="#" method="get">
                <input type="text" placeholder="Search By AdmNo" name="q" size="10" id="searchfield" title="searchfield" onkeyup="searchstudents(this.value)" />
                <!--<input type="submit" name="Search" value="" id="searchbutton" title="Search" />-->
            </form>
        </div>



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
                        <th>Phone</th>
                       <!-- <th>Gurdian Contact</th>  -->
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Program/Major</th>
                      <!--   <th>Academic Year</th>    -->
                        <th>Year Of Study</th>   
                        <th>Home Town</th>
                        <th>County</th>
                        <th>Registration Date</th>
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
                         <td class="center"><%=s.getAdmNo()%> </td>  
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
                         <td class="center"><%=dateFormatter.format(s.getDateOfRegistration())%></td>  
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


               <div id="tooplate_middle">     
               <div id="middle_left">
              <p>MMU CU Student Other Details</p>
             </div>
                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                <thead>
                    <tr>
                        <th>*</th>
                        <th>Admission Number</th>
                        <th>Firstname</th>                
                        <th>Lastname</th>
                        <th>Is a Christian?</th>
                        <th>For What Period?</th>
                        <th>Ever serverd in a Ministry?</th>
                        <th>Which Ministry?</th>
                        <th>Desired Ministry</th>
                        <th>Ministry Vision</th>
                    </tr>
                </thead>   
                <tbody>
                       

                     <%   
                                                                   
                      int counts = 1;
                       for (StudentOtherDetail d : studentDetailsList) {
                              
              
                    %>
                      <tr>
                         <td width="10%"><%=ussdCount2%></td>
                         <td class="center"><%=admnoHash.get(d.getStudentUuid())%></td> 
                         <td class="center"><%=firstnameHash.get(d.getStudentUuid())%></td>
                         <td class="center"><%=lastnameHash.get(d.getStudentUuid())%></td>  
                         <td class="center"><%=d.getChristian()%></td>  
                         <td class="center"><%=d.getDuration()%></td> 
                         <td class="center"><%=d.getMinistry()%></td>
                         <td class="center"><%=d.getMinistryName()%></td>  
                         <td class="center"><%=d.getDesiredMinistry()%></td> 
                         <td class="center"><%=d.getMinistryVision()%></td>
                       
                       </tr>

                    <%
                           ussdCount2++;
                            } 
                   
                    %>

                </tbody>
                </table>  
                    
                     <div id="pagination">
                <form name="pageForm" method="post" action="home.jsp">                                
                    <%                                            
                        if (!studentpage2.isFirstPage()) {
                    %>
                        <input class="toolbarBtn" type="submit" name="page2" value="First" />
                        <input class="toolbarBtn" type="submit" name="page2" value="Previous" />
                    <%
                        }
                    %>
                    <span class="pageInfo">Page 
                        <span class="pagePosition currentPage2"><%= studentpage2.getPageNum()%></span> of 
                        <span class="pagePosition"><%= studentpage2.getTotalPage()%></span>
                    </span>   
                    <%
                        if (!studentpage2.isLastPage()) {                        
                    %>
                        <input class="toolbarBtn" type="submit" name="page2" value="Next">  
                        <input class="toolbarBtn" type="submit" name="page2" value="Last">
                    <%
                       }
                    %>                                
                </form>
            </div>
                    
                    
                </div>








    



 <br> <br> <br> <br> <br> <br>
 <br> <br> <br> <br> <br> <br>
     <p>&nbsp;&nbsp;&nbsp;</p>
	
    <div id="tooplate_main_top"></div>        
    <div id="tooplate_main">
        
    
    	
        <div class="cleaner"></div>
    </div> <!-- end of main -->
    
  <jsp:include page="footer.jsp" />

        
</div> <!-- end of wrapper -->
