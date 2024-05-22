package guipraktisi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Queue;
import java.util.LinkedList;

public class GUIPraktisi {

    public static void main(String[] args) {
        // Membuat objek Register
        Register rg = new Register ();
        rg.setVisible(true);
        rg.pack();
        rg.setLocationRelativeTo(null);
        rg.setDefaultCloseOperation(Register.EXIT_ON_CLOSE);
      
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Home home = new Home();
                home.setVisible(true);
                home.pack();
                home.setLocationRelativeTo(null);
                home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}