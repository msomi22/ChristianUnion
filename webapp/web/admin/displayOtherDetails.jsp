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
 String Uuid = request.getParameter("Uuid");
 String Adm = request.getParameter("Admiss");
  //out.println(Adm+"  *** "+Uuid);
  Student student;
  StudentOtherDetail studentDetails;

  StudentDAO studentDAO = StudentDAO.getInstance();
   student = studentDAO.getStudentByUuid(Uuid);

  StudentOtherDetailDAO studentDetailsDAO = StudentOtherDetailDAO.getInstance();
   studentDetails = studentDetailsDAO.getDetail(Uuid);   

      %>      <style type="text/css">
             .tablecss{clear: both;
                       margin: 2%;
                       font-size: 16px;
                       color: #6978A4;
                       line-height: 30px;
                      },
               #Ztable{width: 800px;
                      /* height: 300px;*/
                      }
          
              </style>        

               <div id="Ztable">     
               <div class="tablecss">
              <p> M.M.U. C.U. Student Other Details for Admission No. <u><b><%=Adm%></b></u> </p>
             </div>
                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                <% if(student != null || studentDetails != null){
                %>
                <tbody>                   
                         <tr>  <td width="30%" class="center">Surname</td>                <td class="center"><%=student.getSurName()%></td> </tr>
                         <tr>  <td width="30%" class="center">Phone No</td>                <td class="center"><%=student.getMobile()%></td> </tr>
                         <tr>  <td width="30%" class="center">Guardian Contact</td>         <td class="center"><%=student.getGuardianContact()%></td> </tr>
                         <tr>  <td width="30%" class="center">Email</td>                <td class="center"><%=student.getEmail()%></td> </tr>
                         <tr>  <td width="30%" class="center">Program/Major</td>         <td class="center"><%=student.getProgram()%></td> </tr>                     
                         <tr>  <td width="30%" class="center">Academic Year</td>             <td class="center"><%=student.getAcademicYear()%></td>  </tr> 
                         <tr>  <td width="30%" class="center">Is a Christian?</td>            <td class="center"><%=studentDetails.getChristian()%></td>    </tr>
                         <tr>  <td width="30%" class="center">For What Period?</td>            <td class="center"><%=studentDetails.getDuration()%></td>     </tr>
                         <tr>  <td width="30%" class="center">Ever Served in a Ministry?</td>  <td class="center"><%=studentDetails.getMinistry()%></td>  </tr>
                         <tr>  <td width="30%" class="center">Which Ministry?</td>             <td class="center"><%=studentDetails.getMinistryName()%></td>    </tr>  
                         <tr>  <td width="30%" class="center">Desired Ministry</td>           <td class="center"><%=studentDetails.getDesiredMinistry()%></td> </tr>
                         <tr>  <td width="30%" class="center">Ministry Vision</td>             <td class="center"><%=studentDetails.getMinistryVision()%></td>   </tr>                    
                
                 <% } else 
                            {%>

                            <tr>  <td class="center">NO DETAILS THAT WERE FOUND!!</td> </tr>

                 <%
                    }
                 %>
                  </tbody>
                </table>                    
                  
                </div>


 