/**
 * 
 */
package com.gmail.mwendapeter72.server.persistence.student;

import java.util.List;

import com.gmail.mwendapeter72.server.bean.student.StudentPosition;

/**
 * @author peter
 *
 */
public class StudentPositionDAO implements CuStudentPositionDAO {

	/**
	 * 
	 */
	public StudentPositionDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentPositionDAO#getPosition(java.lang.String)
	 */
	@Override
	public StudentPosition getPosition(String StudentUuid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentPositionDAO#putPosition(com.gmail.mwendapeter72.server.bean.student.StudentPosition)
	 */
	@Override
	public boolean putPosition(StudentPosition position) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentPositionDAO#updatePosition(com.gmail.mwendapeter72.server.bean.student.StudentPosition)
	 */
	@Override
	public boolean updatePosition(StudentPosition position) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentPositionDAO#deletePosition(com.gmail.mwendapeter72.server.bean.student.StudentPosition)
	 */
	@Override
	public boolean deletePosition(StudentPosition position) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gmail.mwendapeter72.server.persistence.student.CuStudentPositionDAO#getAllPositions()
	 */
	@Override
	public List<StudentPosition> getAllPositions() {
		// TODO Auto-generated method stub
		return null;
	}

}
