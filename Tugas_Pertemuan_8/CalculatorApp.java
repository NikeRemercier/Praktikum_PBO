package Tugas_Asdos.Tugas_Pertemuan_8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField display; // Display utama untuk menampilkan ekspresi dan hasil
    private StringBuilder expression; // Variabel untuk menyimpan ekspresi matematika yang diinput
    
    // Konstruktor utama untuk mendesain GUI
    public CalculatorApp() {
        setTitle("Kalkulator Sederhana"); // Judul aplikasi
        setSize(400, 600); // Ukuran jendela aplikasi
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Aplikasi berhenti saat jendela ditutup
        setLayout(new BorderLayout()); // Mengatur layout utama ke BorderLayout

        // Inisialisasi ekspresi sebagai StringBuilder
        expression = new StringBuilder();
        
        // Panel display (bagian atas)
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 30)); // Mengatur font display
        display.setHorizontalAlignment(SwingConstants.RIGHT); // Text rata kanan
        display.setEditable(false); // Display tidak bisa diedit secara langsung
        display.setBackground(Color.BLACK); // Warna background hitam
        display.setForeground(Color.WHITE); // Warna teks putih
        display.setPreferredSize(new Dimension(400, 100)); // Ukuran preferensi display
        add(display, BorderLayout.NORTH); // Menambahkan display ke atas (utara)

        // Panel utama dengan tombol
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Panel untuk tombol angka dan tombol "="
        JPanel numbersPanel = new JPanel(new GridLayout(4, 4, 10, 10)); // Grid 4x4
        numbersPanel.setBackground(new Color(245, 245, 245));

        // Array label tombol untuk angka dan operasi dasar
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Membuat tombol berdasarkan array "buttons"
        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 25)); // Ukuran font tombol
            button.setBackground(new Color(230, 230, 230)); // Warna latar tombol
            button.setForeground(Color.BLACK); // Warna teks tombol
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); // Border tombol
            button.addActionListener(this); // Menambahkan listener untuk aksi tombol
            numbersPanel.add(button); // Menambahkan tombol ke panel angka
        }

        mainPanel.add(numbersPanel, BorderLayout.CENTER); // Tambahkan panel angka ke tengah

        // Panel untuk tombol kontrol (C dan %)
        JPanel controlPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // Grid 1x2
        controlPanel.setBackground(new Color(245, 245, 245));

        // Array tombol kontrol
        String[] controls = {"C", "%"};

        // Membuat tombol kontrol (C dan %)
        for (String label : controls) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 25)); // Ukuran font tombol kontrol
            button.setBackground(new Color(255, 102, 102)); // Warna latar tombol kontrol
            button.setForeground(Color.WHITE); // Warna teks tombol kontrol
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
            button.addActionListener(this); // Listener untuk aksi tombol
            controlPanel.add(button); // Tambahkan tombol kontrol ke panel
        }

        mainPanel.add(controlPanel, BorderLayout.NORTH); // Tambahkan panel kontrol ke atas main panel

        add(mainPanel, BorderLayout.CENTER); // Tambahkan panel utama ke tengah
    }

    // Method untuk menangani aksi tombol
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Dapatkan teks dari tombol yang ditekan

        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            // Jika angka atau titik (.) ditekan, tambahkan ke ekspresi
            expression.append(command);
            display.setText(expression.toString());
        } else if (command.equals("C")) { // Tombol "C" untuk menghapus
            expression.setLength(0); // Hapus ekspresi
            display.setText("");
        } else if (command.equals("%")) { // Tombol "%" untuk persen
            expression.append("/100"); // Tambahkan "/100" ke ekspresi untuk menghitung persen
            display.setText(expression.toString());
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            // Tambahkan operator ke ekspresi
            expression.append(" ").append(command).append(" ");
            display.setText(expression.toString());
        } else if (command.equals("=")) { // Tombol "=" untuk menghitung hasil
            try {
                double result = evaluateExpression(expression.toString());
                display.setText(expression.toString() + " = " + result);
                expression.setLength(0); // Reset ekspresi setelah perhitungan
                expression.append(result); // Simpan hasil perhitungan sebagai awal ekspresi berikutnya
            } catch (Exception ex) {
                display.setText("Error");
                expression.setLength(0);
            }
        }
    }

    // Method untuk mengevaluasi ekspresi aritmatika
    private double evaluateExpression(String expr) {
        String[] tokens = expr.split(" ");
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) { // Jika token adalah angka
                values.push(Double.parseDouble(token));
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) { // Jika token adalah operator
                while (!operators.isEmpty() && hasPrecedence(token.charAt(0), operators.peek())) {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(token.charAt(0));
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    // Method untuk menentukan prioritas operator
    private boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        else return true;
    }

    // Method untuk menerapkan operasi
    private double applyOperation(char operator, double b, double a) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    // Main method untuk menjalankan aplikasi
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorApp calc = new CalculatorApp();
            calc.setVisible(true); // Tampilkan jendela aplikasi
        });
    }
}
