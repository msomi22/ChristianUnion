/**
*TestEmailUtil.java
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

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


/**
 * test the EmailUtil
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class TestEmailUtil {
	
	final String[] EMAILS = {"mwendapeter72@gmail.com","mwendapeter72@gmail.com"};
	final String[] EMAILS2 = {"mwendapeter72gmail.com","mwendapeter72gmail.com"};
	final String[] EMAILS3 = {"hfgsghjfgsghfgghjfg","hgfsfghjufgdfghjk"};
	
	final String EMAIL ="mwendapeter72@gmail.com";
	final String EMAIL2 ="mwendapeter72gmail.com";
	final String EMAIL3 ="hhggggujjjiiuugyghghghj";
	
	
	
	final String FROM ="mwendapeter72@gmail.com";
	
	final String TO = "mwendapeter72@gmail.com,mwendapeter72@gmail.com,mwendapeter72@gmail.com";
	final String[] recipientList = TO.split(",");  
	
	final String TO2 ="mwendapeter72@gmail.com";
	
	final String  CC ="mwendapeter72@gmail.com,mwendapeter72@gmail.com";
	final String[] recCCList = CC.split(","); 
	
	final String CC2 ="mwendapeter72@gmail.com";
	
	final String BCC = "mwendapeter72@gmail.com,mwendapeter72@gmail.com";
	final String[] recBCCList = BCC.split(","); 
	
	
	final String BCC2 = "mwendapeter72@gmail.com";
	
	final String SUBJECT ="This is a test message";
	final String BODY ="hello...! This is a test message - from mwendapeter72@gmail.com";
	
	final String OUT_E_SERVER ="smtp.googlemail.com";
	final int OUT_E_PORT = 465;
		

	/**
	 * Test method for {@link com.gmail.mwendapeter72.util.EmailUtil#EmailUtil(java.lang.String, java.lang.String[], java.lang.String[], java.lang.String[], java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testEmailUtilStringStringArrayStringArrayStringArrayStringStringStringIntStringString() {
		EmailUtil util = new EmailUtil(FROM, recipientList, recCCList, recBCCList, SUBJECT, BODY, OUT_E_SERVER, OUT_E_PORT,
				"mwendapeter72@gmail.com", "peter*#mwenda");
		util.run();
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.util.EmailUtil#EmailUtil(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)}.
	 */
	//@Ignore
	@Test
	public void testEmailUtilStringStringStringStringStringIntStringString() {
		EmailUtil util = new EmailUtil(FROM, TO2, SUBJECT, BODY, OUT_E_SERVER, OUT_E_PORT,
				"smtpUsername", "smtpPasswd");
		util.run();
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.util.EmailUtil#validateEmail(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testValidateEmail() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.util.EmailUtil#validateEmails(java.lang.String[])}.
	 */
	@Ignore
	@Test
	public void testValidateEmails() {
		fail("Not yet implemented");
	}

}
