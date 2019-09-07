package Thayson2;
import java.util.Scanner;
class Sinhvien{
    private String masv;
    private String ten;
    private int lop;
    private int khoa;

    public Sinhvien(String masv, String ten, int lop, int khoa) {
        this.masv = masv;
        this.ten = ten;
        this.lop = lop;
        this.khoa = khoa;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        return "Sinhvien{" +
                "masv='" + masv + '\'' +
                ", ten='" + ten + '\'' +
                ", lop=" + lop +
                ", khoa=" + khoa +
                '}';
    }
}
public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sinhvien sv = new Sinhvien("102","Tay",12,17);
        System.out.println(sv);
    }
}
