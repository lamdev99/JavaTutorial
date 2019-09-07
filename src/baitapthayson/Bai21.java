package baitapthayson;

import java.lang.reflect.Array;
import java.util.*;

public class Bai21 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a =  new int[n];
        Random rd = new Random();
        a[0] = 1;a[1] = 2;a[2] = 1; a[3] = 1; a[4] = 2;
        for(int i = 0; i < n; i++){
        //    a[i]  = ;
            set.add(a[i]);
        }
        Arrays.sort(a);
        for(Integer b: a){
            System.out.print(b+" ");
        }
        System.out.println();
        for(Integer b: set){
            System.out.print(b+" ");
        }

    }
}
