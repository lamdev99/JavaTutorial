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
    List<SinhVien> listSV = new ArrayList<>();
    JTextField ten, lop, dtb;
    JButton addToFile, sort, readFromFile;
    JTable table;
    DefaultTableModel model;

    public UISV() {
        init();
        setLayout(null);
        setBound();
        docFile("SVV.txt");
        addToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name, lopp, diem;
                try {
                    name = ten.getText();
                    lopp = lop.getText();
                    diem = dtb.getText();
                    ExName(name);
                    ExName(lopp);
                    ExLop(lopp);
                    ExDTB(Double.parseDouble(diem));
                    SinhVien sv = new SinhVien(++maSVAuto, name, lopp, Double.parseDouble(diem));
                    listSV.add(sv);
                    ghiFile("SVV.txt", sv);
                } catch (ExUsage ex) {
                    ten.requestFocus();
                    JOptionPane.showMessageDialog(null, "Nhap lai");
                }

            }
        });
        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(listSV, new SortByDTB());
                int n = model.getRowCount();
                for (int i = 0; i < n; i++)
                    model.removeRow(0);
                for (SinhVien sv : listSV)
                    hienthi(sv);
            }
        });
        readFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                docFile("SVV.txt");
                for (SinhVien sv : listSV)
                    hienthi(sv);
            }
        });
        setSize(1000, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setBound() {
        paneladd.setBounds(0, 300, 450, 150);
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

    public void init() {
        ten = new JTextField();
        lop = new JTextField();
        dtb = new JTextField();
        addToFile = new JButton("Add to File");
        sort = new JButton("Sort");
        readFromFile = new JButton("Read from file");
        paneladd = new JPanel(new GridLayout(3, 3));
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Ten");
        model.addColumn("Lop");
        model.addColumn("DTB");
        table.setBounds(500, 100, 400, 600);
        add(table);
    }

    public void hienthi(SinhVien sv) {
        Object[] o = new Object[4];
        o[0] = String.valueOf(sv.getMaSV());
        o[1] = sv.getTen();
        o[2] = sv.getLop();
        o[3] = String.valueOf(sv.getDtb());
        model.addRow(o);
    }

    public void docFile(String path) {
        listSV.clear();
        int n = model.getRowCount();
        for (int i = 0; i < n; i++)
            model.removeRow(0);
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String id, name, lop, dtb;
            while ((id = br.readLine()) != null) {
                name = br.readLine();
                lop = br.readLine();
                dtb = br.readLine();
                SinhVien sv = new SinhVien(Integer.parseInt(id), name, lop, Double.parseDouble(dtb));
                listSV.add(sv);
                maSVAuto = Integer.parseInt(id);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public void ghiFile(String path, SinhVien sv) {
        try {
            FileWriter fw = new FileWriter(path, true);
            fw.write(sv.getMaSV() + "\n");
            fw.write(sv.getTen() + "\n");
            fw.write(sv.getLop() + "\n");
            fw.write(sv.getDtb() + "\n");
            fw.close();
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        new UISV();
    }

    public void ExName(String s) throws ExUsage {
        if (s.length() == 0) throw new ExUsage();
    }

    public void ExDTB(Double d) throws ExUsage {
        if (d < 0 || d > 10) throw new ExUsage();
    }

    public void ExLop(String s) throws ExUsage {
        if (!s.matches("^D[1-9]{2}CQCN[0,1][0-9]$")) throw new ExUsage();
    }
}

class SortByDTB implements Comparator<SinhVien> {

    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        return o1.getDtb() > o2.getDtb() ? -1 : 1;
    }
}

class ExUsage extends Exception {
    public ExUsage() {

    }
}

class SinhVien implements Serializable {
    private int maSV;
    private String ten, lop;
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

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV=" + maSV +
                ", ten='" + ten + '\'' +
                ", lop='" + lop + '\'' +
                ", dtb=" + dtb +
                '}';
    }
}