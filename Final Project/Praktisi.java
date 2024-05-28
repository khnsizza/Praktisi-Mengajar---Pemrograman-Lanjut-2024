package praktisi;

import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Praktisi<T> { // Membuat kelas Praktisi menjadi generik
    private Queue<T> antrian; // Menyimpan nama pelanggan dalam antrian
    private static final String NAMA_BERKAS = "antrian.txt";

    public Praktisi() {
        antrian = new LinkedList<>();
        muatAntrianDariBerkas(); // Memuat antrian dari berkas saat objek praktisi dibuat
    }

    public void tambahPelanggan(T pelanggan) {
        if (pelanggan == null || pelanggan.toString().isEmpty()) {
            throw new IllegalArgumentException("Nama pelanggan tidak boleh kosong");
        }
        antrian.add(pelanggan);
        simpanAntrianKeBerkas(); // Menyimpan antrian yang diperbarui ke berkas
    }

    public T layaniPelanggan() {
        T pelangganDilayani = antrian.poll(); // Menghapus dan mengembalikan pelanggan di depan antrian
        simpanAntrianKeBerkas(); // Menyimpan antrian yang telah diperbarui ke berkas
        return pelangganDilayani;
    }

    public int jumlahAntrian() {
        return antrian.size(); // Mengembalikan jumlah pelanggan dalam antrian
    }

    public T lihatPelangganBerikutnya() {
        return antrian.peek(); // Melihat pelanggan berikutnya tanpa mengeluarkan dari antrian
    }

    public boolean antrianKosong() {
        return antrian.isEmpty(); // Memeriksa apakah antrian kosong
    }

    private void simpanAntrianKeBerkas() {
        try (BufferedWriter penulis = new BufferedWriter(new FileWriter(NAMA_BERKAS))) {
            for (T pelanggan : antrian) {
                penulis.write(pelanggan.toString());
                penulis.newLine(); // Menulis setiap pelanggan dalam antrian ke berkas
            }
            System.out.println("Antrian berhasil disimpan ke " + NAMA_BERKAS);
        } catch (IOException e) {
            System.err.println("Gagal menyimpan antrian ke berkas: " + e.getMessage());
            e.printStackTrace(); // Menangani kesalahan saat menyimpan ke berkas
        }
    }

    private void muatAntrianDariBerkas() {
        try (BufferedReader pembaca = new BufferedReader(new FileReader(NAMA_BERKAS))) {
            String pelanggan;
            while ((pelanggan = pembaca.readLine()) != null) {
                antrian.add((T) pelanggan); // Meng-casting string ke tipe T, Membaca setiap baris dari berkas dan menambahkan ke antrian
            }
            System.out.println("Antrian berhasil dimuat dari " + NAMA_BERKAS);
        } catch (IOException e) {
            System.err.println("Gagal memuat antrian dari berkas: " + e.getMessage());
            e.printStackTrace(); // Menangani kesalahan saat memuat dari berkas
        }
    }
}
