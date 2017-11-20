-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2015 at 04:12 PM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hello2`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('1', '1'),
('2', '2'),
('Jamil', '2746');

-- --------------------------------------------------------

--
-- Table structure for table `coach`
--

CREATE TABLE `coach` (
  `COACHID` int(11) NOT NULL,
  `COACHNAME` varchar(30) NOT NULL,
  `LOCID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coach`
--

INSERT INTO `coach` (`COACHID`, `COACHNAME`, `LOCID`) VALUES
(1, 'JORAH', 2),
(2, 'CERCIE', 4),
(3, 'VENGAAL', 1),
(4, 'MORINHO', 6),
(5, 'BENETIZ', 1),
(6, 'GOMEZ', 2),
(7, 'JAIME', 3),
(8, 'WENGER', 5);

-- --------------------------------------------------------

--
-- Table structure for table `kit`
--

CREATE TABLE `kit` (
  `KITID` int(11) NOT NULL,
  `KITCOLOR` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kit`
--

INSERT INTO `kit` (`KITID`, `KITCOLOR`) VALUES
(1, 'BLUE'),
(2, 'RED'),
(3, 'WHITE'),
(4, 'YELLOW');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `LOCID` int(11) NOT NULL,
  `LOC` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`LOCID`, `LOC`) VALUES
(1, 'England'),
(2, 'Brazil'),
(3, 'Germany'),
(4, 'Argentina'),
(5, 'Spain'),
(6, 'Netherlands');

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `OWNERID` int(11) NOT NULL,
  `OWNERNAME` varchar(30) NOT NULL,
  `LOCID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`OWNERID`, `OWNERNAME`, `LOCID`) VALUES
(1, 'ROMAN', 1),
(2, 'AMIR', 6),
(3, 'CHE LOE', 5),
(4, 'ABRAHAM ', 3),
(5, 'SIR RICHARD', 2),
(6, 'YOKOSHAMA', 5);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `PLAYERID` int(11) NOT NULL,
  `PLAYERNAME` varchar(30) NOT NULL,
  `LOCID` int(11) NOT NULL,
  `GOALSCORED` int(11) NOT NULL,
  `ASSISTS` int(11) NOT NULL,
  `SAVES` int(11) NOT NULL,
  `TEAMID` int(11) NOT NULL,
  `SPONSORID` int(11) NOT NULL,
  `POSITION` varchar(30) NOT NULL,
  `AGE` int(11) NOT NULL,
  `HEIGHT` varchar(30) NOT NULL,
  `WEIGHT` varchar(30) NOT NULL,
  `KITNUMBER` int(11) NOT NULL,
  `Img` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`PLAYERID`, `PLAYERNAME`, `LOCID`, `GOALSCORED`, `ASSISTS`, `SAVES`, `TEAMID`, `SPONSORID`, `POSITION`, `AGE`, `HEIGHT`, `WEIGHT`, `KITNUMBER`, `Img`) VALUES
(1, 'EDEN HAZARD', 1, 25, 15, 0, 2, 4, 'MIDFIELDER', 25, '5 FT 8 IN', '69kg', 10, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p1.png'),
(2, 'IVANOVIC', 1, 7, 2, 0, 2, 4, 'DEFENDER', 25, '5 FT 9 IN', '70kg', 2, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p2.png'),
(3, 'COURTOIS', 1, 0, 0, 5, 2, 4, 'GOALKEEPER', 26, '6 FT ', '70 kg', 28, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p3.png'),
(4, 'OSCAR', 1, 6, 4, 0, 2, 4, 'MIDFIELDER', 24, '5 FT 11 IN', '67 kg', 11, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p4.png'),
(5, 'DIEGO COSTA', 1, 5, 7, 0, 2, 4, 'STRIKER', 27, '5 FT 9 IN', '66kg', 19, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p5.png'),
(6, 'SERGIO ROMERO', 2, 0, 0, 5, 3, 6, 'GOAL KEEPER', 26, '6 FT 1 IN', '72 kg', 22, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p6.png'),
(7, 'MARCOS ROJO', 2, 0, 2, 0, 3, 6, 'DEFENDER', 25, '5 FT 10 IN', '69 kg', 5, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p7.png'),
(8, 'JUAN MATA', 2, 3, 5, 0, 3, 6, 'MIDFIELDER', 27, '5 FT 11 IN', '67 kg', 8, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p8.png'),
(9, 'Bastian Schweinsteiger	', 2, 4, 6, 0, 3, 6, 'MIDFIELDER', 26, '6 FT', '72 kg', 31, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p9.png'),
(10, 'WAYNE ROONEY', 2, 6, 3, 0, 3, 6, 'STRIKER', 30, '5 FT 11 IN', '68 kg', 10, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p10.png'),
(11, 'Petr Cech', 1, 0, 0, 4, 1, 2, 'GOAL KEEPER', 28, '6 FT', '72 kg', 1, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p11.png'),
(12, 'Mikel Arteta', 1, 1, 2, 0, 1, 2, 'MIDFIELDER', 28, '5 FT 8 IN', '65 kg', 8, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p12.png'),
(13, 'Mesut Özil', 1, 3, 4, 0, 1, 2, 'MIDFIELDER', 26, '5 FT 9 IN', '67 kg', 11, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p13.png'),
(14, 'JACK WILSHERE', 1, 3, 4, 0, 1, 2, 'MIDFIELDER', 24, '5 FT 8 IN', '68 KG', 10, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p14.png'),
(15, 'AARON RAMSEY', 1, 3, 4, 5, 1, 2, 'MIDFIELDER', 24, '5 FT 8 IN', '65 kg', 16, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p15.png'),
(16, 'JOE HART', 2, 0, 0, 3, 4, 3, 'GOALKEEPER', 26, '6 FT', '70 kg', 1, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p16.png'),
(17, 'BACARY SAGNA', 2, 0, 2, 0, 4, 3, 'DEFENDER', 29, '5 FT 9 IN', '69kg', 3, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p17.png'),
(18, 'DAVID SILVA', 2, 2, 2, 0, 4, 3, 'MIDFIELDER', 30, '5 FT 9 IN', '68 kg', 21, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p18.png'),
(19, 'SAMIR NASRI', 2, 2, 4, 0, 4, 3, 'MIDFIELDER', 25, '5 FT 10 IN', '69 kg', 8, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p19.png'),
(20, 'SERGIO AGUERO', 2, 2, 1, 0, 4, 3, 'STRIKER', 25, '5 FT 11 IN', '67 kg', 16, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p20.png'),
(21, 'SIMON ', 3, 0, 0, 2, 5, 1, 'GOALKEEPER', 25, '5 FT 11 IN', '69 kg', 22, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p21.png'),
(22, 'NATHANIEL', 3, 0, 1, 0, 5, 1, 'DEFENDER', 23, '5 FT 10 IN', '70 kg', 2, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p22.png'),
(23, 'JOSE ENRIQUE', 3, 0, 2, 0, 5, 1, '', 23, '5 FT 8 IN', '70 kg', 3, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p23.png'),
(24, 'COUTINHO', 3, 2, 1, 0, 5, 1, 'MIDFIELDER', 25, '5 FT 10 IN', '70 kg', 10, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p24.png'),
(25, 'BENTEKE', 3, 1, 2, 0, 5, 1, 'STRIKER', 25, '5 FT 11 IN', '69 kg', 20, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p25.png'),
(26, 'HUGO', 1, 0, 0, 2, 6, 2, 'GOALKEEPER', 24, '5 FT 9 IN', '66 kg', 25, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p26.png'),
(27, 'KYLE WALKER', 1, 0, 3, 0, 6, 2, 'DEFENDER', 24, '5 FT 10 IN', '66 kg', 2, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p27.png'),
(28, 'RYAN MASON', 1, 3, 1, 0, 6, 2, 'MIDFIELDER', 24, '5 FT 9 IN', '67 kg', 38, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p28.png'),
(29, 'ERIK LAMELA', 1, 3, 1, 0, 6, 2, 'STRIKER', 24, '5 FT 11 IN', '70 kg', 11, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p29.png'),
(30, 'HARY KANE', 1, 2, 1, 0, 6, 2, 'STRIKER', 25, '5 FT 10 IN', '68 kg', 37, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p30.png'),
(31, 'ELDIN', 5, 0, 0, 2, 7, 1, 'GOALKEEPER', 25, '5 FT 10 IN', '67 kg', 11, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p31.png'),
(32, 'HARRY', 5, 1, 2, 0, 7, 1, 'DEFENDER', 25, '5 FT 10 IN', '69 kg', 19, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p32.png'),
(33, 'ROBERT', 5, 1, 2, 0, 7, 1, 'MIDFIELDER', 24, '5 FT 8 IN', '70 kg', 23, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p33.png'),
(34, 'SHAUN', 5, 1, 2, 0, 7, 1, 'MIDFIELDER', 25, '5 FT 10 IN', '70 kg', 28, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p34.png'),
(35, 'ABEL HARNANDEZ', 5, 3, 1, 0, 7, 1, 'STRIKER', 26, '5 FT 11 IN', '70 kg', 11, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p35.png'),
(36, 'JOEL ', 6, 0, 0, 2, 8, 4, 'GOALKEEPER', 24, '5 FT 10 IN', '70 kg', 1, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p36.png'),
(37, 'tony blair', 6, 0, 1, 0, 8, 4, 'DEFENDER', 25, '5 FT 9 IN', '90', 2, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p37.png'),
(38, 'GIBSON', 6, 1, 2, 0, 8, 4, 'MIDFIELDER', 25, '5 FT 8 IN', '68 kg', 4, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p38.png'),
(39, 'BARRY', 6, 2, 3, 0, 8, 4, 'MIDFIELDER', 25, '5 FT 11 IN', '68 kg', 18, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p39.png'),
(40, 'ROMELU', 6, 3, 2, 0, 8, 4, 'STRIKER', 25, '5 FT 10 IN', '66 kg', 17, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\Player\\p40.png');

-- --------------------------------------------------------

--
-- Table structure for table `sponsor`
--

CREATE TABLE `sponsor` (
  `SPONSORID` int(11) NOT NULL,
  `SPONSORNAME` varchar(30) NOT NULL,
  `LOCID` int(11) NOT NULL,
  `OWNERID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sponsor`
--

INSERT INTO `sponsor` (`SPONSORID`, `SPONSORNAME`, `LOCID`, `OWNERID`) VALUES
(1, 'NIKE', 2, 1),
(2, 'ADDIDAS', 2, 4),
(3, 'PUMA', 3, 2),
(4, 'REEBOK', 4, 3),
(5, 'SAMSUNG', 1, 4),
(6, 'FLYEMIRATES', 6, 6);

-- --------------------------------------------------------

--
-- Table structure for table `stadium`
--

CREATE TABLE `stadium` (
  `STADIUMID` int(11) NOT NULL,
  `STADIUMNAME` varchar(30) NOT NULL,
  `LOCID` int(11) NOT NULL,
  `CAPACITY` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stadium`
--

INSERT INTO `stadium` (`STADIUMID`, `STADIUMNAME`, `LOCID`, `CAPACITY`) VALUES
(1, 'STAMFORD BRIDGE', 1, 80000),
(2, 'EMIRATES STADIUM', 1, 90000),
(3, 'OLD TRAFORD STADIUM', 2, 75000),
(4, 'ETIHAD STADIUM', 2, 100000),
(5, 'ANFIELD STADIUM', 3, 97500),
(6, 'WHITE HART-LANE', 1, 50000),
(7, 'KC STADIUM', 5, 47000),
(8, 'GOODISON PARK', 6, 49000);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `TEAMID` int(11) NOT NULL,
  `TEAMNAME` varchar(30) NOT NULL,
  `STADIUMID` int(11) NOT NULL,
  `COACHID` int(11) NOT NULL,
  `GAMEPLAYED` int(11) NOT NULL,
  `GAMEWON` int(11) NOT NULL,
  `GAMELOST` int(11) NOT NULL,
  `GAMEDRAWN` int(11) NOT NULL,
  `SPONSORID` int(11) NOT NULL,
  `KITID` int(11) NOT NULL,
  `OWNERID` int(11) NOT NULL,
  `teamlogo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`TEAMID`, `TEAMNAME`, `STADIUMID`, `COACHID`, `GAMEPLAYED`, `GAMEWON`, `GAMELOST`, `GAMEDRAWN`, `SPONSORID`, `KITID`, `OWNERID`, `teamlogo`) VALUES
(1, 'ARSENAL', 2, 1, 12, 6, 2, 4, 2, 2, 2, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\t1.png'),
(2, 'CHELSEA', 1, 6, 13, 7, 3, 3, 4, 1, 4, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\t2.png'),
(3, 'MANCHESTER UNITED', 3, 7, 10, 5, 2, 3, 6, 4, 3, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\t3.png'),
(4, 'MANCHESTER CITY', 4, 8, 11, 9, 2, 0, 3, 3, 2, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\t4.png'),
(5, 'LIVERPOOL', 5, 5, 9, 4, 3, 2, 1, 1, 1, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\t5.png'),
(6, 'TOTTENHAM', 6, 3, 10, 3, 5, 2, 2, 2, 3, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\t6.png'),
(7, 'HULL CITY', 7, 4, 8, 4, 4, 0, 1, 3, 5, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\t7.png'),
(8, 'EVERTON', 8, 2, 6, 2, 1, 3, 4, 4, 6, 'D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\pics\\t8.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `coach`
--
ALTER TABLE `coach`
  ADD PRIMARY KEY (`COACHID`);

--
-- Indexes for table `kit`
--
ALTER TABLE `kit`
  ADD PRIMARY KEY (`KITID`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`LOCID`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`OWNERID`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`PLAYERID`);

--
-- Indexes for table `sponsor`
--
ALTER TABLE `sponsor`
  ADD PRIMARY KEY (`SPONSORID`);

--
-- Indexes for table `stadium`
--
ALTER TABLE `stadium`
  ADD PRIMARY KEY (`STADIUMID`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`TEAMID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `coach`
--
ALTER TABLE `coach`
  MODIFY `COACHID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `kit`
--
ALTER TABLE `kit`
  MODIFY `KITID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `LOCID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `owner`
--
ALTER TABLE `owner`
  MODIFY `OWNERID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `PLAYERID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `sponsor`
--
ALTER TABLE `sponsor`
  MODIFY `SPONSORID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `stadium`
--
ALTER TABLE `stadium`
  MODIFY `STADIUMID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `TEAMID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
