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

    public static String CACHE_STATISTICS_BY_STUDENT = "StatisticsEmail";
    public final static String CACHE_STUDENT_BY_ADM_NO = "StudentAdmNo";

    // The following caches have an UUID as the key for the object
    public final static String CACHE_STUDENT_BY_UUID = "StudentUuid";

    //Cache variables to be used in the admin section
    public static String CACHE_ALL_STUDENTS_STATISTICS_KEY = "CacheAllAccountsStatisticsKey";
    public static String CACHE_ALL_STUDENTS_STATISTICS = "CacheAllAccountsStatisticsKey";
}

