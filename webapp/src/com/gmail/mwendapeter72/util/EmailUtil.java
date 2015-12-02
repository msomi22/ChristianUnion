/**
*EmailUtil.java
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
package com.gmail.mwendapeter72.util;

import java.util.Arrays;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.log4j.Logger;




/**
 * utility that enables sending of email 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class EmailUtil  extends Thread{
	
	private EmailValidator emailValidator = EmailValidator.getInstance();   
    private Logger logger = Logger.getLogger(this.getClass());
	
    private String from;
    private String[] to, cc, bcc; 
	private String subject, body, outgoingEmailServer;
	private int outgoingEmailPort;
    private String outgoingUsername, outgoingPassword;
	 
	 

    /**
     * Disable the default constructor
     */
    private EmailUtil() {}
    
    
    /**
     * @param from
     * @param to
     * @param cc
     * @param bcc
     * @param subject
     * @param body
     * @param outgoingEmailServer
     * @param outgoingEmailPort
     * @param outgoingUsername 
     * @param outgoingPassword 
     */
    public EmailUtil(String from, String[] to, String[] cc, String[] bcc, 
			String subject, String body, String outgoingEmailServer, int outgoingEmailPort,
			String outgoingUsername, String outgoingPassword) {
    	
    	this.from = from;
    	this.to = to;
    	this.cc = cc;
    	this.bcc = bcc;
    	this.subject = subject;
    	this.body = body;
    	this.outgoingEmailServer = outgoingEmailServer;
    	this.outgoingEmailPort = outgoingEmailPort;
    	this.outgoingUsername = outgoingUsername;
    	this.outgoingPassword = outgoingPassword;
    }
    
    
    /**
     * @param from
     * @param to
     * @param subject
     * @param body
     * @param outgoingEmailServer
     * @param outgoingEmailPort
     * @param outgoingUsername 
     * @param outgoingPassword 
     */
    public EmailUtil(String from, String to, String subject, String body, 
    		String outgoingEmailServer, int outgoingEmailPort,
    		String outgoingUsername, String outgoingPassword) {
    	
    	this.from = from;
    	this.to = new String[] {to};
    	this.cc = new String[] {};
    	this.bcc = new String[] {};
    	this.subject = subject;
    	this.body = body;
    	this.outgoingEmailServer = outgoingEmailServer;
    	this.outgoingEmailPort = outgoingEmailPort;
    	this.outgoingUsername = outgoingUsername;
    	this.outgoingPassword = outgoingPassword;
    }
	
     
    /**
     * Validates an email address
     * 
     * @param email 
     * @return boolean indicating the validity of the email
     */      
    public boolean validateEmail(String email) {
       
		return  emailValidator.isValid(email);		
 
	}
    
    
    /**
     * Validates multiple emails at once
     * 
     * @param emailsToValidate 
     * @return boolean indicating whether or not all the emails are valid
     */
    public boolean validateEmails(String[] emailsToValidate) {
        
         for(String email : emailsToValidate) {
           if(!validateEmail(email)){
               return false;
           }
         }
 
		 return true;	
	}



	/**
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		SimpleEmail email;
		
		try {
			email = new SimpleEmail();
			email.setDebug(true); 
			email.setSSLCheckServerIdentity(true);
			email.setStartTLSRequired(true);
			email.setBounceAddress("mwendapeter72@gmail.com");
			email.setHostName(outgoingEmailServer);
			email.setSmtpPort(outgoingEmailPort); 
			email.setAuthenticator(new DefaultAuthenticator(outgoingUsername, outgoingPassword));
			email.setSSLOnConnect(true);
			
			email.setFrom(from);						
			email.addTo(to);
			
			
			if(cc.length > 0) {
				email.addCc(cc);
			}
			
			if(bcc.length > 0) {
				email.addBcc(bcc);
			}
						
			email.setSubject(subject);
			email.setMsg(body);
			
			
			if(validateEmails(to)) {
				email.send();
				
			} else {
				logger.error("Invalid destinations in " + toString());
			}
			
			
		} catch(EmailException e) {
			logger.error("EmailException when trying to send out a SimpleEmail: " + this.toString());
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e)); 
		}	
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailUtil [from=");
		builder.append(from);
		builder.append(", to=");
		builder.append(Arrays.toString(to));
		builder.append(", cc=");
		builder.append(Arrays.toString(cc));
		builder.append(", bcc=");
		builder.append(Arrays.toString(bcc));
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", body=");
		builder.append(body);
		builder.append(", outgoingEmailServer=");
		builder.append(outgoingEmailServer);
		builder.append(", outgoingEmailPort=");
		builder.append(outgoingEmailPort);
		builder.append("]");
		
		return builder.toString();
	}
	
	}