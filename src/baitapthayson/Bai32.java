package baitapthayson;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai32 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String s = sc.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s," ");
        String[] name = new String[5];
        int i = 0;
        while(stringTokenizer.hasMoreTokens()){
            name[i++] = stringTokenizer.nextToken();
        }
        System.out.println(name[2]+" "+name[0]+" "+name[1]);
    }
}
