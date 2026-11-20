package rekammedis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Operasi verifikasi SOAP yang selalu memeriksa ulang kewenangan DPJP di database. */
public final class SoapVerifikasiDPJP {
    public static final class DataVerifikasi {
        public final String kodeDokter;
        public final String namaDokter;
        public final String waktu;
        DataVerifikasi(String kodeDokter, String namaDokter, String waktu) {
            this.kodeDokter = kodeDokter;
            this.namaDokter = namaDokter;
            this.waktu = waktu;
        }
    }


    /** Informasi status terakhir verifikasi SOAP untuk tampilan baca. */
    public static final class DataStatus {
        public final String status;
        public final String kodeDokter;
        public final String namaDokter;
        public final String waktu;

        DataStatus(String status, String kodeDokter, String namaDokter, String waktu) {
            this.status = status;
            this.kodeDokter = kodeDokter;
            this.namaDokter = namaDokter;
            this.waktu = waktu;
        }
    }

    /** Membaca status terakhir tanpa mengubah data atau kewenangan DPJP. */
    public static DataStatus cariStatus(Connection koneksi, String jenis,
            String noRawat, String tanggal, String jam) throws SQLException {
        String sql = "select v.status,v.kd_dokter,d.nm_dokter,"
                + "date_format(v.waktu_verifikasi,'%Y-%m-%d %H:%i:%s') waktu "
                + "from soap_verifikasi_dpjp v "
                + "left join dokter d on d.kd_dokter=v.kd_dokter "
                + "where v.jenis_rawat=? and v.no_rawat=? "
                + "and v.tgl_perawatan=? and v.jam_rawat=?";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, jenis);
            ps.setString(2, noRawat);
            ps.setString(3, tanggal);
            ps.setString(4, jam);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? new DataStatus(
                        rs.getString("status"),
                        rs.getString("kd_dokter"),
                        rs.getString("nm_dokter"),
                        rs.getString("waktu")) : null;
            }
        }
    }

    private SoapVerifikasiDPJP() { }

    static boolean bolehVerifikasi(Connection koneksi, String jenis, String noRawat, String kdDokter) throws SQLException {
        return dpjpBertanggungJawab(koneksi, jenis, noRawat, kdDokter);
    }

    static boolean bolehVerifikasiTanggal(Connection koneksi, String tanggal, String kdDokter) throws SQLException {
        String sql = "select 1 from pemeriksaan_ralan p inner join reg_periksa r on r.no_rawat=p.no_rawat "
                + "where p.tgl_perawatan=? and r.kd_dokter=? union all "
                + "select 1 from pemeriksaan_ranap p inner join dpjp_ranap d on d.no_rawat=p.no_rawat "
                + "where p.tgl_perawatan=? and d.kd_dokter=? limit 1";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, tanggal); ps.setString(2, kdDokter); ps.setString(3, tanggal); ps.setString(4, kdDokter);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        }
    }

    static int[] hitungStatusTanggal(Connection koneksi, String tanggal, String kdDokter) throws SQLException {
        String sql = "select sum(case when v.status='Aktif' then 0 else 1 end) belum, "
                + "sum(case when v.status='Aktif' then 1 else 0 end) sudah from ("
                + "select 'Ralan' jenis,p.no_rawat,p.tgl_perawatan,p.jam_rawat from pemeriksaan_ralan p "
                + "inner join reg_periksa r on r.no_rawat=p.no_rawat where p.tgl_perawatan=? and r.kd_dokter=? "
                + "union all select 'Ranap' jenis,p.no_rawat,p.tgl_perawatan,p.jam_rawat from pemeriksaan_ranap p "
                + "inner join dpjp_ranap d on d.no_rawat=p.no_rawat where p.tgl_perawatan=? and d.kd_dokter=?"
                + ") s left join soap_verifikasi_dpjp v on v.jenis_rawat=s.jenis and v.no_rawat=s.no_rawat "
                + "and v.tgl_perawatan=s.tgl_perawatan and v.jam_rawat=s.jam_rawat";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, tanggal); ps.setString(2, kdDokter); ps.setString(3, tanggal); ps.setString(4, kdDokter);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return new int[]{rs.getInt("belum"), rs.getInt("sudah")};
            }
        }
        return new int[]{0, 0};
    }

    public static DataVerifikasi cari(Connection koneksi, String jenis, String noRawat, String tanggal, String jam) throws SQLException {
        String sql = "select v.kd_dokter,d.nm_dokter,date_format(v.waktu_verifikasi,'%Y-%m-%d %H:%i:%s') waktu "
                + "from soap_verifikasi_dpjp v left join dokter d on d.kd_dokter=v.kd_dokter "
                + "where v.jenis_rawat=? and v.no_rawat=? and v.tgl_perawatan=? and v.jam_rawat=? and v.status='Aktif'";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, jenis); ps.setString(2, noRawat); ps.setString(3, tanggal); ps.setString(4, jam);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? new DataVerifikasi(rs.getString("kd_dokter"), rs.getString("nm_dokter"), rs.getString("waktu")) : null;
            }
        }
    }

    static int verifikasiTanggal(Connection koneksi, String jenis, String noRawat, String tanggal, String kdDokter) throws SQLException {
        return ubahTanggal(koneksi, jenis, noRawat, tanggal, kdDokter, true, "");
    }

    static int cabutTanggal(Connection koneksi, String jenis, String noRawat, String tanggal, String kdDokter, String alasan) throws SQLException {
        return ubahTanggal(koneksi, jenis, noRawat, tanggal, kdDokter, false, alasan);
    }

    static boolean verifikasiSatu(Connection koneksi, String jenis, String noRawat, String tanggal, String jam, String kdDokter) throws SQLException {
        return ubahSatu(koneksi, jenis, noRawat, tanggal, jam, kdDokter, true, "");
    }

    static boolean cabutSatu(Connection koneksi, String jenis, String noRawat, String tanggal, String jam, String kdDokter, String alasan) throws SQLException {
        return ubahSatu(koneksi, jenis, noRawat, tanggal, jam, kdDokter, false, alasan);
    }

    private static int ubahTanggal(Connection koneksi, String jenis, String noRawat, String tanggal,
            String kdDokter, boolean verifikasi, String alasan) throws SQLException {
        boolean autoCommit = koneksi.getAutoCommit();
        koneksi.setAutoCommit(false);
        int jumlah = 0;
        try {
            String tabel = "Ralan".equals(jenis) ? "pemeriksaan_ralan" : "pemeriksaan_ranap";
            String sql = "select no_rawat,tgl_perawatan,jam_rawat from " + tabel + " where tgl_perawatan=?"
                    + ((noRawat == null || noRawat.trim().isEmpty()) ? "" : " and no_rawat=?")
                    + " order by no_rawat,jam_rawat";
            List<String[]> kunci = new ArrayList<String[]>();
            try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
                ps.setString(1, tanggal);
                if (noRawat != null && !noRawat.trim().isEmpty()) ps.setString(2, noRawat);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) kunci.add(new String[]{rs.getString(1), rs.getString(2), rs.getString(3)});
                }
            }
            for (String[] k : kunci) {
                if (ubahSatuDalamTransaksi(koneksi, jenis, k[0], k[1], k[2], kdDokter, verifikasi, alasan)) jumlah++;
            }
            koneksi.commit();
            return jumlah;
        } catch (SQLException e) {
            koneksi.rollback(); throw e;
        } finally {
            koneksi.setAutoCommit(autoCommit);
        }
    }

    private static boolean ubahSatu(Connection koneksi, String jenis, String noRawat, String tanggal,
            String jam, String kdDokter, boolean verifikasi, String alasan) throws SQLException {
        boolean autoCommit = koneksi.getAutoCommit();
        koneksi.setAutoCommit(false);
        try {
            boolean berubah = ubahSatuDalamTransaksi(koneksi, jenis, noRawat, tanggal, jam, kdDokter, verifikasi, alasan);
            koneksi.commit();
            return berubah;
        } catch (SQLException e) {
            koneksi.rollback(); throw e;
        } finally {
            koneksi.setAutoCommit(autoCommit);
        }
    }

    private static boolean ubahSatuDalamTransaksi(Connection koneksi, String jenis, String noRawat,
            String tanggal, String jam, String kdDokter, boolean verifikasi, String alasan) throws SQLException {
        if (!dpjpBertanggungJawab(koneksi, jenis, noRawat, kdDokter)) return false;
        String sql = "select 1 from " + ("Ralan".equals(jenis) ? "pemeriksaan_ralan" : "pemeriksaan_ranap")
                + " where no_rawat=? and tgl_perawatan=? and jam_rawat=? for update";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, noRawat); ps.setString(2, tanggal); ps.setString(3, jam);
            try (ResultSet rs = ps.executeQuery()) { if (!rs.next()) return false; }
        }
        try (PreparedStatement ps = koneksi.prepareStatement("select status from soap_verifikasi_dpjp where jenis_rawat=? and no_rawat=? and tgl_perawatan=? and jam_rawat=? for update")) {
            ps.setString(1, jenis); ps.setString(2, noRawat); ps.setString(3, tanggal); ps.setString(4, jam);
            try (ResultSet rs = ps.executeQuery()) {
                if (verifikasi && rs.next() && "Aktif".equals(rs.getString(1))) return false;
                if (!verifikasi && (!rs.next() || !"Aktif".equals(rs.getString(1)))) return false;
            }
        }
        String statusBaru = verifikasi ? "Aktif" : "Dicabut";
        String sqlStatus = "insert into soap_verifikasi_dpjp(jenis_rawat,no_rawat,tgl_perawatan,jam_rawat,kd_dokter,waktu_verifikasi,status,waktu_perubahan) "
                + "values(?,?,?,?,?,now(),?,now()) on duplicate key update kd_dokter=values(kd_dokter),"
                + "waktu_verifikasi=if(values(status)='Aktif',now(),waktu_verifikasi),status=values(status),waktu_perubahan=now()";
        try (PreparedStatement ps = koneksi.prepareStatement(sqlStatus)) {
            ps.setString(1, jenis); ps.setString(2, noRawat); ps.setString(3, tanggal); ps.setString(4, jam);
            ps.setString(5, kdDokter); ps.setString(6, statusBaru); ps.executeUpdate();
        }
        try (PreparedStatement ps = koneksi.prepareStatement("insert into soap_verifikasi_dpjp_audit(jenis_rawat,no_rawat,tgl_perawatan,jam_rawat,aksi,kd_dokter,waktu,alasan) values(?,?,?,?,?,?,now(),?)")) {
            ps.setString(1, jenis); ps.setString(2, noRawat); ps.setString(3, tanggal); ps.setString(4, jam);
            ps.setString(5, verifikasi ? "Verifikasi" : "Pencabutan"); ps.setString(6, kdDokter);
            ps.setString(7, alasan == null ? "" : alasan.trim()); ps.executeUpdate();
        }
        return true;
    }

    private static boolean dpjpBertanggungJawab(Connection koneksi, String jenis, String noRawat, String kdDokter) throws SQLException {
        String sql = "Ralan".equals(jenis)
                ? "select 1 from reg_periksa where no_rawat=? and kd_dokter=?"
                : "select 1 from dpjp_ranap where no_rawat=? and kd_dokter=?";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, noRawat); ps.setString(2, kdDokter);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        }
    }


    /** Edit SOAP dan cabut verifikasi lama dalam satu transaksi. */
    static boolean editSOAP(Connection koneksi, String jenis, String noRawat,
            String tanggal, String jam, String kdDokter, String keluhan,
            String pemeriksaan, String penilaian, String rtl,
            String instruksi, String evaluasi) throws SQLException {

        if (!"Ralan".equals(jenis) && !"Ranap".equals(jenis))
            throw new SQLException("Jenis rawat tidak valid.");

        String tabel = "Ralan".equals(jenis)
                ? "pemeriksaan_ralan" : "pemeriksaan_ranap";

        boolean autoCommit = koneksi.getAutoCommit();
        koneksi.setAutoCommit(false);
        boolean berhasil = false;

        try {
            String[] lama = new String[6];

            String baca = "select keluhan,pemeriksaan,penilaian,rtl,instruksi,evaluasi "
                    + "from " + tabel
                    + " where no_rawat=? and tgl_perawatan=? and jam_rawat=? for update";

            try (PreparedStatement ps = koneksi.prepareStatement(baca)) {
                ps.setString(1, noRawat);
                ps.setString(2, tanggal);
                ps.setString(3, jam);

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next())
                        throw new SQLException("Data SOAP tidak ditemukan.");

                    for (int i = 0; i < 6; i++)
                        lama[i] = rs.getString(i + 1);
                }
            }

            // Periksa ulang kewenangan DPJP setelah baris SOAP dikunci.
            if (!dpjpBertanggungJawab(koneksi, jenis, noRawat, kdDokter))
                throw new SQLException("Akun bukan DPJP penanggung jawab.");

            String[] baru = {
                keluhan == null ? "" : keluhan,
                pemeriksaan == null ? "" : pemeriksaan,
                penilaian == null ? "" : penilaian,
                rtl == null ? "" : rtl,
                instruksi == null ? "" : instruksi,
                evaluasi == null ? "" : evaluasi
            };

            for (String v : baru) {
                if (v.length() > 2000)
                    throw new SQLException("Maksimal 2.000 karakter per kolom.");
            }

            for (int i = 2; i < 6; i++) {
                if (baru[i].trim().isEmpty())
                    throw new SQLException(
                        "Asesmen, Plan, Instruksi, dan Evaluasi wajib diisi.");
            }

            boolean sama = true;
            for (int i = 0; i < 6; i++) {
                if (!java.util.Objects.equals(lama[i], baru[i])) {
                    sama = false;
                    break;
                }
            }

            if (sama) {
                koneksi.commit();
                return false;
            }

            String update = "update " + tabel
                    + " set keluhan=?,pemeriksaan=?,penilaian=?,rtl=?,instruksi=?,evaluasi=? "
                    + "where no_rawat=? and tgl_perawatan=? and jam_rawat=?";

            try (PreparedStatement ps = koneksi.prepareStatement(update)) {
                for (int i = 0; i < 6; i++)
                    ps.setString(i + 1, baru[i]);

                ps.setString(7, noRawat);
                ps.setString(8, tanggal);
                ps.setString(9, jam);

                if (ps.executeUpdate() != 1)
                    throw new SQLException("Update SOAP gagal.");
            }

            String bacaStatus = "select status from soap_verifikasi_dpjp "
                    + "where jenis_rawat=? and no_rawat=? "
                    + "and tgl_perawatan=? and jam_rawat=? for update";

            try (PreparedStatement ps = koneksi.prepareStatement(bacaStatus)) {
                ps.setString(1, jenis);
                ps.setString(2, noRawat);
                ps.setString(3, tanggal);
                ps.setString(4, jam);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next() && "Aktif".equals(rs.getString(1))) {

                        String cabut = "update soap_verifikasi_dpjp "
                                + "set status='Dicabut',waktu_perubahan=now() "
                                + "where jenis_rawat=? and no_rawat=? "
                                + "and tgl_perawatan=? and jam_rawat=? "
                                + "and status='Aktif'";

                        try (PreparedStatement up = koneksi.prepareStatement(cabut)) {
                            up.setString(1, jenis);
                            up.setString(2, noRawat);
                            up.setString(3, tanggal);
                            up.setString(4, jam);

                            if (up.executeUpdate() != 1)
                                throw new SQLException("Pencabutan verifikasi gagal.");
                        }

                        String audit = "insert into soap_verifikasi_dpjp_audit "
                                + "(jenis_rawat,no_rawat,tgl_perawatan,jam_rawat,"
                                + "aksi,kd_dokter,waktu,alasan) "
                                + "values(?,?,?,?,?,?,now(),?)";

                        try (PreparedStatement au = koneksi.prepareStatement(audit)) {
                            au.setString(1, jenis);
                            au.setString(2, noRawat);
                            au.setString(3, tanggal);
                            au.setString(4, jam);
                            au.setString(5, "Pencabutan");
                            au.setString(6, kdDokter);
                            au.setString(7, "SOAP diubah; wajib verifikasi ulang");
                            au.executeUpdate();
                        }
                    }
                }
            }

            koneksi.commit();
            berhasil = true;

        } catch (SQLException ex) {
            koneksi.rollback();
            throw ex;
        } finally {
            koneksi.setAutoCommit(autoCommit);
        }

        // Catat aktivitas setelah transaksi SOAP berhasil.
        // Isi klinis SOAP tidak pernah dimasukkan ke trackersql.
        if (berhasil) {
            catatAktivitasEditSOAP(jenis, noRawat, tanggal, jam);
        }

        return berhasil;
    }

    private static void catatAktivitasEditSOAP(
            String jenis, String noRawat, String tanggal, String jam) {

        if (!"yes".equals(fungsi.koneksiDB.AKTIFKANTRACKSQL()))
            return;

        String aktivitas = fungsi.akses.getalamatip()
                + " EDIT SOAP DPJP jenis=" + jenis
                + " no_rawat=" + noRawat
                + " tanggal=" + tanggal
                + " jam=" + jam;

        String sql = "insert into trackersql values(now(),?,?)";

        try (Connection logKoneksi = fungsi.koneksiDB.condb();
             PreparedStatement ps = logKoneksi.prepareStatement(sql)) {

            ps.setString(1, aktivitas);
            ps.setString(2, fungsi.akses.getkode());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Gagal mencatat aktivitas Edit SOAP: " + ex);
        }
    }

}
