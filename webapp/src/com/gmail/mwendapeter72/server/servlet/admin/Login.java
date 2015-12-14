/**
*Login.java
*
*Maasai Mara University Christian Union Online Management System.
*Copyright 2015 Fastech Solutions Ltd
*Licensed under the Open Software License, Version 3.0 
*The codes herein AND/OR this file CAN BE copied without the author's approval for learning purposes or for use in one's own project
*if need be, feel free to contact the author
*Contacts, Mobile: +254718953974
*         email: mwendapeter72@gmail.com
*         email: petermwenda83@yahoo.com 
**/
package com.gmail.mwendapeter72.server.servlet.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.jasypt.util.text.BasicTextEncryptor;

import com.gmail.mwendapeter72.server.servlet.util.PropertiesConfig;
import com.gmail.mwendapeter72.server.session.admin.SessionConstants;


/**
 * used for admin login
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class Login extends HttpServlet{
	
	 /**
	 * 
	 */
	
	private Logger logger;
	final String ACCOUNT_SIGN_IN_WRONG_CAPTCHA = "The characters you entered did not "
	            + "match those provided in the image. Please try again.";
	
	private String hiddenCaptchaStr = "", username, password;
   
	private BasicTextEncryptor textEncryptor;

		 
	/**
     *
     * @param config
     * @throws ServletException
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(PropertiesConfig.getConfigValue("ENCRYPT_PASSWORD"));
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
         

        username = StringUtils.trimToEmpty(request.getParameter("Username"));
        password = StringUtils.trimToEmpty(request.getParameter("Password"));
        
         
         hiddenCaptchaStr = request.getParameter("captchaHidden");
         String captchaAnswer = request.getParameter("captchaAnswer").trim();
         

        // System.out.println(username);
        // System.out.println(password);
       
         if (!validateCaptcha(hiddenCaptchaStr, captchaAnswer)) {
             session.setAttribute(SessionConstants.ADMIN_SIGN_IN_ERROR_KEY, ACCOUNT_SIGN_IN_WRONG_CAPTCHA);
             response.sendRedirect("admin/index.jsp");
        
           } else if (!StringUtils.equals(username, PropertiesConfig.getConfigValue("ADMIN_USERNAME"))) {
            session.setAttribute(SessionConstants.ADMIN_SIGN_IN_ERROR_KEY, SessionConstants.ADMIN_SIGN_IN_ERROR_KEY);
            response.sendRedirect("admin/index.jsp");
            
         }else if (!StringUtils.equals(password, PropertiesConfig.getConfigValue("ADMIN_PASSWORD"))) {
             session.setAttribute(SessionConstants.ADMIN_SIGN_IN_ERROR_KEY, SessionConstants.ADMIN_SIGN_IN_ERROR_VALUE);
             response.sendRedirect("admin/index.jsp");
             
         }
         else {
        	
                 session.setAttribute(SessionConstants.ADMIN_SESSION_KEY, PropertiesConfig.getConfigValue("ADMIN_USERNAME"));      		 
        		 session.setAttribute(SessionConstants.ADMIN_LOGIN_TIME_KEY, String.valueOf(new Date().getTime()));
        		 
                 response.sendRedirect("admin/home.jsp");
                 
            
         }
         
	}

    
    

/**
 * @param encodedSystemCaptcha
 * @param userCaptcha
 * @return
 */
private boolean validateCaptcha(String encodedSystemCaptcha, String userCaptcha) {
    boolean valid = false;
    String decodedHiddenCaptcha = "";

    try {
        decodedHiddenCaptcha = textEncryptor.decrypt(URLDecoder.decode(encodedSystemCaptcha, "UTF-8"));

    } catch (UnsupportedEncodingException e) {
        logger.error("UnsupportedEncodingException while trying to validate captcha.");
        logger.error(ExceptionUtils.getStackTrace(e));
    }

    if (StringUtils.equalsIgnoreCase(decodedHiddenCaptcha, userCaptcha)) {
        valid = true;
    }

    return valid;
}



/**
 * Handles the HTTP <code>POST</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
}
    private static final long serialVersionUID = 8039574614217263114L;
}
