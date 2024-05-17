package Latihan;
import java.io.File;

public class latihan1 {
 
       public static void main(String args[]) {
           File dir1=new File("Folder1");
           System.out.println(dir1.mkdir());
           File file1= new File(dir1,"File1.txt");
           System.out.println(file1.getPath());
           System.out.println(dir1.isDirectory());
       }
    }

