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
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
	private static final long serialVersionUID = -594007090895227780L;
		Scheduler scheduler = null;
		
        
        

        /**
         * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
         */
        public void contextInitialized(ServletContextEvent servletContext) {

               System.out.println("Context Initialized ::::Quartz By PeterMwenda");
                
                try {
                        // Setup the Job class and the Job group
                        JobDetail job = newJob(QuartzJob.class).withIdentity(
                                        "CronQuartzJob", "Group").build();

                        // Create a Trigger that fires every .... 
                        //"20 20 23 ? * *"
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
                System.out.println("Context Destroyed ::::Quartz By PeterMwenda");
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