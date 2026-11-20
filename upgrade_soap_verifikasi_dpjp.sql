-- Jalankan sekali pada database SIMRS sebelum membuka fitur verifikasi SOAP.
-- Tabel utama menyimpan status terakhir; tabel audit menyimpan semua aksinya.
CREATE TABLE IF NOT EXISTS `soap_verifikasi_dpjp` (
  `jenis_rawat` enum('Ralan','Ranap') NOT NULL,
  `no_rawat` varchar(17) NOT NULL,
  `tgl_perawatan` date NOT NULL,
  `jam_rawat` time NOT NULL,
  `kd_dokter` varchar(20) NOT NULL,
  `waktu_verifikasi` datetime NOT NULL,
  `status` enum('Aktif','Dicabut') NOT NULL DEFAULT 'Aktif',
  `waktu_perubahan` datetime NOT NULL,
  PRIMARY KEY (`jenis_rawat`,`no_rawat`,`tgl_perawatan`,`jam_rawat`),
  KEY `kd_dokter` (`kd_dokter`),
  KEY `waktu_verifikasi` (`waktu_verifikasi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `soap_verifikasi_dpjp_audit` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `jenis_rawat` enum('Ralan','Ranap') NOT NULL,
  `no_rawat` varchar(17) NOT NULL,
  `tgl_perawatan` date NOT NULL,
  `jam_rawat` time NOT NULL,
  `aksi` enum('Verifikasi','Pencabutan') NOT NULL,
  `kd_dokter` varchar(20) NOT NULL,
  `waktu` datetime NOT NULL,
  `alasan` varchar(500) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `soap_key` (`jenis_rawat`,`no_rawat`,`tgl_perawatan`,`jam_rawat`),
  KEY `kd_dokter` (`kd_dokter`),
  KEY `waktu` (`waktu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
