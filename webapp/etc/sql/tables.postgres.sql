--Maasai Mara University Christian Union Online Management System.
--Copyright 2015 Fastech Solutions Ltd
--Licensed under the Open Software License, Version 3.0 
--The codes herein AND/OR this file should NOT, under any circumstances whatsoever, be copied without the author's approval.
--Contacts author the: +254718953974
--@author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>


-- Schema Name: cudb
-- Username: cu
-- Password: Cu12c

-- These tables describe the database a CU Management System

-- Make sure you have created a Postgres user with the above username, password
-- and appropriate permissions. For development environments, you can make the 
-- database user to be a superuser to allow for copying of external files. 

-- Then run the "dbSetup.sh" script in the bin folder of this project.

\c postgres

-- Then execute the following:
DROP DATABASE IF EXISTS cudb; -- To drop a database you can't be logged into it. Drops if it exists.
CREATE DATABASE cudb;

-- Connect with the database on the username
\c cudb cu



--======================
--======================
--1. Student Management
--======================
--======================


-- -------------------
-- Table Status
-- -------------------
CREATE TABLE  Status (
    Id SERIAL PRIMARY KEY,
    Uuid text UNIQUE NOT NULL,
    Status text
    

);
\COPY Status(Uuid,Status) FROM '/tmp/Status.csv' WITH DELIMITER AS '|' CSV HEADER
ALTER TABLE Status OWNER TO cu;



-- -------------------
-- Table Executive
-- -------------------
CREATE TABLE  Executive (
    Id SERIAL PRIMARY KEY,
    Uuid text UNIQUE NOT NULL,
    Category text
    

);
\COPY Executive(Uuid,Category) FROM '/tmp/Executive.csv' WITH DELIMITER AS '|' CSV HEADER
ALTER TABLE Executive OWNER TO cu;





-- -------------------
-- Table Ministry
-- -------------------
CREATE TABLE  Ministry (
    Id SERIAL PRIMARY KEY,
    Uuid text UNIQUE NOT NULL,
    MinistryName text
    

);
\COPY Ministry(Uuid,MinistryName) FROM '/tmp/Ministry.csv' WITH DELIMITER AS '|' CSV HEADER
ALTER TABLE Ministry OWNER TO cu;



-- -------------------
-- Table Family
-- -------------------
CREATE TABLE  Family (
    Id SERIAL PRIMARY KEY,
    Uuid text UNIQUE NOT NULL,
    FamilyName text
    

);
\COPY Family(Uuid,FamilyName) FROM '/tmp/Family.csv' WITH DELIMITER AS '|' CSV HEADER
ALTER TABLE Family OWNER TO cu;



-- -------------------
-- Table Position
-- -------------------
CREATE TABLE  Position (
    Id SERIAL PRIMARY KEY,
    Uuid text UNIQUE NOT NULL,
    PositionName text
    

);
\COPY Position(Uuid,PositionName) FROM '/tmp/Position.csv' WITH DELIMITER AS '|' CSV HEADER
ALTER TABLE Position OWNER TO cu;






-- -------------------
-- Table Student
-- -------------------


CREATE TABLE  Student (
    Id SERIAL PRIMARY KEY,
    Uuid text UNIQUE NOT NULL,
    StatusUuid text REFERENCES Status(Uuid),
    AdmNo text,
    FirstName text,
    SurName text,
    LastName text,
    Email text,
    Mobile text,
    GuardianContact text,
    DOB text,
    Gender text,
    Program text,
    AcademicYear text,
    YearOfStudy text,
    HomeTown text,
    County text,
    DateOfRegistration timestamp with time zone DEFAULT now(),
    ActivationDate timestamp with time zone DEFAULT now()

);
\COPY Student(Uuid,StatusUuid,AdmNo,FirstName,SurName,LastName,Email,Mobile,GuardianContact,DOB,Gender,Program,AcademicYear,YearOfStudy,HomeTown,County,DateOfRegistration,ActivationDate) FROM '/tmp/Student.csv' WITH DELIMITER AS '|' CSV HEADER
ALTER TABLE Student OWNER TO cu;


-- -------------------
-- Table StudentOtherInfo
-- -------------------
CREATE TABLE  StudentOtherInfo (
    Id SERIAL PRIMARY KEY,
    Uuid text UNIQUE NOT NULL,
    StudentUuid text REFERENCES Student(Uuid),
    Christian text,
    Duration text,
    Ministry text,
    MinistryName text,
    DesiredMinistry text,
    MinistryVision text
    

);
\COPY StudentOtherInfo(Uuid,StudentUuid,Christian,Duration,Ministry,MinistryName,DesiredMinistry,MinistryVision) FROM '/tmp/StudentOtherInfo.csv' WITH DELIMITER AS '|' CSV HEADER
ALTER TABLE StudentOtherInfo OWNER TO cu;


-- -------------------
-- Table LeadersRegister
-- -------------------
CREATE TABLE  LeadersRegister (
    Id SERIAL PRIMARY KEY,
    Uuid text UNIQUE NOT NULL,
    StudentUuid text REFERENCES Student(Uuid),
    StatusUuid text REFERENCES Status(Uuid),
    Category text ,
    Position text ,
    SubPosition text ,
    StartDate  timestamp with time zone DEFAULT now(),
    EndDate  timestamp 
   
    

);
\COPY LeadersRegister(Uuid,StudentUuid,StatusUuid,Category,Position,SubPosition,StartDate,EndDate) FROM '/tmp/LeadersRegister.csv' WITH DELIMITER AS '|' CSV HEADER
ALTER TABLE LeadersRegister OWNER TO cu;





