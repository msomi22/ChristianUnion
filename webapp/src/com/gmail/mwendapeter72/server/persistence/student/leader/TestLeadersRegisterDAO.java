/**
*TestLeadersRegisterDAO.java
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
package com.gmail.mwendapeter72.server.persistence.student.leader;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister;

/**
 * persistence test for {@link LeadersRegisterDAO}
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class TestLeadersRegisterDAO {
	
	final String databaseName = "cudb";
	final String Host = "localhost";
	final String databaseUsername = "cu";
	final String databasePassword = "Cu12c";
	final int databasePort = 5432;
	
	private String UUID = "448FC261-887A-47AF-948E-389EF282F62C",
			       UUID_NEW = "C2EA40B2-0433-4C08-8BED-1F4CD4762444";
	
	private String STUDENT_UUID ="750943EA-314D-473A-8CF1-8C4F9C271A04",
			       STUDENT_UUID_NEW ="193596F5-DC88-4D5A-8723-467F300E3F46";
	
	private String STATUS_UUID_INACTIVE ="6C03705B-E05E-420B-B5B8-C7EE36643E60",
			       STATUS_UUID_ACTIVE ="85C6F08E-902C-46C2-8746-8C50E7D11E2E";
	
	private String  CATEGORY ="Executive",
			        CATEGORY_NEW ="New Cat",
			        CATEGORY_UPDATE ="Update Cat";
	
	private String  POSITION ="Pastor(Chairperson)",
	                POSITION_NEW ="New Chair",
			        POSITION_UPDATE ="Update Chair";
	
	private String  SUB_POSITION ="Pastor(Chairperson)",
			        SUB_POSITION_NEW ="New Chair",
			        SUB_POSITION_UPDATE ="Update Chair";
	
	 private Date START_DATE = new Date(new Long("141941056800") );
	 
	 private Date END_DATE = new Date(new Long("141941055600") );
	
	
	
	
	
	private LeadersRegisterDAO store;

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO#getPosition(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetLeader() {
		store = new LeadersRegisterDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		LeadersRegister l = new LeadersRegister();
		l = store.getLeader(STUDENT_UUID);
		assertEquals(l.getUuid(),UUID);
		assertEquals(l.getStudentUuid(),STUDENT_UUID);
		assertEquals(l.getStatusUuid(),STATUS_UUID_ACTIVE);
		assertEquals(l.getCategory(),CATEGORY);
		assertEquals(l.getPosition(),POSITION);
		assertEquals(l.getSubPosition(),SUB_POSITION);
	}
	
	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO#getPosition(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetLeader2() {
		store = new LeadersRegisterDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		LeadersRegister l = new LeadersRegister();
		l = store.getLeader(STUDENT_UUID, STATUS_UUID_ACTIVE);
		assertEquals(l.getUuid(),UUID);
		assertEquals(l.getStudentUuid(),STUDENT_UUID);
		assertEquals(l.getStatusUuid(),STATUS_UUID_ACTIVE);
		assertEquals(l.getCategory(),CATEGORY);
		assertEquals(l.getPosition(),POSITION);
		assertEquals(l.getSubPosition(),SUB_POSITION);
	}
	
	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO#getPosition(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testGetLeader3() {
		store = new LeadersRegisterDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		LeadersRegister Leader = new LeadersRegister();
		Leader.setStudentUuid(STUDENT_UUID);
		Leader.setStatusUuid(STATUS_UUID_ACTIVE);
		Leader.setCategory(CATEGORY);
		Leader.setPosition(POSITION);
		Leader.setSubPosition(SUB_POSITION);
		Leader = store.getLeader(Leader);
		assertEquals(Leader.getUuid(),UUID);
		assertEquals(Leader.getStudentUuid(),STUDENT_UUID);
		assertEquals(Leader.getStatusUuid(),STATUS_UUID_ACTIVE);
		assertEquals(Leader.getCategory(),CATEGORY);
		assertEquals(Leader.getPosition(),POSITION);
		assertEquals(Leader.getSubPosition(),SUB_POSITION);
	}
	
	
	
		/**
		 * 
		 */
	  @Ignore
		@Test
		public void testHasExecutiveHead() {
			store = new LeadersRegisterDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
			assertTrue(store.HasLeader(STUDENT_UUID, STATUS_UUID_ACTIVE));
		} 

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO#putPosition(com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister)}.
	 */
	//@Ignore
	@Test
	public void testPutLeader() {
		store = new LeadersRegisterDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		LeadersRegister Leader = new LeadersRegister();
		//Leader.setUuid(UUID_NEW);STUDENT_UUID_NEW
		String uuid ="6568C61E-D190-473F-91D1-475874B6873F";
		Leader.setStudentUuid(uuid);   
		Leader.setStatusUuid(STATUS_UUID_ACTIVE);
		Leader.setCategory(CATEGORY_NEW);
		Leader.setPosition(POSITION_NEW);
		Leader.setSubPosition(SUB_POSITION_NEW);
		Leader.setStartDate(START_DATE);
		assertTrue(store.putLeader(Leader)); 
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO#updatePosition(com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister)}.
	 */
	@Ignore
	@Test
	public void testUpdateLeader() {
		store = new LeadersRegisterDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		LeadersRegister Leader = new LeadersRegister();
		Leader.setStudentUuid(STUDENT_UUID_NEW);
		Leader.setStatusUuid(STATUS_UUID_INACTIVE);
		Leader.setCategory(CATEGORY_UPDATE);
		Leader.setPosition(POSITION_UPDATE);
		Leader.setSubPosition(SUB_POSITION_UPDATE);
		Leader.setStartDate(START_DATE);
		Leader.setEndDate(END_DATE);
		assertTrue(store.updateLeader(Leader));  
	}
	
	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO#updatePosition(com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister)}.
	 */
	@Ignore
	@Test
	public void testTerminateLeader() {
		store = new LeadersRegisterDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		LeadersRegister l = new LeadersRegister();
		l.setStudentUuid(STUDENT_UUID_NEW);
		l.setStatusUuid(STATUS_UUID_INACTIVE);
		l.setEndDate(END_DATE);
		assertTrue(store.TerminateLeader(l));    
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO#deletePosition(com.gmail.mwendapeter72.server.bean.student.leader.LeadersRegister)}.
	 */
	@Ignore
	@Test
	public void testDeleteLeader() {
		store = new LeadersRegisterDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		LeadersRegister l = new LeadersRegister();
		l.setStudentUuid(STUDENT_UUID);
		assertTrue(store.deleteLeader(l));
	}

	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO#getAllPositions(int, int)}.
	 */
	@Ignore
	@Test
	public void testGetAllLeaders() {
		store = new LeadersRegisterDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		List<LeadersRegister> leadersRegister = store.getAllLeaders(0, 15);
		 //assertEquals(studentList.size() , 15); 
		 for(LeadersRegister l : leadersRegister){
			System.out.println(l);
		}
	}
	
	
	
	
	/**
	 * Test method for {@link com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO#getAllPositions(int, int)}.
	 */
	@Ignore
	@Test
	public void testGetLeaderList() {
		store = new LeadersRegisterDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
		List<LeadersRegister> leadersRegister = store.getLeadersList();
		 //assertEquals(studentList.size() , 15); 
		 for(LeadersRegister l : leadersRegister){
			System.out.println(l);
		}
	}

}
