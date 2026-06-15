-- ==========================================
-- DROP & CREATE DATABASE
-- ==========================================

USE master;
GO

IF EXISTS (
    SELECT *
    FROM sys.databases
    WHERE name = 'CarRentingSystem_DB'
)
BEGIN
    ALTER DATABASE CarRentingSystem_DB
    SET SINGLE_USER
    WITH ROLLBACK IMMEDIATE;

    DROP DATABASE CarRentingSystem_DB;
END
GO

CREATE DATABASE CarRentingSystem_DB;
GO

USE CarRentingSystem_DB;
GO

-- ==========================================
-- ACCOUNT
-- ==========================================

CREATE TABLE Account (
    AccountID INT PRIMARY KEY,
    AccountName NVARCHAR(100) NOT NULL,
    Role NVARCHAR(50) NOT NULL
);
GO

-- ==========================================
-- CAR PRODUCER
-- ==========================================

CREATE TABLE CarProducer (
    ProducerID INT PRIMARY KEY,
    ProducerName NVARCHAR(100) NOT NULL,
    Address NVARCHAR(255) NOT NULL,
    Country NVARCHAR(100) NOT NULL
);
GO

-- ==========================================
-- CAR
-- ==========================================

CREATE TABLE Car (
    CarID INT PRIMARY KEY,
    CarName NVARCHAR(100) NOT NULL,
    CarModelYear INT NOT NULL,
    Color NVARCHAR(50) NOT NULL,
    Capacity INT NOT NULL,
    Description NVARCHAR(1000) NOT NULL,
    ImportDate DATE NOT NULL,
    ProducerID INT NOT NULL,
    RentPrice DECIMAL(18,2) NOT NULL,
    Status NVARCHAR(50) NOT NULL,

    CONSTRAINT FK_Car_Producer
        FOREIGN KEY (ProducerID)
        REFERENCES CarProducer(ProducerID)
);
GO

-- ==========================================
-- CUSTOMER
-- ==========================================

CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY,
    CustomerName NVARCHAR(100) NOT NULL,
    Mobile VARCHAR(20) NOT NULL,
    Birthday DATE NOT NULL,
    IdentityCard VARCHAR(20) NOT NULL,
    LicenceNumber VARCHAR(50) NOT NULL,
    LicenceDate DATE NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    AccountID INT NOT NULL,

    CONSTRAINT UQ_Customer_Email
        UNIQUE (Email),

    CONSTRAINT UQ_Customer_Mobile
        UNIQUE (Mobile),

    CONSTRAINT UQ_Customer_IdentityCard
        UNIQUE (IdentityCard),

    CONSTRAINT UQ_Customer_LicenceNumber
        UNIQUE (LicenceNumber),

    CONSTRAINT FK_Customer_Account
        FOREIGN KEY (AccountID)
        REFERENCES Account(AccountID)
);
GO

-- ==========================================
-- CAR RENTAL
-- PK(CustomerID, CarID, PickupDate)
-- ==========================================

CREATE TABLE CarRental (
    CustomerID INT NOT NULL,
    CarID INT NOT NULL,
    PickupDate DATE NOT NULL,
    ReturnDate DATE NOT NULL,
    RentPrice DECIMAL(18,2) NOT NULL,
    Status NVARCHAR(50) NOT NULL,

    CONSTRAINT PK_CarRental
        PRIMARY KEY (CustomerID, CarID, PickupDate),

    CONSTRAINT FK_CarRental_Customer
        FOREIGN KEY (CustomerID)
        REFERENCES Customer(CustomerID),

    CONSTRAINT FK_CarRental_Car
        FOREIGN KEY (CarID)
        REFERENCES Car(CarID),

    CONSTRAINT CK_CarRental_Date
        CHECK (PickupDate < ReturnDate)
);
GO

-- ==========================================
-- REVIEW
-- ==========================================

CREATE TABLE Review (
    CustomerID INT NOT NULL,
    CarID INT NOT NULL,
    ReviewStar INT NOT NULL,
    Comment NVARCHAR(1000) NOT NULL,

    CONSTRAINT PK_Review
        PRIMARY KEY (CustomerID, CarID),

    CONSTRAINT FK_Review_Customer
        FOREIGN KEY (CustomerID)
        REFERENCES Customer(CustomerID),

    CONSTRAINT FK_Review_Car
        FOREIGN KEY (CarID)
        REFERENCES Car(CarID),

    CONSTRAINT CK_Review_Star
        CHECK (ReviewStar BETWEEN 1 AND 5)
);
GO
