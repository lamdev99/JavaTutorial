package baitapthayson;

import java.util.*;

public class Bai33 {
    public static void main(String[] args) {
        Map<Character,Integer> myMap = new HashMap<>();
        myMap.put('I',1);
        myMap.put('V',5);
        myMap.put('X',10);
        myMap.put('L',50);
        myMap.put('C',100);
        myMap.put('D',500);
        myMap.put('M',1000);
        Scanner sc = new Scanner(System.in);
        long result = 0;
        String s = sc.next();
        int i = 0;
        for(i = 0; i < s.length()-1; i++){
            if(myMap.get(s.charAt(i))>=myMap.get(s.charAt(i+1)))    result+=myMap.get(s.charAt(i));
            else{
               // System.out.println(myMap.get(s.charAt(i))+" "+myMap.get(s.charAt(i+1)));
//                System.out.println(i);
                result += myMap.get(s.charAt(i+1))-myMap.get(s.charAt(i));
                i++;
            }
        }
        if(i==s.length()-1)   result += myMap.get(s.charAt(i));
        System.out.println(result);
    }
}
