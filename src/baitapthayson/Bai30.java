package baitapthayson;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s," %-/");
        // bo nhung thanh phan thua
        StringBuilder result = new StringBuilder();
        while(stringTokenizer.hasMoreTokens()){
            String s1 = stringTokenizer.nextToken();
            result.append(Character.toUpperCase(s1.charAt(0)));
            for(int i = 1; i < s1.length(); i++){
                result.append(Character.toLowerCase(s1.charAt(i)));
            }
            result.append(" ");
        }
        System.out.println(result);
    }
}
