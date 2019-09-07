package baithaysonpart2;

import java.util.Scanner;

class Matrix {
    private float a[][];
    Scanner sc;

    public Matrix() {
        a = new float[4][4];
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                a[i][j] = sc.nextFloat();
            }
        }
    }

    public Matrix(int row, int col) {
        a = new float[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                a[i][j] = sc.nextFloat();
            }
        }
    }

    public Matrix add(Matrix m) {
        Matrix sum = new Matrix(this.a.length, this.a[0].length);
        int n = this.a.length;
        int k = this.a[0].length;
        if (n != m.a.length || k != m.a[0].length) {
            System.out.println("Khong thoa man");
            return sum;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                sum.a[i][j] = this.a[i][j] + m.a[i][j];
            }
        }
        return sum;
    }
    public void output(){
        for(int i = 1; i <= this.a.length; i++){
            for(int j = 1; j <= this.a[0].length; j++){
                System.out.print(this.a[i][j]+" ");
            }
            System.out.println();
        }
    }
}

public class bai12 {
    public static void main(String[] args) {
        Matrix m = new Matrix(3, 3);
        Matrix n = new Matrix();
        Matrix k = new Matrix();
        k = n.add(m);
        k.output();
    }
}
