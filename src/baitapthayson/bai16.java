package baitapthayson;

public class bai16 {
    public static void main(String[] args) {
        for(int i = 1000000; i <= 9999999; i++){
            if(checkNumber(i)&&isPrime(i))
                System.out.println(i);
        }
    }
    public static boolean checkNumber(int n){
        int sum =  0;
        while(n>0){
            if(isPrime(n%10)==false)    return false;
            sum += n%10;
            n/=10;
        }
        return (true&&isPrime(sum));
    }
    public static boolean isPrime(int n){
        if(n<2) return false;
        else{
            for(int i = 2; i <= Math.sqrt(n); i++)
                if(n%i==0)  return false;
            return true;
        }
    }
}
