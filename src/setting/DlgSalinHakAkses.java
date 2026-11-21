package setting;

import fungsi.akses;
import fungsi.koneksiDB;
import fungsi.sekuel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Dialog untuk menyandingkan hak akses dua user (Sumber dan Tujuan) sebelum disalin.
 * Mode yang tersedia: "Samakan persis" - hak akses Tujuan dibuat identik dengan Sumber.
 * Hanya kolom hak akses yang berubah; ID user dan password tidak disentuh.
 *
 * Daftar KOLOM harus sama dengan kolom hak akses pada DlgUser.tampil() (urutan dan nama),
 * yaitu kolom tabel "user" setelah id_user dan password.
 */
public class DlgSalinHakAkses extends JDialog {

    /** Nama kolom hak akses pada tabel user (urutan sama dengan DlgUser.tampil()). */
    static final String[] KOLOM = (
        "penyakit,obat_penyakit,dokter,jadwal_praktek,petugas,pasien,registrasi,tindakan_ralan,kamar_inap,"+
        "tindakan_ranap,operasi,rujukan_keluar,rujukan_masuk,beri_obat,resep_pulang,pasien_meninggal,diet_pasien,"+
        "kelahiran_bayi,periksa_lab,periksa_radiologi,kasir_ralan,deposit_pasien,piutang_pasien,peminjaman_berkas,"+
        "barcode,presensi_harian,presensi_bulanan,pegawai_admin,pegawai_user,suplier,satuan_barang,konversi_satuan,"+
        "jenis_barang,obat,stok_opname_obat,stok_obat_pasien,pengadaan_obat,pemesanan_obat,penjualan_obat,piutang_obat,"+
        "retur_ke_suplier,retur_dari_pembeli,retur_obat_ranap,retur_piutang_pasien,keuntungan_penjualan,"+
        "keuntungan_beri_obat,sirkulasi_obat,ipsrs_barang,ipsrs_pengadaan_barang,ipsrs_stok_keluar,"+
        "ipsrs_rekap_pengadaan,ipsrs_rekap_stok_keluar,ipsrs_pengeluaran_harian,inventaris_jenis,inventaris_kategori,"+
        "inventaris_merk,inventaris_ruang,inventaris_produsen,inventaris_koleksi,inventaris_inventaris,"+
        "inventaris_sirkulasi,parkir_jenis,parkir_in,parkir_out,parkir_rekap_harian,parkir_rekap_bulanan,"+
        "informasi_kamar,harian_tindakan_poli,obat_per_poli,obat_per_kamar,obat_per_dokter_ralan,obat_per_dokter_ranap,"+
        "harian_dokter,bulanan_dokter,harian_paramedis,bulanan_paramedis,pembayaran_ralan,pembayaran_ranap,"+
        "rekap_pembayaran_ralan,rekap_pembayaran_ranap,tagihan_masuk,tambahan_biaya,potongan_biaya,resep_obat,"+
        "resume_pasien,penyakit_ralan,penyakit_ranap,kamar,tarif_ralan,tarif_ranap,tarif_lab,tarif_radiologi,"+
        "tarif_operasi,akun_rekening,rekening_tahun,posting_jurnal,buku_besar,cashflow,keuangan,pengeluaran,setup_pjlab,"+
        "setup_otolokasi,setup_jam_kamin,setup_embalase,tracer_login,display,set_harga_obat,set_penggunaan_tarif,"+
        "set_oto_ralan,biaya_harian,biaya_masuk_sekali,set_no_rm,billing_ralan,billing_ranap,jm_ranap_dokter,igd,"+
        "barcoderalan,barcoderanap,set_harga_obat_ralan,set_harga_obat_ranap,penyakit_pd3i,surveilans_pd3i,"+
        "surveilans_ralan,diagnosa_pasien,surveilans_ranap,pny_takmenular_ranap,pny_takmenular_ralan,kunjungan_ralan,"+
        "rl32,rl33,rl37,rl38,harian_tindakan_dokter,sms,sidikjari,jam_masuk,jadwal_pegawai,parkir_barcode,set_nota,"+
        "dpjp_ranap,mutasi_barang,rl34,rl36,fee_visit_dokter,fee_bacaan_ekg,fee_rujukan_rontgen,fee_rujukan_ranap,"+
        "fee_ralan,akun_bayar,bayar_pemesanan_obat,obat_per_dokter_peresep,ipsrs_jenis_barang,pemasukan_lain,"+
        "pengaturan_rekening,closing_kasir,keterlambatan_presensi,set_harga_kamar,rekap_per_shift,bpjs_cek_nik,"+
        "bpjs_cek_kartu,bpjs_cek_riwayat,obat_per_cara_bayar,kunjungan_ranap,bayar_piutang,payment_point,"+
        "bpjs_cek_nomor_rujukan,icd9,darurat_stok,retensi_rm,temporary_presensi,jurnal_harian,sirkulasi_obat2,"+
        "edit_registrasi,bpjs_referensi_diagnosa,bpjs_referensi_poli,industrifarmasi,harian_js,bulanan_js,"+
        "harian_paket_bhp,bulanan_paket_bhp,piutang_pasien2,bpjs_referensi_faskes,bpjs_sep,pengambilan_utd,tarif_utd,"+
        "pengambilan_utd2,utd_medis_rusak,pengambilan_penunjang_utd,pengambilan_penunjang_utd2,utd_penunjang_rusak,"+
        "suplier_penunjang,utd_donor,bpjs_monitoring_klaim,utd_cekal_darah,utd_komponen_darah,utd_stok_darah,"+
        "utd_pemisahan_darah,harian_kamar,rincian_piutang_pasien,keuntungan_beri_obat_nonpiutang,reklasifikasi_ralan,"+
        "reklasifikasi_ranap,utd_penyerahan_darah,hutang_obat,riwayat_obat_alkes_bhp,sensus_harian_poli,rl4a,"+
        "aplicare_referensi_kamar,aplicare_ketersediaan_kamar,inacbg_klaim_baru_otomatis,inacbg_klaim_baru_manual,"+
        "inacbg_coder_nik,mutasi_berkas,akun_piutang,harian_kso,bulanan_kso,harian_menejemen,bulanan_menejemen,"+
        "inhealth_cek_eligibilitas,inhealth_referensi_jenpel_ruang_rawat,inhealth_referensi_poli,"+
        "inhealth_referensi_faskes,inhealth_sjp,piutang_ralan,piutang_ranap,detail_piutang_penjab,lama_pelayanan_ralan,"+
        "catatan_pasien,rl4b,rl4asebab,rl4bsebab,data_HAIs,harian_HAIs,bulanan_HAIs,hitung_bor,perusahaan_pasien,"+
        "resep_dokter,lama_pelayanan_apotek,hitung_alos,detail_tindakan,rujukan_poli_internal,rekap_poli_anak,"+
        "grafik_kunjungan_poli,grafik_kunjungan_perdokter,grafik_kunjungan_perpekerjaan,grafik_kunjungan_perpendidikan,"+
        "grafik_kunjungan_pertahun,berkas_digital_perawatan,penyakit_menular_ranap,penyakit_menular_ralan,"+
        "grafik_kunjungan_perbulan,grafik_kunjungan_pertanggal,grafik_kunjungan_demografi,"+
        "grafik_kunjungan_statusdaftartahun,grafik_kunjungan_statusdaftartahun2,grafik_kunjungan_statusdaftarbulan,"+
        "grafik_kunjungan_statusdaftarbulan2,grafik_kunjungan_statusdaftartanggal,grafik_kunjungan_statusdaftartanggal2,"+
        "grafik_kunjungan_statusbataltahun,grafik_kunjungan_statusbatalbulan,pcare_cek_penyakit,"+
        "grafik_kunjungan_statusbataltanggal,kategori_barang,golongan_barang,pemberian_obat_pertanggal,"+
        "penjualan_obat_pertanggal,pcare_cek_kesadaran,pembatalan_periksa_dokter,pembayaran_per_unit,"+
        "rekap_pembayaran_per_unit,grafik_kunjungan_percarabayar,ipsrs_pengadaan_pertanggal,ipsrs_stokkeluar_pertanggal,"+
        "grafik_kunjungan_ranaptahun,pcare_cek_rujukan,grafik_lab_ralantahun,grafik_rad_ralantahun,cek_entry_ralan,"+
        "inacbg_klaim_baru_manual2,permintaan_medis,rekap_permintaan_medis,surat_pemesanan_medis,permintaan_non_medis,"+
        "rekap_permintaan_non_medis,surat_pemesanan_non_medis,grafik_per_perujuk,bpjs_cek_prosedur,bpjs_cek_kelas_rawat,"+
        "bpjs_cek_dokter,bpjs_cek_spesialistik,bpjs_cek_ruangrawat,bpjs_cek_carakeluar,bpjs_cek_pasca_pulang,"+
        "detail_tindakan_okvk,billing_parsial,bpjs_cek_nomor_rujukan_rs,bpjs_cek_rujukan_kartu_pcare,"+
        "bpjs_cek_rujukan_kartu_rs,akses_depo_obat,bpjs_rujukan_keluar,grafik_lab_ralanbulan,pengeluaran_stok_apotek,"+
        "grafik_rad_ralanbulan,detailjmdokter2,pengaduan_pasien,grafik_lab_ralanhari,grafik_rad_ralanhari,"+
        "sensus_harian_ralan,metode_racik,pembayaran_akun_bayar,pengguna_obat_resep,rekap_pemesanan,"+
        "master_berkas_pegawai,berkas_kepegawaian,riwayat_jabatan,riwayat_pendidikan,riwayat_naik_gaji,kegiatan_ilmiah,"+
        "riwayat_penghargaan,riwayat_penelitian,penerimaan_non_medis,bayar_pesan_non_medis,hutang_barang_non_medis,"+
        "rekap_pemesanan_non_medis,insiden_keselamatan,insiden_keselamatan_pasien,grafik_ikp_pertahun,"+
        "grafik_ikp_perbulan,grafik_ikp_pertanggal,riwayat_data_batch,grafik_ikp_jenis,grafik_ikp_dampak,"+
        "piutang_akun_piutang,grafik_kunjungan_per_agama,grafik_kunjungan_per_umur,suku_bangsa,bahasa_pasien,"+
        "golongan_tni,satuan_tni,jabatan_tni,pangkat_tni,golongan_polri,satuan_polri,jabatan_polri,pangkat_polri,"+
        "cacat_fisik,grafik_kunjungan_suku,grafik_kunjungan_bahasa,booking_operasi,mapping_poli_bpjs,"+
        "grafik_kunjungan_per_cacat,barang_cssd,skdp_bpjs,booking_registrasi,bpjs_cek_propinsi,bpjs_cek_kabupaten,"+
        "bpjs_cek_kecamatan,bpjs_cek_dokterdpjp,bpjs_cek_riwayat_rujukanrs,bpjs_cek_tanggal_rujukan,permintaan_lab,"+
        "permintaan_radiologi,surat_indeks,surat_map,surat_almari,surat_rak,surat_ruang,surat_klasifikasi,surat_status,"+
        "surat_sifat,surat_balas,surat_masuk,pcare_cek_dokter,pcare_cek_poli,pcare_cek_provider,pcare_cek_statuspulang,"+
        "pcare_cek_spesialis,pcare_cek_subspesialis,pcare_cek_sarana,pcare_cek_khusus,pcare_cek_obat,pcare_cek_tindakan,"+
        "pcare_cek_faskessubspesialis,pcare_cek_faskesalihrawat,pcare_cek_faskesthalasemia,pcare_mapping_obat,"+
        "pcare_mapping_tindakan,pcare_club_prolanis,pcare_mapping_poli,pcare_kegiatan_kelompok,"+
        "pcare_mapping_tindakan_ranap,pcare_peserta_kegiatan_kelompok,sirkulasi_obat3,bridging_pcare_daftar,"+
        "pcare_mapping_dokter,ranap_per_ruang,penyakit_ranap_cara_bayar,anggota_militer_dirawat,set_input_parsial,"+
        "lama_pelayanan_radiologi,lama_pelayanan_lab,bpjs_cek_sep,catatan_perawatan,surat_keluar,kegiatan_farmasi,"+
        "stok_opname_logistik,sirkulasi_non_medis,rekap_lab_pertahun,perujuk_lab_pertahun,rekap_radiologi_pertahun,"+
        "perujuk_radiologi_pertahun,jumlah_porsi_diet,jumlah_macam_diet,payment_point2,pembayaran_akun_bayar2,"+
        "hapus_nota_salah,pengkajian_askep,hais_perbangsal,ppn_obat,saldo_akun_perbulan,display_apotek,"+
        "sisrute_referensi_faskes,sisrute_referensi_alasanrujuk,sisrute_referensi_diagnosa,sisrute_rujukan_masuk,"+
        "sisrute_rujukan_keluar,bpjs_cek_skdp,data_batch,kunjungan_permintaan_lab,kunjungan_permintaan_lab2,"+
        "kunjungan_permintaan_radiologi,kunjungan_permintaan_radiologi2,pcare_pemberian_obat,pcare_pemberian_tindakan,"+
        "pembayaran_akun_bayar3,password_asuransi,kemenkes_sitt,siranap_ketersediaan_kamar,grafik_tb_periodelaporan,"+
        "grafik_tb_rujukan,grafik_tb_riwayat,grafik_tb_tipediagnosis,grafik_tb_statushiv,grafik_tb_skoringanak,"+
        "grafik_tb_konfirmasiskoring5,grafik_tb_konfirmasiskoring6,grafik_tb_sumberobat,grafik_tb_hasilakhirpengobatan,"+
        "grafik_tb_hasilteshiv,kadaluarsa_batch,sisa_stok,obat_per_resep,pemakaian_air_pdam,limbah_b3_medis,"+
        "grafik_air_pdam_pertanggal,grafik_air_pdam_perbulan,grafik_limbahb3_pertanggal,grafik_limbahb3_perbulan,"+
        "limbah_domestik,grafik_limbahdomestik_pertanggal,grafik_limbahdomestik_perbulan,mutu_air_limbah,pest_control,"+
        "ruang_perpustakaan,kategori_perpustakaan,jenis_perpustakaan,pengarang_perpustakaan,penerbit_perpustakaan,"+
        "koleksi_perpustakaan,inventaris_perpustakaan,set_peminjaman_perpustakaan,denda_perpustakaan,"+
        "anggota_perpustakaan,peminjaman_perpustakaan,bayar_denda_perpustakaan,ebook_perpustakaan,jenis_cidera_k3rs,"+
        "penyebab_k3rs,jenis_luka_k3rs,lokasi_kejadian_k3rs,dampak_cidera_k3rs,jenis_pekerjaan_k3rs,bagian_tubuh_k3rs,"+
        "peristiwa_k3rs,grafik_k3_pertahun,grafik_k3_perbulan,grafik_k3_pertanggal,grafik_k3_perjeniscidera,"+
        "grafik_k3_perpenyebab,grafik_k3_perjenisluka,grafik_k3_lokasikejadian,grafik_k3_dampakcidera,"+
        "grafik_k3_perjenispekerjaan,grafik_k3_perbagiantubuh,jenis_cidera_k3rstahun,penyebab_k3rstahun,"+
        "jenis_luka_k3rstahun,lokasi_kejadian_k3rstahun,dampak_cidera_k3rstahun,jenis_pekerjaan_k3rstahun,"+
        "bagian_tubuh_k3rstahun,sekrining_rawat_jalan,bpjs_histori_pelayanan,rekap_mutasi_berkas,"+
        "skrining_ralan_pernapasan_pertahun,pengajuan_barang_medis,pengajuan_barang_nonmedis,"+
        "grafik_kunjungan_ranapbulan,grafik_kunjungan_ranaptanggal,grafik_kunjungan_ranap_peruang,"+
        "kunjungan_bangsal_pertahun,grafik_jenjang_jabatanpegawai,grafik_bidangpegawai,grafik_departemenpegawai,"+
        "grafik_pendidikanpegawai,grafik_sttswppegawai,grafik_sttskerjapegawai,grafik_sttspulangranap,kip_pasien_ranap,"+
        "kip_pasien_ralan,bpjs_mapping_dokterdpjp,data_triase_igd,master_triase_skala1,master_triase_skala2,"+
        "master_triase_skala3,master_triase_skala4,master_triase_skala5,master_triase_pemeriksaan,"+
        "master_triase_macamkasus,rekap_permintaan_diet,daftar_pasien_ranap,daftar_pasien_ranaptni,"+
        "pengajuan_asetinventaris,item_apotek_jenis,item_apotek_kategori,item_apotek_golongan,"+
        "item_apotek_industrifarmasi,10_obat_terbanyak_poli,grafik_pengajuan_aset_urgensi,grafik_pengajuan_aset_status,"+
        "grafik_pengajuan_aset_departemen,rekap_pengajuan_aset_departemen,grafik_kelompok_jabatanpegawai,"+
        "grafik_resiko_kerjapegawai,grafik_emergency_indexpegawai,grafik_inventaris_ruang,harian_HAIs2,"+
        "grafik_inventaris_jenis,data_resume_pasien,perkiraan_biaya_ranap,rekap_obat_poli,rekap_obat_pasien,"+
        "permintaan_perbaikan_inventaris,grafik_HAIs_pasienbangsal,grafik_HAIs_pasienbulan,grafik_HAIs_laju_vap,"+
        "grafik_HAIs_laju_iad,grafik_HAIs_laju_pleb,grafik_HAIs_laju_isk,grafik_HAIs_laju_ilo,grafik_HAIs_laju_hap,"+
        "inhealth_mapping_poli,inhealth_mapping_dokter,inhealth_mapping_tindakan_ralan,inhealth_mapping_tindakan_ranap,"+
        "inhealth_mapping_tindakan_radiologi,inhealth_mapping_tindakan_laborat,inhealth_mapping_tindakan_operasi,"+
        "hibah_obat_bhp,asal_hibah,asuhan_gizi,inhealth_kirim_tagihan,sirkulasi_obat4,sirkulasi_obat5,"+
        "sirkulasi_non_medis2,monitoring_asuhan_gizi,penerimaan_obat_perbulan,rekap_kunjungan,surat_sakit,"+
        "penilaian_awal_keperawatan_ralan,permintaan_diet,master_masalah_keperawatan,pengajuan_cuti,kedatangan_pasien,"+
        "utd_pendonor,toko_suplier,toko_jenis,toko_set_harga,toko_barang,penagihan_piutang_pasien,"+
        "akun_penagihan_piutang,stok_opname_toko,toko_riwayat_barang,toko_surat_pemesanan,toko_pengajuan_barang,"+
        "toko_penerimaan_barang,toko_pengadaan_barang,toko_hutang,toko_bayar_pemesanan,toko_member,toko_penjualan,"+
        "registrasi_poli_per_tanggal,toko_piutang,toko_retur_beli,ipsrs_returbeli,ipsrs_riwayat_barang,pasien_corona,"+
        "toko_pendapatan_harian,diagnosa_pasien_corona,perawatan_pasien_corona,penilaian_awal_keperawatan_gigi,"+
        "master_masalah_keperawatan_gigi,toko_bayar_piutang,toko_piutang_harian,toko_penjualan_harian,deteksi_corona,"+
        "penilaian_awal_keperawatan_kebidanan,pengumuman_epasien,surat_hamil,set_tarif_online,booking_periksa,"+
        "toko_sirkulasi,toko_retur_jual,toko_retur_piutang,toko_sirkulasi2,toko_keuntungan_barang,"+
        "zis_pengeluaran_penerima_dankes,zis_penghasilan_penerima_dankes,zis_ukuran_rumah_penerima_dankes,"+
        "zis_dinding_rumah_penerima_dankes,zis_lantai_rumah_penerima_dankes,zis_atap_rumah_penerima_dankes,"+
        "zis_kepemilikan_rumah_penerima_dankes,zis_kamar_mandi_penerima_dankes,zis_dapur_rumah_penerima_dankes,"+
        "zis_kursi_rumah_penerima_dankes,zis_kategori_phbs_penerima_dankes,zis_elektronik_penerima_dankes,"+
        "zis_ternak_penerima_dankes,zis_jenis_simpanan_penerima_dankes,penilaian_awal_keperawatan_anak,"+
        "zis_kategori_asnaf_penerima_dankes,master_masalah_keperawatan_anak,master_imunisasi,"+
        "zis_patologis_penerima_dankes,pcare_cek_kartu,surat_bebas_narkoba,surat_keterangan_covid,pemakaian_air_tanah,"+
        "grafik_air_tanah_pertanggal,grafik_air_tanah_perbulan,lama_pelayanan_poli,hemodialisa,laporan_tahunan_irj,"+
        "grafik_harian_hemodialisa,grafik_bulanan_hemodialisa,grafik_tahunan_hemodialisa,grafik_bulanan_meninggal,"+
        "perbaikan_inventaris,surat_cuti_hamil,permintaan_stok_obat_pasien,pemeliharaan_inventaris,"+
        "klasifikasi_pasien_ranap,bulanan_klasifikasi_pasien_ranap,harian_klasifikasi_pasien_ranap,"+
        "klasifikasi_pasien_perbangsal,soap_perawatan,klaim_rawat_jalan,skrining_gizi,lama_penyiapan_rm,dosis_radiologi,"+
        "demografi_umur_kunjungan,jam_diet_pasien,rvu_bpjs,verifikasi_penerimaan_farmasi,verifikasi_penerimaan_logistik,"+
        "pemeriksaan_lab_pa,ringkasan_pengajuan_obat,ringkasan_pemesanan_obat,ringkasan_pengadaan_obat,"+
        "ringkasan_penerimaan_obat,ringkasan_hibah_obat,ringkasan_penjualan_obat,ringkasan_beri_obat,"+
        "ringkasan_piutang_obat,ringkasan_stok_keluar_obat,ringkasan_retur_suplier_obat,ringkasan_retur_pembeli_obat,"+
        "penilaian_awal_keperawatan_ranapkebidanan,ringkasan_pengajuan_nonmedis,ringkasan_pemesanan_nonmedis,"+
        "ringkasan_pengadaan_nonmedis,ringkasan_penerimaan_nonmedis,ringkasan_stokkeluar_nonmedis,"+
        "ringkasan_returbeli_nonmedis,omset_penerimaan,validasi_penagihan_piutang,permintaan_ranap,bpjs_diagnosa_prb,"+
        "bpjs_obat_prb,bpjs_surat_kontrol,penggunaan_bhp_ok,surat_keterangan_rawat_inap,surat_keterangan_sehat,"+
        "pendapatan_per_carabayar,akun_host_to_host_bank_jateng,pembayaran_bank_jateng,bpjs_surat_pri,"+
        "ringkasan_tindakan,lama_pelayanan_pasien,surat_sakit_pihak_2,tagihan_hutang_obat,referensi_mobilejkn_bpjs,"+
        "batal_pendaftaran_mobilejkn_bpjs,lama_operasi,grafik_inventaris_kategori,grafik_inventaris_merk,"+
        "grafik_inventaris_produsen,pengembalian_deposit_pasien,validasi_tagihan_hutang_obat,piutang_obat_belum_lunas,"+
        "integrasi_briapi,pengadaan_aset_inventaris,akun_aset_inventaris,suplier_inventaris,penerimaan_aset_inventaris,"+
        "bayar_pemesanan_iventaris,hutang_aset_inventaris,hibah_aset_inventaris,titip_faktur_non_medis,"+
        "validasi_tagihan_non_medis,titip_faktur_aset,validasi_tagihan_aset,hibah_non_medis,pcare_alasan_tacc,"+
        "resep_luar,surat_bebas_tbc,surat_buta_warna,surat_bebas_tato,surat_kewaspadaan_kesehatan,"+
        "grafik_porsidiet_pertanggal,grafik_porsidiet_perbulan,grafik_porsidiet_pertahun,grafik_porsidiet_perbangsal,"+
        "penilaian_awal_medis_ralan,master_masalah_keperawatan_mata,penilaian_awal_keperawatan_mata,"+
        "penilaian_awal_medis_ranap,penilaian_awal_medis_ranap_kebidanan,penilaian_awal_medis_ralan_kebidanan,"+
        "penilaian_awal_medis_igd,penilaian_awal_medis_ralan_anak,bpjs_referensi_poli_hfis,bpjs_referensi_dokter_hfis,"+
        "bpjs_referensi_jadwal_hfis,penilaian_fisioterapi,bpjs_program_prb,bpjs_suplesi_jasaraharja,"+
        "bpjs_data_induk_kecelakaan,bpjs_sep_internal,bpjs_klaim_jasa_raharja,bpjs_daftar_finger_print,"+
        "bpjs_rujukan_khusus,pemeliharaan_gedung,grafik_perbaikan_inventaris_pertanggal,"+
        "grafik_perbaikan_inventaris_perbulan,grafik_perbaikan_inventaris_pertahun,"+
        "grafik_perbaikan_inventaris_perpelaksana_status,penilaian_mcu,peminjam_piutang,piutang_lainlain,cara_bayar,"+
        "audit_kepatuhan_apd,bpjs_task_id,bayar_piutang_lain,pembayaran_akun_bayar4,stok_akhir_farmasi_pertanggal,"+
        "riwayat_kamar_pasien,uji_fungsi_kfr,hapus_berkas_digital_perawatan,kategori_pengeluaran_harian,"+
        "kategori_pemasukan_lain,pembayaran_akun_bayar5,ruang_ok,telaah_resep,jasa_tindakan_pasien,"+
        "permintaan_resep_pulang,rekap_jm_dokter,status_data_rm,ubah_petugas_lab_pk,ubah_petugas_lab_pa,"+
        "ubah_petugas_radiologi,gabung_norawat,gabung_rm,ringkasan_biaya_obat_pasien_pertanggal,"+
        "master_masalah_keperawatan_igd,penilaian_awal_keperawatan_igd,bpjs_referensi_dpho_apotek,"+
        "bpjs_referensi_poli_apotek,bayar_jm_dokter,bpjs_referensi_faskes_apotek,bpjs_referensi_spesialistik_apotek,"+
        "pembayaran_briva,penilaian_awal_keperawatan_ranap,nilai_penerimaan_vendor_farmasi_perbulan,akun_bayar_hutang,"+
        "master_rencana_keperawatan,laporan_tahunan_igd,obat_bhp_tidakbergerak,ringkasan_hutang_vendor_farmasi,"+
        "nilai_penerimaan_vendor_nonmedis_perbulan,ringkasan_hutang_vendor_nonmedis,master_rencana_keperawatan_anak,"+
        "anggota_polri_dirawat,daftar_pasien_ranap_polri,soap_ralan_polri,soap_ranap_polri,laporan_penyakit_polri,"+
        "jumlah_pengunjung_ralan_polri,catatan_observasi_igd,catatan_observasi_ranap,catatan_observasi_ranap_kebidanan,"+
        "catatan_observasi_ranap_postpartum,penilaian_awal_medis_ralan_tht,penilaian_psikologi,audit_cuci_tangan_medis,"+
        "audit_pembuangan_limbah,ruang_audit_kepatuhan,audit_pembuangan_benda_tajam,audit_penanganan_darah,"+
        "audit_pengelolaan_linen_kotor,audit_penempatan_pasien,audit_kamar_jenazah,audit_bundle_iadp,audit_bundle_ido,"+
        "audit_fasilitas_kebersihan_tangan,audit_fasilitas_apd,audit_pembuangan_limbah_cair_infeksius,"+
        "audit_sterilisasi_alat,penilaian_awal_medis_ralan_psikiatri,persetujuan_penolakan_tindakan,audit_bundle_isk,"+
        "audit_bundle_plabsi,audit_bundle_vap,akun_host_to_host_bank_papua,pembayaran_bank_papua,"+
        "penilaian_awal_medis_ralan_penyakit_dalam,penilaian_awal_medis_ralan_mata,penilaian_awal_medis_ralan_neurologi,"+
        "sirkulasi_obat6,penilaian_awal_medis_ralan_orthopedi,penilaian_awal_medis_ralan_bedah,"+
        "integrasi_khanza_health_services,soap_ralan_tni,soap_ranap_tni,jumlah_pengunjung_ralan_tni,"+
        "laporan_penyakit_tni,catatan_keperawatan_ranap,master_rencana_keperawatan_gigi,master_rencana_keperawatan_mata,"+
        "master_rencana_keperawatan_igd,master_masalah_keperawatan_psikiatri,master_rencana_keperawatan_psikiatri,"+
        "penilaian_awal_keperawatan_psikiatri,pemantauan_pews_anak,surat_pulang_atas_permintaan_sendiri,"+
        "template_hasil_radiologi,laporan_bulanan_irj,template_pemeriksaan,pemeriksaan_lab_mb,ubah_petugas_lab_mb,"+
        "penilaian_pre_operasi,penilaian_pre_anestesi,perencanaan_pemulangan,penilaian_lanjutan_resiko_jatuh_dewasa,"+
        "penilaian_lanjutan_resiko_jatuh_anak,penilaian_awal_medis_ralan_geriatri,penilaian_tambahan_pasien_geriatri,"+
        "skrining_nutrisi_dewasa,skrining_nutrisi_lansia,hasil_pemeriksaan_usg,skrining_nutrisi_anak,"+
        "akun_host_to_host_bank_jabar,pembayaran_bank_jabar,surat_pernyataan_pasien_umum,konseling_farmasi,"+
        "pelayanan_informasi_obat,jawaban_pio_apoteker,surat_persetujuan_umum,transfer_pasien_antar_ruang,"+
        "satu_sehat_referensi_dokter,satu_sehat_referensi_pasien,satu_sehat_mapping_departemen,"+
        "satu_sehat_mapping_lokasi,satu_sehat_kirim_encounter,catatan_cek_gds,satu_sehat_kirim_condition,"+
        "checklist_pre_operasi,satu_sehat_kirim_observationttv,signin_sebelum_anestesi,satu_sehat_kirim_procedure,"+
        "operasi_per_bulan,timeout_sebelum_insisi,signout_sebelum_menutup_luka,dapur_barang,dapur_opname,"+
        "satu_sehat_mapping_vaksin,dapur_suplier,satu_sehat_kirim_Immunization,checklist_post_operasi,dapur_pembelian,"+
        "dapur_stok_keluar,dapur_riwayat_barang,permintaan_dapur,rekonsiliasi_obat,biaya_pengadaan_dapur,"+
        "rekap_pengadaan_dapur,kesling_limbah_b3medis_cair,grafik_limbahb3cair_pertanggal,grafik_limbahb3cair_perbulan,"+
        "rekap_biaya_registrasi,konfirmasi_rekonsiliasi_obat,satu_sehat_kirim_clinicalimpression,"+
        "penilaian_pasien_terminal,surat_persetujuan_rawat_inap,monitoring_reaksi_tranfusi,penilaian_korban_kekerasan,"+
        "penilaian_lanjutan_resiko_jatuh_lansia,penilaian_pasien_penyakit_menular,mpp_skrining,"+
        "edukasi_pasien_keluarga_rj,pemantauan_pews_dewasa,penilaian_tambahan_bunuh_diri,bpjs_antrean_pertanggal,"+
        "penilaian_tambahan_perilaku_kekerasan,penilaian_tambahan_beresiko_melarikan_diri,"+
        "persetujuan_penundaan_pelayanan,sisa_diet_pasien,penilaian_awal_medis_ralan_bedah_mulut,"+
        "penilaian_pasien_keracunan,pemantauan_meows_obstetri,catatan_adime_gizi,pengajuan_biaya,"+
        "penilaian_awal_keperawatan_ralan_geriatri,master_masalah_keperawatan_geriatri,"+
        "master_rencana_keperawatan_geriatri,checklist_kriteria_masuk_hcu,checklist_kriteria_keluar_hcu,"+
        "penilaian_risiko_dekubitus,master_menolak_anjuran_medis,penolakan_anjuran_medis,"+
        "laporan_tahunan_penolakan_anjuran_medis,template_laporan_operasi,hasil_tindakan_eswl,"+
        "checklist_kriteria_masuk_icu,checklist_kriteria_keluar_icu,akses_dokter_lain_rawat_jalan,follow_up_dbd,"+
        "penilaian_risiko_jatuh_neonatus,persetujuan_pengajuan_biaya,pemeriksaan_fisik_ralan_per_penyakit,"+
        "penilaian_lanjutan_resiko_jatuh_geriatri,pemantauan_ews_neonatus,validasi_persetujuan_pengajuan_biaya,"+
        "riwayat_perawatan_icare_bpjs,rekap_pengajuan_biaya,penilaian_awal_medis_ralan_kulit_kelamin,"+
        "akun_host_to_host_bank_mandiri,penilaian_medis_hemodialisa,penilaian_level_kecemasan_ranap_anak,"+
        "penilaian_lanjutan_resiko_jatuh_psikiatri,penilaian_lanjutan_skrining_fungsional,"+
        "penilaian_medis_ralan_rehab_medik,laporan_anestesi,template_persetujuan_penolakan_tindakan,"+
        "penilaian_medis_ralan_gawat_darurat_psikiatri,bpjs_referensi_setting_apotek,bpjs_referensi_obat_apotek,"+
        "bpjs_mapping_obat_apotek,pembayaran_bank_mandiri,penilaian_ulang_nyeri,penilaian_terapi_wicara,"+
        "bpjs_obat_23hari_apotek,pengkajian_restrain,bpjs_kunjungan_sep_apotek,bpjs_monitoring_klaim_apotek,"+
        "bpjs_daftar_pelayanan_obat_apotek,penilaian_awal_medis_ralan_paru,catatan_keperawatan_ralan,catatan_persalinan,"+
        "skor_aldrette_pasca_anestesi,skor_steward_pasca_anestesi,skor_bromage_pasca_anestesi,penilaian_pre_induksi,"+
        "hasil_usg_urologi,hasil_usg_gynecologi,hasil_pemeriksaan_ekg,hapus_edit_sep_bpjs,satu_sehat_kirim_diet,"+
        "satu_sehat_mapping_obat,dapur_ringkasan_pembelian,satu_sehat_kirim_medication,"+
        "satu_sehat_kirim_medicationrequest,penatalaksanaan_terapi_okupasi,satu_sehat_kirim_medicationdispense,"+
        "hasil_usg_neonatus,hasil_endoskopi_faring_laring,satu_sehat_mapping_radiologi,"+
        "satu_sehat_kirim_servicerequest_radiologi,hasil_endoskopi_hidung,satu_sehat_kirim_specimen_radiologi,"+
        "master_masalah_keperawatan_neonatus,master_rencana_keperawatan_neonatus,"+
        "penilaian_awal_keperawatan_ranap_neonatus,satu_sehat_kirim_observation_radiologi,"+
        "satu_sehat_kirim_diagnosticreport_radiologi,hasil_endoskopi_telinga,satu_sehat_mapping_lab,"+
        "satu_sehat_kirim_servicerequest_lab,satu_sehat_kirim_servicerequest_labmb,satu_sehat_kirim_specimen_lab,"+
        "satu_sehat_kirim_specimen_labmb,satu_sehat_kirim_observation_lab,satu_sehat_kirim_observation_labmb,"+
        "satu_sehat_kirim_diagnosticreport_lab,satu_sehat_kirim_diagnosticreport_labmb,"+
        "kepatuhan_kelengkapan_keselamatan_bedah,nilai_piutang_perjenis_bayar_per_bulan,ringkasan_piutang_jenis_bayar,"+
        "penilaian_pasien_imunitas_rendah,balance_cairan,catatan_observasi_chbp,catatan_observasi_induksi_persalinan,"+
        "skp_kategori_penilaian,skp_kriteria_penilaian,skp_penilaian,referensi_poli_mobilejknfktp,"+
        "referensi_dokter_mobilejknfktp,skp_rekapitulasi_penilaian,pembayaran_pihak_ke3_bankmandiri,"+
        "metode_pembayaran_bankmandiri,bank_tujuan_transfer_bankmandiri,kodetransaksi_tujuan_transfer_bankmandiri,"+
        "konsultasi_medik,jawaban_konsultasi_medik,pcare_cek_alergi,pcare_cek_prognosa,data_sasaran_usiaproduktif,"+
        "data_sasaran_usialansia,skrining_perilaku_merokok_sekolah_remaja,skrining_kekerasan_pada_perempuan,"+
        "skrining_obesitas,skrining_risiko_kanker_payudara,skrining_risiko_kanker_paru,skrining_tbc,"+
        "skrining_kesehatan_gigi_mulut_remaja,penilaian_awal_keperawatan_ranap_bayi,booking_mcu_perusahaan,"+
        "catatan_observasi_restrain_nonfarma,catatan_observasi_ventilator,catatan_anestesi_sedasi,skrining_puma,"+
        "satu_sehat_kirim_careplan,satu_sehat_kirim_medicationstatement,skrining_adiksi_nikotin,skrining_thalassemia,"+
        "skrining_instrumen_sdq,skrining_instrumen_srq,checklist_pemberian_fibrinolitik,skrining_kanker_kolorektal,"+
        "dapur_pemesanan,bayar_pesan_dapur,hutang_dapur,titip_faktur_dapur,validasi_tagihan_dapur,surat_pemesanan_dapur,"+
        "pengajuan_barang_dapur,dapur_returbeli,hibah_dapur,ringkasan_penerimaan_dapur,ringkasan_pengajuan_dapur,"+
        "ringkasan_pemesanan_dapur,ringkasan_returbeli_dapur,ringkasan_stokkeluar_dapur,dapur_stokkeluar_pertanggal,"+
        "sirkulasi_dapur,sirkulasi_dapur2,verifikasi_penerimaan_dapur,nilai_penerimaan_vendor_dapur_perbulan,"+
        "ringkasan_hutang_vendor_dapur,penilaian_psikologi_klinis,penilaian_awal_medis_ranap_neonatus,"+
        "penilaian_derajat_dehidrasi,ringkasan_jasa_tindakan_medis,pendapatan_per_akun,hasil_pemeriksaan_echo,"+
        "penilaian_bayi_baru_lahir,rl1_3_ketersediaan_kamar,pendapatan_per_akun_closing,pengeluaran_pengeluaran,"+
        "skrining_diabetes_melitus,laporan_tindakan,pelaksanaan_informasi_edukasi,layanan_kedokteran_fisik_rehabilitasi,"+
        "skrining_kesehatan_gigi_mulut_balita,skrining_anemia,layanan_program_kfr,skrining_hipertensi,"+
        "skrining_kesehatan_penglihatan,catatan_observasi_hemodialisa,skrining_kesehatan_gigi_mulut_dewasa,"+
        "skrining_risiko_kanker_serviks,catatan_cairan_hemodialisa,skrining_kesehatan_gigi_mulut_lansia,"+
        "skrining_indra_pendengaran,catatan_pengkajian_paska_operasi,skrining_frailty_syndrome,sirkulasi_cssd,"+
        "lama_pelayanan_cssd,catatan_observasi_bayi,riwayat_surat_peringatan,master_kesimpulan_anjuran_mcu,"+
        "kategori_piutang_jasa_perusahaan,piutang_jasa_perusahaan,bayar_piutang_jasa_perusahaan,"+
        "piutang_jasa_perusahaan_belum_lunas,checklist_kesiapan_anestesi,piutang_peminjaman_uang_belum_lunas,"+
        "hasil_pemeriksaan_slit_lamp,hasil_pemeriksaan_oct,beban_hutang_lain,poli_asal_pasien_ranap,pemberi_hutang_lain,"+
        "dokter_asal_pasien_ranap,duta_parkir_rekap_keluar,surat_keterangan_layak_terbang,bayar_beban_hutang_lain,"+
        "surat_persetujuan_pemeriksaan_hiv,skrining_instrumen_acrs,surat_pernyataan_memilih_dpjp,"+
        "skrining_instrumen_mental_emosional,pelanggan_lab_kesehatan_lingkungan,kriteria_masuk_nicu,"+
        "kriteria_keluar_nicu,penilaian_medis_ranap_psikiatrik,kriteria_masuk_picu,kriteria_keluar_picu,"+
        "master_sampel_bakumutu,skrining_instrumen_amt,parameter_pengujian_lab_kesehatan_lingkungan,"+
        "nilai_normal_baku_mutu_lab_kesehatan_lingkungan,skrining_pneumonia_severity_index,"+
        "permintaan_pengujian_sampel_lab_kesehatan_lingkungan,penilaian_awal_medis_ralan_jantung,"+
        "penilaian_awal_medis_ralan_urologi,hasil_pemeriksaan_treadmill,hasil_pemeriksaan_echo_pediatrik,"+
        "template_pelaksanaan_informasi_edukasi,skrining_instrumen_esat,penilaian_awal_medis_ranap_jantung,"+
        "penugasan_pengujian_sampel_lab_kesehatan_lingkungan,hasil_pengujian_sampel_lab_kesehatan_lingkungan,"+
        "verifikasi_pengujian_sampel_lab_kesehatan_lingkungan,validasi_pengujian_sampel_lab_kesehatan_lingkungan,"+
        "rekap_pelayanan_lab_kesehatan_lingkungan,pembayaran_pengujian_sampel_lab_kesehatan_lingkungan,skrining_curb65,"+
        "bpjs_potensi_prb,bpjs_riwayat_pelayanan_obat,skrining_gizi_kehamilan,bpjs_rekap_peserta_prb_apotek,"+
        "serah_terima_anggota_tubuh_barang,pcra_icra_jenis_aktivitas_proyek,pcra_icra_lokasi_kelompok_risiko_area,"+
        "pcra_icra_kelas_risiko_pencegahan,pcra_icra_tindakan_pengendalian,pcra_icra_identifkasi_risiko_infeksi,"+
        "pcra_icra_identifkasi_risiko_keselamatan,pcra_icra_identifkasi_risiko_kebakaran,"+
        "pcra_icra_identifkasi_risiko_utilitas,bpjs_daftar_resep_apotek,daftar_permintaan_resep_iterasi_bpjs,"+
        "pcra_icra_pengkajian_risiko_prakonstruksi,pcra_icra_persyaratan_harus_dipenuhi,"+
        "satu_sehat_kirim_questionresponse_telaah_farmasi,satu_sehat_kirim_allergy_intolerance,konsultasi_perawat,"+
        "jawaban_konsultasi_perawat,bridging_smart_klaim_bpjs,mapping_prosedur_smart_klaim_bpjs,"+
        "mapping_penyakit_smart_klaim_bpjs,permintaan_binrohtal,surat_permintaan_perlindungan_dari_kekerasan,"+
        "surat_permohonan_privasi,surat_permintaan_second_opinion,surat_keterangan_berobat,surat_penolakan_resusitasi,"+
        "catatan_observasi_ruang_ok,hasil_pemeriksaan_usg_abdomen,intervensi_nyeri_farmakologi,"+
        "intervensi_nyeri_nonfarmakologi,surat_pengajuan_cuti_pasien,checklist_kriteria_masuk_isolasi,"+
        "satu_sehat_mapping_kptl_tindakan_ralan,satu_sehat_mapping_kptl_tindakan_ranap,"+
        "satu_sehat_mapping_kptl_tindakan_radiologi,satu_sehat_mapping_kptl_tindakan_laborat,"+
        "satu_sehat_mapping_kptl_tindakan_operasi,satu_sehat_mapping_kptl_tarif_kamar,checklist_kriteria_keluar_isolasi,"+
        "satu_sehat_tanda_tangan_elektronik,satu_sehat_kirim_composition,ringkasan_hutang_vendor_inventaris,"+
        "ringkasan_beban_hutang_lain,set_resep_per_cara_bayar,skrining_tolac,admisi_skoring_tolac,monitoring_tolac,"+
        "hasil_persalinan_tolac,laporan_reaksi_transfusi,penilaian_grace_scor"
        ).split(",");

    static final String SAMA = "Sama";
    static final String DITAMBAH = "Ditambah";
    static final String DICABUT = "Dicabut";

    private static final Color WARNA_TAMBAH = new Color(214, 240, 214);
    private static final Color WARNA_CABUT = new Color(250, 214, 214);

    private final Connection koneksi = koneksiDB.condb();
    private final sekuel Sequel = new sekuel();
    private final String[] label;
    private final Runnable onSelesai;

    private final PilihPengguna cmbSumber;
    private final PilihPengguna cmbTujuan;
    private final JComboBox<String> cmbFilter = new JComboBox<String>(new String[]{"Berbeda", "Semua", DITAMBAH, DICABUT});
    private final JTextField txtCari = new JTextField();
    private final JLabel lblRingkasan = new JLabel(" ");
    private final JButton btnSalin = new JButton("Salin (samakan persis)");
    private final JButton btnTutup = new JButton("Tutup");
    private final DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Hak Akses", "Sumber", "Tujuan", "Perubahan"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable tabel = new JTable(model);
    private final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);

    // hasil perbandingan terakhir
    private String idSumber = null, idTujuan = null;
    private String[] hakSumber = null, hakTujuan = null;
    private String[] statusKolom = null;
    private int jmlTambah = 0, jmlCabut = 0;

    /** Satu baris user pada pilihan Sumber/Tujuan. */
    static final class Pengguna {
        final String id, nama, jabatan;

        Pengguna(String id, String nama, String jabatan) {
            this.id = id;
            this.nama = nama == null ? "" : nama;
            this.jabatan = jabatan == null ? "" : jabatan;
        }

        @Override
        public String toString() {
            return id + " - " + nama + (jabatan.isEmpty() ? "" : " (" + jabatan + ")");
        }
    }

    /**
     * @param owner     jendela induk
     * @param users     daftar user: tiap elemen {id, nama, jabatan}
     * @param label     nama tampilan tiap kolom hak akses (urutan = KOLOM); boleh null
     * @param idTujuan  user yang dipilih awal sebagai Tujuan; boleh null
     * @param onSelesai dipanggil setelah penyalinan berhasil (mis. memuat ulang tabel); boleh null
     */
    public DlgSalinHakAkses(Window owner, List<String[]> users, String[] label, String idTujuan, Runnable onSelesai) {
        super(owner, "Bandingkan & Salin Hak Akses", ModalityType.APPLICATION_MODAL);
        this.label = label;
        this.onSelesai = onSelesai;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        List<Pengguna> daftarPengguna = new ArrayList<Pengguna>();
        Pengguna awal = null;
        for (String[] u : users) {
            Pengguna p = new Pengguna(u[0], u[1], u[2]);
            daftarPengguna.add(p);
            if (idTujuan != null && idTujuan.equals(p.id)) {
                awal = p;
            }
        }
        cmbSumber = new PilihPengguna(daftarPengguna, () -> bandingkan());
        cmbTujuan = new PilihPengguna(daftarPengguna, () -> bandingkan());
        cmbTujuan.setPengguna(awal);

        susunTampilan();
        pasangAksi();
        setSize(920, 680);
        setLocationRelativeTo(owner);
        bandingkan();
    }

    private void susunTampilan() {
        Font f = new Font("Tahoma", Font.PLAIN, 11);
        JPanel root = new JPanel(new BorderLayout(0, 6));
        root.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        setContentPane(root);

        // atas: pilih Sumber dan Tujuan
        JPanel atas = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 3, 2, 3);
        c.anchor = GridBagConstraints.WEST;
        c.gridy = 0;
        c.gridx = 0;
        atas.add(new JLabel("Sumber (hak akses yang disalin) :"), c);
        c.gridx = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        atas.add(cmbSumber, c);
        c.gridy = 1;
        c.gridx = 0;
        c.weightx = 0;
        c.fill = GridBagConstraints.NONE;
        atas.add(new JLabel("Tujuan (hak akses yang ditimpa) :"), c);
        c.gridx = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        atas.add(cmbTujuan, c);
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 2;
        JLabel info = new JLabel("<html>Mode <b>Samakan persis</b>: hak akses Tujuan dibuat identik dengan Sumber "
                + "(hak yang tidak dimiliki Sumber akan dicabut dari Tujuan). ID user dan password tidak diubah.</html>");
        info.setForeground(new Color(90, 90, 90));
        atas.add(info, c);

        // filter
        JPanel filter = new JPanel(new BorderLayout(6, 0));
        JPanel kiri = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        kiri.add(new JLabel("Tampilkan :"));
        kiri.add(cmbFilter);
        filter.add(kiri, BorderLayout.WEST);
        JPanel cari = new JPanel(new BorderLayout(4, 0));
        cari.add(new JLabel("Cari hak akses : "), BorderLayout.WEST);
        cari.add(txtCari, BorderLayout.CENTER);
        filter.add(cari, BorderLayout.CENTER);

        JPanel tengahAtas = new JPanel(new BorderLayout(0, 6));
        tengahAtas.add(atas, BorderLayout.NORTH);
        tengahAtas.add(filter, BorderLayout.SOUTH);
        root.add(tengahAtas, BorderLayout.NORTH);

        // tabel
        tabel.setFont(f);
        tabel.setRowHeight(20);
        tabel.setRowSorter(sorter);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(480);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabel.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabel.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object v, boolean sel, boolean foc, int row, int col) {
                Component comp = super.getTableCellRendererComponent(t, v, sel, foc, row, col);
                if (!sel) {
                    String st = String.valueOf(t.getModel().getValueAt(t.convertRowIndexToModel(row), 3));
                    comp.setBackground(DITAMBAH.equals(st) ? WARNA_TAMBAH : DICABUT.equals(st) ? WARNA_CABUT : Color.WHITE);
                    comp.setForeground(Color.BLACK);
                }
                setHorizontalAlignment(col == 0 ? LEFT : CENTER);
                return comp;
            }
        });
        root.add(new JScrollPane(tabel), BorderLayout.CENTER);

        // bawah
        JPanel bawah = new JPanel(new BorderLayout(0, 4));
        JLabel legenda = new JLabel("<html><span style='background:#d6f0d6'>&nbsp;Ditambah&nbsp;</span> hak akan diberikan ke Tujuan &nbsp;&nbsp;"
                + "<span style='background:#fad6d6'>&nbsp;Dicabut&nbsp;</span> hak akan dicabut dari Tujuan</html>");
        legenda.setFont(f);
        bawah.add(legenda, BorderLayout.NORTH);
        lblRingkasan.setFont(new Font("Tahoma", Font.BOLD, 11));
        bawah.add(lblRingkasan, BorderLayout.CENTER);
        JPanel tombol = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 0));
        tombol.add(btnSalin);
        tombol.add(btnTutup);
        bawah.add(tombol, BorderLayout.SOUTH);
        root.add(bawah, BorderLayout.SOUTH);

        for (JComponent k : new JComponent[]{cmbSumber, cmbTujuan, cmbFilter, txtCari, btnSalin, btnTutup, lblRingkasan}) {
            if (k != lblRingkasan) {
                k.setFont(f);
            }
        }
        btnSalin.setEnabled(false);
    }

    private void pasangAksi() {
        cmbFilter.addActionListener((ActionEvent e) -> terapkanFilter());
        txtCari.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                terapkanFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                terapkanFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                terapkanFilter();
            }
        });
        btnSalin.addActionListener((ActionEvent e) -> salin());
        btnTutup.addActionListener((ActionEvent e) -> dispose());
        getRootPane().registerKeyboardAction((ActionEvent e) -> dispose(),
                KeyStroke.getKeyStroke("ESCAPE"), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    /**
     * Pilihan user dengan pencarian: ketik sebagian ID atau nama (beberapa kata boleh, urutan bebas)
     * untuk menyaring daftar; panah atas/bawah + Enter atau klik untuk memilih; Esc menutup daftar.
     */
    static final class PilihPengguna extends JPanel {
        private final List<Pengguna> semua;
        private final Runnable onUbah;
        private final JTextField teks;
        private final BasicArrowButton btnPanah = new BasicArrowButton(SwingConstants.SOUTH);
        private final DefaultListModel<Pengguna> model = new DefaultListModel<Pengguna>();
        private final JList<Pengguna> daftar = new JList<Pengguna>(model);
        private final JPopupMenu popup = new JPopupMenu();
        private Pengguna terpilih = null;
        private boolean internal = false;
        private int barisPopup = -1;

        PilihPengguna(List<Pengguna> semua, Runnable onUbah) {
            super(new BorderLayout());
            this.semua = semua;
            this.onUbah = onUbah;
            teks = new JTextField() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (getText().isEmpty() && !hasFocus()) {
                        g.setColor(Color.GRAY);
                        g.setFont(getFont());
                        g.drawString("Ketik ID atau nama untuk mencari...", 4,
                                (getHeight() + g.getFontMetrics().getAscent() - g.getFontMetrics().getDescent()) / 2);
                    }
                }
            };
            teks.setToolTipText("Ketik sebagian ID atau nama user untuk mencari");
            add(teks, BorderLayout.CENTER);
            add(btnPanah, BorderLayout.EAST);

            daftar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            daftar.setFixedCellHeight(20);
            daftar.setFocusable(false);
            popup.setFocusable(false);
            popup.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            teks.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    berubah();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    berubah();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                }
            });
            teks.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int kode = e.getKeyCode();
                    if (kode == KeyEvent.VK_DOWN) {
                        if (!popup.isVisible()) {
                            saring(teks.getText());
                        } else {
                            geser(1);
                        }
                        e.consume();
                    } else if (kode == KeyEvent.VK_UP) {
                        if (popup.isVisible()) {
                            geser(-1);
                        }
                        e.consume();
                    } else if (kode == KeyEvent.VK_ENTER) {
                        if (popup.isVisible() && model.size() > 0) {
                            int idx = daftar.getSelectedIndex();
                            pilih(model.get(idx < 0 ? 0 : idx));
                            e.consume();
                        }
                    } else if (kode == KeyEvent.VK_ESCAPE) {
                        if (popup.isVisible()) {
                            popup.setVisible(false);
                            e.consume();
                        }
                    }
                }
            });
            teks.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    teks.selectAll();
                }

                @Override
                public void focusLost(FocusEvent e) {
                    popup.setVisible(false);
                    if (teks.getText().trim().isEmpty() && terpilih != null) {
                        // kolom sengaja dikosongkan: pilihan dihapus
                        terpilih = null;
                        tampilkanTerpilih();
                        onUbah.run();
                        return;
                    }
                    tampilkanTerpilih();
                }
            });
            daftar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    int idx = daftar.locationToIndex(e.getPoint());
                    if (idx >= 0 && idx < model.size()) {
                        pilih(model.get(idx));
                    }
                }
            });
            daftar.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int idx = daftar.locationToIndex(e.getPoint());
                    if (idx >= 0 && idx < model.size()) {
                        daftar.setSelectedIndex(idx);
                    }
                }
            });
            btnPanah.addActionListener((ActionEvent e) -> {
                if (popup.isVisible()) {
                    popup.setVisible(false);
                } else {
                    teks.requestFocusInWindow();
                    saring("");
                }
            });
        }

        Pengguna getPengguna() {
            return terpilih;
        }

        @Override
        public boolean requestFocusInWindow() {
            return teks.requestFocusInWindow();
        }

        /** Mengatur pilihan tanpa memicu perbandingan. */
        void setPengguna(Pengguna p) {
            terpilih = p;
            tampilkanTerpilih();
        }

        @Override
        public void setFont(Font f) {
            super.setFont(f);
            if (teks != null) {
                teks.setFont(f);
                daftar.setFont(f);
            }
        }

        /** Cocok bila semua kata pada kueri ada di teks pengguna (tanpa membedakan huruf besar/kecil). */
        static boolean cocok(Pengguna p, String kueri) {
            String target = p.toString().toLowerCase();
            for (String k : kueri.trim().toLowerCase().split("\\s+")) {
                if (!k.isEmpty() && !target.contains(k)) {
                    return false;
                }
            }
            return true;
        }

        private void tampilkanTerpilih() {
            internal = true;
            try {
                teks.setText(terpilih == null ? "" : terpilih.toString());
                teks.setForeground(Color.BLACK);
            } finally {
                internal = false;
            }
        }

        private void berubah() {
            if (internal) {
                return;
            }
            saring(teks.getText());
        }

        private void saring(String kueri) {
            model.clear();
            for (Pengguna p : semua) {
                if (cocok(p, kueri)) {
                    model.addElement(p);
                }
            }
            teks.setForeground(model.isEmpty() ? Color.RED : Color.BLACK);
            if (model.isEmpty()) {
                popup.setVisible(false);
                return;
            }
            int sel = terpilih != null ? model.indexOf(terpilih) : -1;
            daftar.setSelectedIndex(sel >= 0 ? sel : 0);
            int baris = Math.min(10, model.size());
            if (popup.isVisible() && baris != barisPopup) {
                // ukuran popup berubah: tutup lalu buka lagi agar ukuran dan gambar ikut diperbarui
                popup.setVisible(false);
            }
            if (!popup.isVisible()) {
                popup.removeAll();
                JScrollPane sp = new JScrollPane(daftar);
                sp.setPreferredSize(new Dimension(Math.max(teks.getWidth() + btnPanah.getWidth(), 200), baris * 20 + 4));
                popup.add(sp);
                barisPopup = baris;
                popup.show(teks, 0, teks.getHeight());
            }
            daftar.revalidate();
            daftar.repaint();
            daftar.ensureIndexIsVisible(daftar.getSelectedIndex());
        }

        private void geser(int arah) {
            int n = model.size();
            if (n == 0) {
                return;
            }
            int idx = Math.max(0, Math.min(n - 1, daftar.getSelectedIndex() + arah));
            daftar.setSelectedIndex(idx);
            daftar.ensureIndexIsVisible(idx);
        }

        private void pilih(Pengguna p) {
            popup.setVisible(false);
            boolean beda = terpilih == null || !terpilih.id.equals(p.id);
            terpilih = p;
            tampilkanTerpilih();
            if (teks.hasFocus()) {
                teks.selectAll();
            }
            if (beda) {
                onUbah.run();
            }
        }
    }

    // ---------------------------------------------------------------- logika murni (dapat diuji)

    /** Status tiap kolom: Ditambah (Sumber ya, Tujuan tidak), Dicabut (Sumber tidak, Tujuan ya), atau Sama. */
    static String[] hitungStatus(String[] sumber, String[] tujuan) {
        String[] st = new String[sumber.length];
        for (int k = 0; k < sumber.length; k++) {
            boolean s = "true".equals(sumber[k]);
            boolean t = "true".equals(tujuan[k]);
            st[k] = s == t ? SAMA : (s ? DITAMBAH : DICABUT);
        }
        return st;
    }

    /** UPDATE yang hanya memuat kolom yang berubah; nilai lewat parameter, id user parameter terakhir. */
    static String bangunSql(List<Integer> kolomBerubah) {
        StringBuilder sb = new StringBuilder("update `user` set ");
        for (int n = 0; n < kolomBerubah.size(); n++) {
            if (n > 0) {
                sb.append(',');
            }
            sb.append('`').append(KOLOM[kolomBerubah.get(n)]).append("`=?");
        }
        sb.append(" where id_user=AES_ENCRYPT(?,'nur')");
        return sb.toString();
    }

    private static String bangunSelect() {
        StringBuilder sb = new StringBuilder("select ");
        for (int k = 0; k < KOLOM.length; k++) {
            if (k > 0) {
                sb.append(',');
            }
            sb.append('`').append(KOLOM[k]).append('`');
        }
        sb.append(" from `user` where id_user=AES_ENCRYPT(?,'nur')");
        return sb.toString();
    }

    // ---------------------------------------------------------------- akses database

    /** Membaca hak akses satu user langsung dari database berdasarkan ID; null bila user tidak ada. */
    private String[] bacaHak(String id) throws Exception {
        try (PreparedStatement ps = koneksi.prepareStatement(bangunSelect())) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                String[] hak = new String[KOLOM.length];
                for (int k = 0; k < KOLOM.length; k++) {
                    hak[k] = "true".equalsIgnoreCase(rs.getString(k + 1)) ? "true" : "false";
                }
                return hak;
            }
        }
    }

    private String namaKolom(int k) {
        return (label != null && k < label.length && label[k] != null && !label[k].isEmpty()) ? label[k] : KOLOM[k];
    }

    private void bandingkan() {
        model.setRowCount(0);
        statusKolom = null;
        hakSumber = null;
        hakTujuan = null;
        idSumber = null;
        idTujuan = null;
        jmlTambah = 0;
        jmlCabut = 0;
        btnSalin.setEnabled(false);

        Pengguna s = cmbSumber.getPengguna();
        Pengguna t = cmbTujuan.getPengguna();
        if (s == null || t == null) {
            lblRingkasan.setText("Pilih user Sumber dan Tujuan.");
            return;
        }
        if (s.id.equals(t.id)) {
            lblRingkasan.setText("Sumber dan Tujuan adalah user yang sama. Pilih user yang berbeda.");
            return;
        }
        try {
            String[] hs = bacaHak(s.id);
            String[] ht = bacaHak(t.id);
            if (hs == null || ht == null) {
                lblRingkasan.setText("Data user " + (hs == null ? s.id : t.id) + " tidak ditemukan di database.");
                return;
            }
            idSumber = s.id;
            idTujuan = t.id;
            hakSumber = hs;
            hakTujuan = ht;
            statusKolom = hitungStatus(hs, ht);
            for (int k = 0; k < KOLOM.length; k++) {
                if (DITAMBAH.equals(statusKolom[k])) {
                    jmlTambah++;
                } else if (DICABUT.equals(statusKolom[k])) {
                    jmlCabut++;
                }
                model.addRow(new Object[]{namaKolom(k),
                    "true".equals(hs[k]) ? "Ya" : "Tidak",
                    "true".equals(ht[k]) ? "Ya" : "Tidak",
                    statusKolom[k]});
            }
            lblRingkasan.setText("+" + jmlTambah + " ditambah, -" + jmlCabut + " dicabut, "
                    + (KOLOM.length - jmlTambah - jmlCabut) + " tidak berubah");
            btnSalin.setEnabled(jmlTambah + jmlCabut > 0);
            terapkanFilter();
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
            lblRingkasan.setText("Gagal membaca hak akses: " + e.getMessage());
        }
    }

    private void terapkanFilter() {
        final String mode = String.valueOf(cmbFilter.getSelectedItem());
        final String kata = txtCari.getText().trim().toLowerCase();
        sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> en) {
                String st = String.valueOf(en.getValue(3));
                if ("Berbeda".equals(mode) && SAMA.equals(st)) {
                    return false;
                }
                if ((DITAMBAH.equals(mode) || DICABUT.equals(mode)) && !mode.equals(st)) {
                    return false;
                }
                return kata.isEmpty() || String.valueOf(en.getValue(0)).toLowerCase().contains(kata);
            }
        });
    }

    private void salin() {
        if (statusKolom == null || idSumber == null || idTujuan == null) {
            return;
        }
        Pengguna s = cmbSumber.getPengguna();
        Pengguna t = cmbTujuan.getPengguna();
        if (s == null || t == null || !s.id.equals(idSumber) || !t.id.equals(idTujuan)) {
            bandingkan();
            return;
        }
        String peringatan = idTujuan.equals(akses.getkode())
                ? "<br><br><b>Perhatian: Tujuan adalah akun yang sedang Anda gunakan.</b>" : "";
        int jawab = JOptionPane.showConfirmDialog(this,
                "<html>Samakan hak akses <b>Tujuan</b> dengan <b>Sumber</b>?<br><br>"
                + "Sumber : " + esc(s.toString()) + "<br>"
                + "Tujuan : " + esc(t.toString()) + "<br><br>"
                + "+" + jmlTambah + " hak ditambahkan, -" + jmlCabut + " hak dicabut.<br>"
                + "ID user dan password tidak diubah. Tindakan ini tidak dapat dibatalkan."
                + peringatan + "</html>",
                "Konfirmasi Salin Hak Akses", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (jawab != JOptionPane.YES_OPTION) {
            return;
        }

        List<Integer> berubah = new ArrayList<Integer>();
        for (int k = 0; k < KOLOM.length; k++) {
            if (!SAMA.equals(statusKolom[k])) {
                berubah.add(k);
            }
        }
        boolean autoCommitSemula = true;
        try {
            autoCommitSemula = koneksi.getAutoCommit();
            koneksi.setAutoCommit(false);
            try (PreparedStatement ps = koneksi.prepareStatement(bangunSql(berubah))) {
                int p = 1;
                for (int k : berubah) {
                    ps.setString(p++, hakSumber[k]);
                }
                ps.setString(p, idTujuan);
                int n = ps.executeUpdate();
                if (n != 1) {
                    throw new IllegalStateException("Jumlah baris yang berubah tidak sesuai (" + n + ")");
                }
            }
            koneksi.commit();
        } catch (Exception e) {
            try {
                koneksi.rollback();
            } catch (Exception ignore) {
            }
            System.out.println("Notifikasi : " + e);
            JOptionPane.showMessageDialog(this, "Gagal menyalin hak akses, tidak ada perubahan yang tersimpan.\n" + e.getMessage(),
                    "Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        } finally {
            try {
                koneksi.setAutoCommit(autoCommitSemula);
            } catch (Exception ignore) {
            }
        }

        // catatan audit: tanpa password
        StringBuilder log = new StringBuilder("Salin hak akses (samakan persis) dari user ")
                .append(idSumber).append(" ke user ").append(idTujuan)
                .append(": +").append(jmlTambah).append(" -").append(jmlCabut).append(" kolom: ");
        for (int k : berubah) {
            log.append(KOLOM[k]).append(DITAMBAH.equals(statusKolom[k]) ? "(+) " : "(-) ");
        }
        String teks = log.length() > 3000 ? log.substring(0, 3000) + "..." : log.toString();
        Sequel.SimpanTrack(teks);

        if (onSelesai != null) {
            onSelesai.run();
        }
        JOptionPane.showMessageDialog(this, "Hak akses berhasil disalin (" + berubah.size() + " hak berubah).");
        bandingkan();
    }

    private static String esc(String x) {
        return x.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
