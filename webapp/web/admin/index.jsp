<!DOCTYPE html>

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

<%@page import="com.gmail.mwendapeter72.server.session.admin.SessionConstants"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="org.apache.commons.lang3.RandomStringUtils"%>
<%@page import="org.jasypt.util.text.BasicTextEncryptor"%>
<%@ page import="com.gmail.mwendapeter72.server.servlet.util.PropertiesConfig" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Calendar" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  String username = (String) session.getAttribute("username");
    if (username != null) {
        response.sendRedirect("index.jsp");
    }


     

    
     //response.setIntHeader("Refresh",200);
      
       BasicTextEncryptor textEncryptor = new BasicTextEncryptor();   
       textEncryptor.setPassword(PropertiesConfig.getConfigValue("ENCRYPT_PASSWORD")); 
      


      String captcha = RandomStringUtils.randomAlphabetic(4); 
      String encryptedCaptcha = textEncryptor.encrypt(captcha);
%>




<html >
  <head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    
    
 <link rel="stylesheet" href="css/reset.css">
 <script src="js/prefixfree.min.js"></script>
 <link href="../css/adminlogin.css" rel="stylesheet"/>
 <link href="../css/bootstrap/bootstrap-cerulean.css" rel="stylesheet">
 <link href="../css/bootstrap/bootstrap-responsive.css" rel="stylesheet">
 </head>
 <body>

 
      <div id="login">           
                             



   

                             <%

                                String loginError = "";                      
                                session = request.getSession(false);
                                     loginError = (String) session.getAttribute(SessionConstants.ADMIN_SIGN_IN_ERROR_KEY);
                                    

                                if(session != null) {
                                    loginError = (String) session.getAttribute(SessionConstants.ADMIN_SIGN_IN_ERROR_KEY);                                  
                                }                        

                                if (StringUtils.isNotEmpty(loginError)) {
                                    out.println("<p style='color:red;'>");                 
                                    out.println("Oh my God!: " + loginError);
                                    out.println("</p>");                                 
                                    session.setAttribute(SessionConstants.ADMIN_SIGN_IN_ERROR_KEY, null);
                                  } 
                                   
                            %>







    <form id="login_form" action="../adminLogin" method="POST" >

    <div class="field_container">
     Username: <input type="text" placeholder="Username" name="Username">
    </div>
    
    <div class="field_container">
     Password: <input type="Password" placeholder="Password" name="Password">
    </div>
                    
                     
                      <%
                        String fontImageUrl = "../fontImageGenerator?text=" + URLEncoder.encode(encryptedCaptcha, "UTF-8");
                        %> 
                        <div class="field_container">
                        <div class='wrapper'>
                            <label for='captchaAnswer'>Are You a robot?</label>
                            <div id="spam-check">
                                <span id="captchaGuidelines">Type the characters you see in the image below. (<em>Letters are not case-sensitive</em>)</span><br>
                                <img id="captcha" src=<% out.println("\"" + fontImageUrl + "\"");%> width="80" height="40" />
                                <input type="text" name="captchaAnswer" id="captchaAnswer" size="5" class="input_normal" />
                                <input type="hidden" name="captchaHidden" id="captchaHidden"
                                       value=<% out.println("\"" + URLEncoder.encode(encryptedCaptcha, "UTF-8") + "\"");%> />
                            </div>
                        </div>
                      </div>


      <button id="sign_in_button">
        <span class="button_text">Sign In</span>
      </button>
    
   
    </form>



   
  </div>  
   
    
  
  </body>
</html>
