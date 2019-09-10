package baithaysonpart2;

import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StackOfIntegers stackOfIntegers = new StackOfIntegers();
        while(n>0){
            if(n%2==0){
                stackOfIntegers.push(0);
            }
            else{
                stackOfIntegers.push(1);
            }
            n/=2;
        }
        while(!stackOfIntegers.isEmpty()){
            System.out.print(stackOfIntegers.peak());
            stackOfIntegers.pop();
        }
    }
}
