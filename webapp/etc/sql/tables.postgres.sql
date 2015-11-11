
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
-- Table Student
-- -------------------


CREATE TABLE  Student (
    Id SERIAL PRIMARY KEY,
    Uuid text UNIQUE NOT NULL,
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
    DateOfRegistration timestamp with time zone DEFAULT now()

);
\COPY Student(Uuid,AdmNo,FirstName,SurName,LastName,Email,Mobile,GuardianContact,DOB,Gender,Program,AcademicYear,YearOfStudy,HomeTown,County,DateOfRegistration) FROM '/tmp/Student.csv' WITH DELIMITER AS '|' CSV HEADER
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
-- Table ApprovalStatus
-- -------------------
CREATE TABLE  Status (
    Id SERIAL PRIMARY KEY,
    Uuid text UNIQUE NOT NULL,
    Status text
    

);
\COPY Status(Uuid,Status) FROM '/tmp/Status.csv' WITH DELIMITER AS '|' CSV HEADER
ALTER TABLE Status OWNER TO cu;




-- -------------------
-- Table StudentApproval
-- -------------------
CREATE TABLE  StudentStatus (
    Id SERIAL PRIMARY KEY,
    Uuid text UNIQUE NOT NULL,
    StudentUuid text REFERENCES Student(Uuid),
    StudentStatusUuid text REFERENCES Status(Uuid)
   
    

);
\COPY StudentStatus(Uuid,StudentUuid,StudentStatusUuid) FROM '/tmp/StudentStatus.csv' WITH DELIMITER AS '|' CSV HEADER
ALTER TABLE StudentStatus OWNER TO cu;









