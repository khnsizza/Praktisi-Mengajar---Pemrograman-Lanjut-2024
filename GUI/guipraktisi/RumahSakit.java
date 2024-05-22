/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guipraktisi;

/**
 *
 * @author Khansa
 */

 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class RumahSakit {



    public static void main(String[] args) {
        AntrianRumahSakit antrianRumahSakit = new AntrianRumahSakit();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

       
        try {
            antrianRumahSakit.muatAntrianDariFile("antrian.txt");
            System.out.println("Antrian berhasil dimuat dari file.");
        } catch (IOException e) {
            System.out.println("Gagal memuat antrian dari file: " + e.getMessage());
        }

        try {
            // Menambahkan pasien ke antrian
            System.out.print("Masukkan jumlah pasien yang akan ditambahkan:");
            int jumlahPasien = Integer.parseInt(scanner.nextLine());

            int i = 0;
            while (i < jumlahPasien) {
                System.out.print("Masukkan nama pasien:");
                String nama = scanner.nextLine();
                System.out.print("Masukkan umur pasien:");
                String umurInput = scanner.nextLine();

                if (umurInput.isEmpty()) {
                    continue;
                }

                int umur = Integer.parseInt(umurInput);
                if (umur <= 0) {
                    throw new ArithmeticException("Umur pasien tidak valid. Umur harus lebih dari 0.");
                }

                String tanggal = formatter.format(new Date());
                int nomorAntrian = antrianRumahSakit.antrianPasien.size() + 1;

                antrianRumahSakit.tambah(new Pasien(nama, umur, nomorAntrian, tanggal));
                i++;
            }

            // Menampilkan antrian
            antrianRumahSakit.tampilkanAntrian();

            // Simpan antrian ke file
            try {
                antrianRumahSakit.simpanAntrianKeFile("antrian.txt");
                System.out.println("Antrian berhasil disimpan ke file.");
            } catch (IOException e) {
                System.out.println("Gagal menyimpan antrian ke file: " + e.getMessage());
            }

            // Memproses antrian
            for (i = 0; i < jumlahPasien; i++) {
                Pasien pasien = antrianRumahSakit.keluarkan();
                if (pasien != null) {
                    System.out.println(pasien.nama + " telah dikeluarkan dari antrian.");
                } else {
                    System.out.println("Antrian kosong.");
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Jumlah pasien harus berupa angka.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}



