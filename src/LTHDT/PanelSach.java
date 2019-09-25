package LTHDT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSach {
    private String nameBook,majorB,yearB,quantityB,authorB;
    private JTable SachTable;
    private JTextField bookName;
    private JTextField author;
    private JButton addBtn;
    private JTextField year;
    private JTextField quantity;
    private JComboBox major;
    public void createPanel(){

    }
    public JPanel getPanel(){
        Init();
        addEvent();
        JPanel panel = new JPanel();
        panel.add(SachTable);
        panel.add(bookName);
        panel.add(author);
        panel.add(addBtn);
        panel.add(year);
        panel.add(quantity);
        panel.add(quantity);
        return panel;
    }
    public void Init(){
        SachTable  =  new JTable();
        bookName  = new JTextField();
        author = new JTextField();
        year = new JTextField();
        major = new JComboBox();
        quantity = new JTextField();

    }
    public void  addEvent(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkEx()){
                    Sach sach = new Sach(nameBook,authorB,majorB,yearB,quantityB);
                    System.out.println(sach);
                }
                else{

                }
            }
        });
    }
    public boolean checkEx(){
        nameBook = bookName.getText();
        authorB = author.getText();
        majorB = major.getActionCommand();
        yearB = year.getText();
        quantityB = quantity.getText();
        try {
            ExStringEqualsNull(nameBook);
            ExStringEqualsNull(authorB);
            ExStringEqualsNull(majorB);
            ExStringEqualsNull(yearB);
            ExStringEqualsNull(quantityB);
        } catch (ExUsage exUsage) {
            if(nameBook.length()==0)    bookName.requestFocus();
            if(authorB.length()==0) author.requestFocus();
            if(majorB.length()==0)  major.requestFocus();
            if(yearB.length()==0)   year.requestFocus();
            if(quantityB.length()==0)   quantity.requestFocus();
            return false;
        }
        return true;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public class ExUsage extends Exception{
        public ExUsage(String msg){
            super(msg);
        }
    }
    public void ExStringEqualsNull(String s) throws ExUsage{
        if(s.length()==0)   throw  new ExUsage("abc");
    }
}


