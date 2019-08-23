package baitapthayson;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Bai20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+5];
        Random rd = new Random();
        for(int i = 1; i <= n; i++){
            a[i] = rd.nextInt(9000)+1000;
        }
        System.out.println("Nhap so X:");
        int X = sc.nextInt();
        int minDistance = 9999;
        for(int i = 1; i <= n; i++){
            if(isPrime(a[i])){
                minDistance = Math.min(minDistance,Math.abs(a[i]-X));
            }
        }
        System.out.println(minDistance);
    }
    public static boolean isPrime(int n){
        if(n<2) return false;
        else{
            for(int i = 2; i <= Math.sqrt(n); i++)
                if(n%i==0)  return false;
            return true;
        }
    }
}
