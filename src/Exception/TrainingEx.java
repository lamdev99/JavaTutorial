package Exception;

import java.util.Scanner;

class Ex{
    public static int readScore(){
        Scanner sc = new Scanner(System.in);
        int n = 0; boolean check = true;
        while (check) {
                try {
                    String s = sc.nextLine();
                    char c = s.charAt(0);
                    n = Integer.parseInt(s);

                    if (n < 0 || n > 10)
                        throw new ScoreEx();
                    check = false;
                }catch (ScoreEx e) {
                    System.out.println("Nhap diem tu 0 den 10!");
                }catch (NumberFormatException e){
                    System.out.println("Nhap lai diem!");
                }
            }
        return n;
        }
    private static class ScoreEx extends Throwable {
    }
}



public class TrainingEx {
    public static void main(String[] args) {
        int n = Ex.readScore();
        System.out.println(n);
    }
}
