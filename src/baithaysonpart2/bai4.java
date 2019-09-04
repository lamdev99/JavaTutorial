package baithaysonpart2;

class StackOfIntegers {
    private int[] elements;
    private int size;

    public StackOfIntegers() {
        size = -1;
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
        //if(!isFull())
            return elements[size];
        //return 0;
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
        StackOfIntegers stackOfIntegers = new StackOfIntegers(3);
        System.out.println(stackOfIntegers.isEmpty());
        for(int i = 1; i < 4; i++){
            stackOfIntegers.push(i);
            System.out.println(stackOfIntegers.isFull());
        }
        System.out.println(stackOfIntegers.peak());
        stackOfIntegers.pop();
        while (!stackOfIntegers.isEmpty()){
            System.out.println(stackOfIntegers.peak());
            stackOfIntegers.pop();
        }
    }
}
