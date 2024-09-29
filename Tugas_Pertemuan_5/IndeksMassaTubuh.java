package Tugas_Asdos.Tugas_Pertemuan_5;

import java.util.Scanner;

public class IndeksMassaTubuh {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk menerima input dari pengguna
        Scanner input = new Scanner(System.in);

        // Meminta pengguna memasukkan berat badan dalam kilogram
        System.out.print("Masukkan berat badan (kg): ");
        // Menyimpan input berat badan ke variabel beratBadan
        double beratBadan = input.nextDouble();

        // Meminta pengguna memasukkan tinggi badan dalam meter
        System.out.print("Masukkan tinggi badan (meter): ");
        // Menyimpan input tinggi badan ke variabel tinggiBadan
        double tinggiBadan = input.nextDouble();

        // Menghitung IMT berdasarkan rumus IMT = Berat Badan (kg) / (Tinggi Badan (m) x Tinggi Badan (m))
        double IMT = beratBadan / (tinggiBadan * tinggiBadan);

        // Deklarasi variabel untuk menyimpan kriteria IMT
        String kriteria;

        // Menentukan kriteria berdasarkan nilai IMT
        if (IMT <= 18.4) {
            kriteria = "Berat Badan Kurang";
        } else if (IMT >= 18.5 && IMT <= 24.9) {
            kriteria = "Berat Badan Ideal";
        } else if (IMT >= 25 && IMT <= 29.9) {
            kriteria = "Berat Badan Lebih";
        } else if (IMT >= 30 && IMT <= 39.9) {
            kriteria = "Gemuk";
        } else {
            kriteria = "Sangat Gemuk";
        }

        // Menampilkan hasil IMT dan kriteria ke layar
        System.out.println("\n=== Hasil Perhitungan IMT ===");
        System.out.println("IMT Anda: " + IMT);
        System.out.println("Kriteria: " + kriteria);

        // Menutup Scanner untuk mencegah kebocoran resource
        input.close();
    }
}
