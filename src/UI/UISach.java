package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UISach extends JFrame {
    JTable table;
    JTextField name,author,year;
    JButton add,sort;
    List<Sach> list = new ArrayList<>();
    public UISach(){
        init();
        setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Author");
        model.addColumn("Year");

        add(new JScrollPane(table),BorderLayout.CENTER);

        JPanel panelD = new JPanel(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(3,2));
        panel.add(new JLabel("Name"));
        panel.add(name);
        panel.add(new JLabel("Author"));
        panel.add(author);
        panel.add(new JLabel("Year"));
        panel.add(year);
        JPanel panelB = new JPanel(new GridLayout(2,1));
        panelB.add(add);
        panelB.add(sort);
        panelD.add(panel,BorderLayout.CENTER);
        panelD.add(panelB,BorderLayout.EAST);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sach sach = new Sach(name.getText(),author.getText(),year.getText());
                Object[] row = new Object[4];
                row[0] = String.valueOf(sach.getId());
                row[1] = sach.getName();
                row[2] = sach.getAuthor();
                row[3] = sach.getYear();
                model.addRow(row);
                list.add(sach);
            }
        });
        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(list,new SortByName());
                int index = model.getRowCount();
                for(int i = 0; i <index;i++)
                    model.removeRow(0);
                for(Sach sach: list){
                    Object[] row = new Object[4];
                    row[0] = String.valueOf(sach.getId());
                    row[1] = sach.getName();
                    row[2] = sach.getAuthor();
                    row[3] = sach.getYear();
                    model.addRow(row);
                }
            }
        });
        panelD.setBounds(0,300,700,200);
        add(panelD,BorderLayout.SOUTH);
        setSize(700,700);
       // setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        name = new JTextField();
        author = new JTextField();
        year = new JTextField();
        add = new JButton("add");
        sort = new JButton("sort");
   }
    public static void main(String[] args) {
        new UISach();
    }
}
class SortByName implements Comparator<Sach>{

    @Override
    public int compare(Sach o1, Sach o2) {
        return o1.getName().compareTo(o2.getName());
    }
}