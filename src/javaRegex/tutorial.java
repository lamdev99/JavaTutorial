package javaRegex;

import java.util.Scanner;

public class tutorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        boolean cont = true;
        while(cont){
            System.out.println("Nhap string:");
            s = sc.nextLine();
            if(s.matches("^0\\d{2,3}$")) break;
        }
    }
}
