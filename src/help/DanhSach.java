package help;


import java.util.Scanner;

public class DanhSach{
    private int n;
    private PTGT[] ds;

    public DanhSach(){
        n=0;
        ds = new PTGT[100];
    }
    public DanhSach(int n){
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public PTGT[] getDs() {
        return ds;
    }

    public void Xuat(){
        System.out.println("hang" + "\t" +"mau"+"\t"+"nam"+"\t"+"gia");
        for(int i=0;i<n;i++){
            System.out.println(ds[i].toString());
        }
    }

    public void Nhap(){
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap n: ");
        n = in.nextInt();
        for(int i=0; i<n; i++){
            ds[i] = new PTGT();
            ds[i].Nhap();
        }
    }
}

