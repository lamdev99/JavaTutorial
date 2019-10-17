package UI;

import InOutJava.Main;

import javax.swing.*;
import java.awt.*;

public class test extends Canvas {
    static JFrame frame;
    final static int xCenter = 200,handS=80,handM=60,handH=40;
    final static int yCenter = 200;
    private static int xS,yS,xH,yH,xM,yM;
    public static void setXYEnd(StillClock st){
        int h = st.getHour();
        int m = st.getMin();
        int s = st.getSec();
        double angle = (h+s/3600+m/60)*(2*Math.PI/12);
        xH = (int) (xCenter+handH * Math.sin(angle));
        yH = (int) (yCenter-handH * Math.cos(angle));
        angle = (m+s/60)*(2*Math.PI/60);
        xM = (int) (xCenter+handM * Math.sin(angle));
        yM = (int) (yCenter-handM * Math.cos(angle));
        angle = s*(2*Math.PI/60);
        xS = (int) (xCenter+handS * Math.sin(angle));
        yS = (int) (yCenter-handS * Math.cos(angle));

    }
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.drawLine(xCenter,yCenter,xH,yH);
        g.setColor(Color.BLACK);
        g.drawLine(xCenter,yCenter,xM,yM);
        g.setColor(Color.BLUE);
        g.drawLine(xCenter,yCenter,xS,yS);
        g.drawOval(100,100,200,200);
    }
    public static void createFrame(){
        frame = new JFrame();
        frame.setSize(500,500);
        StillClock st = new StillClock(4,30,40);
        JLabel label = new JLabel();
        label.setBounds(180,400,150,50);
        label.setText(st.getHour()+" : "+st.getMin()+" : "+st.getSec());
        setXYEnd(st);
        frame.add(label);
        frame.add(new test());
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        createFrame();
    }

}
