/**
 * 
 */
package com.gmail.mwendapeter72.server.bean.student;

import java.util.Date;

import com.gmail.mwendapeter72.server.bean.AllBean;

/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author joram<a href="mailto:joramndungu10@gmail.com">Joram Muriithi</a>
 *
 */
public class Student extends AllBean {
	private String StudentUuid;
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
	private Date DateOfRegistration = new Date();

	/**
	 * 
	 */
	public Student() {
		super();
		StudentUuid="";
		AdmNo ="";
		FirstName="";
		SurName="";
		LastName="";
		Email="";
		Mobile="";
		GuardianContact="";
		DOB="";
		Gender="";
		Program="";
		AcademicYear="";
		YearOfStudy="";
		HomeTown="";
		County="";
		DateOfRegistration = new Date(new Long(""));			
	}
	

	public String getStudentUuid() {
		return StudentUuid;
	}


	public void setStudentUuid(String studentUuid) {
		StudentUuid = studentUuid;
	}


	public String getAdmNo() {
		return AdmNo;
	}


	public void setAdmNo(String admNo) {
		AdmNo = admNo;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getSurName() {
		return SurName;
	}


	public void setSurName(String surName) {
		SurName = surName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getMobile() {
		return Mobile;
	}


	public void setMobile(String mobile) {
		Mobile = mobile;
	}


	public String getGuardianContact() {
		return GuardianContact;
	}


	public void setGuardianContact(String guardianContact) {
		GuardianContact = guardianContact;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public String getProgram() {
		return Program;
	}


	public void setProgram(String program) {
		Program = program;
	}


	public String getAcademicYear() {
		return AcademicYear;
	}


	public void setAcademicYear(String academicYear) {
		AcademicYear = academicYear;
	}


	public String getYearOfStudy() {
		return YearOfStudy;
	}


	public void setYearOfStudy(String yearOfStudy) {
		YearOfStudy = yearOfStudy;
	}


	public String getHomeTown() {
		return HomeTown;
	}


	public void setHomeTown(String homeTown) {
		HomeTown = homeTown;
	}


	public String getCounty() {
		return County;
	}


	public void setCounty(String county) {
		County = county;
	}


	public Date getDateOfRegistration() {
		return DateOfRegistration;
	}


	public void setDateOfRegistration(Date dateOfRegistration) {
		DateOfRegistration = dateOfRegistration;
	}


	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Student [ getUuid() =");
		builder.append(getUuid());
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
		builder.append("]");
		return builder.toString(); 
		}
	
}
