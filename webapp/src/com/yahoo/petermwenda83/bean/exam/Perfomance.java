
/*************************************************************
 * Online School Management System                           *
 * Forth Year Project                                        *
 * Maasai Mara University                                    *
 * Bachelor of Science(Computer Science)                     *
 * Year:2015-2016                                            *
 * Name: Njeru Mwenda Peter                                  *
 * ADM NO : BS02/009/2012                                    *
 *                                                           *
 *************************************************************/
package com.yahoo.petermwenda83.bean.exam;

import java.util.Date;

import com.yahoo.petermwenda83.bean.StorableBean;

/**
 * Student performance in a school
 * 
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class Perfomance extends StorableBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5213605489119414121L;
	private String schoolAccountUuid;
	private String teacherUuid;
	private String studentUuid;
	private String subjectUuid;
	private String examUuid;
	private double score;
	private String term;
	private String year;
	private String sysUser;
	private Date submitssionDate;
	
	/**
	 * 
	 */
	public Perfomance() {
        super();
        schoolAccountUuid ="";
        teacherUuid ="";
        studentUuid ="";
        subjectUuid ="";
        examUuid ="";
        score = 0.0;
        term ="";
      	year ="";
      	sysUser ="";
      	submitssionDate = new Date(); 
      	
	}
	
	

	/**
	 * @return the schoolAccountUuid
	 */
	public String getSchoolAccountUuid() {
		return schoolAccountUuid;
	}



	/**
	 * @param schoolAccountUuid the schoolAccountUuid to set
	 */
	public void setSchoolAccountUuid(String schoolAccountUuid) {
		this.schoolAccountUuid = schoolAccountUuid;
	}



	/**
	 * @return the teacherUuid
	 */
	public String getTeacherUuid() {
		return teacherUuid;
	}



	/**
	 * @param teacherUuid the teacherUuid to set
	 */
	public void setTeacherUuid(String teacherUuid) {
		this.teacherUuid = teacherUuid;
	}



	/**
	 * @return the studentUuid
	 */
	public String getStudentUuid() {
		return studentUuid;
	}



	/**
	 * @param studentUuid the studentUuid to set
	 */
	public void setStudentUuid(String studentUuid) {
		this.studentUuid = studentUuid;
	}



	/**
	 * @return the subjectUuid
	 */
	public String getSubjectUuid() {
		return subjectUuid;
	}



	/**
	 * @param subjectUuid the subjectUuid to set
	 */
	public void setSubjectUuid(String subjectUuid) {
		this.subjectUuid = subjectUuid;
	}



	/**
	 * @return the examUuid
	 */
	public String getExamUuid() {
		return examUuid;
	}



	/**
	 * @param examUuid the examUuid to set
	 */
	public void setExamUuid(String examUuid) {
		this.examUuid = examUuid;
	}



	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}



	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}



	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}



	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}



	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}



	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}



	/**
	 * @return the sysUser
	 */
	public String getSysUser() {
		return sysUser;
	}



	/**
	 * @param sysUser the sysUser to set
	 */
	public void setSysUser(String sysUser) {
		this.sysUser = sysUser;
	}



	/**
	 * @return the submitssionDate
	 */
	public Date getSubmitssionDate() {
		return submitssionDate;
	}



	/**
	 * @param submitssionDate the submitssionDate to set
	 */
	public void setSubmitssionDate(Date submitssionDate) {
		this.submitssionDate = submitssionDate;
	}



	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Performance [ getUuid() =");
		builder.append(getUuid());
		builder.append(", schoolAccountUuid =");
		builder.append(schoolAccountUuid);
		builder.append(",teacherUuid=");
		builder.append(teacherUuid);
		builder.append(", studentUuid =");
		builder.append(studentUuid);
		builder.append(", subjectUuid =");
		builder.append(subjectUuid);
		builder.append(", examUuid =");
		builder.append(examUuid);
		builder.append(", score =");
		builder.append(score);
		builder.append(", term =");
		builder.append(term);
		builder.append(", year =");
		builder.append(year);
		builder.append(", sysUser =");
		builder.append(sysUser);
		builder.append(", submitssionDate =");
		builder.append(submitssionDate);
		builder.append("]");
		return builder.toString(); 
		}
	

}
