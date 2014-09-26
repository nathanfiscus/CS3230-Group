package Lab7;

import java.awt.*;
import javax.swing.*;


public class Lab7 extends JFrame{
    public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
           @Override
           public void run() {
               JFrame mainFrame = new Lab7();
               mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
               mainFrame.pack();
               mainFrame.setVisible(true);
           }
       });


    }
}
