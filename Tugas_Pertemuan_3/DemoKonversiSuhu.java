package Tugas_Asdos.Tugas_Pertemuan_3;

// Kelas DemoKonversiSuhu digunakan untuk menguji semua method dari KonversiSuhu dan KonversiSuhu2
public class DemoKonversiSuhu {
    public static void main(String[] args) {
        // Membuat objek dari kelas KonversiSuhu2
        // Karena KonversiSuhu2 mewarisi KonversiSuhu, objek ini dapat memanggil semua method dari kedua kelas
        KonversiSuhu2 konversi = new KonversiSuhu2();

        // Mendefinisikan nilai suhu dalam Celcius
        double celcius = 100;
        // Mengonversi suhu dari Celcius ke Fahrenheit menggunakan method celciusToFahrenheit dari kelas KonversiSuhu
        System.out.println(celcius + " Celcius ke Fahrenheit: " + konversi.celciusToFahrenheit(celcius));
        
        // Mengonversi suhu dari Celcius ke Reamur menggunakan method celciusToReamur dari kelas KonversiSuhu
        System.out.println(celcius + " Celcius ke Reamur: " + konversi.celciusToReamur(celcius));

        // Mendefinisikan nilai suhu dalam Fahrenheit
        double fahrenheit = 212;
        // Mengonversi suhu dari Fahrenheit ke Reamur menggunakan method fahrenheitToReamur dari kelas KonversiSuhu2
        System.out.println(fahrenheit + " Fahrenheit ke Reamur: " + konversi.fahrenheitToReamur(fahrenheit));
    }
}