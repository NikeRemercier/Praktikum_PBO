package Tugas_Asdos.Tugas_Pertemuan_5;

import java.util.Scanner;

public class PotonganPembelian {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk menerima input dari pengguna
        Scanner input = new Scanner(System.in);

        // Meminta pengguna untuk memasukkan total pembelian
        System.out.print("Masukkan total pembelian (Rp.): ");
        // Menyimpan input total pembelian ke variabel totalPembelian
        double totalPembelian = input.nextDouble();

        // Deklarasi variabel untuk menyimpan jumlah potongan
        double potongan;

        // Mengecek apakah total pembelian kurang dari Rp. 50.000
        if (totalPembelian < 50000) {
            // Jika benar, potongan sebesar 5% dari total pembelian
            potongan = 0.05 * totalPembelian;
        } else {
            // Jika total pembelian Rp. 50.000 atau lebih, potongan sebesar 20%
            potongan = 0.2 * totalPembelian;
        }

        // Menghitung jumlah yang harus dibayarkan setelah potongan
        double totalBayar = totalPembelian - potongan;

        // Menampilkan hasil perhitungan ke layar
        System.out.println("\n=== Hasil Perhitungan ===");
        // Menampilkan total pembelian yang diinput oleh pengguna
        System.out.println("Total pembelian Rp. " + totalPembelian);
        // Menampilkan besarnya potongan yang dihitung berdasarkan total pembelian
        System.out.println("Besarnya potongan Rp. " + potongan);
        // Menampilkan jumlah akhir yang harus dibayarkan (setelah dipotong)
        System.out.println("Jumlah yang harus dibayarkan Rp. " + totalBayar);

        // Menutup Scanner untuk mencegah kebocoran resource
        input.close();
    }
}
