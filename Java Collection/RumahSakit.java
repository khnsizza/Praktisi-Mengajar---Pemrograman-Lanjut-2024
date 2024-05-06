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
        for (Pasien pasien : antrianPasien) {
            System.out.println("Nama: " + pasien.nama + ", Umur: " + pasien.umur);
        }
    }
}

public class RumahSakit {
    public static void main(String[] args) {
        AntrianRumahSakit antrianRumahSakit = new AntrianRumahSakit();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan pasien ke antrian
        System.out.print("Masukkan jumlah pasien yang akan ditambahkan:");
        int jumlahPasien = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        int i = 0;
        while (i < jumlahPasien) {
            System.out.print("Masukkan nama pasien:");
            String nama = scanner.nextLine();
            System.out.print("Masukkan umur pasien:");
            int umur = scanner.nextInt();
            scanner.nextLine();

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

        scanner.close();
    }
}
