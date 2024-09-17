package Tugas_Asdos.Tugas_Pertemuan_1;

// Kelas Mahasiswa mendefinisikan tiga metode dasar yang mewakili aktivitas mahasiswa.
public class Mahasiswa {
 // Metode membaca yang akan menampilkan status ketika mahasiswa membaca.
 public void membaca() {
 System.out.println("Mahasiswa sedang membaca buku.");
 }
 // Metode nyontek yang akan menampilkan status ketika mahasiswa menyontek.
 public void nyontek() {
 System.out.println("Mahasiswa sedang menyontek saat ujian.");
 }
 // Metode modifikasi yang akan menampilkan status ketika mahasiswa memodifikasi tugas.
 public void modifikasi() {
 System.out.println("Mahasiswa sedang memodifikasi tugas.");
 }
}
// Kelas MahasiswaBeraksi adalah kelas utama yang akan menjalankan program.
class MahasiswaBeraksi {
 public static void main(String[] args) {
 // Membuat objek dari kelas Mahasiswa
 Mahasiswa mahasiswa = new Mahasiswa();
 // Memanggil metode membaca() dari objek mahasiswa
 mahasiswa.membaca();
 // Memanggil metode nyontek() dari objek mahasiswa
 mahasiswa.nyontek();
 // Memanggil metode modifikasi() dari objek mahasiswa
 mahasiswa.modifikasi();
 }
}
