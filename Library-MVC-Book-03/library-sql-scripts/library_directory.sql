CREATE DATABASE  IF NOT EXISTS `library_directory`;
USE `library_directory`;

--
-- Table structure for table `library`
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
	(3,'Lee','Child');
    
    
    

