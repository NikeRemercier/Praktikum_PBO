package Tugas_Asdos.Tugas_Pertemuan_4;

// Kelas abstrak BangunRuang yang mendefinisikan kerangka umum untuk bangun ruang
// Setiap kelas turunan dari BangunRuang harus mengimplementasikan metode hitungVolume() dan hitungLuasPermukaan()
abstract class BangunRuang {
    // Metode abstrak untuk menghitung volume bangun ruang
    // Harus diimplementasikan oleh kelas turunan
    public abstract double hitungVolume();

    // Metode abstrak untuk menghitung luas permukaan bangun ruang
    // Harus diimplementasikan oleh kelas turunan
    public abstract double hitungLuasPermukaan();
}

// Kelas Balok yang mewarisi (extends) dari BangunRuang
// Kelas ini harus mengimplementasikan metode hitungVolume() dan hitungLuasPermukaan()
class Balok extends BangunRuang {
    // Atribut panjang, lebar, dan tinggi untuk menyimpan dimensi balok
    private double panjang, lebar, tinggi;

    // Konstruktor untuk menginisialisasi panjang, lebar, dan tinggi balok
    public Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    // Implementasi metode hitungVolume() untuk menghitung volume balok
    // Rumus volume balok: panjang * lebar * tinggi
    @Override
    public double hitungVolume() {
        return panjang * lebar * tinggi;
    }

    // Implementasi metode hitungLuasPermukaan() untuk menghitung luas permukaan balok
    // Rumus luas permukaan balok: 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi)
    @Override
    public double hitungLuasPermukaan() {
        return 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
    }
}

// Kelas Kubus yang juga mewarisi (extends) dari BangunRuang
// Kubus juga harus mengimplementasikan metode hitungVolume() dan hitungLuasPermukaan()
class Kubus extends BangunRuang {
    // Atribut sisi untuk menyimpan panjang sisi kubus
    private double sisi;

    // Konstruktor untuk menginisialisasi panjang sisi kubus
    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    // Implementasi metode hitungVolume() untuk menghitung volume kubus
    // Rumus volume kubus: sisi^3 (sisi pangkat tiga)
    @Override
    public double hitungVolume() {
        return Math.pow(sisi, 3); // Menggunakan fungsi Math.pow untuk menghitung pangkat tiga
    }

    // Implementasi metode hitungLuasPermukaan() untuk menghitung luas permukaan kubus
    // Rumus luas permukaan kubus: 6 * (sisi^2) (6 kali sisi pangkat dua)
    @Override
    public double hitungLuasPermukaan() {
        return 6 * Math.pow(sisi, 2); // Menggunakan Math.pow untuk menghitung pangkat dua
    }
}

// Kelas utama yang berfungsi untuk menjalankan program
public class KelasBeraksi {
    public static void main(String[] args) {
        // Membuat objek balok dengan panjang = 3, lebar = 4, dan tinggi = 5
        Balok balok = new Balok(3, 4, 5);

        // Menampilkan hasil volume dan luas permukaan balok
        System.out.println("Volume Balok: " + balok.hitungVolume()); // Volume = 3 * 4 * 5 = 60
        System.out.println("Luas Permukaan Balok: " + balok.hitungLuasPermukaan()); // Luas = 2 * (3 * 4 + 3 * 5 + 4 * 5) = 94

        // Membuat objek kubus dengan sisi = 4
        Kubus kubus = new Kubus(4);

        // Menampilkan hasil volume dan luas permukaan kubus
        System.out.println("Volume Kubus: " + kubus.hitungVolume()); // Volume = 4^3 = 64
        System.out.println("Luas Permukaan Kubus: " + kubus.hitungLuasPermukaan()); // Luas = 6 * 4^2 = 96
    }
}
