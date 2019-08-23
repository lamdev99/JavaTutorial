package baitapthayson;

import java.util.Scanner;

public class Bai23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a =  new int[n+5];
        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
        }
        int pos = 0,max = 0,posRe = 0,maxRe = 0;
        for(int i = 1; i < n; i++){
            if(a[i]<=a[i+1]){
                max++;
            }
            else{
                if(maxRe<max){
                    maxRe = max;
                    posRe = pos;
                }
                pos = i;
                max = 1;
            }
        }
        System.out.println(posRe+" "+maxRe);
    }
}
//1  4  2  3  1  2  6  8  3  5  7