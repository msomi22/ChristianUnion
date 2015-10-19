/**
 * 
 */
package com.gmail.mwendapeter72.server.servlet.util;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.persistence.DButils;


/**
 * Utility dealing with database connection pooling.
 * <p>
 *  
 *  @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 */
public class DbPoolUtil extends HttpServlet {

	
	private static DButils dButils; 
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	/**
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        dButils = new DButils();
    }
    
    
    /**
     * @return the database credentials class
     */
    public static DButils getDBCredentials() {
    	return dButils;
    }
    
    
    /**
     * 
     */
    @Override
    public void destroy() {
		logger.info("Now shutting down database pools.");
    	
		dButils.closeConnections();		
	} 
    
    
    private static final long serialVersionUID = -7899535368789138778L;
}
