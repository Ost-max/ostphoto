-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: 10.0.6.93
-- Generation Time: Oct 04, 2013 at 05:57 PM
-- Server version: 5.5.29-0ubuntu0.12.04.1
-- PHP Version: 5.3.10-1ubuntu3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `d697cce2ac6a44417a9ba071ee422a01b`
--

-- --------------------------------------------------------

--
-- Table structure for table `Category`
--

CREATE TABLE IF NOT EXISTS `Category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `comment` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_2` (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `Category`
--

INSERT INTO `Category` (`id`, `name`, `comment`) VALUES
(1, 'all', ''),
(2, 'none', ''),
(3, 'portrait', NULL),
(4, 'autumn', NULL),
(5, 'landscape', NULL),
(6, 'autumn', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Photo`
--

CREATE TABLE IF NOT EXISTS `Photo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `Comment` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `Photo`
--

INSERT INTO `Photo` (`id`, `fileName`, `Comment`, `update`) VALUES
(2, '722145714154750215347335754561620.jpg', NULL, '2013-10-03'),
(3, '39ac4382.jpg', NULL, '2013-10-03'),
(4, '222dcd1a.jpg', NULL, '2013-10-03'),
(5, '4b97c159.jpg', NULL, '2013-10-03');

-- --------------------------------------------------------

--
-- Table structure for table `Photo_Cat`
--

CREATE TABLE IF NOT EXISTS `Photo_Cat` (
  `id` int(11) NOT NULL,
  `cat` int(10) NOT NULL,
  `photo` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `meeting_date` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fio` VARCHAR(45) NOT NULL,
  `meetingDate` DATE NOT NULL,
  `startTime` TIME NULL,
  `endTime` TIME NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
