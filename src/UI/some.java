package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class some extends JFrame implements ActionListener {
    JButton btn;
    JTextField number;
    JTextArea kq;
    public some(){
        btn = new JButton("Click");
        number = new JTextField();
        kq = new JTextArea();
        setLayout(null);
        btn.setBounds(50,200,100,50);
        number.setBounds(50,100,200,50);
        kq.setBounds(300,100,200,200);
        add(btn);add(kq);add(number);

        btn.addActionListener(this);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new some();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s =  number.getText();
        int n = Integer.parseInt(s);
        int[] d = new int[n+5];
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(d[i]==0){
                for(int j = 2; j <= n/i; j++){
                    d[i*j] = 1;
                }
            }
        }
        for(int i = 2; i < n; i++)
            if(d[i]==0){
                kq.append(i+",");
            }
    }
}
