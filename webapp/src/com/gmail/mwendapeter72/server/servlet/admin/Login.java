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
 * 
 */
package com.gmail.mwendapeter72.server.servlet.admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.servlet.util.PropertiesConfig;
import com.gmail.mwendapeter72.server.session.admin.SessionConstants2;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class Login extends HttpServlet{
	
	 private Logger logger;

	/**
     *
     * @param config
     * @throws ServletException
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        logger = Logger.getLogger(this.getClass());

    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession(true);
         

         String username = StringUtils.trimToEmpty(request.getParameter("Username"));
         String password = StringUtils.trimToEmpty(request.getParameter("Password"));
         
         
         //System.out.println(username);
         //System.out.println(password);
        
         if (!StringUtils.equals(password, PropertiesConfig.getConfigValue("ADMIN_PASSWORD"))) {
             session.setAttribute(SessionConstants2.ADMIN_SIGN_IN_ERROR_KEY, SessionConstants2.ADMIN_SIGN_IN_ERROR_VALUE);
             response.sendRedirect("admin/index.jsp");

             
        	
         } else if (!StringUtils.equals(username, PropertiesConfig.getConfigValue("ADMIN_USERNAME"))) {
            session.setAttribute(SessionConstants2.ADMIN_SIGN_IN_ERROR_KEY, SessionConstants2.ADMIN_SIGN_IN_ERROR_KEY);
            response.sendRedirect("admin/index.jsp");
         
         } else {
             session.setAttribute(SessionConstants2.ADMIN_SESSION_KEY, "admin");
             session.setAttribute(SessionConstants2.ADMIN_LOGIN_TIME_KEY, new Date());
             
            response.sendRedirect("admin/home.jsp");
         }
	}

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
