package baithaysonpart2;

import java.util.*;

class SinhVien{
    private int idSV;
    private String nameSV,className,grade;

    public SinhVien(int idSV, String nameSV, String className, String grade) {
        this.idSV = idSV;
        this.nameSV = nameSV;
        this.className = className;
        this.grade = grade;
    }

    public int getIdSV() {
        return idSV;
    }

    public void setIdSV(int idSV) {
        this.idSV = idSV;
    }

    public String getNameSV() {
        return nameSV;
    }

    public void setNameSV(String nameSV) {
        this.nameSV = nameSV;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "idSV=" + idSV +
                ", nameSV='" + nameSV + '\'' +
                ", className='" + className + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public SinhVien() {
    }
}

class CompareSV implements Comparator<SinhVien>{

    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        return o1.getNameSV().compareTo(o2.getNameSV());
    }
}

public class bai1 {
    private static List<SinhVien>  listSV;
    private static Set<String> setSV;
    public static void main(String[] args) {
        int n;
        listSV = new ArrayList<>();
        do{
            Case();
        }while(Case()==true);
    }
    public static boolean Case(){
        System.out.println("Nhap thu ban muon" +
                "0.Thoat" +
                "1.Them sinh vien" +
                "2.Hien thi danh sach" +
                "3.Sap xep theo ten" +
                "4.Sap xep theo lop");
        int choose;
        Scanner sc = new Scanner(System.in);
        choose = sc.nextInt();
        switch (choose){
            case 0:{
                return false;
            }
            case 1:{
                System.out.println("Nhap so luong sinh vien");
                int n = sc.nextInt();
                for(int i = 1; i <= n; i++){
                    SinhVien sv = new SinhVien();
                    System.out.print("Nhap ma SV: ");
                    sv.setIdSV(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Nhap ten sinh vien: ");
                    sv.setNameSV(sc.nextLine());
                    System.out.print("Nhap ten lop: ");
                    sv.setClassName(sc.nextLine());
                    System.out.print("Nhap ten khoa: ");
                    sv.setGrade(sc.nextLine());
                    listSV.add(sv);
                }
                return true;
            }
            case 2:{
                System.out.println("In danh sach sinh vien");
                for(SinhVien Sv: listSV){
                    System.out.println(Sv);
                }
                return true;
            }
            case 3:{
                System.out.println("Sap xep theo ten");
                Collections.sort(listSV, new CompareSV());
                for(SinhVien Sv: listSV){
                    System.out.println(Sv);
                }
                return true;
            }
            case 4:{
                setSV = new HashSet<>();
                for(SinhVien sv: listSV){
                    setSV.add(sv.getClassName());
                }
                for(String s: setSV){
                    System.out.println(s+":");
                    for(SinhVien sv: listSV){
                        if(s.equals(sv.getClassName())){
                            System.out.println(sv.getNameSV());
                        }
                    }
                }
            }
        }
        return true;
    }
}
