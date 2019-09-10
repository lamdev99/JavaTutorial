package baitapthayson;

import java.util.Scanner;

public class bai22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n+m+1];
        int[] b = new int[m+1];
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        for(int i = 1; i <= m; i++)
            b[i] = sc.nextInt();
        for(int i = n+m; i>=n+p; i--)
            a[i] = a[i-m];
        for(int i = p+1; i <= p+m; i++)
            a[i] = b[i-p];
        for(int i = 1; i <= n+m; i++)
            System.out.print(a[i]+" ");
    }
}
