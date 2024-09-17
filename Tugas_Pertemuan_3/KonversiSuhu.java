package Tugas_Asdos.Tugas_Pertemuan_3;

// Kelas KonversiSuhu mendefinisikan dua metode untuk mengonversi suhu dari Celcius ke Fahrenheit dan Reamur
public class KonversiSuhu {
    
    // Method ini mengonversi suhu dari Celcius ke Fahrenheit
    // Rumusnya adalah (Celcius * 9/5) + 32
    public double celciusToFahrenheit(double celcius) {
        return (celcius * 9/5) + 32;
    }

    // Method ini mengonversi suhu dari Celcius ke Reamur
    // Rumusnya adalah Celcius * 4/5
    public double celciusToReamur(double celcius) {
        return celcius * 4/5;
    }
}
