package UI;

import javax.swing.*;
import java.awt.*;

public class Mainclass extends JFrame {
    public Mainclass(){

        JComboBox cbb = new JComboBox();
        cbb.addItem("Male");
        cbb.addItem("Female");
        setLayout(new FlowLayout());

        setSize(500,500);
        add(cbb);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Mainclass();
    }
}
