package baitapthayson;

import java.util.Scanner;

public class Bai17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n+5][n+5];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(i==j||j==0){
                    a[i][j] = 1;
                    System.out.print(1+" ");
                }else{
                    a[i][j] = a[i-1][j] + a[i-1][j-1];
                    System.out.print(a[i][j]+" ");
                };
            }
            System.out.println();
        }
    }
}
