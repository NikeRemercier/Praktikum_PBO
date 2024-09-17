package Tugas_Asdos.Tugas_Pertemuan_2;

// Kelas Bingo untuk mencetak lirik lagu
public class Bingo {

    // Konstruktor
    public Bingo() {
        // Memanggil method printLyrics saat objek Bingo dibuat
        printLyrics();
    }

    // Method untuk mencetak lirik lagu Bingo dengan logika tepuk tangan
    private void printLyrics() {
        String dogName = "BINGO"; // Nama anjing
        String clap = "(clap)";   // Representasi tepuk tangan

        // Loop untuk mengurangi satu huruf nama anjing setiap iterasi
        for (int i = 0; i <= dogName.length(); i++) {
            // Mencetak bagian awal dari lirik
            System.out.println("There was a farmer who had a dog,");
            System.out.println("And " + dogName + " was his name-o.");
            
            // Loop untuk mencetak baris B-I-N-G-O atau (clap) sesuai jumlah huruf yang dihilangkan
            for (int j = 0; j < 3; j++) {
                // Loop untuk menggantikan huruf dengan tepukan sesuai dengan indeks
                for (int k = 0; k < i; k++) {
                    System.out.print(clap + "-");
                }
                // Mencetak sisa nama anjing
                System.out.println(dogName.substring(i));
            }

            // Mencetak bagian akhir dari lirik
            System.out.println("And " + dogName + " was his name-o.");
            System.out.println();  // Baris kosong untuk pemisah antar bait
        }
    }

    // Method main untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek Bingo yang secara otomatis mencetak lirik melalui konstruktor
        new Bingo();
    }
}
