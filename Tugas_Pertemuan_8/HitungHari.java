package Tugas_Asdos.Tugas_Pertemuan_8; 
import java.util.Calendar; // Mengimpor kelas Calendar untuk manipulasi tanggal

// Kelas HitungHari untuk menghitung jumlah hari dalam bulan tertentu
public class HitungHari {
    private int tahun; // Variabel untuk menyimpan tahun
    private int bulan; // Variabel untuk menyimpan bulan

    // Konstruktor untuk inisialisasi tahun dan bulan
    public HitungHari(int tahun, int bulan) {
        this.tahun = tahun; // Menetapkan nilai tahun
        this.bulan = bulan; // Menetapkan nilai bulan
    }

    // Metode untuk menghitung jumlah hari dalam bulan yang ditentukan
    public int hitung() {
        // Menggunakan objek Calendar untuk mendapatkan informasi tanggal
        Calendar calendar = Calendar.getInstance(); // Membuat instance Calendar
        calendar.set(Calendar.YEAR, tahun); // Mengatur tahun pada objek Calendar
        calendar.set(Calendar.MONTH, bulan - 1); // Mengatur bulan (bulan dimulai dari 0)

        // Mengembalikan jumlah hari maksimum dalam bulan yang telah diatur
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
