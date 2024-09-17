package Tugas_Asdos.Tugas_Pertemuan_3;

// Kelas KonversiSuhu2 adalah subclass dari KonversiSuhu
// Kelas ini mewarisi method dari KonversiSuhu dan menambahkan method baru untuk konversi suhu
public class KonversiSuhu2 extends KonversiSuhu {

    // Method ini mengonversi suhu dari Fahrenheit ke Reamur
    // Langkah pertama adalah mengonversi Fahrenheit ke Celcius menggunakan rumus (Fahrenheit - 32) * 5/9
    // Setelah itu, hasilnya dikonversi ke Reamur dengan rumus Celcius * 4/5
    public double fahrenheitToReamur(double fahrenheit) {
        // Mengonversi Fahrenheit ke Celcius
        double celcius = (fahrenheit - 32) * 5/9; 
        // Mengonversi Celcius ke Reamur
        return celcius * 4/5; 
    }
}


