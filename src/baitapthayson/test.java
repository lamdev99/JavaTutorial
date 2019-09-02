package baitapthayson;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;


public class test{

    // bai 6 UCLN
    public static int UCLN(int a, int b)
    {
        if(b==0)return a;
        return UCLN(b,a%b);
    }

    // bai 7: So nguyen to cung nhau
    public static void SoNguyenToCungNhau(int a, int b)
    {
        for(int i=a;i<b;i++)
        {
            if(i==1)
                continue;
            for(int j=i+1;j<=b;j++)
            {

                if(UCLN(i, j)==1)
                    System.out.println(i+" "+j);
            }
        }
    }

    // bai 8: tong cac chu so
    public static int TongCacChuSo(int a)
    {
        int tong=0;
        while(a!=0)
        {
            tong+=a%10;a/=10;
        }
        return tong;
    }

    // bai 9: phan tich thanh thua so nguyen to

    public static boolean CheckSoNguyenTo(int a)
    {
        if(a==1) return false;
        for(int i=2;i<=Math.sqrt(a);i++)
        {
            if(a%i==0)
                return false;
        }
        return true;
    }

    public static void PhanTich(int a)
    {
        ArrayList<Integer> lst = new ArrayList<>();

        for(int i=2;i<=a;i++)
        {
            if(CheckSoNguyenTo(i))
            {
                lst.add(i);
            }
        }
        StringBuffer kq=new StringBuffer();
        //System.out.println(lst.size());
        for(int i=0;i<lst.size();)
        {
            if(a%lst.get(i)==0)
            {
                kq.append("x"+lst.get(i));
                a/=lst.get(i);
                if(a==0) break;
            }
            else{
                i++;
            }
        }
        kq.deleteCharAt(0);
        System.out.println(kq);
    }

    // bai 10
    public static void LietKeNSoNguyenToDauTien(int n)
    {
        int i=2;
        while(n>0)
        {
            if(CheckSoNguyenTo(i)==true)
            {
                System.out.println(i);

                n--;
            }
            i++;
        }
    }

    // bai 11: n so Fibonaci dau tien

    public static int FibonaciThuN(int n)
    {
        if(n==1 || n==2) return 1;
        return FibonaciThuN(n-1)+ FibonaciThuN(n-2);
    }

    public static void N_SoFibonaciDauTien(int n)
    {
        for(int i=1;i<=n;i++)
            System.out.println(FibonaciThuN(i));
    }

    // bai 12

    public static void LietKeSoThuanNghich()
    {

        for(int i=100000;i<=999999;i++)
        {
            StringBuffer s1= new StringBuffer(Integer.toString(i));
            StringBuffer s2 = new StringBuffer(Integer.toString(i));
            s2.reverse();

            String n1 = s1.toString();
            String n2 =s2.toString();

            if(n1.equals(n2))
            {
                System.out.println(i);
            }
        }
    }

    // bai 13 tinh so pi
    public static double SoPi(double c)
    {
        int n=0;
        double pi=0;
        while(c<(double)1/(2*n+1))
        {
            n++; // tim n du lon
        }
        for(int i=0;i<=n;i++)
        {
            pi+= Math.pow(-1, i)*(double)1/(2*i+1);
        }
        return pi*4;
    }

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int a= sc.nextInt();

    }

}
