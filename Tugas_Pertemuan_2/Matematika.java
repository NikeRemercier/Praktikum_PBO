package Tugas_Asdos.Tugas_Pertemuan_2;

// Interface yang mendefinisikan operasi matematika
interface OperasiMatematika {
    int pertambahan(int a, int b);  // Mendeklarasikan method untuk pertambahan
    int pengurangan(int a, int b);  // Mendeklarasikan method untuk pengurangan
    int perkalian(int a, int b);    // Mendeklarasikan method untuk perkalian
    int pembagian(int a, int b);    // Mendeklarasikan method untuk pembagian
}

// Kelas Matematika yang mengimplementasikan interface OperasiMatematika
public class Matematika implements OperasiMatematika {

    // Implementasi method pertambahan
    public int pertambahan(int a, int b) {
        return a + b; // Mengembalikan hasil pertambahan dua angka
    }

    // Implementasi method pengurangan
    public int pengurangan(int a, int b) {
        return a - b; // Mengembalikan hasil pengurangan dua angka
    }

    // Implementasi method perkalian
    public int perkalian(int a, int b) {
        return a * b; // Mengembalikan hasil perkalian dua angka
    }

    // Implementasi method pembagian
    public int pembagian(int a, int b) {
        return a / b; // Mengembalikan hasil pembagian dua angka
    }
}

// Kelas MatematikaBeraksi untuk menguji implementasi metode dari kelas Matematika
class MatematikaBeraksi {
    public static void main(String[] args) {
        // Membuat objek dari kelas Matematika
        Matematika matematika = new Matematika();

        // Melakukan operasi aritmatika dan menampilkan hasilnya

        // Menguji pertambahan
        int hasilPertambahan = matematika.pertambahan(20, 10);
        System.out.println("Pertambahan: 20 + 10 = " + hasilPertambahan);

        // Menguji pengurangan
        int hasilPengurangan = matematika.pengurangan(10, 5);
        System.out.println("Pengurangan: 10 - 5 = " + hasilPengurangan);

        // Menguji perkalian
        int hasilPerkalian = matematika.perkalian(10, 3);
        System.out.println("Perkalian: 10 * 3 = " + hasilPerkalian);

        // Menguji pembagian
        int hasilPembagian = matematika.pembagian(20, 2);
        System.out.println("Pembagian: 20 / 2 = " + hasilPembagian);
    }
}