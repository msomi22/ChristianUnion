/**
*TestStatusDAO.java
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
package com.gmail.mwendapeter72.server.servlet.util;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.persistence.DBCredentials;


/**
 * Utility dealing with database connection pooling.
 * <p>
 *  
 *  @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 */
public class DbPoolUtil extends HttpServlet {

	
	private static DBCredentials dBCredentials; 
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	/**
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        dBCredentials = new DBCredentials();
    }
    
    
    /**
     * @return the database credentials class
     */
    public static DBCredentials getDBCredentials() {
    	return dBCredentials;
    }
    
    
    /**
     * 
     */
    @Override
    public void destroy() {
		logger.info("Now shutting down database pools.");
    	
		dBCredentials.closeConnections();		
	} 
    
    
    private static final long serialVersionUID = -7899535368789138778L;
}
