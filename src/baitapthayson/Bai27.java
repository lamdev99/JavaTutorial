package baitapthayson;

public class Bai27 {
    public static void main(String[] args) {
        for(long i = 100000;  i<= 999999; i++){
            String s = String.valueOf(i);
            if(ktraThuanNghich(s)){
                System.out.println(i);
            }
        }
    }
    public static boolean ktraThuanNghich(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        String stringReverse = stringBuilder.reverse().toString();
        return stringReverse.equals(s);
    }
}
