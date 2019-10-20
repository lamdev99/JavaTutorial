package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UISV extends JFrame {
    JPanel paneladd;
    static int maSVAuto = 1000;
    List<SinhVien > listSV = new ArrayList<>();
    JTextField ten,lop,dtb;
    JButton addToFile,sort,readFromFile;
    JTable table;
    DefaultTableModel model;
    public UISV(){
        init();
        setLayout(null);
        setBound();
        docFile("SV.txt");
        addToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name,lopp,diem;
                try{
                    name = ten.getText();
                    lopp = lop.getText();
                    diem = dtb.getText();
                    ExName(name);
                    ExName(lopp);
                    ExDTB(Double.parseDouble(diem));
                    SinhVien sv = new SinhVien(++maSVAuto,name,lopp,Double.parseDouble(diem));
                    listSV.add(sv);
                }catch(ExUsage ex){
                    ten.requestFocus();
                    JOptionPane.showMessageDialog(null,"Nhap lai");
                }
                ghiFile("SV.txt");
            }
        });
        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(listSV,new SortByDTB());
                int n = model.getRowCount();
                for(int i = 0; i < n; i++)
                    model.removeRow(0);
                for(SinhVien sv: listSV)
                    hienthi(sv);
            }
        });
        readFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                docFile("SV.txt");
                for(SinhVien sv: listSV)
                    hienthi(sv);
            }
        });
        setSize(1000,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void setBound(){
        paneladd.setBounds(0,0,450,300);
        paneladd.add(new JLabel("Ten"));
        paneladd.add(ten);
        paneladd.add(addToFile);
        paneladd.add(new JLabel("Lop"));
        paneladd.add(lop);
        paneladd.add(readFromFile);
        paneladd.add(new JLabel("DTB"));
        paneladd.add(dtb);
        paneladd.add(sort);

        add(paneladd);

    }
    public void init(){
        ten = new JTextField();
        lop = new JTextField();
        dtb = new JTextField();
        addToFile = new JButton("Add to File");
        sort = new JButton("Sort");
        readFromFile = new JButton("Read from file");
        paneladd = new JPanel(new GridLayout(3,3));
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Ten");
        model.addColumn("Lop");
        model.addColumn("DTB");
        table.setBounds(500,100,400,600);
        add(table);
    }
    public void hienthi(SinhVien sv){
        //for(SinhVien sv: listSV){
            Object[] o = new Object[4];
            o[0] = String.valueOf(sv.getMaSV());
            o[1] = sv.getTen();
            o[2] = sv.getLop();
            o[3] = String.valueOf(sv.getDtb());
            model.addRow(o);
        //}
    }
    public void docFile(String path){
        listSV.clear();
        int n = model.getRowCount();
        for(int i = 0; i < n; i++)
            model.removeRow(0);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean cont = true;
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(cont){
                SinhVien sv = (SinhVien) ois.readObject();

                if(sv!=null) {listSV.add(sv);maSVAuto = sv.getMaSV();}
                else cont = false;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    public void ghiFile(String path){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            for(SinhVien sv: listSV){
                oos.writeObject(sv);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new UISV();
    }
    public void ExName(String s) throws ExUsage{
        if(s.length()==0)   throw new ExUsage();
    }
    public void ExDTB(Double d) throws ExUsage{
        if(d<0||d>10)   throw new ExUsage();
    }

}
class SortByDTB implements Comparator<SinhVien>{

    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        return o1.getDtb() > o2.getDtb() ? -1 : 1;
    }
}
class ExUsage extends Exception{
    public ExUsage(){

    }
}
class SinhVien implements Serializable{
    private int maSV;
    private String ten,lop;
    private double dtb;

    public SinhVien() {
    }

    public SinhVien(int maSV, String ten, String lop, double dtb) {
        this.maSV = maSV;
        this.ten = ten;
        this.lop = lop;
        this.dtb = dtb;
    }

    public int getMaSV() {
        return maSV;
    }

    public String getTen() {
        return ten;
    }

    public String getLop() {
        return lop;
    }

    public double getDtb() {
        return dtb;
    }
}