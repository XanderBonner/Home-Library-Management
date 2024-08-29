CREATE DATABASE  IF NOT EXISTS `library_directory`;
USE `library_directory`;
SET FOREIGN_KEY_CHECKS = 0;
--
-- Table structure for table `library`
--


--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `AuthorID` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`AuthorID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `author`
--

INSERT INTO `author` VALUES 
	(1,'Jack','Carr'),
	(2,'Brad','Thor'),
	(3,'Lee','Child'),
	(4,'J.K.','Rowling');
    
--
-- Table structure for table `publishers`
--

DROP TABLE IF EXISTS `publisher`;

CREATE TABLE `publisher` (
  `PublisherID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  `Address` VARCHAR(255),
  `Phone` VARCHAR(20),
  PRIMARY KEY (`PublisherID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `publisher`
--

INSERT INTO `publisher` VALUES
	(1,'Simon & Schuster','1515 Broadway, New York, NY 10036','800-223-2336');
    
    

--
-- Table structure for table `book`
--    

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `BookID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(255) NOT NULL,
  `author_ID` INT,
  `publisher_ID` INT,
  `ISBN` VARCHAR(20),
  `publication_year` INT,
  `Bookcategory` VARCHAR(20),
  PRIMARY KEY (`BookID`),
  UNIQUE KEY `TITLE_UNIQUE` (`Title`),
  KEY `FK_AUTHOR_IDX`(`author_ID`),
  KEY `FK_PUBLISHER_IDX`(`publisher_ID`),
  CONSTRAINT `FK_AUTHOR` FOREIGN KEY (`author_ID`) REFERENCES `author`(`AuthorID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PUBLISHER` FOREIGN KEY (`publisher_ID`) REFERENCES `publisher`(`PublisherID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;    

--
-- Data for table `book`
--

INSERT INTO `book` VALUES 
	(1,'The Terminal List: A Thriller',1,1,'9783986760168',2018,'Thriller'),
    (2,'Harry Potter and the Sorcerers Stone',4,1,'9788869183157',1997,'Fantasy');
    
--
-- Table structure for table `member`
--    

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `MemberID` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL UNIQUE,
  `password` VARCHAR(68) NOT NULL,
  `active` TINYINT NOT NULL,
  `First_Name` VARCHAR(255) NOT NULL,
  `Last_Name` VARCHAR(255) NOT NULL,
  `Address` VARCHAR(255),
  `Member_Email` VARCHAR(100),
  PRIMARY KEY (`MemberID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;    

--
-- Data for table `member`
--

INSERT INTO `member` VALUES 
	(1,'xander','{bcrypt}$2a$10$2htqZu1Wta.TIu91dfIan.AXftLPdbS1wMqRMFhV4vopAK3H5k2kS',1, 'Xander', 'Bonner', '900 W 26th St, Austin, TX','Xander@gmail.com'),
    (2,'kyleigh','{bcrypt}$2a$10$2htqZu1Wta.TIu91dfIan.AXftLPdbS1wMqRMFhV4vopAK3H5k2kS',1, 'Kyleigh', 'Roberts', '300 Victory Lane, Dallas, TX','Kyleigh@gmail.com'),
    (3,'jeff','{bcrypt}$2a$10$2htqZu1Wta.TIu91dfIan.AXftLPdbS1wMqRMFhV4vopAK3H5k2kS',1, 'Jeff', 'Roberts', '100 Kobe Lane, Bluffton, SC','Jeff@gmail.com'),
    (4,'michelle', '{bcrypt}$2a$10$2htqZu1Wta.TIu91dfIan.AXftLPdbS1wMqRMFhV4vopAK3H5k2kS', 1, 'Michelle', 'Roberts', '100 Kobe Lane, Bluffton, SC', 'Michelle@example.com');
    

--
-- Table structure for table `roles`
--    

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `username` VARCHAR(50) NOT NULL UNIQUE,
  `role` VARCHAR(68) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`role`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `member`(`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;    

--
-- Data for table `authorities`
--

INSERT INTO `roles` VALUES 
    ('xander', 'ROLE_MEMBER'),
    ('kyleigh', 'ROLE_MEMBER'),
    ('jeff', 'ROLE_MEMBER'),
    ('michelle', 'ROLE_LIBRARIAN');
    
    

