package Tugas;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pasien {
    String nama;
    int umur;
    int nomorAntrian;
    String tanggal;

    public Pasien(String nama, int umur, int nomorAntrian, String tanggal) {
        this.nama = nama;
        this.umur = umur;
        this.nomorAntrian = nomorAntrian;
        this.tanggal = tanggal;
    }

    public String toString() {
        return nama + "," + umur + "," + nomorAntrian + "," + tanggal;
    }

    public static Pasien fromString(String pasienStr) {
        String[] parts = pasienStr.split(",");
        return new Pasien(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]);
    }
}

class AntrianRumahSakit {
    Queue<Pasien> antrianPasien;

    public AntrianRumahSakit() {
        antrianPasien = new LinkedList<>();
    }

    public void tambah(Pasien pasien) {
        antrianPasien.add(pasien);
        System.out.println(pasien.nama + " telah ditambahkan ke antrian.");
    }

    public Pasien keluarkan() {
        return antrianPasien.poll();
    }

    public void tampilkanAntrian() {
        System.out.println("Pasien dalam antrian:");
        if (antrianPasien.isEmpty()) {
            System.out.println("Tidak ada pasien dalam antrian.");
        } else {
            for (Pasien pasien : antrianPasien) {
                System.out.println("Nama: " + pasien.nama + ", Umur: " + pasien.umur + ", Nomor Antrian: " + pasien.nomorAntrian + ", Tanggal: " + pasien.tanggal);
            }
        }
    }

    public void simpanAntrianKeFile(String namaFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(namaFile)))) {
            for (Pasien pasien : antrianPasien) {
                writer.println(pasien);
            }
        }
    }

    public void muatAntrianDariFile(String namaFile) throws IOException {
        antrianPasien.clear();
        try (Scanner fileScanner = new Scanner(new FileReader(namaFile))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                antrianPasien.add(Pasien.fromString(line));
            }
        }
    }
}

