package baitapthayson;

import java.util.Scanner;

public class Bai26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a=  new int[n+5][n+5];
        int gt = 1,hang = n, cot = n,d = 1;
        while(gt<=n*n){
            for(int i = d; i <= cot; i++)  a[d][i] = gt++;
            for(int i = d+1; i<= hang; i++) a[i][cot] = gt++;
            for(int i = cot-1; i>=d; i--) a[hang][i] = gt++;
            for(int i = hang-1; i>d; i--)   a[i][d]  = gt++;
            hang--;
            cot--;
            d++;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
