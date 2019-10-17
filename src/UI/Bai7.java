package UI;

import BaiCuoiKi.Jbutton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai7 extends JFrame {
    JFrame f;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem nhap,thoat;
    JTable table;
    JButton nhapmoi;
    DefaultTableModel model  = new DefaultTableModel();
    public Bai7(){
        f =  new JFrame();

        table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Ho va ten");
        model.addColumn("Tuoi");
        model.addColumn("Diem");
        f.add(new JScrollPane(table),BorderLayout.CENTER);
        initMenu();

        nhapmoi = new JButton("Nhap moi");
        f.add(nhapmoi,BorderLayout.SOUTH);

        f.setJMenuBar(menuBar);
        f.setSize(500,500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        nhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAction();
            }
        });
        thoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        nhapmoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               addAction();
            }
        });
    }
    public void initMenu(){
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        nhap = new JMenuItem("Nhap");
        thoat = new JMenuItem("Thoat");
        menu.add(nhap);
        menu.add(thoat);
        menuBar.add(menu);
    }
    public void addAction(){
        Dialog d = new JDialog(f,"");
        JTextField id,name,age,point;
        JButton luu,boqua;
        id = new JTextField();
        name = new JTextField();
        age = new JTextField();
        point = new JTextField();
        luu = new JButton("Luu");
        boqua = new JButton("Bo qua");
        d.setLayout(new GridLayout(5,2));
        d.add(new JLabel("ID"));d.add(id);
        d.add(new JLabel("Name"));d.add(name);
        d.add(new JLabel("Age"));d.add(age);
        d.add(new JLabel("Point")); d.add(point);
        d.add(luu);d.add(boqua);
        d.setLocationRelativeTo(null);
        d.pack();
        luu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] row = new Object[4];
                row[0] = id.getText();
                row[1] = name.getText();
                row[2] = age.getText();
                row[3] = point.getText();
                model.addRow(row);
            }
        });
        boqua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });
        d.setVisible(true);
    }
    public static void main(String[] args) {
        new Bai7();
    }
}