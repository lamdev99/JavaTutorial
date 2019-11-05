package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class testJva  extends JFrame {
    JTextField text;
    JTextArea area;
    JButton btn;
    public testJva(){
        init();
        text.setBounds(0,0,100,50);
        area.setBounds(100,200,200,100);
        btn.setBounds(0,200,50,50);
        add(text);
        add(area);
        add(btn);
        setSize(600,400);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.append(text.getText());
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    public void init(){
        area = new JTextArea();
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        text = new JTextField();
        btn = new JButton("Show");
    }
    public static void main(String[] args) {
        new testJva();
    }
}
