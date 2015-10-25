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
package com.gmail.mwendapeter72.server.servlet.init;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class Log4jInit extends HttpServlet{

	 private static final long serialVersionUID = 1L;
	    private final Logger logger = Logger.getLogger(this.getClass());
	    
	    
	    /**
	     * @param config
	     * @throws ServletException
	     */
	    public void init(ServletConfig config) throws ServletException {
	    	 super.init(config);

	        initConfig();
	        logger.info("Have initialized log4j");
	    }

	    
	    /**
		 * 
		 * @param request
	      * @param response
	      * @throws ServletException
	      * @throws IOException  
		 */	
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	initConfig();
	    	
	    	PrintWriter out = response.getWriter();
	    	out.println("Have reloaded log4j settings.");
	    	out.close();
	    }
	    
	    
	    /**
		 * 
		 * @param request
		 * @param response
	      * @throws ServletException
	      * @throws IOException  
		 */	
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	doPost(request, response);
	    }
	    
	    
	    /**
	     * 
	     */
	    private void initConfig() {
	    	String prefix = getServletContext().getRealPath("/");
	        String file = getServletConfig().getInitParameter("log4j-init-file");

	        // if the log4j-init-file is not set, then no point in trying
	        if (file != null) {
	            PropertyConfigurator.configure(prefix + file);
	        }
	    }
}
