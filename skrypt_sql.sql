-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Wersja serwera:               10.1.31-MariaDB - mariadb.org binary distribution
-- Serwer OS:                    Win32
-- HeidiSQL Wersja:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Zrzut struktury bazy danych telnetbot
CREATE DATABASE IF NOT EXISTS `telnetbot` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci */;
USE `telnetbot`;

-- Zrzut struktury tabela telnetbot.telnet_cmd
CREATE TABLE IF NOT EXISTS `telnet_cmd` (
  `cmd_id` int(11) DEFAULT NULL,
  `lp` varchar(6) COLLATE utf8_polish_ci DEFAULT NULL,
  `type` varchar(6) COLLATE utf8_polish_ci DEFAULT NULL,
  `arg1` varchar(50) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Data exporting was unselected.
-- Zrzut struktury tabela telnetbot.telnet_comm_block
CREATE TABLE IF NOT EXISTS `telnet_comm_block` (
  `id_cb` int(11) DEFAULT NULL,
  `lp` int(11) DEFAULT NULL,
  `type` varchar(2) COLLATE utf8_polish_ci DEFAULT NULL,
  `wait_str` varchar(50) COLLATE utf8_polish_ci DEFAULT NULL,
  `cmd` varchar(50) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Data exporting was unselected.
-- Zrzut struktury tabela telnetbot.telnet_device
CREATE TABLE IF NOT EXISTS `telnet_device` (
  `lp` int(11) NOT NULL AUTO_INCREMENT,
  `device` varchar(50) COLLATE utf8_polish_ci DEFAULT '',
  `socket` varchar(10) COLLATE utf8_polish_ci DEFAULT '',
  `user` varchar(50) COLLATE utf8_polish_ci DEFAULT '',
  `pass` varchar(50) COLLATE utf8_polish_ci DEFAULT '',
  `lo` varchar(50) COLLATE utf8_polish_ci DEFAULT '',
  `pa` varchar(50) COLLATE utf8_polish_ci DEFAULT '',
  `cmd_id` varchar(50) COLLATE utf8_polish_ci DEFAULT '',
  KEY `lp` (`lp`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
