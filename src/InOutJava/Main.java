package InOutJava;


import java.io.*;
import java.util.*;

class SinhVien implements Serializable {
    private String xepLoai;
    private int maSV;
    private String ten, lop;
    private double dtb;

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

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

public class Main {

    public static void main(String[] args) {
        List<SinhVien> newList = new ArrayList<>();
        List<SinhVien> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choose = -1;
        while (choose!=0){
            System.out.println("1.Doc thong tin tu file");
            System.out.println("2.In ra thong tin sinh vien");
            System.out.println("3.Sap xep theo lop");
            System.out.println("4.Sap xep theo muc diem");
            System.out.println("0.Thoat");
            choose = sc.nextInt();
            switch (choose){
                case 1:{
                    list=getSV("SV.INP");
                    break;
                }
                case 2:{
                    for(SinhVien sv: list)
                        System.out.println(sv);
                    break;
                }
                case 3:{
                    SortByClassAndDtb(list);
                    newList = getSV("SX.OUT");
                    for (SinhVien sv: newList)
                        System.out.println(sv);
                    break;
                }
                case 4:{
                    SortByDtbAndName(list);
                    newList = getSV("XEPLOAI.OUT");

                    for (SinhVien sv: newList)
                        System.out.println(sv);
                    break;
                }
                default: break;
            }

        }
    }
    public static void SortByDtbAndName(List<SinhVien> list) {
        for (SinhVien sv : list) {
            if (sv.getDtb() > 8)
                sv.setXepLoai("Gioi");
            else if (sv.getDtb() > 7)
                sv.setXepLoai("Kha");
            else if (sv.getDtb() > 5)
                sv.setXepLoai("TB");
            else sv.setXepLoai("Yeu");
        }
        List<SinhVien> arrayKq = new ArrayList<>();
        List<SinhVien> newList = new ArrayList<>();
        String xl = "Gioi";
        for (SinhVien sv : list) {
            if (sv.getXepLoai().equals(xl)) {
                newList.add(sv);
            } else {
                Collections.sort(newList, new SortByName());
                for (SinhVien s : newList)
                    arrayKq.add(s);
                newList.clear();
                newList.add(sv);
            }
        }
        if (!newList.isEmpty()) {
            for (SinhVien s : newList)
                arrayKq.add(s);
        }
        OutputSV(arrayKq, "XEPLOAI.OUT");
    }

    public static void SortByClassAndDtb(List<SinhVien> list) {
        SinhVien sv = (SinhVien) list.get(0);
        String lop = sv.getLop();
        List<SinhVien> arrayKq = new ArrayList<>();
        List<SinhVien> newList = new ArrayList<>();
        for (SinhVien sinhVien : list) {
            if (sinhVien.getLop().equals(lop)) {
                newList.add(sinhVien);
            } else {
                Collections.sort(newList, new SortByDtb());
                for (SinhVien s : newList)
                    arrayKq.add(s);
                newList.clear();
                lop = sinhVien.getLop();
                newList.add(sinhVien);
            }
        }
        if (!newList.isEmpty()) {
            Collections.sort(newList, new SortByDtb());
            for (SinhVien s : newList)
                arrayKq.add(s);
        }
        OutputSV(arrayKq, "SX.OUT");
    }

    public static boolean TestException(SinhVien sv) {
        boolean check = true;
        try {
            ExLop(sv.getLop());
            ExDiem(sv.getDtb());
            ExMaSV(sv.getMaSV());
            ExTen(sv.getTen());
        } catch (ExUsage exmaSV) {
            check = false;
            return check;
        }
        return check;
    }

    public static List<SinhVien> getSV(String path) {
        List<SinhVien> al = new ArrayList<SinhVien>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<SinhVien> objectsList = new ArrayList<SinhVien>();
        boolean cont = true;
        try {
            ObjectInputStream input = new ObjectInputStream(fis);
            while (cont) {
                SinhVien obj = (SinhVien) input.readObject();
                if (obj != null)
                    objectsList.add(obj);
                else
                    cont = false;
            }
        } catch (Exception e) {
            //System.out.println(e.printStackTrace());
        }
        return objectsList;
    }

    public static void OutputSV(List<SinhVien> list, String path) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            for (SinhVien sv : list)
                oos.writeObject(sv);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void InputSV() {
//        ObjectOutputStream oos = null;
//        try {
//            oos = new ObjectOutputStream(new FileOutputStream("SV.INP"));
//            oos.writeObject(new SinhVien(1234, "Lam", "D17CQCN06", 6));
//            oos.writeObject(new SinhVien(1234, "Nam", "D17CQCN06", 9));
//            oos.writeObject(new SinhVien(1234, "Thai", "A17CQCN06", 9));
//            oos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private static class ExUsage extends Exception {
        public ExUsage(String me) {
            super(me);
        }
    }

    public static void ExMaSV(int maSV) throws ExUsage {
        if (maSV < 1000 || maSV > 9999) throw new ExUsage("");
    }

    public static void ExTen(String ten) throws ExUsage {
        if (ten.length() == 0) throw new ExUsage(ten);
    }

    public static void ExDiem(double diem) throws ExUsage {
        if (diem < 0 || diem >= 10) throw new ExUsage("");
    }

    public static void ExLop(String lop) throws ExUsage {
        if (lop.charAt(0) <= 'A' || lop.charAt(0) >= 'Z') throw new ExUsage(lop);
    }
}

class SortByClass implements Comparator<SinhVien> {

    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        return o1.getLop().compareTo(o2.getLop());
    }
}

class SortByDtb implements Comparator<SinhVien> {

    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        return (int) (o2.getDtb() - o1.getDtb());
    }
}

class SortByName implements Comparator<SinhVien> {

    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        return o1.getTen().compareTo(o2.getTen());
    }
}