package rekammedis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public final class EditSOAPDPJP extends JDialog {

    private final Connection koneksi;
    private final String jenis, noRawat, tanggal, jam, kdDokter;

    private final JTextArea keluhan = area();
    private final JTextArea pemeriksaan = area();
    private final JTextArea penilaian = area();
    private final JTextArea rtl = area();
    private final JTextArea instruksi = area();
    private final JTextArea evaluasi = area();

    private static JTextArea area() {
        JTextArea a = new JTextArea(5, 35);
        a.setLineWrap(true);
        a.setWrapStyleWord(true);
        a.setFont(new Font("SansSerif", Font.PLAIN, 14));
        a.setBorder(new EmptyBorder(7, 8, 7, 8));
        return a;
    }

    public EditSOAPDPJP(JDialog parent, boolean modal, Connection koneksi,
            String jenis, String noRawat, String tanggal, String jam,
            String kdDokter) {

        super(parent, modal);

        this.koneksi = koneksi;
        this.jenis = jenis;
        this.noRawat = noRawat;
        this.tanggal = tanggal;
        this.jam = jam;
        this.kdDokter = kdDokter;

        setTitle("Edit SOAP DPJP - " + jenis);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // HEADER IDENTITAS SOAP
        JPanel header = new JPanel(new BorderLayout(5, 5));
        header.setBorder(new EmptyBorder(12, 16, 12, 16));

        JLabel judul = new JLabel("EDIT SOAP DPJP");
        judul.setFont(new Font("SansSerif", Font.BOLD, 17));

        JLabel identitas = new JLabel(
                "No. Rawat: " + noRawat
                + "     |     Tanggal: " + tanggal
                + "     |     Jam: " + jam
        );
        identitas.setFont(new Font("SansSerif", Font.PLAIN, 13));

        header.add(judul, BorderLayout.NORTH);
        header.add(identitas, BorderLayout.SOUTH);

        // FORM LANDSCAPE: 2 KOLOM X 3 BARIS
        JPanel isi = new JPanel(new GridLayout(3, 2, 12, 12));
        isi.setBorder(new EmptyBorder(12, 16, 12, 16));

        tambah(isi, "1. Subjek / Keluhan", keluhan);
        tambah(isi, "2. Objek / Pemeriksaan", pemeriksaan);
        tambah(isi, "3. Asesmen / Penilaian", penilaian);
        tambah(isi, "4. Plan / RTL", rtl);
        tambah(isi, "5. Instruksi / Implementasi", instruksi);
        tambah(isi, "6. Evaluasi", evaluasi);

        JScrollPane scroll = new JScrollPane(isi);
        scroll.setBorder(BorderFactory.createEmptyBorder());

        // FOOTER
        JPanel footer = new JPanel(new BorderLayout());
        footer.setBorder(new EmptyBorder(8, 16, 12, 16));

        JLabel catatan = new JLabel(
                "<html><font color='#8A6500'>"
                + "Perubahan pada SOAP yang sudah diverifikasi "
                + "akan mencabut verifikasi lama dan mewajibkan verifikasi ulang."
                + "</font></html>"
        );
        catatan.setFont(new Font("SansSerif", Font.PLAIN, 11));

        JPanel tombol = new JPanel();
        JButton simpan = new JButton("Simpan Perubahan");
        JButton batal = new JButton("Batal");

        simpan.setFont(new Font("SansSerif", Font.BOLD, 13));
        batal.setFont(new Font("SansSerif", Font.PLAIN, 13));

        simpan.setPreferredSize(new Dimension(165, 36));
        batal.setPreferredSize(new Dimension(100, 36));

        tombol.add(simpan);
        tombol.add(batal);

        footer.add(catatan, BorderLayout.CENTER);
        footer.add(tombol, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);

        batal.addActionListener(e -> dispose());
        simpan.addActionListener(e -> simpan());

        try {
            if (!SoapVerifikasiDPJP.bolehVerifikasi(
                    koneksi, jenis, noRawat, kdDokter)) {
                throw new Exception(
                        "Akun bukan DPJP penanggung jawab."
                );
            }

            muat();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    parent,
                    "Tidak dapat membuka SOAP: " + ex.getMessage(),
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
            );
            dispose();
            return;
        }

        setMinimumSize(new Dimension(900, 650));
        setSize(1100, 760);
        setLocationRelativeTo(parent);
    }

    private static void tambah(JPanel p, String label, JTextArea a) {
        JPanel field = new JPanel(new BorderLayout(4, 6));

        JLabel judul = new JLabel(label);
        judul.setFont(new Font("SansSerif", Font.BOLD, 13));

        JScrollPane scroll = new JScrollPane(a);
        scroll.setPreferredSize(new Dimension(400, 125));

        field.add(judul, BorderLayout.NORTH);
        field.add(scroll, BorderLayout.CENTER);

        p.add(field);
    }

    private String tabel() throws Exception {
        if ("Ralan".equals(jenis)) {
            return "pemeriksaan_ralan";
        }

        if ("Ranap".equals(jenis)) {
            return "pemeriksaan_ranap";
        }

        throw new Exception("Jenis rawat tidak valid.");
    }

    private static String nilai(String s) {
        return s == null ? "" : s;
    }

    private void muat() throws Exception {
        String sql = "select keluhan,pemeriksaan,penilaian,rtl,"
                + "instruksi,evaluasi from " + tabel()
                + " where no_rawat=? and tgl_perawatan=? and jam_rawat=?";

        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, noRawat);
            ps.setString(2, tanggal);
            ps.setString(3, jam);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    throw new Exception("Data SOAP tidak ditemukan.");
                }

                keluhan.setText(nilai(rs.getString(1)));
                pemeriksaan.setText(nilai(rs.getString(2)));
                penilaian.setText(nilai(rs.getString(3)));
                rtl.setText(nilai(rs.getString(4)));
                instruksi.setText(nilai(rs.getString(5)));
                evaluasi.setText(nilai(rs.getString(6)));
            }
        }
    }

    private void simpan() {
        String[] v = {
            keluhan.getText(),
            pemeriksaan.getText(),
            penilaian.getText(),
            rtl.getText(),
            instruksi.getText(),
            evaluasi.getText()
        };

        for (String x : v) {
            if (x.length() > 2000) {
                JOptionPane.showMessageDialog(
                        this,
                        "Maksimal 2.000 karakter per kolom.",
                        "Validasi",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
        }

        for (int i = 2; i < 6; i++) {
            if (v[i].trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Asesmen, Plan, Instruksi, dan Evaluasi wajib diisi.",
                        "Validasi",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
        }

        // KONFIRMASI SEBELUM PENYIMPANAN
        String pesan = "<html>"
                + "<b>Apakah Anda yakin ingin menyimpan perubahan SOAP ini?</b>"
                + "<br><br>"
                + "No. Rawat: " + noRawat
                + "<br>Tanggal: " + tanggal
                + "<br>Jam: " + jam
                + "<br><br>"
                + "<font color='#A06000'>"
                + "Jika SOAP sudah diverifikasi, verifikasi lama akan dicabut "
                + "dan harus dilakukan verifikasi ulang."
                + "</font></html>";

        int konfirmasi = JOptionPane.showConfirmDialog(
                this,
                pesan,
                "Konfirmasi Perubahan SOAP",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (konfirmasi != JOptionPane.YES_OPTION) {
            return;
        }

        // LOGIKA PENYIMPANAN ASLI TETAP DIPAKAI
        try {
            boolean ok = SoapVerifikasiDPJP.editSOAP(
                    koneksi,
                    jenis,
                    noRawat,
                    tanggal,
                    jam,
                    kdDokter,
                    v[0],
                    v[1],
                    v[2],
                    v[3],
                    v[4],
                    v[5]
            );

            if (ok) {
                JOptionPane.showMessageDialog(
                        this,
                        "SOAP berhasil diperbarui.\n"
                        + "Jika sebelumnya terverifikasi, verifikasi lama "
                        + "telah dicabut dan wajib diverifikasi ulang.",
                        "Berhasil",
                        JOptionPane.INFORMATION_MESSAGE
                );
                dispose();

            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Tidak ada perubahan atau akun bukan DPJP "
                        + "penanggung jawab.",
                        "Informasi",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Gagal menyimpan SOAP: " + ex.getMessage(),
                    "Kesalahan",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
