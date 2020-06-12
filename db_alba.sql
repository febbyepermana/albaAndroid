-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 12 Jun 2020 pada 15.26
-- Versi server: 10.4.10-MariaDB
-- Versi PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_alba`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemain`
--

CREATE TABLE `pemain` (
  `id` int(11) NOT NULL,
  `foto` varchar(100) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `posisi` varchar(50) NOT NULL,
  `dribling` char(55) NOT NULL,
  `vo2max` char(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pemain`
--

INSERT INTO `pemain` (`id`, `foto`, `nama`, `tanggal_lahir`, `posisi`, `dribling`, `vo2max`) VALUES
(2, '', 'Messi', '2020-06-09', 'Depan', '', ''),
(3, '', 'wiwiw', '2020-06-11', 'Belakang', '', ''),
(4, '', 'Azka', '2020-06-13', 'Depan', '', ''),
(5, '', 'Aziz', '2020-02-04', 'Belakang', '', ''),
(6, '', 'Gonzales', '2020-06-19', 'Depan', '', ''),
(7, '', 'Ahmad', '2020-01-16', 'Depan', '', ''),
(8, '', 'Ilham', '1998-02-14', 'Depan', '', ''),
(11, '', 'Agil', '1998-04-15', 'Belakang', '', ''),
(43, '', 'Tatang', '2020-06-02', 'Depan', '', ''),
(47, '', 'jeje', '0000-00-00', 'Penjaga Gawang', '', '');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `pemain`
--
ALTER TABLE `pemain`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `pemain`
--
ALTER TABLE `pemain`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
