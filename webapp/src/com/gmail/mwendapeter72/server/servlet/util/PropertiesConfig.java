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
package com.gmail.mwendapeter72.server.servlet.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class PropertiesConfig extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8894737966457928235L;

	private final Logger logger = Logger.getLogger(this.getClass());
	
	private static String configFile = "";
	
	// Values in config file to be retained in a HashMap
	private static final HashMap<String,String> configHash = new HashMap<>(); 
	
	/**
	 * @param config
	 * @throws ServletException
	 * @see javax.servlet.Servlet#init(ServletConfig)
	 */
        @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		configFile = getServletContext().getRealPath("/") + getInitParameter("config-file");
		initConfigHash();
		
	}
        

	/**
      * @param request 
      * @param response 
      * @throws ServletException 
      * @throws IOException 
      * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	
	/**  
	 * @param configAttribute
	 * @return 		the String value of the attribute we seek
	 */
	public static String getConfigValue(String configAttribute) {
		return configHash.get(configAttribute);
	}
	
	
	/**
	 * Populate the internal HashMap which will hold configuration keys and values
	 */
	private void initConfigHash() {
		PropertiesConfiguration config;		
		String key;
		
		try {
			config = new PropertiesConfiguration();
			config.setListDelimiter('|');	// our array delimiter
			config.setFileName(configFile); 
			config.load();
			
			Iterator<String> keys = config.getKeys();
			
			while(keys.hasNext()) {
				key = keys.next();
				configHash.put(key, (String)config.getProperty(key));
			}
			
		} catch (ConfigurationException e) {
			logger.error("ConfigurationException when trying to initialize configuration HashMap");
			logger.error(ExceptionUtils.getStackTrace(e));	
			System.out.println(ExceptionUtils.getStackTrace(e));
		} 
	}
}
