package Tugas_Asdos.Tugas_Pertemuan_6;

public class Main {

    public static void main(String[] args) {
        // a. Menghitung deret bilangan prima dan bukan dari 0-20
        System.out.println("a. Deret bilangan prima dan bukan dari 0-20:");
        // Menggunakan perulangan for untuk memeriksa bilangan dari 0 hingga 20
        for (int i = 0; i <= 20; i++) {
            // Memanggil fungsi adalahPrima untuk mengecek apakah bilangan i adalah prima
            if (adalahPrima(i)) {
                System.out.println(i + " adalah bilangan prima."); // Jika prima
            } else {
                System.out.println(i + " bukan bilangan prima."); // Jika bukan prima
            }
        }

        // b. Menghitung deret bilangan ganjil dan genap dari 0-20
        System.out.println("\nb. Deret bilangan ganjil dan genap dari 0-20:");
        int bilangan = 0;
        // Menggunakan perulangan while untuk memeriksa bilangan dari 0 hingga 20
        while (bilangan <= 20) {
            // Mengecek apakah bilangan genap (jika habis dibagi 2)
            if (bilangan % 2 == 0) {
                System.out.println(bilangan + " adalah bilangan genap.");
            } else {
                // Jika tidak habis dibagi 2, maka bilangan tersebut ganjil
                System.out.println(bilangan + " adalah bilangan ganjil.");
            }
            bilangan++; // Menaikkan nilai bilangan setiap iterasi
        }

        // c. Menampilkan huruf Z-A
        System.out.println("\nc. Huruf Z-A:");
        char huruf = 'Z'; // Inisialisasi huruf mulai dari Z
        // Menggunakan perulangan do-while untuk menampilkan huruf dari Z ke A
        do {
            System.out.print(huruf + " "); // Menampilkan huruf saat ini
            huruf--; // Mengurangi huruf ke huruf sebelumnya
        } while (huruf >= 'A'); // Lanjutkan hingga huruf menjadi A
        System.out.println(); // Baris baru setelah selesai

        // d. Lagu “Anak Ayam Turun N”
        System.out.println("\nd. Lagu Anak Ayam Turun N:");
        int anakAyam = 10; // Memulai jumlah anak ayam dari 10
        // Menggunakan perulangan do-while untuk menampilkan lirik lagu
        do {
            // Jika jumlah anak ayam lebih dari 1
            if (anakAyam > 1) {
                System.out.println("Anak ayam turun " + anakAyam + ", mati satu tinggal " + (anakAyam - 1));
            } else {
                // Jika anak ayam tinggal 1, maka tinggal induknya
                System.out.println("Anak ayam turun 1, mati satu tinggal induknya");
            }
            anakAyam--; // Mengurangi jumlah anak ayam setiap iterasi
        } while (anakAyam > 0); // Lanjutkan hingga anak ayam habis (0)
    }

    // Fungsi untuk mengecek apakah sebuah bilangan adalah bilangan prima
    // Sebuah bilangan prima adalah bilangan yang hanya bisa dibagi oleh 1 dan dirinya sendiri
    public static boolean adalahPrima(int angka) {
        // Bilangan kurang dari atau sama dengan 1 bukan bilangan prima
        if (angka <= 1) {
            return false;
        }
        // Mengecek apakah ada pembagi dari 2 hingga akar dari bilangan tersebut
        for (int i = 2; i <= Math.sqrt(angka); i++) {
            // Jika bilangan tersebut habis dibagi i, maka bukan prima
            if (angka % i == 0) {
                return false;
            }
        }
        // Jika tidak ditemukan pembagi, maka bilangan tersebut prima
        return true;
    }
}

