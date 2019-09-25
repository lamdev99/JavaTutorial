package baitapthayson;

import java.util.*;

class NhanVien{
    private String ten,que;
    private int namSinh,namCT;

    public NhanVien(String ten, String que, int namSinh, int namCT) {
        this.ten = ten;
        this.que = que;
        this.namSinh = namSinh;
        this.namCT = namCT;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getNamCT() {
        return namCT;
    }

    public void setNamCT(int namCT) {
        this.namCT = namCT;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "ten='" + ten + '\'' +
                ", que='" + que + '\'' +
                ", namSinh=" + namSinh +
                ", namCT=" + namCT +
                '}';
    }
}

public class Main {
    private static List<NhanVien> nhanVienList;
    public static void main(String[] args) {
        int choose = -1;
        nhanVienList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(choose!=0){
            System.out.println("1.Them\n" +
                    "2.Sua\n" +
                    "3.Xoa\n" +
                    "4.Hien thi\n" +
                    "5.Top 2 nhan vien tham nien cao nhat\n" +
                    "6.Top 2 nhan vien cao tuoi nhat\n" +
                    "0.Thoat");
            choose = sc.nextInt();
            switch (choose){
                case 1:{
                    add();
                    break;
                }
                case 2:{
                    sc.nextLine();
                    String name;
                    System.out.print("Nhap ten nhan vien ban muon sua"); name = sc.nextLine();
                    update(name);
                    break;
                }
                case 3:{
                    sc.nextLine();
                    String name;
                    System.out.print("Nhap ten nhan vien ban muon xoa"); name= sc.nextLine();
                    delete(name);
                    break;
                }
                case 4:{
                    display();
                    break;
                }
                case 5:{
                    Collections.sort(nhanVienList, new SortByNCT());
                    System.out.println(nhanVienList.get(0));
                    System.out.println(nhanVienList.get(1));
                    break;
                }
                case 6:{
                    Collections.sort(nhanVienList, new SortByAge());
                    System.out.println(nhanVienList.get(0));
                    System.out.println(nhanVienList.get(1));
                    break;
                }
                default: break;
            }

        }
    }
    public static void add(){
        String ten,que;
        int ns,nct;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten: ");ten = sc.nextLine();
        System.out.print("Nhap que: ");que = sc.nextLine();
        System.out.print("Nhap nam sinh: ");ns = sc.nextInt();
        System.out.print("Nhap nam cong tac");nct = sc.nextInt();
        NhanVien nv = new NhanVien(ten,que,ns,nct);
        nhanVienList.add(nv);
    }
    public static void delete(String name){
        for(NhanVien nv : nhanVienList){
            if (nv.getTen().equals(name)){
                nhanVienList.remove(nv);
                break;
            }
        }
    }
    public static void update(String name){
        Scanner sc = new Scanner(System.in);
        for(NhanVien nv: nhanVienList){
            if(nv.getTen().equals(name)){
                nhanVienList.remove(nv);
                add();
                break;
            }
        }
    }
    public static void display(){
        for(NhanVien nv: nhanVienList){
            System.out.println(nv);
        }
    }

}
class SortByNCT implements Comparator<NhanVien>{

    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        return o1.getNamCT()>o2.getNamCT() ? -1 : 1;
    }
}

class SortByAge implements Comparator<NhanVien>{

    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        return o1.getNamSinh()>o2.getNamSinh() ? 1: -1;
    }
}