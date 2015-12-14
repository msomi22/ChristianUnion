/**
*CacheInit.java
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
package com.gmail.mwendapeter72.server.servlet.init;



import java.io.File;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.Status;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.DiskStoreConfiguration;
import net.sf.ehcache.config.SizeOfPolicyConfiguration;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.gmail.mwendapeter72.server.bean.StorableBean;
import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.cache.CacheVariables;
import com.gmail.mwendapeter72.server.persistence.student.StatusDAO;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.persistence.student.StudentOtherDetailDAO;
import com.gmail.mwendapeter72.server.persistence.student.leader.LeadersRegisterDAO;
import com.gmail.mwendapeter72.server.persistence.student.leader.PositionDAO;
import com.gmail.mwendapeter72.server.persistence.student.leader.executive.ExecutiveDAO;
import com.gmail.mwendapeter72.server.persistence.student.leader.family.FamilyDAO;
import com.gmail.mwendapeter72.server.persistence.student.leader.ministry.MinistryDAO;
import com.gmail.mwendapeter72.server.servlet.util.PropertiesConfig;


/**
 * initialize ehcache
 * <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class CacheInit extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3008204545799439966L;

	protected StudentOtherDetailDAO studentOtherDetailDAO;
	protected StudentDAO studentDAO;
	protected StatusDAO statusDAO;
	
	protected LeadersRegisterDAO leadersRegisterDAO;
	protected PositionDAO positionDAO;
	
	protected ExecutiveDAO executiveDAO;
	
	protected FamilyDAO familyDAO;
	
	protected MinistryDAO ministryDAO;
	
	
    private CacheManager cacheManager;
    private SizeOfPolicyConfiguration sizeOfPolicyConfiguration;

    private Logger logger = Logger.getLogger(this.getClass());
    
    
    /**
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
       
        studentOtherDetailDAO = StudentOtherDetailDAO.getInstance();
        studentDAO = StudentDAO.getInstance();
        statusDAO = StatusDAO.getInstance();
       
        
        leadersRegisterDAO = LeadersRegisterDAO.getInstance();
        positionDAO = PositionDAO.getInstance();
        
        executiveDAO = ExecutiveDAO.getInstance();
        
        familyDAO = FamilyDAO.getInstance();
        
        ministryDAO = MinistryDAO.getInstance();
       
        sizeOfPolicyConfiguration = new SizeOfPolicyConfiguration();
        sizeOfPolicyConfiguration.setMaxDepthExceededBehavior("abort");

        logger.info("Starting to initialize cache");
        initCache();
        logger.info("Have finished initializing cache");
    }
    

    /**
     *
     */
    protected void initCache() {
        DiskStoreConfiguration diskConfig = new DiskStoreConfiguration();
        diskConfig.setPath(System.getProperty("java.io.tmpdir") + File.separator +
        		"ehcache" + File.separator + PropertiesConfig.getConfigValue("CACHE_FILE"));        
        
        Configuration config = (new Configuration()).diskStore(diskConfig);
        config.setMaxBytesLocalHeap(Long.parseLong(PropertiesConfig.getConfigValue("MAX_BYTES_LOCAL_HEAP")));
        config.setMaxBytesLocalDisk(Long.parseLong(PropertiesConfig.getConfigValue("MAX_BYTES_LOCAL_DISK")));
        config.setUpdateCheck(false);

        cacheManager = CacheManager.create(config);
      
        List<? extends StorableBean> objList;
        
        objList = studentDAO.getStudentList();
        initCacheByUuid(CacheVariables.CACHE_STUDENT_BY_UUID, objList);
        
        objList = statusDAO.getAllStatus();
        initCacheByUuid(CacheVariables.CACHE_STATUS_BY_UUID, objList);
        
        objList = studentOtherDetailDAO.getDetailList();
        initCacheByUuid(CacheVariables.CACHE_STUDENT_OTHER_INFO_BY_UUID, objList);
        
        objList = leadersRegisterDAO.getLeadersList();
        initCacheByUuid(CacheVariables.CACHE_LEADERS_REGISTER_BY_UUID, objList);
        
        objList = positionDAO.getPositionList();
        initCacheByUuid(CacheVariables.CACHE_POSITION_BY_UUID, objList);
        
        objList = executiveDAO.getExecutiveList();
        initCacheByUuid(CacheVariables.CACHE_EXECUTIVE_BY_UUID, objList);
       
        objList = familyDAO.getFamilyList();
        initCacheByUuid(CacheVariables.CACHE_FAMILY_BY_UUID, objList);
        
       
        objList = ministryDAO.getAllMinistres();
        initCacheByUuid(CacheVariables.CACHE_MINISTRY_BY_UUID, objList);
        
      

        initStudentsCache(CacheVariables.CACHE_STUDENT_BY_ADM_NO);
        
        initGenericCache(CacheVariables.CACHE_STATISTICS_BY_STUDENT);
        initGenericCache(CacheVariables.CACHE_STUDENTS_STATISTICS);        
    }
    

    /**
     *
     * @param cacheName
     * @param objList
     */
    private void initCacheByUuid(String cacheName, List<? extends StorableBean> objList) {
    	Cache cache = null;
        if (!cacheManager.cacheExists(cacheName)) {
            CacheConfiguration cacheConfig = new CacheConfiguration().sizeOfPolicy(sizeOfPolicyConfiguration);
            cacheConfig.setCopyOnRead(false); // Whether the Cache should copy elements it returns
            cacheConfig.setCopyOnWrite(false); // Whether the Cache should copy elements it gets
            cacheConfig.setEternal(true); // Sets whether elements are eternal.        
            cacheConfig.setName(cacheName); // Sets the name of the cache.

            cache = new Cache(cacheConfig);
            cacheManager.addCacheIfAbsent(cache);
            if (cache.getStatus() == Status.STATUS_UNINITIALISED) {
                cache.initialise();
            }
            
        } else {
        	CacheManager mgr = CacheManager.getInstance();
        	cache = mgr.getCache(cacheName);
        }
     
        for (StorableBean b : objList) {
            cache.put(new Element(b.getUuid(), b)); // UUID as the key            
        }
    }    
    

   
    /**
     * @param cacheName
     */
    private void initStudentsCache(String cacheName) {

        if (!cacheManager.cacheExists(cacheName)) {
            CacheConfiguration cacheConfig = new CacheConfiguration().sizeOfPolicy(sizeOfPolicyConfiguration);
            cacheConfig.setCopyOnRead(false); // Whether the Cache should copy elements it returns
            cacheConfig.setCopyOnWrite(false); // Whether the Cache should copy elements it gets
            cacheConfig.setEternal(true); // Sets whether elements are eternal.    	
            cacheConfig.setName(cacheName); // Sets the name of the cache.

            Cache studentsCache = new Cache(cacheConfig);
            cacheManager.addCacheIfAbsent(studentsCache);
            if (studentsCache.getStatus() == Status.STATUS_UNINITIALISED) {
            	studentsCache.initialise();
            }

            List<Student> allstudents = studentDAO.getStudentList();

            if (StringUtils.equals(cacheName, CacheVariables.CACHE_STUDENT_BY_ADM_NO)) {
                for (Student stu : allstudents) {
                	studentsCache.put(new Element(stu.getAdmNo(), stu));		// admno as the key
                }
            }
        }
    }

   
    
    /**
     *
     * @param cacheName
     */
    private void initGenericCache(String cacheName) {
        if (!cacheManager.cacheExists(cacheName)) {
            CacheConfiguration cacheConfig = new CacheConfiguration().sizeOfPolicy(sizeOfPolicyConfiguration);
            cacheConfig.setCopyOnRead(false); // Whether the Cache should copy elements it returns
            cacheConfig.setCopyOnWrite(false); // Whether the Cache should copy elements it gets
            cacheConfig.setEternal(true); // Sets whether elements are eternal.    	
            cacheConfig.setName(cacheName); // Sets the name of the cache.

            Cache cache = new Cache(cacheConfig);
            cacheManager.addCacheIfAbsent(cache);
            if (cache.getStatus() == Status.STATUS_UNINITIALISED) {
                cache.initialise();
            }
        }
    }
    
    
    /**
     * @see javax.servlet.GenericServlet#destroy()
     */
    @Override
    public void destroy() {
        super.destroy();

        CacheManager.getInstance().shutdown();
    }
}
