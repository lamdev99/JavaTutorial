package baitapthayson;

import java.util.Scanner;

public class Bai25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[m+5][n+5];
        int[][] b = new int[n+5][k+5];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                b[i][j] = sc.nextInt();
            }
        }
        int[][] c= new int[m+5][k+5];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= k; j++){
                c[i][j] = 0;
                for(int q = 1; q <= n; q++){
                    c[i][j] += a[i][q]*b[q][j];
                }
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }
}
