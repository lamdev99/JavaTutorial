package Exception;

import java.util.Scanner;


class StringEqualsNull extends  Exception{
    public StringEqualsNull(String s){
        super(s);
    }
}

class ExceptionString{
    public void StringEqualsNullEx(String s) throws StringEqualsNull{
        if(s.length()==0)   throw new StringEqualsNull(s);
    }
}

public class ExceptionEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        System.out.println("Nhap vao ten cua ban");
        while(check==false){
            check = checkString();
        }
    }
    public static boolean checkString(){
        Scanner sc = new Scanner(System.in);
        String s;
        try {
            s = sc.nextLine();
            new ExceptionString().StringEqualsNullEx(s);
            System.out.println("Your name is "+ s);
            return true;
        }catch (StringEqualsNull e){
            System.out.println("Nhap lai ten cua ban");
            return false;
        }
    }
}
