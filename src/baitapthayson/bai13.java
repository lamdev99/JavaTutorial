package baitapthayson;

import java.util.Scanner;
import java.math.*;
public class bai13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double c = sc.nextDouble();
        double result = 0;
        double T = 1;
        int minus = 1;
        int i = 1;
        while(Math.abs(1/T) > c){
            minus = minus * -1;
            T = T*(i+1)*(i+2);
            i+=2;
            result += minus*1/T;
        }
        System.out.println(result*4);
    }
}
