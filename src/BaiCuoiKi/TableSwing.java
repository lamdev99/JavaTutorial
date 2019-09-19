package BaiCuoiKi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Table implements ActionListener, MouseListener {
    Object[] col = {"ID","NAME","AGE"};
    Object[] row = new Object[3];
    JPanel jFrame;
    JTable jTable;
    JButton btnAdd,btnUpdate,btnDelete;
    JTextField tfId,tfName,tfAge;
    JScrollPane jScrollPane;
    DefaultTableModel model;
    Font font;
    public void createTable(){
        init();
        addToFrame();
        addAction();
    }
    public void init(){
        jFrame = new JPanel();
        btnAdd = new JButton("Add");
        btnDelete = new JButton("Delete");
        btnUpdate = new JButton("Update");
        tfAge = new JTextField();
        tfId = new JTextField();
        tfName = new JTextField();
        jTable = new JTable();
        jScrollPane = new JScrollPane(jTable);
        model = new DefaultTableModel();
    }
    public void addToFrame(){
        tfId.setBounds(50,300,100,30);
        tfName.setBounds(50,350,100,30);
        tfAge.setBounds(50,400,100,30);
        btnAdd.setBounds(200,300,100,30);
        btnUpdate.setBounds(200,350,100,30);
        btnDelete.setBounds(200,400,100,30);
        jScrollPane.setBounds(0,0,700,200);

        model.setColumnIdentifiers(col);
        jTable.setModel(model);
        jTable.setBackground(Color.ORANGE);
        jTable.setForeground(Color.WHITE);
        font = new Font("",1,22);
        jTable.setFont(font);
        jTable.setRowHeight(30);

        jFrame.add(jScrollPane);
        jFrame.add(tfId);
        jFrame.add(tfName);
        jFrame.add(tfAge);
        jFrame.add(btnAdd);
        jFrame.add(btnUpdate);
        jFrame.add(btnDelete);
        jFrame.setSize(700,600);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
    JPanel returnPanel(){
        return this.jFrame;
    }
    public void addAction(){
        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        jTable.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAdd){
            boolean canAdd = true;
            try {
                row[0] = tfId.getText();
                Integer.valueOf(row[0].toString());
            }catch (Exception ex){
                canAdd = false;
                JOptionPane.showMessageDialog(jFrame,ex);
                tfId.setText("");
                tfId.requestFocus();
            }
            row[1] = tfName.getText();
            try{
                row[2] = tfAge.getText();
                Integer.valueOf(row[2].toString());
            }catch (Exception ex){
                canAdd = false;
                JOptionPane.showMessageDialog(jFrame,ex);
                tfAge.setText("");
                tfAge.requestFocus();
            }
            if(canAdd){
                model.addRow(row);
                JOptionPane.showMessageDialog(jFrame,"Add Successfully");
            }
        }
        if(e.getSource()==btnDelete){
            int i = jTable.getSelectedRow();
            if(i>=0){
                model.removeRow(i);
                JOptionPane.showMessageDialog(jFrame,"Delete Successfully");
            }
            else{
                JOptionPane.showMessageDialog(jFrame,null,"Can not delete any row!!!",JOptionPane.WARNING_MESSAGE);
            }
        }
        if(e.getSource()==btnUpdate){
            int i = jTable.getSelectedRow();
            if(i>=0){
                model.setValueAt(tfId.getText(),i,0);
                model.setValueAt(tfName.getText(),i,1);
                model.setValueAt(tfAge.getText(),i,2);
            }
            else{
                JOptionPane.showMessageDialog(jFrame,null,"Can not update any row!!!",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int i = jTable.getSelectedRow();
        tfId.setText(model.getValueAt(i,0).toString());
        tfName.setText(model.getValueAt(i,1).toString());
        tfAge.setText(model.getValueAt(i,2).toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

public class TableSwing {
    public static void main(String[] args) {
        new Table().createTable();
    }
}
