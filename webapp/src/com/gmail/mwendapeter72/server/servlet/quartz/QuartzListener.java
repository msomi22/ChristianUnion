/**
*QuartzListener.java
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
package com.gmail.mwendapeter72.server.servlet.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.gmail.mwendapeter72.server.test.quartz.QuartzJob;

public class QuartzListener extends HttpServlet implements ServletContextListener {

/**
 * initialize the quarts scheduling file
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
	private static final long serialVersionUID = -594007090895227780L;
		Scheduler scheduler = null;
		
        
        

        /**
         * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
         */
        public void contextInitialized(ServletContextEvent servletContext) {
                  
        	  try {
                        // Setup the Job class and the Job group
                        JobDetail job = newJob(QuartzJob.class).withIdentity(
                                        "CronQuartzJob", "Group").build();

                        // Create a Trigger that fires every 5 minutes 
                        Trigger trigger = newTrigger()
                        .withIdentity("TriggerName", "Group")
                        .startNow()
                        .withSchedule(CronScheduleBuilder.cronSchedule("0 0/5 * * * ?"))
                        .build(); 

                        // Setup the Job and Trigger with Scheduler & schedule jobs
                        scheduler = new StdSchedulerFactory().getScheduler();
                        scheduler.start();
                        scheduler.scheduleJob(job, trigger);
                       
                     }
                 catch (SchedulerException e) {
                   e.printStackTrace();
                }
        }

        /**
         * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
         */
        public void contextDestroyed(ServletContextEvent servletContext) {
                try 
                {
                    scheduler.shutdown();
                  } 
                  catch (SchedulerException e) 
                 {
                     e.printStackTrace();
                }
           }
}