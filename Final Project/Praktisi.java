package praktisi;

import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Praktisi<T> { // Membuat kelas Praktisi menjadi generik
    private Queue<T> queue; //menyimpan nama pelanggan dalam antrian
    private static final String FILE_NAME = "queue.txt";

    public Praktisi() {
        queue = new LinkedList<>();
        loadQueueFromFile(); //Memuat antrian dari berkas saat objek praktisi dibuat
    }

    public void addCustomer(T customer) {
        if (customer == null || customer.toString().isEmpty()) {
            throw new IllegalArgumentException("Nama pelanggan tidak boleh kosong");
        }
        queue.add(customer);
        saveQueueToFile(); // Menyimpan antrian yang diperbarui ke berkas
    }

    public T serveCustomer() {
        T servedCustomer = queue.poll(); // Menghapus dan mengembalikan pelanggan didepan antrian
        saveQueueToFile(); //Menyimpan antrian yang telah diperbarui ke berkas
        return servedCustomer;
    }

    public int getQueueSize() {
        return queue.size(); // Mengembalikan jumlah pelanggan dalam antrian
    }

    public T peekNextCustomer() {
        return queue.peek(); //Melihat pelanggan berikutnya tanpa mengeluarkan dari antrian
    }

    public boolean isEmpty() {
        return queue.isEmpty(); //Memeriksa apakah antrian kosong 
    }

    private void saveQueueToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (T customer : queue) {
                writer.write(customer.toString());
                writer.newLine(); //Menulis setiap pelanggan dalam antrian file
            }
            System.out.println("Queue successfully saved to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Failed to save queue to file: " + e.getMessage());
            e.printStackTrace(); //Menangani kesalahan saat menyimpan ke berkas
        }
    }

    private void loadQueueFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String customer;
            while ((customer = reader.readLine()) != null) {
                queue.add((T) customer); // Meng-casting string ke tipe T, Membaca setiap baris dari file & menambahkan ke antrian
            }
            System.out.println("Queue successfully loaded from " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Failed to load queue from file: " + e.getMessage());
            e.printStackTrace(); // Mengangani kesalahan saat memuat dari berkas
        }
    }
}
