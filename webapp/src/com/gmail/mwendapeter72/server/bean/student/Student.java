/**
*Student.java
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
package com.gmail.mwendapeter72.server.bean.student;

import java.util.Date;

import com.gmail.mwendapeter72.server.bean.StorableBean;


/**<p>
 * A student within the MMUCU System
 * </P>
 * @author <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author <a href="mailto:joramndungu10@gmail.com">Joram Muriithi</a>
 *
 */
public class Student extends StorableBean implements Comparable<Student> {
	
	private String StatusUuid;
	private String AdmNo;
	private String FirstName; 
	private String SurName; 
	private String LastName;
	private String Email;
	private String Mobile;
	private String GuardianContact;
	private String DOB;
	private String Gender;
	private String Program;
	private String AcademicYear;
	private String YearOfStudy;
	private String HomeTown;
	private String County;
	private Date DateOfRegistration;
	private Date ActivationDate;
	
	
	
	public Student() {
		super();
		StatusUuid = ""; 
		AdmNo = "";
		FirstName = "";
		SurName = "";
		LastName = "";
		Email = "";
		Mobile = "";
		GuardianContact = "";
		DOB = "";
		Gender = "";
		Program = "";
		AcademicYear = "";
		YearOfStudy = "";
		HomeTown = "";
		County = "";
		DateOfRegistration = new Date();	
		ActivationDate = new Date();	
		
	}
	
	/**
	 * @return the statusUuid
	 */
	public String getStatusUuid() {
		return StatusUuid;
	}

	/**
	 * @param statusUuid the statusUuid to set
	 */
	public void setStatusUuid(String statusUuid) {
		StatusUuid = statusUuid;
	}

	/**
	 * @return the admNo
	 */
	public String getAdmNo() {
		return AdmNo;
	}

	/**
	 * @param admNo the admNo to set
	 */
	public void setAdmNo(String admNo) {
		AdmNo = admNo;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	/**
	 * @return the surName
	 */
	public String getSurName() {
		return SurName;
	}

	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		SurName = surName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return Mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	/**
	 * @return the guardianContact
	 */
	public String getGuardianContact() {
		return GuardianContact;
	}

	/**
	 * @param guardianContact the guardianContact to set
	 */
	public void setGuardianContact(String guardianContact) {
		GuardianContact = guardianContact;
	}

	/**
	 * @return the dOB
	 */
	public String getDOB() {
		return DOB;
	}

	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(String dOB) {
		DOB = dOB;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		Gender = gender;
	}

	/**
	 * @return the program
	 */
	public String getProgram() {
		return Program;
	}

	/**
	 * @param program the program to set
	 */
	public void setProgram(String program) {
		Program = program;
	}

	/**
	 * @return the academicYear
	 */
	public String getAcademicYear() {
		return AcademicYear;
	}

	/**
	 * @param academicYear the academicYear to set
	 */
	public void setAcademicYear(String academicYear) {
		AcademicYear = academicYear;
	}

	/**
	 * @return the yearOfStudy
	 */
	public String getYearOfStudy() {
		return YearOfStudy;
	}

	/**
	 * @param yearOfStudy the yearOfStudy to set
	 */
	public void setYearOfStudy(String yearOfStudy) {
		YearOfStudy = yearOfStudy;
	}

	/**
	 * @return the homeTown
	 */
	public String getHomeTown() {
		return HomeTown;
	}

	/**
	 * @param homeTown the homeTown to set
	 */
	public void setHomeTown(String homeTown) {
		HomeTown = homeTown;
	}

	/**
	 * @return the county
	 */
	public String getCounty() {
		return County;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		County = county;
	}

	/**
	 * @return the dateOfRegistration
	 */
	public Date getDateOfRegistration() {
		return DateOfRegistration;
	}

	/**
	 * @param dateOfRegistration the dateOfRegistration to set
	 */
	public void setDateOfRegistration(Date dateOfRegistration) {
		DateOfRegistration = dateOfRegistration;
	}

	/**
	 * @return the activationDate
	 */
	public Date getActivationDate() {
		return ActivationDate;
	}

	/**
	 * @param activationDate the activationDate to set
	 */
	public void setActivationDate(Date activationDate) {
		ActivationDate = activationDate;
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Student [ getUuid() =");
		builder.append(getUuid());
		builder.append(", StatusUuid =");
		builder.append(StatusUuid);
		builder.append(", AdmNo =");
		builder.append(AdmNo);
		builder.append(", FirstName =");
		builder.append(FirstName);
		builder.append(", SurName =");
		builder.append(SurName);
		builder.append(", LastName =");
		builder.append(LastName);
		builder.append(", Email =");
		builder.append(Email);
		builder.append(", Mobile =");
		builder.append(Mobile);
		builder.append(", GuardianContact =");
		builder.append(GuardianContact);
		builder.append(", DOB =");
		builder.append(DOB);
		builder.append(", Gender =");
		builder.append(Gender);
		builder.append(", Program =");
		builder.append(Program);
		builder.append(", AcademicYear =");
		builder.append(AcademicYear);
		builder.append(", YearOfStudy =");
		builder.append(YearOfStudy);
		builder.append(", HomeTown =");
		builder.append(HomeTown);
		builder.append(", County =");
		builder.append(County);
		builder.append(", DateOfRegistration =");
		builder.append(DateOfRegistration);
		builder.append(", ActivationDate =");
		builder.append(ActivationDate);
		builder.append("]");
		return builder.toString(); 
		}


	@Override
	public int compareTo(Student s) {
		return AdmNo.compareTo(((Student) s).getAdmNo());
	}
	
	
	private static final long serialVersionUID = 4194878627241319276L;
}
