package Tugas_Asdos.Tugas_Pertemuan_9;

// Mengimpor kelas yang dibutuhkan untuk GUI dan tabel
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Kelas untuk merepresentasikan data mahasiswa
class Mahasiswa {
    private String nim;       // Nomor Induk Mahasiswa
    private String nama;      // Nama mahasiswa
    private String alamat;    // Alamat mahasiswa
    private String mataKuliah; // Nama mata kuliah
    private double nilai1;    // Nilai 1 (10%)
    private double nilai2;    // Nilai 2 (15%)
    private double nilai3;    // Nilai 3 (25% - UTS)
    private double nilai4;    // Nilai 4 (15%)
    private double nilai5;    // Nilai 5 (35%)

    // Konstruktor untuk inisialisasi data mahasiswa
    public Mahasiswa(String nim, String nama, String alamat, String mataKuliah,
                     double nilai1, double nilai2, double nilai3, double nilai4, double nilai5) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.mataKuliah = mataKuliah;
        this.nilai1 = nilai1;
        this.nilai2 = nilai2;
        this.nilai3 = nilai3;
        this.nilai4 = nilai4;
        this.nilai5 = nilai5;
    }

    // Metode untuk menghitung nilai akhir berdasarkan bobot
    public double hitungNilaiAkhir() {
        return (nilai1 * 0.1) + (nilai2 * 0.15) + (nilai3 * 0.25) + (nilai4 * 0.15) + (nilai5 * 0.35);
    }

    // Metode untuk mengkonversi data mahasiswa ke dalam array untuk ditampilkan di tabel
    public Object[] toArray() {
        return new Object[]{nim, nama, alamat, mataKuliah, hitungNilaiAkhir()};
    }
}

// Kelas utama untuk aplikasi GUI
public class InputMahasiswa {
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>(); // List untuk menyimpan data mahasiswa
    private JTextField txtNIM, txtNama, txtAlamat, txtMataKuliah, txtNilai1, txtNilai2, txtUTS, txtNilai4, txtNilai5; // Field input
    private JTable mahasiswaTable; // Tabel untuk menampilkan data mahasiswa
    private DefaultTableModel model; // Model tabel

    // Konstruktor untuk mengatur komponen GUI
    public InputMahasiswa() {
        JFrame frame = new JFrame("Input Data Mahasiswa"); // Judul frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Menutup aplikasi saat frame ditutup
        frame.setSize(500, 400); // Ukuran frame
        frame.setLayout(new BorderLayout()); // Layout menggunakan BorderLayout

        // Panel untuk input data mahasiswa
        JPanel inputPanel = new JPanel(new GridLayout(9, 2, 5, 5)); // GridLayout dengan 9 baris dan 2 kolom
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Memberikan jarak pada panel

        // Inisialisasi field input
        txtNIM = new JTextField();
        txtNama = new JTextField();
        txtAlamat = new JTextField();
        txtMataKuliah = new JTextField();
        txtNilai1 = new JTextField();
        txtNilai2 = new JTextField();
        txtUTS = new JTextField();
        txtNilai4 = new JTextField();
        txtNilai5 = new JTextField();

        // Menambahkan label dan field input ke panel
        inputPanel.add(new JLabel("NIM:"));
        inputPanel.add(txtNIM);
        inputPanel.add(new JLabel("Nama:"));
        inputPanel.add(txtNama);
        inputPanel.add(new JLabel("Alamat:"));
        inputPanel.add(txtAlamat);
        inputPanel.add(new JLabel("Mata Kuliah:"));
        inputPanel.add(txtMataKuliah);
        inputPanel.add(new JLabel("Nilai 1 (10%):"));
        inputPanel.add(txtNilai1);
        inputPanel.add(new JLabel("Nilai 2 (15%):"));
        inputPanel.add(txtNilai2);
        inputPanel.add(new JLabel("Nilai UTS (25%):"));
        inputPanel.add(txtUTS);
        inputPanel.add(new JLabel("Nilai 4 (15%):"));
        inputPanel.add(txtNilai4);
        inputPanel.add(new JLabel("Nilai 5 (35%):"));
        inputPanel.add(txtNilai5);

        // Tabel untuk menampilkan data mahasiswa
        String[] columnNames = {"NIM", "Nama", "Alamat", "Mata Kuliah", "Nilai Akhir"}; // Nama kolom
        model = new DefaultTableModel(columnNames, 0); // Model tabel dengan kolom yang sudah ditentukan
        mahasiswaTable = new JTable(model); // Tabel untuk menampilkan data
        mahasiswaTable.setRowHeight(20); // Mengatur tinggi baris tabel
        // Mengatur lebar kolom tabel
        mahasiswaTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        mahasiswaTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        mahasiswaTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        mahasiswaTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        mahasiswaTable.getColumnModel().getColumn(4).setPreferredWidth(75);
        
        // Scroll pane untuk tabel agar bisa di-scroll
        JScrollPane scrollPane = new JScrollPane(mahasiswaTable);

        // Tombol Simpan dan Hapus
        JButton btnSimpan = new JButton("Simpan"); // Tombol untuk menyimpan data
        JButton btnHapus = new JButton("Hapus");   // Tombol untuk menghapus data
        btnSimpan.setPreferredSize(new Dimension(80, 25)); // Ukuran tombol
        btnHapus.setPreferredSize(new Dimension(80, 25));

        // Action listener untuk tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Mengambil data dari input dan membuat objek Mahasiswa
                    Mahasiswa mahasiswa = new Mahasiswa(
                            txtNIM.getText(),
                            txtNama.getText(),
                            txtAlamat.getText(),
                            txtMataKuliah.getText(),
                            Double.parseDouble(txtNilai1.getText()),
                            Double.parseDouble(txtNilai2.getText()),
                            Double.parseDouble(txtUTS.getText()),
                            Double.parseDouble(txtNilai4.getText()),
                            Double.parseDouble(txtNilai5.getText())
                    );

                    // Menambahkan mahasiswa ke daftar dan model tabel
                    daftarMahasiswa.add(mahasiswa);
                    model.addRow(mahasiswa.toArray()); // Menambahkan baris ke tabel
                    clearInputFields(); // Mengosongkan field input setelah menyimpan
                } catch (NumberFormatException ex) {
                    // Menampilkan pesan error jika input tidak valid
                    JOptionPane.showMessageDialog(frame, "Masukkan nilai yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action listener untuk tombol Hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = mahasiswaTable.getSelectedRow(); // Mendapatkan baris yang dipilih
                if (selectedRow != -1) {
                    daftarMahasiswa.remove(selectedRow); // Menghapus dari daftar mahasiswa
                    model.removeRow(selectedRow); // Menghapus dari tabel
                } else {
                    // Menampilkan pesan peringatan jika tidak ada baris yang dipilih
                    JOptionPane.showMessageDialog(frame, "Pilih baris yang ingin dihapus!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Menambahkan komponen ke frame
        frame.add(inputPanel, BorderLayout.NORTH); // Menambahkan panel input di bagian atas
        frame.add(scrollPane, BorderLayout.CENTER); // Menambahkan tabel di tengah
        JPanel buttonPanel = new JPanel(); // Panel untuk tombol
        buttonPanel.add(btnSimpan); // Menambahkan tombol Simpan
        buttonPanel.add(btnHapus); // Menambahkan tombol Hapus
        frame.add(buttonPanel, BorderLayout.SOUTH); // Menambahkan panel tombol di bagian bawah

        // Mengatur tampilan frame
        frame.setLocationRelativeTo(null); // Memusatkan frame di layar
        frame.setVisible(true); // Menampilkan frame
    }

    // Metode untuk mengosongkan field input
    private void clearInputFields() {
        txtNIM.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtMataKuliah.setText("");
        txtNilai1.setText("");
        txtNilai2.setText("");
        txtUTS.setText("");
        txtNilai4.setText("");
        txtNilai5.setText("");
    }

    // Metode utama untuk menjalankan aplikasi
    public static void main(String[] args) {
        SwingUtilities.invokeLater(InputMahasiswa::new); // Menjalankan aplikasi di thread yang aman
    }
}
