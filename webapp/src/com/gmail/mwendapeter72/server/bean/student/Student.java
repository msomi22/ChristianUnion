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
package com.gmail.mwendapeter72.server.bean.student;

import java.util.Date;

import com.gmail.mwendapeter72.server.bean.AllBean;


/**
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 * @author joram<a href="mailto:joramndungu10@gmail.com">Joram Muriithi</a>
 *
 */
public class Student extends AllBean implements Comparable<Student> {
	
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

	/**
	 * 
	 */
	public Student() {
		super();
		
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
		DateOfRegistration = new Date();			
	}
	


	


	public String getAdmNo() {
		return AdmNo;
	}


	public void setAdmNo(String admNo) {
		this.AdmNo = admNo;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}


	public String getSurName() {
		return SurName;
	}


	public void setSurName(String surName) {
		this.SurName = surName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		this.LastName = lastName;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		this.Email = email;
	}


	public String getMobile() {
		return Mobile;
	}


	public void setMobile(String mobile) {
		this.Mobile = mobile;
	}


	public String getGuardianContact() {
		return GuardianContact;
	}


	public void setGuardianContact(String guardianContact) {
		this.GuardianContact = guardianContact;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		this.DOB = dOB;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		this.Gender = gender;
	}


	public String getProgram() {
		return Program;
	}


	public void setProgram(String program) {
		this.Program = program;
	}


	public String getAcademicYear() {
		return AcademicYear;
	}


	public void setAcademicYear(String academicYear) {
		this.AcademicYear = academicYear;
	}


	public String getYearOfStudy() {
		return YearOfStudy;
	}


	public void setYearOfStudy(String yearOfStudy) {
		this.YearOfStudy = yearOfStudy;
	}


	public String getHomeTown() {
		return HomeTown;
	}


	public void setHomeTown(String homeTown) {
		this.HomeTown = homeTown;
	}


	public String getCounty() {
		return County;
	}


	public void setCounty(String county) {
		this.County = county;
	}


	public Date getDateOfRegistration() {
		return new Date(DateOfRegistration.getTime());
	}


	public void setDateOfRegistration(Date dateOfRegistration) {
		this.DateOfRegistration = new Date(dateOfRegistration.getTime());
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


	@Override
	public int compareTo(Student s) {
		return AdmNo.compareTo(((Student) s).getAdmNo());
	}
	
}
