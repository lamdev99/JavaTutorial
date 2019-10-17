package QuanLiNhaDat;

import java.util.*;

public class QLPT {
    static Set<PTGT> myList = new HashSet<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choose = -1;
        while (choose != 0) {
            System.out.println("1.Nhap\t" +
                    "2.In\t");
            choose = sc.nextInt();
            switch (choose){
                case 1:{
                    input();
                    break;
                }
                case 2:{
                    output();
                    break;
                }
                default: break;
            }
        }
    }
    public static void input(){
        System.out.println("Chon loai\t" +
                "1.Oto\t" +
                "2.XeTai\t" +
                "3.Fix\t" +
                "4.Tinh tong tien\t" +
                "5.Sort\t" +
                "6.Seek\t" +
                "7.Max\t" +
                "0.Out");
        int chon;
        chon = sc.nextInt();
        switch (chon){
            case 1:{
                String khung,hang,mau,dongco;
                int nam,gia,chongoi;
                khung = sc.nextLine();
                hang = sc.nextLine();
                mau = sc.nextLine();
                dongco = sc.nextLine();
                nam = sc.nextInt();
                gia = sc.nextInt();
                chongoi = sc.nextInt();
                if(testHang(hang)){
                    Oto o = new Oto(khung,nam,gia,hang,mau,dongco,chongoi);
                    if(!myList.contains(o)){
                        myList.add(o);
                    }

                }
                break;
            }
            case 2:{
                String khung,hang,mau;
                int nam,gia,trongtai;
                khung = sc.nextLine();
                hang = sc.nextLine();
                mau = sc.nextLine();
                nam = sc.nextInt();
                gia = sc.nextInt();
                trongtai = sc.nextInt();

                if(testHang(hang)){
                    XeTai x = new XeTai(khung,nam,gia,hang,mau,trongtai);
                    if(!myList.contains(x))
                        myList.add(x);
                }
                break;
            }
            case 3:{
                System.out.println("Nhap vao khung muon sua");
                String khung;
                khung = sc.nextLine();
                fix(khung);
                break;
            }
            case 4:{
                System.out.println(tinhGia());
                break;
            }
            case 5:{
                List<PTGT> list = (List<PTGT>) myList;
                Collections.sort(list,new SortByGia());
                for(PTGT pt: list){
                    System.out.println(pt);
                }
                break;
            }
            case 6:{
                break;
            }
            case 7:{
                break;
            }
            default: break;
        }
    }
    public static void output(){
        int demOto = 0;
        for (PTGT pt: myList){
            System.out.println(pt);
            if(pt.isOto()){
                demOto ++;
            }
        }
        System.out.println("So oto: "+demOto+"\n"+"So xe tai "+(myList.size()-demOto)+"");

    }
    public static void fix(String khung){
        for(PTGT pt: myList){
            if(pt.getSoKhungXe().equals(khung)){
                ///something
                return;
            }
        }
        System.out.println("Khong ton tai so khung");
    }
    public static int tinhGia(){
        int Sum = 0;
        for (PTGT pt: myList){
            Sum += pt.getGia();
        }
        return Sum;
    }
    public static boolean testHang(String s){
        return s.matches("^[a-z]{1}\\d{4}$");
    }
}

class SortByGia implements Comparator<PTGT>{

    @Override
    public int compare(PTGT o1, PTGT o2) {
        return o1.getGia() > o2.getGia()?-1:1;
    }
}