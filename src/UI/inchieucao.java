package UI;

import BaiCuoiKi.Jbutton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class inchieucao extends JFrame {
    JTextField text = new JTextField();
    JButton btn = new JButton("Show");

    public inchieucao() {
        setTitle("Nhap chieu cao va in ra can nang");
        add(new JLabel("Nhap chieu cao:"));
        add(text);
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Ban nang: " + (new Random().nextInt(50) + 40) + "kg",
                        "Can nang ban la" +
                                "", JOptionPane.WARNING_MESSAGE);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 3));
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        new inchieucao();
    }
}
