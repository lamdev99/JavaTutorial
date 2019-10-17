package Doulingo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenPratice extends JFrame {
    JPanel panel;
    JButton add;
    JTextField tanh,tviet;
    JLabel eng,vie;
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    public ScreenPratice(){

    }
    public void init(){
        panel = new JPanel();
        ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));
        JLabel label = new JLabel(image);
        label.setBounds(0,0,1000,600);

        table = new JTable(model);
        model.addColumn("English");
        model.addColumn("VietNam");
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(80,50,200,450);
        panel.add(pane);

        tanh = new JTextField();
        tviet = new JTextField();
        eng = new JLabel("Tieng Anh");
        vie = new JLabel("Tieng Viet");
        eng.setBounds(700,200,100,50);
        tanh.setBounds(770,200,100,50);
        vie.setBounds(700,270,100,50);
        tviet.setBounds(770,270,100,50);
        panel.add(eng);panel.add(tanh);panel.add(vie);panel.add(tviet);

        add = new JButton("Add");

        add.setBounds(750,350,100,50);
        panel.add(add);

        panel.setSize(1000,600);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.add(label);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void addListener(){
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] row = new Object[2];
                row[0] = tanh.getText();
                row[1] = tviet.getText();
                model.addRow(row);
            }
        });
    }
    public JPanel getPanel(){
        init();
        addListener();
        return panel;
    }
}
