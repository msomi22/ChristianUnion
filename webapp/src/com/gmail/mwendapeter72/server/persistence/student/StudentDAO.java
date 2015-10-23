/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.Student;

/**
 * @author joram
 *
 */
public class StudentDAO  implements CuStudentDAO {

	/**
	 * 
	 */
	public StudentDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudent(java.lang.String)
	 */
	@Override
	public Student getStudent(String AdmNo) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getStudentByUuid(java.lang.String)
	 */
	@Override
	public Student getStudentByUuid(String Uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#putStudent(com.gmail.mwendapeter72.server.bean.student.Student)
	 */
	@Override
	public boolean putStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#updateStudent(com.gmail.mwendapeter72.server.bean.student.Student, java.lang.String)
	 */
	@Override
	public boolean updateStudent(Student student, String Uuid) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#deleteStudent(com.gmail.mwendapeter72.server.bean.student.Student, java.lang.String)
	 */
	@Override
	public boolean deleteStudent(Student student, String Uuid) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentDAO#getAllStdeunt()
	 */
	@Override
	public List<Student> getAllStdeunt() {
		// TODO Auto-generated method stub
		return null;
	}

}
