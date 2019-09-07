package baitapthayson;

import java.lang.reflect.Array;
import java.util.*;

public class Bai21 {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a =  new int[n];
        Random rd = new Random();
        for(int i = 0; i < n; i++){
            a[i]  = rd.nextInt(900)+100;
        }
        Arrays.sort(a);
        for(Integer b: a){
            System.out.print(b+" ");
            set.add(b);
        }
        System.out.println();
        for(Integer b: set){
            System.out.print(b+" ");
        }

    }
}
