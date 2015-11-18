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


<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Student"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StudentStatusDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.StudentStatus"%>

<%@page import="com.gmail.mwendapeter72.server.persistence.student.StatusDAO"%>
<%@page import="com.gmail.mwendapeter72.server.bean.student.Status"%>

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
        response.sendRedirect("index.jsp");
    }

    
     response.setIntHeader("Refresh",200);



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


  
 
   //date format
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
    SimpleDateFormat timezoneFormatter = new SimpleDateFormat("z");

      %>
    



        <div id="tooplate_wrapper">

        <style type="text/css">
         input{
           height: 26px !important;
            }
   
          </style>

        <jsp:include page="header.jsp" />

        

                   <%   

                         HashMap<String, String> paramHash = (HashMap<String, String>) session.getAttribute(
                         SessionConstants.STUDENT_REGISTER_DETAILS);

                        if (paramHash == null) {
                             paramHash = new HashMap<String, String>();
                            }

                                
                            // out.println("academic year"+request.getSession().getAttribute("academic_year"));   
                            // out.println("year of study"+request.getSession().getAttribute("year_of_study"));     
                        

                                String editErr = "";
                                String editsuccess = "";
                                session = request.getSession(false);
                                     editErr = (String) session.getAttribute(SessionConstants.STUDENT_UPDATE_ERROR);
                                     editsuccess = (String) session.getAttribute(SessionConstants.STUDENT_UPDATE_SUCCESS); 

                                                    

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



                    <form action="studentUpdate" method="POST">
                    <fieldset>

                        <div class="control-group">
                        <label class="control-label" for="AdmNo">Admission Number:</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  placeholder="Search By AdmNo" id="receiver" type="text" name="AdmNo" 
                             value="<%=StringUtils.trimToEmpty(paramHash.get("AdmNumber"))%>"  >                                    
                         </div>
                         </div> 
                         <div class="form-actions">
                         <button type="submit" name="Find" value="Find"   class="btn btn-primary">Find</button>
                         </div>
                            
                     </fieldset>
                     </form>
                    </div>







                       <br> <br> <br> <br> <br> <br>
                       <br> <br> <br> <br> <br> <br>




                      <div id="middle_left">
               <form action="activateStudent" method="POST">
                 <fieldset>

                 <div class="control-group">
                        <label class="control-label" for="AdmNo">Year Of Study:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" placeholder="Year Of Study"  id="receiver" type="text" name="year_of_study" 
                             value="<%=StringUtils.trimToEmpty(paramHash.get("year_of_study"))%>"  >                                    
                        </div>
                    </div> 

                     <div class="control-group">
                        <label class="control-label" for="AdmNo">Academic Year:</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  placeholder="Academic Year" id="receiver" type="text" name="academic_year" 
                             value="<%=StringUtils.trimToEmpty(paramHash.get("academic_year")) %>"  >                                    
                        </div>
                    </div> 
                  
                    <div class="form-actions">
                         <input type="hidden" name="student_uuid" value="<%=StringUtils.trimToEmpty(paramHash.get("student_uuid"))%>">
                        <button type="submit" name="Activate" value="Activate"   class="btn btn-primary">Activate</button>
                    </div>
                            
                   </fieldset>
                 </form>

              </div>

	                  </div>


             
                 <br> <br> <br> <br> <br> <br>
                 <br> <br> <br> <br> <br> <br>
                 <br> <br> <br> <br> <br> <br>
                


             


    <div id="tooplate_main_top"></div>        
    <div id="tooplate_main">
        
    
    	
        <div class="cleaner"></div>
    </div> <!-- end of main -->

    
  <jsp:include page="footer.jsp" />

        
</div> <!-- end of wrapper -->
