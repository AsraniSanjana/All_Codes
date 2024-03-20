-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 17, 2024 at 07:11 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hostel_ms`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `dept_id` varchar(5) NOT NULL,
  `ADMIN_NAME` varchar(30) NOT NULL,
  `DEPT_NAME` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dept_id`, `ADMIN_NAME`, `DEPT_NAME`) VALUES
('D1', 'PERSON A', 'CMPN'),
('D2', 'PERSON B', 'EXTC'),
('D3', 'PERSON C', 'IT'),
('D4', 'PERSON D', 'ETRX');

-- --------------------------------------------------------

--
-- Table structure for table `id_of_students_in_a_room`
--

CREATE TABLE `id_of_students_in_a_room` (
  `room_id` varchar(5) NOT NULL,
  `STUDENT_1_ID` varchar(5) DEFAULT NULL,
  `STUDENT_2_ID` varchar(5) DEFAULT NULL,
  `STUDENT_3_ID` varchar(5) DEFAULT NULL,
  `STUDENT_4_ID` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `id_of_students_in_a_room`
--

INSERT INTO `id_of_students_in_a_room` (`room_id`, `STUDENT_1_ID`, `STUDENT_2_ID`, `STUDENT_3_ID`, `STUDENT_4_ID`) VALUES
('R001', 'HS01', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `looks_after`
--

CREATE TABLE `looks_after` (
  `ASSIGNED_STAFF_ID` varchar(5) NOT NULL,
  `CORRESPONDING_ROOM_ID` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `looks_after`
--

INSERT INTO `looks_after` (`ASSIGNED_STAFF_ID`, `CORRESPONDING_ROOM_ID`) VALUES
('S001', 'R001'),
('S003', 'R002'),
('S001', 'R001'),
('S003', 'R002'),
('S004', 'R005');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `ROOM_ID` varchar(5) NOT NULL,
  `ROOM_NO` int(5) DEFAULT NULL,
  `ROOM_OCCUPIED` varchar(3) DEFAULT NULL,
  `MONTHLY_BILL` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`ROOM_ID`, `ROOM_NO`, `ROOM_OCCUPIED`, `MONTHLY_BILL`) VALUES
('R001', 102, 'YES', 8000),
('R002', 403, 'YES', 600),
('R003', 102, 'YES', 9800),
('R005', 201, 'YES', 9800);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `STAFF_ID` varchar(5) NOT NULL,
  `STAFF_NAME` varchar(30) NOT NULL,
  `STAFF_CONTACT_NO` int(10) DEFAULT NULL,
  `STAFF_SALARY` int(8) DEFAULT NULL,
  `STAFF_ROLE_NAME` varchar(30) NOT NULL,
  `dept_id` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`STAFF_ID`, `STAFF_NAME`, `STAFF_CONTACT_NO`, `STAFF_SALARY`, `STAFF_ROLE_NAME`, `dept_id`) VALUES
('S001', 'Jose Sellers', 1234567890, 5000, 'Janitor', 'D1'),
('S002', 'Atticus Turner', 2147483647, 7000, 'Manager', 'D1'),
('S003', 'Jessie Mcknight', 1357924680, 9000, 'Receiptionist', 'D3'),
('S004', 'Kyler Whitney', 2147483647, 5000, 'Warden', 'D3'),
('S005', 'Emmanuel Lloyd', 1616161616, 2000, 'Mess Employee', 'D2'),
('S006', 'Nigel Jennings', 2147483647, 9098, 'Councellor', 'D1'),
('S007', 'Sonia Pruitt', 2147483647, 6000, 'Gatekeeper', 'D2');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `STUD_ID` varchar(5) NOT NULL,
  `STUD_NAME` varchar(30) NOT NULL,
  `STUD_ADHAR_NO` int(12) DEFAULT NULL,
  `STUD_STAY_PERIOD` varchar(30) DEFAULT NULL,
  `STUD_GENDER` char(1) DEFAULT NULL,
  `STUD_DEPT` varchar(4) NOT NULL,
  `STUD_DOB` date DEFAULT NULL,
  `FEE_STATUS` varchar(6) NOT NULL,
  `ALLOTED_ROOM_ID` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`STUD_ID`, `STUD_NAME`, `STUD_ADHAR_NO`, `STUD_STAY_PERIOD`, `STUD_GENDER`, `STUD_DEPT`, `STUD_DOB`, `FEE_STATUS`, `ALLOTED_ROOM_ID`) VALUES
('HS01', 'SANJANA ASRANI', 2147483647, '22 MONTHS', 'F', 'D4', '0000-00-00', 'PAID', 'R001'),
('HS02', 'AMRITA ASRANI', 2147483647, '10 MONTHS', 'F', 'D4', '0000-00-00', 'PAID', 'R001'),
('HS03', 'DINESH PANCHI', 2147483647, '2 YEARS', 'M', 'D4', '0000-00-00', 'PAID', 'R002'),
('HS04', 'SONAM PANCHI', 1111111111, '1 MONTH', 'F', 'D4', '0000-00-00', 'PAID', 'R001');

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `visit_no` int(5) NOT NULL,
  `VISITOR_ID` varchar(5) DEFAULT NULL,
  `VISITOR_NAME` varchar(30) NOT NULL,
  `IN_TIME` varchar(9) DEFAULT NULL,
  `OUT_TIME` varchar(9) DEFAULT NULL,
  `VISIT_DATE` date DEFAULT NULL,
  `CUR_TIME` varchar(20) DEFAULT NULL,
  `CUR_DATE` datetime DEFAULT NULL,
  `VISITING_STUD_ID` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`visit_no`, `VISITOR_ID`, `VISITOR_NAME`, `IN_TIME`, `OUT_TIME`, `VISIT_DATE`, `CUR_TIME`, `CUR_DATE`, `VISITING_STUD_ID`) VALUES
(1, 'V001', 'JESSICA LALCHANDANI', '02:03', '04:00', '2022-01-12', '23:34:34', '2024-03-17 23:34:34', 'HS01'),
(2, 'V001', 'Mahek Budhrani', '11:43 AM', '04:38 PM', '2022-06-19', '23:34:34', '2024-03-17 23:34:34', 'HS01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dept_id`);

--
-- Indexes for table `id_of_students_in_a_room`
--
ALTER TABLE `id_of_students_in_a_room`
  ADD PRIMARY KEY (`room_id`),
  ADD KEY `STUDENT_1_ID` (`STUDENT_1_ID`),
  ADD KEY `STUDENT_2_ID` (`STUDENT_2_ID`),
  ADD KEY `STUDENT_3_ID` (`STUDENT_3_ID`),
  ADD KEY `STUDENT_4_ID` (`STUDENT_4_ID`);

--
-- Indexes for table `looks_after`
--
ALTER TABLE `looks_after`
  ADD KEY `ASSIGNED_STAFF_ID` (`ASSIGNED_STAFF_ID`),
  ADD KEY `CORRESPONDING_ROOM_ID` (`CORRESPONDING_ROOM_ID`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`ROOM_ID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`STAFF_ID`),
  ADD KEY `dept_id` (`dept_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`STUD_ID`),
  ADD KEY `STUD_DEPT` (`STUD_DEPT`);

--
-- Indexes for table `visitor`
--
ALTER TABLE `visitor`
  ADD PRIMARY KEY (`visit_no`),
  ADD KEY `VISITING_STUD_ID` (`VISITING_STUD_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `visitor`
--
ALTER TABLE `visitor`
  MODIFY `visit_no` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `id_of_students_in_a_room`
--
ALTER TABLE `id_of_students_in_a_room`
  ADD CONSTRAINT `id_of_students_in_a_room_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`ROOM_ID`),
  ADD CONSTRAINT `id_of_students_in_a_room_ibfk_2` FOREIGN KEY (`STUDENT_1_ID`) REFERENCES `student` (`STUD_ID`),
  ADD CONSTRAINT `id_of_students_in_a_room_ibfk_3` FOREIGN KEY (`STUDENT_2_ID`) REFERENCES `student` (`STUD_ID`),
  ADD CONSTRAINT `id_of_students_in_a_room_ibfk_4` FOREIGN KEY (`STUDENT_3_ID`) REFERENCES `student` (`STUD_ID`),
  ADD CONSTRAINT `id_of_students_in_a_room_ibfk_5` FOREIGN KEY (`STUDENT_4_ID`) REFERENCES `student` (`STUD_ID`);

--
-- Constraints for table `looks_after`
--
ALTER TABLE `looks_after`
  ADD CONSTRAINT `looks_after_ibfk_1` FOREIGN KEY (`ASSIGNED_STAFF_ID`) REFERENCES `staff` (`STAFF_ID`),
  ADD CONSTRAINT `looks_after_ibfk_2` FOREIGN KEY (`CORRESPONDING_ROOM_ID`) REFERENCES `room` (`ROOM_ID`);

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`DEPT_ID`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`STUD_DEPT`) REFERENCES `department` (`DEPT_ID`);

--
-- Constraints for table `visitor`
--
ALTER TABLE `visitor`
  ADD CONSTRAINT `visitor_ibfk_1` FOREIGN KEY (`VISITING_STUD_ID`) REFERENCES `student` (`STUD_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
