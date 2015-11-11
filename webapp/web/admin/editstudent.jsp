
<%@page import="com.gmail.mwendapeter72.server.session.admin.SessionConstants2"%>
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

    String username = (String) session.getAttribute(SessionConstants2.ADMIN_SESSION_KEY);
    if (StringUtils.isEmpty(username)) {
        response.sendRedirect("index.jsp");
    }

     session.setMaxInactiveInterval(SessionConstants.SESSION_TIMEOUT);
     response.setHeader("Refresh", SessionConstants2.SESSION_TIMEOUT + "; url=/ChristianUnion/admin");



%>





<style type="text/css">
   input{
    height: 26px !important;
   }
   
 </style>

<div id="tooplate_wrapper">

  <jsp:include page="header.jsp" />
    
 <div id="container" class="clear"> 

                 

 <div class="box-content">



            <form class="form-horizontal" action="../editStudent" method="POST"  >
                <fieldset>

                    <div class="control-group">
                        <label class="control-label" for="admno">Admission Number</label>
                        <div class="controls">
                            <input class="input-xlarge"   name="admno" type="text" value="<%=request.getParameter("admno")%>">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="firstname">Firstname</label>
                        <div class="controls">
                            <input class="input-xlarge"   name="firstname" type="text" value="<%=request.getParameter("firstname")%>">
                        </div>
                    </div>
                        
                    <div class="control-group">
                        <label class="control-label" for="surname">Surname</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="surname" type="text" value="<%=request.getParameter("surname")%>">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="lastname">Lastname</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="lastname" type="text" value="<%=request.getParameter("lastname")%>">
                        </div>
                    </div>

                     <div class="control-group">
                        <label class="control-label" for="email">Email</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="email" type="text" value="<%=request.getParameter("email")%>">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="mobile">Mobile Number</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="mobile" type="text" value="<%=request.getParameter("mobile")%>">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="guardiancontact">Guardian Contact</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="guardiancontact" type="text" value="<%=request.getParameter("guardiancontact")%>">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="dob">Year of Birth</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="dob" type="text" value="<%=request.getParameter("dob")%>">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="gender">Gender</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="gender" type="text" value="<%=request.getParameter("gender")%>">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="program">Program/Major</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="program" type="text" value="<%=request.getParameter("program")%>">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="academicyear">Academic Year</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="academicyear" type="text" value="<%=request.getParameter("academicyear")%>">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="yearofstudy">Year of Study</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="yearofstudy" type="text" value="<%=request.getParameter("yearofstudy")%>">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="hometown">Home Town</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="hometown" type="text" value="<%=request.getParameter("hometown")%>">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="county">County</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="county" type="text" value="<%=request.getParameter("county")%>">
                        </div>
                    </div>


                    <div class="control-group">
                        <label class="control-label" for="ischristian">Is a Christian?</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="ischristian" type="text" value="<%=request.getParameter("ischristian")%>">
                        </div>
                    </div>


                    <div class="control-group">
                        <label class="control-label" for="duration">For How Long?</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="duration" type="text" value="<%=request.getParameter("duration")%>">
                        </div>
                    </div>


                    <div class="control-group">
                        <label class="control-label" for="hasministry">Has Served in Ministry Before?</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="hasministry" type="text" value="<%=request.getParameter("hasministry")%>">
                        </div>
                    </div>


                    <div class="control-group">
                        <label class="control-label" for="ministryname">Which Ministry</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="ministryname" type="text" value="<%=request.getParameter("ministryname")%>">
                        </div>
                    </div>


                    <div class="control-group">
                        <label class="control-label" for="desiredministry">Desired Ministry</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="desiredministry" type="text" value="<%=request.getParameter("desiredministry")%>">
                        </div>
                    </div>


                    <div class="control-group">
                        <label class="control-label" for="vision">Ministry Vision</label>
                        <div class="controls">
                            <input class="input-xlarge focused"  name="vision" type="text" value="<%=request.getParameter("vision")%>">
                        </div>
                    </div>
                    
                    

                   
                     <div class="form-actions">
                        <input type="hidden" name="uuid" value="<%=request.getParameter("uuid")%>">
                        <button type="submit" class="btn btn-primary">Save</button>
                     <!--   <a href="/admin/home.jsp"><button class="btn">Cancel</button></a> -->
                    </div>

                </fieldset>
            </form>
             

           </div>





                 <br> <br> <br> <br> <br> <br>
                 
                 
   <div id="tooplate_main_top"></div>        
    <div id="tooplate_main">
        </div>

    
        
        <div class="cleaner"></div>
    </div> 
  <jsp:include page="footer.jsp" />

        
</div> <!-- end of wrapper -->



