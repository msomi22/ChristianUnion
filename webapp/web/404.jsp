<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--
    This page is displayed when there is a 404 server error (page not found).
--%>
<%
    String contextPath = getServletContext().getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>We're sorry,something went wrong (404)</title>
        <style type="text/css">
            body { background-color: #efefef; color: #333; font-family: Georgia,Palatino,'Book Antiqua',serif;padding:0;margin:0;text-align:center; }
            p {font-style:italic;}
            div.dialog {
                width: 490px;
                margin: 4em auto 0 auto;
            }
            img { border:none; }
        </style>
    </head>

    <body>
      <div class="dialog">
       
        <p>
           Looks like something went wrong.<br /><br />
            We can't find the page you are looking for.<br /><br />
            <!-- go back <a href="<%= contextPath %>/admin/home.jsp">Home Page</a>. -->
        </p>
      </div>
    </body>
    
</html>