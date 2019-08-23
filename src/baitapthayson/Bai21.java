package baitapthayson;

import java.lang.reflect.Array;
import java.util.*;

public class Bai21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a =  new int[n+1];
        Random rd = new Random();
        for(int i = 1; i <= n; i++){
            a[i]  = rd.nextInt(900)+100;
        }
        Arrays.sort(a);
        for(Integer b: a){
            System.out.println(b);
        }
    }
}
