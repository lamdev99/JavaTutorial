package baitapthayson;

public class bai12 {
    public static void main(String[] args) {
        for(int i = 100; i <= 999; i++){
            System.out.print(i);
            String s = String.valueOf(i);
            StringBuilder stringBuilder = new StringBuilder(s);
            System.out.print(stringBuilder.reverse());
            System.out.println();
        }
    }
}
