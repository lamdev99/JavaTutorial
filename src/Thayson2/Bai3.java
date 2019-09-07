package Thayson2;
import java.util.Scanner;
class Rectangle{
    private double width;
    private double height;
    private String color;
    Rectangle(){
        width = 1;
        height =1;
    }
    Rectangle(double width, double height, String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public double getWidth(){
        return this.width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getHeight(){
        return this.height;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(){
        this.color = color;
    }

    public double findArea(){
        return (this.width * this.height);
    }
    public double findPerimeter(){
        return (this.width+ this.height)*2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }
}
public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle re = new Rectangle(4, 5, "do");
        System.out.println(re);
        System.out.println(re.findArea());
        System.out.println(re.findPerimeter());
    }
}
