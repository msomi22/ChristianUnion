<%
/**
Maasai Mara University Christian Union Online Management System.


Copyright 2015 Fastech Solutions Ltd
Licensed under the Open Software License, Version 3.0 
The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.

Contacts author the: +254718953974

@author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 */
%>


<%@page import="com.gmail.mwendapeter72.server.util.FontImageGenerator"%>
<%@page import="com.gmail.mwendapeter72.server.session.SessionConstants"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="org.apache.commons.lang3.RandomStringUtils"%>
<%@page import="org.jasypt.util.text.BasicTextEncryptor"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Calendar" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 if (session == null) {
        response.sendRedirect("index.jsp");
    }

    
     response.setIntHeader("Refresh",200);

       BasicTextEncryptor textEncryptor = new BasicTextEncryptor();    
       textEncryptor.setPassword(FontImageGenerator.SECRET_KEY);   


      String captcha = RandomStringUtils.randomAlphabetic(4); 
      String encryptedCaptcha = textEncryptor.encrypt(captcha.toLowerCase());
%>




<div id="tooplate_wrapper">

  <jsp:include page="header.jsp" />
  <script>
	
	function hideDiv(){
		$('#divid').hide();
	}

	function showDiv(){
    $('#divid').show();

	 }

	 function hideDivm(){
		$('#dividm').hide();
	}

	function showDivm(){
      $('#dividm').show();

	 }
</script>  
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
                                    out.println("error: " + addErrStr);
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






<div id="tooplate_main_top"></div>        
    <div id="tooplate_main" >
   
    <div id="homepage" class="clear">  
     <h3><i class="icon-edit"></i>Membership Registration Form: Personnal Information</h3>            
      <P> <b style=color:red;>Please NOTE that fields marked with(*) are required/mandatory </b></P>
        
         <div class="box-content">
            <form  class="form-horizontal"   action="addStudent" method="POST" >
                <fieldset>

                    <div class="control-group">
                        <label class="control-label" for="name">Admission Number*:</label>
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

                    
                   <div class="control-group" >
                        <label class="control-label" for="name"> Area You A Christian?*:</label>
                        <div class="controls">
                             <input class="input-xlarge focused" id="receiver" type="radio" onchange ="showDiv()" name="Christian" value="YES" checked>Yes 
                             <input class="input-xlarge focused" id="receiver" type="radio" onchange ="hideDiv()"name="Christian" value="NO">No 
                        </div>

                    </div> 
                      

                   <div class="control-group" id="divid">
                        <label class="control-label" for="name">For How long have you been in Christianity?:</label>
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
                        <label class="control-label" for="name">Ever served in any ministry?:</label>
                        <div class="controls">
                             <input class="input-xlarge focused" id="receiver" type="radio" onchange ="showDivm()" name="Ministry" value="YES"checked >Yes
                             <input class="input-xlarge focused" id="receiver" type="radio" onchange ="hideDivm()" name="Ministry" value="NO">No 
                        </div>
                    </div> 


                   <div class="control-group" id="dividm">
                        <label class="control-label" for="name">Which Ministry(ies)/Current Ministry(ies):</label>
                        <div class="controls">
                            <select name="MinistryNames"  multiple>
                                <option value="Bible Study" selected>Bible Study</option>
                                <option value="Praise And Worship">Praise And Worship</option>
                                <option value="Intercessory">Intercessory</option>
                                <option value="Evangelism">Evangelism</option>
                                <option value="Evangelism">Techinical</option>
                                <option value="Evangelism">Ushering</option>

                            </select>                           
                          
                        </div>
                    </div> 


                     <div class="control-group">
                        <label class="control-label" for="name">Which Ministry(ies) would you like to serve in the MMUCU?:</label>
                       <div class="controls">
                            <select name="DesiredMinistries" multiple>
                                <option value="Bible Study" selected>Bible Study</option>
                                <option value="Praise And Worship">Praise And Worship</option>
                                <option value="Intercessory">Intercessory</option>
                                <option value="Evangelism">Evangelism</option>
                                <option value="Evangelism">Techinical</option>
                                <option value="Evangelism">Ushering</option>
                                
                            </select>                           
                          
                        </div>
                    </div> 



                     <div class="control-group">
                        <label class="control-label" for="name">What's your vision for the Ministry(ies)?:</label>
                        <div class="controls">
                            <textarea  type="textarea" name="Vision" rows="5" cols ="90"     value="<%= StringUtils.trimToEmpty(paramHash.get("Vision")) %>">
                            </textarea>
                        </div>
                    </div> 
                   



                     <h3><i class="icon-edit"></i> Student Declaration:</h3>        
                    <p>According to <b>MMUCU</b> Constitution <i>Article 6(A) (1)</i>.Full membership shall be open to all bonafide 
                       registered undergraduate students of <u>Maasai Mara University</u> Christan Union(Main campus) 
                       who ascribe to the doctrinal basis in <i>article (5)</i> and soberly sign/accept the following declaration.</p>
                    <p>"In Joining <b>MMUCU,</b> <strong>I declare</strong> my Faith in Jesus as my Savior and Lord, and it is my desire by the Grace of God to
                    live a life consistent with this Declaration.I am also determined to give active support to the <b>MMUCU</b> as it seeks
                    to fulfil it aims"</p>   
                    <input type="checkbox" name="Declaration" id="Declaration" >
                    I Declare  <a href=#"></a>

                      
                      


                     <h3><i class="icon-edit"></i> Are You a robot?</h3>  
                      <div class="formalign">
                      <span class="_nb-checkbox-label"><i>Type the characters you see in the image below.(Letters are not case-sensitive)</i></span>
                      </div>
                      <% String fontImageUrl = "fontImageGenerator?text=" + URLEncoder.encode(encryptedCaptcha, "UTF-8"); %>
                        
                         <div id="spam-check">

                      <img id="captcha" src=<% out.println("\"" + fontImageUrl + "\"");%> width="68" height="29" />
                      <input type="text" name="captchaAnswer" id="captchaAnswer" size="5" class="input_normal" />
                      <input type="hidden" name="captchaHidden" id="captchaHidden"
                      value=<% out.println("\"" + URLEncoder.encode(encryptedCaptcha, "UTF-8") + "\"");%> />
                      </div> 

                      
               <i class="icon-edit"></i><p> COLOSSIANS 3:10 "Let the word of christ dwell in you richly in all
               wisdom: teaching and admonishing one another in psalms and hymns and spiritual songs, singing
               with grace in your heart to the lord:</P> 

                   </div><!--/span-->

               
                    <div class="form-actions">
                        <button type="submit" name="Send" value="Send"   class="btn btn-primary">Submit</button>
                    </div>
                          
              


                   </fieldset>
                   </form>

                  








    
             </div>
         
    </div>
        <div class="cleaner"></div>
    </div> <!-- end of main -->
    
   <jsp:include page="footer.jsp" />

   

</div>














