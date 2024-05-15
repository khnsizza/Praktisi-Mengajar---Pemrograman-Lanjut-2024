package Tugas;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pasien {
    String nama;
    int umur;

    public Pasien(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
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
                System.out.println("Nama: " + pasien.nama + ", Umur: " + pasien.umur);
            }
        }
    }
}

public class RumahSakit {
    public static void main(String[] args) {
        AntrianRumahSakit antrianRumahSakit = new AntrianRumahSakit();
        Scanner scanner = new Scanner(System.in);

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
                    antrianRumahSakit.tambah(null);
                    i++;
                    continue;
                }
                
                int umur = Integer.parseInt(umurInput);
                if (umur <= 0) {
                    throw new ArithmeticException("Umur pasien tidak valid. Umur harus lebih dari 0.");
                }

                antrianRumahSakit.tambah(new Pasien(nama, umur));
                i++;
            }

            // Menampilkan antrian
            antrianRumahSakit.tampilkanAntrian();

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
