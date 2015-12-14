/**
*CacheVariables.java
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
package com.gmail.mwendapeter72.server.cache;
/**
 * <p>
 * Variables used for cache managements 
 * </P>
 * <a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 *
 */
public class CacheVariables {

    public static String CACHE_STATISTICS_BY_STUDENT = "CacheAllStudentsStatistics";
    public final static String CACHE_STUDENTS_STATISTICS = "CacheStudent";
    public final static String CACHE_STUDENT_BY_ADM_NO = "StudentAdmNo";

    // The following caches have an UUID as the key for the object
    public final static String CACHE_STUDENT_BY_UUID = "StudentUuid";
    public final static String CACHE_STUDENT_OTHER_INFO_BY_UUID = "StudentOtherInfoUuid";
    
    public final static String CACHE_STATUS_BY_UUID = "StatusUuid";
    
    public final static String CACHE_LEADERS_REGISTER_BY_UUID = "LeadersRegisterUuid"; 
    public final static String CACHE_POSITION_BY_UUID = "PositionUuid";
    
    public final static String CACHE_EXECUTIVE_BY_UUID = "executiveUuid";
    public final static String CACHE_EXECUTIVE_HEAD_BY_UUID = "ExecutiveHeadUuid";
    
    public final static String CACHE_FAMILY_BY_UUID = "FamilyUuid";
    public final static String CACHE_FAMILY_HEAD_BY_UUID = "FamilyHeadUuid";
    public final static String CACHE_GUKA_BY_UUID = "GukaUuid";
    
    public final static String CACHE_MINISTRY_BY_UUID = "MinistryUuid";
    public final static String CACHE_MINISTRY_HEAD_BY_UUID = "MinistryHeadUuid";
    
    
    
    public final static String CACHE_EXECUTIVE_HEAD_BY_STUDENT_UUID = "ExecHeadUuid"; 
    public final static String CACHE_FAMILY_HEAD_BY_STUDENT_UUID = "famHeadUuid";
    public final static String CACHE_MINISTRY_HEAD_BY_STUDENT_UUID = "minHeadUuid";

    //Cache variables to be used in the admin section
    public static String CACHE_ALL_STUDENTS_STATISTICS_KEY = "CacheAllAccountsStatisticsKey";
    public static String CACHE_ALL_STUDENTS_STATISTICS = "CacheAllAccountsStatisticsKey";
}

