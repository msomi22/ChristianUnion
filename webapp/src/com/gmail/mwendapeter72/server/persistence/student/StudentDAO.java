/**
 *StudentDAO.java
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
package com.gmail.mwendapeter72.server.persistence.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.persistence.DBConnectDAO;

/**
 *  Persistence implementation for {@link Student}s
 *  
 *  Copyright (c) FasTech Solutions Ltd., Dec 02, 2015
 * 
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author <a href="mailto:joramndungu10@gmail.com">Joram Muriithi</a>
 *
 */
public class StudentDAO extends DBConnectDAO  implements CuStudentDAO {

	private static StudentDAO studentDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();

	/**
	 * @return {@link StudentDAO}
	 */
	public static StudentDAO getInstance(){

		if(studentDAO == null){
			studentDAO = new StudentDAO();		
		}
		return studentDAO;
	}

	/**
	 * 
	 */
	public StudentDAO() { 
		super();
		StudentOtherDetailDAO.getInstance();	
	}


	/**
	 * @param databaseName the  databaseName 
	 * @param Host the  Host
	 * @param databaseUsername the databaseUsername
	 * @param databasePassword the databasePassword
	 * @param databasePort the databasePort
	 */
	public StudentDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);
		new StudentOtherDetailDAO(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudent(java.lang.String)
	 */
	public Student getStudent(String AdmNo) {
		Student student = null;
		ResultSet rset = null;
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student WHERE AdmNo = ?;");       

				){

			pstmt.setString(1, AdmNo); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				student  = beanProcessor.toBean(rset,Student.class);
			}



		}catch(SQLException e){
			logger.error("SQL Exception when getting Student  with AdmNo: " + AdmNo);
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
		}

		return student; 
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudent(java.lang.String, java.lang.String)
	 */
	public Student getStudent(String Uuid, String Gender) {
		Student student = null;
		ResultSet rset = null;
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student WHERE Uuid = ? AND Gender = ?;");       

				){

			pstmt.setString(1, Uuid); 
			pstmt.setString(2, Gender); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				student  = beanProcessor.toBean(rset,Student.class);
			}



		}catch(SQLException e){
			logger.error("SQL Exception when getting Student  with Uuid: " + Uuid);
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
		}

		return student; 
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudentAdmNo(java.lang.String)
	 */
	public List<Student> getStudentAdmNo( String admno) {
		List<Student> list = new ArrayList<>();

		try (
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student WHERE admno ILIKE ? ORDER BY admno ASC LIMIT ? OFFSET ?;;");    		   
				) {

			pstmt.setString(1, "%" + admno.toUpperCase() + "%");
			pstmt.setInt(2, 10);
			pstmt.setInt(3, 0);
			try( ResultSet rset = pstmt.executeQuery();){

				list = beanProcessor.toBeanList(rset, Student.class);
			}
		} catch (SQLException e) {
			logger.error("SQLException when getting Student of admno '" + admno +  "'");
			logger.error(ExceptionUtils.getStackTrace(e));
		}

		Collections.sort(list);
		return list;
	}



	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudentByEmail(java.lang.String)
	 */
	public Student getStudentByEmail(String Email) {
		Student student = null;
		ResultSet rset = null;
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student WHERE Email = ?;");       

				){

			pstmt.setString(1, Email); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				student  = beanProcessor.toBean(rset,Student.class);
			}



		}catch(SQLException e){
			logger.error("SQL Exception when getting Student  with Email: " + Email);
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
		}

		return student; 
	}





	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudentByUuid(java.lang.String)
	 */
	public Student getStudentByUuid(String Uuid) {
		Student student = null;
		ResultSet rset = null;
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student WHERE Uuid = ?;");       

				){

			pstmt.setString(1, Uuid); 
			rset = pstmt.executeQuery();
			while(rset.next()){

				student  = beanProcessor.toBean(rset,Student.class);
			}



		}catch(SQLException e){
			logger.error("SQL Exception when getting Student  with Uuid: " + Uuid);
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));

		}
		//System.out.println(student);
		return student; 
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#putStudent(com.gmail.mwendapeter72.server.bean.student.Student)
	 */
	public boolean putStudent(Student student) {
		boolean success = true; 

		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Student" 
						+"(Uuid,StatusUuid,AdmNo,FirstName,SurName,LastName,Email,Mobile,"
						+ "GuardianContact,DOB,Gender,Program,AcademicYear,"
						+ "YearOfStudy,HomeTown,County,DateOfRegistration,ActivationDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
				){               

			pstmt.setString(1, student.getUuid());
			pstmt.setString(2, student.getStatusUuid());
			pstmt.setString(3, student.getAdmNo());
			pstmt.setString(4, student.getFirstName());
			pstmt.setString(5, student.getSurName());
			pstmt.setString(6, student.getLastName());
			pstmt.setString(7, student.getEmail());
			pstmt.setString(8, student.getMobile());
			pstmt.setString(9, student.getGuardianContact());
			pstmt.setString(10, student.getDOB());
			pstmt.setString(11, student.getGender());
			pstmt.setString(12, student.getProgram());
			pstmt.setString(13, student.getAcademicYear());
			pstmt.setString(14, student.getYearOfStudy());
			pstmt.setString(15, student.getHomeTown());
			pstmt.setString(16, student.getCounty());
			pstmt.setTimestamp(17, new Timestamp(student.getDateOfRegistration().getTime()));
			pstmt.setTimestamp(18, new Timestamp(student.getActivationDate().getTime()));
			pstmt.executeUpdate();





		}catch(SQLException e){
			logger.error("SQL Exception trying to put Student: "+student);
			logger.error(ExceptionUtils.getStackTrace(e)); 
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}


		return success;
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#updateStudent(com.gmail.mwendapeter72.server.bean.student.Student, java.lang.String)
	 */
	public boolean updateStudent(Student student, String Uuid) {
		boolean success = true;

		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE Student SET AdmNo =?," 
						+"FirstName =?,SurName =?,LastName =?,Email =?,Mobile =?,"
						+ "GuardianContact =?,DOB =?,Gender=?, Program =?,AcademicYear =?,YearOfStudy=?,"
						+ " HomeTown =?,County =? WHERE Uuid = ?;");
				){              //StatusUuid ActivationDate

			pstmt.setString(1, student.getAdmNo());
			pstmt.setString(2, student.getFirstName());
			pstmt.setString(3, student.getSurName());	           
			pstmt.setString(4, student.getLastName());
			pstmt.setString(5, student.getEmail());
			pstmt.setString(6, student.getMobile());
			pstmt.setString(7, student.getGuardianContact());
			pstmt.setString(8, student.getDOB());
			pstmt.setString(9, student.getGender());                       
			pstmt.setString(10, student.getProgram());
			pstmt.setString(11, student.getAcademicYear());
			pstmt.setString(12, student.getYearOfStudy());
			pstmt.setString(13, student.getHomeTown());
			pstmt.setString(14, student.getCounty());
			pstmt.setString(15, student.getUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception trying to update Student: "+student);
			logger.error(ExceptionUtils.getStackTrace(e));  
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}
		return success;
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#activateStudent(com.gmail.mwendapeter72.server.bean.student.Student)
	 */
	public boolean activateStudent(Student student) {
		boolean success = true;

		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE Student SET StatusUuid =?,"
						+ "YearOfStudy =?,AcademicYear=?,ActivationDate=? WHERE Uuid = ?;");
				){        

			pstmt.setString(1, student.getStatusUuid());
			pstmt.setString(2, student.getYearOfStudy());
			pstmt.setString(3, student.getAcademicYear());
			pstmt.setTimestamp(4, new Timestamp(student.getActivationDate().getTime()));//
			pstmt.setString(5, student.getUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception trying to update Student: "+student);
			logger.error(ExceptionUtils.getStackTrace(e));  
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}
		return success;
	}



	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#deActivateStudent(com.gmail.mwendapeter72.server.bean.student.Student)
	 */
	public boolean deActivateStudent(Student student) {
		boolean success = true;
		try(   Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE Student SET StatusUuid =?  WHERE Uuid = ?;");
				){        

			pstmt.setString(1, student.getStatusUuid());
			pstmt.setString(2, student.getUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception trying to update Student: "+student);
			logger.error(ExceptionUtils.getStackTrace(e));  
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;
		}
		return success;
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#deleteStudent(com.gmail.mwendapeter72.server.bean.student.Student, java.lang.String)
	 */
	public boolean deleteStudent(Student student, String Uuid) {
		boolean success = true; 
		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Student"
						+ " WHERE Uuid = ?;");       

				){

			pstmt.setString(1, student.getUuid());
			pstmt.executeUpdate();

		}catch(SQLException e){
			logger.error("SQL Exception when deletting student : " +student);
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
			success = false;

		}

		return success;
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudentList(int, int)
	 */
	public List<Student> getStudentList(int startIndex , int endIndex) {
		List<Student> studentList = new ArrayList<>();

		try(
				Connection conn = dbutils.getConnection();
				PreparedStatement psmt= conn.prepareStatement("SELECT * FROM Student ORDER BY AdmNo ASC LIMIT ? OFFSET ? ;");
				) {

			psmt.setInt(1, endIndex - startIndex);
			psmt.setInt(2, startIndex);

			try(ResultSet rset = psmt.executeQuery();){

				studentList = beanProcessor.toBeanList(rset, Student.class);
			}
		} catch (SQLException e) {
			logger.error("SQLException when trying to get a Student List with an index and offset.");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e)); 
		}

		return studentList;		
	}


	/**
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudentList()
	 */
	public List<Student> getStudentList() {
		List<Student> list =new  ArrayList<>(); 
		try(   
				Connection conn = dbutils.getConnection();
				PreparedStatement  pstmt = conn.prepareStatement("SELECT * FROM Student ;");   
				ResultSet rset = pstmt.executeQuery();
				) {

			list = beanProcessor.toBeanList(rset, Student.class);


		} catch(SQLException e){
			logger.error("SQL Exception when getting all Student");
			logger.error(ExceptionUtils.getStackTrace(e));
			System.out.println(ExceptionUtils.getStackTrace(e));
		}

		return list;
	}





}
