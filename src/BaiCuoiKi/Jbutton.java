package BaiCuoiKi;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class test implements ActionListener {
    private String s;
    private JFrame jFrame;
    JButton jButton;
    JTextField jTextField;
    JRadioButton jRB_Male, jRB_Female;
    ButtonGroup bg_Sex;
    JCheckBox jCB_Java, jCB_React;

    public void createFrame() {
        init();
        setBound();
        addAction();
        addFrame();
    }

    public void setBound() {
        jTextField.setBounds(50, 50, 100, 30);
        jButton.setBounds(50, 100, 100, 30);
        jCB_Java.setBounds(50, 150, 80, 50);
        jCB_React.setBounds(150, 150, 80, 50);
        jRB_Male.setBounds(50, 180, 80, 50);
        jRB_Female.setBounds(150, 180, 80, 50);
    }

    public void addFrame() {
        bg_Sex.add(jRB_Male);
        bg_Sex.add(jRB_Female);
        jFrame.add(jRB_Male);
        jFrame.add(jRB_Female);
        jFrame.add(jCB_Java);
        jFrame.add(jCB_React);
        jFrame.add(jButton);
        jFrame.add(jTextField);
        jFrame.setSize(400, 400);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    public void init() {
        s = "";
        jFrame = new JFrame("Button");
        jButton = new JButton("ClickME!!!");
        jTextField = new JTextField("");
        jCB_Java = new JCheckBox("Java");
        jCB_React = new JCheckBox("React");
        jRB_Male = new JRadioButton("Male");
        jRB_Female = new JRadioButton("Female");
        bg_Sex = new ButtonGroup();
    }

    public void addAction() {
        jButton.addActionListener(this);

        jCB_Java.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jRB_Male.isSelected()) {
            JOptionPane.showMessageDialog(jFrame, "You are Male");
        }
        if (jRB_Female.isSelected()) {
            JOptionPane.showMessageDialog(jFrame, "You are Female");
        }
    }
}

class table {
    JFrame jFrame;
    JTable jTable;
    ListSelectionModel listSelectionModel;
    JScrollPane jScrollPane;
    String data[][] = {{"101", "Lam", "20"},
            {"102", "Nam", "20"},
            {"103", "Dan", "20"}};
    String col[] = {"ID", "NAME", "AGE"};

    public void createFrame() {
        init();
        addToFrame();
        addAction();
    }

    public void init() {
        jFrame = new JFrame("Class");
        jTable = new JTable(data, col);
        jScrollPane = new JScrollPane(jTable);
        jTable.setCellSelectionEnabled(true);
        listSelectionModel = jTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void addToFrame() {
        jTable.setBounds(40, 40, 150, 150);
        jFrame.add(jTable);
        jFrame.setSize(300, 400);
        jFrame.setVisible(true);
    }

    public void addAction() {
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String Data = null;
                int[] row = jTable.getSelectedRows();
                int[] col = jTable.getSelectedColumns();
                for(int i = 0; i < row.length; i++){
                    for(int j = 0; j < col.length; j++){
                        Data = (String) jTable.getValueAt(row[i],col[j]);
                    }
                }
                JOptionPane.showMessageDialog(jFrame,Data.toString());
            }
        });
    }
}

public class Jbutton {

    public static void main(String[] args) {
        new table().createFrame();
    }
}
