-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Des 2021 pada 17.15
-- Versi server: 10.4.18-MariaDB
-- Versi PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pegawai`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `idPegawai` int(20) NOT NULL,
  `namaPegawai` varchar(20) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `jumlahHariMasuk` int(20) NOT NULL,
  `gajiPokok` varchar(20) NOT NULL,
  `potongan` varchar(20) NOT NULL,
  `totalGaji` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`idPegawai`, `namaPegawai`, `jabatan`, `jumlahHariMasuk`, `gajiPokok`, `potongan`, `totalGaji`) VALUES
(20001, 'Raidha', 'Direktur Utama', 30, '8000000', '0', '8000000'),
(20011, 'Sasuke', 'Direktur Personalia', 27, '6000000', '600000', '5400000'),
(20012, 'Sakura', 'Manager', 22, '5000000', '1333333', '3666667'),
(20013, 'Hinata', 'Karyawan', 15, '3000000', '1500000', '1500000'),
(20015, 'Tobi', 'Karyawan', 20, '3000000', '1000000', '2000000');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`idPegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
