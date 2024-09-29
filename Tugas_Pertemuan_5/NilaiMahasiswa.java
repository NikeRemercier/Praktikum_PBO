package Tugas_Asdos.Tugas_Pertemuan_5;

import java.util.Scanner;

public class NilaiMahasiswa {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk menerima input dari pengguna
        Scanner input = new Scanner(System.in);

        // Meminta pengguna memasukkan NPM
        System.out.print("NPM: ");
        // Menyimpan input NPM ke variabel npm
        String npm = input.nextLine();
        
        // Meminta pengguna memasukkan Nama Mahasiswa
        System.out.print("Nama Mahasiswa: ");
        // Menyimpan input Nama Mahasiswa ke variabel nama
        String nama = input.nextLine();
        
        // Meminta pengguna memasukkan nilai kehadiran
        System.out.print("Nilai Kehadiran: ");
        // Menyimpan input nilai kehadiran ke variabel nilaiKehadiran
        double nilaiKehadiran = input.nextDouble();
        
        // Meminta pengguna memasukkan nilai tugas
        System.out.print("Nilai Tugas: ");
        // Menyimpan input nilai tugas ke variabel nilaiTugas
        double nilaiTugas = input.nextDouble();
        
        // Meminta pengguna memasukkan nilai UTS
        System.out.print("Nilai UTS: ");
        // Menyimpan input nilai UTS ke variabel nilaiUTS
        double nilaiUTS = input.nextDouble();
        
        // Meminta pengguna memasukkan nilai UAS
        System.out.print("Nilai UAS: ");
        // Menyimpan input nilai UAS ke variabel nilaiUAS
        double nilaiUAS = input.nextDouble();
        
        // Menghitung nilai akhir berdasarkan rumus yang diberikan
        // Rumusnya adalah (10% dari Nilai Kehadiran) + (20% dari Nilai Tugas) + 
        // (30% dari Nilai UTS) + (40% dari Nilai UAS)
        double nilaiAkhir = (0.1 * nilaiKehadiran) + (0.2 * nilaiTugas) + (0.3 * nilaiUTS) + (0.4 * nilaiUAS);

        // Deklarasi variabel untuk grade dan keterangan berdasarkan nilai akhir
        String grade;
        String keterangan;

        // Menentukan grade dan keterangan berdasarkan rentang nilai akhir
        if (nilaiAkhir >= 76) {
            // Jika nilai akhir >= 76, maka grade A dengan keterangan "ISTIMEWA"
            grade = "A";
            keterangan = "ISTIMEWA";
        } else if (nilaiAkhir >= 66) {
            // Jika nilai akhir antara 66 dan 75, maka grade B dengan keterangan "BAIK"
            grade = "B";
            keterangan = "BAIK";
        } else if (nilaiAkhir >= 56) {
            // Jika nilai akhir antara 56 dan 65, maka grade C dengan keterangan "CUKUP"
            grade = "C";
            keterangan = "CUKUP";
        } else if (nilaiAkhir >= 46) {
            // Jika nilai akhir antara 46 dan 55, maka grade D dengan keterangan "KURANG"
            grade = "D";
            keterangan = "KURANG";
        } else {
            // Jika nilai akhir < 46, maka grade E dengan keterangan "KURANG SEKALI"
            grade = "E";
            keterangan = "KURANG SEKALI";
        }

        // Menampilkan hasil perhitungan nilai mahasiswa ke layar
        System.out.println("\n=== Hasil Perhitungan Nilai ===");
        // Menampilkan NPM mahasiswa yang diinput pengguna
        System.out.println("NPM Mahasiswa    : " + npm);
        // Menampilkan Nama mahasiswa yang diinput pengguna
        System.out.println("Nama Mahasiswa   : " + nama);
        // Menampilkan nilai rata-rata (nilai akhir) yang sudah dihitung
        System.out.println("Nilai Rata-rata  : " + nilaiAkhir);
        // Menampilkan grade berdasarkan nilai akhir
        System.out.println("Grade            : " + grade);
        // Menampilkan keterangan berdasarkan grade
        System.out.println("Keterangan       : " + keterangan);

        // Menutup Scanner untuk mencegah kebocoran resource
        input.close();
    }
}
