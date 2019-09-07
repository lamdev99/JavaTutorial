package baitapthayson;

import java.math.BigInteger;
import java.util.Random;

public class Bai28 {
    public static void main(String[] args) {
        Random rd = new Random();
        int numBit1 = 20+rd.nextInt(980);
        BigInteger first= getRandomBigInteger(numBit1);
        //int numBit2 = 20+rd.nextInt(980);
        System.out.println(first);
//        BigInteger second = getRandomBigInteger(numBit2);
//        System.out.println(first+" "+second);
//        System.out.println(first.subtract(second));
//        System.out.println(first.add(second));
    }
    public static BigInteger getRandomBigInteger(int numBit) {
        Random rand = new Random();
        BigInteger result = new BigInteger(numBit, rand); // (2^4-1) = 15 is the maximum value
        return result;
    }
}
