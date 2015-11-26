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

<%@page import="com.gmail.mwendapeter72.server.session.admin.SessionConstants2"%>
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
  String username = (String) session.getAttribute("username");
    if (username != null) {
        response.sendRedirect("index.jsp");
    }


    
     //response.setIntHeader("Refresh",200);
       String ENCRYPT_PASSWORD = "Vuwachip2";
       BasicTextEncryptor textEncryptor = new BasicTextEncryptor();    
       textEncryptor.setPassword(ENCRYPT_PASSWORD);


      String captcha = RandomStringUtils.randomAlphabetic(4); 
      String encryptedCaptcha = textEncryptor.encrypt(captcha.toLowerCase());
%>




<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    
    
    <link rel="stylesheet" href="css/reset.css">


<!DOCTYPE html>
<html>
<head>
    <title>login</title>

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
                                     loginError = (String) session.getAttribute(SessionConstants2.ADMIN_SIGN_IN_ERROR_KEY);
                                    

                                if(session != null) {
                                    loginError = (String) session.getAttribute(SessionConstants2.ADMIN_SIGN_IN_ERROR_KEY);                                  
                                }                        

                                if (StringUtils.isNotEmpty(loginError)) {
                                    out.println("<p style='color:red;'>");                 
                                    out.println("error: " + loginError);
                                    out.println("</p>");                                 
                                    session.setAttribute(SessionConstants2.ADMIN_SIGN_IN_ERROR_KEY, null);
                                  } 
                                   
                            %>







    <form id="login_form" action="../adminLogin" method="POST">

    <div class="field_container">
      <input type="text" placeholder="Username" name="Username">
    </div>
    
    <div class="field_container">
      <input type="Password" placeholder="Password" name="Password">
    </div>
                    
                     
                      <%
                        String fontImageUrl = "../fontImageGenerator?text=" + URLEncoder.encode(encryptedCaptcha, "UTF-8");
                        %> 
                        <div class="field_container">
                        <div class='wrapper'>
                            <label for='captchaAnswer'>Are You a robot?</label>
                            <div id="spam-check">
                                <span id="captchaGuidelines">Type the characters you see in the image below. (<em>Letters are case-sensitive</em>)</span><br>
                                <img id="captcha" src=<% out.println("\"" + fontImageUrl + "\"");%> width="68" height="29" />
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
