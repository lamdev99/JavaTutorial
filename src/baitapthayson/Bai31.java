package baitapthayson;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s," ");
        String result = "";
        while(stringTokenizer.hasMoreTokens()){
            String nextToken = stringTokenizer.nextToken();
            if(nextToken.length()>result.length()){
                result = nextToken;
            }
        }
        System.out.println(result+" "+s.indexOf(result));
    }
}
