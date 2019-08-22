package baitapthayson;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt(); // đọc vào 1 số nguyên.
        int b = in.nextInt();
        painting(a, b);
        //  char c = in.next().charAt(0);// đọc vào 1 ký tự.
        //String word = in.next(); // đọc vào 1 từ;
        //String line = in.nextLine(); // đọc vào 1 dòng.
    }
    public static void painting (int a,int b ){
        for (int i = 1;i<=b;i++)
        {
            for (int j = 1;i<=a;j++)
            {
                if (i==1|i==b|j==1|j==a)
                {
                    System.out.print("*");
                }
                else System.out.print(" ");
            }
            System.out.println("\n");
        }


    }
}
