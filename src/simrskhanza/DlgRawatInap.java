Warning: truncated output (original token count: 195484)
Total output lines: 12945

/*
  Dilarang keras memperjualbelikan/mengambil keuntungan dari Software 
  ini dalam bentuk apapun tanpa seijin pembuat software
  (Khanza.Soft Media). Bagi yang sengaja membajak softaware ini ta
  npa ijin, kami sumpahi sial 1000 turunan, miskin sampai 500 turu
  nan. Selalu mendapat kecelakaan sampai 400 turunan. Anak pertama
  nya cacat tidak punya kaki sampai 300 turunan. Susah cari jodoh
  sampai umur 50 tahun sampai 200 turunan. Ya Alloh maafkan kami 
  karena telah berdoa buruk, semua ini kami lakukan karena kami ti
  dak pernah rela karya kami dibajak tanpa ijin.
 */
package simrskhanza;

import rekammedis.RMRiwayatPerawatan;
import surat.SuratKontrol;
import keuangan.DlgCariPerawatanRanap;
import keuangan.DlgCariPerawatanRanap2;
import inventory.DlgPemberianObat;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import fungsi.akuntindakanranap;
import fungsi.copypastesoapranap;
import inventory.DlgCariObat2;
import inventory.DlgCariObat3;
import inventory.DlgCopyResep;
import inventory.DlgPeresepanDokter;
import inventory.DlgPermintaanResepPulang;
import inventory.DlgPermintaanStokPasien;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import kepegawaian.DlgCariPegawai;
import keuangan.Jurnal;
import laporan.DlgBerkasRawat;
import laporan.DlgDiagnosaPenyakit;
import permintaan.DlgBookingOperasi;
import permintaan.DlgPermintaanKonsultasiMedik;
import permintaan.DlgPermintaanLaboratorium;
import permintaan.DlgPermintaanPelayananInformasiObat;
import permintaan.DlgPermintaanRadiologi;
import rekammedis.RMCari5SOAPTerakhir;
import rekammedis.RMCatatanADIMEGizi;
import rekammedis.RMCatatanAnastesiSedasi;
import rekammedis.RMCatatanPengkajianPaskaOperasi;
import rekammedis.RMCatatanPersalinan;
import rekammedis.RMChecklistKesiapanAnestesi;
import rekammedis.RMChecklistKriteriaKeluarHCU;
import rekammedis.RMChecklistKriteriaKeluarICU;
import rekammedis.RMChecklistKriteriaKeluarNICU;
import rekammedis.RMChecklistKriteriaKeluarPICU;
import rekammedis.RMChecklistKriteriaMasukHCU;
import rekammedis.RMChecklistKriteriaMasukICU;
import rekammedis.RMChecklistKriteriaMasukNICU;
import rekammedis.RMChecklistKriteriaMasukPICU;
import rekammedis.RMChecklistPemberianFibrinolitik;
import rekammedis.RMChecklistPostOperasi;
import rekammedis.RMChecklistPreOperasi;
import rekammedis.RMDataAsuhanGizi;
import rekammedis.RMDataCatatanCairanHemodialisa;
import rekammedis.RMDataCatatanCekGDS;
import rekammedis.RMDataCatatanKeperawatanRanap;
import rekammedis.RMDataCatatanKeseimbanganCairan;
import rekammedis.RMDataCatatanObservasiBayi;
import rekammedis.RMDataCatatanObservasiCHBP;
import rekammedis.RMDataCatatanObservasiHemodialisa;
import rekammedis.RMDataCatatanObservasiInduksiPersalinan;
import rekammedis.RMDataCatatanObservasiRanap;
import rekammedis.RMDataCatatanObservasiRanapKebidanan;
import rekammedis.RMDataCatatanObservasiRanapPostPartum;
import rekammedis.RMDataCatatanObservasiRestrainNonFarmakologi;
import rekammedis.RMDataCatatanObservasiVentilator;
import rekammedis.RMDataFollowUpDBD;
import rekammedis.RMDataMonitoringAsuhanGizi;
import rekammedis.RMDataMonitoringReaksiTranfusi;
import rekammedis.RMDataResumePasienRanap;
import rekammedis.RMDataSkriningGiziLanjut;
import rekammedis.RMHasilEndoskopiFaringLaring;
import rekammedis.RMHasilEndoskopiHidung;
import rekammedis.RMHasilEndoskopiTelinga;
import rekammedis.RMHasilPemeriksaanEKG;
import rekammedis.RMHasilPemeriksaanEcho;
import rekammedis.RMHasilPemeriksaanEchoPediatrik;
import rekammedis.RMHasilPemeriksaanOCT;
import rekammedis.RMHasilPemeriksaanSlitLamp;
import rekammedis.RMHasilPemeriksaanTreadmill;
import rekammedis.RMHasilPemeriksaanUSG;
import rekammedis.RMHasilPemeriksaanUSGGynecologi;
import rekammedis.RMHasilPemeriksaanUSGNeonatus;
import rekammedis.RMHasilPemeriksaanUSGUrologi;
import rekammedis.RMHasilTindakanESWL;
import rekammedis.RMKonselingFarmasi;
import rekammedis.RMLaporanTindakan;
import rekammedis.RMMonitoringAldrettePascaAnestesi;
import rekammedis.RMMonitoringBromagePascaAnestesi;
import rekammedis.RMMonitoringStewardPascaAnestesi;
import rekammedis.RMPelaksanaanInformasiEdukasi;
import rekammedis.RMPemantauanMEOWS;
import rekammedis.RMPemantauanPEWS;
import rekammedis.RMPemantauanEWSD;
import rekammedis.RMPemantauanEWSNeonatus;
import rekammedis.RMPengkajianRestrain;
import rekammedis.RMPenilaianAwalKeperawatanKebidananRanap;
import rekammedis.RMPenilaianAwalKeperawatanRanap;
import rekammedis.RMPenilaianAwalKeperawatanRanapBayiAnak;
import rekammedis.RMPenilaianAwalKeperawatanRanapNeonatus;
import rekammedis.RMPenilaianAwalMedisHemodialisa;
import rekammedis.RMPenilaianAwalMedisRanapDewasa;
import rekammedis.RMPenilaianAwalMedisRanapJantung;
import rekammedis.RMPenilaianAwalMedisRanapKandungan;
import rekammedis.RMPenilaianAwalMedisRanapNeonatus;
import rekammedis.RMPenilaianAwalMedisRanapPsikiatrik;
import rekammedis.RMPenilaianBayiBaruLahir;
import rekammedis.RMPenilaianDerajatDehidrasi;
import rekammedis.RMPenilaianFisioterapi;
import rekammedis.RMPenilaianKorbanKekerasan;
import rekammedis.RMPenilaianLanjutanRisikoJatuhAnak;
import rekammedis.RMPenilaianLanjutanRisikoJatuhDewasa;
import rekammedis.RMPenilaianLanjutanRisikoJatuhGeriatri;
import rekammedis.RMPenilaianLanjutanRisikoJatuhLansia;
import rekammedis.RMPenilaianLanjutanRisikoJatuhPsikiatri;
import rekammedis.RMPenilaianLanjutanSkriningFungsional;
import rekammedis.RMPenilaianLevelKecemasanRanapAnak;
import rekammedis.RMPenilaianPasienImunitasRendah;
import rekammedis.RMPenilaianPasienPenyakitMenular;
import rekammedis.RMPenilaianPasienTerminal;
import rekammedis.RMPenilaianPreAnastesi;
import rekammedis.RMPenilaianPreInduksi;
import rekammedis.RMPenilaianPreOperasi;
import rekammedis.RMPenilaianPsikologi;
import rekammedis.RMPenilaianPsikologiKlinis;
import rekammedis.RMPenilaianRisikoDekubitus;
import rekammedis.RMPenilaianRisikoJatuhNeonatus;
import rekammedis.RMPenilaianTambahanBunuhDiri;
import rekammedis.RMPenilaianTambahanGeriatri;
import rekammedis.RMPenilaianTambahanMelarikanDiri;
import rekammedis.RMPenilaianTambahanPerilakuKekerasan;
import rekammedis.RMPenilaianUlangNyeri;
import rekammedis.RMPerencanaanPemulangan;
import rekammedis.RMRekonsiliasiObat;
import rekammedis.RMSignInSebelumAnastesi;
import rekammedis.RMSignOutSebelumMenutupLuka;
import rekammedis.RMSkriningNutrisiAnak;
import rekammedis.RMSkriningNutrisiDewasa;
import rekammedis.RMSkriningNutrisiLansia;
import rekammedis.RMTimeOutSebelumInsisi;
import rekammedis.RMTransferPasienAntarRuang;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import kepegawaian.DlgCariDokter;
import kepegawaian.DlgCariPetugas;
import permintaan.DlgPermintaanKonsultasiPerawat;
import rekammedis.RMAdmisiSkoringTOLAC;
import rekammedis.RMChecklistKriteriaKeluarIsolasi;
import rekammedis.RMChecklistKriteriaMasukIsolasi;
import rekammedis.RMDataCatatanObservasiRuangOperasi;
import rekammedis.RMDataIntervensiNyeriFarmakologi;
import rekammedis.RMDataIntervensiNyeriNonFarmakologi;
import rekammedis.RMDataMonitoringTOLAC;
import rekammedis.RMDataSkriningGiziKehamilan;
import rekammedis.RMHasilPemeriksaanUSGAbdomen;
import rekammedis.RMHasilPersalinanTOLAC;
import rekammedis.RMReaksiTransfusi;
import rekammedis.PanelRiwayatRalan;

/**
 *
 * @author perpustakaan
 */
public final class DlgRawatInap extends javax.swing.JDialog {
    private final DefaultTableModel tabModeDr,tabModePr,tabModeDrPr,
            tabModePemeriksaan,tabModeObstetri,tabModeGinekologi;
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private Jurnal jur=new Jurnal();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private PanelRiwayatRalan panelRiwayatPerawatan;
    private volatile boolean ceksukses = false;
    private Connection koneksi=koneksiDB.condb();
    private PreparedStatement ps,ps2,ps3,ps4,ps5,ps6;
    private ResultSet rs;
    private int i=0,tinggi=0;
    private boolean sukses=false;  
    private double ttljmdokter=0,ttljmperawat=0,ttlkso=0,ttlpendapatan=0,ttljasasarana=0,ttlbhp=0,ttlmenejemen=0;
    private String kode_poli="",kamar="",jenisbayar="",TANGGALMUNDUR="yes";

    /** Creates new form DlgRawatInap
     * @param parent
     * @param modal */
    public DlgRawatInap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initRawatInap();
    TabRawat.addTab("Data Operasi", new PanelDataLamaOperasi());
        panelRiwayatPerawatan = new PanelRiwayatRalan(koneksi, false);
        panelRiwayatPerawatan.setOperationEditHandler((noRawat, tanggalOperasi) -> {
            DlgCariTagihanOperasi formOperasi = new DlgCariTagihanOperasi(null, false);
            formOperasi.bukaLaporanOperasiDariDataLama(noRawat, tanggalOperasi);
        });
        TabRawat.addTab("Riwayat Perawatan", panelRiwayatPerawatan);
        TabRawat.addChangeListener(e -> {
            if (TabRawat.getSelectedComponent() instanceof PanelDataLamaOperasi) {
                ((PanelDataLamaOperasi) TabRawat.getSelectedComponent()).tampil();
            } else if (TabRawat.getSelectedComponent() == panelRiwayatPerawatan) {
                panelRiwayatPerawatan.setNoRawat(TNoRw.getText());
            }
        });
        TNoRw.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            private void updateHistory() {
                if (panelRiwayatPerawatan != null && TabRawat.getSelectedComponent() == panelRiwayatPerawatan) {
                    panelRiwayatPerawatan.setNoRawat(TNoRw.getText());
                }
            }
            @Override public void insertUpdate(javax.swing.event.DocumentEvent event) { updateHistory(); }
            @Override public void removeUpdate(javax.swing.event.DocumentEvent event) { updateHistory(); }
            @Override public void changedUpdate(javax.swing.event.DocumentEvent event) { updateHistory(); }
        });

        this.setLocation(8,1);
        setSize(885,674);
        
        tabModeDr=new DefaultTableModel(null,new Object[]{
            "P","No.Rawat","No.R.M.","Nama Pasien","Perawatan/Tindakan","Kode Dokter","Dokter Yg Menangani","Tgl.Rawat","Jam Rawat","Biaya","Kode","Tarif Dokter","KSO","Jasa Sarana","BHP","Menejemen"}){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                 java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbRawatDr.setModel(tabModeDr);
        //tampilDr();

        tbRawatDr.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbRawatDr.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 16; i++) {
            TableColumn column = tbRawatDr.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(105);
            }else if(i==2){
                column.setPreferredWidth(70);
            }else if(i==3){
                column.setPreferredWidth(180);
            }else if(i==4){
                column.setPreferredWidth(180);
            }else if(i==5){
                column.setPreferredWidth(90);
            }else if(i==6){
                column.setPreferredWidth(180);
            }else if(i==7){
                column.setPreferredWidth(80);
            }else if(i==8){
                column.setPreferredWidth(75);
            }else if(i==9){
                column.setPreferredWidth(90);
            }else if(i==10){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==11){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==12){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==13){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==14){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==15){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }
        }
        tbRawatDr.setDefaultRenderer(Object.class, new WarnaTable());

        tabModePr=new DefaultTableModel(null,new Object[]{
            "P","No.Rawat","No.R.M.","Nama Pasien","Perawatan/Tindakan","NIP","Petugas Yg Menangani","Tgl.Rawat","Jam Rawat","Biaya","Kode","Tarif Perawat","KSO","Jasa Sarana","BHP","Menejemen"}){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                 java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbRawatPr.setModel(tabModePr);
        tbRawatPr.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbRawatPr.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 16; i++) {
            TableColumn column = tbRawatPr.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(105);
            }else if(i==2){
                column.setPreferredWidth(70);
            }else if(i==3){
                column.setPreferredWidth(180);
            }else if(i==4){
                column.setPreferredWidth(180);
            }else if(i==5){
                column.setPreferredWidth(90);
            }else if(i==6){
                column.setPreferredWidth(180);
            }else if(i==7){
                column.setPreferredWidth(80);
            }else if(i==8){
                column.setPreferredWidth(75);
            }else if(i==9){
                column.setPreferredWidth(90);
            }else if(i==10){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==11){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==12){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==13){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==14){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==15){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }
        }
        tbRawatPr.setDefaultRenderer(Object.class, new WarnaTable());
        
        tabModeDrPr=new DefaultTableModel(null,new Object[]{
            "P","No.Rawat","No.R.M.","Nama Pasien","Perawatan/Tindakan","Kode Dokter",
            "Dokter Yg Menangani","NIP","Petugas Yg Menangani","Tgl.Rawat","Jam Rawat",
            "Biaya","Kode","Tarif Dokter","Tarif Petugas","KSO","Jasa Sarana","BHP","Menejemen"}){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                 java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,java.lang.Object.class,
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbRawatDrPr.setModel(tabModeDrPr);
        tbRawatDrPr.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbRawatDrPr.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 19; i++) {
            TableColumn column = tbRawatDrPr.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(105);
            }else if(i==2){
                column.setPreferredWidth(70);
            }else if(i==3){
                column.setPreferredWidth(180);
            }else if(i==4){
                column.setPreferredWidth(180);
            }else if(i==5){
                column.setPreferredWidth(90);
            }else if(i==6){
                column.setPreferredWidth(180);
            }else if(i==7){
                column.setPreferredWidth(90);
            }else if(i==8){
                column.setPreferredWidth(180);
            }else if(i==9){
                column.setPreferredWidth(80);
            }else if(i==10){
                column.setPreferredWidth(75);
            }else if(i==11){
                column.setPreferredWidth(90);
            }else if(i==12){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==13){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==14){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==15){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==16){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==17){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==18){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }
        }
        tbRawatDrPr.setDefaultRenderer(Object.class, new WarnaTable());
        
        tabModePemeriksaan=new DefaultTableModel(null,new Object[]{
            "P","No.Rawat","No.R.M.","Nama Pasien","Tgl.Rawat","Jam","Suhu(C)","Tensi","Nadi(/menit)",
            "Respirasi(/menit)","Tinggi(Cm)","Berat(Kg)","SpO2(%)","GCS(E,V,M)","Kesadaran","Subjek","Objek","Alergi","Asesmen","Plan",
            "Inst/Impl","Evaluasi","NIP","Dokter/Paramedis","Profesi/Jabatan","StatusVerifikasi"}){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                 java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,java.lang.Object.class,
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                 java.lang.Object.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbPemeriksaan.setModel(tabModePemeriksaan);
        tbPemeriksaan.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbPemeriksaan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 25; i++) {
            TableColumn column = tbPemeriksaan.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(105);
            }else if(i==2){
                column.setPreferredWidth(70);
            }else if(i==3){
                column.setPreferredWidth(150);
            }else if(i==4){
                column.setPreferredWidth(65);
            }else if(i==5){
                column.setPreferredWidth(50);
            }else if(i==6){
                column.setPreferredWidth(45);
            }else if(i==7){
                column.setPreferredWidth(60);
            }else if(i==8){
                column.setPreferredWidth(73);
            }else if(i==9){
                column.setPreferredWidth(90);
            }else if(i==10){
                column.setPreferredWidth(63);
            }else if(i==11){
                column.setPreferredWidth(57);
            }else if(i==12){
                column.setPreferredWidth(50);
            }else if(i==13){
                column.setPreferredWidth(64);
            }else if(i==14){
                column.setPreferredWidth(90);
            }else if(i==15){
                column.setPreferredWidth(180);
            }else if(i==16){
                column.setPreferredWidth(180);
            }else if(i==17){
                column.setPreferredWidth(130);
            }else if(i==18){
                column.setPreferredWidth(180);
            }else if(i==19){
                column.setPreferredWidth(180);
            }else if(i==20){
                column.setPreferredWidth(180);
            }else if(i==21){
                column.setPreferredWidth(180);
            }else if(i==22){
                column.setPreferredWidth(80);
            }else if(i==23){
                column.setPreferredWidth(150);
            }else if(i==24){
                column.setPreferredWidth(100);
            }
        }
        tbPemeriksaan.setDefaultRenderer(Object.class,
            new javax.swing.table.DefaultTableCellRenderer() {
                private final java.awt.Color HIJAU_AKTIF =
                    new java.awt.Color(220, 245, 220);
                private final java.awt.Color PUTIH =
                    new java.awt.Color(255, 255, 255);
                private final java.awt.Color ZEBRA =
                    new java.awt.Color(245, 250, 245);

                @Override
                public java.awt.Component getTableCellRendererComponent(
                        javax.swing.JTable table, Object value,
                        boolean isSelected, boolean hasFocus,
                        int row, int column) {
                    java.awt.Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                    if (!isSelected) {
                        int modelRow = table.convertRowIndexToModel(row);
                        Object status = table.getModel().getValueAt(modelRow, 25);
                        boolean aktif = Boolean.TRUE.equals(status)
                            || "true".equalsIgnoreCase(String.valueOf(status))
                            || "1".equals(String.valueOf(status));

                        c.setBackground(aktif ? HIJAU_AKTIF
                            : (row % 2 == 1 ? ZEBRA : PUTIH));
                    }
                    return c;
                }
            });

        // Kolom status digunakan secara internal dan tidak ditampilkan.
        TableColumn kolomStatusSOAP =
            tbPemeriksaan.getColumnModel().getColumn(25);
        kolomStatusSOAP.setMinWidth(0);
        kolomStatusSOAP.setMaxWidth(0);
        kolomStatusSOAP.setPreferredWidth(0);
        
        tabModeObstetri=new DefaultTableModel(null,new Object[]{
            "P","No.Rawat","No.R.M","Nama Pasien","Tgl.Rawat","Jam Rawat",
            "Tinggi Fundus","Janin", "Letak","Panggul","Denyut","Kontraksi",
            "Kualitas Mnt", "Kualitas Detik","Fluksus","Albus","Vulva",
            "Portio","Dalam","Tebal","Arah","Pembukaan","Penurunan",
            "Denominator","Ketuban","Feto"}) {
             @Override public boolean isCellEditable(int rowIndex, int colIndex) {
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
            }
            Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        };
        
        tbPemeriksaanObstetri.setModel(tabModeObstetri);
        tbPemeriksaanObstetri.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbPemeriksaanObstetri.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        for (i = 0; i < 26; i++) {
            TableColumn column = tbPemeriksaanObstetri.getColumnModel().getColumn(i);
            if(i==0) {
                column.setPreferredWidth(20);
            }else if(i==1) {
                column.setPreferredWidth(105);
            }else if(i==2) {
                column.setPreferredWidth(70);
            }else if(i==3) {
                column.setPreferredWidth(180);
            }else if(i==4) {
                column.setPreferredWidth(80);
            }else if(i==5) {
                column.setPreferredWidth(70);
            }else if(i==6) {
                column.setPreferredWidth(80);
            }else if(i==7) {
                column.setPreferredWidth(60);
            }else if(i==8) {
                column.setPreferredWidth(60);
            }else if(i==9) {
                column.setPreferredWidth(60);
            }else if(i==10) {
                column.setPreferredWidth(60);
            }else if(i==11) {
                column.setPreferredWidth(60);
            }else if(i==12) {
                column.setPreferredWidth(70);
            }else if(i==13) {
                column.setPreferredWidth(80);
            }else if(i==14) {
                column.setPreferredWidth(50);
            }else if(i==15) {
                column.setPreferredWidth(40);
            }else if(i==16) {
                column.setPreferredWidth(170);
            }else if(i==17) {
                column.setPreferredWidth(170);
            }else if(i==18) {
                column.setPreferredWidth(60);
            }else if(i==19) {
                column.setPreferredWidth(50);
            }else if(i==20) {
                column.setPreferredWidth(60);
            }else if(i==21) {
                column.setPreferredWidth(170);
            }else if(i==22) {
                column.setPreferredWidth(170);
            }else if(i==23) {
                column.setPreferredWidth(170);
            }else if(i==24) {
                column.setPreferredWidth(50);
            }else if(i==25) {
                column.setPreferredWidth(70);
            }
        }
        tbPemeriksaanObstetri.setDefaultRenderer(Object.class, new WarnaTable());
        
        tabModeGinekologi=new DefaultTableModel(null,new Object[]{
            "P","No.Rawat","No.R.M","Nama Pasien","Tgl.Rawat","Jam Rawat",
            "Inpeksi","Inspeksi Vulva/Uretra/Vagina", "Inspekulo","Fluxus",
            "Fluor Albus", "Inspekulo Vulva/Vagina", "Inspekulo Portio", "Inspekulo Sondage",
            "Pemeriksaan Dalam Portio", "Pemeriksaan Dalam Bentuk","Pemeriksaan Dalam Cavum Uteri","Mobilitas",
            "Ukuran Cavum Uteri","Nyeri Tekan","Pemeriksaan Dalam Adnexa Kanan","Pemeriksaan Dalam Adnexa Kiri",
            "Pemeriksaan Dalam Cavum Douglas"}) {
             @Override public boolean isCellEditable(int rowIndex, int colIndex) {
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
            }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,
                 java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                 java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                 java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                 java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                 java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                 java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                 java.lang.Object.class,java.lang.Object.class
                 
             };
            @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
                }
            };
        
        tbPemeriksaanGinekologi.setModel(tabModeGinekologi);
        tbPemeriksaanGinekologi.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbPemeriksaanGinekologi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        for (i = 0; i < 23; i++) {
            TableColumn column = tbPemeriksaanGinekologi.getColumnModel().getColumn(i);
            if(i==0) {
                column.setPreferredWidth(20);
            }else if(i==1) {
                column.setPreferredWidth(105);
            }else if(i==2) {
                column.setPreferredWidth(70);
            }else if(i==3) {
                column.setPreferredWidth(180);
            }else if(i==4) {
                column.setPreferredWidth(80);
            }else if(i==5) {
                column.setPreferredWidth(70);
            }else if(i==6) {
                column.setPreferredWidth(200);
            }else if(i==7) {
                column.setPreferredWidth(200);
            }else if(i==8) {
                column.setPreferredWidth(200);
            }else if(i==9) {
                column.setPreferredWidth(42);
            }else if(i==10) {
                column.setPreferredWidth(62);
            }else if(i==11) {
                column.setPreferredWidth(200);
            }else if(i==12) {
                column.setPreferredWidth(200);
            }else if(i==13) {
                column.setPreferredWidth(200);
            }else if(i==14) {
                column.setPreferredWidth(200);
            }else if(i==15) {
                column.setPreferredWidth(200);
            }else if(i==16) {
                column.setPreferredWidth(200);
            }else if(i==17) {
                column.setPreferredWidth(50);
            }else if(i==18) {
                column.setPreferredWidth(200);
            }else if(i==19) {
                column.setPreferredWidth(67);
            }else if(i==20) {
                column.setPreferredWidth(200);
            }else if(i==21) {
                column.setPreferredWidth(200);
            }else if(i==22) {
                column.setPreferredWidth(200);
            }  
        }
        tbPemeriksaanGinekologi.setDefaultRenderer(Object.class, new WarnaTable());

        kdptg.setDocument(new batasInput((byte)20).getKata(kdptg));
        kdptg2.setDocument(new batasInput((byte)20).getKata(kdptg2));
        KdDok.setDocument(new batasInput((byte)20).getKata(KdDok));
        KdDok2.setDocument(new batasInput((byte)20).getKata(KdDok2));
        TNoRw.setDocument(new batasInput((byte)17).getKata(TNoRw));        
        TKdPrw.setDocument(new batasInput((byte)15).getKata(TKdPrw));
        TKdPrwPetugas.setDocument(new batasInput((byte)15).getKata(TKdPrwPetugas));
        TKdPrwDokterPetugas.setDocument(new batasInput((byte)15).getKata(TKdPrwDokterPetugas));
        TSuhu.setDocument(new batasInput((byte)5).getKata(TSuhu));
        TLetak.setDocument(new batasInput((byte)50).getKata(TLetak));
        TTensi.setDocument(new batasInput((byte)8).getKata(TTensi));
        TCariPasien.setDocument(new batasInput((byte)20).getKata(TCariPasien));
        TKeluhan.setDocument(new batasInput((int)2000).getKata(TKeluhan));  
        TPemeriksaan.setDocument(new batasInput((int)2000).getKata(TPemeriksaan));    
        TPenilaian.setDocument(new batasInput((int)2000).getKata(TPenilaian));  
        TEvaluasi.setDocument(new batasInput((int)2000).getKata(TEvaluasi));
        TindakLanjut.setDocument(new batasInput((int)2000).getKata(TindakLanjut));  
        TInstruksi.setDocument(new batasInput((int)2000).getKata(TInstruksi));      
        TTinggi.setDocument(new batasInput((byte)5).getKata(TTinggi));
        TBerat.setDocument(new batasInput((byte)5).getKata(TBerat));
        SpO2.setDocument(new batasInput((byte)3).getOnlyAngka(SpO2));
        TNadi.setDocument(new batasInput((byte)3).getOnlyAngka(TNadi));
        TRespirasi.setDocument(new batasInput((byte)3).getOnlyAngka(TRespirasi));      
        TGCS.setDocument(new batasInput((byte)10).getKata(TGCS)); 
        TAlergi.setDocument(new batasInput((int)50).getKata(TAlergi));        
        TCari.setDocument(new batasInput((int)100).getKata(TCari));       
        TInspeksi.setDocument(new batasInput((byte)50).getKata(TInspeksi));
        TInspeksiVulva.setDocument(new batasInput((byte)50).getKata(TInspeksiVulva));
        TInspekuloGine.setDocument(new batasInput((byte)50).getKata(TInspekuloGine));
        TVulvaInspekulo.setDocument(new batasInput((byte)50).getKata(TVulvaInspekulo));
        TPortioInspekulo.setDocument(new batasInput((byte)50).getKata(TPortioInspekulo));
        TSondage.setDocument(new batasInput((byte)50).getKata(TSondage));
        TPortioDalam.setDocument(new batasInput((byte)50).getKata(TPortioDalam));
        TBentuk.setDocument(new batasInput((byte)50).getKata(TBentuk));
        TCavumUteri.setDocument(new batasInput((byte)50).getKata(TCavumUteri));
        TUkuran.setDocument(new batasInput((byte)50).getKata(TUkuran));
        TAdnexaKanan.setDocument(new batasInput((byte)50).getKata(TAdnexaKanan));
        TAdnexaKiri.setDocument(new batasInput((byte)50).getKata(TAdnexaKiri));
        TCavumDouglas.setDocument(new batasInput((byte)50).getKata(TCavumDouglas));
        
        ChkInput.setSelected(false);
        isForm(); 
        ChkInput1.setSelected(false);
        isForm2();
        ChkInput2.setSelected(false);
        isForm3(); 
        ChkAccor.setSelected(true);
        isMenu();
        jam();
        
        try {
            TANGGALMUNDUR=koneksiDB.TANGGALMUNDUR();
        } catch (Exception e) {
            TANGGALMUNDUR="yes";
        }
    }
    
    


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BagianRS = new javax.swing.JTextField();
        Bhp = new javax.swing.JTextField();
        JmDokter = new javax.swing.JTextField();
        JmPerawat = new javax.swing.JTextField();
        TTnd = new javax.swing.JTextField();
        KSO = new javax.swing.JTextField();
        Menejemen = new javax.swing.JTextField();
        internalFrame1 = new widget.InternalFrame();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnEdit = new widget.Button();
        BtnPrint = new widget.Button();
        BtnAll = new widget.Button();
        jLabel10 = new widget.Label();
        LCount = new widget.Label();
        BtnKeluar = new widget.Button();
        panelGlass10 = new widget.panelisi();
        jLabel19 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel21 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        jLabel20 = new widget.Label();
        TCariPasien = new widget.TextBox();
        btnPasien = new widget.Button();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        TabRawat = new widget.TabPane();
        internalFrame2 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbRawatDr = new widget.Table();
        panelGlass7 = new widget.panelisi();
        jLabel5 = new widget.Label();
        KdDok = new widget.TextBox();
        BtnSeekDokter = new widget.Button();
        TDokter = new widget.TextBox();
        jLabel11 = new widget.Label();
        TKdPrw = new widget.TextBox();
        TNmPrw = new widget.TextBox();
        btnTindakan = new widget.Button();
        btnTindakan3 = new widget.Button();
        internalFrame3 = new widget.InternalFrame();
        Scroll1 = new widget.ScrollPane();
        tbRawatPr = new widget.Table();
        panelGlass13 = new widget.panelisi();
        jLabel13 = new widget.Label();
        kdptg = new widget.TextBox();
        BtnSeekPetugas = new widget.Button();
        TPerawat = new widget.TextBox();
        jLabel28 = new widget.Label();
        TKdPrwPetugas = new widget.TextBox();
        TNmPrwPetugas = new widget.TextBox();
        btnTindakan4 = new widget.Button();
        btnTindakan5 = new widget.Button();
        internalFrame4 = new widget.InternalFrame();
        Scroll2 = new widget.ScrollPane();
        tbRawatDrPr = new widget.Table();
        panelGlass11 = new widget.panelisi();
        jLabel14 = new widget.Label();
        kdptg2 = new widget.TextBox();
        BtnSeekPetugas2 = new widget.Button();
        TPerawat2 = new widget.TextBox();
        jLabel12 = new widget.Label();
        KdDok2 = new widget.TextBox();
        TDokter2 = new widget.TextBox();
        BtnSeekDokter2 = new widget.Button();
        jLabel29 = new widget.Label();
        TKdPrwDokterPetugas = new widget.TextBox();
        TNmPrwDokterPetugas = new widget.TextBox();
        btnTindakan6 = new widget.Button();
        btnTindakan7 = new widget.Button();
        internalFrame5 = new widget.InternalFrame();
        Scroll3 = new widget.ScrollPane();
        tbPemeriksaan = new widget.Table();
        PanelInput1 = new javax.swing.JPanel();
        ChkInput = new widget.CekBox();
        panelGlass12 = new widget.panelisi();
        jLabel15 = new widget.Label();
        TAlergi = new widget.TextBox();
        scrollPane1 = new widget.ScrollPane();
        TKeluhan = new widget.TextArea();
        scrollPane2 = new widget.ScrollPane();
        TPemeriksaan = new widget.TextArea();
        jLabel8 = new widget.Label();
        jLabel9 = new widget.Label();
        scrollPane3 = new widget.ScrollPane();
        TPenilaian = new widget.TextArea();
        jLabel37 = new widget.Label();
        jLabel26 = new widget.Label();
        scrollPane4 = new widget.ScrollPane();
        TindakLanjut = new widget.TextArea();
        jLabel53 = new widget.Label();
        KdPeg = new widget.TextBox();
        TPegawai = new widget.TextBox();
        BtnSeekPegawai = new widget.Button();
        Jabatan = new widget.TextBox();
        jLabel54 = new widget.Label();
        jLabel55 = new widget.Label();
        scrollPane7 = new widget.ScrollPane();
        TInstruksi = new widget.TextArea();
        jLabel56 = new widget.Label();
        SpO2 = new widget.TextBox();
        jLabel22 = new widget.Label();
        TGCS = new widget.TextBox();
        jLabel58 = new widget.Label();
        cmbKesadaran = new widget.ComboBox();
        scrollPane8 = new widget.ScrollPane();
        TEvaluasi = new widget.TextArea();
        jLabel59 = new widget.Label();
        Btn5Soap = new widget.Button();
        BtnStatusVerifikasiSOAP = new widget.Button();
        BtnRiwayatSOAP = new widget.Button();
        BtnVerifikasiSOAP = new widget.Button();
        jLabel7 = new widget.Label();
        TSuhu = new widget.TextBox();
        jLabel17 = new widget.Label();
        TTinggi = new widget.TextBox();
        jLabel4 = new widget.Label();
        TTensi = new widget.TextBox();
        TRespirasi = new widget.TextBox();
        jLabel41 = new widget.Label();
        jLabel16 = new widget.Label();
        TBerat = new widget.TextBox();
        TNadi = new widget.TextBox();
        jLabel61 = new widget.Label();
        internalFrame6 = new widget.InternalFrame();
        Scroll4 = new widget.ScrollPane();
        tbPemeriksaanObstetri = new widget.Table();
        PanelInput2 = new javax.swing.JPanel();
        ChkInput1 = new widget.CekBox();
        panelGlass14 = new widget.panelisi();
        jLabel27 = new widget.Label();
        TTinggi_uteri = new widget.TextBox();
        jLabel30 = new widget.Label();
        jLabel31 = new widget.Label();
        TLetak = new widget.TextBox();
        jLabel32 = new widget.Label();
        TKualitas_dtk = new widget.TextBox();
        jLabel33 = new widget.Label();
        cmbPanggul = new widget.ComboBox();
        jLabel34 = new widget.Label();
        TTebal = new widget.TextBox();
        TDenyut = new widget.TextBox();
        jLabel36 = new widget.Label();
        TDenominator = new widget.TextBox();
        jLabel38 = new widget.Label();
        jLabel39 = new widget.Label();
        TKualitas_mnt = new widget.TextBox();
        jLabel40 = new widget.Label();
        cmbFeto = new widget.ComboBox();
        jLabel42 = new widget.Label();
        cmbJanin = new widget.ComboBox();
        cmbKetuban = new widget.ComboBox();
        TPortio = new widget.TextBox();
        jLabel43 = new widget.Label();
        TVulva = new widget.TextBox();
        cmbKontraksi = new widget.ComboBox();
        cmbAlbus = new widget.ComboBox();
        jLabel45 = new widget.Label();
        jLabel46 = new widget.Label();
        jLabel47 = new widget.Label();
        jLabel44 = new widget.Label();
        cmbFluksus = new widget.ComboBox();
        jLabel48 = new widget.Label();
        cmbDalam = new widget.ComboBox();
        jLabel49 = new widget.Label();
        TPembukaan = new widget.TextBox();
        TPenurunan = new widget.TextBox();
        jLabel50 = new widget.Label();
        jLabel51 = new widget.Label();
        cmbArah = new widget.ComboBox();
        jLabel52 = new widget.Label();
        internalFrame7 = new widget.InternalFrame();
        Scroll5 = new widget.ScrollPane();
        tbPemeriksaanGinekologi = new widget.Table();
        PanelInput3 = new javax.swing.JPanel();
        ChkInput2 = new widget.CekBox();
        panelGlass15 = new widget.panelisi();
        jLabel35 = new widget.Label();
        TInspeksiVulva = new widget.TextBox();
        TAdnexaKanan = new widget.TextBox();
        jLabel57 = new widget.Label();
        cmbMobilitas = new widget.ComboBox();
        jLabel60 = new widget.Label();
        TInspekuloGine = new widget.TextBox();
        jLabel62 = new widget.Label();
        jLabel64 = new widget.Label();
        jLabel67 = new widget.Label();
        TPortioInspekulo = new widget.TextBox();
        TCavumUteri = new widget.TextBox();
        cmbFluorGine = new widget.ComboBox();
        TInspeksi = new widget.TextBox();
        cmbFluxusGine = new widget.ComboBox();
        jLabel71 = new widget.Label();
        jLabel72 = new widget.Label();
        jLabel73 = new widget.Label();
        jLabel74 = new widget.Label();
        jLabel75 = new widget.Label();
        TVulvaInspekulo = new widget.TextBox();
        jLabel76 = new widget.Label();
        jLabel77 = new widget.Label();
        TPortioDalam = new widget.TextBox();
        TBentuk = new widget.TextBox();
        jLabel78 = new widget.Label();
        cmbNyeriTekan = new widget.ComboBox();
        TSondage = new widget.TextBox();
        jLabel79 = new widget.Label();
        jLabel80 = new widget.Label();
        TAdnexaKiri = new widget.TextBox();
        jLabel81 = new widget.Label();
        TCavumDouglas = new widget.TextBox();
        TUkuran = new widget.TextBox();
        jLabel82 = new widget.Label();
        jLabel83 = new widget.Label();
        FormInput = new widget.PanelBiasa();
        jLabel3 = new widget.Label();
        TNoRw = new widget.TextBox();
        TNoRM = new widget.TextBox();
        TPasien = new widget.TextBox();
        DTPTgl = new widget.Tanggal();
        jLabel18 = new widget.Label();
        cmbJam = new widget.ComboBox();
        cmbMnt = new widget.ComboBox();
        cmbDtk = new widget.ComboBox();
        ChkJln = new widget.CekBox();
        PanelAccor = new widget.PanelBiasa();
        ChkAccor = new widget.CekBox();
        ScrollMenu = new widget.ScrollPane();
        FormMenu = new widget.PanelBiasa();
        BtnRiwayat = new widget.Button();
        BtnResepObat = new widget.Button();
        BtnCopyResep = new widget.Button();
        BtnPermintaanStok = new widget.Button();
        BtnPermintaanResepPulang = new widget.Button();
        BtnInputObat = new widget.Button();
        BtnObatBhp = new widget.Button();
        BtnBerkasDigital = new widget.Button();
        BtnPermintaanLab = new widget.Button();
        BtnPermintaanRad = new widget.Button();
        BtnJadwalOperasi = new widget.Button();
        BtnSKDP = new widget.Button();
        BtnRujukKeluar = new widget.Button();
        BtnDiagnosa = new widget.Button();
        BtnResume = new widget.Button();
        BtnAwalKeperawatanUmum = new widget.Button();
        BtnAwalKeperawatanKandungan = new widget.Button();
        BtnAwalFisioterapi = new widget.Button();
        BtnAwalMedis = new widget.Button();
        BtnAwalMedisKandungan = new widget.Button();
        BtnAwalMedisHemodialisa = new widget.Button();
        BtnChecklistPreOperasi = new widget.Button();
        BtnSignInSebelumAnestesi = new widget.Button();
        BtnTimeOutSebelumInsisi = new widget.Button();
        BtnSignOutSebelumMenutupLuka = new widget.Button();
        BtnChecklistPostOperasi = new widget.Button();
        BtnPenilaianPreOperasi = new widget.Button();
        BtnPenilaianPreAnestesi = new widget.Button();
        BtnSkorAldrettePascaAnestesi = new widget.Button();
        BtnSkorStewardPascaAnestesi = new widget.Button();
        BtnPenilaianPsikolog = new widget.Button();
        BtnPerencanaanPemulangan = new widget.Button();
        BtnPenilaianLanjutanResikoJatuhDewasa = new widget.Button();
        BtnPenilaianLanjutanResikoJatuhAnak = new widget.Button();
        BtnPenilaianLanjutanResikoJatuhLansia = new widget.Button();
        BtnPenilaianLanjutanResikoJatuhNeonatus = new widget.Button();
        BtnPenilaianLanjutanResikoJatuhGeriatri = new widget.Button();
        BtnPenilaianLanjutanResikoJatuhPsikiatri = new widget.Button();
        BtnPenilaianLanjutanSkriningFungsional = new widget.Button();
        BtnPenilaianResikoDekubitus = new widget.Button();
        BtnHasilPemeriksaanUSG = new widget.Button();
        BtnDokumentasiESWL = new widget.Button();
        BtnCatatanPersalinan = new widget.Button();
        BtnCatatan = new widget.Button();
        BtnCatatanObservasiRanap = new widget.Button();
        BtnCatatanObservasiRanapKebidanan = new widget.Button();
        BtnCatatanObservasiRanapPostPartum = new widget.Button();
        BtnFollowUpDBD = new widget.Button();
        BtnCatatanKeperawatan = new widget.Button();
        BtnCatatanCekGDS = new widget.Button();
        BtnPenilaianUlangNyeri = new widget.Button();
        BtnPemantauanPEWSAnak = new widget.Button();
        BtnPemantauanPEWSDewasa = new widget.Button();
        BtnPemantauanMEOWS = new widget.Button();
        BtnPemantauanEWSNeonatus = new widget.Button();
        BtnChecklistKriteriaMasukHCU = new widget.Button();
        BtnChecklistKriteriaKeluarHCU = new widget.Button();
        BtnChecklistKriteriaMasukICU = new widget.Button();
        BtnChecklistKriteriaKeluarICU = new widget.Button();
        BtnMonitoringReaksiTranfusi = new widget.Button();
        BtnSkriningNutrisiDewasa = new widget.Button();
        BtnSkriningNutrisiLansia = new widget.Button();
        BtnSkriningNutrisiAnak = new widget.Button();
        BtnSkriningGiziLanjut = new widget.Button();
        BtnAsuhanGizi = new widget.Button();
        BtnMonitoringAsuhanGizi = new widget.Button();
        BtnCatatanADIMEGizi = new widget.Button();
        BtnKonselingFarmasi = new widget.Button();
        BtnInformasiObat = new widget.Button();
        BtnRekonsiliasiObat = new widget.Button();
        BtnTransferAntarRuang = new widget.Button();
        BtnPengkajianRestrain = new widget.Button();
        BtnPenilaianPasienTerminal = new widget.Button();
        BtnPenilaianKorbanKekerasan = new widget.Button();
        BtnPenilaianKecemasanAnak = new widget.Button();
        BtnPenilaianPasienPenyakitMenular = new widget.Button();
        BtnPenilaianTambahanGeriatri = new widget.Button();
        BtnPenilaianTambahanBunuhDiri = new widget.Button();
        BtnPenilaianTambahanPerilakuKekerasan = new widget.Button();
        BtnPenilaianTambahanMelarikanDiri = new widget.Button();

        BagianRS.setEditable(false);
        BagianRS.setText("0");
        BagianRS.setName("BagianRS"); // NOI18N

        Bhp.setEditable(false);
        Bhp.setText("0");
        Bhp.setName("Bhp"); // NOI18N

        JmDokter.setEditable(false);
        JmDokter.setText("0");
        JmDokter.setName("JmDokter"); // NOI18N

        JmPerawat.setEditable(false);
        JmPerawat.setText("0");
        JmPerawat.setName("JmPerawat"); // NOI18N

        TTnd.setEditable(false);
        TTnd.setText("0");
        TTnd.setName("TTnd"); // NOI18N

        KSO.setEditable(false);
        KSO.setText("0");
        KSO.setName("KSO"); // NOI18N

        Menejemen.setEditable(false);
        Menejemen.setText("0");
        Menejemen.setName("Menejemen"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Perawatan/Tindakan Rawat Inap ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        jPanel3.setBackground(new java.awt.Color(215, 225, 215));
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 100));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Simpan");
        BtnSimpan.setToolTipText("Alt+S");
        BtnSimpan.setIconTextGap(3);
        BtnSimpan.setName("BtnSimpan"); // NOI18N
        BtnSimpan.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        BtnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnSimpan);

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnBatal.setMnemonic('B');
        BtnBatal.setText("Baru");
        BtnBatal.setToolTipText("Alt+B");
        BtnBatal.setIconTextGap(3);
        BtnBatal.setName("BtnBatal"); // NOI18N
        BtnBatal.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });
        BtnBatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBatalKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnBatal);

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapus.setMnemonic('H');
        BtnHapus.setText("Hapus");
        BtnHapus.setToolTipText("Alt+H");
        BtnHapus.setIconTextGap(3);
        BtnHapus.setName("BtnHapus"); // NOI18N
        BtnHapus.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });
        BtnHapus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnHapus);

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); // NOI18N
        BtnEdit.setMnemonic('G');
        BtnEdit.setText("Ganti");
        BtnEdit.setToolTipText("Alt+G");
        BtnEdit.setIconTextGap(3);
        BtnEdit.setName("BtnEdit"); // NOI18N
        BtnEdit.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });
        BtnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnEditKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnEdit);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setIconTextGap(3);
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnPrint);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setIconTextGap(3);
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnAll);

        jLabel10.setText("Record :");
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(95, 30));
        panelGlass8.add(jLabel10);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(87, 30));
        panelGlass8.add(LCount);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setIconTextGap(3);
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnKeluar);

        jPanel3.add(panelGlass8, java.awt.BorderLayout.CENTER);

        panelGlass10.setName("panelGlass10"); // NOI18N
        panelGlass10.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 10));

        jLabel19.setText("Tgl.Rawat :");
        jLabel19.setName("jLabel19"); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(64, 23));
        panelGlass10.add(jLabel19);

        DTPCari1.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "18-12-2023" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy");
        DTPCari1.setName("DTPCari1"); // NOI18N
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(95, 23));
        panelGlass10.add(DTPCari1);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("s.d.");
        jLabel21.setName("jLabel21"); // NOI18N
        jLabel21.setPreferredSize(new java.awt.Dimension(23, 23));
        panelGlass10.add(jLabel21);

        DTPCari2.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "18-12-2023" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(95, 23));
        panelGlass10.add(DTPCari2);

        jLabel20.setText("No.RM :");
        jLabel20.setName("jLabel20"); // NOI18N
        jLabel20.setPreferredSize(new java.awt.Dimension(55, 23));
        panelGlass10.add(jLabel20);

        TCariPasien.setName("TCariPasien"); // NOI18N
        TCariPasien.setPreferredSize(new java.awt.Dimension(140, 23));
        panelGlass10.add(TCariPasien);

        btnPasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPasien.setMnemonic('6');
        btnPasien.setToolTipText("Alt+6");
        btnPasien.setName("btnPasien"); // NOI18N
        btnPasien.setPreferredSize(new java.awt.Dimension(28, 23));
        btnPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasienActionPerformed(evt);
            }
        });
        btnPasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPasienKeyPressed(evt);
            }
        });
        panelGlass10.add(btnPasien);

        jSeparator5.setBackground(new java.awt.Color(220, 225, 215));
        jSeparator5.setForeground(new java.awt.Color(220, 225, 215));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setName("jSeparator5"); // NOI18N
        jSeparator5.setOpaque(true);
        jSeparator5.setPreferredSize(new java.awt.Dimension(1, 23));
        panelGlass10.add(jSeparator5);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass10.add(jLabel6);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(273, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass10.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('7');
        BtnCari.setToolTipText("Alt+7");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass10.add(BtnCari);

        jPanel3.add(panelGlass10, java.awt.BorderLayout.PAGE_START);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        TabRawat.setBackground(new java.awt.Color(255, 255, 253));
        TabRawat.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TabRawat.setName("TabRawat"); // NOI18N
        TabRawat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabRawatMouseClicked(evt);
            }
        });

        internalFrame2.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame2.setName("internalFrame2"); // NOI18N
        internalFrame2.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbRawatDr.setAutoCreateRowSorter(false);
        tbRawatDr.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbRawatDr.setName("tbRawatDr"); // NOI18N
        tbRawatDr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRawatDrMouseClicked(evt);
            }
        });
        tbRawatDr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbRawatDrKeyReleased(evt);
            }
        });
        Scroll.setViewportView(tbRawatDr);

        internalFrame2.add(Scroll, java.awt.BorderLayout.CENTER);

        panelGlass7.setName("panelGlass7"); // NOI18N
        panelGlass7.setPreferredSize(new java.awt.Dimension(44, 74));
        panelGlass7.setLayout(null);

        jLabel5.setText("Dokter :");
        jLabel5.setName("jLabel5"); // NOI18N
        panelGlass7.add(jLabel5);
        jLabel5.setBounds(0, 10, 105, 23);

        KdDok.setHighlighter(null);
        KdDok.setName("KdDok"); // NOI18N
        KdDok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdDokKeyPressed(evt);
            }
        });
        panelGlass7.add(KdDok);
        KdDok.setBounds(108, 10, 130, 23);

        BtnSeekDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeekDokter.setMnemonic('4');
        BtnSeekDokter.setToolTipText("ALt+4");
        BtnSeekDokter.setName("BtnSeekDokter"); // NOI18N
        BtnSeekDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeekDokterActionPerformed(evt);
            }
        });
        panelGlass7.add(BtnSeekDokter);
        BtnSeekDokter.setBounds(849, 10, 28, 23);

        TDokter.setEditable(false);
        TDokter.setHighlighter(null);
        TDokter.setName("TDokter"); // NOI18N
        panelGlass7.add(TDokter);
        TDokter.setBounds(240, 10, 606, 23);

        jLabel11.setText("Tindakan/Tagihan :");
        jLabel11.setName("jLabel11"); // NOI18N
        panelGlass7.add(jLabel11);
        jLabel11.setBounds(0, 40, 105, 23);

        TKdPrw.setName("TKdPrw"); // NOI18N
        TKdPrw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TKdPrwKeyPressed(evt);
            }
        });
        panelGlass7.add(TKdPrw);
        TKdPrw.setBounds(108, 40, 100, 23);

        TNmPrw.setEditable(false);
        TNmPrw.setName("TNmPrw"); // NOI18N
        panelGlass7.add(TNmPrw);
        TNmPrw.setBounds(210, 40, 605, 23);

        btnTindakan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnTindakan.setMnemonic('3');
        btnTindakan.setToolTipText("Alt+3");
        btnTindakan.setName("btnTindakan"); // NOI18N
        btnTindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTindakanActionPerformed(evt);
            }
        });
        btnTindakan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTindakanKeyPressed(evt);
            }
        });
        panelGlass7.add(btnTindakan);
        btnTindakan.setBounds(818, 40, 28, 23);

        btnTindakan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnTindakan3.setMnemonic('3');
        btnTindakan3.setToolTipText("Alt+3");
        btnTindakan3.setName("btnTindakan3"); // NOI18N
        btnTindakan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTindakan3ActionPerformed(evt);
            }
        });
        btnTindakan3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTindakan3KeyPressed(evt);
            }
        });
        panelGlass7.add(btnTindakan3);
        btnTindakan3.setBounds(849, 40, 28, 23);

        internalFrame2.add(panelGlass7, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Penanganan Dokter", internalFrame2);

        internalFrame3.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame3.setName("internalFrame3"); // NOI18N
        internalFrame3.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll1.setName("Scroll1"); // NOI18N
        Scroll1.setOpaque(true);

        tbRawatPr.setAutoCreateRowSorter(false);
        tbRawatPr.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbRawatPr.setName("tbRawatPr"); // NOI18N
        tbRawatPr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRawatPrMouseClicked(evt);
            }
        });
        tbRawatPr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbRawatPrKeyReleased(evt);
            }
        });
        Scroll1.setViewportView(tbRawatPr);

        internalFrame3.add(Scroll1, java.awt.BorderLayout.CENTER);

        panelGlass13.setName("panelGlass13"); // NOI18N
        panelGlass13.setPreferredSize(new java.awt.Dimension(44, 74));
        panelGlass13.setLayout(null);

        jLabel13.setText("Petugas :");
        jLabel13.setName("jLabel13"); // NOI18N
        panelGlass13.add(jLabel13);
        jLabel13.setBounds(0, 10, 105, 23);

        kdptg.setHighlighter(null);
        kdptg.setName("kdptg"); // NOI18N
        kdptg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdptgKeyPressed(evt);
            }
        });
        panelGlass13.add(kdptg);
        kdptg.setBounds(108, 10, 130, 23);

        BtnSeekPetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeekPetugas.setMnemonic('5');
        BtnSeekPetugas.setToolTipText("ALt+5");
        BtnSeekPetugas.setName("BtnSeekPetugas"); // NOI18N
        BtnSeekPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeekPetugasActionPerformed(evt);
            }
        });
        panelGlass13.add(BtnSeekPetugas);
        BtnSeekPetugas.setBounds(849, 10, 28, 23);

        TPerawat.setEditable(false);
        TPerawat.setBackground(new java.awt.Color(202, 202, 202));
        TPerawat.setHighlighter(null);
        TPerawat.setName("TPerawat"); // NOI18N
        panelGlass13.add(TPerawat);
        TPerawat.setBounds(240, 10, 606, 23);

        jLabel28.setText("Tindakan/Tagihan :");
        jLabel28.setName("jLabel28"); // NOI18N
        panelGlass13.add(jLabel28);
        jLabel28.setBounds(0, 40, 105, 23);

        TKdPrwPetugas.setName("TKdPrwPetugas"); // NOI18N
        TKdPrwPetugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TKdPrwPetugasKeyPressed(evt);
            }
        });
        panelGlass13.add(TKdPrwPetugas);
        TKdPrwPetugas.setBounds(108, 40, 100, 23);

        TNmPrwPetugas.setEditable(false);
        TNmPrwPetugas.setName("TNmPrwPetugas"); // NOI18N
        panelGlass13.add(TNmPrwPetugas);
        TNmPrwPetugas.setBounds(210, 40, 605, 23);

        btnTindakan4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnTindakan4.setMnemonic('3');
        btnTindakan4.setToolTipText("Alt+3");
        btnTindakan4.setName("btnTindakan4"); // NOI18N
        btnTindakan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTindakan4ActionPerformed(evt);
            }
        });
        btnTindakan4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTindakan4KeyPressed(evt);
            }
        });
        panelGlass13.add(btnTindakan4);
        btnTindakan4.setBounds(818, 40, 28, 23);

        btnTindakan5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnTindakan5.setMnemonic('3');
        btnTindakan5.setToolTipText("Alt+3");
        btnTindakan5.setName("btnTindakan5"); // NOI18N
        btnTindakan5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTindakan5ActionPerformed(evt);
            }
        });
        btnTindakan5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTindakan5KeyPressed(evt);
            }
        });
        panelGlass13.add(btnTindakan5);
        btnTindakan5.setBounds(849, 40, 28, 23);

        internalFrame3.add(panelGlass13, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Penanganan Petugas", internalFrame3);

        internalFrame4.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame4.setName("internalFrame4"); // NOI18N
        internalFrame4.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll2.setName("Scroll2"); // NOI18N
        Scroll2.setOpaque(true);

        tbRawatDrPr.setAutoCreateRowSorter(false);
        tbRawatDrPr.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbRawatDrPr.setName("tbRawatDrPr"); // NOI18N
        tbRawatDrPr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRawatDrPrMouseClicked(evt);
            }
        });
        tbRawatDrPr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbRawatDrPrKeyReleased(evt);
            }
        });
        Scroll2.setViewportView(tbRawatDrPr);

        internalFrame4.add(Scroll2, java.awt.BorderLayout.CENTER);

        panelGlass11.setName("panelGlass11"); // NOI18N
        panelGlass11.setPreferredSize(new java.awt.Dimension(44, 104));
        panelGlass11.setLayout(null);

        jLabel14.setText("Petugas :");
        jLabel14.setName("jLabel14"); // NOI18N
        panelGlass11.add(jLabel14);
        jLabel14.setBounds(0, 40, 105, 23);

        kdptg2.setHighlighter(null);
        kdptg2.setName("kdptg2"); // NOI18N
        kdptg2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdptg2KeyPressed(evt);
            }
        });
        panelGlass11.add(kdptg2);
        kdptg2.setBounds(108, 40, 130, 23);

        BtnSeekPetugas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeekPetugas2.setMnemonic('5');
        BtnSeekPetugas2.setToolTipText("ALt+5");
        BtnSeekPetugas2.setName("BtnSeekPetugas2"); // NOI18N
        BtnSeekPetugas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeekPetugas2ActionPerformed(evt);
            }
        });
        panelGlass11.add(BtnSeekPetugas2);
        BtnSeekPetugas2.setBounds(849, 40, 28, 23);

        TPerawat2.setEditable(false);
        TPerawat2.setBackground(new java.awt.Color(202, 202, 202));
        TPerawat2.setHighlighter(null);
        TPerawat2.setName("TPerawat2"); // NOI18N
        panelGlass11.add(TPerawat2);
        TPerawat2.setBounds(240, 40, 606, 23);

        jLabel12.setText("Dokter :");
        jLabel12.setName("jLabel12"); // NOI18N
        panelGlass11.add(jLabel12);
        jLabel12.setBounds(0, 10, 105, 23);

        KdDok2.setHighlighter(null);
        KdDok2.setName("KdDok2"); // NOI18N
        KdDok2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdDok2KeyPressed(evt);
            }
        });
        panelGlass11.add(KdDok2);
        KdDok2.setBounds(108, 10, 130, 23);

        TDokter2.setEditable(false);
        TDokter2.setHighlighter(null);
        TDokter2.setName("TDokter2"); // NOI18N
        panelGlass11.add(TDokter2);
        TDokter2.setBounds(240, 10, 606, 23);

        BtnSeekDokter2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeekDokter2.setMnemonic('4');
        BtnSeekDokter2.setToolTipText("ALt+4");
        BtnSeekDokter2.setName("BtnSeekDokter2"); // NOI18N
        BtnSeekDokter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeekDokter2ActionPerformed(evt);
            }
        });
        panelGlass11.add(BtnSeekDokter2);
        BtnSeekDokter2.setBounds(849, 10, 28, 23);

        jLabel29.setText("Tindakan/Tagihan :");
        jLabel29.setName("jLabel29"); // NOI18N
        panelGlass11.add(jLabel29);
        jLabel29.setBounds(0, 70, 105, 23);

        TKdPrwDokterPetugas.setName("TKdPrwDokterPetugas"); // NOI18N
        TKdPrwDokterPetugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TKdPrwDokterPetugasKeyPressed(evt);
            }
        });
        panelGlass11.add(TKdPrwDokterPetugas);
        TKdPrwDokterPetugas.setBounds(108, 70, 100, 23);

        TNmPrwDokterPetugas.setEditable(false);
        TNmPrwDokterPetugas.setName("TNmPrwDokterPetugas"); // NOI18N
        panelGlass11.add(TNmPrwDokterPetugas);
        TNmPrwDokterPetugas.setBounds(210, 70, 605, 23);

        btnTindakan6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnTindakan6.setMnemonic('3');
        btnTindakan6.setToolTipText("Alt+3");
        btnTindakan6.setName("btnTindakan6"); // NOI18N
        btnTindakan6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTindakan6ActionPerformed(evt);
            }
        });
        btnTindakan6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTindakan6KeyPressed(evt);
            }
        });
        panelGlass11.add(btnTindakan6);
        btnTindakan6.setBounds(818, 70, 28, 23);

        btnTindakan7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnTindakan7.setMnemonic('3');
        btnTindakan7.setToolTipText("Alt+3");
        btnTindakan7.setName("btnTindakan7"); // NOI18N
        btnTindakan7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTindakan7ActionPerformed(evt);
            }
        });
        btnTindakan7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTindakan7KeyPressed(evt);
            }
        });
        panelGlass11.add(btnTindakan7);
        btnTindakan7.setBounds(849, 70, 28, 23);

        internalFrame4.add(panelGlass11, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Penanganan Dokter & Petugas", internalFrame4);

        internalFrame5.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame5.setName("internalFrame5"); // NOI18N
        internalFrame5.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll3.setName("Scroll3"); // NOI18N
        Scroll3.setOpaque(true);

        tbPemeriksaan.setAutoCreateRowSorter(false);
        tbPemeriksaan.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbPemeriksaan.setName("tbPemeriksaan"); // NOI18N
        tbPemeriksaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPemeriksaanMouseClicked(evt);
            }
        });
        tbPemeriksaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbPemeriksaanKeyReleased(evt);
            }
        });
        Scroll3.setViewportView(tbPemeriksaan);

        internalFrame5.add(Scroll3, java.awt.BorderLayout.CENTER);

        PanelInput1.setName("PanelInput1"); // NOI18N
        PanelInput1.setOpaque(false);
        PanelInput1.setPreferredSize(new java.awt.Dimension(192, 296));
        PanelInput1.setLayout(new java.awt.BorderLayout(1, 1));

        ChkInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setMnemonic('I');
        ChkInput.setText(".: Input Data");
        ChkInput.setToolTipText("Alt+I");
        ChkInput.setBorderPainted(true);
        ChkInput.setBorderPaintedFlat(true);
        ChkInput.setFocusable(false);
        ChkInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChkInput.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput.setName("ChkInput"); // NOI18N
        ChkInput.setPreferredSize(new java.awt.Dimension(192, 20));
        ChkInput.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInputActionPerformed(evt);
            }
        });
        PanelInput1.add(ChkInput, java.awt.BorderLayout.PAGE_END);

        panelGlass12.setName("panelGlass12"); // NOI18N
        panelGlass12.setPreferredSize(new java.awt.Dimension(44, 276));
        panelGlass12.setLayout(null);

        jLabel15.setText("Alergi :");
        jLabel15.setName("jLabel15"); // NOI18N
        panelGlass12.add(jLabel15);
        jLabel15.setBounds(450, 10, 90, 23);

        TAlergi.setHighlighter(null);
        TAlergi.setName("TAlergi"); // NOI18N
        TAlergi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TAlergiKeyPressed(evt);
            }
        });
        panelGlass12.add(TAlergi);
        TAlergi.setBounds(543, 10, 360, 23);

        scrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane1.setName("scrollPane1"); // NOI18N

        TKeluhan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TKeluhan.setColumns(20);
        TKeluhan.setRows(5);
        TKeluhan.setName("TKeluhan"); // NOI18N
        TKeluhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TKeluhanKeyPressed(evt);
            }
        });
        scrollPane1.setViewportView(TKeluhan);

        panelGlass12.add(scrollPane1);
        scrollPane1.setBounds(73, 70, 360, 38);

        scrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane2.setName("scrollPane2"); // NOI18N

        TPemeriksaan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TPemeriksaan.setColumns(20);
        TPemeriksaan.setRows(5);
        TPemeriksaan.setName("TPemeriksaan"); // NOI18N
        TPemeriksaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TPemeriksaanKeyPressed(evt);
            }
        });
        scrollPane2.setViewportView(TPemeriksaan);

        panelGlass12.add(scrollPane2);
        scrollPane2.setBounds(73, 115, 360, 38);

        jLabel8.setText("Subjek :");
        jLabel8.setName("jLabel8"); // NOI18N
        panelGlass12.add(jLabel8);
        jLabel8.setBounds(0, 70, 70, 23);

        jLabel9.setText("Objek :");
        jLabel9.setName("jLabel9"); // NOI18N
        panelGlass12.add(jLabel9);
        jLabel9.setBounds(0, 115, 70, 23);

        scrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane3.setName("scrollPane3"); // NOI18N

        TPenilaian.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TPenilaian.setColumns(20);
        TPenilaian.setRows(5);
        TPenilaian.setName("TPenilaian"); // NOI18N
        TPenilaian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TPenilaianKeyPressed(evt);
            }
        });
        scrollPane3.setViewportView(TPenilaian);

        panelGlass12.add(scrollPane3);
        scrollPane3.setBounds(543, 40, 360, 38);

        jLabel37.setText("Asesmen :");
        jLabel37.setName("jLabel37"); // NOI18N
        panelGlass12.add(jLabel37);
        jLabel37.setBounds(450, 40, 90, 23);

        jLabel26.setText("Plan :");
        jLabel26.setName("jLabel26"); // NOI18N
        panelGlass12.add(jLabel26);
        jLabel26.setBounds(450, 85, 90, 23);

        scrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane4.setName("scrollPane4"); // NOI18N

        TindakLanjut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TindakLanjut.setColumns(20);
        TindakLanjut.setRows(5);
        TindakLanjut.setName("TindakLanjut"); // NOI18N
        TindakLanjut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TindakLanjutKeyPressed(evt);
            }
        });
        scrollPane4.setViewportView(TindakLanjut);

        panelGlass12.add(scrollPane4);
        scrollPane4.setBounds(543, 85, 360, 47);

        jLabel53.setText("Dilakukan :");
        jLabel53.setName("jLabel53"); // NOI18N
        panelGlass12.add(jLabel53);
        jLabel53.setBounds(0, 10, 70, 23);

        KdPeg.setHighlighter(null);
        KdPeg.setName("KdPeg"); // NOI18N
        KdPeg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdPegKeyPressed(evt);
            }
        });
        panelGlass12.add(KdPeg);
        KdPeg.setBounds(73, 10, 115, 23);

        TPegawai.setEditable(false);
        TPegawai.setHighlighter(null);
        TPegawai.setName("TPegawai"); // NOI18N
        panelGlass12.add(TPegawai);
        TPegawai.setBounds(190, 10, 212, 23);

        BtnSeekPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeekPegawai.setMnemonic('4');
        BtnSeekPegawai.setToolTipText("ALt+4");
        BtnSeekPegawai.setName("BtnSeekPegawai"); // NOI18N
        BtnSeekPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeekPegawaiActionPerformed(evt);
            }
        });
        panelGlass12.add(BtnSeekPegawai);
        BtnSeekPegawai.setBounds(405, 10, 28, 23);

        Jabatan.setEditable(false);
        Jabatan.setHighlighter(null);
        Jabatan.setName("Jabatan"); // NOI18N
        panelGlass12.add(Jabatan);
        Jabatan.setBounds(193, 40, 209, 23);

        jLabel54.setText("Profesi / Jabatan / Departemen :");
        jLabel54.setName("jLabel54"); // NOI18N
        panelGlass12.add(jLabel54);
        jLabel54.setBounds(0, 40, 190, 23);

        jLabel55.setText("Inst/Impl :");
        jLabel55.setName("jLabel55"); // NOI18N
        panelGlass12.add(jLabel55);
        jLabel55.setBounds(450, 139, 90, 23);

        scrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane7.setName("scrollPane7"); // NOI18N

        TInstruksi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TInstruksi.setColumns(20);
        TInstruksi.setRows(5);
        TInstruksi.setName("TInstruksi"); // NOI18N
        TInstruksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TInstruksiKeyPressed(evt);
            }
        });
        scrollPane7.setViewportView(TInstruksi);

        panelGlass12.add(scrollPane7);
        scrollPane7.setBounds(543, 139, 360, 50);

        jLabel56.setText("SpO2 (%) :");
        jLabel56.setName("jLabel56"); // NOI18N
        panelGlass12.add(jLabel56);
        jLabel56.setBounds(0, 220, 70, 23);

        SpO2.setFocusTraversalPolicyProvider(true);
        SpO2.setName("SpO2"); // NOI18N
        SpO2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SpO2KeyPressed(evt);
            }
        });
        panelGlass12.add(SpO2);
        SpO2.setBounds(73, 220, 42, 23);

        jLabel22.setText("GCS (E,V,M) :");
        jLabel22.setName("jLabel22"); // NOI18N
        panelGlass12.add(jLabel22);
        jLabel22.setBounds(120, 220, 70, 23);

        TGCS.setFocusTraversalPolicyProvider(true);
        TGCS.setName("TGCS"); // NOI18N
        TGCS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TGCSKeyPressed(evt);
            }
        });
        panelGlass12.add(TGCS);
        TGCS.setBounds(193, 220, 42, 23);

        jLabel58.setText("Kesadaran :");
        jLabel58.setName("jLabel58"); // NOI18N
        panelGlass12.add(jLabel58);
        jLabel58.setBounds(234, 220, 70, 23);

        cmbKesadaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Compos Mentis", "Somnolence", "Sopor", "Coma","Apatis","Delirium","Meninggal" }));
        cmbKesadaran.setName("cmbKesadaran"); // NOI18N
        cmbKesadaran.setPreferredSize(new java.awt.Dimension(62, 28));
        cmbKesadaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbKesadaranKeyPressed(evt);
            }
        });
        panelGlass12.add(cmbKesadaran);
        cmbKesadaran.setBounds(307, 220, 126, 23);

        scrollPane8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane8.setName("scrollPane8"); // NOI18N

        TEvaluasi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TEvaluasi.setColumns(20);
        TEvaluasi.setRows(5);
        TEvaluasi.setName("TEvaluasi"); // NOI18N
        TEvaluasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TEvaluasiKeyPressed(evt);
            }
        });
        scrollPane8.setViewportView(TEvaluasi);

        panelGlass12.add(scrollPane8);
        scrollPane8.setBounds(543, 196, 360, 44);

        BtnStatusVerifikasiSOAP.setText("Riwayat Verifikasi SOAP");
        BtnStatusVerifikasiSOAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/checked.png")));
        BtnStatusVerifikasiSOAP.setToolTipText("Lihat riwayat verifikasi SOAP pasien");
        BtnStatusVerifikasiSOAP.setName("BtnStatusVerifikasiSOAP");
        BtnStatusVerifikasiSOAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRiwayatSOAPActionPerformed(evt);
            }
        });
        panelGlass12.add(BtnStatusVerifikasiSOAP);
        BtnStatusVerifikasiSOAP.setBounds(908, 124, 190, 44);

        BtnRiwayatSOAP.setText("Status Verifikasi SOAP");
        BtnRiwayatSOAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png")));
        BtnRiwayatSOAP.setToolTipText("Lihat status verifikasi SOAP yang dipilih");
        BtnRiwayatSOAP.setName("BtnRiwayatSOAP"); // NOI18N
        BtnRiwayatSOAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnStatusVerifikasiSOAPActionPerformed(evt);
            }
        });
        panelGlass12.add(BtnRiwayatSOAP);
        BtnRiwayatSOAP.setBounds(908, 172, 190, 44);

        BtnVerifikasiSOAP.setText("Verifikasi SOAP");
        BtnVerifikasiSOAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept_page.png")));
        BtnVerifikasiSOAP.setToolTipText("Verifikasi manual satu SOAP yang dipilih");
        BtnVerifikasiSOAP.setName("BtnVerifikasiSOAP");
        BtnVerifikasiSOAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerifikasiSOAPActionPerformed(evt);
            }
        });
        panelGlass12.add(BtnVerifikasiSOAP);
        BtnVerifikasiSOAP.setBounds(908, 220, 190, 44);

        jLabel59.setText("Evaluasi :");
        jLabel59.setName("jLabel59"); // NOI18N
        panelGlass12.add(jLabel59);
        jLabel59.setBounds(450, 196, 90, 23);

        Btn5Soap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        Btn5Soap.setMnemonic('4');
        Btn5Soap.setToolTipText("ALt+4");
        Btn5Soap.setName("Btn5Soap"); // NOI18N
        Btn5Soap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn5SoapActionPerformed(evt);
            }
        });
        panelGlass12.add(Btn5Soap);
        Btn5Soap.setBounds(405, 40, 28, 23);

        jLabel7.setText("Suhu (°C) :");
        jLabel7.setName("jLabel7"); // NOI18N
        panelGlass12.add(jLabel7);
        jLabel7.setBounds(0, 160, 70, 23);

        TSuhu.setFocusTraversalPolicyProvider(true);
        TSuhu.setName("TSuhu"); // NOI18N
        TSuhu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TSuhuKeyPressed(evt);
            }
        });
        panelGlass12.add(TSuhu);
        TSuhu.setBounds(73, 160, 55, 23);

        jLabel17.setText("TB (Cm) :");
        jLabel17.setName("jLabel17"); // NOI18N
        panelGlass12.add(jLabel17);
        jLabel17.setBounds(0, 190, 70, 23);

        TTinggi.setFocusTraversalPolicyProvider(true);
        TTinggi.setName("TTinggi"); // NOI18N
        TTinggi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TTinggiKeyPressed(evt);
            }
        });
        panelGlass12.add(TTinggi);
        TTinggi.setBounds(73, 190, 55, 23);

        jLabel4.setText("Tensi (mmHg) :");
        jLabel4.setName("jLabel4"); // NOI18N
        panelGlass12.add(jLabel4);
        jLabel4.setBounds(130, 160, 90, 23);

        TTensi.setHighlighter(null);
        TTensi.setName("TTensi"); // NOI18N
        TTensi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TTensiKeyPressed(evt);
            }
        });
        panelGlass12.add(TTensi);
        TTensi.setBounds(223, 160, 74, 23);

        TRespirasi.setHighlighter(null);
        TRespirasi.setName("TRespirasi"); // NOI18N
        TRespirasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TRespirasiKeyPressed(evt);
            }
        });
        panelGlass12.add(TRespirasi);
        TRespirasi.setBounds(223, 190, 55, 23);

        jLabel41.setText("RR (/menit) :");
        jLabel41.setName("jLabel41"); // NOI18N
        panelGlass12.add(jLabel41);
        jLabel41.setBounds(130, 190, 90, 23);

        jLabel16.setText("Berat (Kg) :");
        jLabel16.setName("jLabel16"); // NOI18N
        panelGlass12.add(jLabel16);
        jLabel16.setBounds(296, 160, 79, 23);

        TBerat.setHighlighter(null);
        TBerat.setName("TBerat"); // NOI18N
        TBerat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TBeratKeyPressed(evt);
            }
        });
        panelGlass12.add(TBerat);
        TBerat.setBounds(378, 160, 55, 23);

        TNadi.setFocusTraversalPolicyProvider(true);
        TNadi.setName("TNadi"); // NOI18N
        TNadi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNadiKeyPressed(evt);
            }
        });
        panelGlass12.add(TNadi);
        TNadi.setBounds(378, 190, 55, 23);

        jLabel61.setText("Nadi (/menit) :");
        jLabel61.setName("jLabel61"); // NOI18N
        panelGlass12.add(jLabel61);
        jLabel61.setBounds(296, 190, 79, 23);

        PanelInput1.add(panelGlass12, java.awt.BorderLayout.CENTER);

        internalFrame5.add(PanelInput1, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Pemeriksaan", internalFrame5);

        internalFrame6.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame6.setName("internalFrame6"); // NOI18N
        internalFrame6.setLayout(new java.awt.BorderLayout(1, 1));…145484 tokens truncated…ewardPascaAnestesi);
        FormMenu.add(BtnSkorBromagePascaAnestesi);
        FormMenu.add(BtnCatatanPengkajianPaskaOperasi);
        FormMenu.add(BtnPenilaianPsikolog);
        FormMenu.add(BtnPenilaianPsikologKlinis);
        FormMenu.add(BtnPerencanaanPemulangan);
        FormMenu.add(BtnPenilaianLanjutanResikoJatuhDewasa);
        FormMenu.add(BtnPenilaianLanjutanResikoJatuhAnak);
        FormMenu.add(BtnPenilaianLanjutanResikoJatuhLansia);
        FormMenu.add(BtnPenilaianLanjutanResikoJatuhNeonatus);
        FormMenu.add(BtnPenilaianLanjutanResikoJatuhGeriatri);
        FormMenu.add(BtnPenilaianLanjutanResikoJatuhPsikiatri);
        FormMenu.add(BtnPenilaianLanjutanSkriningFungsional);
        FormMenu.add(BtnPenilaianResikoDekubitus);
        FormMenu.add(BtnHasilPemeriksaanUSG);
        FormMenu.add(BtnHasilPemeriksaanUSGUrologi);
        FormMenu.add(BtnHasilPemeriksaanUSGNeonatus);
        FormMenu.add(BtnHasilPemeriksaanUSGGynecologi);
        FormMenu.add(BtnHasilPemeriksaanUSGAbdomen);
        FormMenu.add(BtnHasilPemeriksaanEKG);
        FormMenu.add(BtnHasilPemeriksaanECHO);
        FormMenu.add(BtnHasilPemeriksaanECHOPediatrik);
        FormMenu.add(BtnHasilPemeriksaanSlitLamp);
        FormMenu.add(BtnHasilPemeriksaanOCT);
        FormMenu.add(BtnHasilPemeriksaanTreadmill);
        FormMenu.add(BtnHasilEndoskopiFaringLaring);
        FormMenu.add(BtnHasilEndoskopiHidung);
        FormMenu.add(BtnHasilEndoskopiTelinga);
        FormMenu.add(BtnDokumentasiESWL);
        FormMenu.add(BtnAdmisiSkoringTOLAC);
        FormMenu.add(BtnCatatanPersalinan);
        FormMenu.add(BtnLaporanTindakan);
        FormMenu.add(BtnHasilPersalinanTOLAC);
        FormMenu.add(BtnCatatan);
        FormMenu.add(BtnCatatanObservasiRanap);
        FormMenu.add(BtnCatatanObservasiRanapKebidanan);
        FormMenu.add(BtnCatatanObservasiRanapPostPartum);
        FormMenu.add(BtnCatatanObservasiCHBP);
        FormMenu.add(BtnCatatanObservasiInduksiPersalinan);
        FormMenu.add(BtnMonitoringTolac);
        FormMenu.add(BtnCatatanObservasiBayi);
        FormMenu.add(BtnCatatanObservasiRestrainNonfarmakologi);
        FormMenu.add(BtnCatatanObservasiVentilator);
        FormMenu.add(BtnCatatanObservasiHemodialisa);
        FormMenu.add(BtnCatatanObservasiRuangOperasi);
        FormMenu.add(BtnCatatanKeseimbanganCairan);
        FormMenu.add(BtnCatatanCairanHemodialisa);
        FormMenu.add(BtnChecklistPemberianFibrinolitik);
        FormMenu.add(BtnFollowUpDBD);
        FormMenu.add(BtnCatatanKeperawatan);
        FormMenu.add(BtnCatatanCekGDS);
        FormMenu.add(BtnPenilaianUlangNyeri);
        FormMenu.add(BtnIntervensiNyeriFarmakologi);
        FormMenu.add(BtnIntervensiNyeriNonFarmakologi);
        FormMenu.add(BtnPemantauanPEWSAnak);
        FormMenu.add(BtnPemantauanPEWSDewasa);
        FormMenu.add(BtnPemantauanMEOWS);
        FormMenu.add(BtnPemantauanEWSNeonatus);
        FormMenu.add(BtnChecklistKriteriaMasukHCU);
        FormMenu.add(BtnChecklistKriteriaKeluarHCU);
        FormMenu.add(BtnChecklistKriteriaMasukICU);
        FormMenu.add(BtnChecklistKriteriaKeluarICU);
        FormMenu.add(BtnChecklistKriteriaMasukNICU);
        FormMenu.add(BtnChecklistKriteriaKeluarNICU);
        FormMenu.add(BtnChecklistKriteriaMasukPICU);
        FormMenu.add(BtnChecklistKriteriaKeluarPICU);
        FormMenu.add(BtnChecklistKriteriaMasukIsolasi);
        FormMenu.add(BtnChecklistKriteriaKeluarIsolasi);
        FormMenu.add(BtnMonitoringReaksiTranfusi);
        FormMenu.add(BtnLaporanReaksiTranfusi);
        FormMenu.add(BtnSkriningNutrisiDewasa);
        FormMenu.add(BtnSkriningNutrisiLansia);
        FormMenu.add(BtnSkriningNutrisiAnak);
        FormMenu.add(BtnSkriningGiziKehamilan);
        FormMenu.add(BtnSkriningGiziLanjut);
        FormMenu.add(BtnAsuhanGizi);
        FormMenu.add(BtnMonitoringAsuhanGizi);
        FormMenu.add(BtnCatatanADIMEGizi);
        FormMenu.add(BtnKonselingFarmasi);
        FormMenu.add(BtnInformasiObat);
        FormMenu.add(BtnRekonsiliasiObat);
        FormMenu.add(BtnTransferAntarRuang);
        FormMenu.add(BtnPelaksanaanInformasiEdukasi);
        FormMenu.add(BtnPengkajianRestrain);
        FormMenu.add(BtnPenilaianBayiBaruLahir);
        FormMenu.add(BtnPenilaianPasienTerminal);
        FormMenu.add(BtnPenilaianKorbanKekerasan);
        FormMenu.add(BtnPenilaianKecemasanAnak);
        FormMenu.add(BtnPenilaianPasienPenyakitMenular);
        FormMenu.add(BtnPenilaianPasienImunitasRendah);
        FormMenu.add(BtnPenilaianTambahanGeriatri);
        FormMenu.add(BtnPenilaianTambahanBunuhDiri);
        FormMenu.add(BtnPenilaianTambahanPerilakuKekerasan);
        FormMenu.add(BtnPenilaianTambahanMelarikanDiri);
        FormMenu.add(BtnPenilaianDerajatDehidrasi);
    }

    private void simpan() {
        switch (TabRawat.getSelectedIndex()) {
            case 0:
                if(KdDok.getText().trim().equals("")||TDokter.getText().trim().equals("")){
                    Valid.textKosong(KdDok,"Dokter");
                }else if(TKdPrw.getText().trim().equals("")||TNmPrw.getText().trim().equals("")){
                    Valid.textKosong(TKdPrw,"perawatan");
                }else{
                    if(Sequel.cariRegistrasi(TNoRw.getText().trim())>0){
                        JOptionPane.showMessageDialog(rootPane,"Data billing sudah terverifikasi.\nSilahkan hubungi bagian kasir/keuangan ..!!");
                        TCari.requestFocus();
                    }else{
                        Sequel.AutoComitFalse();
                        sukses=true;
                        if(Sequel.menyimpantf("rawat_inap_dr","?,?,?,?,?,?,?,?,?,?,?","Data",11,new String[]{
                            TNoRw.getText(),TKdPrw.getText(),KdDok.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),
                            cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                            BagianRS.getText(),Bhp.getText(),JmDokter.getText(),KSO.getText(),Menejemen.getText(),TTnd.getText()
                        })==true){
                            Sequel.queryu("delete from tampjurnal");
                            if(Valid.SetAngka(TTnd.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"','Suspen Piutang Tindakan Ranap','"+TTnd.getText()+"','0'","debet=debet+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }                              
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getTindakan_Ranap()+"','Pendapatan Tindakan Rawat Inap','0','"+TTnd.getText()+"'","kredit=kredit+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getTindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(JmDokter.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Beban Jasa Medik Dokter Tindakan Ranap','"+JmDokter.getText()+"','0'","debet=debet+'"+(JmDokter.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Utang Jasa Medik Dokter Tindakan Ranap','0','"+JmDokter.getText()+"'","kredit=kredit+'"+(JmDokter.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(KSO.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"','Beban KSO Tindakan Ranap','"+KSO.getText()+"','0'","debet=debet+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"','Utang KSO Tindakan Ranap','0','"+KSO.getText()+"'","kredit=kredit+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(BagianRS.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"','Beban Jasa Sarana Tindakan Ranap','"+BagianRS.getText()+"','0'","debet=debet+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"','Utang Jasa Sarana Tindakan Ranap','0','"+BagianRS.getText()+"'","kredit=kredit+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(Bhp.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"','HPP BHP Tindakan Ranap','"+Bhp.getText()+"','0'","debet=debet+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"','Persediaan BHP Tindakan Ranap','0','"+Bhp.getText()+"'","kredit=kredit+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(Menejemen.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"','Beban Jasa Menejemen Tindakan Ranap','"+Menejemen.getText()+"','0'","debet=debet+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"','Utang Jasa Menejemen Tindakan Ranap','0','"+Menejemen.getText()+"'","kredit=kredit+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(sukses==true){
                                sukses=jur.simpanJurnal(TNoRw.getText(),"U","TINDAKAN RAWAT INAP PASIEN "+TPasien.getText()+" DIPOSTING OLEH "+akses.getkode());
                            }
                        }else{
                            sukses=false;
                        }

                        if(sukses==true){
                            Sequel.Commit();
                            tabModeDr.addRow(new Object[]{
                                false,TNoRw.getText(),TNoRM.getText(),TPasien.getText(),TNmPrw.getText(),KdDok.getText(),TDokter.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),
                                cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),Double.parseDouble(TTnd.getText()),TKdPrw.getText(),JmDokter.getText(),KSO.getText(),
                                BagianRS.getText(),Bhp.getText(),Menejemen.getText()
                            });
                            LCount.setText(""+tabModeDr.getRowCount());
                            BtnBatalActionPerformed(null);
                        }else{
                            JOptionPane.showMessageDialog(null,"Terjadi kesalahan saat pemrosesan data, transaksi dibatalkan.\nPeriksa kembali data sebelum melanjutkan menyimpan..!!");
                            Sequel.RollBack();
                        }
                        Sequel.AutoComitTrue();
                    }
                }   break;
            case 1:
                if(kdptg.getText().trim().equals("")||TPerawat.getText().trim().equals("")){                              
                    Valid.textKosong(kdptg,"Petugas");
                }else if(TKdPrwPetugas.getText().trim().equals("")||TNmPrwPetugas.getText().trim().equals("")){
                    Valid.textKosong(TKdPrwPetugas,"perawatan");
                }else{
                    if(Sequel.cariRegistrasi(TNoRw.getText().trim())>0){
                        JOptionPane.showMessageDialog(rootPane,"Data billing sudah terverifikasi.\nSilahkan hubungi bagian kasir/keuangan ..!!");
                        TCari.requestFocus();
                    }else{
                        Sequel.AutoComitFalse();
                        sukses=true;
                        if(Sequel.menyimpantf("rawat_inap_pr","?,?,?,?,?,?,?,?,?,?,?","Data",11,new String[]{
                            TNoRw.getText(),TKdPrwPetugas.getText(),kdptg.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),
                            cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                            BagianRS.getText(),Bhp.getText(),JmPerawat.getText(),KSO.getText(),Menejemen.getText(),TTnd.getText()
                        })==true){
                            Sequel.queryu("delete from tampjurnal");
                            if(Valid.SetAngka(TTnd.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"','Suspen Piutang Tindakan Ranap','"+TTnd.getText()+"','0'","debet=debet+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getTindakan_Ranap()+"','Pendapatan Tindakan Rawat Inap','0','"+TTnd.getText()+"'","kredit=kredit+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getTindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(JmPerawat.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Beban Jasa Medik Paramedis Tindakan Ranap','"+JmPerawat.getText()+"','0'","debet=debet+'"+(JmPerawat.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Utang Jasa Medik Paramedis Tindakan Ranap','0','"+JmPerawat.getText()+"'","kredit=kredit+'"+(JmPerawat.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(KSO.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"','Beban KSO Tindakan Ranap','"+KSO.getText()+"','0'","debet=debet+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"','Utang KSO Tindakan Ranap','0','"+KSO.getText()+"'","kredit=kredit+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(BagianRS.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"','Beban Jasa Sarana Tindakan Ranap','"+BagianRS.getText()+"','0'","debet=debet+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"','Utang Jasa Sarana Tindakan Ranap','0','"+BagianRS.getText()+"'","kredit=kredit+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(Bhp.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"','HPP BHP Tindakan Ranap','"+Bhp.getText()+"','0'","debet=debet+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"','Persediaan BHP Tindakan Ranap','0','"+Bhp.getText()+"'","kredit=kredit+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(Menejemen.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"','Beban Jasa Menejemen Tindakan Ranap','"+Menejemen.getText()+"','0'","debet=debet+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"','Utang Jasa Menejemen Tindakan Ranap','0','"+Menejemen.getText()+"'","kredit=kredit+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(sukses==true){
                                sukses=jur.simpanJurnal(TNoRw.getText(),"U","TINDAKAN RAWAT INAP PASIEN "+TPasien.getText()+" DIPOSTING OLEH "+akses.getkode()); 
                            }
                        }else{
                            sukses=false;
                        }
                        if(sukses==true){
                            Sequel.Commit();
                            tabModePr.addRow(new Object[]{
                                false,TNoRw.getText(),TNoRM.getText(),TPasien.getText(),TNmPrwPetugas.getText(),kdptg.getText(),TPerawat.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),
                                cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),Double.parseDouble(TTnd.getText()),TKdPrwPetugas.getText(),
                                JmPerawat.getText(),KSO.getText(),BagianRS.getText(),Bhp.getText(),Menejemen.getText()
                            });
                            LCount.setText(""+tabModePr.getRowCount());
                            BtnBatalActionPerformed(null);
                        }else{
                            JOptionPane.showMessageDialog(null,"Terjadi kesalahan saat pemrosesan data, transaksi dibatalkan.\nPeriksa kembali data sebelum melanjutkan menyimpan..!!");
                            Sequel.RollBack();
                        }
                        Sequel.AutoComitTrue();
                    }                            
                }   break;
            case 2:
                if(KdDok2.getText().trim().equals("")||TDokter2.getText().trim().equals("")){                              
                    Valid.textKosong(KdDok2,"Dokter");
                }else if(kdptg2.getText().trim().equals("")||TPerawat2.getText().trim().equals("")){
                    Valid.textKosong(kdptg2,"Petugas");
                }else if(TKdPrwDokterPetugas.getText().trim().equals("")||TNmPrwDokterPetugas.getText().trim().equals("")){
                    Valid.textKosong(TKdPrwDokterPetugas,"perawatan");
                }else{
                    if(Sequel.cariRegistrasi(TNoRw.getText().trim())>0){
                        JOptionPane.showMessageDialog(rootPane,"Data billing sudah terverifikasi.\nSilahkan hubungi bagian kasir/keuangan ..!!");
                        TCari.requestFocus();
                    }else{
                        Sequel.AutoComitFalse();
                        sukses=true;
                        if(Sequel.menyimpantf("rawat_inap_drpr","?,?,?,?,?,?,?,?,?,?,?,?,?","Data",13,new String[]{
                            TNoRw.getText(),TKdPrwDokterPetugas.getText(),KdDok2.getText(),kdptg2.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),
                            cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                            BagianRS.getText(),Bhp.getText(),JmDokter.getText(),JmPerawat.getText(),KSO.getText(),Menejemen.getText(),TTnd.getText()
                        })==true){
                            Sequel.queryu("delete from tampjurnal");
                            if(Valid.SetAngka(TTnd.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"','Suspen Piutang Tindakan Ranap','"+TTnd.getText()+"','0'","debet=debet+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getTindakan_Ranap()+"','Pendapatan Tindakan Rawat Inap','0','"+TTnd.getText()+"'","kredit=kredit+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getTindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(JmDokter.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Beban Jasa Medik Dokter Tindakan Ranap','"+JmDokter.getText()+"','0'","debet=debet+'"+(JmDokter.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Utang Jasa Medik Dokter Tindakan Ranap','0','"+JmDokter.getText()+"'","kredit=kredit+'"+(JmDokter.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(JmPerawat.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Beban Jasa Medik Paramedis Tindakan Ranap','"+JmPerawat.getText()+"','0'","debet=debet+'"+(JmPerawat.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Utang Jasa Medik Paramedis Tindakan Ranap','0','"+JmPerawat.getText()+"'","kredit=kredit+'"+(JmPerawat.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(KSO.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"','Beban KSO Tindakan Ranap','"+KSO.getText()+"','0'","debet=debet+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"','Utang KSO Tindakan Ranap','0','"+KSO.getText()+"'","kredit=kredit+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(BagianRS.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"','Beban Jasa Sarana Tindakan Ranap','"+BagianRS.getText()+"','0'","debet=debet+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"','Utang Jasa Sarana Tindakan Ranap','0','"+BagianRS.getText()+"'","kredit=kredit+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(Bhp.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"','HPP BHP Tindakan Ranap','"+Bhp.getText()+"','0'","debet=debet+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"','Persediaan BHP Tindakan Ranap','0','"+Bhp.getText()+"'","kredit=kredit+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(Valid.SetAngka(Menejemen.getText())>0){
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"','Beban Jasa Menejemen Tindakan Ranap','"+Menejemen.getText()+"','0'","debet=debet+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                                if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"','Utang Jasa Menejemen Tindakan Ranap','0','"+Menejemen.getText()+"'","kredit=kredit+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }   
                            }
                            if(sukses==true){
                                sukses=jur.simpanJurnal(TNoRw.getText(),"U","TINDAKAN RAWAT INAP PASIEN "+TPasien.getText()+" DIPOSTING OLEH "+akses.getkode());
                            }
                        }else{
                            sukses=false;
                        }

                        if(sukses==true){
                            Sequel.Commit();
                            tabModeDrPr.addRow(new Object[]{
                                false,TNoRw.getText(),TNoRM.getText(),TPasien.getText(),TNmPrwDokterPetugas.getText(),KdDok2.getText(),TDokter2.getText(),kdptg2.getText(),TPerawat2.getText(),
                                Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),Double.parseDouble(TTnd.getText()),
                                TKdPrwDokterPetugas.getText(),JmDokter.getText(),JmPerawat.getText(),KSO.getText(),BagianRS.getText(),Bhp.getText(),Menejemen.getText()
                            });
                            LCount.setText(""+tabModeDrPr.getRowCount());
                            BtnBatalActionPerformed(null);
                        }else{
                            JOptionPane.showMessageDialog(null,"Terjadi kesalahan saat pemrosesan data, transaksi dibatalkan.\nPeriksa kembali data sebelum melanjutkan menyimpan..!!");
                            Sequel.RollBack();
                        }
                        Sequel.AutoComitTrue();
                    }                            
                }   break;
            case 3:
                if((!TKeluhan.getText().trim().equals(""))||(!TPemeriksaan.getText().trim().equals(""))||(!TSuhu.getText().trim().equals(""))||
                        (!TTensi.getText().trim().equals(""))||(!TAlergi.getText().trim().equals(""))||(!TTinggi.getText().trim().equals(""))||
                        (!TBerat.getText().trim().equals(""))||(!TRespirasi.getText().trim().equals(""))||(!TNadi.getText().trim().equals(""))||
                        (!TGCS.getText().trim().equals(""))||(!TindakLanjut.getText().trim().equals(""))||(!TPenilaian.getText().trim().equals(""))||
                        (!TInstruksi.getText().trim().equals(""))||(!SpO2.getText().trim().equals(""))||(!TEvaluasi.getText().trim().equals(""))){
                    if(KdPeg.getText().trim().equals("")||TPegawai.getText().trim().equals("")){
                        Valid.textKosong(KdPeg,"Dokter/Paramedis masih kosong...!!");
                    }else{
                        if(akses.getkode().equals("Admin Utama")){
                            if(Sequel.menyimpantf("pemeriksaan_ranap","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",20,new String[]{
                                    TNoRw.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),                      
                                    TSuhu.getText(),TTensi.getText(),TNadi.getText(),TRespirasi.getText(),TTinggi.getText(),TBerat.getText(),SpO2.getText(),TGCS.getText(),
                                    cmbKesadaran.getSelectedItem().toString(),TKeluhan.getText(),TPemeriksaan.getText(),TAlergi.getText(),
                                    TPenilaian.getText(),TindakLanjut.getText(),TInstruksi.getText(),TEvaluasi.getText(),KdPeg.getText()
                                })==true){
                                tabModePemeriksaan.addRow(new Object[]{
                                    false,TNoRw.getText(),TNoRM.getText(),TPasien.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                                    TSuhu.getText(),TTensi.getText(),TNadi.getText(),TRespirasi.getText(),TTinggi.getText(),TBerat.getText(),SpO2.getText(),TGCS.getText(),cmbKesadaran.getSelectedItem().toString(),
                                    TKeluhan.getText(),TPemeriksaan.getText(),TAlergi.getText(),TPenilaian.getText(),TindakLanjut.getText(),TInstruksi.getText(),TEvaluasi.getText(),KdPeg.getText(),TPegawai.getText(),
                                    Jabatan.getText(),false
                                });
                                LCount.setText(""+tabModePemeriksaan.getRowCount());
                                BtnBatalActionPerformed(null);
                            }
                        }else{
                            if(akses.getkode().equals(KdPeg.getText())){
                                if(Sequel.menyimpantf("pemeriksaan_ranap","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",20,new String[]{
                                    TNoRw.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),                      
                                    TSuhu.getText(),TTensi.getText(),TNadi.getText(),TRespirasi.getText(),TTinggi.getText(),TBerat.getText(),SpO2.getText(),TGCS.getText(),
                                    cmbKesadaran.getSelectedItem().toString(),TKeluhan.getText(),TPemeriksaan.getText(),TAlergi.getText(),
                                    TPenilaian.getText(),TindakLanjut.getText(),TInstruksi.getText(),TEvaluasi.getText(),KdPeg.getText()
                                })==true){
                                    tabModePemeriksaan.addRow(new Object[]{
                                        false,TNoRw.getText(),TNoRM.getText(),TPasien.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                                        TSuhu.getText(),TTensi.getText(),TNadi.getText(),TRespirasi.getText(),TTinggi.getText(),TBerat.getText(),SpO2.getText(),TGCS.getText(),cmbKesadaran.getSelectedItem().toString(),
                                        TKeluhan.getText(),TPemeriksaan.getText(),TAlergi.getText(),TPenilaian.getText(),TindakLanjut.getText(),TInstruksi.getText(),TEvaluasi.getText(),KdPeg.getText(),TPegawai.getText(),
                                        Jabatan.getText(),false
                                    });
                                    LCount.setText(""+tabModePemeriksaan.getRowCount());
                                    BtnBatalActionPerformed(null);
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,"Hanya bisa disimpan oleh dokter/petugas yang bersangkutan..!!");
                            }
                        }
                    }
                }   break;
            case 4:
                if((!TTinggi_uteri.getText().trim().equals(""))||(!TLetak.getText().trim().equals(""))||
                        (!TDenyut.getText().trim().equals(""))||(!TKualitas_mnt.getText().trim().equals(""))||
                        (!TKualitas_dtk.getText().trim().equals(""))||(!TVulva.getText().trim().equals(""))||
                        (!TPortio.getText().trim().equals(""))||(!TTebal.getText().trim().equals(""))||
                        (!TPembukaan.getText().trim().equals(""))||(!TPenurunan.getText().trim().equals(""))||
                        (!TDenominator.getText().trim().equals(""))){
                    if(Sequel.menyimpantf("pemeriksaan_obstetri_ranap","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",23,new String[]{
                            TNoRw.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                            TTinggi_uteri.getText(),cmbJanin.getSelectedItem().toString(),TLetak.getText(),cmbPanggul.getSelectedItem().toString(),TDenyut.getText(),
                            cmbKontraksi.getSelectedItem().toString(),TKualitas_mnt.getText(),TKualitas_dtk.getText(),cmbFluksus.getSelectedItem().toString(),
                            cmbAlbus.getSelectedItem().toString(),TVulva.getText(),TPortio.getText(),cmbDalam.getSelectedItem().toString(),TTebal.getText(),
                            cmbArah.getSelectedItem().toString(),TPembukaan.getText(),TPenurunan.getText(),TDenominator.getText(),cmbKetuban.getSelectedItem().toString(),
                            cmbFeto.getSelectedItem().toString()
                        })==true){
                            tabModeObstetri.addRow(new Object[] {
                                false,TNoRw.getText(),TNoRM.getText(),TPasien.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                                TTinggi_uteri.getText(),cmbJanin.getSelectedItem().toString(),TLetak.getText(),cmbPanggul.getSelectedItem().toString(),TDenyut.getText(),cmbKontraksi.getSelectedItem().toString(),
                                TKualitas_mnt.getText(),TKualitas_dtk.getText(),cmbFluksus.getSelectedItem().toString(),cmbAlbus.getSelectedItem().toString(),TVulva.getText(),TPortio.getText(),
                                cmbDalam.getSelectedItem().toString(),TTebal.getText(),cmbArah.getSelectedItem().toString(),TPembukaan.getText(),TPenurunan.getText(),TDenominator.getText(),
                                cmbKetuban.getSelectedItem().toString(),cmbFeto.getSelectedItem().toString() 
                            });
                            TTinggi_uteri.setText("");cmbJanin.setSelectedIndex(0);TLetak.setText("");cmbPanggul.setSelectedIndex(0);TDenyut.setText("");
                            cmbKontraksi.setSelectedIndex(0);TKualitas_mnt.setText("");TKualitas_dtk.setText("");cmbFluksus.setSelectedIndex(0);
                            cmbAlbus.setSelectedIndex(0);TVulva.setText("");TPortio.setText("");cmbDalam.setSelectedIndex(0);TTebal.setText("");
                            cmbArah.setSelectedIndex(0);TPembukaan.setText("");TPenurunan.setText("");TDenominator.setText("");cmbKetuban.setSelectedIndex(0);
                            cmbFeto.getSelectedItem().toString();
                            LCount.setText(""+tabModeObstetri.getRowCount());
                    }
                }   break; 
            case 5:
                if ((!TInspeksi.getText().trim().equals(""))||(!TInspeksiVulva.getText().trim().equals(""))||
                        (!TInspekuloGine.getText().trim().equals(""))||(!TUkuran.getText().trim().equals(""))||
                        (!TPortioInspekulo.getText().trim().equals(""))||(!TSondage.getText().trim().equals(""))||
                        (!TPortioDalam.getText().trim().equals(""))||(!TBentuk.getText().trim().equals(""))||
                        (!TCavumUteri.getText().trim().equals(""))||(!TUkuran.getText().trim().equals(""))||
                        (!TAdnexaKanan.getText().trim().equals(""))||(!TAdnexaKiri.getText().trim().equals(""))||
                        (!TCavumDouglas.getText().trim().equals(""))) {
                    if(Sequel.menyimpantf("pemeriksaan_ginekologi_ranap","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",20, new String[] {
                            TNoRw.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                            TInspeksi.getText(),TInspeksiVulva.getText(),TInspekuloGine.getText(),
                            cmbFluxusGine.getSelectedItem().toString(),cmbFluorGine.getSelectedItem().toString(), TVulvaInspekulo.getText(),
                            TPortioInspekulo.getText(), TSondage.getText(), TPortioDalam.getText(),
                            TBentuk.getText(), TCavumUteri.getText(), cmbMobilitas.getSelectedItem().toString(),
                            TUkuran.getText(), cmbNyeriTekan.getSelectedItem().toString(),
                            TAdnexaKanan.getText(), TAdnexaKiri.getText(), TCavumDouglas.getText()
                        })==true){
                            tabModeGinekologi.addRow(new Object[] {
                                false,TNoRw.getText(),TNoRM.getText(),TPasien.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                                TInspeksi.getText(),TInspeksiVulva.getText(),TInspekuloGine.getText(),cmbFluxusGine.getSelectedItem().toString(),cmbFluorGine.getSelectedItem().toString(),TVulvaInspekulo.getText(),
                                TPortioInspekulo.getText(),TSondage.getText(),TPortioDalam.getText(),TBentuk.getText(),TCavumUteri.getText(),cmbMobilitas.getSelectedItem().toString(),TUkuran.getText(),
                                cmbNyeriTekan.getSelectedItem().toString(),TAdnexaKanan.getText(),TAdnexaKiri.getText(),TCavumDouglas.getText()
                            });
                            TInspeksi.setText("");TInspeksiVulva.setText("");TInspekuloGine.setText("");
                            cmbFluxusGine.setSelectedIndex(0);cmbFluorGine.setSelectedIndex(0); TVulvaInspekulo.setText("");
                            TPortioInspekulo.setText(""); TSondage.setText(""); TPortioDalam.setText("");
                            TBentuk.setText(""); TCavumUteri.setText(""); cmbMobilitas.setSelectedIndex(0);
                            TUkuran.setText(""); cmbNyeriTekan.setSelectedIndex(0);
                            TAdnexaKanan.setText(""); TAdnexaKiri.setText(""); TCavumDouglas.getText();
                            LCount.setText(""+tabModeGinekologi.getRowCount());
                    }
                } break;
            default:
                break;
        }
    }

    private void gantitindakandokter() {
        if(Sequel.cariRegistrasi(tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),1).toString())>0){
            JOptionPane.showMessageDialog(rootPane,"Data billing sudah terverifikasi, data tidak boleh diubah.\nSilahkan hubungi bagian kasir/keuangan ..!!");
            TCari.requestFocus();
        }else{
            Sequel.AutoComitFalse();
            sukses=true;
            if(Sequel.mengedittf("rawat_inap_dr","no_rawat='"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),1)+
                    "' and kd_jenis_prw='"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),10)+  
                    "' and kd_dokter='"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),5)+
                    "' and tgl_perawatan='"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),7)+
                    "' and jam_rawat='"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),8)+"'",
                    "no_rawat='"+TNoRw.getText()+"',kd_jenis_prw='"+TKdPrw.getText()+
                    "',kd_dokter='"+KdDok.getText()+"',material='"+BagianRS.getText()+
                    "',bhp='"+Bhp.getText()+"',tarif_tindakandr='"+JmDokter.getText()+"',biaya_rawat='"+TTnd.getText()+
                    "',tgl_perawatan='"+Valid.SetTgl(DTPTgl.getSelectedItem()+"")+"',jam_rawat='"+cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem()+"',"+
                    "kso='"+KSO.getText()+"',menejemen='"+Menejemen.getText()+"'")==true){

                Sequel.queryu("delete from tampjurnal");
                if(Valid.SetAngka(tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),9).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"','Suspen Piutang Tindakan Ranap','0','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),9).toString()+"'","kredit=kredit+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),9).toString()+"'","kd_rek='"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getTindakan_Ranap()+"','Pendapatan Tindakan Rawat Inap','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),9).toString()+"','0'","debet=debet+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),9).toString()+"'","kd_rek='"+akuntindakanranap.getTindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }
                }
                if(Valid.SetAngka(tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),11).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Beban Jasa Medik Dokter Tindakan Ranap','0','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),11).toString()+"'","kredit=kredit+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),11).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Utang Jasa Medik Dokter Tindakan Ranap','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),11).toString()+"','0'","debet=debet+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),11).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                } 
                }
                if(Valid.SetAngka(tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),12).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"','Beban KSO Tindakan Ranap','0','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),12).toString()+"'","kredit=kredit+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),12).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"','Utang KSO Tindakan Ranap','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),12).toString()+"','0'","debet=debet+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),12).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                }
                if(Valid.SetAngka(tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),13).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"','Beban Jasa Sarana Tindakan Ranap','0','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),13).toString()+"'","kredit=kredit+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),13).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }  
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"','Utang Jasa Sarana Tindakan Ranap','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),13).toString()+"','0'","debet=debet+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),13).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                } 
                }
                if(Valid.SetAngka(tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),14).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"','HPP BHP Tindakan Ranap','0','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),14).toString()+"'","kredit=kredit+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),14).toString()+"'","kd_rek='"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"','Persediaan BHP Tindakan Ranap','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),14).toString()+"','0'","debet=debet+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),14).toString()+"'","kd_rek='"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                } 
                }
                if(Valid.SetAngka(tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),15).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"','Beban Jasa Menejemen Tindakan Ranap','0','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),15).toString()+"'","kredit=kredit+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),15).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"','Utang Jasa Menejemen Tindakan Ranap','"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),15).toString()+"','0'","debet=debet+'"+tbRawatDr.getValueAt(tbRawatDr.getSelectedRow(),15).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                                    sukses=false;
                                }
                }
                
                if(sukses==true){
                    sukses=jur.simpanJurnal(TNoRw.getText(),"U","PERUBAHAN TINDAKAN RAWAT INAP PASIEN OLEH "+akses.getkode());
                }

                if(sukses==true){
                    Sequel.queryu("delete from tampjurnal");
                        if(Valid.SetAngka(TTnd.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"','Suspen Piutang Tindakan Ranap','"+TTnd.getText()+"','0'","debet=debet+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getTindakan_Ranap()+"','Pendapatan Tindakan Rawat Inap','0','"+TTnd.getText()+"'","kredit=kredit+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getTindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(JmDokter.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Beban Jasa Medik Dokter Tindakan Ranap','"+JmDokter.getText()+"','0'","debet=debet+'"+(JmDokter.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Utang Jasa Medik Dokter Tindakan Ranap','0','"+JmDokter.getText()+"'","kredit=kredit+'"+(JmDokter.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(KSO.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"','Beban KSO Tindakan Ranap','"+KSO.getText()+"','0'","debet=debet+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"','Utang KSO Tindakan Ranap','0','"+KSO.getText()+"'","kredit=kredit+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(BagianRS.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"','Beban Jasa Sarana Tindakan Ranap','"+BagianRS.getText()+"','0'","debet=debet+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"','Utang Jasa Sarana Tindakan Ranap','0','"+BagianRS.getText()+"'","kredit=kredit+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(Bhp.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"','HPP BHP Tindakan Ranap','"+Bhp.getText()+"','0'","debet=debet+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"','Persediaan BHP Tindakan Ranap','0','"+Bhp.getText()+"'","kredit=kredit+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(Menejemen.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"','Beban Jasa Menejemen Tindakan Ranap','"+Menejemen.getText()+"','0'","debet=debet+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"','Utang Jasa Menejemen Tindakan Ranap','0','"+Menejemen.getText()+"'","kredit=kredit+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(sukses==true){
                        sukses=jur.simpanJurnal(TNoRw.getText(),"U","PERUBAHAN TINDAKAN RAWAT INAP PASIEN "+TPasien.getText());
                    }
                }
            }else{
                sukses=false;
            }  

            if(sukses==true){
                Sequel.Commit();
                tbRawatDr.setValueAt(TNoRw.getText(),tbRawatDr.getSelectedRow(), 1);
                tbRawatDr.setValueAt(TNoRM.getText(),tbRawatDr.getSelectedRow(), 2);
                tbRawatDr.setValueAt(TPasien.getText(),tbRawatDr.getSelectedRow(), 3);
                tbRawatDr.setValueAt(TNmPrw.getText(),tbRawatDr.getSelectedRow(), 4);
                tbRawatDr.setValueAt(KdDok.getText(),tbRawatDr.getSelectedRow(), 5);
                tbRawatDr.setValueAt(TDokter.getText(),tbRawatDr.getSelectedRow(), 6);
                tbRawatDr.setValueAt(Valid.SetTgl(DTPTgl.getSelectedItem()+""),tbRawatDr.getSelectedRow(), 7);
                tbRawatDr.setValueAt(cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),tbRawatDr.getSelectedRow(), 8);
                tbRawatDr.setValueAt(Double.parseDouble(TTnd.getText()),tbRawatDr.getSelectedRow(), 9);
                tbRawatDr.setValueAt(TKdPrw.getText(),tbRawatDr.getSelectedRow(), 10);
                tbRawatDr.setValueAt(JmDokter.getText(),tbRawatDr.getSelectedRow(), 11);
                tbRawatDr.setValueAt(KSO.getText(),tbRawatDr.getSelectedRow(), 12);
                tbRawatDr.setValueAt(BagianRS.getText(),tbRawatDr.getSelectedRow(), 13);
                tbRawatDr.setValueAt(Bhp.getText(),tbRawatDr.getSelectedRow(), 14);
                tbRawatDr.setValueAt(Menejemen.getText(),tbRawatDr.getSelectedRow(), 15);
                BtnBatalActionPerformed(null);
            }else{
                JOptionPane.showMessageDialog(null,"Terjadi kesalahan saat pemrosesan data, transaksi dibatalkan.\nPeriksa kembali data sebelum melanjutkan menyimpan..!!");
                Sequel.RollBack();
            }
            Sequel.AutoComitTrue();
        }
    }
    
    private void gantitindakanpetugas(){
        if(Sequel.cariRegistrasi(tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),1).toString())>0){
            JOptionPane.showMessageDialog(rootPane,"Data billing sudah terverifikasi, data tidak boleh diubah.\nSilahkan hubungi bagian kasir/keuangan ..!!");
            TCari.requestFocus();
        }else{
            Sequel.AutoComitFalse();
            sukses=true;
            if(Sequel.mengedittf("rawat_inap_pr","no_rawat='"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),1)+
                    "' and kd_jenis_prw='"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),10)+
                    "' and nip='"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),5)+
                    "' and tgl_perawatan='"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),7)+
                    "' and jam_rawat='"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),8)+"'",
                    "no_rawat='"+TNoRw.getText()+"',kd_jenis_prw='"+TKdPrwPetugas.getText()+
                    "',nip='"+kdptg.getText()+"',material='"+BagianRS.getText()+
                    "',bhp='"+Bhp.getText()+"',tarif_tindakanpr='"+JmPerawat.getText()+"',biaya_rawat='"+TTnd.getText()+
                    "',tgl_perawatan='"+Valid.SetTgl(DTPTgl.getSelectedItem()+"")+"',jam_rawat='"+cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem()+"',"+
                    "kso='"+KSO.getText()+"',menejemen='"+Menejemen.getText()+"'")==true){

                Sequel.queryu("delete from tampjurnal");
                if(Valid.SetAngka(tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),9).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"','Suspen Piutang Tindakan Ranap','0','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),9).toString()+"'","kredit=kredit+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),9).toString()+"'","kd_rek='"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getTindakan_Ranap()+"','Pendapatan Tindakan Rawat Inap','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),9).toString()+"','0'","debet=debet+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),9).toString()+"'","kd_rek='"+akuntindakanranap.getTindakan_Ranap()+"'")==false){
                        sukses=false;
                    }
                }
                if(Valid.SetAngka(tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),11).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Beban Jasa Medik Dokter Tindakan Ranap','0','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),11).toString()+"'","kredit=kredit+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),11).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Utang Jasa Medik Dokter Tindakan Ranap','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),11).toString()+"','0'","debet=debet+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),11).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                }
                if(Valid.SetAngka(tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),12).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"','Beban KSO Tindakan Ranap','0','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),12).toString()+"'","kredit=kredit+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),12).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    }  
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"','Utang KSO Tindakan Ranap','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),12).toString()+"','0'","debet=debet+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),12).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    }  
                }
                if(Valid.SetAngka(tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),13).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"','Beban Jasa Sarana Tindakan Ranap','0','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),13).toString()+"'","kredit=kredit+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),13).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    }  
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"','Utang Jasa Sarana Tindakan Ranap','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),13).toString()+"','0'","debet=debet+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),13).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                }
                if(Valid.SetAngka(tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),14).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"','HPP BHP Tindakan Ranap','0','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),14).toString()+"'","kredit=kredit+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),14).toString()+"'","kd_rek='"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"','Persediaan BHP Tindakan Ranap','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),14).toString()+"','0'","debet=debet+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),14).toString()+"'","kd_rek='"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                }
                if(Valid.SetAngka(tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),15).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"','Beban Jasa Menejemen Tindakan Ranap','0','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),15).toString()+"'","kredit=kredit+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),15).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"','Utang Jasa Menejemen Tindakan Ranap','"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),15).toString()+"','0'","debet=debet+'"+tbRawatPr.getValueAt(tbRawatPr.getSelectedRow(),15).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    }
                }
                if(sukses==true){
                    sukses=jur.simpanJurnal(TNoRw.getText(),"U","PEMBATALAN TINDAKAN RAWAT INAP PASIEN "+TNoRM.getText()+" "+TPasien.getText()+" OLEH "+akses.getkode());
                }

                if(sukses==true){
                    Sequel.queryu("delete from tampjurnal");
                    if(Valid.SetAngka(TTnd.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"','Suspen Piutang Tindakan Ranap','"+TTnd.getText()+"','0'","debet=debet+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getTindakan_Ranap()+"','Pendapatan Tindakan Rawat Inap','0','"+TTnd.getText()+"'","kredit=kredit+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getTindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(JmPerawat.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Beban Jasa Medik Paramedis Tindakan Ranap','"+JmPerawat.getText()+"','0'","debet=debet+'"+(JmPerawat.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Utang Jasa Medik Paramedis Tindakan Ranap','0','"+JmPerawat.getText()+"'","kredit=kredit+'"+(JmPerawat.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(KSO.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"','Beban KSO Tindakan Ranap','"+KSO.getText()+"','0'","debet=debet+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"','Utang KSO Tindakan Ranap','0','"+KSO.getText()+"'","kredit=kredit+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(BagianRS.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"','Beban Jasa Sarana Tindakan Ranap','"+BagianRS.getText()+"','0'","debet=debet+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"','Utang Jasa Sarana Tindakan Ranap','0','"+BagianRS.getText()+"'","kredit=kredit+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(Bhp.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"','HPP BHP Tindakan Ranap','"+Bhp.getText()+"','0'","debet=debet+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"','Persediaan BHP Tindakan Ranap','0','"+Bhp.getText()+"'","kredit=kredit+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(Menejemen.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"','Beban Jasa Menejemen Tindakan Ranap','"+Menejemen.getText()+"','0'","debet=debet+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"','Utang Jasa Menejemen Tindakan Ranap','0','"+Menejemen.getText()+"'","kredit=kredit+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(sukses==true){
                        sukses=jur.simpanJurnal(TNoRw.getText(),"U","TINDAKAN RAWAT INAP PASIEN "+TPasien.getText());
                    }
                }
            }else{
                sukses=false;
            } 
            if(sukses==true){
                Sequel.Commit();
                tbRawatPr.setValueAt(TNoRw.getText(),tbRawatPr.getSelectedRow(), 1);
                tbRawatPr.setValueAt(TNoRM.getText(),tbRawatPr.getSelectedRow(), 2);
                tbRawatPr.setValueAt(TPasien.getText(),tbRawatPr.getSelectedRow(), 3);
                tbRawatPr.setValueAt(TNmPrwPetugas.getText(),tbRawatPr.getSelectedRow(), 4);
                tbRawatPr.setValueAt(kdptg.getText(),tbRawatPr.getSelectedRow(), 5);
                tbRawatPr.setValueAt(TPerawat.getText(),tbRawatPr.getSelectedRow(), 6);
                tbRawatPr.setValueAt(Valid.SetTgl(DTPTgl.getSelectedItem()+""),tbRawatPr.getSelectedRow(), 7);
                tbRawatPr.setValueAt(cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),tbRawatPr.getSelectedRow(), 8);
                tbRawatPr.setValueAt(Double.parseDouble(TTnd.getText()),tbRawatPr.getSelectedRow(), 9);
                tbRawatPr.setValueAt(TKdPrwPetugas.getText(),tbRawatPr.getSelectedRow(), 10);
                tbRawatPr.setValueAt(JmPerawat.getText(),tbRawatPr.getSelectedRow(), 11);
                tbRawatPr.setValueAt(KSO.getText(),tbRawatPr.getSelectedRow(), 12);
                tbRawatPr.setValueAt(BagianRS.getText(),tbRawatPr.getSelectedRow(), 13);
                tbRawatPr.setValueAt(Bhp.getText(),tbRawatPr.getSelectedRow(), 14);
                tbRawatPr.setValueAt(Menejemen.getText(),tbRawatPr.getSelectedRow(), 15);
                BtnBatalActionPerformed(null);
            }else{
                JOptionPane.showMessageDialog(null,"Terjadi kesalahan saat pemrosesan data, transaksi dibatalkan.\nPeriksa kembali data sebelum melanjutkan menyimpan..!!");
                Sequel.RollBack();
            }
            Sequel.AutoComitTrue();
        }
    }
    
    private void gantitindakandokterpetugas(){
        if(Sequel.cariRegistrasi(tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),1).toString())>0){
            JOptionPane.showMessageDialog(rootPane,"Data billing sudah terverifikasi, data tidak boleh diubah.\nSilahkan hubungi bagian kasir/keuangan ..!!");
            TCari.requestFocus();
        }else{
            Sequel.AutoComitFalse();
            sukses=true;
            if(Sequel.mengedittf("rawat_inap_drpr","no_rawat='"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),1)+
                    "' and kd_jenis_prw='"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),12)+
                    "' and kd_dokter='"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),5)+
                    "' and nip='"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),7)+
                    "' and tgl_perawatan='"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),9)+
                    "' and jam_rawat='"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),10)+"'",
                    "no_rawat='"+TNoRw.getText()+"',kd_jenis_prw='"+TKdPrwDokterPetugas.getText()+
                    "',nip='"+kdptg2.getText()+"',kd_dokter='"+KdDok2.getText()+"',material='"+BagianRS.getText()+
                    "',bhp='"+Bhp.getText()+"',tarif_tindakanpr='"+JmPerawat.getText()+"',tarif_tindakandr='"+JmDokter.getText()+"',biaya_rawat='"+TTnd.getText()+
                    "',tgl_perawatan='"+Valid.SetTgl(DTPTgl.getSelectedItem()+"")+"',jam_rawat='"+cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem()+"',"+
                    "kso='"+KSO.getText()+"',menejemen='"+Menejemen.getText()+"'")==true){

                Sequel.queryu("delete from tampjurnal");
                if(Valid.SetAngka(tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),11).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"','Suspen Piutang Tindakan Ranap','0','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),11).toString()+"'","kredit=kredit+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),11).toString()+"'","kd_rek='"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getTindakan_Ranap()+"','Pendapatan Tindakan Rawat Inap','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),11).toString()+"','0'","debet=debet+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),11).toString()+"'","kd_rek='"+akuntindakanranap.getTindakan_Ranap()+"'")==false){
                        sukses=false;
                    }   
                }
                if(Valid.SetAngka(tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),13).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Beban Jasa Medik Dokter Tindakan Ranap','0','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),13).toString()+"'","kredit=kredit+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),13).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Utang Jasa Medik Dokter Tindakan Ranap','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),13).toString()+"','0'","debet=debet+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),13).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                }
                if(Valid.SetAngka(tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),14).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Beban Jasa Medik Paramedis Tindakan Ranap','0','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),14).toString()+"'","kredit=kredit+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),14).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    }     
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Utang Jasa Medik Paramedis Tindakan Ranap','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),14).toString()+"','0'","debet=debet+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),14).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    }         
                }
                if(Valid.SetAngka(tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),15).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"','Beban KSO Tindakan Ranap','0','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),15).toString()+"'","kredit=kredit+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),15).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    }  
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"','Utang KSO Tindakan Ranap','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),15).toString()+"','0'","debet=debet+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),15).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    }                               
                }
                if(Valid.SetAngka(tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),16).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"','Beban Jasa Sarana Tindakan Ranap','0','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),16).toString()+"'","kredit=kredit+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),16).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"','Utang Jasa Sarana Tindakan Ranap','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),16).toString()+"','0'","debet=debet+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),16).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                }
                if(Valid.SetAngka(tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),17).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"','HPP BHP Tindakan Ranap','0','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),17).toString()+"'","kredit=kredit+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),17).toString()+"'","kd_rek='"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"','Persediaan BHP Tindakan Ranap','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),17).toString()+"','0'","debet=debet+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),17).toString()+"'","kd_rek='"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    } 
                }
                if(Valid.SetAngka(tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),18).toString())>0){
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"','Beban Jasa Menejemen Tindakan Ranap','0','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),18).toString()+"'","kredit=kredit+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),18).toString()+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    }    
                    if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"','Utang Jasa Menejemen Tindakan Ranap','"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),18).toString()+"','0'","debet=debet+'"+tbRawatDrPr.getValueAt(tbRawatDrPr.getSelectedRow(),18).toString()+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                        sukses=false;
                    }  
                }
                if(sukses==true){
                    sukses=jur.simpanJurnal(TNoRw.getText(),"U","PEMBATALAN TINDAKAN RAWAT INAP PASIEN "+TNoRM.getText()+" "+TPasien.getText()+" OLEH "+akses.getkode());
                }

                if(sukses==true){
                    Sequel.queryu("delete from tampjurnal");
                    if(Valid.SetAngka(TTnd.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"','Suspen Piutang Tindakan Ranap','"+TTnd.getText()+"','0'","debet=debet+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getSuspen_Piutang_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getTindakan_Ranap()+"','Pendapatan Tindakan Rawat Inap','0','"+TTnd.getText()+"'","kredit=kredit+'"+(TTnd.getText())+"'","kd_rek='"+akuntindakanranap.getTindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(JmDokter.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Beban Jasa Medik Dokter Tindakan Ranap','"+JmDokter.getText()+"','0'","debet=debet+'"+(JmDokter.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"','Utang Jasa Medik Dokter Tindakan Ranap','0','"+JmDokter.getText()+"'","kredit=kredit+'"+(JmDokter.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Dokter_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(JmPerawat.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Beban Jasa Medik Paramedis Tindakan Ranap','"+JmPerawat.getText()+"','0'","debet=debet+'"+(JmPerawat.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"','Utang Jasa Medik Paramedis Tindakan Ranap','0','"+JmPerawat.getText()+"'","kredit=kredit+'"+(JmPerawat.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Medik_Paramedis_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(KSO.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"','Beban KSO Tindakan Ranap','"+KSO.getText()+"','0'","debet=debet+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_KSO_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"','Utang KSO Tindakan Ranap','0','"+KSO.getText()+"'","kredit=kredit+'"+(KSO.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_KSO_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(BagianRS.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"','Beban Jasa Sarana Tindakan Ranap','"+BagianRS.getText()+"','0'","debet=debet+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"','Utang Jasa Sarana Tindakan Ranap','0','"+BagianRS.getText()+"'","kredit=kredit+'"+(BagianRS.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Sarana_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(Bhp.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"','HPP BHP Tindakan Ranap','"+Bhp.getText()+"','0'","debet=debet+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getHPP_BHP_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"','Persediaan BHP Tindakan Ranap','0','"+Bhp.getText()+"'","kredit=kredit+'"+(Bhp.getText())+"'","kd_rek='"+akuntindakanranap.getPersediaan_BHP_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(Valid.SetAngka(Menejemen.getText())>0){
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"','Beban Jasa Menejemen Tindakan Ranap','"+Menejemen.getText()+"','0'","debet=debet+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getBeban_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }  
                        if(Sequel.menyimpantf("tampjurnal","'"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"','Utang Jasa Menejemen Tindakan Ranap','0','"+Menejemen.getText()+"'","kredit=kredit+'"+(Menejemen.getText())+"'","kd_rek='"+akuntindakanranap.getUtang_Jasa_Menejemen_Tindakan_Ranap()+"'")==false){
                            sukses=false;
                        }   
                    }
                    if(sukses==true){
                        sukses=jur.simpanJurnal(TNoRw.getText(),"U","TINDAKAN RAWAT INAP PASIEN "+TPasien.getText());
                    }
                }   
            }else{
                sukses=false;
            } 

            if(sukses==true){
                Sequel.Commit();
                tbRawatDrPr.setValueAt(TNoRw.getText(),tbRawatDrPr.getSelectedRow(), 1);
                tbRawatDrPr.setValueAt(TNoRM.getText(),tbRawatDrPr.getSelectedRow(), 2);
                tbRawatDrPr.setValueAt(TPasien.getText(),tbRawatDrPr.getSelectedRow(), 3);
                tbRawatDrPr.setValueAt(TNmPrwDokterPetugas.getText(),tbRawatDrPr.getSelectedRow(), 4);
                tbRawatDrPr.setValueAt(KdDok2.getText(),tbRawatDrPr.getSelectedRow(), 5);
                tbRawatDrPr.setValueAt(TDokter2.getText(),tbRawatDrPr.getSelectedRow(), 6);
                tbRawatDrPr.setValueAt(kdptg2.getText(),tbRawatDrPr.getSelectedRow(), 7);
                tbRawatDrPr.setValueAt(TPerawat2.getText(),tbRawatDrPr.getSelectedRow(), 8);
                tbRawatDrPr.setValueAt(Valid.SetTgl(DTPTgl.getSelectedItem()+""),tbRawatDrPr.getSelectedRow(), 9);
                tbRawatDrPr.setValueAt(cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),tbRawatDrPr.getSelectedRow(), 10);
                tbRawatDrPr.setValueAt(TTnd.getText(),tbRawatDrPr.getSelectedRow(), 11);
                tbRawatDrPr.setValueAt(TKdPrwDokterPetugas.getText(),tbRawatDrPr.getSelectedRow(), 12);
                tbRawatDrPr.setValueAt(JmDokter.getText(),tbRawatDrPr.getSelectedRow(), 13);
                tbRawatDrPr.setValueAt(JmPerawat.getText(),tbRawatDrPr.getSelectedRow(), 14);
                tbRawatDrPr.setValueAt(KSO.getText(),tbRawatDrPr.getSelectedRow(), 15);
                tbRawatDrPr.setValueAt(BagianRS.getText(),tbRawatDrPr.getSelectedRow(), 16);
                tbRawatDrPr.setValueAt(Bhp.getText(),tbRawatDrPr.getSelectedRow(), 17);
                tbRawatDrPr.setValueAt(Menejemen.getText(),tbRawatDrPr.getSelectedRow(), 18);
                BtnBatalActionPerformed(null);
            }else{
                JOptionPane.showMessageDialog(null,"Terjadi kesalahan saat pemrosesan data, transaksi dibatalkan.\nPeriksa kembali data sebelum melanjutkan menyimpan..!!");
                Sequel.RollBack();
            }
            Sequel.AutoComitTrue();                                    
        }
    }
    
    public void emptTeks(){
        ChkInput.setSelected(true);
        ChkInput1.setSelected(true);
        ChkInput2.setSelected(true);
        isForm(); 
        isForm2();
        isForm3();
        TSuhu.setText("");
        TKdPrw.setText("");
        TNmPrw.setText("");
        TKdPrwPetugas.setText("");
        TNmPrwPetugas.setText("");        
        TKdPrwDokterPetugas.setText("");
        TNmPrwDokterPetugas.setText("");
        TTensi.setText("");
        TKeluhan.setText("");
        TPemeriksaan.setText("");
        TPenilaian.setText("");
        TindakLanjut.setText("");
        TBerat.setText("");
        TTinggi.setText("");
        TNadi.setText("");
        SpO2.setText("");
        TEvaluasi.setText("");
        TRespirasi.setText("");
        TGCS.setText("");
        TAlergi.setText("");
        TTnd.setText("0");
        BagianRS.setText("0");
        Bhp.setText("0");
        JmDokter.setText("0");
        JmPerawat.setText("0");
        TInstruksi.setText("");
        DTPTgl.setDate(new Date());
        TTinggi_uteri.setText("");
        TLetak.setText("");
        TDenyut.setText("");
        TVulva.setText("");
        TPortio.setText("");
        TTebal.setText("");
        TPembukaan.setText("");
        TPenurunan.setText("");
        TDenominator.setText("");
        TKualitas_mnt.setText("");
        TKualitas_dtk.setText("");
        TInspeksi.setText("");
        TInspeksiVulva.setText("");
        TInspekuloGine.setText("");
        TVulvaInspekulo.setText("");
        TPortioInspekulo.setText("");
        TSondage.setText("");
        TPortioDalam.setText("");
        TBentuk.setText("");
        TCavumUteri.setText("");
        TUkuran.setText("");
        TAdnexaKanan.setText("");
        TAdnexaKiri.setText("");
        TCavumDouglas.setText("");
        cmbKesadaran.setSelectedIndex(0);
        TNoRw.requestFocus();
    }
    
    private void runBackground(Runnable task) {
        if (ceksukses) return;
        if (executor.isShutdown() || executor.isTerminated()) return;
        if (!isDisplayable()) return;

        ceksukses = true;
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        try {
            executor.submit(() -> {
                try {
                    task.run();
                } finally {
                    ceksukses = false;
                    SwingUtilities.invokeLater(() -> {
                        if (isDisplayable()) {
                            setCursor(Cursor.getDefaultCursor());
                        }
                    });
                }
            });
        } catch (RejectedExecutionException ex) {
            ceksukses = false;
        }
    }
    
    /** Tab tambahan Data Lama Operasi; terpisah dari filter Rawat Inap. */
    /** Tab tambahan Data Lama Operasi. */
    private class PanelDataLamaOperasi extends javax.swing.JPanel {
        private final javax.swing.table.DefaultTableModel model;
        private final javax.swing.JTable tabel;

        PanelDataLamaOperasi() {
            setLayout(new java.awt.BorderLayout(5,5));
            model = new javax.swing.table.DefaultTableModel(new Object[]{"No.","Tgl. Operasi","No. Rawat","No. RM","Nama Pasien","Operator 1","Operasi","Mulai","Selesai","Durasi (menit)","Status Laporan"},0) {
                @Override public boolean isCellEditable(int row, int col) { return false; }
            };
            tabel = new javax.swing.JTable(model); tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            tabel.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION); tabel.setRowHeight(22);
            int[] widths = {45,145,155,75,190,160,220,145,145,110,140};
            for (int i=0;i<widths.length;i++) tabel.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            tabel.setDefaultRenderer(Object.class,new WarnaTable()); add(new javax.swing.JScrollPane(tabel),java.awt.BorderLayout.CENTER);
            javax.swing.JPopupMenu popup = new javax.swing.JPopupMenu();
            javax.swing.JMenuItem laporan = new javax.swing.JMenuItem("Ubah Laporan Operasi Pasien");
            laporan.addActionListener(e -> bukaLaporanOperasi()); popup.add(laporan); 
            javax.swing.JMenuItem cetak =
                new javax.swing.JMenuItem("Laporan Operasi Pasien");
            cetak.addActionListener(e -> cetakLaporanOperasi());
            popup.add(cetak);
tabel.setComponentPopupMenu(popup);
            tabel.addMouseListener(new java.awt.event.MouseAdapter() {
                private void pilih(java.awt.event.MouseEvent e) { int r=tabel.rowAtPoint(e.getPoint()); if(r>=0)tabel.setRowSelectionInterval(r,r); }
                @Override public void mousePressed(java.awt.event.MouseEvent e) { if(e.isPopupTrigger())pilih(e); }
                @Override public void mouseReleased(java.awt.event.MouseEvent e) { if(e.isPopupTrigger())pilih(e); }
            });
            tampil();
        }
        private void tampil() {
            model.setRowCount(0);
            String sql="SELECT o.no_rawat,o.tgl_operasi,rp.no_rkm_medis,p.nm_pasien,o.operator1,pg.nama AS nama_operator,po.nm_perawatan,lo.tanggal AS mulai,lo.selesaioperasi,"+
                "CASE WHEN lo.tanggal IS NOT NULL AND lo.selesaioperasi IS NOT NULL AND lo.selesaioperasi>lo.tanggal THEN TIMESTAMPDIFF(MINUTE,lo.tanggal,lo.selesaioperasi) ELSE NULL END AS durasi,"+
                "CASE WHEN lo.no_rawat IS NULL THEN 'Belum ada laporan' ELSE 'Sudah ada laporan' END AS status_laporan FROM operasi o "+
                "INNER JOIN reg_periksa rp ON rp.no_rawat=o.no_rawat INNER JOIN pasien p ON p.no_rkm_medis=rp.no_rkm_medis "+
                "LEFT JOIN pegawai pg ON pg.nik=o.operator1 LEFT JOIN paket_operasi po ON po.kode_paket=o.kode_paket "+
                "LEFT JOIN laporan_operasi lo ON lo.no_rawat=o.no_rawat AND lo.tanggal=o.tgl_operasi "+
                "WHERE o.no_rawat=? ORDER BY o.tgl_operasi DESC,o.no_rawat";
            String noRawatAktif=TNoRw.getText().trim();
            if(noRawatAktif.isEmpty()) return;
            try (java.sql.PreparedStatement psTab=koneksi.prepareStatement(sql)) {
                psTab.setString(1,noRawatAktif);
                try (java.sql.ResultSet r=psTab.executeQuery()) { int no=0; while(r.next()) {
                    String op=r.getString("nama_operator"); if(op==null||op.trim().isEmpty())op=r.getString("operator1");
                    java.sql.Timestamp mulai=r.getTimestamp("mulai"), selesai=r.getTimestamp("selesaioperasi"); Object durasi=r.getObject("durasi");
                    model.addRow(new Object[]{++no,r.getString("tgl_operasi"),r.getString("no_rawat"),r.getString("no_rkm_medis"),r.getString("nm_pasien"),op,r.getString("nm_perawatan"),mulai==null?"":mulai.toString(),selesai==null?"":selesai.toString(),durasi==null?"Periksa waktu":durasi,r.getString("status_laporan")});
                }}
            } catch(Exception ex) { System.out.println("Notif Data Lama Operasi: "+ex); javax.swing.JOptionPane.showMessageDialog(this,"Gagal mengambil data operasi:\n"+ex.getMessage(),"Data Lama Operasi",javax.swing.JOptionPane.ERROR_MESSAGE); }
        }
        private void bukaLaporanOperasi() {
            int row = tabel.getSelectedRow();
            if (row < 0) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Pilih baris operasi terlebih dahulu.");
                return;
            }

            String noRawat = String.valueOf(tabel.getValueAt(row, 2));
            String tanggalOperasi = String.valueOf(tabel.getValueAt(row, 1));

            try {
                DlgCariTagihanOperasi form =
                    new DlgCariTagihanOperasi(null, false);
                form.bukaLaporanOperasiDariDataLama(noRawat, tanggalOperasi);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Gagal membuka form Laporan Operasi:\n" + ex.getMessage(),
                    "Laporan Operasi",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }

        private void cetakLaporanOperasi() {
            int row = tabel.getSelectedRow();
            if (row < 0) {
                javax.swing.JOptionPane.showMessageDialog(
                    this, "Pilih baris operasi terlebih dahulu.");
                return;
            }

            String noRawat = String.valueOf(tabel.getValueAt(row, 2));
            String tanggalOperasi = String.valueOf(tabel.getValueAt(row, 1));

            try {
                DlgCariTagihanOperasi form =
                    new DlgCariTagihanOperasi(null, false);
                form.cetakLaporanOperasiDariDataLama(
                    noRawat, tanggalOperasi);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Gagal mencetak Laporan Operasi:\n" + ex.getMessage(),
                    "Cetak Laporan Operasi",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
                ex.printStackTrace();
            }
        }

    }

    public void dispose() {
        executor.shutdownNow();
        if (panelRiwayatPerawatan != null) {
            panelRiwayatPerawatan.dispose();
        }
        super.dispose();
    }
}
