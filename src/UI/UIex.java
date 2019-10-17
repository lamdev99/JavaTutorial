package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIex extends JFrame {
    JTextField edit;
    JTextArea kq;
    JButton btn;
    public UIex(){
        edit = new JTextField();
        kq = new JTextArea();
        btn = new JButton("Show");


        edit.setBounds(0,50,100,50);
        kq.setEditable(false);
        btn.setBounds(0,200,100,50);
        kq.setBounds(200,100,300,200);
        setLayout(null);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sangNT(Integer.parseInt(edit.getText().toString()));
            }
        });
        add(edit);
        add(btn);
        add(kq);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void sangNT(int n){

    }
    public static void main(String[] args) {
        new UIex();
    }
}
