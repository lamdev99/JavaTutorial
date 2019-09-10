package baithaysonpart2;

import java.util.Scanner;

class StackOfIntegers {
    private int[] elements;
    private int size;

    public StackOfIntegers() {
        size = -1;elements = new int[16];
    }

    public StackOfIntegers(int capacity) {
        size = -1;
        elements = new int[capacity];
    }

    public boolean isEmpty() {
        return size==-1;
    }

    public boolean isFull() {
        try {
            elements[++size] = 1;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Stack is full");
            size--;
            return true;
        }
        size--;
        return false;
    }

    public int peak() {
        return elements[size];
    }

    public void push(int n) {
        try {
            elements[++size] = n;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void pop() {
        size--;
    }

    public int getSize() {
        return size;
    }
}

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StackOfIntegers stackOfIntegers = new StackOfIntegers();
        int i = 2;
        //System.out.println(1);
        while(n>1){
            if(n%i==0){
                stackOfIntegers.push(i);
               // System.out.print(i+" ");
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
