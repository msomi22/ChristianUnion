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
package com.gmail.mwendapeter72.server.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.servlet.util.PropertiesConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */

public class DButils {
	private Logger logger = Logger.getLogger(this.getClass());
    protected String databaseName;
    protected String Host;
    protected String databaseUsername;
    protected String databasePassword;
    protected int databasePort =5432,dbPoolSize=5;
    private Connection con;
    
    private HikariDataSource datasource;
    
	public DButils() {
		databaseName = PropertiesConfig.getConfigValue("DATABASE_NAME");
		Host= PropertiesConfig.getConfigValue("DATABASE_HOST");
		databaseUsername = PropertiesConfig.getConfigValue("DATABASE_USERNAME");
		databasePassword = PropertiesConfig.getConfigValue("DATABASE_PASSWORD");
		databasePort = Integer.parseInt(PropertiesConfig.getConfigValue("DATABASE_POOL_SIZE"));
		
		 initConnection();
	}
	
	/**
	 * @param databaseName
	 * @param Host
	 * @param databaseUsername
	 * @param databasePassword
	 * @param databasePort
	 */
	public DButils(String databaseName,String Host,String databaseUsername ,
			String databasePassword,int databasePort){
		this.databaseName = databaseName;
		this.Host = Host;
		this.databaseUsername = databaseUsername;
		this.databasePassword = databasePassword;
		this.databasePort = databasePort;
		
		 initConnection();
	}


	/**
	 * @return con
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException{
          Connection conn = null;
        
        try {
            conn = datasource.getConnection();

        } catch (SQLException e) {
            logger.error("SQLException when trying to get an SQL Connection.");
            logger.error(ExceptionUtils.getStackTrace(e));

            initConnection();
        }
        
        return conn;   
        
	}
	
	  public Connection getJdbcConnection() {
	      String dbURL;
	              
	       dbURL = "jdbc:postgresql://" + Host + ":" + databasePort + "/" + databaseName;
	      
	        // Loading underlying JDBC driver
	        try {
	            Class.forName("org.postgresql.Driver");
	            con = DriverManager.getConnection(dbURL, databaseUsername, databasePassword); //set up jdbc connection that doesn't use HikariCP

	        } catch (ClassNotFoundException e) {
	            logger.error("ClassNotFoundException when trying to get unpooled JDBC connection");
	            logger.error(ExceptionUtils.getStackTrace(e));
	            
	        } catch (SQLException ex) {
	                logger.error("SQLException when trying to get unpooled JDBC connection");
	            logger.error(ExceptionUtils.getStackTrace(ex));
	        }

	        return con;
	    } 
	    
	 /**
     *
     */
    public void closeConnections() {
        if (datasource != null) {
                datasource.shutdown();
        }
    }
	
	
	

    /**
     *
     */
    private void initConnection() {
                
        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(dbPoolSize);
        config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        config.addDataSourceProperty("serverName", Host);
        config.addDataSourceProperty("databaseName", databaseName);
        config.addDataSourceProperty("user", databaseUsername);
        config.addDataSourceProperty("password", databasePassword);
        
        datasource = new HikariDataSource(config);       
    }
	

}