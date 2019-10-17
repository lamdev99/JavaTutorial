package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Login extends JFrame {
    JPanel panel;
    public Login(){
        setTitle("Doulingo");
        init();
        //panel.setBounds(0,0,1000,600);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setLayout(null);
    }
    public void init(){
        panel = new JPanel();
        ImageIcon image  = new ImageIcon(getClass().getResource("bg92.jpg"));
        JLabel label = new JLabel(image);
        panel.add(label);
    }
    public static void main(String[] args) {
        new Login();
    }
}
