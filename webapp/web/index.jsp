

<%@page import="com.gmail.mwendapeter72.server.session.SessionConstants"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 if (session == null) {
        response.sendRedirect("index.jsp");
    }

    
     response.setIntHeader("Refresh",200);
%>










<div id="tooplate_wrapper">

  <jsp:include page="header.jsp" />
    
 <div id="container" class="clear"> 
  

                             <%

                         HashMap<String, String> paramHash = (HashMap<String, String>) session.getAttribute(
                         SessionConstants.STUDENT_REGISTER_DETAILS);

                        if (paramHash == null) {
                             paramHash = new HashMap<String, String>();
                            }





                                String addErrStr = "";
                                String addsuccessStr = "";
                                session = request.getSession(false);
                                     addErrStr = (String) session.getAttribute(SessionConstants.STUDENT_ADD_ERROR);
                                     addsuccessStr = (String) session.getAttribute(SessionConstants.STUDENT_ADD_SUCCESS); 

                                if(session != null) {
                                    addErrStr = (String) session.getAttribute(SessionConstants.STUDENT_ADD_ERROR);
                                    addsuccessStr = (String) session.getAttribute(SessionConstants.STUDENT_ADD_SUCCESS);
                                }                        

                                if (StringUtils.isNotEmpty(addErrStr)) {
                                    out.println("<p style='color:red;'>");                 
                                    out.println("error!!: " + addErrStr);
                                    out.println("</p>");                                 
                                    session.setAttribute(SessionConstants.STUDENT_ADD_ERROR, null);
                                  } 
                                   else if (StringUtils.isNotEmpty(addsuccessStr)) {
                                    out.println("<p style='color:green;'>");                                 
                                    out.println("success: " + addsuccessStr);
                                    out.println("</p>");                                   
                                    session.setAttribute(SessionConstants.STUDENT_ADD_SUCCESS, null);
                                  } 

                            %>







   
    <div id="homepage" class="clear">  
     <h3><i class="icon-edit"></i> Student Registration Form: Basic Details</h3>            
      <P> <b style=color:red;>Please NOTE that fields marked with(*) are required/mandatory </b></P>
        
         <div class="box-content">
            <form  class="form-horizontal"   action="addStudent" method="POST" >
                <fieldset>

                    <div class="control-group">
                        <label class="control-label" for="name">Admission Nummber*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="AdmNo" 
                            value="<%= StringUtils.trimToEmpty(paramHash.get("AdmNo")) %>"  >

                        </div>
                    </div>  

                    <div class="control-group">
                        <label class="control-label" for="name">First Name*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="FirstName" 
                             value="<%= StringUtils.trimToEmpty(paramHash.get("FirstName")) %>"  >                                    
                        </div>
                    </div> 


                    <div class="control-group">
                        <label class="control-label" for="name">SurName*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="SurName"
                              value="<%= StringUtils.trimToEmpty(paramHash.get("SurName")) %>"  >
                        </div>
                    </div> 


                     <div class="control-group">
                        <label class="control-label" for="name">Last Name*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="LastName"
                              value="<%= StringUtils.trimToEmpty(paramHash.get("LastName")) %>"  >
                        </div>
                    </div> 
                    

                    <div class="control-group">
                        <label class="control-label" for="name">Email*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="Email" 
                            value="<%= StringUtils.trimToEmpty(paramHash.get("Email")) %>"  >
                        </div>
                    </div> 





                    <div class="control-group">
                        <label class="control-label" for="name">Phone*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="Phone" 
                            value="<%= StringUtils.trimToEmpty(paramHash.get("Phone")) %>"   >
                        </div>
                    </div> 

                           
                            
                      
                      <div class="control-group">
                        <label class="control-label" for="name">Guardian Contact*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="GuardianContact" 
                             value="<%= StringUtils.trimToEmpty(paramHash.get("GuardianContact")) %>"   >
                        </div>
                    </div> 


                    <div class="control-group">
                        <label class="control-label" for="name">Year Of Birth*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="DOB" 
                             value="<%= StringUtils.trimToEmpty(paramHash.get("DOB")) %>"   >
                        </div>
                    </div> 

                           


                   
                     <div class="control-group">
                        <label class="control-label" for="name">Gender*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="radio" name="studentgender" value="MALE" >Male 
                            <input class="input-xlarge focused" id="receiver" type="radio" name="studentgender" value="FEMALE">Female 
                        </div>
                    </div> 



                       <h3><i class="icon-edit"></i> Education Details*:</h3>      


                    <div class="control-group">
                        <label class="control-label" for="name">Program/Major*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="Program" 
                              value="<%= StringUtils.trimToEmpty(paramHash.get("Program")) %>"   >

                        </div>
                    </div> 



                    <div class="control-group">
                        <label class="control-label" for="name">Academic Year*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="AcademicYear" 
                              value="<%= StringUtils.trimToEmpty(paramHash.get("AcademicYear")) %>" >
                        </div>
                    </div> 



                     
                    <div class="control-group">
                        <label class="control-label" for="name">Year Of Study*:</label>
                         <div class="controls">
                            <select name="YearOfStudy" >
                                <option value="">Please select one</option> 
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                
                            </select>                           
                          
                        </div>
                    </div> 
                    
                       <h3><i class="icon-edit"></i> Other Details:</h3> 

                    <div class="control-group">
                        <label class="control-label" for="name">Home Town*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="HomeTown" 
                              value="<%= StringUtils.trimToEmpty(paramHash.get("HomeTown")) %>" >
                        </div>
                    </div> 


                    <div class="control-group">
                        <label class="control-label" for="name">County*:</label> <!--required="true" -->
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="County" 
                             value="<%= StringUtils.trimToEmpty(paramHash.get("County")) %>" >
                        </div>
                    </div> 


                      <h3><i class="icon-edit"></i> Your Christian Life:</h3> 

                    
                   <div class="control-group">
                        <label class="control-label" for="name"> Area You A Christian?*:</label>
                        <div class="controls">
                             <input class="input-xlarge focused" id="receiver" type="radio" name="Christian" value="YES" checked>Yes 
                             <input class="input-xlarge focused" id="receiver" type="radio" name="Christian" value="NO">No 
                        </div>

                    </div> 
                      

                   <div class="control-group">
                        <label class="control-label" for="name">If Yes Approximately For How long Have You Been In Christianity:</label>
                        <div class="controls">
                            <select name="Duration" >
                                <option value="">Please select one</option> 
                                <option value="Less Than 6 Months">Less Than 6 Months</option>
                                <option value="Between 6-12 Months">Between 6-12 Months</option>
                                <option value="Between 1-2 Years">Between 1-2 Years</option>
                                <option value="Between 2-4 Years">Between 2-4 Years</option>
                                <option value="Above 4 Years">Above 4 Years</option>
                            </select>                           
                          
                        </div>
                    </div> 


                     <div class="control-group">
                        <label class="control-label" for="name"> Have you ever served in any ministry?:</label>
                        <div class="controls">
                             <input class="input-xlarge focused" id="receiver" type="radio" name="Ministry" value="YES"checked >Yes
                             <input class="input-xlarge focused" id="receiver" type="radio" name="Ministry" value="NO">No 
                        </div>
                    </div> 


                   <div class="control-group">
                        <label class="control-label" for="name">If Yes which Ministry(s):</label>
                        <div class="controls">
                            <select name="MinistryName" >
                                <option value="">Please select one</option> 
                                <option value="Bible Study">Bible Study</option>
                                <option value="Praise And Worship">Praise And Worship</option>
                                <option value="Intercessory">Intercessory</option>
                                <option value="Evangelism">Evangelism</option>
                                
                            </select>                           
                          
                        </div>
                    </div> 


                     <div class="control-group">
                        <label class="control-label" for="name">Which ministry would you like to serve in the Maasai Mara University Christian Union?:</label>
                       <div class="controls">
                            <select name="DesiredMinistry" >
                                <option value="">Please select one</option> 
                                <option value="Bible Study">Bible Study</option>
                                <option value="Praise And Worship">Praise And Worship</option>
                                <option value="Intercessory">Intercessory</option>
                                <option value="Evangelism">Evangelism</option>
                                
                            </select>                           
                          
                        </div>
                    </div> 



                     <div class="control-group">
                        <label class="control-label" for="name">What is your vision for the Ministry you desire Serve in?:</label>
                        <div class="controls">
                            <textarea  type="textarea" name="Vision" rows="5" cols ="90"     value="<%= StringUtils.trimToEmpty(paramHash.get("Vision")) %>">
                            </textarea>
                        </div>
                    </div> 
                   



                     <h3><i class="icon-edit"></i> Student Declaration:</h3>        
                    <p>According to <b>MMCU(MU)</b> Constitution <i>Article 6(A) (1)</i>.Full membership shall be open to all bonafide 
                       registered undergeaduate students of <u>Maasai Mara University</u> Christan Union(Main campus) 
                       who ascribe to the doctrinal basis in <i>article (5)</i> and soberly sign/accept the following declaration.</p>
                    <p>"In Joining <b>MMUCU(MU),</b> <strong>I declare</strong> my Faith in Jesus as my Savior and Lord, and it is my desire by the Grace of God to
                    live a life consistent with this Declaration.I am also determined to give active support to the <b>MMUCU(MU)</b> as it seeks
                    to fullfill it aims"</p>   
                    <input type="checkbox" name="Declaration" id="Declaration" >
                    I Declare  <a href=#">

               
                    <div class="form-actions">
                        <button type="submit" name="Send" value="Send"   class="btn btn-primary">Submit</button>
                    </div>
                            
                   </fieldset>
                   </form>

                  
       
                   </div><!--/span-->








    
             
         
    </div>
        <div class="cleaner"></div>
    </div> <!-- end of main -->
    
   <jsp:include page="footer.jsp" />

   

</div>














