package Exception;

import java.util.Scanner;

class MyException extends  Exception{
    private int ex;

    public MyException(int ex) {
        this.ex = ex;
    }
    public String toString(){
        return "My exception "+ ex;
    }
}

public class ExceptionEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int n = -1;
        while(check){
            try{
                System.out.print("Nhap so diem cua ban: ");
                n = sc.nextInt();
                nhapdiem(n);
                //String.valueOf(n);
                check = false;
            } catch (MyException e){
                System.out.println("Nhap sai");
            }
        }
        System.out.println("So diem cua ban la: "+n);
    }
    public static void nhapdiem(int a) throws MyException{
        if(a>10||a<0){
            throw new MyException(a);
        }
        if(String.valueOf(a).toString().equals("\n")){
            throw  new MyException(a);
        }
    }
}
