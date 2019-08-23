package baitapthayson;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Bai19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+5];
        Random rd = new Random();
        for(int i = 1; i <= n; i++){
            a[i] = rd.nextInt(2000)-1000;
        }
        System.out.println("Cac so co 3 chu so");
        Map<Integer,Integer> myMap = new HashMap<>();
        for(int i = 1; i <= n; i++){
            if(a[i]>=100&&a[i]<=999) System.out.print(a[i]+" ");
            myMap.put(a[i],0);
        }
        for(int i = 1; i<= n; i++){
            myMap.put(a[i],myMap.get(a[i])+1);
        }
        int Max = 0, maxValueAppear = 0;
        for(int i = 1; i <= n; i++){
            if(myMap.get(a[i])>Max) {
                Max = Math.max(myMap.get(a[i]), Max);
                maxValueAppear = a[i];
            }
        }
        System.out.println();
        System.out.println(maxValueAppear+" "+Max);
    }
}
