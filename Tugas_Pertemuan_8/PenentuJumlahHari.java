package Tugas_Asdos.Tugas_Pertemuan_8;

import javax.swing.*; // Import package untuk GUI
import java.awt.*; // Import package untuk layout
import java.awt.event.ActionEvent; // Import untuk menangani event aksi
import java.awt.event.ActionListener; // Import untuk listener aksi
import java.io.BufferedWriter; // Import untuk menulis file
import java.io.FileWriter; // Import untuk membuat file
import java.io.IOException; // Import untuk menangani exception IO

// Kelas utama untuk aplikasi Penentu Jumlah Hari
public class PenentuJumlahHari extends JFrame implements ActionListener {
    // Deklarasi komponen GUI
    private JTextField tahunField, hasilField; // Field untuk input tahun dan menampilkan hasil
    private JComboBox<String> bulanComboBox; // Dropdown untuk memilih bulan
    private JButton hitungButton, hapusButton, simpanButton, keluarButton; // Tombol aksi

    // Konstruktor untuk mengatur tampilan GUI
    public PenentuJumlahHari() {
        // Set judul dan ukuran window
        setTitle("Penentu Jumlah Hari");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Keluar saat jendela ditutup
        setLayout(new GridBagLayout()); // Menggunakan GridBagLayout untuk tata letak yang fleksibel
        GridBagConstraints gbc = new GridBagConstraints(); // Objek untuk mengatur constraints pada komponen
        gbc.fill = GridBagConstraints.HORIZONTAL; // Mengisi ruang horizontal

        // Membuat dan menambahkan label dan field input untuk tahun
        JLabel tahunLabel = new JLabel("Tahun:"); // Label untuk input tahun
        tahunField = new JTextField(10); // Field input untuk tahun (10 karakter)

        // Membuat label dan dropdown untuk bulan
        JLabel bulanLabel = new JLabel("Bulan:"); // Label untuk dropdown bulan
        
        // Array bulan untuk dropdown
        String[] bulanNames = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        bulanComboBox = new JComboBox<>(bulanNames); // Dropdown untuk memilih bulan
        
        // Membuat label dan field untuk hasil
        JLabel hasilLabel = new JLabel("Jumlah Hari:"); // Label untuk hasil
        hasilField = new JTextField(10); // Field untuk menampilkan hasil
        hasilField.setEditable(false); // Hasil tidak bisa diedit oleh pengguna

        // Membuat tombol untuk aksi
        hitungButton = new JButton("Hitung"); // Tombol untuk menghitung
        hapusButton = new JButton("Hapus"); // Tombol untuk menghapus input
        simpanButton = new JButton("Simpan"); // Tombol untuk menyimpan hasil
        keluarButton = new JButton("Keluar"); // Tombol untuk keluar aplikasi

        // Menambahkan action listener untuk setiap tombol
        hitungButton.addActionListener(this);
        hapusButton.addActionListener(this);
        simpanButton.addActionListener(this);
        keluarButton.addActionListener(this);

        // Menambahkan komponen ke frame menggunakan GridBagLayout
        gbc.gridx = 0; // Kolom
        gbc.gridy = 0; // Baris
        gbc.insets = new Insets(10, 10, 5, 10); // Margin antar komponen
        add(tahunLabel, gbc); // Menambahkan label tahun
        
        gbc.gridx = 1; // Kolom 1
        add(tahunField, gbc); // Menambahkan field input tahun

        gbc.gridx = 0; // Kembali ke kolom 0
        gbc.gridy = 1; // Baris 1
        add(bulanLabel, gbc); // Menambahkan label bulan
        
        gbc.gridx = 1; // Kolom 1
        add(bulanComboBox, gbc); // Menambahkan dropdown bulan

        gbc.gridx = 0; // Kembali ke kolom 0
        gbc.gridy = 2; // Baris 2
        add(hasilLabel, gbc); // Menambahkan label hasil
        
        gbc.gridx = 1; // Kolom 1
        add(hasilField, gbc); // Menambahkan field hasil

        // Menambahkan tombol
        gbc.gridx = 0; // Kembali ke kolom 0
        gbc.gridy = 3; // Baris 3
        gbc.gridwidth = 2; // Tombol menggunakan dua kolom
        gbc.fill = GridBagConstraints.CENTER; // Mengatur tombol di tengah
        add(hitungButton, gbc); // Menambahkan tombol hitung
        
        gbc.gridy = 4; // Baris 4
        add(hapusButton, gbc); // Menambahkan tombol hapus
        
        gbc.gridy = 5; // Baris 5
        add(simpanButton, gbc); // Menambahkan tombol simpan
        
        gbc.gridy = 6; // Baris 6
        add(keluarButton, gbc); // Menambahkan tombol keluar
    }

    // Metode yang menangani aksi tombol
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hitungButton) { // Jika tombol hitung ditekan
            try {
                int tahun = Integer.parseInt(tahunField.getText()); // Mengambil input tahun
                int bulan = bulanComboBox.getSelectedIndex() + 1; // Mendapatkan bulan dari dropdown (indeks + 1)
                HitungHari hitungHari = new HitungHari(tahun, bulan); // Membuat objek HitungHari
                int jumlahHari = hitungHari.hitung(); // Menghitung jumlah hari
                hasilField.setText(String.valueOf(jumlahHari)); // Menampilkan hasil
            } catch (NumberFormatException ex) { // Menangani jika input bukan angka
                JOptionPane.showMessageDialog(this, "Input tidak valid, masukkan angka yang benar."); // Tampilkan pesan kesalahan
            }
        } else if (e.getSource() == hapusButton) { // Jika tombol hapus ditekan
            tahunField.setText(""); // Mengosongkan field tahun
            bulanComboBox.setSelectedIndex(0); // Mengatur dropdown ke bulan pertama
            hasilField.setText(""); // Mengosongkan field hasil
        } else if (e.getSource() == simpanButton) { // Jika tombol simpan ditekan
            String hasil = hasilField.getText(); // Mengambil hasil dari field
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("hasil_jumlah_hari.txt", true))) {
                writer.write("Jumlah hari: " + hasil); // Menulis hasil ke file
                writer.newLine(); // Menambahkan baris baru
                JOptionPane.showMessageDialog(this, "Hasil disimpan ke 'hasil_jumlah_hari.txt'."); // Tampilkan pesan sukses
            } catch (IOException ex) { // Menangani kesalahan IO
                JOptionPane.showMessageDialog(this, "Gagal menyimpan hasil."); // Tampilkan pesan kesalahan
            }
        } else if (e.getSource() == keluarButton) { // Jika tombol keluar ditekan
            System.exit(0); // Keluar dari aplikasi
        }
    }

    // Metode utama untuk menjalankan aplikasi
    public static void main(String[] args) {
        // Menggunakan SwingUtilities untuk menjamin thread keamanan
        SwingUtilities.invokeLater(() -> {
            PenentuJumlahHari app = new PenentuJumlahHari(); // Membuat instance aplikasi
            app.setVisible(true); // Menampilkan aplikasi
        });
    }
}
