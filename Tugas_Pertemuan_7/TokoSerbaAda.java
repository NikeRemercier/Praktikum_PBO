package Tugas_Asdos.Tugas_Pertemuan_7;

import java.util.Scanner; // Mengimpor kelas Scanner untuk input dari pengguna

// Kelas yang merepresentasikan barang
class Barang {
    private String kodeBarang; // Kode barang
    private String namaBarang; // Nama barang
    private int harga; // Harga barang

    // Konstruktor untuk inisialisasi barang
    public Barang(String kodeBarang, String namaBarang, int harga) {
        this.kodeBarang = kodeBarang; // Mengatur kode barang
        this.namaBarang = namaBarang; // Mengatur nama barang
        this.harga = harga; // Mengatur harga barang
    }

    // Getter untuk mendapatkan kode barang
    public String getKodeBarang() {
        return kodeBarang;
    }

    // Getter untuk mendapatkan nama barang
    public String getNamaBarang() {
        return namaBarang;
    }

    // Getter untuk mendapatkan harga barang
    public int getHarga() {
        return harga;
    }
}

// Kelas utama untuk aplikasi Toko Serba Ada
public class TokoSerbaAda {
    private static Barang[] daftarBarang = new Barang[3]; // Daftar barang dengan array tetap

    // Method untuk menginisialisasi barang yang tersedia
    public static void inisialisasiBarang() {
        // Menambahkan barang ke dalam daftar
        daftarBarang[0] = new Barang("a001", "Buku", 3000);
        daftarBarang[1] = new Barang("a002", "Pensil", 4000);
        daftarBarang[2] = new Barang("a003", "Pulpen", 5000);
    }

    public static void main(String[] args) {
        inisialisasiBarang(); // Menginisialisasi daftar barang
        Scanner scanner = new Scanner(System.in); // Membuat scanner untuk input pengguna

        // Menampilkan daftar barang
        System.out.println("\n===========================================");
        System.out.println("            Daftar Barang Toko            ");
        System.out.println("===========================================");
        System.out.printf("%-10s %-20s %-10s\n", "Kode", "Nama Barang", "Harga");
        System.out.println("===========================================");
        for (Barang barang : daftarBarang) {
            // Menampilkan setiap barang dalam daftar
            System.out.printf("%-10s %-20s %-10d\n", barang.getKodeBarang(), barang.getNamaBarang(), barang.getHarga());
        }
        System.out.println("===========================================\n");

        String[][] struk = new String[10][6]; // Menyimpan struk pembelian (maksimal 10 item)
        int totalPembayaran = 0; // Total pembayaran
        int itemCount = 0; // Jumlah item yang dibeli

        // Meminta pengguna memasukkan jumlah item barang yang ingin dibeli
        int jumlahItem = 0;
        while (true) {
            System.out.print("Masukkan jumlah item barang yang ingin dibeli: ");
            if (scanner.hasNextInt()) { // Memeriksa apakah input adalah angka
                jumlahItem = scanner.nextInt(); // Membaca input jumlah item
                if (jumlahItem > 0 && jumlahItem <= 10) { // Batasi maksimum 10 item
                    break; // Keluar dari loop jika input valid
                } else {
                    System.out.println("Jumlah item harus antara 1 dan 10. Silakan coba lagi.");
                }
            } else {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                scanner.next(); // Mengonsumsi input yang salah
            }
        }
        scanner.nextLine(); // Mengonsumsi newline

        // Loop untuk membeli barang sesuai jumlah yang dimasukkan
        for (int i = 0; i < jumlahItem; i++) {
            System.out.println("\nData ke-" + (i + 1) + ":");
            String kode = "";
            while (true) {
                System.out.print("Masukkan kode barang: ");
                kode = scanner.nextLine(); // Input kode barang

                // Mencari barang berdasarkan kode
                Barang barangDipilih = null;
                for (Barang barang : daftarBarang) {
                    if (barang.getKodeBarang().equalsIgnoreCase(kode)) {
                        barangDipilih = barang; // Menyimpan barang yang dipilih
                        break; // Keluar dari loop jika barang ditemukan
                    }
                }

                // Jika barang tidak ditemukan
                if (barangDipilih == null) {
                    System.out.println("Barang dengan kode " + kode + " tidak ditemukan. Silakan coba lagi.");
                } else {
                    // Meminta jumlah beli
                    int jumlahBeli = 0;
                    while (true) {
                        System.out.print("Masukkan jumlah beli: ");
                        if (scanner.hasNextInt()) { // Memeriksa apakah input adalah angka
                            jumlahBeli = scanner.nextInt(); // Membaca input jumlah beli
                            if (jumlahBeli > 0) {
                                scanner.nextLine(); // Mengonsumsi newline
                                break; // Keluar dari loop jika input valid
                            } else {
                                System.out.println("Jumlah beli harus lebih dari 0. Silakan coba lagi.");
                            }
                        } else {
                            System.out.println("Input tidak valid. Silakan masukkan angka.");
                            scanner.next(); // Mengonsumsi input yang salah
                        }
                    }

                    // Menghitung total bayar untuk item ini
                    int totalBayar = barangDipilih.getHarga() * jumlahBeli;

                    // Menyimpan data struk pembelian
                    struk[itemCount][0] = String.valueOf(itemCount + 1); // Nomor urut item
                    struk[itemCount][1] = barangDipilih.getKodeBarang(); // Kode barang
                    struk[itemCount][2] = barangDipilih.getNamaBarang(); // Nama barang
                    struk[itemCount][3] = String.valueOf(barangDipilih.getHarga()); // Harga barang
                    struk[itemCount][4] = String.valueOf(jumlahBeli); // Jumlah beli
                    struk[itemCount][5] = String.valueOf(totalBayar); // Total bayar untuk item ini
                    itemCount++; // Menaikkan jumlah item yang dibeli

                    // Menambahkan total pembayaran
                    totalPembayaran += totalBayar; // Menambahkan total bayar ke total pembayaran

                    System.out.println("Barang berhasil ditambahkan ke struk.");
                    break; // Keluar dari loop setelah barang berhasil ditambahkan
                }
            }
        }

        // Menampilkan struk pembelian
        System.out.println("\nStruk Pembelian:");
        System.out.println("===========================================");
        System.out.printf("%-5s %-10s %-20s %-10s %-10s %-10s\n", "No", "Kode", "Nama Barang", "Harga", "Jumlah", "Jumlah Bayar");
        System.out.println("===========================================");
        for (int i = 0; i < itemCount; i++) {
            // Menampilkan setiap item dalam struk
            System.out.printf("%-5s %-10s %-20s %-10s %-10s %-10s\n", struk[i][0], struk[i][1], struk[i][2], struk[i][3], struk[i][4], struk[i][5]);
        }
        System.out.println("===========================================\n");

        // Menampilkan total pembayaran
        System.out.printf("Total Pembayaran: Rp %,d\n", totalPembayaran); // Menampilkan total pembayaran dengan format
        System.out.println("===========================================\n");
        scanner.close(); // Menutup scanner untuk mencegah kebocoran sumber daya
    }
}
