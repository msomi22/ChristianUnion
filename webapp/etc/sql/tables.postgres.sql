
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
    Year text,
    Major text,
    DOB text,
    County text

);
\COPY Student(Uuid,AdmNo,FirstName,SurName,LastName,Email,Mobile,Year,Major,DOB,County) FROM '/tmp/Student.csv' WITH DELIMITER AS '|' CSV HEADER
ALTER TABLE Student OWNER TO cu;


