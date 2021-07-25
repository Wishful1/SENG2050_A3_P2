DROP DATABASE SENG2050;
GO
CREATE DATABASE SENG2050;
GO
USE SENG2050;
GO
BEGIN
	DROP LOGIN jdbcUserseng2050;
END
CREATE LOGIN jdbcUserseng2050 WITH PASSWORD='mypassword', DEFAULT_DATABASE=SENG2050;
GO
BEGIN
	DROP USER jdbcUserseng2050;
END
CREATE USER jdbcUserseng2050 FOR LOGIN jdbcUserseng2050;
GRANT SELECT, INSERT, UPDATE, DELETE TO jdbcUserseng2050;
GO

CREATE TABLE Issues (IssueId INT                    IDENTITY(1,1) PRIMARY KEY,
                    ReporterId CHAR(30)             ,
                    IssueStatus VARCHAR(50)         DEFAULT 'NEW',
                    Category VARCHAR(40)            NOT NULL,
                    Title VARCHAR(100)              NOT NULL,
                    IssueDtls TEXT                  NOT NULL,
                    IssueComments VARCHAR(5000)     ,
                    DateReported DATETIME           DEFAULT getdate(),
                    ResolutionDtls VARCHAR(5000)    ,
                    DateResolved VARCHAR(40)
);

CREATE TABLE Users (UserId INT              IDENTITY(1,1) PRIMARY KEY,
                    UserName VARCHAR(20)    NOT NULL UNIQUE,
                    FirstName VARCHAR(20)   NOT NULL,
                    LastName VARCHAR(20)    NOT NULL,
                    Email VARCHAR(50)       NOT NULL,
                    Password VARCHAR(20)    NOT NULL,
                    Phone VARCHAR(20)       NOT NULL,
                    CreateDate DATETIME     NOT NULL DEFAULT getdate()
 );

CREATE TABLE Roles (
    RoleName VARCHAR(20) NOT NULL
);

CREATE TABLE UserRoles (
	UserName varchar(20) NOT NULL,
	RoleName varchar(20) NOT NULL
);

INSERT INTO Users (UserName, FirstName, LastName, Email, Password, Phone) VALUES
('user', 'Scott', 'Lonsdale', 'scott@gmail.com', 'user', '012345678'),
('admin', 'Ben', 'Perkins', 'ben@gmail.com', 'admin', '000'),
('staff', 'Bryce', 'Tuppurainen', 'bryce@uon.edu.au', 'staff', '000');

INSERT INTO Roles (RoleName) VALUES
('STAFF'),
('MEMBER');

INSERT INTO UserRoles (UserName, RoleName) VALUES
('user', 'MEMBER'),
('admin', 'STAFF'),
('staff', 'STAFF');


CREATE TABLE MaintenanceEvents (  Maintenanceid  INT                IDENTITY(1,1) PRIMARY KEY,
                                   MaintenanceTitle VARCHAR(128)    NOT NULL,
                                   StartDate VARCHAR(40)            NOT NULL,
                                   EndDate VARCHAR(40)              NOT NULL,
                                   MaintenanceCreatedAt DATETIME    NOT NULL DEFAULT getdate()
);
