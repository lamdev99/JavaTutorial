package TestCuoiKi;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ObjectOutputStream;

class StringEqualsNull extends Exception{
    public StringEqualsNull(String s){
        super(s);
    }
}

class StringToInt extends Exception{

}

class ExceptionString{
    public void StringEqualNullEx(String s) throws StringEqualsNull{
        if(s.length()==0){
            throw new StringEqualsNull(s);
        }
    }
}

class PanelSach implements InterfaceDo, ActionListener, MouseListener {
    JPanel jPanelSach;
    Object[] col = {"ID", "Name Book", "Author", "Object", "Year", "Quantity"};
    Object[] row;
    JTextArea tfName, tfAuthor, tfObject, tfYear, tfQ;
    JLabel lbName,lbAuthor,lbObject,lbYear,lbQ;
    JButton btnAdd;
    JScrollPane jScrollPane;
    DefaultTableModel model;
    JTable jTable;
    Font font;

    @Override
    public JPanel getPanel() {
        return null;
    }

    @Override
    public JPanel createTable() {
        init();
        addToFrame();
        setBoundd();
        addEvent();
        return this.jPanelSach;
    }

    @Override
    public void init() {
        row = new Object[6];
        jPanelSach = new JPanel();
        tfName = new JTextArea();
        tfAuthor = new JTextArea();
        tfObject = new JTextArea();
        tfYear = new JTextArea();
        tfQ = new JTextArea();
        lbName = new JLabel("Book's Name");
        lbAuthor = new JLabel("Author");
        lbObject = new JLabel("Object");
        lbYear = new JLabel("Year");
        lbQ = new JLabel("Quantity");
        jTable = new JTable();
        btnAdd = new JButton("Add");
        model = new DefaultTableModel();
        jScrollPane = new JScrollPane(jTable);
    }

    @Override
    public void addToFrame() {
        jPanelSach.add(tfName);
        jPanelSach.add(tfAuthor);
        jPanelSach.add(tfObject);
        jPanelSach.add(tfYear);
        jPanelSach.add(tfQ);
        jPanelSach.add(lbName);
        jPanelSach.add(lbAuthor);
        jPanelSach.add(lbObject);
        jPanelSach.add(lbYear);
        jPanelSach.add(lbQ);
        jPanelSach.add(btnAdd);
        jPanelSach.add(jScrollPane);
    }

    @Override
    public void setBoundd() {
        tfName.setBounds(150,250,100,30);
        tfAuthor.setBounds(150,300,100,30);
        tfObject.setBounds(150,350,100,30);
        tfYear.setBounds(150,400,100,30);
        tfQ.setBounds(150,450,100,30);
        lbName.setBounds(50,250,80,30);
        lbAuthor.setBounds(50,300,80,30);
        lbObject.setBounds(50,350,80,30);
        lbYear.setBounds(50,400,80,30);
        lbQ.setBounds(50,450,80,30);
        btnAdd.setBounds(300,350,100,30);

        jScrollPane.setBounds(0 ,0,700,200);
        model.setColumnIdentifiers(col);
        jTable.setModel(model);
        jTable.setBackground(Color.ORANGE);
        jTable.setForeground(Color.WHITE);
        font = new Font("",1,22);
        jTable.setFont(font);
        jTable.setRowHeight(30);

        jPanelSach.setSize(700, 600);
        jPanelSach.setLayout(null);
        jPanelSach.setVisible(true);

    }

    @Override
    public void addEvent() {
        btnAdd.addActionListener(this);
    }
    public boolean addToTable(){
        //boolean canAdd = true;
        int year,quantity;
        try {
            row[1] = tfName.getText();
            new ExceptionString().StringEqualNullEx(row[1].toString());
        } catch (StringEqualsNull stringEqualsNull) {
            tfName.requestFocus();
            JOptionPane.showMessageDialog(jPanelSach,"Please " +
                    "fill in all ",null,JOptionPane.WARNING_MESSAGE);
            return false;
            //canAdd = false;
        }
        try {
            row[2] = tfAuthor.getText();
            new ExceptionString().StringEqualNullEx(row[2].toString());
        } catch (StringEqualsNull stringEqualsNull) {
            tfAuthor.requestFocus();
            JOptionPane.showMessageDialog(jPanelSach,"Please " +
                    "fill in all ",null,JOptionPane.WARNING_MESSAGE);
            return false;
         //   canAdd = false;
        }
        try {
            row[3] = tfObject.getText();
            new ExceptionString().StringEqualNullEx(row[3].toString());
        } catch (StringEqualsNull stringEqualsNull) {
            tfObject.requestFocus();
            JOptionPane.showMessageDialog(jPanelSach,"Please " +
                    "fill in all ",null,JOptionPane.WARNING_MESSAGE);
            return false;
          //  canAdd = false;
        }
        try {
            row[4] = tfYear.getText();
            System.out.println(row[4].toString());
            year = Integer.parseInt(row[4].toString());
        } catch (NumberFormatException e) {
            System.out.println(1);
            tfYear.requestFocus();
            JOptionPane.showMessageDialog(jPanelSach,"Please " +
                    "fill number ",null,JOptionPane.WARNING_MESSAGE);
            return false;
            //canAdd = false;
        }
        try {
            row[5] = tfQ.getText();
            System.out.println(row[5].toString());
            quantity = Integer.parseInt(row[5].toString());
        } catch (NumberFormatException e) {
            System.out.println(1);
            tfYear.requestFocus();
            JOptionPane.showMessageDialog(jPanelSach,"Please " +
                    "fill quantity ",null,JOptionPane.WARNING_MESSAGE);
            return false;
            //canAdd = false;
        }
        Sach sach = new Sach(year,quantity,row[1].toString(),row[2].toString(),row[3].toString());
        addToFile(sach);
        model.addRow(row);

        return true;
    }
    public void addToFile(Sach sach){
        ObjectsOutputStreamEx oos = new ObjectsOutputStreamEx(sach);
        oos.add();
        oos.show();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            addToTable();
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

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
