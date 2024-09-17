package Tugas_Asdos.Tugas_Pertemuan_3;
import Tugas_Asdos.Tugas_Pertemuan_2.Matematika;

// Class Matematika2 yang merupakan inherit dari Matematika
public class Matematika2 extends Matematika {
    // Menambahkan method modulus untuk menghitung sisa bagi
    public int modulus(int a, int b) {
        return a % b;
    }
}

// Class untuk memanggil semua method dari Matematika dan Matematika2
class MatematikaInheritance {
    public static void main(String[] args) {
        // Membuat objek dari Matematika2
        Matematika2 matematika2 = new Matematika2();

        // Memanggil method dari class Matematika
        System.out.println("Pertambahan: " + matematika2.pertambahan(20, 10));
        System.out.println("Pengurangan: " + matematika2.pengurangan(20, 10));
        System.out.println("Perkalian: " + matematika2.perkalian(20, 10));
        System.out.println("Pembagian: " + matematika2.pembagian(20, 10));

        // Memanggil method modulus dari class Matematika2
        System.out.println("Modulus: " + matematika2.modulus(20, 6));
    }
}