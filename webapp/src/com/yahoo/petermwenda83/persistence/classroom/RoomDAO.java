/**
 * 
 */
package com.yahoo.petermwenda83.persistence.classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.yahoo.petermwenda83.bean.classroom.ClassRoom;
import com.yahoo.petermwenda83.persistence.GenericDAO;

/**
 * @author peter
 *
 */
public class RoomDAO extends GenericDAO implements SchoolRoomDAO {
	private static RoomDAO roomDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	private BeanProcessor beanProcessor = new BeanProcessor();
	
	public static RoomDAO getInstance(){
		
		if(roomDAO == null){
			roomDAO = new RoomDAO();		
		}
		return roomDAO;
	}
	
	/**
	 * 
	 */
	public RoomDAO() { 
		super();
	}
	
	/**
	 * 
	 */
	public RoomDAO(String databaseName, String Host, String databaseUsername, String databasePassword, int databasePort) {
		super(databaseName, Host, databaseUsername, databasePassword, databasePort);
	}

	@Override
	public ClassRoom getroom(String SchoolAccountUuid, String Uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean putroom(ClassRoom room) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateroom(ClassRoom room) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteroom(ClassRoom room) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ClassRoom> getAllRooms(String SchoolAccountUuid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
