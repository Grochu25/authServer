-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 26 Mar 2025, 19:54
-- Wersja serwera: 10.4.8-MariaDB
-- Wersja PHP: 7.2.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `library_users_credentials`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `credentials`
--

CREATE TABLE `credentials` (
  `login` varchar(50) NOT NULL,
  `passwd` varchar(80) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `credentials`
--

INSERT INTO `credentials` (`login`, `passwd`, `role`) VALUES
('adam@gmail.com', '$2a$10$S//jf5mb4bl.buHw9sWkeOdqvuGwqQAKQZRG/KDBqDTv.V6ytfEQ6', 'USER'),
('admin', '$2a$12$e93rU79gvAE/i6xrRSCXauB2VquOgQw.iU8Vfa8MzTkZG7dd81PXi', 'ADMIN'),
('agnieszka@gmail.com', '$2a$10$exq807pctrgGdhTnuTqdne2g.P87qATqk9C8weyb3JrQ2wiMkEAyS', 'USER'),
('stefan@gmail.com', '$2a$10$exq807pctrgGdhTnuTqdne2g.P87qATqk9C8weyb3JrQ2wiMkEAyS', 'USER');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `credentials`
--
ALTER TABLE `credentials`
  ADD PRIMARY KEY (`login`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
