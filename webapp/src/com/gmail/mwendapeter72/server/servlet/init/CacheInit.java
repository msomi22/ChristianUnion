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

import com.gmail.mwendapeter72.server.bean.AllBean;
import com.gmail.mwendapeter72.server.bean.student.Student;
import com.gmail.mwendapeter72.server.cache.CacheVariables;
import com.gmail.mwendapeter72.server.persistence.student.StudentDAO;
import com.gmail.mwendapeter72.server.persistence.student.StudentPositionDAO;
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

	protected StudentDAO studentDAO;
	protected StudentPositionDAO StudentPositionDAO;
	
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

        studentDAO = StudentDAO.getInstance();
      
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
      //studentDAO
        List<? extends AllBean> objList;

        objList = studentDAO.getStudentList(0, 15); 
        initCacheByUuid(CacheVariables.CACHE_STUDENT_BY_UUID, objList);
       

        initAccountsCache(CacheVariables.CACHE_STUDENT_BY_ADM_NO);
           

        initGenericCache(CacheVariables.CACHE_STATISTICS_BY_STUDENT);
        initGenericCache(CacheVariables.CACHE_STUDENT_BY_ADM_NO);        
    }
    

    /**
     *
     * @param cacheName
     * @param objList
     */
    private void initCacheByUuid(String cacheName, List<? extends AllBean> objList) {
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
     
        for (AllBean b : objList) {
            cache.put(new Element(b.getUuid(), b)); // UUID as the key            
        }
    }    
    

    /**
     *
     * @param cacheName
     */
    private void initAccountsCache(String cacheName) {

        if (!cacheManager.cacheExists(cacheName)) {
            CacheConfiguration cacheConfig = new CacheConfiguration().sizeOfPolicy(sizeOfPolicyConfiguration);
            cacheConfig.setCopyOnRead(false); // Whether the Cache should copy elements it returns
            cacheConfig.setCopyOnWrite(false); // Whether the Cache should copy elements it gets
            cacheConfig.setEternal(true); // Sets whether elements are eternal.    	
            cacheConfig.setName(cacheName); // Sets the name of the cache.

            Cache accountsCache = new Cache(cacheConfig);
            cacheManager.addCacheIfAbsent(accountsCache);
            if (accountsCache.getStatus() == Status.STATUS_UNINITIALISED) {
                accountsCache.initialise();
            }

            List<Student> allstudents = studentDAO.getStudentList(0, 15); 

            if (StringUtils.equals(cacheName, CacheVariables.CACHE_STUDENT_BY_ADM_NO)) {
                for (Student stu : allstudents) {
                    accountsCache.put(new Element(stu.getAdmNo(), stu));		// admno as the key
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
