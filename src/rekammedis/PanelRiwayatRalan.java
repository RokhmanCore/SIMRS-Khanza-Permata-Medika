package rekammedis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicLong;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/** Read-only cross-visit history with a shared visit selector for all history tabs. */
public final class PanelRiwayatRalan extends JPanel {
    private static final int PAGE_SIZE = 10;

    private final Connection connection;
    private final ExecutorService loader = Executors.newSingleThreadExecutor();
    private final AtomicLong requestSequence = new AtomicLong();
    private final PanelRiwayatSoap historyRalan;
    private final PanelRiwayatSoap historyRanap;
    private final JPanel historyHost = new JPanel(new BorderLayout());
    private final JLabel patientInfo = new JLabel("No. R.M.: -", SwingConstants.LEFT);
    private final JLabel selectedInfo = new JLabel("Pilih No. Rawat untuk melihat riwayat.", SwingConstants.LEFT);
    private final JLabel status = new JLabel("", SwingConstants.LEFT);
    private final JTextField search = new JTextField();
    private final JComboBox<String> visitType = new JComboBox<>(new String[]{"Semua", "Rawat Jalan", "Rawat Inap"});
    private final JButton loadMore = new JButton("Muat kunjungan lebih lama");
    private final DefaultTableModel tableModel;
    private final JTable visitsTable;
    private final Timer searchTimer;
    private final List<Visit> visits = new ArrayList<>();
    private volatile String activeNoRawat = "";
    private String selectedNoRawat = "";
    private String searchTerm = "";
    private String visitTypeFilter = "Semua";
    private boolean historyRalanSelected;
    private int nextOffset;
    private boolean hasMore;
    private boolean loading;
    private boolean updatingTable;

    public PanelRiwayatRalan(Connection connection) {
        this(connection, true);
    }

    /** Creates the shared history panel using outpatient or inpatient categories. */
    public PanelRiwayatRalan(Connection connection, boolean rawatJalan) {
        this.connection = connection;
        this.historyRalan = new PanelRiwayatSoap(connection, loader, false, false, true);
        this.historyRanap = new PanelRiwayatSoap(connection, loader, false, true, false);
        this.historyRalanSelected = rawatJalan;
        historyHost.add(rawatJalan ? historyRalan : historyRanap, BorderLayout.CENTER);
        setLayout(new BorderLayout(0, 5));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(210, 225, 217)));

        JPanel header = new JPanel(new BorderLayout(6, 0));
        header.setOpaque(false);
        JLabel title = new JLabel("RIWAYAT PASIEN");
        title.setFont(new Font("Tahoma", Font.BOLD, 12));
        title.setForeground(new Color(30, 80, 70));
        JLabel readOnly = new JLabel("HANYA BACA", SwingConstants.CENTER);
        readOnly.setFont(new Font("Tahoma", Font.BOLD, 9));
        readOnly.setForeground(new Color(34, 112, 76));
        readOnly.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(191, 222, 204)),
                BorderFactory.createEmptyBorder(3, 5, 3, 5)));
        header.add(title, BorderLayout.WEST);
        header.add(readOnly, BorderLayout.EAST);

        patientInfo.setFont(new Font("Tahoma", Font.PLAIN, 10));
        patientInfo.setBorder(BorderFactory.createEmptyBorder(3, 2, 5, 2));
        selectedInfo.setFont(new Font("Tahoma", Font.BOLD, 10));
        selectedInfo.setBorder(BorderFactory.createEmptyBorder(4, 2, 4, 2));
        status.setFont(new Font("Tahoma", Font.PLAIN, 9));
        status.setForeground(new Color(105, 122, 112));

        tableModel = new DefaultTableModel(new Object[]{"Tanggal", "No. Rawat", "Jenis Kunjungan", "Poli", "Data"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        visitsTable = new JTable(tableModel);
        visitsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        visitsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        visitsTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
        visitsTable.setRowHeight(22);
        visitsTable.setDefaultRenderer(Object.class, new fungsi.WarnaTable());
        TableColumn dateColumn = visitsTable.getColumnModel().getColumn(0);
        dateColumn.setPreferredWidth(78);
        TableColumn noRawatColumn = visitsTable.getColumnModel().getColumn(1);
        noRawatColumn.setPreferredWidth(140);
        TableColumn typeColumn = visitsTable.getColumnModel().getColumn(2);
        typeColumn.setPreferredWidth(92);
        TableColumn poliColumn = visitsTable.getColumnModel().getColumn(3);
        poliColumn.setPreferredWidth(105);
        visitsTable.removeColumn(visitsTable.getColumnModel().getColumn(4));
        visitsTable.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (event.getValueIsAdjusting() || updatingTable) {
                return;
            }
            int selectedRow = visitsTable.getSelectedRow();
            if (selectedRow >= 0) {
                int modelRow = visitsTable.convertRowIndexToModel(selectedRow);
                Visit visit = (Visit) tableModel.getValueAt(modelRow, 4);
                selectVisit(visit);
            }
        });

        search.setFont(new Font("Tahoma", Font.PLAIN, 10));
        search.setToolTipText("Cari tanggal, poli, dokter, atau No. Rawat");
        search.setColumns(14);
        search.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent event) { scheduleSearch(); }
            @Override public void removeUpdate(DocumentEvent event) { scheduleSearch(); }
            @Override public void changedUpdate(DocumentEvent event) { scheduleSearch(); }
        });
        searchTimer = new Timer(350, event -> {
            searchTerm = search.getText().trim();
            loadPage(0, true);
        });
        searchTimer.setRepeats(false);
        visitType.setFont(new Font("Tahoma", Font.PLAIN, 10));
        visitType.setToolTipText("Filter riwayat berdasarkan jenis layanan");
        visitType.addActionListener(event -> {
            Object selected = visitType.getSelectedItem();
            visitTypeFilter = selected == null ? "Semua" : selected.toString();
            selectedNoRawat = "";
            selectedInfo.setText("Memuat riwayat " + visitTypeFilter.toLowerCase() + "...");
            currentHistory().setNoRawat("");
            loadPage(0, true);
        });

        loadMore.setFont(new Font("Tahoma", Font.PLAIN, 10));
        loadMore.setFocusPainted(false);
        loadMore.addActionListener(event -> {
            if (!loading && hasMore) {
                loadPage(nextOffset, false);
            }
        });

        JPanel selector = new JPanel(new BorderLayout(0, 3));
        selector.setOpaque(false);
        selector.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 225, 217)),
                BorderFactory.createEmptyBorder(6, 7, 6, 7)));
        selector.setMinimumSize(new Dimension(220, 180));
        JPanel searchControls = new JPanel(new BorderLayout(0, 4));
        searchControls.setOpaque(false);
        JPanel searchRow = new JPanel(new BorderLayout(6, 0));
        searchRow.setOpaque(false);
        JLabel choose = new JLabel("Cari:");
        choose.setFont(new Font("Tahoma", Font.BOLD, 10));
        searchRow.add(choose, BorderLayout.WEST);
        searchRow.add(search, BorderLayout.CENTER);
        JPanel typeRow = new JPanel(new BorderLayout(6, 0));
        typeRow.setOpaque(false);
        JLabel typeLabel = new JLabel("Jenis kunjungan:");
        typeLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        typeRow.add(typeLabel, BorderLayout.WEST);
        typeRow.add(visitType, BorderLayout.CENTER);
        searchControls.add(searchRow, BorderLayout.NORTH);
        searchControls.add(typeRow, BorderLayout.SOUTH);
        selector.add(searchControls, BorderLayout.NORTH);
        JScrollPane visitScroll = new JScrollPane(visitsTable);
        visitScroll.setBorder(BorderFactory.createLineBorder(new Color(224, 234, 228)));
        visitScroll.setPreferredSize(new Dimension(360, 260));
        selector.add(visitScroll, BorderLayout.CENTER);
        JPanel bottom = new JPanel(new BorderLayout(4, 0));
        bottom.setOpaque(false);
        bottom.add(status, BorderLayout.CENTER);
        bottom.add(loadMore, BorderLayout.EAST);
        selector.add(bottom, BorderLayout.SOUTH);

        JPanel top = new JPanel(new BorderLayout(0, 2));
        top.setOpaque(false);
        top.setBorder(BorderFactory.createEmptyBorder(5, 6, 3, 6));
        top.add(header, BorderLayout.NORTH);
        top.add(patientInfo, BorderLayout.CENTER);
        add(top, BorderLayout.NORTH);

        JPanel detail = new JPanel(new BorderLayout(0, 4));
        detail.setOpaque(false);
        detail.setMinimumSize(new Dimension(360, 180));
        detail.add(selectedInfo, BorderLayout.NORTH);
        detail.add(historyHost, BorderLayout.CENTER);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, selector, detail);
        split.setBorder(null);
        split.setDividerSize(7);
        split.setContinuousLayout(true);
        split.setResizeWeight(0.30);
        add(split, BorderLayout.CENTER);
        SwingUtilities.invokeLater(() -> split.setDividerLocation(0.30));
    }

    public void setOperationEditHandler(PanelRiwayatSoap.OperationEditHandler handler) {
        historyRalan.setOperationEditHandler(handler);
        historyRanap.setOperationEditHandler(handler);
    }

    private void scheduleSearch() {
        searchTimer.restart();
    }

    /** Sets the active visit; its exact no_rawat is selected by default. */
    public void setNoRawat(String noRawat) {
        String normalized = noRawat == null ? "" : noRawat.trim();
        if (normalized.equals(activeNoRawat)) {
            return;
        }
        activeNoRawat = normalized;
        selectedNoRawat = normalized;
        searchTimer.stop();
        search.setText("");
        searchTerm = "";
        nextOffset = 0;
        hasMore = false;
        loading = false;
        visits.clear();
        renderVisits();
        if (normalized.isEmpty()) {
            patientInfo.setText("No. R.M.: -");
            selectedInfo.setText("Pilih No. Rawat untuk melihat riwayat.");
            status.setText("");
            loadMore.setEnabled(false);
            currentHistory().setNoRawat("");
            return;
        }
        selectedInfo.setText("No. Rawat dipilih: " + normalized + " · Kunjungan aktif");
        patientInfo.setText("Memuat identitas pasien...");
        status.setText("Memuat kunjungan...");
        loadMore.setEnabled(false);
        currentHistory().setNoRawat(normalized);
        loadPage(0, true);
    }

    private void loadPage(int offset, boolean reset) {
        if (activeNoRawat.isEmpty() || loader.isShutdown()) {
            return;
        }
        final String requestNoRawat = activeNoRawat;
        final String requestSearch = searchTerm;
        final String requestVisitType = visitTypeFilter;
        final long request = requestSequence.incrementAndGet();
        loading = true;
        if (reset) {
            visits.clear();
            nextOffset = 0;
            hasMore = false;
            renderVisits();
        }
        status.setText(requestSearch.isEmpty() ? "Memuat kunjungan..." : "Mencari kunjungan...");
        loadMore.setEnabled(false);
        try {
            loader.submit(() -> {
                List<Visit> page = new ArrayList<>();
                String error = null;
                String sql = "select rp.no_rawat,rp.no_rkm_medis,p.nm_pasien,rp.tgl_registrasi,rp.jam_reg,rp.status_lanjut,"
                        + "coalesce(po.nm_poli,'') as poli,coalesce(d.nm_dokter,'') as dokter "
                        + "from reg_periksa rp inner join pasien p on rp.no_rkm_medis=p.no_rkm_medis "
                        + "left join poliklinik po on rp.kd_poli=po.kd_poli "
                        + "left join dokter d on rp.kd_dokter=d.kd_dokter "
                        + "where rp.no_rkm_medis=(select r.no_rkm_medis from reg_periksa r where r.no_rawat=?) "
                        + "and (?='Semua' or (?='Rawat Jalan' and rp.status_lanjut='Ralan') "
                        + "or (?='Rawat Inap' and rp.status_lanjut='Ranap')) "
                        + "and (?='' or rp.no_rawat like ? or date_format(rp.tgl_registrasi,'%d-%m-%Y') like ? "
                        + "or po.nm_poli like ? or d.nm_dokter like ?) "
                        + "order by (rp.no_rawat=?) desc,rp.tgl_registrasi desc,rp.jam_reg desc "
                        + "limit ? offset ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    String like = "%" + requestSearch + "%";
                    statement.setString(1, requestNoRawat);
                    statement.setString(2, requestVisitType);
                    statement.setString(3, requestVisitType);
                    statement.setString(4, requestVisitType);
                    statement.setString(5, requestSearch);
                    statement.setString(6, like);
                    statement.setString(7, like);
                    statement.setString(8, like);
                    statement.setString(9, like);
                    statement.setString(10, requestNoRawat);
                    statement.setInt(11, PAGE_SIZE);
                    statement.setInt(12, offset);
                    try (ResultSet result = statement.executeQuery()) {
                        while (result.next()) {
                            page.add(new Visit(result.getString("no_rawat"), result.getString("no_rkm_medis"),
                                    result.getString("nm_pasien"), formatDate(result.getString("tgl_registrasi")),
                                    result.getString("jam_reg"), result.getString("poli"),
                                    result.getString("dokter"), result.getString("status_lanjut")));
                        }
                    }
                } catch (Exception exception) {
                    error = "Daftar kunjungan tidak dapat dimuat. Periksa koneksi database.";
                    System.out.println("Notifikasi riwayat rawat jalan: " + exception.getClass().getSimpleName());
                }
                final List<Visit> loaded = page;
                final String loadError = error;
                SwingUtilities.invokeLater(() -> {
                    if (requestSequence.get() != request || !activeNoRawat.equals(requestNoRawat)
                            || loader.isShutdown()) {
                        return;
                    }
                    loading = false;
                    if (loadError != null) {
                        status.setText(loadError);
                        loadMore.setEnabled(false);
                        return;
                    }
                    if (offset == 0 && loaded.isEmpty()) {
                        selectedInfo.setText("Tidak ada kunjungan " + requestVisitType.toLowerCase() + " untuk pasien ini.");
                        currentHistory().setNoRawat("");
                    }
                    if (!loaded.isEmpty() && offset == 0) {
                        patientInfo.setText("No. R.M.: " + loaded.get(0).noRm + " · " + loaded.get(0).patientName);
                    }
                    visits.addAll(loaded);
                    nextOffset = offset + loaded.size();
                    hasMore = loaded.size() == PAGE_SIZE;
                    if (offset == 0 && !requestSearch.isEmpty()) {
                        status.setText(loaded.size() + " hasil untuk pencarian ini.");
                    } else if (requestSearch.isEmpty()) {
                        status.setText("Menampilkan " + visits.size() + " kunjungan terbaru.");
                    } else {
                        status.setText("Menampilkan " + visits.size() + " hasil pencarian.");
                    }
                    loadMore.setText(requestSearch.isEmpty()
                            ? "Muat kunjungan lebih lama" : "Muat hasil berikutnya");
                    loadMore.setEnabled(hasMore);
                    if (offset == 0 && selectedNoRawat.isEmpty() && !loaded.isEmpty()) {
                        selectedNoRawat = loaded.get(0).noRawat;
                        setHistoryForVisit(loaded.get(0));
                    } else if (offset == 0 && requestSearch.isEmpty() && !loaded.isEmpty()
                            && !containsNoRawat(loaded, selectedNoRawat)
                            && !containsNoRawat(visits, selectedNoRawat)) {
                        selectedNoRawat = loaded.get(0).noRawat;
                        setHistoryForVisit(loaded.get(0));
                        selectedInfo.setText("No. Rawat dipilih: " + selectedNoRawat + " · "
                                + loaded.get(0).visitType() + " · Kunjungan terbaru");
                    }
                    renderVisits();
                });
            });
        } catch (RejectedExecutionException ignored) {
            loading = false;
        }
    }

    private String formatDate(String sqlDate) {
        if (sqlDate == null || sqlDate.trim().isEmpty()) {
            return "";
        }
        try {
            return new SimpleDateFormat("dd-MM-yyyy").format(Date.valueOf(sqlDate));
        } catch (IllegalArgumentException exception) {
            return sqlDate;
        }
    }

    private boolean containsNoRawat(List<Visit> candidates, String noRawat) {
        for (Visit visit : candidates) {
            if (visit.noRawat.equals(noRawat)) {
                return true;
            }
        }
        return false;
    }

    private void renderVisits() {
        updatingTable = true;
        tableModel.setRowCount(0);
        int selectedRow = -1;
        for (Visit visit : visits) {
            int row = tableModel.getRowCount();
            tableModel.addRow(new Object[]{visit.date, visit.noRawat, visit.visitType(), visit.poli, visit});
            if (visit.noRawat.equals(selectedNoRawat)) {
                selectedRow = row;
            }
        }
        visitsTable.clearSelection();
        if (selectedRow >= 0) {
            int viewRow = visitsTable.convertRowIndexToView(selectedRow);
            visitsTable.getSelectionModel().setSelectionInterval(viewRow, viewRow);
        }
        updatingTable = false;
    }

    private void selectVisit(Visit visit) {
        if (visit.noRawat.equals(selectedNoRawat)) {
            return;
        }
        selectedNoRawat = visit.noRawat;
        selectedInfo.setText("No. Rawat dipilih: " + visit.noRawat + " · " + visit.visitType() + " · " + visit.date);
        setHistoryForVisit(visit);
        renderVisits();
    }

    public void dispose() {
        requestSequence.incrementAndGet();
        searchTimer.stop();
        loader.shutdownNow();
        historyRalan.dispose();
        historyRanap.dispose();
    }

    private PanelRiwayatSoap currentHistory() {
        return historyRalanSelected ? historyRalan : historyRanap;
    }

    private void setHistoryForVisit(Visit visit) {
        boolean selectRalan = visit.isRawatJalan();
        if (historyRalanSelected != selectRalan) {
            historyHost.removeAll();
            historyRalanSelected = selectRalan;
            historyHost.add(currentHistory(), BorderLayout.CENTER);
            historyHost.revalidate();
            historyHost.repaint();
        }
        currentHistory().setNoRawat(visit.noRawat);
    }

    private static final class Visit {
        private final String noRawat;
        private final String noRm;
        private final String patientName;
        private final String date;
        private final String time;
        private final String poli;
        private final String doctor;
        private final String statusLanjut;

        private Visit(String noRawat, String noRm, String patientName, String date,
                String time, String poli, String doctor, String statusLanjut) {
            this.noRawat = value(noRawat);
            this.noRm = value(noRm);
            this.patientName = value(patientName);
            this.date = value(date);
            this.time = value(time);
            this.poli = value(poli);
            this.doctor = value(doctor);
            this.statusLanjut = value(statusLanjut);
        }

        private boolean isRawatJalan() {
            return "Ralan".equalsIgnoreCase(statusLanjut);
        }

        private String visitType() {
            return isRawatJalan() ? "Rawat Jalan" : "Rawat Inap";
        }

        private static String value(String text) {
            return text == null ? "" : text;
        }
    }
}
