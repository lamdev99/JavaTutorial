package baitapthayson;

import java.util.*;

class Compare implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

public class Bai34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s," ");
        List<String> myList = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()){
            myList.add(stringTokenizer.nextToken());
        }
        Collections.sort(myList,new Compare());
        for(String str: myList){
            System.out.println(str);
        }
    }
}
