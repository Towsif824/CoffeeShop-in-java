-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2019 at 12:21 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `b04`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cId` varchar(6) NOT NULL,
  `customerName` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL,
  `bill` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cId`, `customerName`, `address`, `bill`) VALUES
('c00001', 'superMan', '19/2A', 300.00),
('c00002', 'batMan', 'Kuratoli', 230.20),
('c00003', 'wonderWoman', 'Dhanmondi', 450.00),
('c00004', 'aquaMan', 'Kumilla', 750.00),
('c00005', 'Flash', 'chittagong', 330.20);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `empId` varchar(6) NOT NULL,
  `employeeName` varchar(30) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`empId`, `employeeName`, `designation`, `salary`) VALUES
('e00001', 'Cap', 'manager', 300000.00),
('e00002', 'IronMan', 'barista', 200000.00),
('e00003', 'BlackWidow', 'barista', 200000.00),
('e00004', 'Hulk', 'clerk', 155000.00),
('e00005', 'AntMan', 'clerk', 152000.00),
('e00006', 'ScarletWitch', 'clerk', 142000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(6) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('c00001', 'c12341', 2),
('c00002', 'c12342', 2),
('c00003', 'c12343', 2),
('c00004', 'c12344', 2),
('c00005', 'c12345', 2),
('e00001', '12341', 0),
('e00002', '12342', 1),
('e00003', '12343', 1),
('e00004', '12344', 1),
('e00005', '12345', 1),
('e00006', '12102729', 1);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `pId` varchar(6) NOT NULL,
  `productName` varchar(20) NOT NULL,
  `quantity` int(5) NOT NULL,
  `price` double(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`pId`, `productName`, `quantity`, `price`) VALUES
('p00001', 'coffee', 1, 250.00),
('p00002', 'cookies', 1, 80.20),
('p00003', 'latteCoffee', 1, 150.50),
('p00004', 'cappuccino', 1, 220.00),
('p00005', 'iceCream', 1, 250.00);

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `prId` varchar(6) NOT NULL,
  `pId` varchar(6) NOT NULL,
  `cId` varchar(20) NOT NULL,
  `quantity` int(10) NOT NULL,
  `price` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`prId`, `pId`, `cId`, `quantity`, `price`) VALUES
('pr0001', 'p00002', 'c00001', 3, 240.60),
('pr0002', 'p00004', 'c00002', 3, 500.00),
('pr0003', 'p00003', 'c00005', 5, 752.50),
('pr0004', 'p00001', 'c00004', 3, 750.00),
('pr0005', 'p00001', 'c00002', 2, 300.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cId`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`empId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`pId`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`prId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
