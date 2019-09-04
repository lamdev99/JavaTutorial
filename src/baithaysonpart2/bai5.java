package baithaysonpart2;

class MyPoint {
    private double x, y;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint(MyPoint p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(MyPoint second) {
        return Math.sqrt(Math.pow(this.getX() - second.getX(), 2) + Math.pow(this.getY() - second.getY(), 2));
    }

    public double distance(MyPoint first, MyPoint second) {
        return Math.sqrt(Math.pow(first.getX() - second.getX(), 2) + Math.pow(first.getY() - second.getY(), 2));
    }
}

public class bai5 {
    public static void main(String[] args) {
        MyPoint a = new MyPoint(3,4);
        MyPoint b = new MyPoint(0,0);
        System.out.println(new MyPoint().distance(a,b));
    }
}
