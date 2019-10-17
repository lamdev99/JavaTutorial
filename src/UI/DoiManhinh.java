package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoiManhinh extends JFrame {
    JPanel p1,p2;
    JButton change,exchange;
    public DoiManhinh(){
        p1 = new JPanel();
        p2 = new JPanel();
        change = new JButton("Change");
        exchange = new JButton("Exchange");

        p1.setSize(400,400);
        p2.setSize(400,400);
        p2.setLayout(new FlowLayout());
        p2.add(new JLabel("Day la man hinh 2"));
        p1.add(change);
        p2.add(exchange);

        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                p2.setVisible(true);
                setTitle("Man hinh 2");
            }
        });
        exchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(true);
                p2.setVisible(false);
                setTitle("Man hinh 1");
            }
        });
        add(p1);
        add(p2);
        p2.setVisible(false);
        setTitle("Man hinh 1");
        setSize(400,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new DoiManhinh();
    }
}
