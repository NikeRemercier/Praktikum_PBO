package Tugas_Asdos.Tugas_Pertemuan_6;

import java.util.Scanner;

public class TabelPerkalian {

    public static void main(String[] args) {
        // Membuat scanner untuk input dari pengguna
        Scanner scanner = new Scanner(System.in);
        int n;

        // Melakukan perulangan hingga pengguna memasukkan nilai yang benar (<= 10)
        do {
            // Meminta pengguna memasukkan nilai n
            System.out.print("Masukkan nilai n (maksimal 10): ");
            n = scanner.nextInt();

            // Memeriksa apakah nilai n lebih besar dari 10
            if (n > 10) {
                System.out.println("Nilai n tidak boleh lebih besar dari 10. Silakan coba lagi.");
            }

        } while (n > 10); // Perulangan akan terus berlanjut jika n > 10

        // Mencetak tabel perkalian n x n
        System.out.println("\nTabel Perkalian " + n + " x " + n + ":");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // Menampilkan hasil perkalian i * j
                System.out.print(i * j + "\t");
            }
            // Baris baru setelah mencetak setiap baris tabel
            System.out.println();
        }

        // Menutup scanner
        scanner.close();
    }
}
