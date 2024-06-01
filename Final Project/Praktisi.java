package praktisi;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Praktisi {
    private Queue<String> Antrian; // Menyimpan nama pelanggan dalam antrian
    private static final String NAMA_BERKAS = "Antrian.txt";

    public Praktisi() {
        Antrian = new LinkedList<>();
        muatAntrianDariBerkas(); // Memuat antrian dari berkas saat objek praktisi dibuat
    }

    public void tambahPelanggan(String pelanggan) {
        if (pelanggan == null || pelanggan.isEmpty()) {
            throw new IllegalArgumentException("Nama pelanggan tidak boleh kosong");
        }
        Antrian.add(pelanggan);
        System.out.println("Pelanggan ditambahkan: " + pelanggan);
        simpanAntrianKeBerkas(); // Menyimpan antrian yang diperbarui ke berkas
    }

    public String layaniPelanggan() {
        String pelangganDilayani = Antrian.poll(); // Menghapus dan mengembalikan pelanggan di depan antrian
        if (pelangganDilayani != null) {
            System.out.println("Melayani pelanggan: " + pelangganDilayani);
        } else {
            System.out.println("Tidak ada pelanggan untuk dilayani.");
        }
        simpanAntrianKeBerkas(); // Menyimpan antrian yang telah diperbarui ke berkas
        return pelangganDilayani;
    }

    public int jumlahAntrian() {
        return Antrian.size(); // Mengembalikan jumlah pelanggan dalam antrian
    }

    public String lihatPelangganBerikutnya() {
        return Antrian.peek(); // Melihat pelanggan berikutnya tanpa mengeluarkan dari antrian
    }

    public boolean antrianKosong() {
        return Antrian.isEmpty(); // Memeriksa apakah antrian kosong
    }

    private void simpanAntrianKeBerkas() {
        try (BufferedWriter penulis = new BufferedWriter(new FileWriter(NAMA_BERKAS))) {
            for (String pelanggan : Antrian) {
                penulis.write(pelanggan);
                penulis.newLine(); // Menulis setiap pelanggan dalam antrian ke berkas
            }
            penulis.flush(); // Memastikan semua data telah ditulis
            System.out.println("Antrian berhasil disimpan ke " + NAMA_BERKAS);
        } catch (IOException e) {
            System.err.println("Gagal menyimpan antrian ke berkas: " + e.getMessage());
            e.printStackTrace(); // Menangani kesalahan saat menyimpan ke berkas
        }
    }

    private void muatAntrianDariBerkas() {
        File file = new File(NAMA_BERKAS);
        if (!file.exists()) {
            System.out.println("File " + NAMA_BERKAS + " tidak ditemukan. Antrian dimulai dari kosong");
            return;
        }
        try (BufferedReader pembaca = new BufferedReader(new FileReader(NAMA_BERKAS))) {
            String line;
            while ((line = pembaca.readLine()) != null) {
                Antrian.add(line); // Membaca setiap baris dari berkas dan menambahkan ke antrian
            }
            System.out.println("Antrian berhasil dimuat dari " + NAMA_BERKAS);
        } catch (IOException e) {
            System.err.println("Gagal memuat antrian dari berkas: " + e.getMessage());
            e.printStackTrace(); // Menangani kesalahan saat memuat dari berkas
        }
    }

    public Iterable<String> getAntrian() {
        return Antrian; // Mengembalikan iterable dari antrian
    }
}
