package baithaysonpart2;

import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StackOfIntegers stackOfIntegers = new StackOfIntegers();
        int i = 2;
        while(n>1){
            if(n%i==0){
                stackOfIntegers.push(i);
                n/=i;
            }
            else{
                i++;
            }
        }
        while(!stackOfIntegers.isEmpty()) {
            System.out.print(stackOfIntegers.peak()+" ");
            stackOfIntegers.pop();
        }
    }
}
