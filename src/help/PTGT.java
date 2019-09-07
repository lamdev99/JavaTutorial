package help;


import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class PTGT{
    private String hang, mau;
    private int nam;
    private double gia;

    public PTGT(){}

    public PTGT(String hang, String mau, int nam, double gia){
        this.hang = hang;
        this.mau = mau;
        this.nam = nam;
        this.gia = gia;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String toString(){
        return (hang +"\t" + mau + "\t" + nam + "\t" + gia);
    }

    public void Nhap(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("Nhap vao hang: ");
            hang = in.nextLine();
            hang = hang.toUpperCase();
            if(hang.matches("^[A-Z]{4}\\d{4}$")) break;
        }
        System.out.print("Nhap mau: ");
        mau = in.nextLine();
        System.out.print("Nhap nam: ");
        nam = in.nextInt();
        System.out.print("Nhap gia: ");
        gia = in.nextInt();
    }
}