package Tugas_Asdos.Tugas_Pertemuan_1;

// Kelas Nilai mewakili data nilai mahasiswa yang memiliki beberapa atribut dan metode.
public class Nilai {
    // Atribut untuk menyimpan data NIM, Nama, dan nilai-nilai komponen.
    String nim;
    String nama;
    double nilaiAbsen;
    double nilaiTugas;
    double nilaiUTS;
    double nilaiUAS;
    // Konstruktor Nilai untuk menginisialisasi objek dengan data yang diberikan.
    public Nilai(String nim, String nama, double nilaiAbsen, double nilaiTugas, double nilaiUTS, double
   nilaiUAS) {
    this.nim = nim;
    this.nama = nama;
    this.nilaiAbsen = nilaiAbsen;
    this.nilaiTugas = nilaiTugas;
    this.nilaiUTS = nilaiUTS;
    this.nilaiUAS = nilaiUAS;
    }
    // Metode cetakNilai untuk menampilkan nilai-nilai dan menghitung nilai akhir berdasarkan bobot.
    public void cetakNilai() {
    // Menghitung nilai akhir berdasarkan bobot masing-masing komponen.
    double nilaiAkhir = (nilaiAbsen * 0.1) + (nilaiTugas * 0.2) + (nilaiUTS * 0.3) + (nilaiUAS * 0.4);
   
    // Menampilkan data mahasiswa dan nilai-nilai yang telah dihitung.
    System.out.println("NIM : " + nim);
    System.out.println("Nama : " + nama);
    System.out.println("Nilai Absen [10%] : " + nilaiAbsen);
    System.out.println("Nilai Tugas [20%] : " + nilaiTugas);
    System.out.println("Nilai UTS [30%] : " + nilaiUTS);
    System.out.println("Nilai UAS [40%] : " + nilaiUAS);
    System.out.println("Nilai Akhir : " + nilaiAkhir);
    }
   }
   // Kelas DemoNilai berfungsi sebagai kelas utama untuk mendemonstrasikan penggunaan kelas Nilai.
   class DemoNilai {
    public static void main(String[] args) {
    // Membuat objek dari kelas Nilai dengan memberikan data NIM, Nama, dan nilai-nilai komponen.
    Nilai nilai = new Nilai("1234567", "Sulthan Fauzan", 85, 90, 80, 88);
    // Memanggil metode cetakNilai untuk menampilkan data dan hasil perhitungan.
    nilai.cetakNilai();
    }
   }