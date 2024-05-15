package Latihan;

import java.io.File;
import java.io.IOException;

class Eksepsi1 {
    public static void main(String[] args) {
        try {
            File test = new File("c:\\test.txt");
            test.createNewFile();
        } catch (IOException e) {
            System.out.println("IO Exception sudah ditangani");
        }
    }
}
