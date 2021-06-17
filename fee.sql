-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 27, 2020 at 10:03 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fee`
--

-- --------------------------------------------------------

--
-- Table structure for table `Accountant`
--

CREATE TABLE `Accountant` (
  `Acc_ID` int(10) NOT NULL,
  `Acc_Name` varchar(40) NOT NULL,
  `Acc_Password` varchar(20) NOT NULL,
  `Acc_Email` varchar(20) NOT NULL,
  `Acc_Address` varchar(50) NOT NULL,
  `Acc_Contact` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Accountant`
--

INSERT INTO `Accountant` (`Acc_ID`, `Acc_Name`, `Acc_Password`, `Acc_Email`, `Acc_Address`, `Acc_Contact`) VALUES
(101, 'Mandar', 'mk123', 'mk@gmail.com', 'pqrs', '7575807538');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `rollno` int(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL,
  `contact` int(10) NOT NULL,
  `course` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `fee` int(10) NOT NULL,
  `due` int(10) NOT NULL,
  `paid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`rollno`, `name`, `email`, `address`, `contact`, `course`, `gender`, `fee`, `due`, `paid`) VALUES
(18103602, 'Kaavya', 'kd@gmail.com', 'abcd', 987654321, 'Java', 'female', 50000, 5000, 45000),
(18103606, 'Sheldon', 'sc@gmail.com', 'qwerty', 1029384756, 'Java', 'Male', 50000, 0, 50000),
(18103633, 'Jenil', 'jm@gmail.com', 'uiop', 1234567890, 'Java', 'Male', 30000, 5000, 25000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Accountant`
--
ALTER TABLE `Accountant`
  ADD PRIMARY KEY (`Acc_ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`rollno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
