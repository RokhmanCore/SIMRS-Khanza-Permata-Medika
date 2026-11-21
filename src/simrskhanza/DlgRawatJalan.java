Warning: truncated output (original token count: 218051)
Total output lines: 15078

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

import surat.SuratKontrol;
import kepegawaian.DlgCariDokter;
import kepegawaian.DlgCariPetugas;
import inventory.DlgPemberianObat;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import fungsi.akuntindakanralan;
import fungsi.copypastesoapralan;
import fungsi.kodebpjs;
import fungsi.tarifralan;
import inventory.DlgCariObat;
import inventory.DlgCopyResep;
import inventory.DlgPeresepanDokter;
import inventory.InventoryResepLuar;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import kepegawaian.DlgCariPegawai;
import keuangan.DlgJnsPerawatanRalan;
import keuangan.Jurnal;
import laporan.DlgBerkasRawat;
import permintaan.DlgBookingOperasi;
import permintaan.DlgPermintaanKonsultasiMedik;
import permintaan.DlgPermintaanKonsultasiPerawat;
import rekammedis.RMDataResumePasien;
import permintaan.DlgPermintaanLaboratorium;
import permintaan.DlgPermintaanPelayananInformasiObat;
import permintaan.DlgPermintaanRadiologi;
import rekammedis.MasterCariTemplatePemeriksaan;
import rekammedis.RMAdmisiSkoringTOLAC;
import rekammedis.RMCari5SOAPTerakhir;
import rekammedis.RMCatatanADIMEGizi;
import rekammedis.RMCatatanAnastesiSedasi;
import rekammedis.RMCatatanPengkajianPaskaOperasi;
import rekammedis.RMCatatanPersalinan;
import rekammedis.RMChecklistKesiapanAnestesi;
import rekammedis.RMChecklistKriteriaMasukHCU;
import rekammedis.RMChecklistKriteriaMasukICU;
import rekammedis.RMChecklistKriteriaMasukIsolasi;
import rekammedis.RMChecklistKriteriaMasukNICU;
import rekammedis.RMChecklistKriteriaMasukPICU;
import rekammedis.RMChecklistPemberianFibrinolitik;
import rekammedis.RMChecklistPostOperasi;
import rekammedis.RMChecklistPreOperasi;
import rekammedis.RMDataAsuhanGizi;
import rekammedis.RMDataCatatanCairanHemodialisa;
import rekammedis.RMDataCatatanCekGDS;
import rekammedis.RMDataCatatanKeperawatanRalan;
import rekammedis.RMDataCatatanKeseimbanganCairan;
import rekammedis.RMDataCatatanObservasiBayi;
import rekammedis.RMDataCatatanObservasiCHBP;
import rekammedis.RMDataCatatanObservasiHemodialisa;
import rekammedis.RMDataCatatanObservasiIGD;
import rekammedis.RMDataCatatanObservasiInduksiPersalinan;
import rekammedis.RMDataCatatanObservasiRuangOperasi;
import rekammedis.RMDataIntervensiNyeriFarmakologi;
import rekammedis.RMDataIntervensiNyeriNonFarmakologi;
import rekammedis.RMDataMonitoringAsuhanGizi;
import rekammedis.RMDataMonitoringReaksiTranfusi;
import rekammedis.RMDataMonitoringTOLAC;
import rekammedis.RMDataSkriningGiziKehamilan;
import rekammedis.RMDataSkriningGiziLanjut;
import rekammedis.RMEdukasiPasienKeluargaRawatJalan;
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
import rekammedis.RMHasilPemeriksaanUSGAbdomen;
import rekammedis.RMHasilPemeriksaanUSGGynecologi;
import rekammedis.RMHasilPemeriksaanUSGNeonatus;
import rekammedis.RMHasilPemeriksaanUSGUrologi;
import rekammedis.RMHasilPersalinanTOLAC;
import rekammedis.RMHasilTindakanESWL;
import rekammedis.RMKonselingFarmasi;
import rekammedis.RMLaporanTindakan;
import rekammedis.RMLayananKedokteranFisikRehabilitasi;
import rekammedis.RMMCU;
import rekammedis.RMMonitoringAldrettePascaAnestesi;
import rekammedis.RMMonitoringBromagePascaAnestesi;
import rekammedis.RMMonitoringStewardPascaAnestesi;
import rekammedis.RMPelaksanaanInformasiEdukasi;
import rekammedis.RMPemantauanMEOWS;
import rekammedis.RMPemantauanPEWS;
import rekammedis.RMPemantauanEWSD;
import rekammedis.RMPemantauanEWSNeonatus;
import rekammedis.RMPenatalaksanaanTerapiOkupasi;
import rekammedis.RMPengkajianRestrain;
import rekammedis.RMPenilaianAwalKeperawatanBayiAnak;
import rekammedis.RMPenilaianAwalKeperawatanGigi;
import rekammedis.RMPenilaianAwalKeperawatanIGD;
import rekammedis.RMPenilaianAwalKeperawatanKebidanan;
import rekammedis.RMPenilaianAwalKeperawatanRalan;
import rekammedis.RMPenilaianAwalKeperawatanRalanGeriatri;
import rekammedis.RMPenilaianAwalKeperawatanRalanPsikiatri;
import rekammedis.RMPenilaianAwalMedisHemodialisa;
import rekammedis.RMPenilaianAwalMedisIGD;
import rekammedis.RMPenilaianAwalMedisIGDPsikiatri;
import rekammedis.RMPenilaianAwalMedisRalanAnak;
import rekammedis.RMPenilaianAwalMedisRalanBedah;
import rekammedis.RMPenilaianAwalMedisRalanBedahMulut;
import rekammedis.RMPenilaianAwalMedisRalanDewasa;
import rekammedis.RMPenilaianAwalMedisRalanGeriatri;
import rekammedis.RMPenilaianAwalMedisRalanJantung;
import rekammedis.RMPenilaianAwalMedisRalanKandungan;
import rekammedis.RMPenilaianAwalMedisRalanKulitDanKelamin;
import rekammedis.RMPenilaianAwalMedisRalanMata;
import rekammedis.RMPenilaianAwalMedisRalanNeurologi;
import rekammedis.RMPenilaianAwalMedisRalanOrthopedi;
import rekammedis.RMPenilaianAwalMedisRalanParu;
import rekammedis.RMPenilaianAwalMedisRalanPenyakitDalam;
import rekammedis.RMPenilaianAwalMedisRalanPsikiatrik;
import rekammedis.RMPenilaianAwalMedisRalanRehabMedik;
import rekammedis.RMPenilaianAwalMedisRalanTHT;
import rekammedis.RMPenilaianAwalMedisRalanUrologi;
import rekammedis.RMPenilaianBayiBaruLahir;
import rekammedis.RMPenilaianDerajatDehidrasi;
import rekammedis.RMPenilaianFisioterapi;
import rekammedis.RMPenilaianGRACE;
import rekammedis.RMPenilaianKorbanKekerasan;
import rekammedis.RMPenilaianLanjutanRisikoJatuhAnak;
import rekammedis.RMPenilaianLanjutanRisikoJatuhDewasa;
import rekammedis.RMPenilaianLanjutanRisikoJatuhGeriatri;
import rekammedis.RMPenilaianLanjutanRisikoJatuhLansia;
import rekammedis.RMPenilaianLanjutanRisikoJatuhPsikiatri;
import rekammedis.RMPenilaianLanjutanSkriningFungsional;
import rekammedis.RMPenilaianPasienImunitasRendah;
import rekammedis.RMPenilaianPasienKeracunan;
import rekammedis.RMPenilaianPasienPenyakitMenular;
import rekammedis.RMPenilaianPasienTerminal;
import rekammedis.RMPenilaianPreAnastesi;
import rekammedis.RMPenilaianPreInduksi;
import rekammedis.RMPenilaianPreOperasi;
import rekammedis.RMPenilaianPsikologi;
import rekammedis.RMPenilaianPsikologiKlinis;
import rekammedis.RMPenilaianRisikoJatuhNeonatus;
import rekammedis.RMPenilaianTambahanBunuhDiri;
import rekammedis.RMPenilaianTambahanGeriatri;
import rekammedis.RMPenilaianTambahanMelarikanDiri;
import rekammedis.RMPenilaianTambahanPerilakuKekerasan;
import rekammedis.RMPenilaianTerapiWicara;
import rekammedis.RMPenilaianUlangNyeri;
import rekammedis.RMReaksiTransfusi;
import rekammedis.RMRekonsiliasiObat;
import rekammedis.RMRiwayatPerawatan;
import rekammedis.PanelRiwayatRalan;
import rekammedis.RMSignInSebelumAnastesi;
import rekammedis.RMSignOutSebelumMenutupLuka;
import rekammedis.RMSkriningAdiksiNikotin;
import rekammedis.RMSkriningAnemia;
import rekammedis.RMSkriningCURB65;
import rekammedis.RMSkriningDiabetesMelitus;
import rekammedis.RMSkriningFrailtySyndrome;
import rekammedis.RMSkriningHipertensi;
import rekammedis.RMSkriningIndraPendengaran;
import rekammedis.RMSkriningInstrumenACRS;
import rekammedis.RMSkriningInstrumenAMT;
import rekammedis.RMSkriningInstrumenMentalEmosional;
import rekammedis.RMSkriningInstrumenSDQ;
import rekammedis.RMSkriningKankerKolorektal;
import rekammedis.RMSkriningKekerasanPadaPerempuan;
import rekammedis.RMSkriningKesehatanGigiMulutBalita;
import rekammedis.RMSkriningKesehatanGigiMulutDewasa;
import rekammedis.RMSkriningKesehatanGigiMulutLansia;
import rekammedis.RMSkriningKesehatanGigiMulutRemaja;
import rekammedis.RMSkriningKesehatanPenglihatan;
import rekammedis.RMSkriningMerokokUsiaSekolahRemaja;
import rekammedis.RMSkriningNutrisiAnak;
import rekammedis.RMSkriningNutrisiDewasa;
import rekammedis.RMSkriningNutrisiLansia;
import rekammedis.RMSkriningObesitas;
import rekammedis.RMSkriningPUMA;
import rekammedis.RMSkriningPneumoniaSeverityIndex;
import rekammedis.RMSkriningRisikoKankerParu;
import rekammedis.RMSkriningRisikoKankerPayudara;
import rekammedis.RMSkriningRisikoKankerServiks;
import rekammedis.RMSkriningSRQ;
import rekammedis.RMSkriningTBC;
import rekammedis.RMSkriningTOLAC;
import rekammedis.RMSkriningTalasemia;
import rekammedis.RMTimeOutSebelumInsisi;
import rekammedis.RMTransferPasienAntarRuang;
import rekammedis.RMTriaseIGD;
import rekammedis.RMUjiFungsiKFR;

/**
 *
 * @author dosen
 */
public final class DlgRawatJalan extends javax.swing.JDialog {
    private final DefaultTableModel tabModeDr,tabModePr,tabModeDrPr,
            tabModePemeriksaan,tabModeObstetri,tabModeGinekologi,
            TabModeTindakan,TabModeTindakan2,TabModeTindakan3,TabModeCatatan;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private PreparedStatement ps,ps2,ps3,ps4,ps5,ps6,pstindakan;
    private ResultSet rs,rstindakan;
    private int i=0,jmlparsial=0,jml=0,index=0,tinggi=0;
    private String aktifkanparsial="no",kode_poli="",kd_pj="",TANGGALMUNDUR="yes",pilihiterasi="";
    private boolean[] pilih; 
    private String[] kode,nama,kategori;
    private double[] totaltnd,bagianrs,bhp,jmdokter,jmperawat,kso,menejemen;
    private boolean sukses=false;
    public  boolean bypassranap=false,sudahperiksa=false;
    private double ttljmdokter=0,ttljmperawat=0,ttlkso=0,ttljasasarana=0,ttlbhp=0,ttlmenejemen=0,ttlpendapatan=0;
    private Jurnal jur=new Jurnal();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private PanelRiwayatRalan panelRiwayatPerawatan;
    private volatile boolean ceksukses = false;
    private DlgPeresepanDokter resepobat;

    /** Creates new form DlgPerawatan
     * @param parent
     * @param modal */
    public DlgRawatJalan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        TabRawat.addTab("Data Operasi", new PanelDataLamaOperasi());
        panelRiwayatPerawatan = new PanelRiwayatRalan(koneksi);
        TabRawat.addTab("Riwayat Perawatan", panelRiwayatPerawatan);
        TabRawat.addChangeListener(e -> {
            if (TabRawat.getSelectedComponent() instanceof PanelDataLamaOperasi) {
                ((PanelDataLamaOperasi) TabRawat.getSelectedComponent()).tampil();
            } else if (TabRawat.getSelectedComponent() == panelRiwayatPerawatan) {
                panelRiwayatPerawatan.setNoRawat(TNoRw.getText());
            }
        });

        initRawatJalan();

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
            "P","No.Rawat","No.R.M.","Nama Pasien","Perawatan/Tindakan","Kode Dokter","Dokter Yg Menangani","NIP","Petugas Yg Menangani","Tgl.Rawat","Jam Rawat",
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
                 java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
            "Respirasi(/menit)","Tinggi(Cm)","Berat(Kg)","SpO2(%)","GCS(E,V,M)","Kesadaran","Subjek","Objek","Alergi",
            "L.P.(Cm)","Plan","Asesmen","Inst/Impl","Evaluasi","NIP","Dokter/Paramedis","Profesi/Jabatan"}){
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
                 java.lang.Object.class, java.lang.Object.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbPemeriksaan.setModel(tabModePemeriksaan);
        tbPemeriksaan.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbPemeriksaan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 26; i++) {
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
                column.setPreferredWidth(50);
            }else if(i==19){
                column.setPreferredWidth(180);
            }else if(i==20){
                column.setPreferredWidth(180);
            }else if(i==21){
                column.setPreferredWidth(180);
            }else if(i==22){
                column.setPreferredWidth(180);
            }else if(i==23){
                column.setPreferredWidth(80);
            }else if(i==24){
                column.setPreferredWidth(150);
            }else if(i==25){
                column.setPreferredWidth(100);
            }
        }
        tbPemeriksaan.setDefaultRenderer(Object.class, new WarnaTable());
        
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
        
        TabModeTindakan=new DefaultTableModel(null,new Object[]{
            "P","Kode","Nama Perawatan","Kategori Perawatan","Tarif/Biaya","Bagian RS","BHP","JM Dokter","JM Perawat","KSO","Menejemen"}){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,  
                java.lang.Object.class,java.lang.Double.class,java.lang.Double.class,
                java.lang.Double.class,java.lang.Double.class,java.lang.Double.class,
                java.lang.Double.class,java.lang.Double.class
             };
             /*Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
             };*/
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbTindakan.setModel(TabModeTindakan);
        tbTindakan.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbTindakan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (i = 0; i < 11; i++) {
            TableColumn column = tbTindakan.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(90);
            }else if(i==2){
                column.setPreferredWidth(420);
            }else if(i==3){
                column.setPreferredWidth(150);
            }else if(i==5){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==6){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==7){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==8){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==9){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==10){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else{
                column.setPreferredWidth(90);
            }
        }
        tbTindakan.setDefaultRenderer(Object.class, new WarnaTable());

        TabModeTindakan2=new DefaultTableModel(null,new Object[]{"P","Kode","Nama Perawatan","Kategori Perawatan","Tarif/Biaya","Bagian RS","BHP","JM Dokter","JM Perawat","KSO","Menejemen"}){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,  
                java.lang.Object.class,java.lang.Double.class,java.lang.Double.class,
                java.lang.Double.class,java.lang.Double.class,java.lang.Double.class,
                java.lang.Double.class,java.lang.Double.class
             };
             /*Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
             };*/
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbTindakan2.setModel(TabModeTindakan2);
        tbTindakan2.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbTindakan2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (i = 0; i < 11; i++) {
            TableColumn column = tbTindakan2.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(90);
            }else if(i==2){
                column.setPreferredWidth(420);
            }else if(i==3){
                column.setPreferredWidth(150);
            }else if(i==5){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==6){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==7){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==8){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==9){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==10){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else{
                column.setPreferredWidth(90);
            }
        }
        tbTindakan2.setDefaultRenderer(Object.class, new WarnaTable());
        
        TabModeTindakan3=new DefaultTableModel(null,new Object[]{"P","Kode","Nama Perawatan","Kategori Perawatan","Tarif/Biaya","Bagian RS","BHP","JM Dokter","JM Perawat","KSO","Menejemen"}){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,  
                java.lang.Object.class,java.lang.Double.class,java.lang.Double.class,
                java.lang.Double.class,java.lang.Double.class,java.lang.Double.class,
                java.lang.Double.class,java.lang.Double.class
             };
             /*Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
             };*/
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbTindakan3.setModel(TabModeTindakan3);
        tbTindakan3.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbTindakan3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (i = 0; i < 11; i++) {
            TableColumn column = tbTindakan3.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(90);
            }else if(i==2){
                column.setPreferredWidth(420);
            }else if(i==3){
                column.setPreferredWidth(150);
            }else if(i==5){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==6){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==7){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==8){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==9){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==10){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else{
                column.setPreferredWidth(90);
            }
        }
        tbTindakan3.setDefaultRenderer(Object.class, new WarnaTable());
        
        TabModeCatatan=new DefaultTableModel(null,new Object[]{
            "P","No.Rawat","No.R.M.","Nama Pasien","Tanggal","Jam","Kode Dokter","Nama Dokter","Catatan"}){
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
                 java.lang.Object.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbCatatan.setModel(TabModeCatatan);
        tbCatatan.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbCatatan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 9; i++) {
            TableColumn column = tbCatatan.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(105);
            }else if(i==2){
                column.setPreferredWidth(70);
            }else if(i==3){
                column.setPreferredWidth(180);
            }else if(i==4){
                column.setPreferredWidth(80);
            }else if(i==5){
                column.setPreferredWidth(75);
            }else if(i==6){
                column.setPreferredWidth(80);
            }else if(i==7){
                column.setPreferredWidth(150);
            }else if(i==8){
                column.setPreferredWidth(700);
            }
        }
        tbCatatan.setDefaultRenderer(Object.class, new WarnaTable());
        
        TNoRw.setDocument(new batasInput((byte)17).getKata(TNoRw));
        kdptg.setDocument(new batasInput((byte)20).getKata(kdptg));
        kdptg2.setDocument(new batasInput((byte)20).getKata(kdptg2));
        KdDok.setDocument(new batasInput((byte)20).getKata(KdDok));
        KdDok2.setDocument(new batasInput((byte)20).getKata(KdDok2));
        KdPeg.setDocument(new batasInput((byte)20).getKata(KdPeg));
        TSuhu.setDocument(new batasInput((byte)5).getKata(TSuhu));
        TTensi.setDocument(new batasInput((byte)8).getKata(TTensi));
        TKeluhan.setDocument(new batasInput((int)2000).getKata(TKeluhan));
        TPemeriksaan.setDocument(new batasInput((int)2000).getKata(TPemeriksaan));
        TPenilaian.setDocument(new batasInput((int)2000).getKata(TPenilaian));    
        TInstruksi.setDocument(new batasInput((int)2000).getKata(TInstruksi));     
        TAlergi.setDocument(new batasInput((int)50).getKata(TAlergi));        
        TCari.setDocument(new batasInput((int)100).getKata(TCari));       
        TGCS.setDocument(new batasInput((byte)10).getKata(TGCS));
        TTinggi.setDocument(new batasInput((byte)5).getKata(TTinggi));
        LingkarPerut.setDocument(new batasInput((byte)5).getKata(LingkarPerut));
        TBerat.setDocument(new batasInput((byte)5).getKata(TBerat));
        TindakLanjut.setDocument(new batasInput((int)2000).getKata(TindakLanjut));
        TEvaluasi.setDocument(new batasInput((int)2000).getKata(TEvaluasi));
        TNadi.setDocument(new batasInput((byte)3).getOnlyAngka(TNadi));
        SpO2.setDocument(new batasInput((byte)3).getOnlyAngka(SpO2));
        TRespirasi.setDocument(new batasInput((byte)3).getOnlyAngka(TRespirasi));
        TTinggi_uteri.setDocument(new batasInput((byte)5).getKata(TTinggi_uteri));
        TLetak.setDocument(new batasInput((byte)50).getKata(TLetak));
        TDenyut.setDocument(new batasInput((byte)5).getKata(TDenyut));
        TKualitas_dtk.setDocument(new batasInput((byte)5).getKata(TKualitas_dtk));
        TKualitas_mnt.setDocument(new batasInput((byte)5).getKata(TKualitas_mnt));
        TVulva.setDocument(new batasInput((byte)50).getKata(TVulva));
        TPortio.setDocument(new batasInput((byte)50).getKata(TPortio));
        TTebal.setDocument(new batasInput((byte)5).getKata(TTebal));
        TPembukaan.setDocument(new batasInput((byte)50).getKata(TPembukaan));
        TPenurunan.setDocument(new batasInput((byte)50).getKata(TPenurunan));
        TDenominator.setDocument(new batasInput((byte)50).getKata(TDenominator));
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
        Catatan.setDocument(new batasInput((int)700).getKata(Catatan));
        
        panelDiagnosa1.TabRawat.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LCount.setText(panelDiagnosa1.getRecord()+"");
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
        panelDiagnosa1.tbDiagnosaPasien.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {
                if(panelDiagnosa1.tbDiagnosaPasien.getSelectedRow()!= -1){
                    TNoRw.setText(panelDiagnosa1.tbDiagnosaPasien.getValueAt(panelDiagnosa1.tbDiagnosaPasien.getSelectedRow(),2).toString());
                    TNoRM.setText(panelDiagnosa1.tbDiagnosaPasien.getValueAt(panelDiagnosa1.tbDiagnosaPasien.getSelectedRow(),3).toString());
                    TPasien.setText(panelDiagnosa1.tbDiagnosaPasien.getValueAt(panelDiagnosa1.tbDiagnosaPasien.getSelectedRow(),4).toString());
                } 
            }
        });
        
        panelDiagnosa1.tbDiagnosaPasien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(panelDiagnosa1.tbDiagnosaPasien.getSelectedRow()!= -1){
                    TNoRw.setText(panelDiagnosa1.tbDiagnosaPasien.getValueAt(panelDiagnosa1.tbDiagnosaPasien.getSelectedRow(),2).toString());
                    TNoRM.setText(panelDiagnosa1.tbDiagnosaPasien.getValueAt(panelDiagnosa1.tbDiagnosaPasien.getSelectedRow(),3).toString());
                    TPasien.setText(panelDiagnosa1.tbDiagnosaPasien.getValueAt(panelDiagnosa1.tbDiagnosaPasien.getSelectedRow(),4).toString());
                }                
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
        panelDiagnosa1.tbTindakanPasien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(panelDiagnosa1.tbTindakanPasien.getSelectedRow()!= -1){
                    TNoRw.setText(panelDiagnosa1.tbTindakanPasien.getValueAt(panelDiagnosa1.tbTindakanPasien.getSelectedRow(),2).toString());
                    TNoRM.setText(panelDiagnosa1.tbTindakanPasien.getValueAt(panelDiagnosa1.tbTindakanPasien.getSelectedRow(),3).toString());
                    TPasien.setText(panelDiagnosa1.tbTindakanPasien.getValueAt(panelDiagnosa1.tbTindakanPasien.getSelectedRow(),4).toString());
                }                
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
        panelDiagnosa1.tbTindakanPasien.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {
                if(panelDiagnosa1.tbTindakanPasien.getSelectedRow()!= -1){
                    TNoRw.setText(panelDiagnosa1.tbTindakanPasien.getValueAt(panelDiagnosa1.tbTindakanPasien.getSelectedRow(),2).toString());
                    TNoRM.setText(panelDiagnosa1.tbTindakanPasien.getValueAt(panelDiagnosa1.tbTindakanPasien.getSelectedRow(),3).toString());
                    TPasien.setText(panelDiagnosa1.tbTindakanPasien.getValueAt(panelDiagnosa1.tbTindakanPasien.getSelectedRow(),4).toString());
                } 
            }
        });
        
        ChkInput.setSelected(false);
        isForm(); 
        ChkInput1.setSelected(false);
        isForm2(); 
        ChkInput2.setSelected(false);
        isForm3(); 
        ChkInput3.setSelected(false);
        isForm4();
        ChkAccor.setSelected(true);
        isMenu(); 
        jam();
        
        if(kodebpjs.getKodeBPJS().equals("")){
            kodebpjs.SetKodeBPJS();
        }
        
        if(tarifralan.getCaraBayarRalan().equals("")){
            tarifralan.SetTarifRalan();
        }
        
        try {
            aktifkanparsial=koneksiDB.AKTIFKANBILLINGPARSIAL();
        } catch (Exception ex) {            
            aktifkanparsial="no";
        }
        
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
        panelGlass9 = new widget.panelisi();
        jLabel19 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel21 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        jLabel24 = new widget.Label();
        TCariPasien = new widget.TextBox();
        btnPasien = new widget.Button();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        BtnTambahTindakan = new widget.Button();
        TabRawat = new widget.TabPane();
        internalFrame2 = new widget.InternalFrame();
        panelGlass7 = new widget.panelisi();
        jLabel5 = new widget.Label();
        KdDok = new widget.TextBox();
        BtnSeekDokter = new widget.Button();
        TDokter = new widget.TextBox();
        TabRawatTindakanDokter = new widget.TabPane();
        Scroll6 = new widget.ScrollPane();
        tbTindakan = new widget.Table();
        Scroll = new widget.ScrollPane();
        tbRawatDr = new widget.Table();
        internalFrame3 = new widget.InternalFrame();
        panelGlass10 = new widget.panelisi();
        jLabel13 = new widget.Label();
        kdptg = new widget.TextBox();
        BtnSeekPetugas = new widget.Button();
        TPerawat = new widget.TextBox();
        TabRawatTindakanPetugas = new widget.TabPane();
        Scroll7 = new widget.ScrollPane();
        tbTindakan2 = new widget.Table();
        Scroll8 = new widget.ScrollPane();
        tbRawatPr = new widget.Table();
        internalFrame4 = new widget.InternalFrame();
        panelGlass11 = new widget.panelisi();
        jLabel14 = new widget.Label();
        kdptg2 = new widget.TextBox();
        BtnSeekPetugas2 = new widget.Button();
        TPerawat2 = new widget.TextBox();
        jLabel12 = new widget.Label();
        KdDok2 = new widget.TextBox();
        TDokter2 = new widget.TextBox();
        BtnSeekDokter2 = new widget.Button();
        TabRawatTindakanDokterPetugas = new widget.TabPane();
        Scroll9 = new widget.ScrollPane();
        tbTindakan3 = new widget.Table();
        Scroll10 = new widget.ScrollPane();
        tbRawatDrPr = new widget.Table();
        internalFrame5 = new widget.InternalFrame();
        Scroll3 = new widget.ScrollPane();
        tbPemeriksaan = new widget.Table();
        PanelInput = new javax.swing.JPanel();
        ChkInput = new widget.CekBox();
        panelGlass12 = new widget.panelisi();
        jLabel8 = new widget.Label();
        jLabel7 = new widget.Label();
        jLabel4 = new widget.Label();
        jLabel16 = new widget.Label();
        jLabel18 = new widget.Label();
        jLabel25 = new widget.Label();
        jLabel17 = new widget.Label();
        jLabel9 = new widget.Label();
        jLabel15 = new widget.Label();
        jLabel20 = new widget.Label();
        jLabel22 = new widget.Label();
        scrollPane1 = new widget.ScrollPane();
        TKeluhan = new widget.TextArea();
        jLabel28 = new widget.Label();
        jLabel26 = new widget.Label();
        scrollPane2 = new widget.ScrollPane();
        TPemeriksaan = new widget.TextArea();
        TSuhu = new widget.TextBox();
        TTensi = new widget.TextBox();
        TTinggi = new widget.TextBox();
        TRespirasi = new widget.TextBox();
        TBerat = new widget.TextBox();
        TNadi = new widget.TextBox();
        TGCS = new widget.TextBox();
        TAlergi = new widget.TextBox();
        scrollPane3 = new widget.ScrollPane();
        TPenilaian = new widget.TextArea();
        scrollPane6 = new widget.ScrollPane();
        TindakLanjut = new widget.TextArea();
        jLabel29 = new widget.Label();
        cmbKesadaran = new widget.ComboBox();
        jLabel37 = new widget.Label();
        KdPeg = new widget.TextBox();
        TPegawai = new widget.TextBox();
        BtnSeekPegawai = new widget.Button();
        Jabatan = new widget.TextBox();
        jLabel41 = new widget.Label();
        jLabel53 = new widget.Label();
        scrollPane7 = new widget.ScrollPane();
        TInstruksi = new widget.TextArea();
        jLabel54 = new widget.Label();
        SpO2 = new widget.TextBox();
        jLabel56 = new widget.Label();
        scrollPane8 = new widget.ScrollPane();
        TEvaluasi = new widget.TextArea();
        LingkarPerut = new widget.TextBox();
        Btn5Soap = new widget.Button();
        BtnTemplatePemeriksaan = new widget.Button();
        internalFrame6 = new widget.InternalFrame();
        Scroll4 = new widget.ScrollPane();
        tbPemeriksaanObstetri = new widget.Table();
        PanelInput1 = new javax.swing.JPanel();
        ChkInput1 = new widget.CekBox();
        panelGlass13 = new widget.panelisi();
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
        PanelInput2 = new javax.swing.JPanel();
        ChkInput2 = new widget.CekBox();
        panelGlass14 = new widget.panelisi();
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
        panelDiagnosa1 = new laporan.PanelDiagnosa();
        internalFrame8 = new widget.InternalFrame();
        PanelInput3 = new javax.swing.JPanel();
        ChkInput3 = new widget.CekBox();
        panelGlass15 = new widget.panelisi();
        jLabel55 = new widget.Label();
        scrollPane4 = new widget.ScrollPane();
        Catatan = new widget.TextArea();
        jLabel11 = new widget.Label();
        KdDok3 = new widget.TextBox();
        TDokter3 = new widget.TextBox();
        BtnSeekDokter3 = new widget.Button();
        Scroll11 = new widget.ScrollPane();
        tbCatatan = new widget.Table();
        FormInput = new widget.PanelBiasa();
        jLabel3 = new widget.Label();
        TNoRw = new widget.TextBox();
        TNoRM = new widget.TextBox();
        TPasien = new widget.TextBox();
        jLabel23 = new widget.Label();
        DTPTgl = new widget.Tanggal();
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
        BtnResepLuar = new widget.Button();
        BtnInputObat = new widget.Button();
        BtnObatBhp = new widget.Button();
        BtnBerkasDigital = new widget.Button();
        BtnPermintaanLab = new widget.Button();
        BtnPermintaanRad = new widget.Button();
        BtnJadwalOperasi = new widget.Button();
        BtnSKDP = new widget.Button();
        BtnKamar = new widget.Button();
        BtnTriaseIGD = new widget.Button();
        BtnRujukInternal = new widget.Button();
        BtnResume = new widget.Button();
        BtnAwalKeperawatanIGD = new widget.Button();
        BtnAwalKeperawatan = new widget.Button();
        BtnAwalKeperawatanGigi = new widget.Button();
        BtnAwalKeperawatanKandungan = new widget.Button();
        BtnAwalKeperawatanAnak = new widget.Button();
        BtnAwalKeperawatanPsikiatri = new widget.Button();
        BtnAwalKeperawatanGeriatri = new widget.Button();
        BtnAwalFisioterapi = new widget.Button();
        BtnAwalTerapiWicara = new widget.Button();
        BtnAwalMedisIGD = new widget.Button();
        BtnAwalMedisIGDPsikiatri = new widget.Button();
        BtnAwalMedis = new widget.Button();
        BtnAwalMedisKandungan = new widget.Button();
        BtnAwalMedisAnak = new widget.Button();
        BtnAwalMedisTHT = new widget.Button();
        BtnAwalMedisPsikiatri = new widget.Button();
        BtnAwalMedisPenyakitDalam = new widget.Button();
        BtnAwalMedisMata = new widget.Button();
        BtnAwalMedisNeurologi = new widget.Button();
        BtnAwalMedisOrthopedi = new widget.Button();
        BtnAwalMedisBedah = new widget.Button();
        BtnAwalMedisBedahMulut = new widget.Button();
        BtnAwalMedisGeriatri = new widget.Button();
        BtnAwalMedisKulitKelamin = new widget.Button();
        BtnAwalMedisParu = new widget.Button();
        BtnAwalMedisRehabMedik = new widget.Button();
        BtnAwalMedisHemodialisa = new widget.Button();
        BtnRujukKeluar = new widget.Button();
        BtnCatatan = new widget.Button();
        BtnCatatanObservasiIGD = new widget.Button();
        BtnCatatanCekGDS = new widget.Button();
        BtnCatatanKeperawatan = new widget.Button();
        BtnPenilaianUlangNyeri = new widget.Button();
        BtnPemantauanPEWSAnak = new widget.Button();
        BtnPemantauanPEWSDewasa = new widget.Button();
        BtnPemantauanMEOWS = new widget.Button();
        BtnPemantauanEWSNeonatus = new widget.Button();
        BtnMonitoringReaksiTranfusi = new widget.Button();
        BtnUjiFungsiKFR = new widget.Button();
        BtnChecklistKriteriaMasukHCU = new widget.Button();
        BtnChecklistKriteriaMasukICU = new widget.Button();
        BtnChecklistPreOperasi = new widget.Button();
        BtnSignInSebelumAnestesi = new widget.Button();
        BtnTimeOutSebelumInsisi = new widget.Button();
        BtnSignOutSebelumMenutupLuka = new widget.Button();
        BtnChecklistPostOperasi = new widget.Button();
        BtnPenilaianPreOperasi = new widget.Button();
        BtnPenilaianPreAnestesi = new widget.Button();
        BtnSkorAldrettePascaAnestesi = new widget.Button();
        BtnSkorStewardPascaAnestesi = new widget.Button();
        BtnMedicalCheckUp = new widget.Button();
        BtnPenilaianLanjutanRisikoJatuhDewasa = new widget.Button();
        BtnPenilaianLanjutanRisikoJatuhAnak = new widget.Button();
        BtnPenilaianLanjutanRisikoJatuhLansia = new widget.Button();
        BtnPenilaianLanjutanRisikoJatuhNeonatus = new widget.Button();
        BtnPenilaianLanjutanRisikoJatuhGeriatri = new widget.Button();
        BtnPenilaianLanjutanRisikoJatuhPsikiatri = new widget.Button();
        BtnPenilaianLanjutanSkriningFungsional = new widget.Button();
        BtnHasilPemeriksaanUSG = new widget.Button();
        BtnDokumentasiESWL = new widget.Button();
        BtnCatatanPersalinanan = new widget.Button();
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
        BtnEdukasiPasienKeluarga = new widget.Button();
        BtnPengkajianRestrain = new widget.Button();
        BtnPenilaianPasienTerminal = new widget.Button();
        BtnPenilaianKorbanKekerasan = new widget.Button();
        BtnPenilaianPasienPenyakitMenular = new widget.Button();
        BtnPenilaianPasienKeracunan = new widget.Button();
        BtnPenilaianTambahanGeriatri = new widget.Button();
        BtnPenilaianTambahanBunuhDiri = new widget.Button();
        BtnPenilaianTambahanPerilakuKekerasan = new widget.Button();
        BtnPenilaianTambahanMelarikanDiri = new widget.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Perawatan/Tindakan Rawat Jalan ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); 
        internalFrame1.setName("internalFrame1"); 
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        jPanel3.setName("jPanel3"); 
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 100));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); 
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); 
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Simpan");
        BtnSimpan.setToolTipText("Alt+S");
        BtnSimpan.setName("BtnSimpan"); 
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

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); 
        BtnBatal.setMnemonic('B');
        BtnBatal.setText("Baru");
        BtnBatal.setToolTipText("Alt+B");
        BtnBatal.setName("BtnBatal"); 
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

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); 
        BtnHapus.setMnemonic('H');
        BtnHapus.setText("Hapus");
        BtnHapus.setToolTipText("Alt+H");
        BtnHapus.setName("BtnHapus"); 
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

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); 
        BtnEdit.setMnemonic('G');
        BtnEdit.setText("Ganti");
        BtnEdit.setToolTipText("Alt+G");
        BtnEdit.setName("BtnEdit"); 
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

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); 
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); 
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

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); 
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); 
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
        jLabel10.setName("jLabel10"); 
        jLabel10.setPreferredSize(new java.awt.Dimension(95, 30));
        panelGlass8.add(jLabel10);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); 
        LCount.setPreferredSize(new java.awt.Dimension(87, 30));
        panelGlass8.add(LCount);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); 
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); 
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

        panelGlass9.setName("panelGlass9"); 
        panelGlass9.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel19.setText("Tgl.Rawat :");
        jLabel19.setName("jLabel19"); 
        jLabel19.setPreferredSize(new java.awt.Dimension(64, 23));
        panelGlass9.add(jLabel19);

        DTPCari1.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "18-12-2023" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy");
        DTPCari1.setName("DTPCari1"); 
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(95, 23));
        panelGlass9.add(DTPCari1);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("s.d.");
        jLabel21.setName("jLabel21"); 
        jLabel21.setPreferredSize(new java.awt.Dimension(23, 23));
        panelGlass9.add(jLabel21);

        DTPCari2.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "18-12-2023" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); 
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(95, 23));
        panelGlass9.add(DTPCari2);

        jLabel24.setText("No.RM :");
        jLabel24.setName("jLabel24"); 
        jLabel24.setPreferredSize(new java.awt.Dimension(55, 23));
        panelGlass9.add(jLabel24);

        TCariPasien.setName("TCariPasien"); 
        TCariPasien.setPreferredSize(new java.awt.Dimension(140, 23));
        panelGlass9.add(TCariPasien);

        btnPasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); 
        btnPasien.setMnemonic('6');
        btnPasien.setToolTipText("Alt+6");
        btnPasien.setName("btnPasien"); 
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
        panelGlass9.add(btnPasien);

        jSeparator5.setBackground(new java.awt.Color(220, 225, 215));
        jSeparator5.setForeground(new java.awt.Color(220, 225, 215));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setName("jSeparator5"); 
        jSeparator5.setOpaque(true);
        jSeparator5.setPreferredSize(new java.awt.Dimension(1, 23));
        panelGlass9.add(jSeparator5);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); 
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel6);

        TCari.setName("TCari"); 
        TCari.setPreferredSize(new java.awt.Dimension(240, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass9.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); 
        BtnCari.setMnemonic('6');
        BtnCari.setToolTipText("Alt+6");
        BtnCari.setName("BtnCari"); 
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
        panelGlass9.add(BtnCari);

        BtnTambahTindakan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/plus_16.png"))); 
        BtnTambahTindakan.setMnemonic('3');
        BtnTambahTindakan.setToolTipText("Alt+3");
        BtnTambahTindakan.setName("BtnTambahTindakan"); 
        BtnTambahTindakan.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnTambahTindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahTindakanActionPerformed(evt);
            }
        });
        panelGlass9.add(BtnTambahTindakan);

        jPanel3.add(panelGlass9, java.awt.BorderLayout.PAGE_START);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        TabRawat.setBackground(new java.awt.Color(255, 255, 253));
        TabRawat.setForeground(new java.awt.Color(50, 50, 50));
        TabRawat.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        TabRawat.setName("TabRawat"); 
        TabRawat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabRawatMouseClicked(evt);
            }
        });

        internalFrame2.setBorder(null);
        internalFrame2.setForeground(new java.awt.Color(50, 50, 50));
        internalFrame2.setName("internalFrame2"); 
        internalFrame2.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass7.setBorder(null);
        panelGlass7.setName("panelGlass7"); 
        panelGlass7.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass7.setLayout(null);

        jLabel5.setText("Dokter :");
        jLabel5.setName("jLabel5"); 
        panelGlass7.add(jLabel5);
        jLabel5.setBounds(0, 10, 55, 23);

        KdDok.setHighlighter(null);
        KdDok.setName("KdDok"); 
        KdDok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdDokKeyPressed(evt);
            }
        });
        panelGlass7.add(KdDok);
        KdDok.setBounds(58, 10, 146, 23);

        BtnSeekDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); 
        BtnSeekDokter.setMnemonic('4');
        BtnSeekDokter.setToolTipText("ALt+4");
        BtnSeekDokter.setName("BtnSeekDokter"); 
        BtnSeekDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeekDokterActionPerformed(evt);
            }
        });
        panelGlass7.add(BtnSeekDokter);
        BtnSeekDokter.setBounds(749, 10, 28, 23);

        TDokter.setEditable(false);
        TDokter.setHighlighter(null);
        TDokter.setName("TDokter"); 
        panelGlass7.add(TDokter);
        TDokter.setBounds(206, 10, 540, 23);

        internalFrame2.add(panelGlass7, java.awt.BorderLayout.PAGE_START);

        TabRawatTindakanDokter.setBackground(new java.awt.Color(255, 255, 253));
        TabRawatTindakanDokter.setForeground(new java.awt.Color(50, 50, 50));
        TabRawatTindakanDokter.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        TabRawatTindakanDokter.setName("TabRawatTindakanDokter"); 
        TabRawatTindakanDokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabRawatTindakanDokterMouseClicked(evt);
            }
        });

        Scroll6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Scroll6.setName("Scroll6"); 
        Scroll6.setOpaque(true);

        tbTindakan.setToolTipText("");
        tbTindakan.setName("tbTindakan"); 
        tbTindakan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbTindakanKeyPressed(evt);
            }
        });
        Scroll6.setViewportView(tbTindakan);

        TabRawatTindakanDokter.addTab("Daftar Tindakan/Tagihan", Scroll6);

        Scroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Scroll.setName("Scroll"); 
        Scroll.setOpaque(true);

        tbRawatDr.setName("tbRawatDr"); 
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

        TabRawatTindakanDokter.addTab("Tindakan Dilakukan", Scroll);

        internalFrame2.add(TabRawatTindakanDokter, java.awt.BorderLayout.CENTER);

        TabRawat.addTab("Penanganan Dokter", internalFrame2);

        internalFrame3.setBorder(null);
        internalFrame3.setName("internalFrame3"); 
        internalFrame3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass10.setBorder(null);
        panelGlass10.setName("panelGlass10"); 
        panelGlass10.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass10.setLayout(null);

        jLabel13.setText("Petugas :");
        jLabel13.setName("jLabel13"); 
        panelGlass10.add(jLabel13);
        jLabel13.setBounds(0, 10, 63, 23);

        kdptg.setHighlighter(null);
        kdptg.setName("kdptg"); 
        kdptg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdptgKeyPressed(evt);
            }
        });
        panelGlass10.add(kdptg);
        kdptg.setBounds(66, 10, 146, 23);

        BtnSeekPetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); 
        BtnSeekPetugas.setMnemonic('5');
        BtnSeekPetugas.setToolTipText("ALt+5");
        BtnSeekPetugas.setName("BtnSeekPetugas"); 
        BtnSeekPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeekPetugasActionPerformed(evt);
            }
        });
        panelGlass10.add(BtnSeekPetugas);
        BtnSeekPetugas.setBounds(749, 10, 28, 23);

        TPerawat.setEditable(false);
        TPerawat.setBackground(new java.awt.Color(202, 202, 202));
        TPerawat.setHighlighter(null);
        TPerawat.setName("TPerawat"); 
        panelGlass10.add(TPerawat);
        TPerawat.setBounds(214, 10, 532, 23);

        internalFrame3.add(panelGlass10, java.awt.BorderLayout.PAGE_START);

        TabRawatTindakanPetugas.setBackground(new java.awt.Color(255, 255, 253));
        TabRawatTindakanPetugas.setForeground(new java.awt.Color(50, 50, 50));
        TabRawatTindakanPetugas.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        TabRawatTindakanPetugas.setName("TabRawatTindakanPetugas"); 
        TabRawatTindakanPetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabRawatTindakanPetugasMouseClicked(evt);
            }
        });

        Scroll7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Scroll7.setName("Scroll7"); 
        Scroll7.setOpaque(true);

        tbTindakan2.setToolTipText("");
        tbTindakan2.setName("tbTindakan2"); 
        tbTindakan2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbTindakan2KeyPressed(evt);
            }
        });
        Scroll7.setViewportView(tbTindakan2);

        TabRawatTindakanPetugas.addTab("Daftar Tindakan/Tagihan", Scroll7);

        Scroll8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Scroll8.setName("Scroll8"); 
        Scroll8.setOpaque(true);

        tbRawatPr.setName("tbRawatPr"); 
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
        Scroll8.setViewportView(tbRawatPr);

        TabRawatTindakanPetugas.addTab("Tindakan Dilakukan", Scroll8);

        internalFrame3.add(TabRawatTindakanPetugas, java.awt.BorderLayout.CENTER);

        TabRawat.addTab("Penanganan Petugas", internalFrame3);

        internalFrame4.setBorder(null);
        internalFrame4.setName("internalFrame4"); 
        internalFrame4.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass11.setBorder(null);
        panelGlass11.setName("panelGlass11"); 
        panelGlass11.setPreferredSize(new java.awt.Dimension(44, 74));
        panelGlass11.setLayout(null);

        jLabel14.setText("Petugas :");
        jLabel14.setName("jLabel14"); 
        panelGlass11.add(jLabel14);
        jLabel14.setBounds(0, 40, 65, 23);

        kdptg2.setHighlighter(null);
        kdptg2.setName("kdptg2"); 
        kdptg2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdptg2KeyPressed(evt);
            }
        });
        panelGlass11.add(kdptg2);
        kdptg2.setBounds(68, 40, 130, 23);

        BtnSeekPetugas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); 
        BtnSeekPetugas2.setMnemonic('5');
        BtnSeekPetugas2.setToolTipText("ALt+5");
        BtnSeekPetugas2.setName("BtnSeekPetugas2"); 
        BtnSeekPetugas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeekPetugas2ActionPerformed(evt);
            }
        });
        panelGlass11.add(BtnSeekPetugas2);
        BtnSeekPetugas2.setBounds(749, 40, 28, 23);

        TPerawat2.setEditable(false);
        TPerawat2.setBackground(new java.awt.Color(202, 202, 202));
        TPerawat2.setHighlighter(null);
        TPerawat2.setName("TPerawat2"); 
        panelGlass11.add(TPerawat2);
        TPerawat2.setBounds(200, 40, 546, 23);

        jLabel12.setText("Dokter :");
        jLabel12.setName("jLabel12"); 
        panelGlass11.add(jLabel12);
        jLabel12.setBounds(0, 10, 65, 23);

        KdDok2.setHighlighter(null);
        KdDok2.setName("KdDok2"); 
        KdDok2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdDok2KeyPressed(evt);
            }
        });
        panelGlass11.add(KdDok2);
        KdDok2.setBounds(68, 10, 130, 23);

        TDokter2.setEditable(false);
        TDokter2.setHighlighter(null);
        TDokter2.setName("TDokter2"); 
        panelGlass11.add(TDokter2);
        TDokter2.setBounds(200, 10, 546, 23);

        BtnSeekDokter2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); 
        BtnSeekDokter2.setMnemonic('4');
        BtnSeekDokter2.setToolTipText("ALt+4");
        BtnSeekDokter2.setName("BtnSeekDokter2"); 
        BtnSeekDokter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeekDokter2ActionPerformed(evt);
            }
        });
        panelGlass11.add(BtnSeekDokter2);
        BtnSeekDokter2.setBounds(749, 10, 28, 23);

        internalFrame4.add(panelGlass11, java.awt.BorderLayout.PAGE_START);

        TabRawatTindakanDokterPetugas.setBackground(new java.awt.Color(255, 255, 253));
        TabRawatTindakanDokterPetugas.setForeground(new java.awt.Color(50, 50, 50));
        TabRawatTindakanDokterPetugas.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        TabRawatTindakanDokterPetugas.setName("TabRawatTindakanDokterPetugas"); 
        TabRawatTindakanDokterPetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabRawatTindakanDokterPetugasMouseClicked(evt);
            }
        });

        Scroll9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Scroll9.setName("Scroll9"); 
        Scroll9.setOpaque(true);

        tbTindakan3.setToolTipText("");
        tbTindakan3.setName("tbTindakan3"); 
        tbTindakan3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbTindakan3KeyPressed(evt);
            }
        });
        Scroll9.setViewportView(tbTindakan3);

        TabRawatTindakanDokterPetugas.addTab("Daftar Tindakan/Tagihan", Scroll9);

        Scroll10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Scroll10.setName("Scroll10"); 
        Scroll10.setOpaque(true);

        tbRawatDrPr.setName("tbRawatDrPr"); 
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
        Scroll10.setViewportView(tbRawatDrPr);

        TabRawatTindakanDokterPetugas.addTab("Tindakan Dilakukan", Scroll10);

        internalFrame4.add(TabRawatTindakanDokterPetugas, java.awt.BorderLayout.CENTER);

        TabRawat.addTab("Penanganan Dokter & Petugas", internalFrame4);

        internalFrame5.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame5.setName("internalFrame5"); 
        internalFrame5.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll3.setName("Scroll3"); 
        Scroll3.setOpaque(true);

        tbPemeriksaan.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbPemeriksaan.setName("tbPemeriksaan"); 
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

        PanelInput.setName("PanelInput"); 
        PanelInput.setOpaque(false);
        PanelInput.setPreferredSize(new java.awt.Dimension(192, 273));
        PanelInput.setLayout(new java.awt.BorderLayout(1, 1));

        ChkInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); 
        ChkInput.setMnemonic('I');
        ChkInput.setText(".: Input Data");
        ChkInput.setToolTipText("Alt+I");
        ChkInput.setBorderPainted(true);
        ChkInput.setBorderPaintedFlat(true);
        ChkInput.setFocusable(false);
        ChkInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChkInput.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput.setName("ChkInput"); 
        ChkInput.setPreferredSize(new java.awt.Dimension(192, 20));
        ChkInput.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); 
        ChkInput.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); 
        ChkInput.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); 
        ChkInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInputActionPerformed(evt);
            }
        });
        PanelInput.add(ChkInput, java.awt.BorderLayout.PAGE_END);

        panelGlass12.setName("panelGlass12"); 
        panelGlass12.setPreferredSize(new java.awt.Dimension(44, 134));
        panelGlass12.setLayout(null);

        jLabel8.setText("Subjek :");
        jLabel8.setName("jLabel8"); 
        panelGlass12.add(jLabel8);
        jLabel8.setBounds(0, 70, 70, 23);

        jLabel7.setText("Suhu (°C) :");
        jLabel7.setName("jLabel7"); 
        panelGlass12.add(jLabel7);
        jLabel7.setBounds(0, 160, 70, 23);

        jLabel4.setText("Tensi (mmHg) :");
        jLabel4.setName("jLabel4"); 
        panelGlass12.add(jLabel4);
        jLabel4.setBounds(130, 160, 90, 23);

        jLabel16.setText("Berat (Kg) :");
        jLabel16.setName("jLabel16"); 
        panelGlass12.add(jLabel16);
        jLabel16.setBounds(296, 160, 79, 23);

        jLabel18.setText("Nadi (/menit) :");
        jLabel18.setName("jLabel18"); 
        panelGlass12.add(jLabel18);
        jLabel18.setBounds(296, 190, 79, 23);

        jLabel25.setText("L.P. (Cm) :");
        jLabel25.setName("jLabel25"); 
        panelGlass12.add(jLabel25);
        jLabel25.setBounds(450, 10, 90, 23);

        jLabel17.setText("TB (Cm) :");
        jLabel17.setName("jLabel17"); 
        panelGlass12.add(jLabel17);
        jLabel17.setBounds(0, 190, 70, 23);

        jLabel9.setText("Objek :");
        jLabel9.setName("jLabel9"); 
        panelGlass12.add(jLabel9);
        jLabel9.setBounds(0, 115, 70, 23);

        jLabel15.setText("Alergi :");
        jLabel15.setName("jLabel15"); 
        panelGlass12.add(jLabel15);
        jLabel15.setBounds(624, 10, 70, 23);

        jLabel20.setText("RR (/menit) :");
        jLabel20.setName("jLabel20"); 
        panelGlass12.add(jLabel20);
        jLabel20.setBounds(130, 190, 90, 23);

        jLabel22.setText("GCS (E,V,M) :");
        jLabel22.setName("jLabel22"); 
        panelGlass12.add(jLabel22);
        jLabel22.setBounds(120, 220, 70, 23);

        scrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane1.setName("scrollPane1"); 

        TKeluhan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TKeluhan.setColumns(20);
        TKeluhan.setRows(5);
        TKeluhan.setName("TKeluhan"); 
        TKeluhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TKeluhanKeyPressed(evt);
            }
        });
        scrollPane1.setViewportView(TKeluhan);

        panelGlass12.add(scrollPane1);
        scrollPane1.setBounds(73, 70, 360, 38);

        jLabel28.setText("Asesmen :");
        jLabel28.setName("jLabel28"); 
        panelGlass12.add(jLabel28);
        jLabel28.setBounds(450, 40, 90, 23);

        jLabel26.setText("Plan :");
        jLabel26.setName("jLabel26"); 
        panelGlass12.add(jLabel26);
        jLabel26.setBounds(450, 85, 90, 23);

        scrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane2.setName("scrollPane2"); 

        TPemeriksaan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TPemeriksaan.setColumns(20);
        TPemeriksaan.setRows(5);
        TPemeriksaan.setName("TPemeriksaan"); 
        TPemeriksaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TPemeriksaanKeyPressed(evt);
            }
        });
        scrollPane2.setViewportView(TPemeriksaan);

        panelGlass12.add(scrollPane2);
        scrollPane2.setBounds(73, 115, 360, 38);

        TSuhu.setFocusTraversalPolicyProvider(true);
        TSuhu.setName("TSuhu"); 
        TSuhu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TSuhuKeyPressed(evt);
            }
        });
        panelGlass12.add(TSuhu);
        TSuhu.setBounds(73, 160, 55, 23);

        TTensi.setHighlighter(null);
        TTensi.setName("TTensi"); 
        TTensi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TTensiKeyPressed(evt);
            }
        });
        panelGlass12.add(TTensi);
        TTensi.setBounds(223, 160, 74, 23);

        TTinggi.setFocusTraversalPolicyProvider(true);
        TTinggi.setName("TTinggi"); 
        TTinggi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TTinggiKeyPressed(evt);
            }
        });
        panelGlass12.add(TTinggi);
        TTinggi.setBounds(73, 190, 55, 23);

        TRespirasi.setHighlighter(null);
        TRespirasi.setName("TRespirasi"…168051 tokens truncated…s().getResource("/picture/item.png"))); 
        BtnLayananKedokteranFisikRehabilitasi.setText("Kedokteran Fisik & Rehabilitasi");
        BtnLayananKedokteranFisikRehabilitasi.setFocusPainted(false);
        BtnLayananKedokteranFisikRehabilitasi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnLayananKedokteranFisikRehabilitasi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnLayananKedokteranFisikRehabilitasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnLayananKedokteranFisikRehabilitasi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnLayananKedokteranFisikRehabilitasi.setName("BtnLayananKedokteranFisikRehabilitasi"); 
        BtnLayananKedokteranFisikRehabilitasi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnLayananKedokteranFisikRehabilitasi.setRoundRect(false);
        BtnLayananKedokteranFisikRehabilitasi.addActionListener(this::BtnLayananKedokteranFisikRehabilitasiActionPerformed);
        
        BtnHasilEndoskopiFaringLaring = new widget.Button();
        BtnHasilEndoskopiFaringLaring.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png")));
        BtnHasilEndoskopiFaringLaring.setText("Hasil Endoskopi Faring/Laring");
        BtnHasilEndoskopiFaringLaring.setFocusPainted(false);
        BtnHasilEndoskopiFaringLaring.setFont(new java.awt.Font("Tahoma", 0, 11));
        BtnHasilEndoskopiFaringLaring.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnHasilEndoskopiFaringLaring.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnHasilEndoskopiFaringLaring.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnHasilEndoskopiFaringLaring.setName("BtnHasilEndoskopiFaringLaring");
        BtnHasilEndoskopiFaringLaring.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnHasilEndoskopiFaringLaring.setRoundRect(false);
        BtnHasilEndoskopiFaringLaring.addActionListener(this::BtnHasilEndoskopiFaringLaringActionPerformed);
        
        BtnHasilEndoskopiHidung = new widget.Button();
        BtnHasilEndoskopiHidung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png")));
        BtnHasilEndoskopiHidung.setText("Hasil Endoskopi Hidung");
        BtnHasilEndoskopiHidung.setFocusPainted(false);
        BtnHasilEndoskopiHidung.setFont(new java.awt.Font("Tahoma", 0, 11));
        BtnHasilEndoskopiHidung.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnHasilEndoskopiHidung.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnHasilEndoskopiHidung.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnHasilEndoskopiHidung.setName("BtnHasilEndoskopiHidung");
        BtnHasilEndoskopiHidung.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnHasilEndoskopiHidung.setRoundRect(false);
        BtnHasilEndoskopiHidung.addActionListener(this::BtnHasilEndoskopiHidungActionPerformed);
        
        BtnHasilEndoskopiTelinga = new widget.Button();
        BtnHasilEndoskopiTelinga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png")));
        BtnHasilEndoskopiTelinga.setText("Hasil Endoskopi Telinga");
        BtnHasilEndoskopiTelinga.setFocusPainted(false);
        BtnHasilEndoskopiTelinga.setFont(new java.awt.Font("Tahoma", 0, 11));
        BtnHasilEndoskopiTelinga.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnHasilEndoskopiTelinga.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnHasilEndoskopiTelinga.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnHasilEndoskopiTelinga.setName("BtnHasilEndoskopiTelinga");
        BtnHasilEndoskopiTelinga.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnHasilEndoskopiTelinga.setRoundRect(false);
        BtnHasilEndoskopiTelinga.addActionListener(this::BtnHasilEndoskopiTelingaActionPerformed);
        
        BtnPenilaianPasienImunitasRendah = new widget.Button();
        BtnPenilaianPasienImunitasRendah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnPenilaianPasienImunitasRendah.setText("Pasien Imunitas Rendah");
        BtnPenilaianPasienImunitasRendah.setFocusPainted(false);
        BtnPenilaianPasienImunitasRendah.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnPenilaianPasienImunitasRendah.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnPenilaianPasienImunitasRendah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnPenilaianPasienImunitasRendah.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnPenilaianPasienImunitasRendah.setName("BtnPenilaianPasienImunitasRendah"); 
        BtnPenilaianPasienImunitasRendah.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnPenilaianPasienImunitasRendah.setRoundRect(false);
        BtnPenilaianPasienImunitasRendah.addActionListener(this::BtnPenilaianPasienImunitasRendahActionPerformed);
        
        BtnCatatanKeseimbanganCairan = new widget.Button();
        BtnCatatanKeseimbanganCairan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnCatatanKeseimbanganCairan.setText("Keseimbangan Cairan");
        BtnCatatanKeseimbanganCairan.setFocusPainted(false);
        BtnCatatanKeseimbanganCairan.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnCatatanKeseimbanganCairan.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnCatatanKeseimbanganCairan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnCatatanKeseimbanganCairan.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnCatatanKeseimbanganCairan.setName("BtnCatatanKeseimbanganCairan"); 
        BtnCatatanKeseimbanganCairan.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnCatatanKeseimbanganCairan.setRoundRect(false);
        BtnCatatanKeseimbanganCairan.addActionListener(this::BtnCatatanKeseimbanganCairanActionPerformed);
        
        BtnCatatanObservasiCHBP = new widget.Button();
        BtnCatatanObservasiCHBP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnCatatanObservasiCHBP.setText("Observasi CHBP");
        BtnCatatanObservasiCHBP.setFocusPainted(false);
        BtnCatatanObservasiCHBP.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnCatatanObservasiCHBP.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnCatatanObservasiCHBP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnCatatanObservasiCHBP.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnCatatanObservasiCHBP.setName("BtnCatatanObservasiCHBP"); 
        BtnCatatanObservasiCHBP.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnCatatanObservasiCHBP.setRoundRect(false);
        BtnCatatanObservasiCHBP.addActionListener(this::BtnCatatanObservasiCHBPActionPerformed);
        
        BtnCatatanObservasiInduksiPersalinan = new widget.Button();
        BtnCatatanObservasiInduksiPersalinan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnCatatanObservasiInduksiPersalinan.setText("Observasi Induksi Persalinan");
        BtnCatatanObservasiInduksiPersalinan.setFocusPainted(false);
        BtnCatatanObservasiInduksiPersalinan.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnCatatanObservasiInduksiPersalinan.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnCatatanObservasiInduksiPersalinan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnCatatanObservasiInduksiPersalinan.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnCatatanObservasiInduksiPersalinan.setName("BtnCatatanObservasiInduksiPersalinan"); 
        BtnCatatanObservasiInduksiPersalinan.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnCatatanObservasiInduksiPersalinan.setRoundRect(false);
        BtnCatatanObservasiInduksiPersalinan.addActionListener(this::BtnCatatanObservasiInduksiPersalinanActionPerformed);
        
        BtnCatatanObservasiHemodialisa = new widget.Button();
        BtnCatatanObservasiHemodialisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnCatatanObservasiHemodialisa.setText("Observasi Hemodialisa");
        BtnCatatanObservasiHemodialisa.setFocusPainted(false);
        BtnCatatanObservasiHemodialisa.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnCatatanObservasiHemodialisa.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnCatatanObservasiHemodialisa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnCatatanObservasiHemodialisa.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnCatatanObservasiHemodialisa.setName("BtnCatatanObservasiHemodialisa"); 
        BtnCatatanObservasiHemodialisa.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnCatatanObservasiHemodialisa.setRoundRect(false);
        BtnCatatanObservasiHemodialisa.addActionListener(this::BtnCatatanObservasiHemodialisaActionPerformed);
        
        BtnCatatanObservasiRuangOperasi = new widget.Button();
        BtnCatatanObservasiRuangOperasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnCatatanObservasiRuangOperasi.setText("Observasi Ruang Operasi");
        BtnCatatanObservasiRuangOperasi.setFocusPainted(false);
        BtnCatatanObservasiRuangOperasi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnCatatanObservasiRuangOperasi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnCatatanObservasiRuangOperasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnCatatanObservasiRuangOperasi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnCatatanObservasiRuangOperasi.setName("BtnCatatanObservasiRuangOperasi"); 
        BtnCatatanObservasiRuangOperasi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnCatatanObservasiRuangOperasi.setRoundRect(false);
        BtnCatatanObservasiRuangOperasi.addActionListener(this::BtnCatatanObservasiRuangOperasiActionPerformed);
        
        BtnCatatanCairanHemodialisa = new widget.Button();
        BtnCatatanCairanHemodialisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnCatatanCairanHemodialisa.setText("Cairan Hemodialisa");
        BtnCatatanCairanHemodialisa.setFocusPainted(false);
        BtnCatatanCairanHemodialisa.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnCatatanCairanHemodialisa.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnCatatanCairanHemodialisa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnCatatanCairanHemodialisa.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnCatatanCairanHemodialisa.setName("BtnCatatanCairanHemodialisa"); 
        BtnCatatanCairanHemodialisa.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnCatatanCairanHemodialisa.setRoundRect(false);
        BtnCatatanCairanHemodialisa.addActionListener(this::BtnCatatanCairanHemodialisaActionPerformed);
        
        BtnChecklistPemberianFibrinolitik = new widget.Button();
        BtnChecklistPemberianFibrinolitik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnChecklistPemberianFibrinolitik.setText("Check List Pemberian Fibrinoli");
        BtnChecklistPemberianFibrinolitik.setFocusPainted(false);
        BtnChecklistPemberianFibrinolitik.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnChecklistPemberianFibrinolitik.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnChecklistPemberianFibrinolitik.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnChecklistPemberianFibrinolitik.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnChecklistPemberianFibrinolitik.setName("BtnChecklistPemberianFibrinolitik"); 
        BtnChecklistPemberianFibrinolitik.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnChecklistPemberianFibrinolitik.setRoundRect(false);
        BtnChecklistPemberianFibrinolitik.addActionListener(this::BtnChecklistPemberianFibrinolitikActionPerformed);
        
        BtnPermintaanKonsultasiMedik = new widget.Button();
        BtnPermintaanKonsultasiMedik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnPermintaanKonsultasiMedik.setText("Konsultasi Medik");
        BtnPermintaanKonsultasiMedik.setFocusPainted(false);
        BtnPermintaanKonsultasiMedik.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnPermintaanKonsultasiMedik.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnPermintaanKonsultasiMedik.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnPermintaanKonsultasiMedik.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnPermintaanKonsultasiMedik.setName("BtnPermintaanKonsultasiMedik"); 
        BtnPermintaanKonsultasiMedik.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnPermintaanKonsultasiMedik.setRoundRect(false);
        BtnPermintaanKonsultasiMedik.addActionListener(this::BtnPermintaanKonsultasiMedikActionPerformed);
        
        BtnPermintaanKonsultasiPerawat = new widget.Button();
        BtnPermintaanKonsultasiPerawat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnPermintaanKonsultasiPerawat.setText("Konsultasi Perawat");
        BtnPermintaanKonsultasiPerawat.setFocusPainted(false);
        BtnPermintaanKonsultasiPerawat.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnPermintaanKonsultasiPerawat.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnPermintaanKonsultasiPerawat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnPermintaanKonsultasiPerawat.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnPermintaanKonsultasiPerawat.setName("BtnPermintaanKonsultasiPerawat"); 
        BtnPermintaanKonsultasiPerawat.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnPermintaanKonsultasiPerawat.setRoundRect(false);
        BtnPermintaanKonsultasiPerawat.addActionListener(this::BtnPermintaanKonsultasiPerawatActionPerformed);
        
        BtnSkriningMerokokUsiaRemaja = new widget.Button();
        BtnSkriningMerokokUsiaRemaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningMerokokUsiaRemaja.setText("Skrining Merokok Usia Remaja");
        BtnSkriningMerokokUsiaRemaja.setFocusPainted(false);
        BtnSkriningMerokokUsiaRemaja.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningMerokokUsiaRemaja.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningMerokokUsiaRemaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningMerokokUsiaRemaja.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningMerokokUsiaRemaja.setName("BtnSkriningMerokokUsiaRemaja"); 
        BtnSkriningMerokokUsiaRemaja.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningMerokokUsiaRemaja.setRoundRect(false);
        BtnSkriningMerokokUsiaRemaja.addActionListener(this::BtnSkriningMerokokUsiaRemajaActionPerformed);
        
        BtnSkriningKekerasanPadaWanita = new widget.Button();
        BtnSkriningKekerasanPadaWanita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningKekerasanPadaWanita.setText("Kekerasan Pada Perempuan");
        BtnSkriningKekerasanPadaWanita.setFocusPainted(false);
        BtnSkriningKekerasanPadaWanita.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningKekerasanPadaWanita.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningKekerasanPadaWanita.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningKekerasanPadaWanita.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningKekerasanPadaWanita.setName("BtnSkriningKekerasanPadaWanita"); 
        BtnSkriningKekerasanPadaWanita.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningKekerasanPadaWanita.setRoundRect(false);
        BtnSkriningKekerasanPadaWanita.addActionListener(this::BtnSkriningKekerasanPadaWanitaActionPerformed);
        
        BtnSkriningObesitas = new widget.Button();
        BtnSkriningObesitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningObesitas.setText("Skrining Obesitas");
        BtnSkriningObesitas.setFocusPainted(false);
        BtnSkriningObesitas.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningObesitas.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningObesitas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningObesitas.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningObesitas.setName("BtnSkriningObesitas"); 
        BtnSkriningObesitas.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningObesitas.setRoundRect(false);
        BtnSkriningObesitas.addActionListener(this::BtnSkriningObesitasActionPerformed);
        
        BtnSkriningRisikoKankerPayudara = new widget.Button();
        BtnSkriningRisikoKankerPayudara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningRisikoKankerPayudara.setText("Skrining Risiko Kanker Payudara");
        BtnSkriningRisikoKankerPayudara.setFocusPainted(false);
        BtnSkriningRisikoKankerPayudara.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningRisikoKankerPayudara.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningRisikoKankerPayudara.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningRisikoKankerPayudara.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningRisikoKankerPayudara.setName("BtnSkriningRisikoKankerPayudara"); 
        BtnSkriningRisikoKankerPayudara.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningRisikoKankerPayudara.setRoundRect(false);
        BtnSkriningRisikoKankerPayudara.addActionListener(this::BtnSkriningRisikoKankerPayudaraActionPerformed);
        
        BtnSkriningRisikoKankerParu = new widget.Button();
        BtnSkriningRisikoKankerParu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningRisikoKankerParu.setText("Skrining Risiko Kanker Paru");
        BtnSkriningRisikoKankerParu.setFocusPainted(false);
        BtnSkriningRisikoKankerParu.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningRisikoKankerParu.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningRisikoKankerParu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningRisikoKankerParu.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningRisikoKankerParu.setName("BtnSkriningRisikoKankerParu"); 
        BtnSkriningRisikoKankerParu.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningRisikoKankerParu.setRoundRect(false);
        BtnSkriningRisikoKankerParu.addActionListener(this::BtnSkriningRisikoKankerParuActionPerformed);
        
        BtnSkriningKesehatanGigiMulutremaja = new widget.Button();
        BtnSkriningKesehatanGigiMulutremaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningKesehatanGigiMulutremaja.setText("Skrining Gigi Mulut Remaja");
        BtnSkriningKesehatanGigiMulutremaja.setFocusPainted(false);
        BtnSkriningKesehatanGigiMulutremaja.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningKesehatanGigiMulutremaja.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningKesehatanGigiMulutremaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningKesehatanGigiMulutremaja.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningKesehatanGigiMulutremaja.setName("BtnSkriningKesehatanGigiMulutremaja"); 
        BtnSkriningKesehatanGigiMulutremaja.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningKesehatanGigiMulutremaja.setRoundRect(false);
        BtnSkriningKesehatanGigiMulutremaja.addActionListener(this::BtnSkriningKesehatanGigiMulutremajaActionPerformed);
        
        BtnSkriningKesehatanGigiMulutBalita = new widget.Button();
        BtnSkriningKesehatanGigiMulutBalita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningKesehatanGigiMulutBalita.setText("Skrining Gigi Mulut Balita");
        BtnSkriningKesehatanGigiMulutBalita.setFocusPainted(false);
        BtnSkriningKesehatanGigiMulutBalita.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningKesehatanGigiMulutBalita.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningKesehatanGigiMulutBalita.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningKesehatanGigiMulutBalita.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningKesehatanGigiMulutBalita.setName("BtnSkriningKesehatanGigiMulutBalita"); 
        BtnSkriningKesehatanGigiMulutBalita.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningKesehatanGigiMulutBalita.setRoundRect(false);
        BtnSkriningKesehatanGigiMulutBalita.addActionListener(this::BtnSkriningKesehatanGigiMulutBalitaActionPerformed);
        
        BtnSkriningKesehatanGigiMulutLansia = new widget.Button();
        BtnSkriningKesehatanGigiMulutLansia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningKesehatanGigiMulutLansia.setText("Skrining Gigi Mulut Lansia");
        BtnSkriningKesehatanGigiMulutLansia.setFocusPainted(false);
        BtnSkriningKesehatanGigiMulutLansia.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningKesehatanGigiMulutLansia.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningKesehatanGigiMulutLansia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningKesehatanGigiMulutLansia.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningKesehatanGigiMulutLansia.setName("BtnSkriningKesehatanGigiMulutLansia"); 
        BtnSkriningKesehatanGigiMulutLansia.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningKesehatanGigiMulutLansia.setRoundRect(false);
        BtnSkriningKesehatanGigiMulutLansia.addActionListener(this::BtnSkriningKesehatanGigiMulutLansiaActionPerformed);
        
        BtnSkriningKesehatanGigiMulutDewasa = new widget.Button();
        BtnSkriningKesehatanGigiMulutDewasa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningKesehatanGigiMulutDewasa.setText("Skrining Gigi Mulut Dewasa");
        BtnSkriningKesehatanGigiMulutDewasa.setFocusPainted(false);
        BtnSkriningKesehatanGigiMulutDewasa.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningKesehatanGigiMulutDewasa.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningKesehatanGigiMulutDewasa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningKesehatanGigiMulutDewasa.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningKesehatanGigiMulutDewasa.setName("BtnSkriningKesehatanGigiMulutDewasa"); 
        BtnSkriningKesehatanGigiMulutDewasa.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningKesehatanGigiMulutDewasa.setRoundRect(false);
        BtnSkriningKesehatanGigiMulutDewasa.addActionListener(this::BtnSkriningKesehatanGigiMulutDewasaActionPerformed);
        
        BtnSkriningRisikoKankerServiks = new widget.Button();
        BtnSkriningRisikoKankerServiks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningRisikoKankerServiks.setText("Skrining Risiko Kanker Serviks");
        BtnSkriningRisikoKankerServiks.setFocusPainted(false);
        BtnSkriningRisikoKankerServiks.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningRisikoKankerServiks.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningRisikoKankerServiks.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningRisikoKankerServiks.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningRisikoKankerServiks.setName("BtnSkriningRisikoKankerServiks"); 
        BtnSkriningRisikoKankerServiks.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningRisikoKankerServiks.setRoundRect(false);
        BtnSkriningRisikoKankerServiks.addActionListener(this::BtnSkriningRisikoKankerServiksActionPerformed);
        
        BtnSkriningAnemia = new widget.Button();
        BtnSkriningAnemia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningAnemia.setText("Skrining Anemia");
        BtnSkriningAnemia.setFocusPainted(false);
        BtnSkriningAnemia.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningAnemia.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningAnemia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningAnemia.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningAnemia.setName("BtnSkriningAnemia"); 
        BtnSkriningAnemia.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningAnemia.setRoundRect(false);
        BtnSkriningAnemia.addActionListener(this::BtnSkriningAnemiaActionPerformed);
        
        BtnSkriningHipertensi = new widget.Button();
        BtnSkriningHipertensi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningHipertensi.setText("Skrining Hipertensi");
        BtnSkriningHipertensi.setFocusPainted(false);
        BtnSkriningHipertensi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningHipertensi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningHipertensi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningHipertensi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningHipertensi.setName("BtnSkriningHipertensi"); 
        BtnSkriningHipertensi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningHipertensi.setRoundRect(false);
        BtnSkriningHipertensi.addActionListener(this::BtnSkriningHipertensiActionPerformed);
        
        BtnSkriningKesehatanPenglihatan = new widget.Button();
        BtnSkriningKesehatanPenglihatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningKesehatanPenglihatan.setText("Skrining Kesehatan Penglihatan");
        BtnSkriningKesehatanPenglihatan.setFocusPainted(false);
        BtnSkriningKesehatanPenglihatan.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningKesehatanPenglihatan.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningKesehatanPenglihatan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningKesehatanPenglihatan.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningKesehatanPenglihatan.setName("BtnSkriningKesehatanPenglihatan"); 
        BtnSkriningKesehatanPenglihatan.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningKesehatanPenglihatan.setRoundRect(false);
        BtnSkriningKesehatanPenglihatan.addActionListener(this::BtnSkriningKesehatanPenglihatanActionPerformed);
        
        BtnSkriningIndraPendengaran = new widget.Button();
        BtnSkriningIndraPendengaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningIndraPendengaran.setText("Skrining Indra Pendengaran");
        BtnSkriningIndraPendengaran.setFocusPainted(false);
        BtnSkriningIndraPendengaran.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningIndraPendengaran.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningIndraPendengaran.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningIndraPendengaran.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningIndraPendengaran.setName("BtnSkriningIndraPendengaran"); 
        BtnSkriningIndraPendengaran.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningIndraPendengaran.setRoundRect(false);
        BtnSkriningIndraPendengaran.addActionListener(this::BtnSkriningIndraPendengaranActionPerformed);
        
        BtnSkriningFrailtySyndrome = new widget.Button();
        BtnSkriningFrailtySyndrome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningFrailtySyndrome.setText("Skrining Frailty Syndrome");
        BtnSkriningFrailtySyndrome.setFocusPainted(false);
        BtnSkriningFrailtySyndrome.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningFrailtySyndrome.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningFrailtySyndrome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningFrailtySyndrome.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningFrailtySyndrome.setName("BtnSkriningFrailtySyndrome"); 
        BtnSkriningFrailtySyndrome.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningFrailtySyndrome.setRoundRect(false);
        BtnSkriningFrailtySyndrome.addActionListener(this::BtnSkriningFrailtySyndromeActionPerformed);
        
        BtnSkriningTBC = new widget.Button();
        BtnSkriningTBC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningTBC.setText("Skrining TBC");
        BtnSkriningTBC.setFocusPainted(false);
        BtnSkriningTBC.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningTBC.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningTBC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningTBC.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningTBC.setName("BtnSkriningTBC"); 
        BtnSkriningTBC.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningTBC.setRoundRect(false);
        BtnSkriningTBC.addActionListener(this::BtnSkriningTBCActionPerformed);
        
        BtnSkriningPUMA = new widget.Button();
        BtnSkriningPUMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningPUMA.setText("Skrining PUMA");
        BtnSkriningPUMA.setFocusPainted(false);
        BtnSkriningPUMA.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningPUMA.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningPUMA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningPUMA.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningPUMA.setName("BtnSkriningPUMA"); 
        BtnSkriningPUMA.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningPUMA.setRoundRect(false);
        BtnSkriningPUMA.addActionListener(this::BtnSkriningPUMAActionPerformed);
        
        BtnSkriningAdiksiNikotin = new widget.Button();
        BtnSkriningAdiksiNikotin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningAdiksiNikotin.setText("Skrining Adiksi Nikotin");
        BtnSkriningAdiksiNikotin.setFocusPainted(false);
        BtnSkriningAdiksiNikotin.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningAdiksiNikotin.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningAdiksiNikotin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningAdiksiNikotin.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningAdiksiNikotin.setName("BtnSkriningAdiksiNikotin"); 
        BtnSkriningAdiksiNikotin.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningAdiksiNikotin.setRoundRect(false);
        BtnSkriningAdiksiNikotin.addActionListener(this::BtnSkriningAdiksiNikotinActionPerformed);
        
        BtnSkriningThalassemia = new widget.Button();
        BtnSkriningThalassemia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningThalassemia.setText("Skrining Thalassemia");
        BtnSkriningThalassemia.setFocusPainted(false);
        BtnSkriningThalassemia.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningThalassemia.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningThalassemia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningThalassemia.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningThalassemia.setName("BtnSkriningThalassemia"); 
        BtnSkriningThalassemia.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningThalassemia.setRoundRect(false);
        BtnSkriningThalassemia.addActionListener(this::BtnSkriningThalassemiaActionPerformed);
        
        BtnSkriningInstrumenSDQ = new widget.Button();
        BtnSkriningInstrumenSDQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningInstrumenSDQ.setText("Skrining Instrumen SDQ");
        BtnSkriningInstrumenSDQ.setFocusPainted(false);
        BtnSkriningInstrumenSDQ.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningInstrumenSDQ.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningInstrumenSDQ.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningInstrumenSDQ.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningInstrumenSDQ.setName("BtnSkriningInstrumenSDQ"); 
        BtnSkriningInstrumenSDQ.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningInstrumenSDQ.setRoundRect(false);
        BtnSkriningInstrumenSDQ.addActionListener(this::BtnSkriningInstrumenSDQActionPerformed);
        
        BtnSkriningInstrumenACRS = new widget.Button();
        BtnSkriningInstrumenACRS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningInstrumenACRS.setText("Skrining Instrumen ACRS");
        BtnSkriningInstrumenACRS.setFocusPainted(false);
        BtnSkriningInstrumenACRS.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningInstrumenACRS.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningInstrumenACRS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningInstrumenACRS.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningInstrumenACRS.setName("BtnSkriningInstrumenACRS"); 
        BtnSkriningInstrumenACRS.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningInstrumenACRS.setRoundRect(false);
        BtnSkriningInstrumenACRS.addActionListener(this::BtnSkriningInstrumenACRSActionPerformed);
        
        BtnSkriningInstrumenMentalEmosional = new widget.Button();
        BtnSkriningInstrumenMentalEmosional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningInstrumenMentalEmosional.setText("Skrining Mental Emosional");
        BtnSkriningInstrumenMentalEmosional.setFocusPainted(false);
        BtnSkriningInstrumenMentalEmosional.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningInstrumenMentalEmosional.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningInstrumenMentalEmosional.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningInstrumenMentalEmosional.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningInstrumenMentalEmosional.setName("BtnSkriningInstrumenMentalEmosional"); 
        BtnSkriningInstrumenMentalEmosional.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningInstrumenMentalEmosional.setRoundRect(false);
        BtnSkriningInstrumenMentalEmosional.addActionListener(this::BtnSkriningInstrumenMentalEmosionalActionPerformed);
        
        BtnSkriningInstrumenAMT = new widget.Button();
        BtnSkriningInstrumenAMT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningInstrumenAMT.setText("Skrining Instrumen AMT");
        BtnSkriningInstrumenAMT.setFocusPainted(false);
        BtnSkriningInstrumenAMT.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningInstrumenAMT.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningInstrumenAMT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningInstrumenAMT.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningInstrumenAMT.setName("BtnSkriningInstrumenAMT"); 
        BtnSkriningInstrumenAMT.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningInstrumenAMT.setRoundRect(false);
        BtnSkriningInstrumenAMT.addActionListener(this::BtnSkriningInstrumenAMTActionPerformed);
        
        BtnSkriningPneumoniaSeverityIndex = new widget.Button();
        BtnSkriningPneumoniaSeverityIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningPneumoniaSeverityIndex.setText("Skrining PSI");
        BtnSkriningPneumoniaSeverityIndex.setFocusPainted(false);
        BtnSkriningPneumoniaSeverityIndex.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningPneumoniaSeverityIndex.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningPneumoniaSeverityIndex.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningPneumoniaSeverityIndex.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningPneumoniaSeverityIndex.setName("BtnSkriningPneumoniaSeverityIndex"); 
        BtnSkriningPneumoniaSeverityIndex.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningPneumoniaSeverityIndex.setRoundRect(false);
        BtnSkriningPneumoniaSeverityIndex.addActionListener(this::BtnSkriningPneumoniaSeverityIndexActionPerformed);
        
        BtnSkriningCURB65 = new widget.Button();
        BtnSkriningCURB65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningCURB65.setText("Skrining CURB-65");
        BtnSkriningCURB65.setFocusPainted(false);
        BtnSkriningCURB65.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningCURB65.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningCURB65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningCURB65.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningCURB65.setName("BtnSkriningCURB65"); 
        BtnSkriningCURB65.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningCURB65.setRoundRect(false);
        BtnSkriningCURB65.addActionListener(this::BtnSkriningCURB65ActionPerformed);
        
        BtnSkriningInstrumenSRQ = new widget.Button();
        BtnSkriningInstrumenSRQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningInstrumenSRQ.setText("Skrining Instrumen SRQ");
        BtnSkriningInstrumenSRQ.setFocusPainted(false);
        BtnSkriningInstrumenSRQ.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningInstrumenSRQ.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningInstrumenSRQ.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningInstrumenSRQ.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningInstrumenSRQ.setName("BtnSkriningInstrumenSRQ"); 
        BtnSkriningInstrumenSRQ.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningInstrumenSRQ.setRoundRect(false);
        BtnSkriningInstrumenSRQ.addActionListener(this::BtnSkriningInstrumenSRQActionPerformed);
        
        BtnSkriningKankerKolorektal = new widget.Button();
        BtnSkriningKankerKolorektal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningKankerKolorektal.setText("Skrining Kanker Kolorektal");
        BtnSkriningKankerKolorektal.setFocusPainted(false);
        BtnSkriningKankerKolorektal.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningKankerKolorektal.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningKankerKolorektal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningKankerKolorektal.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningKankerKolorektal.setName("BtnSkriningKankerKolorektal"); 
        BtnSkriningKankerKolorektal.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningKankerKolorektal.setRoundRect(false);
        BtnSkriningKankerKolorektal.addActionListener(this::BtnSkriningKankerKolorektalActionPerformed);
        
        BtnSkriningDiabetesMelitus = new widget.Button();
        BtnSkriningDiabetesMelitus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningDiabetesMelitus.setText("Skrining Diabetes Melitus");
        BtnSkriningDiabetesMelitus.setFocusPainted(false);
        BtnSkriningDiabetesMelitus.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningDiabetesMelitus.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningDiabetesMelitus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningDiabetesMelitus.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningDiabetesMelitus.setName("BtnSkriningDiabetesMelitus"); 
        BtnSkriningDiabetesMelitus.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningDiabetesMelitus.setRoundRect(false);
        BtnSkriningDiabetesMelitus.addActionListener(this::BtnSkriningDiabetesMelitusActionPerformed);
        
        BtnAwalMedisJantung = new widget.Button();
        BtnAwalMedisJantung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnAwalMedisJantung.setText("Awal Medis Jantung");
        BtnAwalMedisJantung.setFocusPainted(false);
        BtnAwalMedisJantung.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnAwalMedisJantung.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnAwalMedisJantung.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnAwalMedisJantung.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnAwalMedisJantung.setName("BtnAwalMedisJantung"); 
        BtnAwalMedisJantung.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnAwalMedisJantung.setRoundRect(false);
        BtnAwalMedisJantung.addActionListener(this::BtnAwalMedisJantungActionPerformed);
        
        BtnAwalMedisUrologi = new widget.Button();
        BtnAwalMedisUrologi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnAwalMedisUrologi.setText("Awal Medis Urologi");
        BtnAwalMedisUrologi.setFocusPainted(false);
        BtnAwalMedisUrologi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnAwalMedisUrologi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnAwalMedisUrologi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnAwalMedisUrologi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnAwalMedisUrologi.setName("BtnAwalMedisUrologi"); 
        BtnAwalMedisUrologi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnAwalMedisUrologi.setRoundRect(false);
        BtnAwalMedisUrologi.addActionListener(this::BtnAwalMedisUrologiActionPerformed);
        
        BtnLaporanTindakan = new widget.Button();
        BtnLaporanTindakan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnLaporanTindakan.setText("Laporan Tindakan");
        BtnLaporanTindakan.setFocusPainted(false);
        BtnLaporanTindakan.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnLaporanTindakan.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnLaporanTindakan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnLaporanTindakan.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnLaporanTindakan.setName("BtnLaporanTindakan"); 
        BtnLaporanTindakan.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnLaporanTindakan.setRoundRect(false);
        BtnLaporanTindakan.addActionListener(this::BtnLaporanTindakanActionPerformed);
        
        BtnCatatanPengkajianPaskaOperasi = new widget.Button();
        BtnCatatanPengkajianPaskaOperasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnCatatanPengkajianPaskaOperasi.setText("Pengkajian Paska Operasi");
        BtnCatatanPengkajianPaskaOperasi.setFocusPainted(false);
        BtnCatatanPengkajianPaskaOperasi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnCatatanPengkajianPaskaOperasi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnCatatanPengkajianPaskaOperasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnCatatanPengkajianPaskaOperasi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnCatatanPengkajianPaskaOperasi.setName("BtnCatatanPengkajianPaskaOperasi"); 
        BtnCatatanPengkajianPaskaOperasi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnCatatanPengkajianPaskaOperasi.setRoundRect(false);
        BtnCatatanPengkajianPaskaOperasi.addActionListener(this::BtnCatatanPengkajianPaskaOperasiActionPerformed);
        
        BtnChecklistKesiapanAnestesi = new widget.Button();
        BtnChecklistKesiapanAnestesi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnChecklistKesiapanAnestesi.setText("Check List Kesiapan Anestesi");
        BtnChecklistKesiapanAnestesi.setFocusPainted(false);
        BtnChecklistKesiapanAnestesi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnChecklistKesiapanAnestesi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnChecklistKesiapanAnestesi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnChecklistKesiapanAnestesi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnChecklistKesiapanAnestesi.setName("BtnChecklistKesiapanAnestesi"); 
        BtnChecklistKesiapanAnestesi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnChecklistKesiapanAnestesi.setRoundRect(false);
        BtnChecklistKesiapanAnestesi.addActionListener(this::BtnChecklistKesiapanAnestesiActionPerformed);
        
        BtnCatatanAnastesiSedasi = new widget.Button();
        BtnCatatanAnastesiSedasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnCatatanAnastesiSedasi.setText("Catatan Anestesi-Sedasi");
        BtnCatatanAnastesiSedasi.setFocusPainted(false);
        BtnCatatanAnastesiSedasi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnCatatanAnastesiSedasi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnCatatanAnastesiSedasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnCatatanAnastesiSedasi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnCatatanAnastesiSedasi.setName("BtnCatatanAnastesiSedasi"); 
        BtnCatatanAnastesiSedasi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnCatatanAnastesiSedasi.setRoundRect(false);
        BtnCatatanAnastesiSedasi.addActionListener(this::BtnCatatanAnastesiSedasiActionPerformed);
        
        BtnCatatanObservasiBayi = new widget.Button();
        BtnCatatanObservasiBayi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnCatatanObservasiBayi.setText("Observasi Bayi");
        BtnCatatanObservasiBayi.setFocusPainted(false);
        BtnCatatanObservasiBayi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnCatatanObservasiBayi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnCatatanObservasiBayi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnCatatanObservasiBayi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnCatatanObservasiBayi.setName("BtnCatatanObservasiBayi"); 
        BtnCatatanObservasiBayi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnCatatanObservasiBayi.setRoundRect(false);
        BtnCatatanObservasiBayi.addActionListener(this::BtnCatatanObservasiBayiActionPerformed);
        
        BtnChecklistKriteriaMasukNICU = new widget.Button();
        BtnChecklistKriteriaMasukNICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png")));
        BtnChecklistKriteriaMasukNICU.setText("Check List Masuk NICU");
        BtnChecklistKriteriaMasukNICU.setFocusPainted(false);
        BtnChecklistKriteriaMasukNICU.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnChecklistKriteriaMasukNICU.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnChecklistKriteriaMasukNICU.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnChecklistKriteriaMasukNICU.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnChecklistKriteriaMasukNICU.setName("BtnChecklistKriteriaMasukNICU");
        BtnChecklistKriteriaMasukNICU.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnChecklistKriteriaMasukNICU.setRoundRect(false);
        BtnChecklistKriteriaMasukNICU.addActionListener(this::BtnChecklistKriteriaMasukNICUActionPerformed);
        
        BtnChecklistKriteriaMasukPICU = new widget.Button();
        BtnChecklistKriteriaMasukPICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png")));
        BtnChecklistKriteriaMasukPICU.setText("Check List Masuk PICU");
        BtnChecklistKriteriaMasukPICU.setFocusPainted(false);
        BtnChecklistKriteriaMasukPICU.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnChecklistKriteriaMasukPICU.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnChecklistKriteriaMasukPICU.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnChecklistKriteriaMasukPICU.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnChecklistKriteriaMasukPICU.setName("BtnChecklistKriteriaMasukPICU");
        BtnChecklistKriteriaMasukPICU.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnChecklistKriteriaMasukPICU.setRoundRect(false);
        BtnChecklistKriteriaMasukPICU.addActionListener(this::BtnChecklistKriteriaMasukPICUActionPerformed);
        
        BtnSkriningGiziKehamilan = new widget.Button();
        BtnSkriningGiziKehamilan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png")));
        BtnSkriningGiziKehamilan.setText("Skrining Gizi Kehamilan");
        BtnSkriningGiziKehamilan.setFocusPainted(false);
        BtnSkriningGiziKehamilan.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningGiziKehamilan.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningGiziKehamilan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningGiziKehamilan.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningGiziKehamilan.setName("BtnSkriningGiziKehamilan");
        BtnSkriningGiziKehamilan.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningGiziKehamilan.setRoundRect(false);
        BtnSkriningGiziKehamilan.addActionListener(this::BtnSkriningGiziKehamilanActionPerformed);
        
        BtnIntervensiNyeriFarmakologi = new widget.Button();
        BtnIntervensiNyeriFarmakologi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png")));
        BtnIntervensiNyeriFarmakologi.setText("Intervensi Nyeri Farmakologi");
        BtnIntervensiNyeriFarmakologi.setFocusPainted(false);
        BtnIntervensiNyeriFarmakologi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnIntervensiNyeriFarmakologi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnIntervensiNyeriFarmakologi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnIntervensiNyeriFarmakologi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnIntervensiNyeriFarmakologi.setName("BtnIntervensiNyeriFarmakologi");
        BtnIntervensiNyeriFarmakologi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnIntervensiNyeriFarmakologi.setRoundRect(false);
        BtnIntervensiNyeriFarmakologi.addActionListener(this::BtnIntervensiNyeriFarmakologiActionPerformed);
        
        BtnIntervensiNyeriNonFarmakologi = new widget.Button();
        BtnIntervensiNyeriNonFarmakologi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png")));
        BtnIntervensiNyeriNonFarmakologi.setText("Intervensi Nyeri Non Farma");
        BtnIntervensiNyeriNonFarmakologi.setFocusPainted(false);
        BtnIntervensiNyeriNonFarmakologi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnIntervensiNyeriNonFarmakologi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnIntervensiNyeriNonFarmakologi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnIntervensiNyeriNonFarmakologi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnIntervensiNyeriNonFarmakologi.setName("BtnIntervensiNyeriNonFarmakologi");
        BtnIntervensiNyeriNonFarmakologi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnIntervensiNyeriNonFarmakologi.setRoundRect(false);
        BtnIntervensiNyeriNonFarmakologi.addActionListener(this::BtnIntervensiNyeriNonFarmakologiActionPerformed);
        
        BtnResepIterasiBPJS = new widget.Button();
        BtnResepIterasiBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png")));
        BtnResepIterasiBPJS.setText("Iterasi Resep BPJS");
        BtnResepIterasiBPJS.setFocusPainted(false);
        BtnResepIterasiBPJS.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnResepIterasiBPJS.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnResepIterasiBPJS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnResepIterasiBPJS.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnResepIterasiBPJS.setName("BtnResepIterasiBPJS");
        BtnResepIterasiBPJS.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnResepIterasiBPJS.setRoundRect(false);
        BtnResepIterasiBPJS.addActionListener(this::BtnResepIterasiBPJSActionPerformed);
        
        BtnChecklistKriteriaMasukIsolasi = new widget.Button();
        BtnChecklistKriteriaMasukIsolasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnChecklistKriteriaMasukIsolasi.setText("Check List Masuk Isolasi");
        BtnChecklistKriteriaMasukIsolasi.setFocusPainted(false);
        BtnChecklistKriteriaMasukIsolasi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnChecklistKriteriaMasukIsolasi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnChecklistKriteriaMasukIsolasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnChecklistKriteriaMasukIsolasi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnChecklistKriteriaMasukIsolasi.setName("BtnChecklistKriteriaMasukIsolasi"); 
        BtnChecklistKriteriaMasukIsolasi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnChecklistKriteriaMasukIsolasi.setRoundRect(false);
        BtnChecklistKriteriaMasukIsolasi.addActionListener(this::BtnChecklistKriteriaMasukIsolasiActionPerformed);
        
        BtnSkriningTOLAC = new widget.Button();
        BtnSkriningTOLAC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnSkriningTOLAC.setText("Skrining TOLAC");
        BtnSkriningTOLAC.setFocusPainted(false);
        BtnSkriningTOLAC.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnSkriningTOLAC.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnSkriningTOLAC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSkriningTOLAC.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnSkriningTOLAC.setName("BtnSkriningTOLAC"); 
        BtnSkriningTOLAC.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnSkriningTOLAC.setRoundRect(false);
        BtnSkriningTOLAC.addActionListener(this::BtnSkriningTOLACActionPerformed);
        
        BtnAdmisiSkoringTOLAC = new widget.Button();
        BtnAdmisiSkoringTOLAC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnAdmisiSkoringTOLAC.setText("Admisi & Skoring TOLAC");
        BtnAdmisiSkoringTOLAC.setFocusPainted(false);
        BtnAdmisiSkoringTOLAC.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnAdmisiSkoringTOLAC.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnAdmisiSkoringTOLAC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnAdmisiSkoringTOLAC.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnAdmisiSkoringTOLAC.setName("BtnAdmisiSkoringTOLAC"); 
        BtnAdmisiSkoringTOLAC.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnAdmisiSkoringTOLAC.setRoundRect(false);
        BtnAdmisiSkoringTOLAC.addActionListener(this::BtnAdmisiSkoringTOLACActionPerformed);
        
        BtnHasilPersalinanTOLAC = new widget.Button();
        BtnHasilPersalinanTOLAC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnHasilPersalinanTOLAC.setText("Hasil Persalinan TOLAC");
        BtnHasilPersalinanTOLAC.setFocusPainted(false);
        BtnHasilPersalinanTOLAC.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnHasilPersalinanTOLAC.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnHasilPersalinanTOLAC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnHasilPersalinanTOLAC.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnHasilPersalinanTOLAC.setName("BtnHasilPersalinanTOLAC"); 
        BtnHasilPersalinanTOLAC.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnHasilPersalinanTOLAC.setRoundRect(false);
        BtnHasilPersalinanTOLAC.addActionListener(this::BtnHasilPersalinanTOLACActionPerformed);
        
        BtnMonitoringTolac = new widget.Button();
        BtnMonitoringTolac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnMonitoringTolac.setText("Monitoring Selama TOLAC");
        BtnMonitoringTolac.setFocusPainted(false);
        BtnMonitoringTolac.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnMonitoringTolac.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnMonitoringTolac.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMonitoringTolac.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnMonitoringTolac.setName("BtnMonitoringTolac"); 
        BtnMonitoringTolac.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnMonitoringTolac.setRoundRect(false);
        BtnMonitoringTolac.addActionListener(this::BtnMonitoringTolacActionPerformed);
        
        BtnLaporanReaksiTranfusi = new widget.Button();
        BtnLaporanReaksiTranfusi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnLaporanReaksiTranfusi.setText("Laporan Reaksi Tranfusi");
        BtnLaporanReaksiTranfusi.setFocusPainted(false);
        BtnLaporanReaksiTranfusi.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnLaporanReaksiTranfusi.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnLaporanReaksiTranfusi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnLaporanReaksiTranfusi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnLaporanReaksiTranfusi.setName("BtnLaporanReaksiTranfusi"); 
        BtnLaporanReaksiTranfusi.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnLaporanReaksiTranfusi.setRoundRect(false);
        BtnLaporanReaksiTranfusi.addActionListener(this::BtnLaporanReaksiTranfusiActionPerformed);
        
        BtnPenilaianGRACEScore = new widget.Button();
        BtnPenilaianGRACEScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item.png"))); 
        BtnPenilaianGRACEScore.setText("Penilaian GRACE Score");
        BtnPenilaianGRACEScore.setFocusPainted(false);
        BtnPenilaianGRACEScore.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        BtnPenilaianGRACEScore.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnPenilaianGRACEScore.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnPenilaianGRACEScore.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnPenilaianGRACEScore.setName("BtnPenilaianGRACEScore"); 
        BtnPenilaianGRACEScore.setPreferredSize(new java.awt.Dimension(190, 23));
        BtnPenilaianGRACEScore.setRoundRect(false);
        BtnPenilaianGRACEScore.addActionListener(this::BtnPenilaianGRACEScoreActionPerformed);
        
        PopupSOAP = new widget.PopupMenu();
        PopupSOAP.setName("PopupSOAP");
        tbPemeriksaan.setComponentPopupMenu(PopupSOAP);
        
        PopupPemeriksaan = new widget.PopupMenu();
        PopupPemeriksaan.setName("PopupPemeriksaan");
        
        TKeluhan.setComponentPopupMenu(PopupPemeriksaan);
        TPemeriksaan.setComponentPopupMenu(PopupPemeriksaan);
        TPenilaian.setComponentPopupMenu(PopupPemeriksaan);
        TindakLanjut.setComponentPopupMenu(PopupPemeriksaan);
        TInstruksi.setComponentPopupMenu(PopupPemeriksaan);
        TEvaluasi.setComponentPopupMenu(PopupPemeriksaan);
        
        MnSOAPDokter = new widget.MenuItem();
        MnSOAPDokter.setBackground(new java.awt.Color(255, 255, 254));
        MnSOAPDokter.setFont(new java.awt.Font("Tahoma", 0, 11));
        MnSOAPDokter.setForeground(new java.awt.Color(50, 50, 50));
        MnSOAPDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); 
        MnSOAPDokter.setText("Formulir SOAP Dokter");
        MnSOAPDokter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MnSOAPDokter.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MnSOAPDokter.setName("MnSOAPDokter");
        MnSOAPDokter.setPreferredSize(new java.awt.Dimension(210, 26));
        MnSOAPDokter.addActionListener(this::MnSOAPDokterActionPerformed);
        
        MnSOAPPetugas = new widget.MenuItem();
        MnSOAPPetugas.setBackground(new java.awt.Color(255, 255, 254));
        MnSOAPPetugas.setFont(new java.awt.Font("Tahoma", 0, 11));
        MnSOAPPetugas.setForeground(new java.awt.Color(50, 50, 50));
        MnSOAPPetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); 
        MnSOAPPetugas.setText("Formulir SOAP Petugas");
        MnSOAPPetugas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MnSOAPPetugas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MnSOAPPetugas.setName("MnSOAPPetugas");
        MnSOAPPetugas.setPreferredSize(new java.awt.Dimension(210, 26));
        MnSOAPPetugas.addActionListener(this::MnSOAPPetugasActionPerformed);
        
        MnCopySOAP = new widget.MenuItem();
        MnCopySOAP.setBackground(new java.awt.Color(255, 255, 254));
        MnCopySOAP.setFont(new java.awt.Font("Tahoma", 0, 11));
        MnCopySOAP.setForeground(new java.awt.Color(50, 50, 50));
        MnCopySOAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); 
        MnCopySOAP.setText("Copy SOAPIE");
        MnCopySOAP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MnCopySOAP.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MnCopySOAP.setName("MnCopySOAP");
        MnCopySOAP.setPreferredSize(new java.awt.Dimension(210, 26));
        MnCopySOAP.addActionListener(this::MnCopySOAPActionPerformed);
        
        MnPasteSOAP = new widget.MenuItem();
        MnPasteSOAP.setBackground(new java.awt.Color(255, 255, 254));
        MnPasteSOAP.setFont(new java.awt.Font("Tahoma", 0, 11));
        MnPasteSOAP.setForeground(new java.awt.Color(50, 50, 50));
        MnPasteSOAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); 
        MnPasteSOAP.setText("Paste SOAPIE");
        MnPasteSOAP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MnPasteSOAP.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MnPasteSOAP.setName("MnPasteSOAP");
        MnPasteSOAP.setPreferredSize(new java.awt.Dimension(210, 26));
        MnPasteSOAP.addActionListener(this::MnPasteSOAPActionPerformed);
        
        TanggalRegistrasi = new widget.TextBox();
        TanggalRegistrasi.setHighlighter(null);
        TanggalRegistrasi.setName("TanggalRegistrasi");
        
        PopupSOAP.add(MnSOAPDokter);
        PopupSOAP.add(MnSOAPPetugas);
        PopupSOAP.add(MnCopySOAP);
        PopupPemeriksaan.add(MnPasteSOAP);
        
        FormMenu.add(BtnRiwayat);
        FormMenu.add(BtnResepObat);
        FormMenu.add(BtnResepIterasiBPJS);
        FormMenu.add(BtnCopyResep);
        FormMenu.add(BtnResepLuar);
        FormMenu.add(BtnInputObat);
        FormMenu.add(BtnObatBhp);
        FormMenu.add(BtnBerkasDigital);
        FormMenu.add(BtnPermintaanLab);
        FormMenu.add(BtnPermintaanRad);
        FormMenu.add(BtnPermintaanKonsultasiMedik);
        FormMenu.add(BtnPermintaanKonsultasiPerawat);
        FormMenu.add(BtnJadwalOperasi);
        FormMenu.add(BtnSKDP);
        FormMenu.add(BtnKamar);
        FormMenu.add(BtnTriaseIGD);
        FormMenu.add(BtnRujukInternal);
        FormMenu.add(BtnResume);
        FormMenu.add(BtnAwalKeperawatanIGD);
        FormMenu.add(BtnAwalKeperawatan);
        FormMenu.add(BtnAwalKeperawatanGigi);
        FormMenu.add(BtnAwalKeperawatanKandungan);
        FormMenu.add(BtnAwalKeperawatanAnak);
        FormMenu.add(BtnAwalKeperawatanPsikiatri);
        FormMenu.add(BtnAwalKeperawatanGeriatri);
        FormMenu.add(BtnAwalFisioterapi);
        FormMenu.add(BtnAwalTerapiWicara);
        FormMenu.add(BtnPenatalaksanaanTerapiOkupasi);
        FormMenu.add(BtnAwalMedisIGD);
        FormMenu.add(BtnAwalMedisIGDPsikiatri);
        FormMenu.add(BtnAwalMedis);
        FormMenu.add(BtnAwalMedisKandungan);
        FormMenu.add(BtnAwalMedisAnak);
        FormMenu.add(BtnAwalMedisTHT);
        FormMenu.add(BtnAwalMedisPsikiatri);
        FormMenu.add(BtnAwalMedisPenyakitDalam);
        FormMenu.add(BtnAwalMedisMata);
        FormMenu.add(BtnAwalMedisNeurologi);
        FormMenu.add(BtnAwalMedisOrthopedi);
        FormMenu.add(BtnAwalMedisBedah);
        FormMenu.add(BtnAwalMedisBedahMulut);
        FormMenu.add(BtnAwalMedisGeriatri);
        FormMenu.add(BtnAwalMedisKulitKelamin);
        FormMenu.add(BtnAwalMedisParu);
        FormMenu.add(BtnAwalMedisJantung);
        FormMenu.add(BtnAwalMedisUrologi);
        FormMenu.add(BtnAwalMedisRehabMedik);
        FormMenu.add(BtnAwalMedisHemodialisa);
        FormMenu.add(BtnRujukKeluar);
        FormMenu.add(BtnAdmisiSkoringTOLAC);
        FormMenu.add(BtnCatatan);
        FormMenu.add(BtnCatatanObservasiIGD);
        FormMenu.add(BtnCatatanObservasiCHBP);
        FormMenu.add(BtnCatatanObservasiInduksiPersalinan);
        FormMenu.add(BtnMonitoringTolac);
        FormMenu.add(BtnCatatanObservasiBayi);
        FormMenu.add(BtnCatatanObservasiHemodialisa);
        FormMenu.add(BtnCatatanObservasiRuangOperasi);
        FormMenu.add(BtnCatatanCekGDS);
        FormMenu.add(BtnCatatanKeperawatan);
        FormMenu.add(BtnCatatanKeseimbanganCairan);
        FormMenu.add(BtnCatatanCairanHemodialisa);
        FormMenu.add(BtnChecklistPemberianFibrinolitik);
        FormMenu.add(BtnPenilaianUlangNyeri);
        FormMenu.add(BtnIntervensiNyeriFarmakologi);
        FormMenu.add(BtnIntervensiNyeriNonFarmakologi);
        FormMenu.add(BtnPemantauanPEWSAnak);
        FormMenu.add(BtnPemantauanPEWSDewasa);
        FormMenu.add(BtnPemantauanMEOWS);
        FormMenu.add(BtnPemantauanEWSNeonatus);
        FormMenu.add(BtnMonitoringReaksiTranfusi);
        FormMenu.add(BtnLaporanReaksiTranfusi);
        FormMenu.add(BtnLayananKedokteranFisikRehabilitasi);
        FormMenu.add(BtnUjiFungsiKFR);
        FormMenu.add(BtnChecklistKriteriaMasukHCU);
        FormMenu.add(BtnChecklistKriteriaMasukICU);
        FormMenu.add(BtnChecklistKriteriaMasukNICU);
        FormMenu.add(BtnChecklistKriteriaMasukPICU);
        FormMenu.add(BtnChecklistKriteriaMasukIsolasi);
        FormMenu.add(BtnPenilaianPreInduksi);
        FormMenu.add(BtnChecklistPreOperasi);
        FormMenu.add(BtnSignInSebelumAnestesi);
        FormMenu.add(BtnTimeOutSebelumInsisi);
        FormMenu.add(BtnSignOutSebelumMenutupLuka);
        FormMenu.add(BtnChecklistPostOperasi);
        FormMenu.add(BtnPenilaianPreOperasi);
        FormMenu.add(BtnCatatanAnastesiSedasi);
        FormMenu.add(BtnPenilaianPreAnestesi);
        FormMenu.add(BtnChecklistKesiapanAnestesi);
        FormMenu.add(BtnSkorAldrettePascaAnestesi);
        FormMenu.add(BtnSkorStewardPascaAnestesi);
        FormMenu.add(BtnSkorBromagePascaAnestesi);
        FormMenu.add(BtnCatatanPengkajianPaskaOperasi);
        FormMenu.add(BtnMedicalCheckUp);
        FormMenu.add(BtnPenilaianPsikolog);
        FormMenu.add(BtnPenilaianPsikologKlinis);
        FormMenu.add(BtnPenilaianGRACEScore);
        FormMenu.add(BtnPenilaianLanjutanRisikoJatuhDewasa);
        FormMenu.add(BtnPenilaianLanjutanRisikoJatuhAnak);
        FormMenu.add(BtnPenilaianLanjutanRisikoJatuhLansia);
        FormMenu.add(BtnPenilaianLanjutanRisikoJatuhNeonatus);
        FormMenu.add(BtnPenilaianLanjutanRisikoJatuhGeriatri);
        FormMenu.add(BtnPenilaianLanjutanRisikoJatuhPsikiatri);
        FormMenu.add(BtnPenilaianLanjutanSkriningFungsional);
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
        FormMenu.add(BtnCatatanPersalinanan);
        FormMenu.add(BtnLaporanTindakan);
        FormMenu.add(BtnHasilPersalinanTOLAC);
        FormMenu.add(BtnSkriningMerokokUsiaRemaja);
        FormMenu.add(BtnSkriningKekerasanPadaWanita);
        FormMenu.add(BtnSkriningObesitas);
        FormMenu.add(BtnSkriningRisikoKankerPayudara);
        FormMenu.add(BtnSkriningRisikoKankerParu);
        FormMenu.add(BtnSkriningRisikoKankerServiks);
        FormMenu.add(BtnSkriningKesehatanGigiMulutremaja);
        FormMenu.add(BtnSkriningKesehatanGigiMulutBalita);
        FormMenu.add(BtnSkriningKesehatanGigiMulutDewasa);
        FormMenu.add(BtnSkriningKesehatanGigiMulutLansia);
        FormMenu.add(BtnSkriningTBC);
        FormMenu.add(BtnSkriningPUMA);
        FormMenu.add(BtnSkriningPneumoniaSeverityIndex);
        FormMenu.add(BtnSkriningCURB65);
        FormMenu.add(BtnSkriningAdiksiNikotin);
        FormMenu.add(BtnSkriningThalassemia);
        FormMenu.add(BtnSkriningInstrumenSDQ);
        FormMenu.add(BtnSkriningInstrumenSRQ);
        FormMenu.add(BtnSkriningInstrumenACRS);
        FormMenu.add(BtnSkriningInstrumenMentalEmosional);
        FormMenu.add(BtnSkriningInstrumenAMT);
        FormMenu.add(BtnSkriningKankerKolorektal);
        FormMenu.add(BtnSkriningDiabetesMelitus);
        FormMenu.add(BtnSkriningAnemia);
        FormMenu.add(BtnSkriningHipertensi);
        FormMenu.add(BtnSkriningKesehatanPenglihatan);
        FormMenu.add(BtnSkriningIndraPendengaran);
        FormMenu.add(BtnSkriningFrailtySyndrome);
        FormMenu.add(BtnSkriningTOLAC);
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
        FormMenu.add(BtnEdukasiPasienKeluarga);
        FormMenu.add(BtnPelaksanaanInformasiEdukasi);
        FormMenu.add(BtnPengkajianRestrain);
        FormMenu.add(BtnPenilaianBayiBaruLahir);
        FormMenu.add(BtnPenilaianPasienTerminal);
        FormMenu.add(BtnPenilaianKorbanKekerasan);
        FormMenu.add(BtnPenilaianPasienPenyakitMenular);
        FormMenu.add(BtnPenilaianPasienImunitasRendah);
        FormMenu.add(BtnPenilaianPasienKeracunan);
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
                }else{                        
                    try {
                        jmlparsial=0;
                        if(aktifkanparsial.equals("yes")){
                            jmlparsial=Sequel.cariInteger("select count(set_input_parsial.kd_pj) from set_input_parsial where set_input_parsial.kd_pj=?",kd_pj);
                        }
                        if(jmlparsial>0){    
                            SimpanPenangananDokter();
                        }else{
                            if(Sequel.cariRegistrasi(TNoRw.getText())>0){
                                JOptionPane.showMessageDialog(rootPane,"Data billing sudah terverifikasi.\nSilahkan hubungi bagian kasir/keuangan ..!!");
                                TCari.requestFocus();
                            }else{
                                SimpanPenangananDokter();
                            }
                        } 
                    } catch (Exception e) {
                    }                      
                } 
                break;
            case 1:
                if(kdptg.getText().trim().equals("")||TPerawat.getText().trim().equals("")){
                    Valid.textKosong(kdptg,"Petugas");
                }else{
                    try {
                        jmlparsial=0;
                        if(aktifkanparsial.equals("yes")){
                            jmlparsial=Sequel.cariInteger("select count(set_input_parsial.kd_pj) from set_input_parsial where set_input_parsial.kd_pj=?",kd_pj);
                        }
                        if(jmlparsial>0){ 
                            SimpanPenangananPetugas();
                        }else{
                            if(Sequel.cariRegistrasi(TNoRw.getText())>0){
                                JOptionPane.showMessageDialog(rootPane,"Data billing sudah terverifikasi.\nSilahkan hubungi bagian kasir/keuangan ..!!");
                                TCari.requestFocus();
                            }else{
                                SimpanPenangananPetugas();
                            }
                        } 
                    } catch (Exception e) {
                    } 
                }  
                break;
            case 2:
                if(KdDok2.getText().trim().equals("")||TDokter2.getText().trim().equals("")){
                    Valid.textKosong(KdDok2,"Dokter");
                }else if(kdptg2.getText().trim().equals("")||TPerawat2.getText().trim().equals("")){
                    Valid.textKosong(kdptg2,"Petugas");
                }else{      
                    try {
                        jmlparsial=0;
                        if(aktifkanparsial.equals("yes")){
                            jmlparsial=Sequel.cariInteger("select count(set_input_parsial.kd_pj) from set_input_parsial where set_input_parsial.kd_pj=?",kd_pj);
                        }
                        if(jmlparsial>0){ 
                            SimpanPenangananDokterPetugas();
                        }else {
                            if(Sequel.cariRegistrasi(TNoRw.getText())>0){
                                JOptionPane.showMessageDialog(rootPane,"Data billing sudah terverifikasi.\nSilahkan hubungi bagian kasir/keuangan ..!!");
                                TCari.requestFocus();
                            }else{
                                SimpanPenangananDokterPetugas();
                            }
                        } 
                    } catch (Exception e) {
                    }                            
                }  
                break;
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
                            if(Sequel.menyimpantf("pemeriksaan_ralan","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",21,new String[]{
                                TNoRw.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                                TSuhu.getText(),TTensi.getText(),TNadi.getText(),TRespirasi.getText(),TTinggi.getText(),TBerat.getText(),
                                SpO2.getText(),TGCS.getText(),cmbKesadaran.getSelectedItem().toString(),TKeluhan.getText(),TPemeriksaan.getText(),TAlergi.getText(),
                                LingkarPerut.getText(),TindakLanjut.getText(),TPenilaian.getText(),TInstruksi.getText(),TEvaluasi.getText(),KdPeg.getText()})==true){
                                    tabModePemeriksaan.addRow(new Object[]{
                                        false,TNoRw.getText(),TNoRM.getText(),TPasien.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                                        TSuhu.getText(),TTensi.getText(),TNadi.getText(),TRespirasi.getText(),TTinggi.getText(),TBerat.getText(),SpO2.getText(),TGCS.getText(),cmbKesadaran.getSelectedItem().toString(),
                                        TKeluhan.getText(),TPemeriksaan.getText(),TAlergi.getText(),LingkarPerut.getText(),TindakLanjut.getText(),TPenilaian.getText(),TInstruksi.getText(),TEvaluasi.getText(),
                                        KdPeg.getText(),TPegawai.getText(),Jabatan.getText()
                                    });
                                    TSuhu.setText("");TTensi.setText("");TNadi.setText("");TRespirasi.setText("");
                                    TTinggi.setText("");TBerat.setText("");TGCS.setText("");TKeluhan.setText("");
                                    TPemeriksaan.setText("");TAlergi.setText("");LingkarPerut.setText("");
                                    TindakLanjut.setText("");TPenilaian.setText("");TInstruksi.setText("");SpO2.setText("");
                                    TEvaluasi.setText("");cmbKesadaran.setSelectedIndex(0);
                                    LCount.setText(""+tabModePemeriksaan.getRowCount());
                            }
                        }else{
                            if(akses.getkode().equals(KdPeg.getText())){
                                if(Sequel.menyimpantf("pemeriksaan_ralan","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",21,new String[]{
                                    TNoRw.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                                    TSuhu.getText(),TTensi.getText(),TNadi.getText(),TRespirasi.getText(),TTinggi.getText(),TBerat.getText(),
                                    SpO2.getText(),TGCS.getText(),cmbKesadaran.getSelectedItem().toString(),TKeluhan.getText(),TPemeriksaan.getText(),TAlergi.getText(),
                                    LingkarPerut.getText(),TindakLanjut.getText(),TPenilaian.getText(),TInstruksi.getText(),TEvaluasi.getText(),KdPeg.getText()})==true){
                                        tabModePemeriksaan.addRow(new Object[]{
                                            false,TNoRw.getText(),TNoRM.getText(),TPasien.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                                            TSuhu.getText(),TTensi.getText(),TNadi.getText(),TRespirasi.getText(),TTinggi.getText(),TBerat.getText(),SpO2.getText(),TGCS.getText(),cmbKesadaran.getSelectedItem().toString(),
                                            TKeluhan.getText(),TPemeriksaan.getText(),TAlergi.getText(),LingkarPerut.getText(),TindakLanjut.getText(),TPenilaian.getText(),TInstruksi.getText(),TEvaluasi.getText(),
                                            KdPeg.getText(),TPegawai.getText(),Jabatan.getText()
                                        });
                                        TSuhu.setText("");TTensi.setText("");TNadi.setText("");TRespirasi.setText("");
                                        TTinggi.setText("");TBerat.setText("");TGCS.setText("");TKeluhan.setText("");
                                        TPemeriksaan.setText("");TAlergi.setText("");LingkarPerut.setText("");
                                        TindakLanjut.setText("");TPenilaian.setText("");TInstruksi.setText("");SpO2.setText("");
                                        TEvaluasi.setText("");cmbKesadaran.setSelectedIndex(0);
                                        LCount.setText(""+tabModePemeriksaan.getRowCount());
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,"Hanya bisa disimpan oleh dokter/petugas yang bersangkutan..!!");
                            }
                        }
                    }
                }
                break;
            case 4:
                if((!TTinggi_uteri.getText().trim().equals(""))||(!TLetak.getText().trim().equals(""))||
                        (!TDenyut.getText().trim().equals(""))||(!TKualitas_mnt.getText().trim().equals(""))||
                        (!TKualitas_dtk.getText().trim().equals(""))||(!TVulva.getText().trim().equals(""))||
                        (!TPortio.getText().trim().equals(""))||(!TTebal.getText().trim().equals(""))||
                        (!TPembukaan.getText().trim().equals(""))||(!TPenurunan.getText().trim().equals(""))||
                        (!TDenominator.getText().trim().equals(""))){
                    if(Sequel.menyimpantf("pemeriksaan_obstetri_ralan","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",23,new String[]{
                        TNoRw.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                        TTinggi_uteri.getText(),cmbJanin.getSelectedItem().toString(),TLetak.getText(),cmbPanggul.getSelectedItem().toString(),TDenyut.getText(),
                        cmbKontraksi.getSelectedItem().toString(),TKualitas_mnt.getText(),TKualitas_dtk.getText(),cmbFluksus.getSelectedItem().toString(),
                        cmbAlbus.getSelectedItem().toString(),TVulva.getText(),TPortio.getText(),cmbDalam.getSelectedItem().toString(),TTebal.getText(),
                        cmbArah.getSelectedItem().toString(),TPembukaan.getText(),TPenurunan.getText(),TDenominator.getText(),cmbKetuban.getSelectedItem().toString(),
                        cmbFeto.getSelectedItem().toString()})==true){
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
                }  
                break;
            case 5:
                if ((!TInspeksi.getText().trim().equals(""))||(!TInspeksiVulva.getText().trim().equals(""))||
                        (!TInspekuloGine.getText().trim().equals(""))||(!TUkuran.getText().trim().equals(""))||
                        (!TPortioInspekulo.getText().trim().equals(""))||(!TSondage.getText().trim().equals(""))||
                        (!TPortioDalam.getText().trim().equals(""))||(!TBentuk.getText().trim().equals(""))||
                        (!TCavumUteri.getText().trim().equals(""))||(!TUkuran.getText().trim().equals(""))||
                        (!TAdnexaKanan.getText().trim().equals(""))||(!TAdnexaKiri.getText().trim().equals(""))||
                        (!TCavumDouglas.getText().trim().equals(""))) {
                    if(Sequel.menyimpantf("pemeriksaan_ginekologi_ralan","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",20, new String[] {
                        TNoRw.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                        TInspeksi.getText(),TInspeksiVulva.getText(),TInspekuloGine.getText(),
                        cmbFluxusGine.getSelectedItem().toString(),cmbFluorGine.getSelectedItem().toString(), TVulvaInspekulo.getText(),
                        TPortioInspekulo.getText(), TSondage.getText(), TPortioDalam.getText(),
                        TBentuk.getText(), TCavumUteri.getText(), cmbMobilitas.getSelectedItem().toString(),
                        TUkuran.getText(), cmbNyeriTekan.getSelectedItem().toString(),
                        TAdnexaKanan.getText(), TAdnexaKiri.getText(), TCavumDouglas.getText()})==true){
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
                }
                break;
            case 6:
                if(akses.getdiagnosa_pasien()==true){
                    panelDiagnosa1.setRM(TNoRw.getText(),TNoRM.getText(),Valid.SetTgl(DTPCari1.getSelectedItem()+""),Valid.SetTgl(DTPCari2.getSelectedItem()+""),"Ralan",TCari.getText().trim());
                    panelDiagnosa1.simpan();
                }
                break;
            case 7:
                if((!KdDok3.getText().trim().equals(""))&&(!TDokter3.getText().trim().equals(""))&&(!Catatan.getText().trim().equals(""))){
                    if(Sequel.menyimpantf("catatan_perawatan","?,?,?,?,?","Data",5,new String[]{
                        Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),
                        TNoRw.getText(),KdDok3.getText(),Catatan.getText()
                    })==true){
                        TabModeCatatan.addRow(new Object[]{
                            false,TNoRw.getText(),TNoRM.getText(),TPasien.getText(),Valid.SetTgl(DTPTgl.getSelectedItem()+""),cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem()+":"+cmbDtk.getSelectedItem(),KdDok3.getText(),TDokter3.getText(),Catatan.getText()
                        });
                        Catatan.setText("");
                        LCount.setText(""+TabModeCatatan.getRowCount());
                    }
                }
                break;
            default:
                break;
        } 
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
    

    /** Tab tambahan Data Operasi Rawat Jalan. */
    private class PanelDataLamaOperasi extends javax.swing.JPanel {
        private final javax.swing.table.DefaultTableModel model;
        private final javax.swing.JTable tabel;

        PanelDataLamaOperasi() {
            setLayout(new java.awt.BorderLayout(5,5));

            model = new javax.swing.table.DefaultTableModel(
                new Object[]{"No.","Tgl. Operasi","No. Rawat","No. RM",
                    "Nama Pasien","Operator 1","Operasi","Mulai",
                    "Selesai","Durasi (menit)","Status Laporan",
                    "Jenis Rawat"}, 0) {
                @Override
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };

            tabel = new javax.swing.JTable(model);
            tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            tabel.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION);
            tabel.setRowHeight(22);

            int[] widths = {45,145,155,75,190,160,220,145,145,110,140,100};
            for (int i=0; i<widths.length; i++) {
                tabel.getColumnModel().getColumn(i)
                    .setPreferredWidth(widths[i]);
            }

            add(new javax.swing.JScrollPane(tabel),
                java.awt.BorderLayout.CENTER);

            javax.swing.JPopupMenu popup = new javax.swing.JPopupMenu();
            javax.swing.JMenuItem laporan =
                new javax.swing.JMenuItem("Ubah Laporan Operasi Pasien");
            laporan.addActionListener(e -> bukaLaporanOperasi());
            popup.add(laporan);
            
            javax.swing.JMenuItem cetak =
                new javax.swing.JMenuItem("Laporan Operasi Pasien");
            cetak.addActionListener(e -> cetakLaporanOperasi());
            popup.add(cetak);
tabel.setComponentPopupMenu(popup);

            tabel.addMouseListener(new java.awt.event.MouseAdapter() {
                private void pilih(java.awt.event.MouseEvent e) {
                    int r = tabel.rowAtPoint(e.getPoint());
                    if (r >= 0) tabel.setRowSelectionInterval(r,r);
                }
                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {
                    if (e.isPopupTrigger()) pilih(e);
                }
                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) {
                    if (e.isPopupTrigger()) pilih(e);
                }
            });

            tampil();
        }

        private void tampil() {
            model.setRowCount(0);

            String sql =
                "SELECT o.no_rawat,o.tgl_operasi,rp.no_rkm_medis," +
                "p.nm_pasien,o.operator1,pg.nama AS nama_operator," +
                "po.nm_perawatan,lo.tanggal AS mulai,lo.selesaioperasi," +
                "CASE WHEN lo.tanggal IS NOT NULL " +
                "AND lo.selesaioperasi IS NOT NULL " +
                "AND lo.selesaioperasi>lo.tanggal " +
                "THEN TIMESTAMPDIFF(MINUTE,lo.tanggal,lo.selesaioperasi) " +
                "ELSE NULL END AS durasi," +
                "CASE WHEN lo.no_rawat IS NULL " +
                "THEN 'Belum ada laporan' " +
                "ELSE 'Sudah ada laporan' END AS status_laporan," +
                "rp.status_lanjut AS jenis_rawat " +
                "FROM operasi o " +
                "INNER JOIN reg_periksa rp ON rp.no_rawat=o.no_rawat " +
                "INNER JOIN pasien p ON p.no_rkm_medis=rp.no_rkm_medis " +
                "LEFT JOIN pegawai pg ON pg.nik=o.operator1 " +
                "LEFT JOIN paket_operasi po ON po.kode_paket=o.kode_paket " +
                "LEFT JOIN laporan_operasi lo " +
                "ON lo.no_rawat=o.no_rawat AND lo.tanggal=o.tgl_operasi " +
                "WHERE rp.no_rkm_medis=? " +
                "ORDER BY o.tgl_operasi DESC,o.no_rawat";

            String noRMMAktif = TNoRM.getText().trim();
            if (noRMMAktif.isEmpty()) return;

            try (java.sql.PreparedStatement psTab =
                    koneksi.prepareStatement(sql)) {
                psTab.setString(1,noRMMAktif);

                try (java.sql.ResultSet r = psTab.executeQuery()) {
                    int no = 0;
                    while (r.next()) {
                        String op = r.getString("nama_operator");
                        if (op == null || op.trim().isEmpty()) {
                            op = r.getString("operator1");
                        }

                        java.sql.Timestamp mulai = r.getTimestamp("mulai");
                        java.sql.Timestamp selesai =
                            r.getTimestamp("selesaioperasi");
                        Object durasi = r.getObject("durasi");

                        model.addRow(new Object[]{
                            ++no,
                            r.getString("tgl_operasi"),
                            r.getString("no_rawat"),
                            r.getString("no_rkm_medis"),
                            r.getString("nm_pasien"),
                            op,
                            r.getString("nm_perawatan"),
                            mulai == null ? "" : mulai.toString(),
                            selesai == null ? "" : selesai.toString(),
                            durasi == null ? "Periksa waktu" : durasi,
                            r.getString("status_laporan"),
                            r.getString("jenis_rawat")
                        });
                    }
                }
            } catch (Exception ex) {
                System.out.println("Notif Data Operasi Rawat Jalan: " + ex);
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Gagal mengambil data operasi:\n" + ex.getMessage(),
                    "Data Operasi",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }

        private void bukaLaporanOperasi() {
            int row = tabel.getSelectedRow();
            if (row < 0) {
                javax.swing.JOptionPane.showMessageDialog(
                    this, "Pilih baris operasi terlebih dahulu.");
                return;
            }

            String noRawat = String.valueOf(tabel.getValueAt(row,2));
            String tanggalOperasi = String.valueOf(tabel.getValueAt(row,1));

            try {
                DlgCariTagihanOperasi form =
                    new DlgCariTagihanOperasi(null,false);
                form.bukaLaporanOperasiDariDataLama(
                    noRawat,tanggalOperasi);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Gagal membuka form Laporan Operasi:\n" + ex.getMessage(),
                    "Laporan Operasi",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
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

    @Override
    public void dispose() {
        executor.shutdownNow();
        if (panelRiwayatPerawatan != null) {
            panelRiwayatPerawatan.dispose();
        }
        super.dispose();
    }
}
