package baitapthayson;

public class Bai14 {
    public static void main(String[] args) {
        for(int i = 100; i <= 999; i++){
            if(canDevideByTen(i)==true){
                System.out.print(i);
                String s = String.valueOf(i);
                StringBuilder stringBuilder = new StringBuilder(s);
                System.out.print(stringBuilder.reverse());
                System.out.println();
            }
        }
    }
    public static boolean canDevideByTen(int n){
        int sum = 0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        sum*=2;
        if(sum%10==0)   return  true;
        return false;
    }
}
